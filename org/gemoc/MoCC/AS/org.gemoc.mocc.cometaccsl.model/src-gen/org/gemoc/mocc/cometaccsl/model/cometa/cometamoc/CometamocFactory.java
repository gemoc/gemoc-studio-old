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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage
 * @generated
 */
public interface CometamocFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometamocFactory eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Queue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Queue</em>'.
	 * @generated
	 */
	Queue createQueue();

	/**
	 * Returns a new object of class '<em>Cometa Mo CLibrary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cometa Mo CLibrary</em>'.
	 * @generated
	 */
	CometaMoCLibrary createCometaMoCLibrary();

	/**
	 * Returns a new object of class '<em>Mo CDomain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mo CDomain</em>'.
	 * @generated
	 */
	MoCDomain createMoCDomain();

	/**
	 * Returns a new object of class '<em>Opaque Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opaque Behavior</em>'.
	 * @generated
	 */
	OpaqueBehavior createOpaqueBehavior();

	/**
	 * Returns a new object of class '<em>Mo CEvent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mo CEvent</em>'.
	 * @generated
	 */
	MoCEvent createMoCEvent();

	/**
	 * Returns a new object of class '<em>Queue Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Queue Instance</em>'.
	 * @generated
	 */
	QueueInstance createQueueInstance();

	/**
	 * Returns a new object of class '<em>Finite State Machine Behavior</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Finite State Machine Behavior</em>'.
	 * @generated
	 */
	FiniteStateMachineBehavior createFiniteStateMachineBehavior();

	/**
	 * Returns a new object of class '<em>Cometa Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cometa Trigger</em>'.
	 * @generated
	 */
	CometaTrigger createCometaTrigger();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CometamocPackage getCometamocPackage();

} //CometamocFactory
