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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.FsmdefinitionPackage;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface CometamocPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cometamoc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.cometamoc/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cometamoc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometamocPackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueImpl <em>Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueue()
	 * @generated
	 */
	int QUEUE = 0;

	/**
	 * The feature id for the '<em><b>Rt Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__RT_INTERFACES = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__KIND = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE__SIZE = 2;

	/**
	 * The number of structural features of the '<em>Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl <em>Cometa Mo CLibrary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaMoCLibrary()
	 * @generated
	 */
	int COMETA_MO_CLIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__NAME = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__VERSION = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__DEFINITION = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Moc Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__MOC_DOMAINS = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Moc Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__MOC_EVENTS = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Queues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY__QUEUES = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Cometa Mo CLibrary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY_FEATURE_COUNT = CometaPackage.MO_CLIBRARY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Cometa Mo CLibrary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_MO_CLIBRARY_OPERATION_COUNT = CometaPackage.MO_CLIBRARY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl <em>Mo CDomain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCDomain()
	 * @generated
	 */
	int MO_CDOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Moc Behaviors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN__MOC_BEHAVIORS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mo CDomain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mo CDomain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CDOMAIN_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__ROLES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__MOC_DOMAIN = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Queue Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__QUEUE_INSTANCES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rt Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__RT_INTERFACES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Behavior Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBlockImpl <em>Opaque Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBlockImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getOpaqueBlock()
	 * @generated
	 */
	int OPAQUE_BLOCK = 4;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BLOCK__CONTENT = CometaPackage.ELEMENT_ABSTRACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BLOCK__RT_ELEMENTS = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opaque Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BLOCK_FEATURE_COUNT = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Opaque Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BLOCK_OPERATION_COUNT = CometaPackage.ELEMENT_ABSTRACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl <em>Opaque Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getOpaqueBehavior()
	 * @generated
	 */
	int OPAQUE_BEHAVIOR = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__NAME = BEHAVIOR__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__VERSION = BEHAVIOR__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__DEFINITION = BEHAVIOR__DEFINITION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__ROLES = BEHAVIOR__ROLES;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__MOC_DOMAIN = BEHAVIOR__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Queue Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__QUEUE_INSTANCES = BEHAVIOR__QUEUE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Rt Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__RT_INTERFACES = BEHAVIOR__RT_INTERFACES;

	/**
	 * The feature id for the '<em><b>Behavior Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS = BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR__BODY = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opaque Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Opaque Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPAQUE_BEHAVIOR_OPERATION_COUNT = BEHAVIOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCEventImpl <em>Mo CEvent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCEventImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCEvent()
	 * @generated
	 */
	int MO_CEVENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Event Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT__EVENT_PARAMETERS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT__USES = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mo CEvent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mo CEvent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CEVENT_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueInstanceImpl <em>Queue Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueInstanceImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueueInstance()
	 * @generated
	 */
	int QUEUE_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE__TYPE = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Queue Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Queue Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUEUE_INSTANCE_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl <em>Finite State Machine Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getFiniteStateMachineBehavior()
	 * @generated
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__NAME = BEHAVIOR__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__VERSION = BEHAVIOR__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__DEFINITION = BEHAVIOR__DEFINITION;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__ROLES = BEHAVIOR__ROLES;

	/**
	 * The feature id for the '<em><b>Moc Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__MOC_DOMAIN = BEHAVIOR__MOC_DOMAIN;

	/**
	 * The feature id for the '<em><b>Queue Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__QUEUE_INSTANCES = BEHAVIOR__QUEUE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Rt Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__RT_INTERFACES = BEHAVIOR__RT_INTERFACES;

	/**
	 * The feature id for the '<em><b>Behavior Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS = BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__TRANSITIONS = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__STATES = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__INITIAL_STATE = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Final States</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR__FINAL_STATES = BEHAVIOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Finite State Machine Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Finite State Machine Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINITE_STATE_MACHINE_BEHAVIOR_OPERATION_COUNT = BEHAVIOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl <em>Cometa Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaGuard()
	 * @generated
	 */
	int COMETA_GUARD = 9;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_GUARD__CONTENT = FsmdefinitionPackage.GUARD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_GUARD__RT_ELEMENTS = FsmdefinitionPackage.GUARD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cometa Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_GUARD_FEATURE_COUNT = FsmdefinitionPackage.GUARD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cometa Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_GUARD_OPERATION_COUNT = FsmdefinitionPackage.GUARD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaActionImpl <em>Cometa Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaActionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaAction()
	 * @generated
	 */
	int COMETA_ACTION = 10;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_ACTION__CONTENT = FsmdefinitionPackage.ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rt Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_ACTION__RT_ELEMENTS = FsmdefinitionPackage.ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cometa Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_ACTION_FEATURE_COUNT = FsmdefinitionPackage.ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Cometa Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_ACTION_OPERATION_COUNT = FsmdefinitionPackage.ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaTriggerImpl <em>Cometa Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaTriggerImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaTrigger()
	 * @generated
	 */
	int COMETA_TRIGGER = 11;

	/**
	 * The feature id for the '<em><b>Trigg On</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_TRIGGER__TRIGG_ON = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cometa Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_TRIGGER_FEATURE_COUNT = FsmdefinitionPackage.TRIGGER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cometa Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMETA_TRIGGER_OPERATION_COUNT = FsmdefinitionPackage.TRIGGER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole <em>Mo CRole</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCRole()
	 * @generated
	 */
	int MO_CROLE = 12;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind <em>Queue Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueueKind()
	 * @generated
	 */
	int QUEUE_KIND = 13;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue <em>Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Queue</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue
	 * @generated
	 */
	EClass getQueue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getRtInterfaces <em>Rt Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rt Interfaces</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getRtInterfaces()
	 * @see #getQueue()
	 * @generated
	 */
	EReference getQueue_RtInterfaces();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getKind()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue#getSize()
	 * @see #getQueue()
	 * @generated
	 */
	EAttribute getQueue_Size();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary <em>Cometa Mo CLibrary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cometa Mo CLibrary</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary
	 * @generated
	 */
	EClass getCometaMoCLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocDomains <em>Moc Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Moc Domains</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocDomains()
	 * @see #getCometaMoCLibrary()
	 * @generated
	 */
	EReference getCometaMoCLibrary_MocDomains();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocEvents <em>Moc Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Moc Events</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getMocEvents()
	 * @see #getCometaMoCLibrary()
	 * @generated
	 */
	EReference getCometaMoCLibrary_MocEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getQueues <em>Queues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queues</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary#getQueues()
	 * @see #getCometaMoCLibrary()
	 * @generated
	 */
	EReference getCometaMoCLibrary_Queues();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain <em>Mo CDomain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CDomain</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain
	 * @generated
	 */
	EClass getMoCDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getMocBehaviors <em>Moc Behaviors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Moc Behaviors</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getMocBehaviors()
	 * @see #getMoCDomain()
	 * @generated
	 */
	EReference getMoCDomain_MocBehaviors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getDomainTimeConstraints <em>Domain Time Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Time Constraints</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain#getDomainTimeConstraints()
	 * @see #getMoCDomain()
	 * @generated
	 */
	EReference getMoCDomain_DomainTimeConstraints();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for the attribute list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Roles</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRoles()
	 * @see #getBehavior()
	 * @generated
	 */
	EAttribute getBehavior_Roles();

	/**
	 * Returns the meta object for the container reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain <em>Moc Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Moc Domain</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getMocDomain()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_MocDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getQueueInstances <em>Queue Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Queue Instances</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getQueueInstances()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_QueueInstances();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRtInterfaces <em>Rt Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rt Interfaces</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getRtInterfaces()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_RtInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getBehaviorTimeConstraints <em>Behavior Time Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior Time Constraints</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior#getBehaviorTimeConstraints()
	 * @see #getBehavior()
	 * @generated
	 */
	EReference getBehavior_BehaviorTimeConstraints();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock <em>Opaque Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Block</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock
	 * @generated
	 */
	EClass getOpaqueBlock();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock#getRtElements <em>Rt Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Rt Elements</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock#getRtElements()
	 * @see #getOpaqueBlock()
	 * @generated
	 */
	EReference getOpaqueBlock_RtElements();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior <em>Opaque Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Behavior</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior
	 * @generated
	 */
	EClass getOpaqueBehavior();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBehavior#getBody()
	 * @see #getOpaqueBehavior()
	 * @generated
	 */
	EReference getOpaqueBehavior_Body();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent <em>Mo CEvent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CEvent</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent
	 * @generated
	 */
	EClass getMoCEvent();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance <em>Queue Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Queue Instance</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance
	 * @generated
	 */
	EClass getQueueInstance();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueInstance#getType()
	 * @see #getQueueInstance()
	 * @generated
	 */
	EReference getQueueInstance_Type();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior <em>Finite State Machine Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Finite State Machine Behavior</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.FiniteStateMachineBehavior
	 * @generated
	 */
	EClass getFiniteStateMachineBehavior();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard <em>Cometa Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cometa Guard</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard
	 * @generated
	 */
	EClass getCometaGuard();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction <em>Cometa Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cometa Action</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction
	 * @generated
	 */
	EClass getCometaAction();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger <em>Cometa Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cometa Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger
	 * @generated
	 */
	EClass getCometaTrigger();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger#getTriggOn <em>Trigg On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigg On</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaTrigger#getTriggOn()
	 * @see #getCometaTrigger()
	 * @generated
	 */
	EReference getCometaTrigger_TriggOn();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole <em>Mo CRole</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mo CRole</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole
	 * @generated
	 */
	EEnum getMoCRole();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind <em>Queue Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Queue Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind
	 * @generated
	 */
	EEnum getQueueKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CometamocFactory getCometamocFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueImpl <em>Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueue()
		 * @generated
		 */
		EClass QUEUE = eINSTANCE.getQueue();

		/**
		 * The meta object literal for the '<em><b>Rt Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUEUE__RT_INTERFACES = eINSTANCE.getQueue_RtInterfaces();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__KIND = eINSTANCE.getQueue_Kind();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUEUE__SIZE = eINSTANCE.getQueue_Size();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl <em>Cometa Mo CLibrary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaMoCLibrary()
		 * @generated
		 */
		EClass COMETA_MO_CLIBRARY = eINSTANCE.getCometaMoCLibrary();

		/**
		 * The meta object literal for the '<em><b>Moc Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_MO_CLIBRARY__MOC_DOMAINS = eINSTANCE.getCometaMoCLibrary_MocDomains();

		/**
		 * The meta object literal for the '<em><b>Moc Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_MO_CLIBRARY__MOC_EVENTS = eINSTANCE.getCometaMoCLibrary_MocEvents();

		/**
		 * The meta object literal for the '<em><b>Queues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_MO_CLIBRARY__QUEUES = eINSTANCE.getCometaMoCLibrary_Queues();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl <em>Mo CDomain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCDomain()
		 * @generated
		 */
		EClass MO_CDOMAIN = eINSTANCE.getMoCDomain();

		/**
		 * The meta object literal for the '<em><b>Moc Behaviors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CDOMAIN__MOC_BEHAVIORS = eINSTANCE.getMoCDomain_MocBehaviors();

		/**
		 * The meta object literal for the '<em><b>Domain Time Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS = eINSTANCE.getMoCDomain_DomainTimeConstraints();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOR__ROLES = eINSTANCE.getBehavior_Roles();

		/**
		 * The meta object literal for the '<em><b>Moc Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__MOC_DOMAIN = eINSTANCE.getBehavior_MocDomain();

		/**
		 * The meta object literal for the '<em><b>Queue Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__QUEUE_INSTANCES = eINSTANCE.getBehavior_QueueInstances();

		/**
		 * The meta object literal for the '<em><b>Rt Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__RT_INTERFACES = eINSTANCE.getBehavior_RtInterfaces();

		/**
		 * The meta object literal for the '<em><b>Behavior Time Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOR__BEHAVIOR_TIME_CONSTRAINTS = eINSTANCE.getBehavior_BehaviorTimeConstraints();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBlockImpl <em>Opaque Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBlockImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getOpaqueBlock()
		 * @generated
		 */
		EClass OPAQUE_BLOCK = eINSTANCE.getOpaqueBlock();

		/**
		 * The meta object literal for the '<em><b>Rt Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_BLOCK__RT_ELEMENTS = eINSTANCE.getOpaqueBlock_RtElements();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl <em>Opaque Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.OpaqueBehaviorImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getOpaqueBehavior()
		 * @generated
		 */
		EClass OPAQUE_BEHAVIOR = eINSTANCE.getOpaqueBehavior();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPAQUE_BEHAVIOR__BODY = eINSTANCE.getOpaqueBehavior_Body();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCEventImpl <em>Mo CEvent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCEventImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCEvent()
		 * @generated
		 */
		EClass MO_CEVENT = eINSTANCE.getMoCEvent();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueInstanceImpl <em>Queue Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.QueueInstanceImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueueInstance()
		 * @generated
		 */
		EClass QUEUE_INSTANCE = eINSTANCE.getQueueInstance();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUEUE_INSTANCE__TYPE = eINSTANCE.getQueueInstance_Type();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl <em>Finite State Machine Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.FiniteStateMachineBehaviorImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getFiniteStateMachineBehavior()
		 * @generated
		 */
		EClass FINITE_STATE_MACHINE_BEHAVIOR = eINSTANCE.getFiniteStateMachineBehavior();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl <em>Cometa Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaGuardImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaGuard()
		 * @generated
		 */
		EClass COMETA_GUARD = eINSTANCE.getCometaGuard();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaActionImpl <em>Cometa Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaActionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaAction()
		 * @generated
		 */
		EClass COMETA_ACTION = eINSTANCE.getCometaAction();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaTriggerImpl <em>Cometa Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaTriggerImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getCometaTrigger()
		 * @generated
		 */
		EClass COMETA_TRIGGER = eINSTANCE.getCometaTrigger();

		/**
		 * The meta object literal for the '<em><b>Trigg On</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMETA_TRIGGER__TRIGG_ON = eINSTANCE.getCometaTrigger_TriggOn();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole <em>Mo CRole</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCRole
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getMoCRole()
		 * @generated
		 */
		EEnum MO_CROLE = eINSTANCE.getMoCRole();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind <em>Queue Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.QueueKind
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometamocPackageImpl#getQueueKind()
		 * @generated
		 */
		EEnum QUEUE_KIND = eINSTANCE.getQueueKind();

	}

} //CometamocPackage
