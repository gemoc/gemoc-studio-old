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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.*;

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
 * @see org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage
 * @generated
 */
public class CometastructureSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CometastructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CometastructureSwitch() {
		if (modelPackage == null) {
			modelPackage = CometastructurePackage.eINSTANCE;
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
			case CometastructurePackage.STRUCTURE_CONTAINER: {
				StructureContainer structureContainer = (StructureContainer)theEObject;
				T result = caseStructureContainer(structureContainer);
				if (result == null) result = caseNamedElement(structureContainer);
				if (result == null) result = caseContainer(structureContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.MO_CCONNECTOR: {
				MoCConnector moCConnector = (MoCConnector)theEObject;
				T result = caseMoCConnector(moCConnector);
				if (result == null) result = caseStructureElement(moCConnector);
				if (result == null) result = caseNamedElement(moCConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.MO_CCOMPONENT: {
				MoCComponent moCComponent = (MoCComponent)theEObject;
				T result = caseMoCComponent(moCComponent);
				if (result == null) result = caseStructureElement(moCComponent);
				if (result == null) result = caseNamedElement(moCComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.MO_CPORT: {
				MoCPort moCPort = (MoCPort)theEObject;
				T result = caseMoCPort(moCPort);
				if (result == null) result = caseStructureElement(moCPort);
				if (result == null) result = caseNamedElement(moCPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.STRUCTURE_ELEMENT: {
				StructureElement structureElement = (StructureElement)theEObject;
				T result = caseStructureElement(structureElement);
				if (result == null) result = caseNamedElement(structureElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.CONTAINER: {
				Container container = (Container)theEObject;
				T result = caseContainer(container);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.COMPOSITE_COMPONENT: {
				CompositeComponent compositeComponent = (CompositeComponent)theEObject;
				T result = caseCompositeComponent(compositeComponent);
				if (result == null) result = caseMoCComponent(compositeComponent);
				if (result == null) result = caseContainer(compositeComponent);
				if (result == null) result = caseStructureElement(compositeComponent);
				if (result == null) result = caseNamedElement(compositeComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.BASIC_COMPONENT: {
				BasicComponent basicComponent = (BasicComponent)theEObject;
				T result = caseBasicComponent(basicComponent);
				if (result == null) result = caseMoCComponent(basicComponent);
				if (result == null) result = caseStructureElement(basicComponent);
				if (result == null) result = caseNamedElement(basicComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.STRUCTURE_LIBRARY: {
				StructureLibrary structureLibrary = (StructureLibrary)theEObject;
				T result = caseStructureLibrary(structureLibrary);
				if (result == null) result = caseNamedElement(structureLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CometastructurePackage.PART: {
				Part part = (Part)theEObject;
				T result = casePart(part);
				if (result == null) result = caseNamedElement(part);
				if (result == null) result = caseContainer(part);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureContainer(StructureContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mo CConnector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mo CConnector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoCConnector(MoCConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mo CComponent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mo CComponent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoCComponent(MoCComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mo CPort</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mo CPort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoCPort(MoCPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureElement(StructureElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer(Container object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeComponent(CompositeComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicComponent(BasicComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructureLibrary(StructureLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePart(Part object) {
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

} //CometastructureSwitch
