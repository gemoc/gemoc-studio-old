/**
 */
package sigpmlextended.impl;

import cnrs.luchogie.up.SwingPlotter;

import cnrs.luchogie.up.data.Figure;

import com.google.common.collect.LinkedListMultimap;

import java.util.ArrayList;

import javax.swing.JFrame;

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
import sigpmlextended.HWRessource;
import sigpmlextended.HWStorageResource;
import sigpmlextended.InputPort;
import sigpmlextended.NamedElement;
import sigpmlextended.OutputPort;
import sigpmlextended.Place;
import sigpmlextended.Port;
import sigpmlextended.SigpmlextendedFactory;
import sigpmlextended.SigpmlextendedPackage;

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
			case SigpmlextendedPackage.PORT: return createPort();
			case SigpmlextendedPackage.INPUT_PORT: return createInputPort();
			case SigpmlextendedPackage.OUTPUT_PORT: return createOutputPort();
			case SigpmlextendedPackage.PLACE: return createPlace();
			case SigpmlextendedPackage.NAMED_ELEMENT: return createNamedElement();
			case SigpmlextendedPackage.HW_RESSOURCE: return createHWRessource();
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
			case SigpmlextendedPackage.SWING_PLOTTER:
				return createSwingPlotterFromString(eDataType, initialValue);
			case SigpmlextendedPackage.JFRAME:
				return createJFrameFromString(eDataType, initialValue);
			case SigpmlextendedPackage.FIGURE:
				return createFigureFromString(eDataType, initialValue);
			case SigpmlextendedPackage.ARRAY_LIST:
				return createArrayListFromString(eDataType, initialValue);
			case SigpmlextendedPackage.LINKED_LIST_MULTIMAP:
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
			case SigpmlextendedPackage.SWING_PLOTTER:
				return convertSwingPlotterToString(eDataType, instanceValue);
			case SigpmlextendedPackage.JFRAME:
				return convertJFrameToString(eDataType, instanceValue);
			case SigpmlextendedPackage.FIGURE:
				return convertFigureToString(eDataType, instanceValue);
			case SigpmlextendedPackage.ARRAY_LIST:
				return convertArrayListToString(eDataType, instanceValue);
			case SigpmlextendedPackage.LINKED_LIST_MULTIMAP:
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
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
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
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HWRessource createHWRessource() {
		HWRessourceImpl hwRessource = new HWRessourceImpl();
		return hwRessource;
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
	public Figure createFigureFromString(EDataType eDataType, String initialValue) {
		return (Figure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFigureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFrame createJFrameFromString(EDataType eDataType, String initialValue) {
		return (JFrame)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJFrameToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwingPlotter createSwingPlotterFromString(EDataType eDataType, String initialValue) {
		return (SwingPlotter)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSwingPlotterToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayList createArrayListFromString(EDataType eDataType, String initialValue) {
		return (ArrayList)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArrayListToString(EDataType eDataType, Object instanceValue) {
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
