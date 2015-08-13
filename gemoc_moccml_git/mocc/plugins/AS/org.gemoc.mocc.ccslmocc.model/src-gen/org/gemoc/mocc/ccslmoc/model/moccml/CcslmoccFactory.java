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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.ccslmoc.model.moccml.CcslmoccPackage
 * @generated
 */
public interface CcslmoccFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CcslmoccFactory eINSTANCE = org.gemoc.mocc.ccslmoc.model.moccml.impl.CcslmoccFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>State Relation Based Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Relation Based Library</em>'.
	 * @generated
	 */
	StateRelationBasedLibrary createStateRelationBasedLibrary();

	/**
	 * Returns a new object of class '<em>State Machine Relation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine Relation Definition</em>'.
	 * @generated
	 */
	StateMachineRelationDefinition createStateMachineRelationDefinition();

	/**
	 * Returns a new object of class '<em>Finish Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finish Clock</em>'.
	 * @generated
	 */
	FinishClock createFinishClock();

	/**
	 * Returns a new object of class '<em>Start Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Clock</em>'.
	 * @generated
	 */
	StartClock createStartClock();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CcslmoccPackage getCcslmoccPackage();

} //CcslmoccFactory
