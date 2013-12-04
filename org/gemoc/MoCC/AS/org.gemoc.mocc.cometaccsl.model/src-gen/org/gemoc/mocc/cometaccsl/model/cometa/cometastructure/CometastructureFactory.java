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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage
 * @generated
 */
public interface CometastructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometastructureFactory eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Structure Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Container</em>'.
	 * @generated
	 */
	StructureContainer createStructureContainer();

	/**
	 * Returns a new object of class '<em>Mo CConnector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mo CConnector</em>'.
	 * @generated
	 */
	MoCConnector createMoCConnector();

	/**
	 * Returns a new object of class '<em>Mo CPort</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mo CPort</em>'.
	 * @generated
	 */
	MoCPort createMoCPort();

	/**
	 * Returns a new object of class '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Component</em>'.
	 * @generated
	 */
	CompositeComponent createCompositeComponent();

	/**
	 * Returns a new object of class '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Basic Component</em>'.
	 * @generated
	 */
	BasicComponent createBasicComponent();

	/**
	 * Returns a new object of class '<em>Structure Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structure Library</em>'.
	 * @generated
	 */
	StructureLibrary createStructureLibrary();

	/**
	 * Returns a new object of class '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part</em>'.
	 * @generated
	 */
	Part createPart();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CometastructurePackage getCometastructurePackage();

} //CometastructureFactory
