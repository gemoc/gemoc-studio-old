package org.gemoc.gemoc_modeling_workbench.ui.debug;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.AbstractDSLDebugger;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public class GemocModelDebugger extends AbstractDSLDebugger implements IEngineHook {

	/**
	 * A fake instruction to prevent the stepping return to stop on each event.
	 */
	private static final EObject FAKE_INSTRUCTION = EcorePackage.eINSTANCE;

	/**
	 * The {@link ObservableBasicExecutionEngine} to debug.
	 */
	private final ObservableBasicExecutionEngine engine;

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
	
	public GemocModelDebugger(IDSLDebugEventProcessor target, ObservableBasicExecutionEngine engine) {
		super(target);
		this.engine = engine;
	}

	@Override
	public void start() {
		engine.start();
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub

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
				for (Event event : LogicalStepHelper.getTickedEvents((LogicalStep) instruction)) {
					if (event.getReferencedObjectRefs().size() != 0) {
						res = super.shouldBreak(event.getReferencedObjectRefs().get(0));
						if (res) {
							break;
						}
					}
				}
			}
		} else if (steppingInto) {
			res = super.shouldBreak(instruction);
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
	public void preLogicalStepSelection(IExecutionEngine engine) 
	{
	}

	@Override
	public void postLogicalStepSelection(IExecutionEngine engine) 
	{
	}

	@Override
	public void postStopEngine(IExecutionEngine engine) 
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
		if (!control(Thread.currentThread().getName(), mse.getCaller()))
		{
			throw new RuntimeException("Debug thread has stopped.");			
		}
	}
	
}
