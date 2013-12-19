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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CCSL Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#getCCSLGuard()
 * @model
 * @generated
 */
public interface CCSLGuard extends Guard {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(BooleanExpression)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage#getCCSLGuard_Value()
	 * @model
	 * @generated
	 */
	BooleanExpression getValue();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLGuard#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BooleanExpression value);

} // CCSLGuard
