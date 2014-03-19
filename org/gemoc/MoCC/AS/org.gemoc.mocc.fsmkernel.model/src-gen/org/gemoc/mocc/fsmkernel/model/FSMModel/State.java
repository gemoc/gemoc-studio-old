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
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The notion of State in FSMModel is a description of a state of control. A control state contributes in regulating incoming and outgoing requests of various concurrent
 * entities. It allows defining the order in which the various requests must precede or succeed. This is done by describing in each state the authorized events / requests, and by defining the successors and predecessors states (of each state) that are part of the synchronization process.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.State#getInputTransitions <em>Input Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.fsmkernel.model.FSMModel.State#getOutputTransitions <em>Output Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getState()
 * @model
 * @generated
 */
public interface State extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Input Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Transitions</em>' reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getState_InputTransitions()
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getInputTransitions();

	/**
	 * Returns the value of the '<em><b>Output Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition}.
	 * It is bidirectional and its opposite is '{@link org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Transitions</em>' reference list.
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage#getState_OutputTransitions()
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.Transition#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Transition> getOutputTransitions();

} // State
