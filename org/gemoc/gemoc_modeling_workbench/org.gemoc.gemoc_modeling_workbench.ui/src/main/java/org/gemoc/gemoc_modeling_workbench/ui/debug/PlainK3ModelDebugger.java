package org.gemoc.gemoc_modeling_workbench.ui.debug;

import java.util.Collection;
import java.util.function.BiPredicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.execution.engine.core.NonDeterministicExecutionEngine;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_modeling_workbench.ui.breakpoint.GemocBreakpoint;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public class PlainK3ModelDebugger extends AbstractGemocDebugger implements IEngineAddon, IGemocDebugger {

	/**
	 * A fake instruction to prevent the stepping return to stop on each event.
	 */
	private static final EObject FAKE_INSTRUCTION = EcorePackage.eINSTANCE;

	/**
	 * The {@link NonDeterministicExecutionEngine} to debug.
	 */
	private final IExecutionEngine engine;

	public PlainK3ModelDebugger(IDSLDebugEventProcessor target, IExecutionEngine engine) {
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
		// TODO generate code to test small/big step
		return false;
	}
	
	@Override
	public void steppingOver(String threadName) {
		// To send notifications, but probably useless
		super.steppingOver(threadName);
		
		// TODO change this, it's simply to do step by step with stepover for now
		addPredicateBreak(new BiPredicate<IExecutionEngine, MSEOccurrence>() {
			@Override
			public boolean test(IExecutionEngine t, MSEOccurrence u) {
				return true;
			}
		});
	}

	
	boolean initFakeStackFrame = false;
	
	@Override
	public void updateData(String threadName, EObject instruction) {
		// TODO display in which bigstep we are in
		if (!initFakeStackFrame) {
			pushStackFrame(threadName, "Fake stack frame", instruction, instruction);
			initFakeStackFrame = true;
		}
			
		
	}

	@Override
	public boolean shouldBreak(EObject instruction) {
		boolean res = false;

		if (instruction instanceof MSEOccurrence) {
			res = shouldBreakMSEOccurence((MSEOccurrence) instruction);
		}

		return res;
	}

	private boolean hasRegularBreakpointTrue(EObject o) {
		return super.shouldBreak(o)
				&& (Boolean.valueOf((String) getBreakpointAttributes(o, GemocBreakpoint.BREAK_ON_LOGICAL_STEP)) || Boolean
						.valueOf((String) getBreakpointAttributes(o, GemocBreakpoint.BREAK_ON_MSE_OCCURRENCE)));

	}

	private boolean shouldBreakMSEOccurence(MSEOccurrence mseOccurrence) {

		if (shouldBreakPredicates(engine, mseOccurrence))
			return true;

		// If still no break yet, we look at regular breakpoints on MSE
		ModelSpecificEvent mse = mseOccurrence.getMse();
		if (hasRegularBreakpointTrue(mse)) {
			return true;
		}

		// If still no break yet, we look at regular breakpoints on MSE's caller
		EObject caller = mseOccurrence.getMse().getCaller();
		if (hasRegularBreakpointTrue(caller)) {
			return true;
		}

		return false;

	}

	@Override
	public EObject getNextInstruction(String threadName, EObject currentInstruction, Stepping stepping) {
		// We always return fakeinstruction to make sure to not stop and to
		// handle everything with shouldBreak
		return FAKE_INSTRUCTION;
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) {
		spawnRunningThread(Thread.currentThread().getName(), engine.getExecutionContext().getResourceModel()
				.getContents().get(0));
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) {
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) {
	}

	@Override
	public void engineStopped(IExecutionEngine engine) {
		if (!isTerminated(Thread.currentThread().getName())) {
			terminated(Thread.currentThread().getName());
		}
	}

	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) {
		if (!control(Thread.currentThread().getName(), logicalStepToApply)) {
			throw new RuntimeException("Debug thread has stopped.");
		}
	}

	@Override
	public void aboutToExecuteMSEOccurrence(IExecutionEngine executionEngine, MSEOccurrence mseOccurrence) {
		if (!control(Thread.currentThread().getName(), mseOccurrence)) {
			throw new RuntimeException("Debug thread has stopped.");
		}
	}

	@Override
	public void terminate() {
		super.terminate();
		engine.stop();
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engineRunnable, RunStatus newStatus) {
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine, LogicalStep logicalStepExecuted) {
	}

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) {
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) {
	}

	@Override
	public boolean validateVariableValue(String threadName, String variableName, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getVariableValue(String threadName, String stackName, String variableName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVariableValue(String threadName, String stackName, String variableName, Object value) {
		// TODO Auto-generated method stub
	}

	@Override
	public void engineAboutToDispose(IExecutionEngine engine) {
	}

}
