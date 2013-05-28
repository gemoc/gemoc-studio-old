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

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import fr.obeo.dsl.sirius.animation.AnimationTarget;

public class IDebugElementAnimationAdapter extends AdapterImpl implements
		IDebugElement {
	protected ILaunch launch;

	protected DebugModelToEclipseDebugAdapterFactory factory;

	public IDebugElementAnimationAdapter(ILaunch launch,
			DebugModelToEclipseDebugAdapterFactory factory) {
		super();
		this.launch = launch;
		this.factory = factory;
	}

	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == factory || type == IDebugElement.class;
	}

	public String getModelIdentifier() {		
		return "fr.obeo.dsl.sirius.modelAnimation";
	}

	public IDebugTarget getDebugTarget() {
		return (IDebugTarget) factory.adapt(findParentTarget(),
				IDebugTarget.class);
	}

	protected AnimationTarget findParentTarget() {
		AnimationTarget parentTarget = null;
		EObject start = null;
		if (getTarget() instanceof EObject) {
			start = (EObject) getTarget();
		} else if (getTarget() instanceof SettingWrapper) {
			start = ((SettingWrapper) getTarget()).getWrapped().getEObject();
		}
		if (start != null) {
			EObject cur = start;
			while (cur != null) {
				if (cur instanceof AnimationTarget) {
					parentTarget = (AnimationTarget) cur;
				}
				cur = cur.eContainer();
			}
		}
		return parentTarget;
	}

	public ILaunch getLaunch() {
		return this.launch;
	}

}
