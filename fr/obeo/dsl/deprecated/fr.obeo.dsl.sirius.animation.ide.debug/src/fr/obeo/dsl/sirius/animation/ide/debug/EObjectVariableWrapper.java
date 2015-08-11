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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

public class EObjectVariableWrapper extends IDebugElementAnimationAdapter
		implements IVariable {

	public EObjectVariableWrapper(ILaunch launch,
			AnimatorEclipseDebugIntegration factory) {
		super(launch, factory);
	}

	private EObject wrapped;

	public EObject getWrapped() {
		return this.wrapped;
	}

	// public static EObjectVariableWrapper getOrCreate(EObject child) {
	// Iterator<EObjectVariableWrapper> it = Iterators.filter(child
	// .eAdapters().iterator(), EObjectVariableWrapper.class);
	// if (!it.hasNext()) {
	// EObjectVariableWrapper created = new EObjectVariableWrapper(child);
	// child.eAdapters().add(created);
	// return created;
	// }
	// return it.next();
	// }

	private EObject getHost() {
		return (EObject) getTarget();
	}

	public void setValue(String expression) throws DebugException {

	}

	public void setValue(IValue value) throws DebugException {

	}

	public boolean supportsValueModification() {
		return false;
	}

	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	public IValue getValue() throws DebugException {
		return (IValue) factory.adapt(getHost(), IValue.class);
	}

	public String getName() throws DebugException {
		String name = "";
		EObject host = getHost();
		if (host.eContainer() != null && host.eContainingFeature() != null) {
			EStructuralFeature contFeature = host.eContainingFeature();
			if (contFeature.isMany()) {
				List contlist = (List) host.eContainer().eGet(contFeature);
				return "[" + contlist.indexOf(host) + "]";
			} else {
				Object value = host.eContainer().eGet(contFeature);
				if (value != null) {
					Object obj = factory.getLabelFactory().adapt(value,
							IItemLabelProvider.class);
					if (obj instanceof IItemLabelProvider) {
						return ((IItemLabelProvider) obj).getText(getHost());
					}
				}
				return "[0]";
			}
		}
		return name;
	}

	public String getReferenceTypeName() throws DebugException {
		return "";
	}

	public boolean hasValueChanged() throws DebugException {
		return false;
	}

}
