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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructureFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface CometastructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cometastructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.cometastructure/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cometastructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometastructurePackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl <em>Structure Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureContainer()
	 * @generated
	 */
	int STRUCTURE_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__PARTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connector Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__CONNECTOR_INSTANCES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__COMPONENT_INSTANCES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER__PORT_INSTANCES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Structure Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Structure Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_CONTAINER_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement <em>Structure Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureElement()
	 * @generated
	 */
	int STRUCTURE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__BEHAVIOR_MAP = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__MOC_DOMAIN = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT__PARAMETERS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Structure Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Structure Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_ELEMENT_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl <em>Mo CConnector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCConnector()
	 * @generated
	 */
	int MO_CCONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__NAME = STRUCTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__VERSION = STRUCTURE_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__DEFINITION = STRUCTURE_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__BEHAVIOR_MAP = STRUCTURE_ELEMENT__BEHAVIOR_MAP;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__MOC_DOMAIN = STRUCTURE_ELEMENT__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__PARAMETERS = STRUCTURE_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__SOURCE = STRUCTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__TARGET = STRUCTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR__KIND = STRUCTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mo CConnector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR_FEATURE_COUNT = STRUCTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Mo CConnector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCONNECTOR_OPERATION_COUNT = STRUCTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent <em>Mo CComponent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCComponent()
	 * @generated
	 */
	int MO_CCOMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__NAME = STRUCTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__VERSION = STRUCTURE_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__DEFINITION = STRUCTURE_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__BEHAVIOR_MAP = STRUCTURE_ELEMENT__BEHAVIOR_MAP;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__MOC_DOMAIN = STRUCTURE_ELEMENT__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__PARAMETERS = STRUCTURE_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Port Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT__OWNED_PORT_INSTANCES = STRUCTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mo CComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT_FEATURE_COUNT = STRUCTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mo CComponent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CCOMPONENT_OPERATION_COUNT = STRUCTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl <em>Mo CPort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCPort()
	 * @generated
	 */
	int MO_CPORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__NAME = STRUCTURE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__VERSION = STRUCTURE_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__DEFINITION = STRUCTURE_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__BEHAVIOR_MAP = STRUCTURE_ELEMENT__BEHAVIOR_MAP;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__MOC_DOMAIN = STRUCTURE_ELEMENT__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__PARAMETERS = STRUCTURE_ELEMENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__DIRECTION = STRUCTURE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__TARGET = STRUCTURE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT__PORT_INTERFACES = STRUCTURE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mo CPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT_FEATURE_COUNT = STRUCTURE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Mo CPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPORT_OPERATION_COUNT = STRUCTURE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PARTS = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CompositeComponentImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getCompositeComponent()
	 * @generated
	 */
	int COMPOSITE_COMPONENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__NAME = MO_CCOMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__VERSION = MO_CCOMPONENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__DEFINITION = MO_CCOMPONENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__BEHAVIOR_MAP = MO_CCOMPONENT__BEHAVIOR_MAP;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__MOC_DOMAIN = MO_CCOMPONENT__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PARAMETERS = MO_CCOMPONENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Port Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__OWNED_PORT_INSTANCES = MO_CCOMPONENT__OWNED_PORT_INSTANCES;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__PARTS = MO_CCOMPONENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__CONNECTORS = MO_CCOMPONENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT__SUB_COMPONENTS = MO_CCOMPONENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_FEATURE_COUNT = MO_CCOMPONENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composite Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_COMPONENT_OPERATION_COUNT = MO_CCOMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl <em>Basic Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getBasicComponent()
	 * @generated
	 */
	int BASIC_COMPONENT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__NAME = MO_CCOMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__VERSION = MO_CCOMPONENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__DEFINITION = MO_CCOMPONENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Behavior Map</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__BEHAVIOR_MAP = MO_CCOMPONENT__BEHAVIOR_MAP;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__MOC_DOMAIN = MO_CCOMPONENT__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__PARAMETERS = MO_CCOMPONENT__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Port Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__OWNED_PORT_INSTANCES = MO_CCOMPONENT__OWNED_PORT_INSTANCES;

	/**
	 * The feature id for the '<em><b>Computation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT__COMPUTATION = MO_CCOMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Basic Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT_FEATURE_COUNT = MO_CCOMPONENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Basic Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_COMPONENT_OPERATION_COUNT = MO_CCOMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl <em>Structure Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureLibrary()
	 * @generated
	 */
	int STRUCTURE_LIBRARY = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Moc Structures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY__MOC_STRUCTURES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Moc Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY__MOC_INTERFACES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structure Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Structure Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_LIBRARY_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.PartImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getPart()
	 * @generated
	 */
	int PART = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__PARTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__COMPONENT_TYPE = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__PORTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Container</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__CONTAINER = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind <em>Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getPortKind()
	 * @generated
	 */
	int PORT_KIND = 10;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind <em>Mo CConnector Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCConnectorKind()
	 * @generated
	 */
	int MO_CCONNECTOR_KIND = 11;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer <em>Structure Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Container</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer
	 * @generated
	 */
	EClass getStructureContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getConnectorInstances <em>Connector Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connector Instances</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getConnectorInstances()
	 * @see #getStructureContainer()
	 * @generated
	 */
	EReference getStructureContainer_ConnectorInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getComponentInstances <em>Component Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Instances</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getComponentInstances()
	 * @see #getStructureContainer()
	 * @generated
	 */
	EReference getStructureContainer_ComponentInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getPortInstances <em>Port Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port Instances</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer#getPortInstances()
	 * @see #getStructureContainer()
	 * @generated
	 */
	EReference getStructureContainer_PortInstances();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector <em>Mo CConnector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CConnector</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector
	 * @generated
	 */
	EClass getMoCConnector();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getSource()
	 * @see #getMoCConnector()
	 * @generated
	 */
	EReference getMoCConnector_Source();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getTarget()
	 * @see #getMoCConnector()
	 * @generated
	 */
	EReference getMoCConnector_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector#getKind()
	 * @see #getMoCConnector()
	 * @generated
	 */
	EAttribute getMoCConnector_Kind();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent <em>Mo CComponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CComponent</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent
	 * @generated
	 */
	EClass getMoCComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent#getOwnedPortInstances <em>Owned Port Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Port Instances</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent#getOwnedPortInstances()
	 * @see #getMoCComponent()
	 * @generated
	 */
	EReference getMoCComponent_OwnedPortInstances();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort <em>Mo CPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CPort</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort
	 * @generated
	 */
	EClass getMoCPort();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getDirection()
	 * @see #getMoCPort()
	 * @generated
	 */
	EAttribute getMoCPort_Direction();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getTarget()
	 * @see #getMoCPort()
	 * @generated
	 */
	EReference getMoCPort_Target();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getPortInterfaces <em>Port Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Port Interfaces</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort#getPortInterfaces()
	 * @see #getMoCPort()
	 * @generated
	 */
	EReference getMoCPort_PortInterfaces();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement <em>Structure Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Element</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement
	 * @generated
	 */
	EClass getStructureElement();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getBehaviorMap <em>Behavior Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior Map</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getBehaviorMap()
	 * @see #getStructureElement()
	 * @generated
	 */
	EReference getStructureElement_BehaviorMap();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getMocDomain <em>Moc Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Moc Domain</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getMocDomain()
	 * @see #getStructureElement()
	 * @generated
	 */
	EReference getStructureElement_MocDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement#getParameters()
	 * @see #getStructureElement()
	 * @generated
	 */
	EReference getStructureElement_Parameters();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container#getParts()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Parts();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Component</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent
	 * @generated
	 */
	EClass getCompositeComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getConnectors()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	EReference getCompositeComponent_Connectors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CompositeComponent#getSubComponents()
	 * @see #getCompositeComponent()
	 * @generated
	 */
	EReference getCompositeComponent_SubComponents();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent <em>Basic Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Component</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent
	 * @generated
	 */
	EClass getBasicComponent();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent#getComputation <em>Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Computation</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.BasicComponent#getComputation()
	 * @see #getBasicComponent()
	 * @generated
	 */
	EReference getBasicComponent_Computation();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary <em>Structure Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure Library</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary
	 * @generated
	 */
	EClass getStructureLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocStructures <em>Moc Structures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Moc Structures</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocStructures()
	 * @see #getStructureLibrary()
	 * @generated
	 */
	EReference getStructureLibrary_MocStructures();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocInterfaces <em>Moc Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Moc Interfaces</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary#getMocInterfaces()
	 * @see #getStructureLibrary()
	 * @generated
	 */
	EReference getStructureLibrary_MocInterfaces();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getComponentType <em>Component Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Type</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getComponentType()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_ComponentType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getPorts()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Ports();

	/**
	 * Returns the meta object for the container reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Container</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part#getContainer()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Container();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind <em>Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind
	 * @generated
	 */
	EEnum getPortKind();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind <em>Mo CConnector Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mo CConnector Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind
	 * @generated
	 */
	EEnum getMoCConnectorKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CometastructureFactory getCometastructureFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl <em>Structure Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureContainer()
		 * @generated
		 */
		EClass STRUCTURE_CONTAINER = eINSTANCE.getStructureContainer();

		/**
		 * The meta object literal for the '<em><b>Connector Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_CONTAINER__CONNECTOR_INSTANCES = eINSTANCE.getStructureContainer_ConnectorInstances();

		/**
		 * The meta object literal for the '<em><b>Component Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_CONTAINER__COMPONENT_INSTANCES = eINSTANCE.getStructureContainer_ComponentInstances();

		/**
		 * The meta object literal for the '<em><b>Port Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_CONTAINER__PORT_INSTANCES = eINSTANCE.getStructureContainer_PortInstances();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl <em>Mo CConnector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCConnectorImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCConnector()
		 * @generated
		 */
		EClass MO_CCONNECTOR = eINSTANCE.getMoCConnector();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CCONNECTOR__SOURCE = eINSTANCE.getMoCConnector_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CCONNECTOR__TARGET = eINSTANCE.getMoCConnector_Target();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MO_CCONNECTOR__KIND = eINSTANCE.getMoCConnector_Kind();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent <em>Mo CComponent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCComponent()
		 * @generated
		 */
		EClass MO_CCOMPONENT = eINSTANCE.getMoCComponent();

		/**
		 * The meta object literal for the '<em><b>Owned Port Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CCOMPONENT__OWNED_PORT_INSTANCES = eINSTANCE.getMoCComponent_OwnedPortInstances();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl <em>Mo CPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.MoCPortImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCPort()
		 * @generated
		 */
		EClass MO_CPORT = eINSTANCE.getMoCPort();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MO_CPORT__DIRECTION = eINSTANCE.getMoCPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CPORT__TARGET = eINSTANCE.getMoCPort_Target();

		/**
		 * The meta object literal for the '<em><b>Port Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CPORT__PORT_INTERFACES = eINSTANCE.getMoCPort_PortInterfaces();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement <em>Structure Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureElement
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureElement()
		 * @generated
		 */
		EClass STRUCTURE_ELEMENT = eINSTANCE.getStructureElement();

		/**
		 * The meta object literal for the '<em><b>Behavior Map</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_ELEMENT__BEHAVIOR_MAP = eINSTANCE.getStructureElement_BehaviorMap();

		/**
		 * The meta object literal for the '<em><b>Moc Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_ELEMENT__MOC_DOMAIN = eINSTANCE.getStructureElement_MocDomain();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_ELEMENT__PARAMETERS = eINSTANCE.getStructureElement_Parameters();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__PARTS = eINSTANCE.getContainer_Parts();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CompositeComponentImpl <em>Composite Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CompositeComponentImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getCompositeComponent()
		 * @generated
		 */
		EClass COMPOSITE_COMPONENT = eINSTANCE.getCompositeComponent();

		/**
		 * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_COMPONENT__CONNECTORS = eINSTANCE.getCompositeComponent_Connectors();

		/**
		 * The meta object literal for the '<em><b>Sub Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_COMPONENT__SUB_COMPONENTS = eINSTANCE.getCompositeComponent_SubComponents();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl <em>Basic Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.BasicComponentImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getBasicComponent()
		 * @generated
		 */
		EClass BASIC_COMPONENT = eINSTANCE.getBasicComponent();

		/**
		 * The meta object literal for the '<em><b>Computation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_COMPONENT__COMPUTATION = eINSTANCE.getBasicComponent_Computation();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl <em>Structure Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getStructureLibrary()
		 * @generated
		 */
		EClass STRUCTURE_LIBRARY = eINSTANCE.getStructureLibrary();

		/**
		 * The meta object literal for the '<em><b>Moc Structures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_LIBRARY__MOC_STRUCTURES = eINSTANCE.getStructureLibrary_MocStructures();

		/**
		 * The meta object literal for the '<em><b>Moc Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE_LIBRARY__MOC_INTERFACES = eINSTANCE.getStructureLibrary_MocInterfaces();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.PartImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '<em><b>Component Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__COMPONENT_TYPE = eINSTANCE.getPart_ComponentType();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__PORTS = eINSTANCE.getPart_Ports();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__CONTAINER = eINSTANCE.getPart_Container();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind <em>Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.PortKind
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getPortKind()
		 * @generated
		 */
		EEnum PORT_KIND = eINSTANCE.getPortKind();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind <em>Mo CConnector Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnectorKind
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.CometastructurePackageImpl#getMoCConnectorKind()
		 * @generated
		 */
		EEnum MO_CCONNECTOR_KIND = eINSTANCE.getMoCConnectorKind();

	}

} //CometastructurePackage
