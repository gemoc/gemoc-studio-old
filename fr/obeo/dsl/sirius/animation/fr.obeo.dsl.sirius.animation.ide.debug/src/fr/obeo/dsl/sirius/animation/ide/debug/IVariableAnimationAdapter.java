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
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.common.notify.Notification;

import fr.obeo.dsl.sirius.animation.Variable;

public class IVariableAnimationAdapter extends IDebugElementAnimationAdapter
		implements IVariable {

	private boolean hasChanged = false;

	public IVariableAnimationAdapter(ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory factory) {
		super(launch, factory);
	}

	private Variable getHost() {
		return (Variable) getTarget();
	}

	@Override
	public void notifyChanged(Notification msg) {
		super.notifyChanged(msg);
		if (!msg.isTouch()) {
			hasChanged = true;
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IVariable.class;
	}

	public void setValue(String expression) throws DebugException {
		// TODO Auto-generated method stub

	}

	public void setValue(IValue value) throws DebugException {
		// TODO Auto-generated method stub

	}

	public boolean supportsValueModification() {
		return false;
	}

	public boolean verifyValue(String expression) throws DebugException {
		return true;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	public IValue getValue() throws DebugException {
		return (IValue) factory.adapt(getHost().getElements(),
				IValue.class);
	}

	public String getName() throws DebugException {
		return getHost().getName();
	}

	public String getReferenceTypeName() throws DebugException {
		return getHost().eClass().getName();
	}

	public boolean hasValueChanged() throws DebugException {
		return hasChanged;
	}

	public void reinitChangeCounter() {
		hasChanged = false;

	}

}
