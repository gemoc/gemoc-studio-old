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

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Thread;

public class IThreadAnimationAdapter extends IDebugElementAnimationAdapter
		implements IThread {

	public IThreadAnimationAdapter(ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory factory) {
		super(launch, factory);
	}

	private boolean suspended = false;

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IThread.class;
	}

	private Thread getHost() {
		return (Thread) getTarget();
	}

	public boolean canResume() {
		return true;
	}

	public boolean canSuspend() {
		return true;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		suspended = false;
		for (IStackFrame sf : getStackFrames()) {
			sf.resume();
		}
	}

	public void suspend() throws DebugException {
		suspended = true;
		for (IStackFrame sf : getStackFrames()) {
			sf.suspend();
		}
	}

	public boolean canStepInto() {
		return true;
	}

	public boolean canStepOver() {
		return true;
	}

	public boolean canStepReturn() {
		return true;
	}

	public boolean isStepping() {
		return getHost().getTopStackFrame().isIsStepping();
	}

	public void stepInto() throws DebugException {
		this.factory.stepIntoViaCommand(getHost());

	}

	public void stepOver() throws DebugException {
		this.factory.stepOverViaCommand(getHost());

	}

	public void stepReturn() throws DebugException {
		this.factory.stepReturnViaCommand(getHost());
	}

	public boolean canTerminate() {
		return true;
	}

	public boolean isTerminated() {
		return getHost().getTopStackFrame() == null;
	}

	public void terminate() throws DebugException {
		getHost().setTopStackFrame(null);
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		IStackFrame[] result = new IStackFrame[getHost().getStackFrames()
				.size()];
		int i = 0;
		for (StackFrame t : getHost().getStackFrames()) {
			result[i] = (IStackFrame) factory.adapt(t, IStackFrame.class);
			i++;
		}
		return result;
	}

	public boolean hasStackFrames() throws DebugException {
		return getHost().getStackFrames().size() > 0;
	}

	public int getPriority() throws DebugException {
		return 0;
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		return (IStackFrame) factory.adapt(getHost().getTopStackFrame(),
				IStackFrame.class);
	}

	public String getName() throws DebugException {
		return getHost().getName();
	}

	public IBreakpoint[] getBreakpoints() {
		return null;
	}

}
