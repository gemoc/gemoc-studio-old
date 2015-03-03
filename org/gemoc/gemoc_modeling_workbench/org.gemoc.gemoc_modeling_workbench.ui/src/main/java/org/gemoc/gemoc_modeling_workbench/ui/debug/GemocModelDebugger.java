package org.gemoc.gemoc_modeling_workbench.ui.debug;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.trace.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_modeling_workbench.ui.breakpoint.GemocBreakpoint;

import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public class GemocModelDebugger extends AbstractDSLDebugger implements IEngineAddon {

	/**
	 * A fake instruction to prevent the stepping return to stop on each event.
	 */
	private static final EObject FAKE_INSTRUCTION = EcorePackage.eINSTANCE;

	/**
	 * The {@link ExecutionEngine} to debug.
	 */
	private final IExecutionEngine engine;

	/**
	 * Tells if the logical step level stack frame is created.
	 */
	private boolean logicalStepFrameCreated;

	/**
	 * Tells if the event level stack frame is created.
	 */
	private boolean mseFrameCreated;

	/**
	 * Tells if we should break at the next {@link LogicalStep}.
	 */
	private boolean breakNextLogicalStep;
	
	public GemocModelDebugger(IDSLDebugEventProcessor target, IExecutionEngine engine) {
		super(target);
		this.engine = engine;
	}

	@Override
	public void start() {
		engine.start();
	}

	@Override
	public void disconnect() {
		return;
	}

	@Override
	public boolean canStepInto(String threadName, EObject instruction) {
		final boolean res;
		
		if (instruction instanceof LogicalStep) {
			boolean hasActionMSE = false;
			for (MSEOccurrence mseOccurence : ((LogicalStep) instruction).getMseOccurrences()) {
				if (mseOccurence.getMse().getAction() != null) {
					hasActionMSE = true;
					break;
				}
			}
			res = hasActionMSE;
		} else {
			res = false;
		}
		
		return res;
	}

	@Override
	public void updateData(String threadName, EObject instruction) {
		if (mseFrameCreated) {
			popStackFrame(threadName);
			mseFrameCreated = false;
		}
		if (logicalStepFrameCreated) {
			popStackFrame(threadName);
			logicalStepFrameCreated = false;
		}
		if (instruction instanceof LogicalStep) {
			pushStackFrame(threadName, LogicalStepHelper.getLogicalStepName((LogicalStep) instruction), instruction, instruction);
			logicalStepFrameCreated = true;
		} else if (instruction instanceof MSEOccurrence) {
			final LogicalStep logicalStep = ((MSEOccurrence) instruction).getLogicalstep();
			pushStackFrame(threadName, LogicalStepHelper.getLogicalStepName(logicalStep), logicalStep, logicalStep);
			logicalStepFrameCreated = true;
			pushStackFrame(threadName, instruction.toString(), instruction, instruction);
			mseFrameCreated = true;				
		}

		// TODO populate variables...
		// variable(threadName, instruction.eClass().getName(), "instruction",
		// instruction);
	}
	
	@Override
	public boolean shouldBreak(EObject instruction) {
		boolean res = false;

		if (instruction instanceof LogicalStep) {
			res = breakNextLogicalStep || shouldBreakLogicalStep((LogicalStep) instruction);
		} else if (instruction instanceof MSEOccurrence) {
			res = shouldBreakMSEOccurence((MSEOccurrence) instruction);
		}

		return res;
	}

	private boolean shouldBreakLogicalStep(LogicalStep logicalStep) {
		final boolean res;
		
		if (super.shouldBreak(logicalStep) && Boolean.valueOf((String)getBreakpointAttributes(logicalStep, GemocBreakpoint.BREAK_ON_LOGICAL_STEP))) {
			res = true;
		} else {
			boolean hasMSEBreak = false;
			for (MSEOccurrence mseOccurrence : logicalStep.getMseOccurrences()) {
				hasMSEBreak = (super.shouldBreak(mseOccurrence.getMse()) && Boolean.valueOf((String)getBreakpointAttributes(mseOccurrence.getMse(), GemocBreakpoint.BREAK_ON_LOGICAL_STEP)));
				hasMSEBreak = hasMSEBreak || (mseOccurrence.getMse().getCaller() != null && super.shouldBreak(mseOccurrence.getMse().getCaller()) && Boolean.valueOf((String)getBreakpointAttributes(mseOccurrence.getMse().getCaller(), GemocBreakpoint.BREAK_ON_LOGICAL_STEP)));
				if (hasMSEBreak) {
					break;
				}
			}
			res = hasMSEBreak;
		}
		
		return res;
	}
	
	private boolean shouldBreakMSEOccurence(MSEOccurrence mseOccurrence) {
		final boolean res;
		
		if ((super.shouldBreak(mseOccurrence.getMse()) && Boolean.valueOf((String)getBreakpointAttributes(mseOccurrence.getMse(), GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE))) || (mseOccurrence.getMse().getCaller() != null && super.shouldBreak(mseOccurrence.getMse().getCaller()) && Boolean.valueOf((String)getBreakpointAttributes(mseOccurrence.getMse().getCaller(), GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE)))) {
			res = true;
		} else {
			LogicalStep locicalStep = mseOccurrence.getLogicalstep();
			res = super.shouldBreak(locicalStep) && Boolean.valueOf((String)getBreakpointAttributes(locicalStep, GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE));
		}
		
		return res;
	}

	@Override
	public EObject getNextInstruction(String threadName, EObject currentInstruction, Stepping stepping) {
		final EObject res;
		if (stepping == Stepping.STEP_RETURN && currentInstruction instanceof MSEOccurrence) {
			res = FAKE_INSTRUCTION;
			breakNextLogicalStep = true;
		} else if (stepping == Stepping.STEP_OVER && currentInstruction instanceof LogicalStep) {
			res = FAKE_INSTRUCTION;
			breakNextLogicalStep = true;
		} else {
			res = super.getNextInstruction(threadName, currentInstruction, stepping);
		}
		return res;
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) 
	{
	}
	
	@Override
	public void engineStarted(IExecutionEngine executionEngine) 
	{
		spawnRunningThread(Thread.currentThread().getName(), engine.getExecutionContext().getResourceModel().getContents().get(0));
	}


	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) 
	{
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) 
	{
	}

	@Override
	public void engineStopped(IExecutionEngine engine) 
	{
		if (!isTerminated(Thread.currentThread().getName())) 
		{
			terminated(Thread.currentThread().getName());
		}
	}

	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
		if (!control(Thread.currentThread().getName(), logicalStepToApply))
		{
			throw new RuntimeException("Debug thread has stopped.");
		}
	}

	@Override
	public void aboutToExecuteMSEOccurrence(IExecutionEngine executionEngine, MSEOccurrence mseOccurrence) 
	{
		if (!control(Thread.currentThread().getName(), mseOccurrence))
		{
			throw new RuntimeException("Debug thread has stopped.");			
		}
	}
	
	@Override
	public void terminate() 
	{
		super.terminate();
		engine.stop();
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engineRunnable, RunStatus newStatus) 
	{
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) 
	{
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted) 
	{
	}

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) 
	{
	}
}
