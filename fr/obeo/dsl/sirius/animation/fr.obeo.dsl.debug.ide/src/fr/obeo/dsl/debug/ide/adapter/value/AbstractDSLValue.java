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
package fr.obeo.dsl.debug.ide.adapter.value;

import fr.obeo.dsl.debug.ide.DSLEclipseDebugIntegration;
import fr.obeo.dsl.debug.ide.adapter.AbstractDSLDebugElementAdapter;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * A <code>null</code> {@link IValue value}.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public abstract class AbstractDSLValue extends AbstractDSLDebugElementAdapter implements IValue {

	/**
	 * Empty {@link IVariable variables}.
	 */
	public static final IVariable[] EMPTY = new IVariable[0];

	/**
	 * The reference type name.
	 */
	private final String referenceTypeName;

	/**
	 * Constructor.
	 * 
	 * @param factory
	 *            the {@link DSLEclipseDebugIntegration} factory
	 * @param referenceTypeName
	 *            the reference type name
	 */
	public AbstractDSLValue(DSLEclipseDebugIntegration factory, String referenceTypeName) {
		super(factory);
		this.referenceTypeName = referenceTypeName;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValue#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return referenceTypeName;
	}

}
