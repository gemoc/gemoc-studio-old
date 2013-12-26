/*******************************************************************************
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 *
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 *
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 *
 *******************************************************************************/
package fr.obeo.dsl.debug.ide.adapter;

import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.DebugTargetState;
import fr.obeo.dsl.debug.DebugTargetUtils;
import fr.obeo.dsl.debug.Thread;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.DSLEclipseDebugIntegration;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEvent;
import fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor;
import fr.obeo.dsl.debug.ide.event.debugger.BreakpointReply;
import fr.obeo.dsl.debug.ide.event.debugger.DeleteVariableReply;
import fr.obeo.dsl.debug.ide.event.debugger.PopStackFrameReply;
import fr.obeo.dsl.debug.ide.event.debugger.PushStackFrameReply;
import fr.obeo.dsl.debug.ide.event.debugger.ResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.SetCurrentInstructionReply;
import fr.obeo.dsl.debug.ide.event.debugger.SpawnRunningThreadReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepIntoResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepOverResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.StepReturnResumingReply;
import fr.obeo.dsl.debug.ide.event.debugger.SteppedReply;
import fr.obeo.dsl.debug.ide.event.debugger.SuspendedReply;
import fr.obeo.dsl.debug.ide.event.debugger.TerminatedReply;
import fr.obeo.dsl.debug.ide.event.debugger.VariableReply;
import fr.obeo.dsl.debug.ide.event.model.DisconnectRequest;
import fr.obeo.dsl.debug.ide.event.model.ResumeRequest;
import fr.obeo.dsl.debug.ide.event.model.StartRequest;
import fr.obeo.dsl.debug.ide.event.model.SuspendRequest;
import fr.obeo.dsl.debug.ide.event.model.TerminateRequest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;

