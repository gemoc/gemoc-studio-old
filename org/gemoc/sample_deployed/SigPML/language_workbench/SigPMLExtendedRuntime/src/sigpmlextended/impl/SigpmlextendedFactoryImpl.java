/**
 */
package sigpmlextended.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import sigpmlextended.Agent;
import sigpmlextended.Application;
import sigpmlextended.HWCommunicationResource;
import sigpmlextended.HWComputationalResource;
import sigpmlextended.HWPlatform;
import sigpmlextended.HWStorageResource;
import sigpmlextended.InputPort;
import sigpmlextended.OutputPort;
import sigpmlextended.Place;
import sigpmlextended.SigpmlextendedFactory;
import sigpmlextended.SigpmlextendedPackage;
import sigpmlextended.sizeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SigpmlextendedFactoryImpl extends EFactoryImpl implements SigpmlextendedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SigpmlextendedFactory init() {
		try {
			SigpmlextendedFactory theSigpmlextendedFactory = (SigpmlextendedFactory)EPackage.Registry.INSTANCE.getEFactory(SigpmlextendedPackage.eNS_URI);
			if (theSigpmlextendedFactory != null) {
				return theSigpmlextendedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SigpmlextendedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlextendedFactoryImpl() {
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
			case SigpmlextendedPackage.APPLICATION: return createApplication();
			case SigpmlextendedPackage.AGENT: return createAgent();
			case SigpmlextendedPackage.INPUT_PORT: return createInputPort();
			case SigpmlextendedPackage.OUTPUT_PORT: return createOutputPort();
			case SigpmlextendedPackage.PLACE: return createPlace();
			case SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE: return createHWComputationalResource();
			case SigpmlextendedPackage.HW_STORAGE_RESOURCE: return createHWStorageResource();
			case SigpmlextendedPackage.HW_COMMUNICATION_RESOURCE: return createHWCommunicationResource();
			case SigpmlextendedPackage.HW_PLATFORM: return createHWPlatform();
			case SigpmlextendedPackage.SYSTEM: return createSystem();
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
			case SigpmlextendedPackage.SIZE_TYPE:
				return createsizeTypeFromString(eDataType, initialValue);
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
			case SigpmlextendedPackage.SIZE_TYPE:
				return convertsizeTypeToString(eDataType, instanceValue);
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
	public sigpmlextended.System createSystem() {
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
	public SigpmlextendedPackage getSigpmlextendedPackage() {
		return (SigpmlextendedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SigpmlextendedPackage getPackage() {
		return SigpmlextendedPackage.eINSTANCE;
	}

} //SigpmlextendedFactoryImpl
