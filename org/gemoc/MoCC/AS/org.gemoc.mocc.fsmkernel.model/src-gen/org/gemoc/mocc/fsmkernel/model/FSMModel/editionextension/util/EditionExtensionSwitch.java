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
package org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.util;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.PrimitiveElement;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryIntegerExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BinaryRealExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.BooleanExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.ClassicalExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.IntegerExpression;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClassicalExpression.RealExpression;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.BindableEntity;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ConcreteEntity;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gemoc.mocc.fsmkernel.model.FSMModel.AbstractAction;

import org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gemoc.mocc.fsmkernel.model.FSMModel.editionextension.EditionExtensionPackage
 * @generated
 */
public class EditionExtensionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EditionExtensionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditionExtensionSwitch() {
		if (modelPackage == null) {
			modelPackage = EditionExtensionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EditionExtensionPackage.INTEGER_ASSIGNEMENT_BLOCK: {
				IntegerAssignementBlock integerAssignementBlock = (IntegerAssignementBlock)theEObject;
				T result = caseIntegerAssignementBlock(integerAssignementBlock);
				if (result == null) result = caseAbstractAction(integerAssignementBlock);
				if (result == null) result = caseNamedElement(integerAssignementBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_INF_EQUAL: {
				IntInfEqual intInfEqual = (IntInfEqual)theEObject;
				T result = caseIntInfEqual(intInfEqual);
				if (result == null) result = caseBooleanExpression(intInfEqual);
				if (result == null) result = caseClassicalExpression(intInfEqual);
				if (result == null) result = casePrimitiveElement(intInfEqual);
				if (result == null) result = caseElement(intInfEqual);
				if (result == null) result = caseConcreteEntity(intInfEqual);
				if (result == null) result = caseBindableEntity(intInfEqual);
				if (result == null) result = caseNamedElement(intInfEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_SUP_EQUAL: {
				IntSupEqual intSupEqual = (IntSupEqual)theEObject;
				T result = caseIntSupEqual(intSupEqual);
				if (result == null) result = caseBooleanExpression(intSupEqual);
				if (result == null) result = caseClassicalExpression(intSupEqual);
				if (result == null) result = casePrimitiveElement(intSupEqual);
				if (result == null) result = caseElement(intSupEqual);
				if (result == null) result = caseConcreteEntity(intSupEqual);
				if (result == null) result = caseBindableEntity(intSupEqual);
				if (result == null) result = caseNamedElement(intSupEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.REAL_INF_EQUAL: {
				RealInfEqual realInfEqual = (RealInfEqual)theEObject;
				T result = caseRealInfEqual(realInfEqual);
				if (result == null) result = caseBooleanExpression(realInfEqual);
				if (result == null) result = caseClassicalExpression(realInfEqual);
				if (result == null) result = casePrimitiveElement(realInfEqual);
				if (result == null) result = caseElement(realInfEqual);
				if (result == null) result = caseConcreteEntity(realInfEqual);
				if (result == null) result = caseBindableEntity(realInfEqual);
				if (result == null) result = caseNamedElement(realInfEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.REAL_SUP_EQUAL: {
				RealSupEqual realSupEqual = (RealSupEqual)theEObject;
				T result = caseRealSupEqual(realSupEqual);
				if (result == null) result = caseBooleanExpression(realSupEqual);
				if (result == null) result = caseClassicalExpression(realSupEqual);
				if (result == null) result = casePrimitiveElement(realSupEqual);
				if (result == null) result = caseElement(realSupEqual);
				if (result == null) result = caseConcreteEntity(realSupEqual);
				if (result == null) result = caseBindableEntity(realSupEqual);
				if (result == null) result = caseNamedElement(realSupEqual);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_SELF_PLUS_ASSIGNEMENT: {
				IntSelfPlusAssignement intSelfPlusAssignement = (IntSelfPlusAssignement)theEObject;
				T result = caseIntSelfPlusAssignement(intSelfPlusAssignement);
				if (result == null) result = caseBinaryIntegerExpression(intSelfPlusAssignement);
				if (result == null) result = caseIntegerExpression(intSelfPlusAssignement);
				if (result == null) result = caseClassicalExpression(intSelfPlusAssignement);
				if (result == null) result = casePrimitiveElement(intSelfPlusAssignement);
				if (result == null) result = caseElement(intSelfPlusAssignement);
				if (result == null) result = caseConcreteEntity(intSelfPlusAssignement);
				if (result == null) result = caseBindableEntity(intSelfPlusAssignement);
				if (result == null) result = caseNamedElement(intSelfPlusAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_SELF_MINUS_ASSIGNEMENT: {
				IntSelfMinusAssignement intSelfMinusAssignement = (IntSelfMinusAssignement)theEObject;
				T result = caseIntSelfMinusAssignement(intSelfMinusAssignement);
				if (result == null) result = caseBinaryIntegerExpression(intSelfMinusAssignement);
				if (result == null) result = caseIntegerExpression(intSelfMinusAssignement);
				if (result == null) result = caseClassicalExpression(intSelfMinusAssignement);
				if (result == null) result = casePrimitiveElement(intSelfMinusAssignement);
				if (result == null) result = caseElement(intSelfMinusAssignement);
				if (result == null) result = caseConcreteEntity(intSelfMinusAssignement);
				if (result == null) result = caseBindableEntity(intSelfMinusAssignement);
				if (result == null) result = caseNamedElement(intSelfMinusAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_SELF_MULTIPLY_ASSIGNEMENT: {
				IntSelfMultiplyAssignement intSelfMultiplyAssignement = (IntSelfMultiplyAssignement)theEObject;
				T result = caseIntSelfMultiplyAssignement(intSelfMultiplyAssignement);
				if (result == null) result = caseBinaryIntegerExpression(intSelfMultiplyAssignement);
				if (result == null) result = caseIntegerExpression(intSelfMultiplyAssignement);
				if (result == null) result = caseClassicalExpression(intSelfMultiplyAssignement);
				if (result == null) result = casePrimitiveElement(intSelfMultiplyAssignement);
				if (result == null) result = caseElement(intSelfMultiplyAssignement);
				if (result == null) result = caseConcreteEntity(intSelfMultiplyAssignement);
				if (result == null) result = caseBindableEntity(intSelfMultiplyAssignement);
				if (result == null) result = caseNamedElement(intSelfMultiplyAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.INT_SELF_DIVIDE_ASSIGNEMENT: {
				IntSelfDivideAssignement intSelfDivideAssignement = (IntSelfDivideAssignement)theEObject;
				T result = caseIntSelfDivideAssignement(intSelfDivideAssignement);
				if (result == null) result = caseBinaryIntegerExpression(intSelfDivideAssignement);
				if (result == null) result = caseIntegerExpression(intSelfDivideAssignement);
				if (result == null) result = caseClassicalExpression(intSelfDivideAssignement);
				if (result == null) result = casePrimitiveElement(intSelfDivideAssignement);
				if (result == null) result = caseElement(intSelfDivideAssignement);
				if (result == null) result = caseConcreteEntity(intSelfDivideAssignement);
				if (result == null) result = caseBindableEntity(intSelfDivideAssignement);
				if (result == null) result = caseNamedElement(intSelfDivideAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.REAL_SELF_PLUS_ASSIGNEMENT: {
				RealSelfPlusAssignement realSelfPlusAssignement = (RealSelfPlusAssignement)theEObject;
				T result = caseRealSelfPlusAssignement(realSelfPlusAssignement);
				if (result == null) result = caseBinaryRealExpression(realSelfPlusAssignement);
				if (result == null) result = caseRealExpression(realSelfPlusAssignement);
				if (result == null) result = caseClassicalExpression(realSelfPlusAssignement);
				if (result == null) result = casePrimitiveElement(realSelfPlusAssignement);
				if (result == null) result = caseElement(realSelfPlusAssignement);
				if (result == null) result = caseConcreteEntity(realSelfPlusAssignement);
				if (result == null) result = caseBindableEntity(realSelfPlusAssignement);
				if (result == null) result = caseNamedElement(realSelfPlusAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.REAL_SELF_MINUS_ASSIGNEMENT: {
				RealSelfMinusAssignement realSelfMinusAssignement = (RealSelfMinusAssignement)theEObject;
				T result = caseRealSelfMinusAssignement(realSelfMinusAssignement);
				if (result == null) result = caseBinaryRealExpression(realSelfMinusAssignement);
				if (result == null) result = caseRealExpression(realSelfMinusAssignement);
				if (result == null) result = caseClassicalExpression(realSelfMinusAssignement);
				if (result == null) result = casePrimitiveElement(realSelfMinusAssignement);
				if (result == null) result = caseElement(realSelfMinusAssignement);
				if (result == null) result = caseConcreteEntity(realSelfMinusAssignement);
				if (result == null) result = caseBindableEntity(realSelfMinusAssignement);
				if (result == null) result = caseNamedElement(realSelfMinusAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EditionExtensionPackage.REAL_SELF_MULTIPLY_ASSIGNEMENT: {
				RealSelfMultiplyAssignement realSelfMultiplyAssignement = (RealSelfMultiplyAssignement)theEObject;
				T result = caseRealSelfMultiplyAssignement(realSelfMultiplyAssignement);
				if (result == null) result = caseBinaryRealExpression(realSelfMultiplyAssignement);
				if (result == null) result = caseRealExpression(realSelfMultiplyAssignement);
				if (result == null) result = caseClassicalExpression(realSelfMultiplyAssignement);
				if (result == null) result = casePrimitiveElement(realSelfMultiplyAssignement);
				if (result == null) result = caseElement(realSelfMultiplyAssignement);
				if (result == null) result = caseConcreteEntity(realSelfMultiplyAssignement);
				if (result == null) result = caseBindableEntity(realSelfMultiplyAssignement);
				if (result == null) result = caseNamedElement(realSelfMultiplyAssignement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Assignement Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Assignement Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerAssignementBlock(IntegerAssignementBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Inf Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Inf Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntInfEqual(IntInfEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Sup Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Sup Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntSupEqual(IntSupEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Inf Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Inf Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealInfEqual(RealInfEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Sup Equal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Sup Equal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealSupEqual(RealSupEqual object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Self Plus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Self Plus Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntSelfPlusAssignement(IntSelfPlusAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Self Minus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Self Minus Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntSelfMinusAssignement(IntSelfMinusAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Self Multiply Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Self Multiply Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntSelfMultiplyAssignement(IntSelfMultiplyAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Self Divide Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Self Divide Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntSelfDivideAssignement(IntSelfDivideAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Self Plus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Self Plus Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealSelfPlusAssignement(RealSelfPlusAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Self Minus Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Self Minus Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealSelfMinusAssignement(RealSelfMinusAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Self Multiply Assignement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Self Multiply Assignement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealSelfMultiplyAssignement(RealSelfMultiplyAssignement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAction(AbstractAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bindable Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bindable Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindableEntity(BindableEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteEntity(ConcreteEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveElement(PrimitiveElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classical Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classical Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassicalExpression(ClassicalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanExpression(BooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerExpression(IntegerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Integer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Integer Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryIntegerExpression(BinaryIntegerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealExpression(RealExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Real Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Real Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryRealExpression(BinaryRealExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EditionExtensionSwitch
