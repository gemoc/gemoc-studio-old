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
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.Variable;

public class IStackFrameAnimationAdapter extends IDebugElementAnimationAdapter
		implements IStackFrame {

	public IStackFrameAnimationAdapter(ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory factory) {
		super(launch, factory);
	}

	public StackFrame getHost() {
		return (StackFrame) getTarget();
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
		return getHost().isIsStepping();
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

	public boolean canResume() {
		return true;
	}

	public boolean canSuspend() {
		return true;
	}

	public boolean isSuspended() {
		return false;
	}

	public void resume() throws DebugException {

	}

	public void suspend() throws DebugException {
		/*
		 * let's reinit all our variable adapters.
		 */
		for (IVariable var : getVariables()) {
			if (var instanceof IVariableAnimationAdapter)
				((IVariableAnimationAdapter) var).reinitChangeCounter();
		}

	}

	public boolean canTerminate() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	public void terminate() throws DebugException {
		// TODO Auto-generated method stub

	}

	public IThread getThread() {
		return (IThread) factory.adapt(getHost().getParent(), IThread.class);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IThread.class;
	}

	public IVariable[] getVariables() throws DebugException {
		IVariable[] result = new IVariable[getHost().getVariables().size()];
		int i = 0;
		for (Variable v : getHost().getVariables()) {
			result[i] = (IVariable) factory.adapt(v, IVariable.class);
			i++;
		}
		return result;
	}

	public boolean hasVariables() throws DebugException {
		return getHost().getVariables().size() > 0;
	}

	public int getLineNumber() throws DebugException {
		return 0;
	}

	public int getCharStart() throws DebugException {
		return 0;
	}

	public int getCharEnd() throws DebugException {
		return 0;
	}

	public String getName() throws DebugException {
		return getHost().getName();
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[0];
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

}
