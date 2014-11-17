/**
 */
package sigpmlextended.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see sigpmlextended.SigpmlextendedPackage
 * @generated
 */
public class SigpmlextendedAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SigpmlextendedPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlextendedAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SigpmlextendedPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SigpmlextendedSwitch<Adapter> modelSwitch =
		new SigpmlextendedSwitch<Adapter>() {
			@Override
			public Adapter caseApplication(Application object) {
				return createApplicationAdapter();
			}
			@Override
			public Adapter caseAgent(Agent object) {
				return createAgentAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseInputPort(InputPort object) {
				return createInputPortAdapter();
			}
			@Override
			public Adapter caseOutputPort(OutputPort object) {
				return createOutputPortAdapter();
			}
			@Override
			public Adapter casePlace(Place object) {
				return createPlaceAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseHWRessource(HWRessource object) {
				return createHWRessourceAdapter();
			}
			@Override
			public Adapter caseHWComputationalResource(HWComputationalResource object) {
				return createHWComputationalResourceAdapter();
			}
			@Override
			public Adapter caseHWStorageResource(HWStorageResource object) {
				return createHWStorageResourceAdapter();
			}
			@Override
			public Adapter caseHWCommunicationResource(HWCommunicationResource object) {
				return createHWCommunicationResourceAdapter();
			}
			@Override
			public Adapter caseHWPlatform(HWPlatform object) {
				return createHWPlatformAdapter();
			}
			@Override
			public Adapter caseSystem(sigpmlextended.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseSigpml_NamedElement(org.gemoc.sigpml.NamedElement object) {
				return createSigpml_NamedElementAdapter();
			}
			@Override
			public Adapter caseSigpml_Application(org.gemoc.sigpml.Application object) {
				return createSigpml_ApplicationAdapter();
			}
			@Override
			public Adapter caseSigpml_Agent(org.gemoc.sigpml.Agent object) {
				return createSigpml_AgentAdapter();
			}
			@Override
			public Adapter caseSigpml_Port(org.gemoc.sigpml.Port object) {
				return createSigpml_PortAdapter();
			}
			@Override
			public Adapter caseSigpml_InputPort(org.gemoc.sigpml.InputPort object) {
				return createSigpml_InputPortAdapter();
			}
			@Override
			public Adapter caseSigpml_OutputPort(org.gemoc.sigpml.OutputPort object) {
				return createSigpml_OutputPortAdapter();
			}
			@Override
			public Adapter caseSigpml_Place(org.gemoc.sigpml.Place object) {
				return createSigpml_PlaceAdapter();
			}
			@Override
			public Adapter caseSigpml_HWRessource(org.gemoc.sigpml.HWRessource object) {
				return createSigpml_HWRessourceAdapter();
			}
			@Override
			public Adapter caseSigpml_HWComputationalResource(org.gemoc.sigpml.HWComputationalResource object) {
				return createSigpml_HWComputationalResourceAdapter();
			}
			@Override
			public Adapter caseSigpml_HWStorageResource(org.gemoc.sigpml.HWStorageResource object) {
				return createSigpml_HWStorageResourceAdapter();
			}
			@Override
			public Adapter caseSigpml_HWCommunicationResource(org.gemoc.sigpml.HWCommunicationResource object) {
				return createSigpml_HWCommunicationResourceAdapter();
			}
			@Override
			public Adapter caseSigpml_HWPlatform(org.gemoc.sigpml.HWPlatform object) {
				return createSigpml_HWPlatformAdapter();
			}
			@Override
			public Adapter caseSigpml_System(org.gemoc.sigpml.System object) {
				return createSigpml_SystemAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.Application
	 * @generated
	 */
	public Adapter createApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.Agent
	 * @generated
	 */
	public Adapter createAgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.InputPort
	 * @generated
	 */
	public Adapter createInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.OutputPort
	 * @generated
	 */
	public Adapter createOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.Place
	 * @generated
	 */
	public Adapter createPlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.HWRessource <em>HW Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.HWRessource
	 * @generated
	 */
	public Adapter createHWRessourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.HWComputationalResource <em>HW Computational Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.HWComputationalResource
	 * @generated
	 */
	public Adapter createHWComputationalResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.HWStorageResource <em>HW Storage Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.HWStorageResource
	 * @generated
	 */
	public Adapter createHWStorageResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.HWCommunicationResource <em>HW Communication Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.HWCommunicationResource
	 * @generated
	 */
	public Adapter createHWCommunicationResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.HWPlatform <em>HW Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.HWPlatform
	 * @generated
	 */
	public Adapter createHWPlatformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link sigpmlextended.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see sigpmlextended.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.NamedElement
	 * @generated
	 */
	public Adapter createSigpml_NamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.Application
	 * @generated
	 */
	public Adapter createSigpml_ApplicationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.Agent
	 * @generated
	 */
	public Adapter createSigpml_AgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.Port
	 * @generated
	 */
	public Adapter createSigpml_PortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.InputPort
	 * @generated
	 */
	public Adapter createSigpml_InputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.OutputPort
	 * @generated
	 */
	public Adapter createSigpml_OutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.Place
	 * @generated
	 */
	public Adapter createSigpml_PlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.HWRessource <em>HW Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.HWRessource
	 * @generated
	 */
	public Adapter createSigpml_HWRessourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.HWComputationalResource <em>HW Computational Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.HWComputationalResource
	 * @generated
	 */
	public Adapter createSigpml_HWComputationalResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.HWStorageResource <em>HW Storage Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.HWStorageResource
	 * @generated
	 */
	public Adapter createSigpml_HWStorageResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.HWCommunicationResource <em>HW Communication Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.HWCommunicationResource
	 * @generated
	 */
	public Adapter createSigpml_HWCommunicationResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.HWPlatform <em>HW Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.HWPlatform
	 * @generated
	 */
	public Adapter createSigpml_HWPlatformAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.sigpml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.sigpml.System
	 * @generated
	 */
	public Adapter createSigpml_SystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SigpmlextendedAdapterFactory
