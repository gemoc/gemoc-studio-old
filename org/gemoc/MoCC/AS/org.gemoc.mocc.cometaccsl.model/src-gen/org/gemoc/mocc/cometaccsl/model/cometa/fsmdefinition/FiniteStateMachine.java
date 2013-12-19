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
package org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Finite State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getStates <em>States</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getFinalStates <em>Final States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getFiniteStateMachine()
 * @model abstract="true"
 * @generated
 */
public interface FiniteStateMachine extends EObject {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getFiniteStateMachine_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getFiniteStateMachine_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getFiniteStateMachine_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FiniteStateMachine#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Final States</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final States</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getFiniteStateMachine_FinalStates()
	 * @model
	 * @generated
	 */
	EList<State> getFinalStates();

} // FiniteStateMachine
