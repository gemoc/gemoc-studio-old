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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getEventParameters <em>Event Parameters</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getUses <em>Uses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getEvent()
 * @model interface="true" abstract="true"
 *        extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface Event extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Parameters</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getEvent_EventParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getEventParameters();

	/**
	 * Returns the value of the '<em><b>Uses</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyEvents <em>Is Referedby Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getEvent_Uses()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyEvents
	 * @model opposite="isReferedbyEvents"
	 * @generated
	 */
	EList<ClockAbstraction> getUses();

} // Event
