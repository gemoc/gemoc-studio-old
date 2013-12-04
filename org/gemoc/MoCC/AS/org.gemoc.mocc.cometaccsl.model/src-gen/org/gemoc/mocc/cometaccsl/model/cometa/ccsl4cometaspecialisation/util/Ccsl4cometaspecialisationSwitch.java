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
package org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification;
import org.gemoc.mocc.cometaccsl.model.cometa.ElementAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.MoCSystemSpecification;

import org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.*;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaAction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaGuard;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.OpaqueBlock;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.ClockAbstraction;
import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Action;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Guard;
import org.gemoc.mocc.cometaccsl.model.cometa.fsmdefinition.Trigger;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.ccsl4cometaspecialisation.Ccsl4cometaspecialisationPackage
 * @generated
 */
public class Ccsl4cometaspecialisationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Ccsl4cometaspecialisationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ccsl4cometaspecialisationSwitch() {
		if (modelPackage == null) {
			modelPackage = Ccsl4cometaspecialisationPackage.eINSTANCE;
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
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_CLOCK: {
				CCSL4CometaClock ccsl4CometaClock = (CCSL4CometaClock)theEObject;
				T result = caseCCSL4CometaClock(ccsl4CometaClock);
				if (result == null) result = caseClockAbstraction(ccsl4CometaClock);
				if (result == null) result = caseElementAbstraction(ccsl4CometaClock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_BLOCK_ABSTRACTION: {
				CCSL4CometaBlockAbstraction ccsl4CometaBlockAbstraction = (CCSL4CometaBlockAbstraction)theEObject;
				T result = caseCCSL4CometaBlockAbstraction(ccsl4CometaBlockAbstraction);
				if (result == null) result = caseOpaqueBlock(ccsl4CometaBlockAbstraction);
				if (result == null) result = caseElementAbstraction(ccsl4CometaBlockAbstraction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_TIME_CONSTRAINT: {
				CCSL4CometaTimeConstraint ccsl4CometaTimeConstraint = (CCSL4CometaTimeConstraint)theEObject;
				T result = caseCCSL4CometaTimeConstraint(ccsl4CometaTimeConstraint);
				if (result == null) result = caseTimeConstraint(ccsl4CometaTimeConstraint);
				if (result == null) result = caseElementAbstraction(ccsl4CometaTimeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMPLEX_TRIGGER: {
				CCSL4CometaComplexTrigger ccsl4CometaComplexTrigger = (CCSL4CometaComplexTrigger)theEObject;
				T result = caseCCSL4CometaComplexTrigger(ccsl4CometaComplexTrigger);
				if (result == null) result = caseTrigger(ccsl4CometaComplexTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_COMETA_SYSTEM_SPECIFICATION: {
				CCSL4CometaCometaSystemSpecification ccsl4CometaCometaSystemSpecification = (CCSL4CometaCometaSystemSpecification)theEObject;
				T result = caseCCSL4CometaCometaSystemSpecification(ccsl4CometaCometaSystemSpecification);
				if (result == null) result = caseCometaSystemSpecification(ccsl4CometaCometaSystemSpecification);
				if (result == null) result = caseMoCSystemSpecification(ccsl4CometaCometaSystemSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_GUARD: {
				CCSL4CometaGuard ccsl4CometaGuard = (CCSL4CometaGuard)theEObject;
				T result = caseCCSL4CometaGuard(ccsl4CometaGuard);
				if (result == null) result = caseCometaGuard(ccsl4CometaGuard);
				if (result == null) result = caseGuard(ccsl4CometaGuard);
				if (result == null) result = caseOpaqueBlock(ccsl4CometaGuard);
				if (result == null) result = caseElementAbstraction(ccsl4CometaGuard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Ccsl4cometaspecialisationPackage.CCSL4_COMETA_ACTION: {
				CCSL4CometaAction ccsl4CometaAction = (CCSL4CometaAction)theEObject;
				T result = caseCCSL4CometaAction(ccsl4CometaAction);
				if (result == null) result = caseCometaAction(ccsl4CometaAction);
				if (result == null) result = caseAction(ccsl4CometaAction);
				if (result == null) result = caseOpaqueBlock(ccsl4CometaAction);
				if (result == null) result = caseElementAbstraction(ccsl4CometaAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Clock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Clock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaClock(CCSL4CometaClock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Block Abstraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Block Abstraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaBlockAbstraction(CCSL4CometaBlockAbstraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Time Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaTimeConstraint(CCSL4CometaTimeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Complex Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Complex Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaComplexTrigger(CCSL4CometaComplexTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Cometa System Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Cometa System Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaCometaSystemSpecification(CCSL4CometaCometaSystemSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaGuard(CCSL4CometaGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CCSL4 Cometa Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CCSL4 Cometa Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCCSL4CometaAction(CCSL4CometaAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Abstraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Abstraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementAbstraction(ElementAbstraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clock Abstraction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clock Abstraction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClockAbstraction(ClockAbstraction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueBlock(OpaqueBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeConstraint(TimeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrigger(Trigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mo CSystem Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mo CSystem Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoCSystemSpecification(MoCSystemSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCometaSystemSpecification(CometaSystemSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuard(Guard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cometa Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cometa Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCometaGuard(CometaGuard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cometa Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cometa Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCometaAction(CometaAction object) {
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

} //Ccsl4cometaspecialisationSwitch
