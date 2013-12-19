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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage
 * @generated
 */
public interface CcslmocFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CcslmocFactory eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CcslmocFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CCSL Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL Library</em>'.
	 * @generated
	 */
	CCSLLibrary createCCSLLibrary();

	/**
	 * Returns a new object of class '<em>CCSL State Machine Relation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL State Machine Relation Definition</em>'.
	 * @generated
	 */
	CCSLStateMachineRelationDefinition createCCSLStateMachineRelationDefinition();

	/**
	 * Returns a new object of class '<em>Finish Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finish Clock</em>'.
	 * @generated
	 */
	FinishClock createFinishClock();

	/**
	 * Returns a new object of class '<em>Integer Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Assignement</em>'.
	 * @generated
	 */
	IntegerAssignement createIntegerAssignement();

	/**
	 * Returns a new object of class '<em>CCSL Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL Guard</em>'.
	 * @generated
	 */
	CCSLGuard createCCSLGuard();

	/**
	 * Returns a new object of class '<em>CCSL Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL Trigger</em>'.
	 * @generated
	 */
	CCSLTrigger createCCSLTrigger();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CcslmocPackage getCcslmocPackage();

} //CcslmocFactory
