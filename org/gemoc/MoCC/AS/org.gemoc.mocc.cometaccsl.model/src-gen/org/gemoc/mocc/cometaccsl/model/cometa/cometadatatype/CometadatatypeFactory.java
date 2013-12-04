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
package org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypePackage
 * @generated
 */
public interface CometadatatypeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometadatatypeFactory eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Declaration</em>'.
	 * @generated
	 */
	TypeDeclaration createTypeDeclaration();

	/**
	 * Returns a new object of class '<em>Data Type Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Library</em>'.
	 * @generated
	 */
	DataTypeLibrary createDataTypeLibrary();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CometadatatypePackage getCometadatatypePackage();

} //CometadatatypeFactory
