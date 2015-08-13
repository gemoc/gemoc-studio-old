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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage
 * @generated
 */
public interface EditionExtensionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditionExtensionFactory eINSTANCE = org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl.EditionExtensionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Integer Assignement Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Assignement Block</em>'.
	 * @generated
	 */
	IntegerAssignementBlock createIntegerAssignementBlock();

	/**
	 * Returns a new object of class '<em>Int Inf Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Inf Equal</em>'.
	 * @generated
	 */
	IntInfEqual createIntInfEqual();

	/**
	 * Returns a new object of class '<em>Int Sup Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Sup Equal</em>'.
	 * @generated
	 */
	IntSupEqual createIntSupEqual();

	/**
	 * Returns a new object of class '<em>Real Inf Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Inf Equal</em>'.
	 * @generated
	 */
	RealInfEqual createRealInfEqual();

	/**
	 * Returns a new object of class '<em>Real Sup Equal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Sup Equal</em>'.
	 * @generated
	 */
	RealSupEqual createRealSupEqual();

	/**
	 * Returns a new object of class '<em>Int Self Plus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Self Plus Assignement</em>'.
	 * @generated
	 */
	IntSelfPlusAssignement createIntSelfPlusAssignement();

	/**
	 * Returns a new object of class '<em>Int Self Minus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Self Minus Assignement</em>'.
	 * @generated
	 */
	IntSelfMinusAssignement createIntSelfMinusAssignement();

	/**
	 * Returns a new object of class '<em>Int Self Multiply Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Self Multiply Assignement</em>'.
	 * @generated
	 */
	IntSelfMultiplyAssignement createIntSelfMultiplyAssignement();

	/**
	 * Returns a new object of class '<em>Int Self Divide Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Self Divide Assignement</em>'.
	 * @generated
	 */
	IntSelfDivideAssignement createIntSelfDivideAssignement();

	/**
	 * Returns a new object of class '<em>Real Self Plus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Self Plus Assignement</em>'.
	 * @generated
	 */
	RealSelfPlusAssignement createRealSelfPlusAssignement();

	/**
	 * Returns a new object of class '<em>Real Self Minus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Self Minus Assignement</em>'.
	 * @generated
	 */
	RealSelfMinusAssignement createRealSelfMinusAssignement();

	/**
	 * Returns a new object of class '<em>Real Self Multiply Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Self Multiply Assignement</em>'.
	 * @generated
	 */
	RealSelfMultiplyAssignement createRealSelfMultiplyAssignement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EditionExtensionPackage getEditionExtensionPackage();

} //EditionExtensionFactory
