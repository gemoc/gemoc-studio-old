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

import fr.obeo.dsl.debug.Variable;
import fr.obeo.dsl.debug.ide.DSLEclipseDebugIntegration;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

/**
 * The {@link Variable} DSL debug model.
 * 
 * @author <a href="mailto:yvan.lussaud@obeo.fr">Yvan Lussaud</a>
 */
public class DSLVariableAdapter extends AbstractDSLDebugElementAdapter implements IVariable {

	/**
	 * Constructor.
	 * 
	 * @param factory
	 *            the {@link DSLEclipseDebugIntegration} factory
	 */
	public DSLVariableAdapter(DSLEclipseDebugIntegration factory) {
		super(factory);
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return super.isAdapterForType(type) || type == IVariable.class;
	}

	/**
	 * Gets the {@link Variable}.
	 * 
	 * @return the {@link Variable}
	 */
	protected Variable getHost() {
		assert target instanceof Variable;
		return (Variable)target;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(java.lang.String)
	 */
	public void setValue(String expression) throws DebugException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValueModification#setValue(org.eclipse.debug.core.model.IValue)
	 */
	public void setValue(IValue value) throws DebugException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValueModification#supportsValueModification()
	 */
	public boolean supportsValueModification() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(java.lang.String)
	 */
	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IValueModification#verifyValue(org.eclipse.debug.core.model.IValue)
	 */
	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IVariable#getValue()
	 */
	public IValue getValue() throws DebugException {
		return (IValue)factory.getValue(getHost().getDeclarationType(), getHost().getValue());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IVariable#getName()
	 */
	public String getName() throws DebugException {
		return getHost().getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IVariable#getReferenceTypeName()
	 */
	public String getReferenceTypeName() throws DebugException {
		return getHost().getDeclarationType();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.debug.core.model.IVariable#hasValueChanged()
	 */
	public boolean hasValueChanged() throws DebugException {
		return getHost().isValueChanged();
	}

}
