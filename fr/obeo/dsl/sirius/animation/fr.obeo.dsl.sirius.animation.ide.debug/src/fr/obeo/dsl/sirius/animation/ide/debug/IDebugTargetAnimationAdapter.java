/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.ide.debug;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;

import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.TargetState;

public class IDebugTargetAnimationAdapter extends IDebugElementAnimationAdapter implements
		IDebugTarget {

	public IDebugTargetAnimationAdapter(
			ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory debugModelToEclipseDebugAdapterFactory) {
		super(launch, debugModelToEclipseDebugAdapterFactory);
	}

	private AnimationTarget getHost() {
		return (AnimationTarget) getTarget();
	}


	public boolean canTerminate() {
		return true;
	}

	public boolean isTerminated() {
		return getHost().getState() == TargetState.TERMINATED;
	}

	public void terminate() throws DebugException {
		factory.terminateViaCommand(getHost());
	}

	public boolean canResume() {
		return true;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IDebugTarget.class;
	}
	
	
	public boolean canSuspend() {
		return true;
	}

	public boolean isSuspended() {
		return getHost().getState() == TargetState.SUSPENDED;
	}

	public void resume() throws DebugException {
		factory.resumeViaCommand(getHost());
	}

	public void suspend() throws DebugException {
		factory.suspendViaCommand(getHost());

	}

	public boolean canDisconnect() {
		return true;
	}

	public void disconnect() throws DebugException {
		factory.disconnectViaCommand(getHost());

	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

	public IProcess getProcess() {
		return null;
	}

	public IThread[] getThreads() throws DebugException {
		IThread[] result = new IThread[getHost().getThreads().size()];
		int i = 0;
		for (fr.obeo.dsl.sirius.animation.Thread t : getHost().getThreads()) {
			result[i] = (IThread) factory.adapt(t, IThread.class);
			i++;
		}
		return result;
	}

	public boolean hasThreads() throws DebugException {
		return getThreads() != null && getThreads().length > 0;
	}

	public String getName() throws DebugException {
		return getHost().getName();
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return false;
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		// not supported
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		// not supported

	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		// not supported

	}

}
