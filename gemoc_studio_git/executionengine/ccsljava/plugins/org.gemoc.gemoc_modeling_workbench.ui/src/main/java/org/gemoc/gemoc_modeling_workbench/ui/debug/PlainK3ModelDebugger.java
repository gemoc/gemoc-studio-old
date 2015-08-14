package org.gemoc.gemoc_modeling_workbench.ui.debug;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiPredicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.engine.dse.NonDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IStackListener;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_modeling_workbench.ui.breakpoint.GemocBreakpoint;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;

public class PlainK3ModelDebugger extends AbstractGemocDebugger implements IEngineAddon, IGemocDebugger, IStackListener {

	/**
	 * A fake instruction to prevent the stepping return to stop on each event.
	 */
	private static final EObject FAKE_INSTRUCTION = EcorePackage.eINSTANCE;

	/**
	 * The {@link NonDeterministicExecutionEngine} to debug.
	 */
	private final IDeterministicExecutionEngine engine;

	public PlainK3ModelDebugger(IDSLDebugEventProcessor target, IDeterministicExecutionEngine engine) {
		super(target);
		this.engine = engine;
		engine.addStackListener(this);
	}

	@Override
	/*
	 * This method is eventually called within a new engine thread.
	 * (non-Javadoc)
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#start()
	 */
	public void start() {
		engine.start();
	}

	@Override
	public void disconnect() {
		return;
	}

	@Override
	/*
	 * For this debugger, instructions should only be MSEOcurrences
	 * (non-Javadoc)
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#canStepInto(java.lang.String,
	 * org.eclipse.emf.ecore.EObject)
	 */
	public boolean canStepInto(String threadName, EObject instruction) {
		// TODO generate code to test small/big step
		return true;
	}

	@Override
	public void steppingOver(String threadName) {
		// To send notifications, but probably useless
		super.steppingOver(threadName);

		// We add a future break as soon as the step is over
		addPredicateBreak(new BiPredicate<IExecutionEngine, MSEOccurrence>() {

			// The operation we want to step over
			private MSEOccurrence steppedOver = engine.getCurrentMSEOccurrence();

			@Override
			public boolean test(IExecutionEngine t, MSEOccurrence u) {
				// We finished stepping over once the mseoccurrence is not there
				// anymore
				return !engine.getCurrentStack().contains(steppedOver);
			}
		});
	}

	@Override
	public void steppingInto(String threadName) {
		// To send notifications, but probably useless
		super.steppingInto(threadName);

		// We add a future break asap
		addPredicateBreak(new BiPredicate<IExecutionEngine, MSEOccurrence>() {
			@Override
			public boolean test(IExecutionEngine t, MSEOccurrence u) {
				// We finished stepping as soon as we encounter a new step
				return true;
			}
		});

	}

	boolean initFakeStackFrame = false;
	String threadName = "a6tIIuOOz8Ir1ppWaAxAtKKoH";

	@Override
	/*
	 * This operation is called lots of time to update the stackframe view. We
	 * have to call "pushStackFrame" and "popStackFrame" to construct the
	 * stackframe.
	 * 
	 * TODO When using "pushStackFrame", we give the big step MSEOcc as
	 * the context, and the small step MSEOcc as the currentInstruction
	 * (non-Javadoc)
	 * 
	 * @see fr.obeo.dsl.debug.ide.IDSLDebugger#updateData(java.lang.String,
	 * org.eclipse.emf.ecore.EObject)
	 */
	public void updateData(String threadName, EObject instruction) {
 
		// This initial frame will in ANY case display the root element of the model, because the first context is the one of the Thread, which is the root
		if (!initFakeStackFrame) {
			pushStackFrame(threadName, "Root frame", instruction, instruction);
			initFakeStackFrame = true;
			this.threadName = threadName;
		}

		for (ToPushPop m : toPushPop) {
			if (m.push) {
				pushStackFrame(threadName, m.mseOccurrence.getMse().getName(), m.mseOccurrence, m.mseOccurrence);
			} else {
				popStackFrame(threadName);
			}
		}

		toPushPop.clear();

	}

	@Override
	public boolean shouldBreak(EObject instruction) {
		if (instruction instanceof MSEOccurrence) {
			return shouldBreakMSEOccurence((MSEOccurrence) instruction);
		}
		return false;
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
	public void engineStarted(IExecutionEngine executionEngine) {
		spawnRunningThread(Thread.currentThread().getName(), engine.getExecutionContext().getResourceModel()
				.getContents().get(0));
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

	private static class ToPushPop {
		public MSEOccurrence mseOccurrence;
		public boolean push;

		ToPushPop(MSEOccurrence mseOccurrence, boolean push) {
			this.mseOccurrence = mseOccurrence;
			this.push = push;
		}
	}

	List<ToPushPop> toPushPop = new ArrayList<>();

	@Override
	public void notifyPushMSEOccurrence(MSEOccurrence mseOccurrence) {
		ToPushPop aaa = new ToPushPop(mseOccurrence, true);
		toPushPop.add(aaa);
	}

	@Override
	public void notifyPopMSEOccurrence(MSEOccurrence mseOccurrence) {
		ToPushPop aaa = new ToPushPop(mseOccurrence, false);
		toPushPop.add(aaa);
	}

	/* --------------------------------------------------------- */
	/* We don't care about all the remaining addon notifications */
	/* --------------------------------------------------------- */

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) {
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) {
	}

	@Override
	public void engineAboutToDispose(IExecutionEngine engine) {
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) {
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) {
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

}
