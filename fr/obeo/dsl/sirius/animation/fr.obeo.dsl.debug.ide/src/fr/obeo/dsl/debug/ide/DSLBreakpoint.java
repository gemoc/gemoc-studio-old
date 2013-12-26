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
package fr.obeo.dsl.debug.ide;

import fr.obeo.dsl.debug.ide.adapter.DSLDebugTargetAdapter;

import org.eclipse.debug.core.model.Breakpoint;
import org.eclipse.emf.ecore.EObject;

/**
 * A breakpoint for DSL models.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLBreakpoint extends Breakpoint {

	/**
	 * The {@link EObject} representing the instruction.
	 */
	protected final EObject eObject;

	/**
	 * Constructor.
	 * 
	 * @param eObject
	 *            the {@link EObject} representing the instruction
	 */
	public DSLBreakpoint(EObject eObject) {
		this.eObject = eObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IBreakpoint#getModelIdentifier()
	 */
	public String getModelIdentifier() {
		return DSLDebugTargetAdapter.REPRESENTATION_ID;
	}

	/**
	 * Gets the {@link EObject} representing the instruction.
	 * 
	 * @return the {@link EObject} representing the instruction
	 */
	public EObject getEObject() {
		return eObject;
	}

}
