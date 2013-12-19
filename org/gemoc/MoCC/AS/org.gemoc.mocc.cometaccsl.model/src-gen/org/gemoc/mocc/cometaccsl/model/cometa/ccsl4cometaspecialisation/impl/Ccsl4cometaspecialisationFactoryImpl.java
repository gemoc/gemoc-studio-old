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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Ccsl4cometaspecialisationFactoryImpl extends EFactoryImpl implements Ccsl4cometaspecialisationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ccsl4cometaspecialisationFactory init() {
		try {
			Ccsl4cometaspecialisationFactory theCcsl4cometaspecialisationFactory = (Ccsl4cometaspecialisationFactory)EPackage.Registry.INSTANCE.getEFactory(Ccsl4cometaspecialisationPackage.eNS_URI);
			if (theCcsl4cometaspecialisationFactory != null) {
				return theCcsl4cometaspecialisationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Ccsl4cometaspecialisationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ccsl4cometaspecialisationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_CLOCK: return createCCSL4CometaClock();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_BLOCK_ABSTRACTION: return createCCSL4CometaBlockAbstraction();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_TIME_CONSTRAINT: return createCCSL4CometaTimeConstraint();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER: return createCCSL4CometaComplexTrigger();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION: return createCCSL4CometaCometaSystemSpecification();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_GUARD: return createCCSL4CometaGuard();
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_ACTION: return createCCSL4CometaAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaClock createCCSL4CometaClock() {
		CCSL4CometaClockImpl ccsl4CometaClock = new CCSL4CometaClockImpl();
		return ccsl4CometaClock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaBlockAbstraction createCCSL4CometaBlockAbstraction() {
		CCSL4CometaBlockAbstractionImpl ccsl4CometaBlockAbstraction = new CCSL4CometaBlockAbstractionImpl();
		return ccsl4CometaBlockAbstraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaTimeConstraint createCCSL4CometaTimeConstraint() {
		CCSL4CometaTimeConstraintImpl ccsl4CometaTimeConstraint = new CCSL4CometaTimeConstraintImpl();
		return ccsl4CometaTimeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaComplexTrigger createCCSL4CometaComplexTrigger() {
		CCSL4CometaComplexTriggerImpl ccsl4CometaComplexTrigger = new CCSL4CometaComplexTriggerImpl();
		return ccsl4CometaComplexTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaCometaSystemSpecification createCCSL4CometaCometaSystemSpecification() {
		CCSL4CometaCometaSystemSpecificationImpl ccsl4CometaCometaSystemSpecification = new CCSL4CometaCometaSystemSpecificationImpl();
		return ccsl4CometaCometaSystemSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaGuard createCCSL4CometaGuard() {
		CCSL4CometaGuardImpl ccsl4CometaGuard = new CCSL4CometaGuardImpl();
		return ccsl4CometaGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CCSL4CometaAction createCCSL4CometaAction() {
		CCSL4CometaActionImpl ccsl4CometaAction = new CCSL4CometaActionImpl();
		return ccsl4CometaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ccsl4cometaspecialisationPackage getCcsl4cometaspecialisationPackage() {
		return (Ccsl4cometaspecialisationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Ccsl4cometaspecialisationPackage getPackage() {
		return Ccsl4cometaspecialisationPackage.eINSTANCE;
	}

} //Ccsl4cometaspecialisationFactoryImpl
