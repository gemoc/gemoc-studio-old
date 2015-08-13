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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditionExtensionFactoryImpl extends EFactoryImpl implements EditionExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EditionExtensionFactory init() {
		try {
			EditionExtensionFactory theEditionExtensionFactory = (EditionExtensionFactory)EPackage.Registry.INSTANCE.getEFactory(EditionExtensionPackage.eNS_URI);
			if (theEditionExtensionFactory != null) {
				return theEditionExtensionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditionExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditionExtensionFactoryImpl() {
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
			case EditionExtensionPackage.INTEGER_ASSIGNEMENT_BLOCK: return createIntegerAssignementBlock();
			case EditionExtensionPackage.INT_INF_EQUAL: return createIntInfEqual();
			case EditionExtensionPackage.INT_SUP_EQUAL: return createIntSupEqual();
			case EditionExtensionPackage.REAL_INF_EQUAL: return createRealInfEqual();
			case EditionExtensionPackage.REAL_SUP_EQUAL: return createRealSupEqual();
			case EditionExtensionPackage.INT_SELF_PLUS_ASSIGNEMENT: return createIntSelfPlusAssignement();
			case EditionExtensionPackage.INT_SELF_MINUS_ASSIGNEMENT: return createIntSelfMinusAssignement();
			case EditionExtensionPackage.INT_SELF_MULTIPLY_ASSIGNEMENT: return createIntSelfMultiplyAssignement();
			case EditionExtensionPackage.INT_SELF_DIVIDE_ASSIGNEMENT: return createIntSelfDivideAssignement();
			case EditionExtensionPackage.REAL_SELF_PLUS_ASSIGNEMENT: return createRealSelfPlusAssignement();
			case EditionExtensionPackage.REAL_SELF_MINUS_ASSIGNEMENT: return createRealSelfMinusAssignement();
			case EditionExtensionPackage.REAL_SELF_MULTIPLY_ASSIGNEMENT: return createRealSelfMultiplyAssignement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAssignementBlock createIntegerAssignementBlock() {
		IntegerAssignementBlockImpl integerAssignementBlock = new IntegerAssignementBlockImpl();
		return integerAssignementBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntInfEqual createIntInfEqual() {
		IntInfEqualImpl intInfEqual = new IntInfEqualImpl();
		return intInfEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSupEqual createIntSupEqual() {
		IntSupEqualImpl intSupEqual = new IntSupEqualImpl();
		return intSupEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealInfEqual createRealInfEqual() {
		RealInfEqualImpl realInfEqual = new RealInfEqualImpl();
		return realInfEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealSupEqual createRealSupEqual() {
		RealSupEqualImpl realSupEqual = new RealSupEqualImpl();
		return realSupEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSelfPlusAssignement createIntSelfPlusAssignement() {
		IntSelfPlusAssignementImpl intSelfPlusAssignement = new IntSelfPlusAssignementImpl();
		return intSelfPlusAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSelfMinusAssignement createIntSelfMinusAssignement() {
		IntSelfMinusAssignementImpl intSelfMinusAssignement = new IntSelfMinusAssignementImpl();
		return intSelfMinusAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSelfMultiplyAssignement createIntSelfMultiplyAssignement() {
		IntSelfMultiplyAssignementImpl intSelfMultiplyAssignement = new IntSelfMultiplyAssignementImpl();
		return intSelfMultiplyAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntSelfDivideAssignement createIntSelfDivideAssignement() {
		IntSelfDivideAssignementImpl intSelfDivideAssignement = new IntSelfDivideAssignementImpl();
		return intSelfDivideAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealSelfPlusAssignement createRealSelfPlusAssignement() {
		RealSelfPlusAssignementImpl realSelfPlusAssignement = new RealSelfPlusAssignementImpl();
		return realSelfPlusAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealSelfMinusAssignement createRealSelfMinusAssignement() {
		RealSelfMinusAssignementImpl realSelfMinusAssignement = new RealSelfMinusAssignementImpl();
		return realSelfMinusAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealSelfMultiplyAssignement createRealSelfMultiplyAssignement() {
		RealSelfMultiplyAssignementImpl realSelfMultiplyAssignement = new RealSelfMultiplyAssignementImpl();
		return realSelfMultiplyAssignement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditionExtensionPackage getEditionExtensionPackage() {
		return (EditionExtensionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EditionExtensionPackage getPackage() {
		return EditionExtensionPackage.eINSTANCE;
	}

} //EditionExtensionFactoryImpl
