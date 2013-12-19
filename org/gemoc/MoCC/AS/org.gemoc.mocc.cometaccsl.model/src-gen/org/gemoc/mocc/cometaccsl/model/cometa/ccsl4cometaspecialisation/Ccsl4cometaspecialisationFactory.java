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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage
 * @generated
 */
public interface Ccsl4cometaspecialisationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Ccsl4cometaspecialisationFactory eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl.Ccsl4cometaspecialisationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Clock</em>'.
	 * @generated
	 */
	CCSL4CometaClock createCCSL4CometaClock();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Block Abstraction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Block Abstraction</em>'.
	 * @generated
	 */
	CCSL4CometaBlockAbstraction createCCSL4CometaBlockAbstraction();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Time Constraint</em>'.
	 * @generated
	 */
	CCSL4CometaTimeConstraint createCCSL4CometaTimeConstraint();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Complex Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Complex Trigger</em>'.
	 * @generated
	 */
	CCSL4CometaComplexTrigger createCCSL4CometaComplexTrigger();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Cometa System Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Cometa System Specification</em>'.
	 * @generated
	 */
	CCSL4CometaCometaSystemSpecification createCCSL4CometaCometaSystemSpecification();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Guard</em>'.
	 * @generated
	 */
	CCSL4CometaGuard createCCSL4CometaGuard();

	/**
	 * Returns a new object of class '<em>CCSL4 Cometa Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CCSL4 Cometa Action</em>'.
	 * @generated
	 */
	CCSL4CometaAction createCCSL4CometaAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Ccsl4cometaspecialisationPackage getCcsl4cometaspecialisationPackage();

} //Ccsl4cometaspecialisationFactory
