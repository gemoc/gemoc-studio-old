package org.gemoc.gemoc_modeling_workbench.ui.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.trace.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
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
	private final ExecutionEngine engine;

	/**
	 * Tells if the logical step level stack frame is created.
	 */
	private boolean frameCreated;

	/**
	 * Tells if the event level stack frame is created.
	 */
	private boolean stepIntoFrameCreated;

	/**
	 * Tells if we are stepping at the event level.
	 */
	private boolean steppingInto;

	/**
	 * Tells if we are stepping from the event level to the next logical step.
	 */
	private boolean steppingReturn;
	
	public GemocModelDebugger(IDSLDebugEventProcessor target, ExecutionEngine engine) {
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
		return instruction instanceof LogicalStep;
	}

	@Override
	public void updateData(String threadName, EObject instruction) {
		if (!frameCreated) {
			pushStackFrame(threadName, LogicalStepHelper.getLogicalStepName((LogicalStep) instruction), instruction, instruction);
			frameCreated = true;
		} else {
			if (steppingInto) {
				if (!stepIntoFrameCreated) {
					pushStackFrame(threadName, instruction.toString(), instruction, instruction);
					stepIntoFrameCreated = true;
				}
			} else {
				if (stepIntoFrameCreated) {
					popStackFrame(threadName);
					stepIntoFrameCreated = false;
				}
			}
			setCurrentInstruction(threadName, instruction);
		}

		// TODO populate variables...
		// variable(threadName, instruction.eClass().getName(), "instruction",
		// instruction);
	}

	@Override
	public boolean shouldBreak(EObject instruction) {
		boolean res = false;
		if (instruction instanceof LogicalStep) {
			steppingInto = false;
			if (steppingReturn) {
				steppingReturn = false;
				res = true;
			} else {
				for (MSEExecutionContext context : ((LogicalStep) instruction).getEventExecutionContexts())
				{
					res = super.shouldBreak(context.getMse()) 
							|| (context.getMse().getCaller() != null && super.shouldBreak(context.getMse().getCaller()));
					if (res) {
						break;
					}
				}
			}
		} else if (steppingInto) {
			res = instruction != null || super.shouldBreak(instruction);
		}
		return res;
	}

	@Override
	public void steppingInto(String threadName) {
		super.steppingInto(threadName);
		steppingInto = true;
	}

	@Override
	public void steppingReturn(String threadName) {
		super.steppingReturn(threadName);
		steppingReturn = true;
	}

	@Override
	public boolean control(String threadName, EObject instruction) {
		final boolean res;

		if (steppingInto || instruction instanceof LogicalStep) {
			res = super.control(threadName, instruction);
		} else {
			res = !isTerminated();
		}

		return res;
	}

	@Override
	public EObject getNextInstruction(String threadName, EObject currentInstruction, Stepping stepping) {
		final EObject res;
		if (stepping == Stepping.STEP_RETURN) {
			res = FAKE_INSTRUCTION;
		} else {
			res= super.getNextInstruction(threadName, currentInstruction, stepping);
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
	public void aboutToSelectLogicalStep(IExecutionEngine engine) 
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
	public void aboutToExecuteMSE(IExecutionEngine executionEngine, ModelSpecificEvent mse) 
	{
		if (!control(Thread.currentThread().getName(), mse.getSolverEvent()))
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
	public void mseExecuted(IExecutionEngine engine, ModelSpecificEvent mse) 
	{
	}
}