/**
 * The {@link DebugTarget} DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLDebugTargetAdapter extends AbstractDSLDebugElementAdapter implements IDebugTarget, IDSLDebugEventProcessor {

	/**
	 * Constructor.
	 * 
	 * @param factory
	 *            the {@link DSLEclipseDebugIntegration} factory
	 */
	public DSLDebugTargetAdapter(DSLEclipseDebugIntegration factory) {
		super(factory);
		// register as a breakpoint listener
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);

		// add current break points
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(
				getModelIdentifier());
		for (IBreakpoint breakpoint : breakpoints) {
			breakpointAdded(breakpoint);
		}
	}

	/**
	 * Starts the debugger with a {@link StartRequest}.
	 */
	public void start() {
		factory.getDebugger().handleEvent(new StartRequest());
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == IDebugTarget.class || super.isAdapterForType(type);
	}

	/**
	 * Gets the {@link DebugTarget}.
	 * 
	 * @return the {@link DebugTarget}
	 */
	protected DebugTarget getHost() {
		assert target instanceof DebugTarget;
		return (DebugTarget)target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#canTerminate()
	 */
	public boolean canTerminate() {
		return DebugTargetUtils.canTerminate(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#isTerminated()
	 */
	public boolean isTerminated() {
		return DebugTargetUtils.isTerminated(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ITerminate#terminate()
	 */
	public void terminate() throws DebugException {
		factory.getModelUpdater().terminateRequest(getHost());
		factory.getDebugger().handleEvent(new TerminateRequest());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canResume()
	 */
	public boolean canResume() {
		return DebugTargetUtils.canResume(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#canSuspend()
	 */
	public boolean canSuspend() {
		return DebugTargetUtils.canSuspend(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#isSuspended()
	 */
	public boolean isSuspended() {
		return DebugTargetUtils.isSuspended(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#resume()
	 */
	public void resume() throws DebugException {
		factory.getDebugger().handleEvent(new ResumeRequest());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.ISuspendResume#suspend()
	 */
	public void suspend() throws DebugException {
		factory.getDebugger().handleEvent(new SuspendRequest());
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		// TODO Auto-generated method stub

	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#canDisconnect()
	 */
	public boolean canDisconnect() {
		return DebugTargetUtils.canDisconnect(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#disconnect()
	 */
	public void disconnect() throws DebugException {
		factory.getDebugger().handleEvent(new DisconnectRequest());
		factory.getModelUpdater().disconnectRequest(getHost());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDisconnect#isDisconnected()
	 */
	public boolean isDisconnected() {
		return getHost().getState() == DebugTargetState.DISCONNECTED;
	}

	public boolean supportsStorageRetrieval() {
		// TODO Auto-generated method stub
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	public IProcess getProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getThreads()
	 */
	public IThread[] getThreads() throws DebugException {
		final List<IThread> res = new ArrayList<IThread>();

		for (Thread thread : getHost().getThreads()) {
			res.add(factory.getThread(thread));
		}

		return res.toArray(new IThread[res.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#hasThreads()
	 */
	public boolean hasThreads() throws DebugException {
		return getHost().getThreads().size() > 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#getName()
	 */
	public String getName() throws DebugException {
		return getHost().getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IDebugTarget#supportsBreakpoint(org.eclipse.debug.core.model.IBreakpoint)
	 */
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint instanceof DSLBreakpoint && ((DSLBreakpoint)breakpoint).getEObject() != null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.obeo.dsl.debug.ide.event.IDSLDebugEventProcessor#handleEvent(fr.obeo.dsl.debug.ide.event.IDSLDebugEvent)
	 */
	public void handleEvent(IDSLDebugEvent event) {
		if (event instanceof SuspendedReply) {
			handleSuspendReply((SuspendedReply)event);
		} else if (event instanceof TerminatedReply) {
			handleTerminatedReply((TerminatedReply)event);
		} else if (event instanceof SpawnRunningThreadReply) {
			handleSpawnRunningThreadReply((SpawnRunningThreadReply)event);
		} else if (event instanceof ResumingReply) {
			handleResumingReply((ResumingReply)event);
		} else if (event instanceof VariableReply) {
			handleVariableReply((VariableReply)event);
		} else if (event instanceof DeleteVariableReply) {
			handleDeleteVariableReply((DeleteVariableReply)event);
		} else if (event instanceof PushStackFrameReply) {
			handlePushStackFrameReply((PushStackFrameReply)event);
		} else if (event instanceof PopStackFrameReply) {
			handlePopStackFrameReply((PopStackFrameReply)event);
		} else if (event instanceof SetCurrentInstructionReply) {
			handleSetCurrentInstructionReply((SetCurrentInstructionReply)event);
		}
	}

	/**
	 * Handles the given {@link SetCurrentInstructionReply}.
	 * 
	 * @param setCurrentInstructionReply
	 *            the {@link SetCurrentInstructionReply}.
	 */
	private void handleSetCurrentInstructionReply(SetCurrentInstructionReply setCurrentInstructionReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), setCurrentInstructionReply
				.getThreadName());
		// EMF model change
		factory.getModelUpdater().setCurrentInstructionReply(eThread,
				setCurrentInstructionReply.getInstruction(), setCurrentInstructionReply.isCanStepInto());
		// Eclipse change
		factory.getThread(eThread).fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link PopStackFrameReply}.
	 * 
	 * @param popStackFrameReply
	 *            the {@link PopStackFrameReply}
	 */
	private void handlePopStackFrameReply(PopStackFrameReply popStackFrameReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), popStackFrameReply.getThreadName());
		// EMF model change
		factory.getModelUpdater().popStackFrameReply(eThread);
		// Eclipse change
		factory.getThread(eThread).fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link PushStackFrameReply}.
	 * 
	 * @param pushStackFrameReply
	 *            the {@link PushStackFrameReply}
	 */
	private void handlePushStackFrameReply(PushStackFrameReply pushStackFrameReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), pushStackFrameReply.getThreadName());
		// EMF model change
		factory.getModelUpdater().pushStackFrameReply(eThread, pushStackFrameReply.getName(),
				pushStackFrameReply.getContext(), pushStackFrameReply.getCurrentInstruction(),
				pushStackFrameReply.isCanStepInto());
		// Eclipse change
		factory.getThread(eThread).fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link DeleteVariableReply}.
	 * 
	 * @param deleteVariableReply
	 *            the {@link DeleteVariableReply}
	 */
	private void handleDeleteVariableReply(DeleteVariableReply deleteVariableReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), deleteVariableReply.getThreadName());
		// EMF model change
		factory.getModelUpdater().deleteVariableReply(eThread, deleteVariableReply.getName());
		// Eclipse change
		factory.getThread(eThread).fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link VariableReply}.
	 * 
	 * @param variableReply
	 *            the {@link VariableReply}
	 */
	private void handleVariableReply(VariableReply variableReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), variableReply.getThreadName());
		// EMF model change
		factory.getModelUpdater().setVariableReply(eThread, variableReply.getDeclarationTypeName(),
				variableReply.getName(), variableReply.getValue());
		// Eclipse change
		factory.getThread(eThread).fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link ResumingReply}.
	 * 
	 * @param resumingReply
	 *            the {@link ResumingReply}
	 */
	private void handleResumingReply(ResumingReply resumingReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), resumingReply.getThreadName());
		if (resumingReply instanceof StepIntoResumingReply) {
			// EMF model change
			factory.getModelUpdater().stepIntoReply(eThread);
			// Eclipse change
			factory.getThread(eThread).fireResumeEvent(DebugEvent.STEP_INTO);
		} else if (resumingReply instanceof StepOverResumingReply) {
			// EMF model change
			factory.getModelUpdater().stepOverReply(eThread);
			// Eclipse change
			factory.getThread(eThread).fireResumeEvent(DebugEvent.STEP_OVER);
		} else if (resumingReply instanceof StepReturnResumingReply) {
			// EMF model change
			factory.getModelUpdater().stepReturnReply(eThread);
			// Eclipse change
			factory.getThread(eThread).fireResumeEvent(DebugEvent.STEP_RETURN);
		} else {
			// EMF model change
			factory.getModelUpdater().resumedReply(eThread);
			// Eclipse change
			factory.getThread(eThread).fireResumeEvent(DebugEvent.CLIENT_REQUEST);
		}
	}

	/**
	 * Handles the given {@link SpawnRunningThreadReply}.
	 * 
	 * @param spawnThreadReply
	 *            the {@link SpawnRunningThreadReply}
	 */
	private void handleSpawnRunningThreadReply(SpawnRunningThreadReply spawnThreadReply) {
		// EMF model change
		factory.getModelUpdater().spawnRunningThreadReply(getHost(), spawnThreadReply.getThreadName(),
				spawnThreadReply.getContext());
		// Eclipse change
		fireChangeEvent(DebugEvent.CONTENT);
	}

	/**
	 * Handles the given {@link TerminatedReply}.
	 * 
	 * @param terminatedReply
	 *            the {@link TerminatedReply}
	 */
	private void handleTerminatedReply(TerminatedReply terminatedReply) {
		final String threadName = terminatedReply.getThreadName();
		if (threadName == null) {
			// EMF model change
			factory.getModelUpdater().terminatedReply(getHost());
			// unregister as a breakpoint listener
			DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
			// Eclipse change
			fireTerminateEvent();
		} else {
			// EMF model change
			Thread eThread = DebugTargetUtils.getThread(getHost(), threadName);
			factory.getModelUpdater().terminatedReply(eThread);
			// Eclipse change
			DSLThreadAdapter thread = factory.getThread(eThread);
			thread.fireTerminateEvent();
		}
	}

	/**
	 * Handles the given {@link SuspendedReply}.
	 * 
	 * @param suspendReply
	 *            the {@link SuspendedReply}
	 */
	private void handleSuspendReply(SuspendedReply suspendReply) {
		final Thread eThread = DebugTargetUtils.getThread(getHost(), suspendReply.getThreadName());
		final DSLThreadAdapter thread = factory.getThread(eThread);

		// EMF model change
		factory.getModelUpdater().suspendedReply(eThread);
		// Eclipse change
		if (suspendReply instanceof SteppedReply) {
			thread.fireSuspendEvent(DebugEvent.STEP_END);
		} else if (suspendReply instanceof BreakpointReply) {
			thread.fireSuspendEvent(DebugEvent.BREAKPOINT);
		} else {
			thread.fireSuspendEvent(DebugEvent.CLIENT_REQUEST);
		}
		factory.getDebugTarget(eThread.getDebugTarget()).fireChangeEvent(DebugEvent.STATE);
	}

}
