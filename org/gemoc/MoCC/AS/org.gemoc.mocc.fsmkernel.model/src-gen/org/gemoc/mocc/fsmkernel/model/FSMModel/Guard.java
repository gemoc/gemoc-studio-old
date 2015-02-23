/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.fsmkernel.model.FSMModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Guard#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends AbstractGuard {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(BooleanExpression)
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getGuard_Value()
	 * @model containment="true" keys="name" required="true"
	 * @generated
	 */
	BooleanExpression getValue();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Guard#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BooleanExpression value);

} // Guard
