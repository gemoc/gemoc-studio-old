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
package org.gemoc.mocc.ccslmoc.model.moccml;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;

import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finish Clock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.ccslmoc.model.moccml.FinishClock#getClock <em>Clock</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccPackage#getFinishClock()
 * @model
 * @generated
 */
public interface FinishClock extends AbstractAction {
	/**
	 * Returns the value of the '<em><b>Clock</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clock</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clock</em>' reference.
	 * @see #setClock(BindableEntity)
	 * @see org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccPackage#getFinishClock_Clock()
	 * @model keys="name" required="true"
	 * @generated
	 */
	BindableEntity getClock();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.ccslmoc.model.moccml.FinishClock#getClock <em>Clock</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clock</em>' reference.
	 * @see #getClock()
	 * @generated
	 */
	void setClock(BindableEntity value);

} // FinishClock
