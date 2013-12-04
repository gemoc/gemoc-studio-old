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
package org.gemoc.mocc.cometaccsl.model.cometa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface CometaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cometa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.cometa/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cometa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometaPackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCSystemSpecificationImpl <em>Mo CSystem Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCSystemSpecificationImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getMoCSystemSpecification()
	 * @generated
	 */
	int MO_CSYSTEM_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Moc Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CSYSTEM_SPECIFICATION__MOC_LIB = 0;

	/**
	 * The number of structural features of the '<em>Mo CSystem Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CSYSTEM_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Mo CSystem Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CSYSTEM_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl <em>System Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getCometaSystemSpecification()
	 * @generated
	 */
	int COMETA_SYSTEM_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Moc Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION__MOC_LIB = MO_CSYSTEM_SPECIFICATION__MOC_LIB;

	/**
	 * The feature id for the '<em><b>Data Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION__DATA_LIB = MO_CSYSTEM_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structure Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB = MO_CSYSTEM_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Lib</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION__TIME_LIB = MO_CSYSTEM_SPECIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>System Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION_FEATURE_COUNT = MO_CSYSTEM_SPECIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>System Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_SYSTEM_SPECIFICATION_OPERATION_COUNT = MO_CSYSTEM_SPECIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__DEFINITION = 2;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl <em>Element Abstraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getElementAbstraction()
	 * @generated
	 */
	int ELEMENT_ABSTRACTION = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ABSTRACTION__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Element Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ABSTRACTION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Element Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_ABSTRACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl <em>Mo CLibrary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getMoCLibrary()
	 * @generated
	 */
	int MO_CLIBRARY = 4;

	/**
	 * The number of structural features of the '<em>Mo CLibrary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CLIBRARY_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Mo CLibrary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CLIBRARY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification <em>Mo CSystem Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CSystem Specification</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification
	 * @generated
	 */
	EClass getMoCSystemSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification#getMocLib <em>Moc Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Moc Lib</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification#getMocLib()
	 * @see #getMoCSystemSpecification()
	 * @generated
	 */
	EReference getMoCSystemSpecification_MocLib();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification <em>System Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Specification</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification
	 * @generated
	 */
	EClass getCometaSystemSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getDataLib <em>Data Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Lib</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getDataLib()
	 * @see #getCometaSystemSpecification()
	 * @generated
	 */
	EReference getCometaSystemSpecification_DataLib();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getStructureLib <em>Structure Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Structure Lib</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getStructureLib()
	 * @see #getCometaSystemSpecification()
	 * @generated
	 */
	EReference getCometaSystemSpecification_StructureLib();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getTimeLib <em>Time Lib</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Lib</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification#getTimeLib()
	 * @see #getCometaSystemSpecification()
	 * @generated
	 */
	EReference getCometaSystemSpecification_TimeLib();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getVersion()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement#getDefinition()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Definition();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction <em>Element Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Abstraction</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction
	 * @generated
	 */
	EClass getElementAbstraction();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction#getContent()
	 * @see #getElementAbstraction()
	 * @generated
	 */
	EAttribute getElementAbstraction_Content();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary <em>Mo CLibrary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CLibrary</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.MoCLibrary
	 * @generated
	 */
	EClass getMoCLibrary();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CometaFactory getCometaFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCSystemSpecificationImpl <em>Mo CSystem Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCSystemSpecificationImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getMoCSystemSpecification()
		 * @generated
		 */
		EClass MO_CSYSTEM_SPECIFICATION = eINSTANCE.getMoCSystemSpecification();

		/**
		 * The meta object literal for the '<em><b>Moc Lib</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CSYSTEM_SPECIFICATION__MOC_LIB = eINSTANCE.getMoCSystemSpecification_MocLib();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl <em>System Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getCometaSystemSpecification()
		 * @generated
		 */
		EClass COMETA_SYSTEM_SPECIFICATION = eINSTANCE.getCometaSystemSpecification();

		/**
		 * The meta object literal for the '<em><b>Data Lib</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_SYSTEM_SPECIFICATION__DATA_LIB = eINSTANCE.getCometaSystemSpecification_DataLib();

		/**
		 * The meta object literal for the '<em><b>Structure Lib</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB = eINSTANCE.getCometaSystemSpecification_StructureLib();

		/**
		 * The meta object literal for the '<em><b>Time Lib</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_SYSTEM_SPECIFICATION__TIME_LIB = eINSTANCE.getCometaSystemSpecification_TimeLib();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.NamedElement <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.NamedElement
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__VERSION = eINSTANCE.getNamedElement_Version();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__DEFINITION = eINSTANCE.getNamedElement_Definition();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl <em>Element Abstraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.ElementAbstractionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getElementAbstraction()
		 * @generated
		 */
		EClass ELEMENT_ABSTRACTION = eINSTANCE.getElementAbstraction();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_ABSTRACTION__CONTENT = eINSTANCE.getElementAbstraction_Content();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl <em>Mo CLibrary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaPackageImpl#getMoCLibrary()
		 * @generated
		 */
		EClass MO_CLIBRARY = eINSTANCE.getMoCLibrary();

	}

} //CometaPackage
