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
package org.gemoc.mocc.cometaccsl.model.cometa.cometatime;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.CometatimeFactory
 * @model kind="package"
 * @generated
 */
public interface CometatimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cometatime";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.mocc.cometatime/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cometatime";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CometatimePackage eINSTANCE = org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl <em>Time Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getTimeLibrary()
	 * @generated
	 */
	int TIME_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Clocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY__CLOCKS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Global Time Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Time Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Time Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_LIBRARY_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeConstraintImpl <em>Time Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeConstraintImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getTimeConstraint()
	 * @generated
	 */
	int TIME_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT__CONTENT = CometaPackage.ELEMENT_ABSTRACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT__USES = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_FEATURE_COUNT = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Time Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_CONSTRAINT_OPERATION_COUNT = CometaPackage.ELEMENT_ABSTRACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl <em>Clock Abstraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getClockAbstraction()
	 * @generated
	 */
	int CLOCK_ABSTRACTION = 2;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION__CONTENT = CometaPackage.ELEMENT_ABSTRACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Is Refered In Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Referedby Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Referedby Trigger</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Clock Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION_FEATURE_COUNT = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Clock Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_ABSTRACTION_OPERATION_COUNT = CometaPackage.ELEMENT_ABSTRACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ComplexEventDefinitionAbstractionImpl <em>Complex Event Definition Abstraction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ComplexEventDefinitionAbstractionImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getComplexEventDefinitionAbstraction()
	 * @generated
	 */
	int COMPLEX_EVENT_DEFINITION_ABSTRACTION = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_DEFINITION_ABSTRACTION__CONTENT = CometaPackage.ELEMENT_ABSTRACTION__CONTENT;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Event Definition Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_DEFINITION_ABSTRACTION_FEATURE_COUNT = CometaPackage.ELEMENT_ABSTRACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Complex Event Definition Abstraction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_EVENT_DEFINITION_ABSTRACTION_OPERATION_COUNT = CometaPackage.ELEMENT_ABSTRACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ParameterImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__KIND = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__PARAMETER_TYPE = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 5;

	/**
	 * The feature id for the '<em><b>Event Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EVENT_PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__USES = 1;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ServiceImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__KIND = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PARAMETERS = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = CometaPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__VERSION = CometaPackage.NAMED_ELEMENT__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DEFINITION = CometaPackage.NAMED_ELEMENT__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__KIND = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = CometaPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_OPERATION_COUNT = CometaPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface <em>Mo CInterface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getMoCInterface()
	 * @generated
	 */
	int MO_CINTERFACE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE__VERSION = INTERFACE__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE__DEFINITION = INTERFACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE__KIND = INTERFACE__KIND;

	/**
	 * The number of structural features of the '<em>Mo CInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mo CInterface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CINTERFACE_OPERATION_COUNT = INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.SendImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getSend()
	 * @generated
	 */
	int SEND = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__NAME = MO_CINTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__VERSION = MO_CINTERFACE__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__DEFINITION = MO_CINTERFACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__KIND = MO_CINTERFACE__KIND;

	/**
	 * The feature id for the '<em><b>Event Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__EVENT_PARAMETERS = MO_CINTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__USES = MO_CINTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = MO_CINTERFACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_OPERATION_COUNT = MO_CINTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ReceiveImpl <em>Receive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ReceiveImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getReceive()
	 * @generated
	 */
	int RECEIVE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__NAME = MO_CINTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__VERSION = MO_CINTERFACE__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__DEFINITION = MO_CINTERFACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__KIND = MO_CINTERFACE__KIND;

	/**
	 * The feature id for the '<em><b>Event Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__EVENT_PARAMETERS = MO_CINTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE__USES = MO_CINTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_FEATURE_COUNT = MO_CINTERFACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Receive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_OPERATION_COUNT = MO_CINTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.AckImpl <em>Ack</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.AckImpl
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getAck()
	 * @generated
	 */
	int ACK = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__NAME = MO_CINTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__VERSION = MO_CINTERFACE__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__DEFINITION = MO_CINTERFACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__KIND = MO_CINTERFACE__KIND;

	/**
	 * The feature id for the '<em><b>Event Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__EVENT_PARAMETERS = MO_CINTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK__USES = MO_CINTERFACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Ack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK_FEATURE_COUNT = MO_CINTERFACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Ack</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACK_OPERATION_COUNT = MO_CINTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface <em>RT Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getRTInterface()
	 * @generated
	 */
	int RT_INTERFACE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE__VERSION = INTERFACE__VERSION;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE__DEFINITION = INTERFACE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE__KIND = INTERFACE__KIND;

	/**
	 * The number of structural features of the '<em>RT Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>RT Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RT_INTERFACE_OPERATION_COUNT = INTERFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind <em>Interface Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getInterfaceKind()
	 * @generated
	 */
	int INTERFACE_KIND = 13;


	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary <em>Time Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Library</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary
	 * @generated
	 */
	EClass getTimeLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getClocks <em>Clocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clocks</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getClocks()
	 * @see #getTimeLibrary()
	 * @generated
	 */
	EReference getTimeLibrary_Clocks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getGlobalTimeConstraints <em>Global Time Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Time Constraints</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary#getGlobalTimeConstraints()
	 * @see #getTimeLibrary()
	 * @generated
	 */
	EReference getTimeLibrary_GlobalTimeConstraints();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint <em>Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time Constraint</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint
	 * @generated
	 */
	EClass getTimeConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint#getUses()
	 * @see #getTimeConstraint()
	 * @generated
	 */
	EReference getTimeConstraint_Uses();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction <em>Clock Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Abstraction</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction
	 * @generated
	 */
	EClass getClockAbstraction();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedInConstraints <em>Is Refered In Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Refered In Constraints</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedInConstraints()
	 * @see #getClockAbstraction()
	 * @generated
	 */
	EReference getClockAbstraction_IsReferedInConstraints();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyEvents <em>Is Referedby Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Referedby Events</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyEvents()
	 * @see #getClockAbstraction()
	 * @generated
	 */
	EReference getClockAbstraction_IsReferedbyEvents();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyTrigger <em>Is Referedby Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Referedby Trigger</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction#getIsReferedbyTrigger()
	 * @see #getClockAbstraction()
	 * @generated
	 */
	EReference getClockAbstraction_IsReferedbyTrigger();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction <em>Complex Event Definition Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Event Definition Abstraction</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction
	 * @generated
	 */
	EClass getComplexEventDefinitionAbstraction();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ComplexEventDefinitionAbstraction#getUses()
	 * @see #getComplexEventDefinitionAbstraction()
	 * @generated
	 */
	EReference getComplexEventDefinitionAbstraction_Uses();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Type</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getParameterType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_ParameterType();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Value();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getEventParameters <em>Event Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Parameters</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getEventParameters()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_EventParameters();

	/**
	 * Returns the meta object for the reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Uses</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event#getUses()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Uses();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Service#getParameters()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Parameters();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Receive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Receive
	 * @generated
	 */
	EClass getReceive();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Ack <em>Ack</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ack</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Ack
	 * @generated
	 */
	EClass getAck();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface#getKind()
	 * @see #getInterface()
	 * @generated
	 */
	EAttribute getInterface_Kind();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface <em>Mo CInterface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CInterface</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface
	 * @generated
	 */
	EClass getMoCInterface();

	/**
	 * Returns the meta object for class '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface <em>RT Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>RT Interface</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface
	 * @generated
	 */
	EClass getRTInterface();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind <em>Interface Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interface Kind</em>'.
	 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind
	 * @generated
	 */
	EEnum getInterfaceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CometatimeFactory getCometatimeFactory();

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
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl <em>Time Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeLibraryImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getTimeLibrary()
		 * @generated
		 */
		EClass TIME_LIBRARY = eINSTANCE.getTimeLibrary();

		/**
		 * The meta object literal for the '<em><b>Clocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_LIBRARY__CLOCKS = eINSTANCE.getTimeLibrary_Clocks();

		/**
		 * The meta object literal for the '<em><b>Global Time Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_LIBRARY__GLOBAL_TIME_CONSTRAINTS = eINSTANCE.getTimeLibrary_GlobalTimeConstraints();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeConstraintImpl <em>Time Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.TimeConstraintImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getTimeConstraint()
		 * @generated
		 */
		EClass TIME_CONSTRAINT = eINSTANCE.getTimeConstraint();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIME_CONSTRAINT__USES = eINSTANCE.getTimeConstraint_Uses();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl <em>Clock Abstraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ClockAbstractionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getClockAbstraction()
		 * @generated
		 */
		EClass CLOCK_ABSTRACTION = eINSTANCE.getClockAbstraction();

		/**
		 * The meta object literal for the '<em><b>Is Refered In Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_ABSTRACTION__IS_REFERED_IN_CONSTRAINTS = eINSTANCE.getClockAbstraction_IsReferedInConstraints();

		/**
		 * The meta object literal for the '<em><b>Is Referedby Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_ABSTRACTION__IS_REFEREDBY_EVENTS = eINSTANCE.getClockAbstraction_IsReferedbyEvents();

		/**
		 * The meta object literal for the '<em><b>Is Referedby Trigger</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_ABSTRACTION__IS_REFEREDBY_TRIGGER = eINSTANCE.getClockAbstraction_IsReferedbyTrigger();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ComplexEventDefinitionAbstractionImpl <em>Complex Event Definition Abstraction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ComplexEventDefinitionAbstractionImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getComplexEventDefinitionAbstraction()
		 * @generated
		 */
		EClass COMPLEX_EVENT_DEFINITION_ABSTRACTION = eINSTANCE.getComplexEventDefinitionAbstraction();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_EVENT_DEFINITION_ABSTRACTION__USES = eINSTANCE.getComplexEventDefinitionAbstraction_Uses();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ParameterImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__PARAMETER_TYPE = eINSTANCE.getParameter_ParameterType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Event
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Event Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__EVENT_PARAMETERS = eINSTANCE.getEvent_EventParameters();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__USES = eINSTANCE.getEvent_Uses();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ServiceImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__PARAMETERS = eINSTANCE.getService_Parameters();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.SendImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ReceiveImpl <em>Receive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.ReceiveImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getReceive()
		 * @generated
		 */
		EClass RECEIVE = eINSTANCE.getReceive();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.AckImpl <em>Ack</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.AckImpl
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getAck()
		 * @generated
		 */
		EClass ACK = eINSTANCE.getAck();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.Interface
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERFACE__KIND = eINSTANCE.getInterface_Kind();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface <em>Mo CInterface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.MoCInterface
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getMoCInterface()
		 * @generated
		 */
		EClass MO_CINTERFACE = eINSTANCE.getMoCInterface();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface <em>RT Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.RTInterface
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getRTInterface()
		 * @generated
		 */
		EClass RT_INTERFACE = eINSTANCE.getRTInterface();

		/**
		 * The meta object literal for the '{@link org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind <em>Interface Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.InterfaceKind
		 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometatime.impl.CometatimePackageImpl#getInterfaceKind()
		 * @generated
		 */
		EEnum INTERFACE_KIND = eINSTANCE.getInterfaceKind();

	}

} //CometatimePackage
