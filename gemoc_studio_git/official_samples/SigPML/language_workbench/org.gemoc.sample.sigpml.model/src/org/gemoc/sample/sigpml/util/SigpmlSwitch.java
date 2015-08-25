/**
 */
package org.gemoc.sample.sigpml.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gemoc.sample.sigpml.Agent;
import org.gemoc.sample.sigpml.Application;
import org.gemoc.sample.sigpml.HWCommunicationResource;
import org.gemoc.sample.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.HWRessource;
import org.gemoc.sample.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.InputPort;
import org.gemoc.sample.sigpml.NamedElement;
import org.gemoc.sample.sigpml.OutputPort;
import org.gemoc.sample.sigpml.Place;
import org.gemoc.sample.sigpml.Port;
import org.gemoc.sample.sigpml.SigpmlPackage;

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
 * @see org.gemoc.sample.sigpml.SigpmlPackage
 * @generated
 */
public class SigpmlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SigpmlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlSwitch() {
		if (modelPackage == null) {
			modelPackage = SigpmlPackage.eINSTANCE;
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
			case SigpmlPackage.APPLICATION: {
				Application application = (Application)theEObject;
				T result = caseApplication(application);
				if (result == null) result = caseNamedElement(application);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.AGENT: {
				Agent agent = (Agent)theEObject;
				T result = caseAgent(agent);
				if (result == null) result = caseNamedElement(agent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseNamedElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.INPUT_PORT: {
				InputPort inputPort = (InputPort)theEObject;
				T result = caseInputPort(inputPort);
				if (result == null) result = casePort(inputPort);
				if (result == null) result = caseNamedElement(inputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.OUTPUT_PORT: {
				OutputPort outputPort = (OutputPort)theEObject;
				T result = caseOutputPort(outputPort);
				if (result == null) result = casePort(outputPort);
				if (result == null) result = caseNamedElement(outputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.PLACE: {
				Place place = (Place)theEObject;
				T result = casePlace(place);
				if (result == null) result = caseNamedElement(place);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.HW_RESSOURCE: {
				HWRessource hwRessource = (HWRessource)theEObject;
				T result = caseHWRessource(hwRessource);
				if (result == null) result = caseNamedElement(hwRessource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE: {
				HWComputationalResource hwComputationalResource = (HWComputationalResource)theEObject;
				T result = caseHWComputationalResource(hwComputationalResource);
				if (result == null) result = caseHWRessource(hwComputationalResource);
				if (result == null) result = caseNamedElement(hwComputationalResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.HW_STORAGE_RESOURCE: {
				HWStorageResource hwStorageResource = (HWStorageResource)theEObject;
				T result = caseHWStorageResource(hwStorageResource);
				if (result == null) result = caseHWRessource(hwStorageResource);
				if (result == null) result = caseNamedElement(hwStorageResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.HW_COMMUNICATION_RESOURCE: {
				HWCommunicationResource hwCommunicationResource = (HWCommunicationResource)theEObject;
				T result = caseHWCommunicationResource(hwCommunicationResource);
				if (result == null) result = caseHWRessource(hwCommunicationResource);
				if (result == null) result = caseNamedElement(hwCommunicationResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.HW_PLATFORM: {
				HWPlatform hwPlatform = (HWPlatform)theEObject;
				T result = caseHWPlatform(hwPlatform);
				if (result == null) result = caseNamedElement(hwPlatform);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SigpmlPackage.SYSTEM: {
				org.gemoc.sample.sigpml.System system = (org.gemoc.sample.sigpml.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseNamedElement(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplication(Application object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Agent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAgent(Agent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPort(InputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPort(OutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Place</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Place</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlace(Place object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>HW Ressource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Ressource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWRessource(HWRessource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HW Computational Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Computational Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWComputationalResource(HWComputationalResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HW Storage Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Storage Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWStorageResource(HWStorageResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HW Communication Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Communication Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWCommunicationResource(HWCommunicationResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HW Platform</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HW Platform</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHWPlatform(HWPlatform object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(org.gemoc.sample.sigpml.System object) {
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

} //SigpmlSwitch
