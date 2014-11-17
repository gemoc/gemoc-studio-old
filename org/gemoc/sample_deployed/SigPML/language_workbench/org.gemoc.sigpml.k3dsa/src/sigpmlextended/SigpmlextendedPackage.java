/**
 */
package sigpmlextended;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.gemoc.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see sigpmlextended.SigpmlextendedFactory
 * @model kind="package"
 * @generated
 */
public interface SigpmlextendedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sigpmlextended";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.sigpml.model/1.0/extended";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sigpmlextended";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SigpmlextendedPackage eINSTANCE = sigpmlextended.impl.SigpmlextendedPackageImpl.init();

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.ApplicationImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = SigpmlPackage.APPLICATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Agents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_AGENTS = SigpmlPackage.APPLICATION__OWNED_AGENTS;

	/**
	 * The feature id for the '<em><b>Owned Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__OWNED_PLACES = SigpmlPackage.APPLICATION__OWNED_PLACES;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = SigpmlPackage.APPLICATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.AgentImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NAME = SigpmlPackage.AGENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNED_PORTS = SigpmlPackage.AGENT__OWNED_PORTS;

	/**
	 * The feature id for the '<em><b>Cycles</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CYCLES = SigpmlPackage.AGENT__CYCLES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__OWNER = SigpmlPackage.AGENT__OWNER;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CODE = SigpmlPackage.AGENT__CODE;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__ALLOCATED_TO = SigpmlPackage.AGENT__ALLOCATED_TO;

	/**
	 * The feature id for the '<em><b>Plotter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__PLOTTER = SigpmlPackage.AGENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Frame</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__FRAME = SigpmlPackage.AGENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Figure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__FIGURE = SigpmlPackage.AGENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__CURRENT_EXEC_CYCLE = SigpmlPackage.AGENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = SigpmlPackage.AGENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.PortImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = SigpmlPackage.PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = SigpmlPackage.PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__RATE = SigpmlPackage.PORT__RATE;

	/**
	 * The feature id for the '<em><b>Byte Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BYTE_RATE = SigpmlPackage.PORT__BYTE_RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = SigpmlPackage.PORT__TYPE;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = SigpmlPackage.PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.InputPortImpl <em>Input Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.InputPortImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getInputPort()
	 * @generated
	 */
	int INPUT_PORT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__NAME = SigpmlPackage.INPUT_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__OWNER = SigpmlPackage.INPUT_PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__RATE = SigpmlPackage.INPUT_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Byte Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__BYTE_RATE = SigpmlPackage.INPUT_PORT__BYTE_RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__TYPE = SigpmlPackage.INPUT_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Size Toread</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT__SIZE_TOREAD = SigpmlPackage.INPUT_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PORT_FEATURE_COUNT = SigpmlPackage.INPUT_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.OutputPortImpl <em>Output Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.OutputPortImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getOutputPort()
	 * @generated
	 */
	int OUTPUT_PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__NAME = SigpmlPackage.OUTPUT_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__OWNER = SigpmlPackage.OUTPUT_PORT__OWNER;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__RATE = SigpmlPackage.OUTPUT_PORT__RATE;

	/**
	 * The feature id for the '<em><b>Byte Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__BYTE_RATE = SigpmlPackage.OUTPUT_PORT__BYTE_RATE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__TYPE = SigpmlPackage.OUTPUT_PORT__TYPE;

	/**
	 * The feature id for the '<em><b>Size Written</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT__SIZE_WRITTEN = SigpmlPackage.OUTPUT_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PORT_FEATURE_COUNT = SigpmlPackage.OUTPUT_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.PlaceImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = SigpmlPackage.PLACE__NAME;

	/**
	 * The feature id for the '<em><b>Its Output Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_OUTPUT_PORT = SigpmlPackage.PLACE__ITS_OUTPUT_PORT;

	/**
	 * The feature id for the '<em><b>Its Input Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ITS_INPUT_PORT = SigpmlPackage.PLACE__ITS_INPUT_PORT;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SIZE = SigpmlPackage.PLACE__SIZE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__OWNER = SigpmlPackage.PLACE__OWNER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TYPE = SigpmlPackage.PLACE__TYPE;

	/**
	 * The feature id for the '<em><b>Byte Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__BYTE_SIZE = SigpmlPackage.PLACE__BYTE_SIZE;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__DELAY = SigpmlPackage.PLACE__DELAY;

	/**
	 * The feature id for the '<em><b>Fifo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__FIFO = SigpmlPackage.PLACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__IS_INITIALIZED = SigpmlPackage.PLACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__CURRENT_SIZE = SigpmlPackage.PLACE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = SigpmlPackage.PLACE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.NamedElementImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = SigpmlPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = SigpmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.HWRessourceImpl <em>HW Ressource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.HWRessourceImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWRessource()
	 * @generated
	 */
	int HW_RESSOURCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__NAME = SigpmlPackage.HW_RESSOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__OWNER = SigpmlPackage.HW_RESSOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE__CONNECTED_TO = SigpmlPackage.HW_RESSOURCE__CONNECTED_TO;

	/**
	 * The number of structural features of the '<em>HW Ressource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_RESSOURCE_FEATURE_COUNT = SigpmlPackage.HW_RESSOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.HWComputationalResourceImpl <em>HW Computational Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.HWComputationalResourceImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWComputationalResource()
	 * @generated
	 */
	int HW_COMPUTATIONAL_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__NAME = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__OWNER = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO;

	/**
	 * The feature id for the '<em><b>Is Under Preemptive Management</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT;

	/**
	 * The feature id for the '<em><b>Allocated Agents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS;

	/**
	 * The feature id for the '<em><b>Current Exec Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>HW Computational Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMPUTATIONAL_RESOURCE_FEATURE_COUNT = SigpmlPackage.HW_COMPUTATIONAL_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.HWStorageResourceImpl <em>HW Storage Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.HWStorageResourceImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWStorageResource()
	 * @generated
	 */
	int HW_STORAGE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__NAME = SigpmlPackage.HW_STORAGE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__OWNER = SigpmlPackage.HW_STORAGE_RESOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__CONNECTED_TO = SigpmlPackage.HW_STORAGE_RESOURCE__CONNECTED_TO;

	/**
	 * The feature id for the '<em><b>Allocated Places</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE__ALLOCATED_PLACES = SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES;

	/**
	 * The number of structural features of the '<em>HW Storage Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_STORAGE_RESOURCE_FEATURE_COUNT = SigpmlPackage.HW_STORAGE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.HWCommunicationResourceImpl <em>HW Communication Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.HWCommunicationResourceImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWCommunicationResource()
	 * @generated
	 */
	int HW_COMMUNICATION_RESOURCE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__NAME = SigpmlPackage.HW_COMMUNICATION_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__OWNER = SigpmlPackage.HW_COMMUNICATION_RESOURCE__OWNER;

	/**
	 * The feature id for the '<em><b>Connected To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE__CONNECTED_TO = SigpmlPackage.HW_COMMUNICATION_RESOURCE__CONNECTED_TO;

	/**
	 * The number of structural features of the '<em>HW Communication Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_COMMUNICATION_RESOURCE_FEATURE_COUNT = SigpmlPackage.HW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.HWPlatformImpl <em>HW Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.HWPlatformImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWPlatform()
	 * @generated
	 */
	int HW_PLATFORM = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM__NAME = SigpmlPackage.HW_PLATFORM__NAME;

	/**
	 * The feature id for the '<em><b>Owned HW Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM__OWNED_HW_RESOURCES = SigpmlPackage.HW_PLATFORM__OWNED_HW_RESOURCES;

	/**
	 * The number of structural features of the '<em>HW Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HW_PLATFORM_FEATURE_COUNT = SigpmlPackage.HW_PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link sigpmlextended.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see sigpmlextended.impl.SystemImpl
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = SigpmlPackage.SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Owned Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_APPLICATION = SigpmlPackage.SYSTEM__OWNED_APPLICATION;

	/**
	 * The feature id for the '<em><b>Owned HW Platform</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__OWNED_HW_PLATFORM = SigpmlPackage.SYSTEM__OWNED_HW_PLATFORM;

	/**
	 * The feature id for the '<em><b>Shared Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SHARED_MEMORY = SigpmlPackage.SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = SigpmlPackage.SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Figure</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cnrs.luchogie.up.data.Figure
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getFigure()
	 * @generated
	 */
	int FIGURE = 15;

	/**
	 * The meta object id for the '<em>JFrame</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javax.swing.JFrame
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getJFrame()
	 * @generated
	 */
	int JFRAME = 14;

	/**
	 * The meta object id for the '<em>Swing Plotter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see cnrs.luchogie.up.SwingPlotter
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getSwingPlotter()
	 * @generated
	 */
	int SWING_PLOTTER = 13;

	/**
	 * The meta object id for the '<em>Array List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.ArrayList
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getArrayList()
	 * @generated
	 */
	int ARRAY_LIST = 16;

	/**
	 * The meta object id for the '<em>Linked List Multimap</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.google.common.collect.LinkedListMultimap
	 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getLinkedListMultimap()
	 * @generated
	 */
	int LINKED_LIST_MULTIMAP = 17;


	/**
	 * Returns the meta object for class '{@link sigpmlextended.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see sigpmlextended.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see sigpmlextended.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Agent#getCurrentExecCycle <em>Current Exec Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Exec Cycle</em>'.
	 * @see sigpmlextended.Agent#getCurrentExecCycle()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_CurrentExecCycle();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Agent#getFigure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Figure</em>'.
	 * @see sigpmlextended.Agent#getFigure()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Figure();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Agent#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Frame</em>'.
	 * @see sigpmlextended.Agent#getFrame()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Frame();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Agent#getPlotter <em>Plotter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plotter</em>'.
	 * @see sigpmlextended.Agent#getPlotter()
	 * @see #getAgent()
	 * @generated
	 */
	EAttribute getAgent_Plotter();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see sigpmlextended.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Port</em>'.
	 * @see sigpmlextended.InputPort
	 * @generated
	 */
	EClass getInputPort();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.InputPort#getSizeToread <em>Size Toread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Toread</em>'.
	 * @see sigpmlextended.InputPort#getSizeToread()
	 * @see #getInputPort()
	 * @generated
	 */
	EAttribute getInputPort_SizeToread();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Port</em>'.
	 * @see sigpmlextended.OutputPort
	 * @generated
	 */
	EClass getOutputPort();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.OutputPort#getSizeWritten <em>Size Written</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size Written</em>'.
	 * @see sigpmlextended.OutputPort#getSizeWritten()
	 * @see #getOutputPort()
	 * @generated
	 */
	EAttribute getOutputPort_SizeWritten();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see sigpmlextended.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Place#getCurrentSize <em>Current Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Size</em>'.
	 * @see sigpmlextended.Place#getCurrentSize()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_CurrentSize();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Place#getFifo <em>Fifo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fifo</em>'.
	 * @see sigpmlextended.Place#getFifo()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_Fifo();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.Place#isIsInitialized <em>Is Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Initialized</em>'.
	 * @see sigpmlextended.Place#isIsInitialized()
	 * @see #getPlace()
	 * @generated
	 */
	EAttribute getPlace_IsInitialized();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see sigpmlextended.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.HWRessource <em>HW Ressource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Ressource</em>'.
	 * @see sigpmlextended.HWRessource
	 * @generated
	 */
	EClass getHWRessource();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.HWComputationalResource <em>HW Computational Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Computational Resource</em>'.
	 * @see sigpmlextended.HWComputationalResource
	 * @generated
	 */
	EClass getHWComputationalResource();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.HWComputationalResource#getCurrentExecCycle <em>Current Exec Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Exec Cycle</em>'.
	 * @see sigpmlextended.HWComputationalResource#getCurrentExecCycle()
	 * @see #getHWComputationalResource()
	 * @generated
	 */
	EAttribute getHWComputationalResource_CurrentExecCycle();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.HWStorageResource <em>HW Storage Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Storage Resource</em>'.
	 * @see sigpmlextended.HWStorageResource
	 * @generated
	 */
	EClass getHWStorageResource();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.HWCommunicationResource <em>HW Communication Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Communication Resource</em>'.
	 * @see sigpmlextended.HWCommunicationResource
	 * @generated
	 */
	EClass getHWCommunicationResource();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.HWPlatform <em>HW Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HW Platform</em>'.
	 * @see sigpmlextended.HWPlatform
	 * @generated
	 */
	EClass getHWPlatform();

	/**
	 * Returns the meta object for class '{@link sigpmlextended.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see sigpmlextended.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the attribute '{@link sigpmlextended.System#getSharedMemory <em>Shared Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shared Memory</em>'.
	 * @see sigpmlextended.System#getSharedMemory()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_SharedMemory();

	/**
	 * Returns the meta object for data type '{@link cnrs.luchogie.up.data.Figure <em>Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Figure</em>'.
	 * @see cnrs.luchogie.up.data.Figure
	 * @model instanceClass="cnrs.luchogie.up.data.Figure"
	 * @generated
	 */
	EDataType getFigure();

	/**
	 * Returns the meta object for data type '{@link javax.swing.JFrame <em>JFrame</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>JFrame</em>'.
	 * @see javax.swing.JFrame
	 * @model instanceClass="javax.swing.JFrame"
	 * @generated
	 */
	EDataType getJFrame();

	/**
	 * Returns the meta object for data type '{@link cnrs.luchogie.up.SwingPlotter <em>Swing Plotter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Swing Plotter</em>'.
	 * @see cnrs.luchogie.up.SwingPlotter
	 * @model instanceClass="cnrs.luchogie.up.SwingPlotter"
	 * @generated
	 */
	EDataType getSwingPlotter();

	/**
	 * Returns the meta object for data type '{@link java.util.ArrayList <em>Array List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Array List</em>'.
	 * @see java.util.ArrayList
	 * @model instanceClass="java.util.ArrayList"
	 * @generated
	 */
	EDataType getArrayList();

	/**
	 * Returns the meta object for data type '{@link com.google.common.collect.LinkedListMultimap <em>Linked List Multimap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Linked List Multimap</em>'.
	 * @see com.google.common.collect.LinkedListMultimap
	 * @model instanceClass="com.google.common.collect.LinkedListMultimap"
	 * @generated
	 */
	EDataType getLinkedListMultimap();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SigpmlextendedFactory getSigpmlextendedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.ApplicationImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.AgentImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Current Exec Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__CURRENT_EXEC_CYCLE = eINSTANCE.getAgent_CurrentExecCycle();

		/**
		 * The meta object literal for the '<em><b>Figure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__FIGURE = eINSTANCE.getAgent_Figure();

		/**
		 * The meta object literal for the '<em><b>Frame</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__FRAME = eINSTANCE.getAgent_Frame();

		/**
		 * The meta object literal for the '<em><b>Plotter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT__PLOTTER = eINSTANCE.getAgent_Plotter();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.PortImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.InputPortImpl <em>Input Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.InputPortImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getInputPort()
		 * @generated
		 */
		EClass INPUT_PORT = eINSTANCE.getInputPort();

		/**
		 * The meta object literal for the '<em><b>Size Toread</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_PORT__SIZE_TOREAD = eINSTANCE.getInputPort_SizeToread();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.OutputPortImpl <em>Output Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.OutputPortImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getOutputPort()
		 * @generated
		 */
		EClass OUTPUT_PORT = eINSTANCE.getOutputPort();

		/**
		 * The meta object literal for the '<em><b>Size Written</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTPUT_PORT__SIZE_WRITTEN = eINSTANCE.getOutputPort_SizeWritten();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.PlaceImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>Current Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__CURRENT_SIZE = eINSTANCE.getPlace_CurrentSize();

		/**
		 * The meta object literal for the '<em><b>Fifo</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__FIFO = eINSTANCE.getPlace_Fifo();

		/**
		 * The meta object literal for the '<em><b>Is Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACE__IS_INITIALIZED = eINSTANCE.getPlace_IsInitialized();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.NamedElementImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.HWRessourceImpl <em>HW Ressource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.HWRessourceImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWRessource()
		 * @generated
		 */
		EClass HW_RESSOURCE = eINSTANCE.getHWRessource();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.HWComputationalResourceImpl <em>HW Computational Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.HWComputationalResourceImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWComputationalResource()
		 * @generated
		 */
		EClass HW_COMPUTATIONAL_RESOURCE = eINSTANCE.getHWComputationalResource();

		/**
		 * The meta object literal for the '<em><b>Current Exec Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE = eINSTANCE.getHWComputationalResource_CurrentExecCycle();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.HWStorageResourceImpl <em>HW Storage Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.HWStorageResourceImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWStorageResource()
		 * @generated
		 */
		EClass HW_STORAGE_RESOURCE = eINSTANCE.getHWStorageResource();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.HWCommunicationResourceImpl <em>HW Communication Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.HWCommunicationResourceImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWCommunicationResource()
		 * @generated
		 */
		EClass HW_COMMUNICATION_RESOURCE = eINSTANCE.getHWCommunicationResource();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.HWPlatformImpl <em>HW Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.HWPlatformImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getHWPlatform()
		 * @generated
		 */
		EClass HW_PLATFORM = eINSTANCE.getHWPlatform();

		/**
		 * The meta object literal for the '{@link sigpmlextended.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see sigpmlextended.impl.SystemImpl
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Shared Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__SHARED_MEMORY = eINSTANCE.getSystem_SharedMemory();

		/**
		 * The meta object literal for the '<em>Figure</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cnrs.luchogie.up.data.Figure
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getFigure()
		 * @generated
		 */
		EDataType FIGURE = eINSTANCE.getFigure();

		/**
		 * The meta object literal for the '<em>JFrame</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javax.swing.JFrame
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getJFrame()
		 * @generated
		 */
		EDataType JFRAME = eINSTANCE.getJFrame();

		/**
		 * The meta object literal for the '<em>Swing Plotter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see cnrs.luchogie.up.SwingPlotter
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getSwingPlotter()
		 * @generated
		 */
		EDataType SWING_PLOTTER = eINSTANCE.getSwingPlotter();

		/**
		 * The meta object literal for the '<em>Array List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.ArrayList
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getArrayList()
		 * @generated
		 */
		EDataType ARRAY_LIST = eINSTANCE.getArrayList();

		/**
		 * The meta object literal for the '<em>Linked List Multimap</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.google.common.collect.LinkedListMultimap
		 * @see sigpmlextended.impl.SigpmlextendedPackageImpl#getLinkedListMultimap()
		 * @generated
		 */
		EDataType LINKED_LIST_MULTIMAP = eINSTANCE.getLinkedListMultimap();

	}

} //SigpmlextendedPackage
