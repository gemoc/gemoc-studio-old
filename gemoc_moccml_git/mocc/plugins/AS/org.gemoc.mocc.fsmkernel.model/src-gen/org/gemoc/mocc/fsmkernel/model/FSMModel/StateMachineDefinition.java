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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getDeclarationBlock <em>Declaration Block</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getStates <em>States</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getInitialStates <em>Initial States</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getFinalStates <em>Final States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition()
 * @model
 * @generated
 */
public interface StateMachineDefinition extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Declaration Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration Block</em>' containment reference.
	 * @see #setDeclarationBlock(DeclarationBlock)
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition_DeclarationBlock()
	 * @model containment="true"
	 * @generated
	 */
	DeclarationBlock getDeclarationBlock();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.StateMachineDefinition#getDeclarationBlock <em>Declaration Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration Block</em>' containment reference.
	 * @see #getDeclarationBlock()
	 * @generated
	 */
	void setDeclarationBlock(DeclarationBlock value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition_Transitions()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition_States()
	 * @model containment="true" keys="name" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Initial States</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial States</em>' reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition_InitialStates()
	 * @model keys="name" required="true"
	 * @generated
	 */
	EList<State> getInitialStates();

	/**
	 * Returns the value of the '<em><b>Final States</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final States</em>' reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getStateMachineDefinition_FinalStates()
	 * @model keys="name"
	 * @generated
	 */
	EList<State> getFinalStates();

} // StateMachineDefinition
