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

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.BasicTypePackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.CCSLModelPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelExpression.KernelExpressionPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.KernelRelation.KernelRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.PrimitivesTypeValue.PrimitivesTypeValuePackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gemoc.mocc.fsmkernel.model.FSMModel.FSMModelPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionFactory;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntInfEqual;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfDivideAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMinusAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfMultiplyAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSelfPlusAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntSupEqual;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.IntegerAssignementBlock;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealInfEqual;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMinusAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfMultiplyAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSelfPlusAssignement;
import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.RealSupEqual;
import org.gemoc.mocc.fsmkernel.model.FSMModel.impl.FSMModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditionExtensionPackageImpl extends EPackageImpl implements EditionExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerAssignementBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intInfEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSupEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realInfEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realSupEqualEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSelfPlusAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSelfMinusAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSelfMultiplyAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intSelfDivideAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realSelfPlusAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realSelfMinusAssignementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realSelfMultiplyAssignementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EditionExtensionPackageImpl() {
		super(eNS_URI, EditionExtensionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EditionExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated NOT
	 */
	public static EditionExtensionPackage init() {
		if (isInited) return (EditionExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(EditionExtensionPackage.eNS_URI);

		// Obtain or create and register package
		EditionExtensionPackageImpl theEditionExtensionPackage = (EditionExtensionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EditionExtensionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EditionExtensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TimeModelPackage.eINSTANCE.eClass();
		BasicTypePackage.eINSTANCE.eClass();
		CCSLModelPackage.eINSTANCE.eClass();
		ClassicalExpressionPackage.eINSTANCE.eClass();
		ClockExpressionAndRelationPackage.eINSTANCE.eClass();
		KernelExpressionPackage.eINSTANCE.eClass();
		KernelRelationPackage.eINSTANCE.eClass();
		PrimitivesTypeValuePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		FSMModelPackageImpl theFSMModelPackage = (FSMModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FSMModelPackage.eNS_URI) instanceof FSMModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FSMModelPackage.eNS_URI) : FSMModelPackage.eINSTANCE);

		// Create package meta-data objects
		theEditionExtensionPackage.createPackageContents();
		theFSMModelPackage.createPackageContents();

		// Initialize created meta-data
		theEditionExtensionPackage.initializePackageContents();
		theFSMModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEditionExtensionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EditionExtensionPackage.eNS_URI, theEditionExtensionPackage);
		return theEditionExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerAssignementBlock() {
		return integerAssignementBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerAssignementBlock_Actions() {
		return (EReference)integerAssignementBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntInfEqual() {
		return intInfEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntInfEqual_LeftValue() {
		return (EReference)intInfEqualEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntInfEqual_RightValue() {
		return (EReference)intInfEqualEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSupEqual() {
		return intSupEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntSupEqual_LeftValue() {
		return (EReference)intSupEqualEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntSupEqual_RightValue() {
		return (EReference)intSupEqualEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealInfEqual() {
		return realInfEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealInfEqual_LeftValue() {
		return (EReference)realInfEqualEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealInfEqual_RightValue() {
		return (EReference)realInfEqualEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealSupEqual() {
		return realSupEqualEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealSupEqual_LeftValue() {
		return (EReference)realSupEqualEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRealSupEqual_RightValue() {
		return (EReference)realSupEqualEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSelfPlusAssignement() {
		return intSelfPlusAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSelfMinusAssignement() {
		return intSelfMinusAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSelfMultiplyAssignement() {
		return intSelfMultiplyAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntSelfDivideAssignement() {
		return intSelfDivideAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealSelfPlusAssignement() {
		return realSelfPlusAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealSelfMinusAssignement() {
		return realSelfMinusAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealSelfMultiplyAssignement() {
		return realSelfMultiplyAssignementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditionExtensionFactory getEditionExtensionFactory() {
		return (EditionExtensionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		integerAssignementBlockEClass = createEClass(INTEGER_ASSIGNEMENT_BLOCK);
		createEReference(integerAssignementBlockEClass, INTEGER_ASSIGNEMENT_BLOCK__ACTIONS);

		intInfEqualEClass = createEClass(INT_INF_EQUAL);
		createEReference(intInfEqualEClass, INT_INF_EQUAL__LEFT_VALUE);
		createEReference(intInfEqualEClass, INT_INF_EQUAL__RIGHT_VALUE);

		intSupEqualEClass = createEClass(INT_SUP_EQUAL);
		createEReference(intSupEqualEClass, INT_SUP_EQUAL__LEFT_VALUE);
		createEReference(intSupEqualEClass, INT_SUP_EQUAL__RIGHT_VALUE);

		realInfEqualEClass = createEClass(REAL_INF_EQUAL);
		createEReference(realInfEqualEClass, REAL_INF_EQUAL__LEFT_VALUE);
		createEReference(realInfEqualEClass, REAL_INF_EQUAL__RIGHT_VALUE);

		realSupEqualEClass = createEClass(REAL_SUP_EQUAL);
		createEReference(realSupEqualEClass, REAL_SUP_EQUAL__LEFT_VALUE);
		createEReference(realSupEqualEClass, REAL_SUP_EQUAL__RIGHT_VALUE);

		intSelfPlusAssignementEClass = createEClass(INT_SELF_PLUS_ASSIGNEMENT);

		intSelfMinusAssignementEClass = createEClass(INT_SELF_MINUS_ASSIGNEMENT);

		intSelfMultiplyAssignementEClass = createEClass(INT_SELF_MULTIPLY_ASSIGNEMENT);

		intSelfDivideAssignementEClass = createEClass(INT_SELF_DIVIDE_ASSIGNEMENT);

		realSelfPlusAssignementEClass = createEClass(REAL_SELF_PLUS_ASSIGNEMENT);

		realSelfMinusAssignementEClass = createEClass(REAL_SELF_MINUS_ASSIGNEMENT);

		realSelfMultiplyAssignementEClass = createEClass(REAL_SELF_MULTIPLY_ASSIGNEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		FSMModelPackage theFSMModelPackage = (FSMModelPackage)EPackage.Registry.INSTANCE.getEPackage(FSMModelPackage.eNS_URI);
		TimeModelPackage theTimeModelPackage = (TimeModelPackage)EPackage.Registry.INSTANCE.getEPackage(TimeModelPackage.eNS_URI);
		ClassicalExpressionPackage theClassicalExpressionPackage = (ClassicalExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(ClassicalExpressionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		integerAssignementBlockEClass.getESuperTypes().add(theFSMModelPackage.getAbstractAction());
		integerAssignementBlockEClass.getESuperTypes().add(theTimeModelPackage.getNamedElement());
		intInfEqualEClass.getESuperTypes().add(theClassicalExpressionPackage.getBooleanExpression());
		intSupEqualEClass.getESuperTypes().add(theClassicalExpressionPackage.getBooleanExpression());
		realInfEqualEClass.getESuperTypes().add(theClassicalExpressionPackage.getBooleanExpression());
		realSupEqualEClass.getESuperTypes().add(theClassicalExpressionPackage.getBooleanExpression());
		intSelfPlusAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		intSelfMinusAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		intSelfMultiplyAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		intSelfDivideAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryIntegerExpression());
		realSelfPlusAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryRealExpression());
		realSelfMinusAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryRealExpression());
		realSelfMultiplyAssignementEClass.getESuperTypes().add(theClassicalExpressionPackage.getBinaryRealExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(integerAssignementBlockEClass, IntegerAssignementBlock.class, "IntegerAssignementBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntegerAssignementBlock_Actions(), theFSMModelPackage.getIntegerAssignement(), null, "actions", null, 1, -1, IntegerAssignementBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intInfEqualEClass, IntInfEqual.class, "IntInfEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntInfEqual_LeftValue(), theClassicalExpressionPackage.getIntegerExpression(), null, "leftValue", null, 1, 1, IntInfEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntInfEqual_RightValue(), theClassicalExpressionPackage.getIntegerExpression(), null, "rightValue", null, 1, 1, IntInfEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intSupEqualEClass, IntSupEqual.class, "IntSupEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntSupEqual_LeftValue(), theClassicalExpressionPackage.getIntegerExpression(), null, "leftValue", null, 1, 1, IntSupEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntSupEqual_RightValue(), theClassicalExpressionPackage.getIntegerExpression(), null, "rightValue", null, 1, 1, IntSupEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realInfEqualEClass, RealInfEqual.class, "RealInfEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRealInfEqual_LeftValue(), theClassicalExpressionPackage.getRealExpression(), null, "leftValue", null, 1, 1, RealInfEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealInfEqual_RightValue(), theClassicalExpressionPackage.getRealExpression(), null, "rightValue", null, 1, 1, RealInfEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realSupEqualEClass, RealSupEqual.class, "RealSupEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRealSupEqual_LeftValue(), theClassicalExpressionPackage.getRealExpression(), null, "leftValue", null, 1, 1, RealSupEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRealSupEqual_RightValue(), theClassicalExpressionPackage.getRealExpression(), null, "rightValue", null, 1, 1, RealSupEqual.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intSelfPlusAssignementEClass, IntSelfPlusAssignement.class, "IntSelfPlusAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intSelfMinusAssignementEClass, IntSelfMinusAssignement.class, "IntSelfMinusAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intSelfMultiplyAssignementEClass, IntSelfMultiplyAssignement.class, "IntSelfMultiplyAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intSelfDivideAssignementEClass, IntSelfDivideAssignement.class, "IntSelfDivideAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realSelfPlusAssignementEClass, RealSelfPlusAssignement.class, "RealSelfPlusAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realSelfMinusAssignementEClass, RealSelfMinusAssignement.class, "RealSelfMinusAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(realSelfMultiplyAssignementEClass, RealSelfMultiplyAssignement.class, "RealSelfMultiplyAssignement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EditionExtensionPackageImpl
