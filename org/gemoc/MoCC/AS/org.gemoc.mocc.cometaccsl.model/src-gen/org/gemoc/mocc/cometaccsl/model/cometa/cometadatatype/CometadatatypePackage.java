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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.CometadatatypeFactory
 * @model kind="package"
 * @generated
 */
public interface CometadatatypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cometadatatype";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.cometadatatype/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cometadatatype";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometadatatypePackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.TypeDeclarationImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl#getTypeDeclaration()
	 * @generated
	 */
	int TYPE_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The number of structural features of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.DataTypeLibraryImpl <em>Data Type Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.DataTypeLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl#getDataTypeLibrary()
	 * @generated
	 */
	int DATA_TYPE_LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Typedef</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY__TYPEDEF = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Type Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_LIBRARY_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.TypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Declaration</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.TypeDeclaration
	 * @generated
	 */
	EClass getTypeDeclaration();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary <em>Data Type Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Library</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary
	 * @generated
	 */
	EClass getDataTypeLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary#getTypedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Typedef</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary#getTypedef()
	 * @see #getDataTypeLibrary()
	 * @generated
	 */
	EReference getDataTypeLibrary_Typedef();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CometadatatypeFactory getCometadatatypeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.TypeDeclarationImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl#getTypeDeclaration()
		 * @generated
		 */
		EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.DataTypeLibraryImpl <em>Data Type Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.DataTypeLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.impl.CometadatatypePackageImpl#getDataTypeLibrary()
		 * @generated
		 */
		EClass DATA_TYPE_LIBRARY = eINSTANCE.getDataTypeLibrary();

		/**
		 * The meta object literal for the '<em><b>Typedef</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_LIBRARY__TYPEDEF = eINSTANCE.getDataTypeLibrary_Typedef();

	}

} //CometadatatypePackage
