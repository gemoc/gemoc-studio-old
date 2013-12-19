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
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CometamocFactoryImpl extends EFactoryImpl implements CometamocFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CometamocFactory init() {
		try {
			CometamocFactory theCometamocFactory = (CometamocFactory)EPackage.Registry.INSTANCE.getEFactory(CometamocPackage.eNS_URI);
			if (theCometamocFactory != null) {
				return theCometamocFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CometamocFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometamocFactoryImpl() {
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
			case CometamocPackage.QUEUE: return createQueue();
			case CometamocPackage.COMETA_MO_CLIBRARY: return createCometaMoCLibrary();
			case CometamocPackage.MO_CDOMAIN: return createMoCDomain();
			case CometamocPackage.OPAQUE_BEHAVIOR: return createOpaqueBehavior();
			case CometamocPackage.MO_CEVENT: return createMoCEvent();
			case CometamocPackage.QUEUE_INSTANCE: return createQueueInstance();
			case CometamocPackage.FINITE_STATE_MACHINE_BEHAVIOR: return createFiniteStateMachineBehavior();
			case CometamocPackage.COMETA_TRIGGER: return createCometaTrigger();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CometamocPackage.MO_CROLE:
				return createMoCRoleFromString(eDataType, initialValue);
			case CometamocPackage.QUEUE_KIND:
				return createQueueKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CometamocPackage.MO_CROLE:
				return convertMoCRoleToString(eDataType, instanceValue);
			case CometamocPackage.QUEUE_KIND:
				return convertQueueKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Queue createQueue() {
		QueueImpl queue = new QueueImpl();
		return queue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometaMoCLibrary createCometaMoCLibrary() {
		CometaMoCLibraryImpl cometaMoCLibrary = new CometaMoCLibraryImpl();
		return cometaMoCLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCDomain createMoCDomain() {
		MoCDomainImpl moCDomain = new MoCDomainImpl();
		return moCDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehavior createOpaqueBehavior() {
		OpaqueBehaviorImpl opaqueBehavior = new OpaqueBehaviorImpl();
		return opaqueBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCEvent createMoCEvent() {
		MoCEventImpl moCEvent = new MoCEventImpl();
		return moCEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueueInstance createQueueInstance() {
		QueueInstanceImpl queueInstance = new QueueInstanceImpl();
		return queueInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FiniteStateMachineBehavior createFiniteStateMachineBehavior() {
		FiniteStateMachineBehaviorImpl finiteStateMachineBehavior = new FiniteStateMachineBehaviorImpl();
		return finiteStateMachineBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometaTrigger createCometaTrigger() {
		CometaTriggerImpl cometaTrigger = new CometaTriggerImpl();
		return cometaTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoCRole createMoCRoleFromString(EDataType eDataType, String initialValue) {
		MoCRole result = MoCRole.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMoCRoleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueueKind createQueueKindFromString(EDataType eDataType, String initialValue) {
		QueueKind result = QueueKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueueKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometamocPackage getCometamocPackage() {
		return (CometamocPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CometamocPackage getPackage() {
		return CometamocPackage.eINSTANCE;
	}

} //CometamocFactoryImpl
