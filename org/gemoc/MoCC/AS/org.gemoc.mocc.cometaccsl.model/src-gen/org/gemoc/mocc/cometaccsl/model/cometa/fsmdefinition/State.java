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

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The notion of State in Cometa is a description of a state of control. A control state contributes in regulating incoming and outgoing requests of various concurrent
 * entities. It allows defining the order in which the various requests must precede or succeed. This is done by describing in each state the authorized events / requests, and by defining the successors and predecessors states (of each state) that are part of the synchronization process.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getActions <em>Actions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getInputTransitions <em>Input Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.State#getOutputTransitions <em>Output Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Action: The action function is defined for the State and Transition. In both cases, the function references the Block they integrate. In the notation of action, a stands for State or Transition. The Blocks define the sequences of instructions for internal and external communication. The internal communication is the communication between control FSM and external control is the answer provided to each requesting concurrent entity.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getState_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Input Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Transitions</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getState_InputTransitions()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getInputTransitions();

	/**
	 * Returns the value of the '<em><b>Output Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Transitions</em>' reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage#getState_OutputTransitions()
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getOutputTransitions();

} // State
