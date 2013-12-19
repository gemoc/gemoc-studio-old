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

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getClocks <em>Clocks</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getGlobalTimeConstraints <em>Global Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getTimeLibrary()
 * @model
 * @generated
 */
public interface TimeLibrary extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Clocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clocks</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getTimeLibrary_Clocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClockAbstraction> getClocks();

	/**
	 * Returns the value of the '<em><b>Global Time Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Time Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Time Constraints</em>' containment reference list.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimePackage#getTimeLibrary_GlobalTimeConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<TimeConstraint> getGlobalTimeConstraints();

} // TimeLibrary
