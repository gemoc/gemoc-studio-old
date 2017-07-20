/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
/**
 */
package org.gemoc.sample.tfsm.concurrent.tfsm;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.concurrent.tfsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}</li>
 * </ul>
 *
 * @see org.gemoc.sample.tfsm.concurrent.tfsm.TfsmPackage#getEventGuard()
 * @model
 * @generated
 */
public interface EventGuard extends Guard {
	/**
	 * Returns the value of the '<em><b>Triggering Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggering Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggering Event</em>' reference.
	 * @see #setTriggeringEvent(FSMEvent)
	 * @see org.gemoc.sample.tfsm.concurrent.tfsm.TfsmPackage#getEventGuard_TriggeringEvent()
	 * @model required="true"
	 * @generated
	 */
	FSMEvent getTriggeringEvent();

	/**
	 * Sets the value of the '{@link org.gemoc.sample.tfsm.concurrent.tfsm.EventGuard#getTriggeringEvent <em>Triggering Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triggering Event</em>' reference.
	 * @see #getTriggeringEvent()
	 * @generated
	 */
	void setTriggeringEvent(FSMEvent value);

} // EventGuard
