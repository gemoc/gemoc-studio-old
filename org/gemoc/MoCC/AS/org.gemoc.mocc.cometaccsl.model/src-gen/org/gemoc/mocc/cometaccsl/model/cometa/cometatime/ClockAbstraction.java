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

import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clock Abstraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedInConstraints <em>Is Refered In Constraints</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyEvents <em>Is Referedby Events</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyTrigger <em>Is Referedby Trigger</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getClockAbstraction()
 * @model abstract="true"
 *        extendedMetaData="name='TimeLibrary'"
 * @generated
 */
public interface ClockAbstraction extends ElementAbstraction {
	/**
	 * Returns the value of the '<em><b>Is Refered In Constraints</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Refered In Constraints</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Refered In Constraints</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getClockAbstraction_IsReferedInConstraints()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint#getUses
	 * @model opposite="uses"
	 * @generated
	 */
	EList<TimeConstraint> getIsReferedInConstraints();

	/**
	 * Returns the value of the '<em><b>Is Referedby Events</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Referedby Events</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Referedby Events</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getClockAbstraction_IsReferedbyEvents()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getUses
	 * @model opposite="uses"
	 * @generated
	 */
	EList<Event> getIsReferedbyEvents();

	/**
	 * Returns the value of the '<em><b>Is Referedby Trigger</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Referedby Trigger</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Referedby Trigger</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getClockAbstraction_IsReferedbyTrigger()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction#getUses
	 * @model opposite="uses"
	 * @generated
	 */
	EList<ComplexEventDefinitionAbstraction> getIsReferedbyTrigger();

} // ClockAbstraction
