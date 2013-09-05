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

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.Iterables;

public class IValueEListAdapter extends IDebugElementAnimationAdapter implements
		IValue {

	private Object host;

	public IValueEListAdapter(ILaunch launch,
			AnimatorEclipseDebugIntegration factory, Object object) {
		super(launch, factory);
		this.host = object;
	}

	public String getReferenceTypeName() throws DebugException {
		return this.host.getClass().getName();
	}

	public String getValueString() throws DebugException {
		if (this.host instanceof List) {
			return "["+ ((List) this.host).size() +"]";
		} else if (this.host != null) {
			return this.host.toString();
		}
		return "";
	}

	public boolean isAllocated() throws DebugException {
		return true;
	}

	public IVariable[] getVariables() throws DebugException {
		if (this.host instanceof List) {
			List hostList = (List) this.host;
			IVariable[] result = new IVariable[hostList.size()];
			int i = 0;
			int nb = hostList.size();
			for (EObject child : Iterables.filter(hostList, EObject.class)) {
				result[i] = (IVariable) factory
						.adaptToEObjectVariableWrapper(child);
				i++;
			}
			return result;
		} else {
			return new IVariable[0];
		}

	}

	public boolean hasVariables() throws DebugException {
		if (this.host instanceof List) {
			return ((List) this.host).size() > 0;
		}
		return false;
	}

}
