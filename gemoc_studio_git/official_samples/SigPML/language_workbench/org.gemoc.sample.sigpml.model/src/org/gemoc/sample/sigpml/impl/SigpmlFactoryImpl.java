/**
 */
package org.gemoc.sample.sigpml.impl;

import com.google.common.collect.LinkedListMultimap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.sample.sigpml.Agent;
import org.gemoc.sample.sigpml.Application;
import org.gemoc.sample.sigpml.HWCommunicationResource;
import org.gemoc.sample.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.InputPort;
import org.gemoc.sample.sigpml.OutputPort;
import org.gemoc.sample.sigpml.Place;
import org.gemoc.sample.sigpml.SigpmlFactory;
import org.gemoc.sample.sigpml.SigpmlPackage;
import org.gemoc.sample.sigpml.sizeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SigpmlFactoryImpl extends EFactoryImpl implements SigpmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SigpmlFactory init() {
		try {
			SigpmlFactory theSigpmlFactory = (SigpmlFactory)EPackage.Registry.INSTANCE.getEFactory(SigpmlPackage.eNS_URI);
			if (theSigpmlFactory != null) {
				return theSigpmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SigpmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlFactoryImpl() {
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
			case SigpmlPackage.APPLICATION: return createApplication();
			case SigpmlPackage.AGENT: return createAgent();
			case SigpmlPackage.INPUT_PORT: return createInputPort();
			case SigpmlPackage.OUTPUT_PORT: return createOutputPort();
			case SigpmlPackage.PLACE: return createPlace();
			case SigpmlPackage.HW_COMPUTATIONAL_RESOURCE: return createHWComputationalResource();
			case SigpmlPackage.HW_STORAGE_RESOURCE: return createHWStorageResource();
			case SigpmlPackage.HW_COMMUNICATION_RESOURCE: return createHWCommunicationResource();
			case SigpmlPackage.HW_PLATFORM: return createHWPlatform();
			case SigpmlPackage.SYSTEM: return createSystem();
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
			case SigpmlPackage.SIZE_TYPE:
				return createsizeTypeFromString(eDataType, initialValue);
			case SigpmlPackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
			case SigpmlPackage.LINKED_LIST_MULTIMAP:
				return createLinkedListMultimapFromString(eDataType, initialValue);
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
			case SigpmlPackage.SIZE_TYPE:
				return convertsizeTypeToString(eDataType, instanceValue);
			case SigpmlPackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			case SigpmlPackage.LINKED_LIST_MULTIMAP:
				return convertLinkedListMultimapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Application createApplication() {
		ApplicationImpl application = new ApplicationImpl();
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Agent createAgent() {
		AgentImpl agent = new AgentImpl();
		return agent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Place createPlace() {
		PlaceImpl place = new PlaceImpl();
		return place;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWComputationalResource createHWComputationalResource() {
		HWComputationalResourceImpl hwComputationalResource = new HWComputationalResourceImpl();
		return hwComputationalResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWStorageResource createHWStorageResource() {
		HWStorageResourceImpl hwStorageResource = new HWStorageResourceImpl();
		return hwStorageResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWCommunicationResource createHWCommunicationResource() {
		HWCommunicationResourceImpl hwCommunicationResource = new HWCommunicationResourceImpl();
		return hwCommunicationResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWPlatform createHWPlatform() {
		HWPlatformImpl hwPlatform = new HWPlatformImpl();
		return hwPlatform;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.gemoc.sample.sigpml.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sizeType createsizeTypeFromString(EDataType eDataType, String initialValue) {
		sizeType result = sizeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertsizeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkedListMultimap createLinkedListMultimapFromString(EDataType eDataType, String initialValue) {
		return (LinkedListMultimap)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLinkedListMultimapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlPackage getSigpmlPackage() {
		return (SigpmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SigpmlPackage getPackage() {
		return SigpmlPackage.eINSTANCE;
	}

} //SigpmlFactoryImpl
