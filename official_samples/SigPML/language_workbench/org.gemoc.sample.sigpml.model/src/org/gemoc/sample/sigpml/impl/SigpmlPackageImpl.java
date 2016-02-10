/**
 */
package org.gemoc.sample.sigpml.impl;

import com.google.common.collect.LinkedListMultimap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
import org.gemoc.sample.sigpml.SigpmlFactory;
import org.gemoc.sample.sigpml.SigpmlPackage;
import org.gemoc.sample.sigpml.sizeType;

import org.gemoc.sample.sigpml.util.SigpmlValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SigpmlPackageImpl extends EPackageImpl implements SigpmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass placeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwRessourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwComputationalResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwStorageResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwCommunicationResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hwPlatformEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sizeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType linkedListMultimapEDataType = null;

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
	 * @see org.gemoc.sample.sigpml.SigpmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SigpmlPackageImpl() {
		super(eNS_URI, SigpmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SigpmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SigpmlPackage init() {
		if (isInited) return (SigpmlPackage)EPackage.Registry.INSTANCE.getEPackage(SigpmlPackage.eNS_URI);

		// Obtain or create and register package
		SigpmlPackageImpl theSigpmlPackage = (SigpmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SigpmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SigpmlPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSigpmlPackage.createPackageContents();

		// Initialize created meta-data
		theSigpmlPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theSigpmlPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return SigpmlValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theSigpmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SigpmlPackage.eNS_URI, theSigpmlPackage);
		return theSigpmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplication() {
		return applicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_OwnedAgents() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplication_OwnedPlaces() {
		return (EReference)applicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgent() {
		return agentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgent_OwnedPorts() {
		return (EReference)agentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_Cycles() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgent_Owner() {
		return (EReference)agentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_Code() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgent_AllocatedTo() {
		return (EReference)agentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_CurrentExecCycle() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_IsCurrentlyExecuting() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAgent__IsExecuting() {
		return agentEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAgent__Execute() {
		return agentEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAgent__Stop() {
		return agentEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Owner() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Rate() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_ByteRate() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Type() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPort() {
		return inputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputPort_SizeToread() {
		return (EAttribute)inputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputPort__Read() {
		return inputPortEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputPort__LogSizeToReadWhenZero() {
		return inputPortEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInputPort__LogSizeToReadWhenNotZero() {
		return inputPortEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPort() {
		return outputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOutputPort_SizeWritten() {
		return (EAttribute)outputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOutputPort__Write() {
		return outputPortEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlace() {
		return placeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_ItsOutputPort() {
		return (EReference)placeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_ItsInputPort() {
		return (EReference)placeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_Fifo() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_IsInitialized() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_Size() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlace_Owner() {
		return (EReference)placeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_Type() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_ByteSize() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_Delay() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_CurrentSize() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPlace__Push() {
		return placeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPlace__Pop() {
		return placeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHWRessource() {
		return hwRessourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHWRessource_Owner() {
		return (EReference)hwRessourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHWRessource_ConnectedTo() {
		return (EReference)hwRessourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHWComputationalResource() {
		return hwComputationalResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHWComputationalResource_IsUnderPreemptiveManagement() {
		return (EAttribute)hwComputationalResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHWComputationalResource_AllocatedAgents() {
		return (EReference)hwComputationalResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getHWComputationalResource__IncCycle() {
		return hwComputationalResourceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHWStorageResource() {
		return hwStorageResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHWStorageResource_AllocatedPlaces() {
		return (EReference)hwStorageResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHWCommunicationResource() {
		return hwCommunicationResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHWPlatform() {
		return hwPlatformEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHWPlatform_OwnedHWResources() {
		return (EReference)hwPlatformEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_OwnedApplication() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_OwnedHWPlatform() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_SharedMemory() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getsizeType() {
		return sizeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLinkedListMultimap() {
		return linkedListMultimapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SigpmlFactory getSigpmlFactory() {
		return (SigpmlFactory)getEFactoryInstance();
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
		applicationEClass = createEClass(APPLICATION);
		createEReference(applicationEClass, APPLICATION__OWNED_AGENTS);
		createEReference(applicationEClass, APPLICATION__OWNED_PLACES);

		agentEClass = createEClass(AGENT);
		createEReference(agentEClass, AGENT__OWNED_PORTS);
		createEAttribute(agentEClass, AGENT__CYCLES);
		createEReference(agentEClass, AGENT__OWNER);
		createEAttribute(agentEClass, AGENT__CODE);
		createEReference(agentEClass, AGENT__ALLOCATED_TO);
		createEAttribute(agentEClass, AGENT__CURRENT_EXEC_CYCLE);
		createEAttribute(agentEClass, AGENT__IS_CURRENTLY_EXECUTING);
		createEOperation(agentEClass, AGENT___IS_EXECUTING);
		createEOperation(agentEClass, AGENT___EXECUTE);
		createEOperation(agentEClass, AGENT___STOP);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__OWNER);
		createEAttribute(portEClass, PORT__RATE);
		createEAttribute(portEClass, PORT__BYTE_RATE);
		createEAttribute(portEClass, PORT__TYPE);

		inputPortEClass = createEClass(INPUT_PORT);
		createEAttribute(inputPortEClass, INPUT_PORT__SIZE_TOREAD);
		createEOperation(inputPortEClass, INPUT_PORT___READ);
		createEOperation(inputPortEClass, INPUT_PORT___LOG_SIZE_TO_READ_WHEN_ZERO);
		createEOperation(inputPortEClass, INPUT_PORT___LOG_SIZE_TO_READ_WHEN_NOT_ZERO);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEAttribute(outputPortEClass, OUTPUT_PORT__SIZE_WRITTEN);
		createEOperation(outputPortEClass, OUTPUT_PORT___WRITE);

		placeEClass = createEClass(PLACE);
		createEReference(placeEClass, PLACE__ITS_OUTPUT_PORT);
		createEReference(placeEClass, PLACE__ITS_INPUT_PORT);
		createEAttribute(placeEClass, PLACE__FIFO);
		createEAttribute(placeEClass, PLACE__IS_INITIALIZED);
		createEAttribute(placeEClass, PLACE__SIZE);
		createEReference(placeEClass, PLACE__OWNER);
		createEAttribute(placeEClass, PLACE__TYPE);
		createEAttribute(placeEClass, PLACE__BYTE_SIZE);
		createEAttribute(placeEClass, PLACE__DELAY);
		createEAttribute(placeEClass, PLACE__CURRENT_SIZE);
		createEOperation(placeEClass, PLACE___PUSH);
		createEOperation(placeEClass, PLACE___POP);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		hwRessourceEClass = createEClass(HW_RESSOURCE);
		createEReference(hwRessourceEClass, HW_RESSOURCE__OWNER);
		createEReference(hwRessourceEClass, HW_RESSOURCE__CONNECTED_TO);

		hwComputationalResourceEClass = createEClass(HW_COMPUTATIONAL_RESOURCE);
		createEAttribute(hwComputationalResourceEClass, HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT);
		createEReference(hwComputationalResourceEClass, HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS);
		createEOperation(hwComputationalResourceEClass, HW_COMPUTATIONAL_RESOURCE___INC_CYCLE);

		hwStorageResourceEClass = createEClass(HW_STORAGE_RESOURCE);
		createEReference(hwStorageResourceEClass, HW_STORAGE_RESOURCE__ALLOCATED_PLACES);

		hwCommunicationResourceEClass = createEClass(HW_COMMUNICATION_RESOURCE);

		hwPlatformEClass = createEClass(HW_PLATFORM);
		createEReference(hwPlatformEClass, HW_PLATFORM__OWNED_HW_RESOURCES);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__OWNED_APPLICATION);
		createEReference(systemEClass, SYSTEM__OWNED_HW_PLATFORM);
		createEAttribute(systemEClass, SYSTEM__SHARED_MEMORY);

		// Create enums
		sizeTypeEEnum = createEEnum(SIZE_TYPE);

		// Create data types
		objectEDataType = createEDataType(OBJECT);
		linkedListMultimapEDataType = createEDataType(LINKED_LIST_MULTIMAP);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		applicationEClass.getESuperTypes().add(this.getNamedElement());
		agentEClass.getESuperTypes().add(this.getNamedElement());
		portEClass.getESuperTypes().add(this.getNamedElement());
		inputPortEClass.getESuperTypes().add(this.getPort());
		outputPortEClass.getESuperTypes().add(this.getPort());
		placeEClass.getESuperTypes().add(this.getNamedElement());
		hwRessourceEClass.getESuperTypes().add(this.getNamedElement());
		hwComputationalResourceEClass.getESuperTypes().add(this.getHWRessource());
		hwStorageResourceEClass.getESuperTypes().add(this.getHWRessource());
		hwCommunicationResourceEClass.getESuperTypes().add(this.getHWRessource());
		hwPlatformEClass.getESuperTypes().add(this.getNamedElement());
		systemEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplication_OwnedAgents(), this.getAgent(), this.getAgent_Owner(), "ownedAgents", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplication_OwnedPlaces(), this.getPlace(), this.getPlace_Owner(), "ownedPlaces", null, 0, -1, Application.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentEClass, Agent.class, "Agent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAgent_OwnedPorts(), this.getPort(), this.getPort_Owner(), "ownedPorts", null, 0, -1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_Cycles(), ecorePackage.getEInt(), "cycles", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgent_Owner(), this.getApplication(), this.getApplication_OwnedAgents(), "owner", null, 1, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_Code(), ecorePackage.getEString(), "code", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgent_AllocatedTo(), this.getHWComputationalResource(), null, "allocatedTo", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_CurrentExecCycle(), ecorePackage.getEInt(), "currentExecCycle", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_IsCurrentlyExecuting(), ecorePackage.getEBoolean(), "isCurrentlyExecuting", "false", 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAgent__IsExecuting(), null, "isExecuting", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAgent__Execute(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getAgent__Stop(), null, "stop", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_Owner(), this.getAgent(), this.getAgent_OwnedPorts(), "owner", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Rate(), ecorePackage.getEInt(), "rate", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_ByteRate(), ecorePackage.getEInt(), "byteRate", null, 1, 1, Port.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Type(), this.getsizeType(), "type", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputPort_SizeToread(), ecorePackage.getEInt(), "sizeToread", null, 0, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getInputPort__Read(), ecorePackage.getEInt(), "read", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getInputPort__LogSizeToReadWhenZero(), null, "logSizeToReadWhenZero", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getInputPort__LogSizeToReadWhenNotZero(), null, "logSizeToReadWhenNotZero", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutputPort_SizeWritten(), ecorePackage.getEInt(), "sizeWritten", null, 0, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getOutputPort__Write(), null, "write", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(placeEClass, Place.class, "Place", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlace_ItsOutputPort(), this.getOutputPort(), null, "itsOutputPort", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlace_ItsInputPort(), this.getInputPort(), null, "itsInputPort", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_Fifo(), this.getObject(), "fifo", null, 0, -1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_IsInitialized(), ecorePackage.getEBoolean(), "isInitialized", "false", 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_Size(), ecorePackage.getEInt(), "size", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlace_Owner(), this.getApplication(), this.getApplication_OwnedPlaces(), "owner", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_Type(), this.getsizeType(), "type", null, 1, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_ByteSize(), ecorePackage.getEInt(), "byteSize", null, 1, 1, Place.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_Delay(), ecorePackage.getEInt(), "delay", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_CurrentSize(), ecorePackage.getEInt(), "currentSize", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getPlace__Push(), null, "push", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPlace__Pop(), null, "pop", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hwRessourceEClass, HWRessource.class, "HWRessource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHWRessource_Owner(), this.getHWPlatform(), this.getHWPlatform_OwnedHWResources(), "owner", null, 0, 1, HWRessource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHWRessource_ConnectedTo(), this.getHWRessource(), null, "connectedTo", null, 0, -1, HWRessource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hwComputationalResourceEClass, HWComputationalResource.class, "HWComputationalResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHWComputationalResource_IsUnderPreemptiveManagement(), ecorePackage.getEBoolean(), "isUnderPreemptiveManagement", null, 0, 1, HWComputationalResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHWComputationalResource_AllocatedAgents(), this.getAgent(), null, "allocatedAgents", null, 0, -1, HWComputationalResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getHWComputationalResource__IncCycle(), null, "incCycle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hwStorageResourceEClass, HWStorageResource.class, "HWStorageResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHWStorageResource_AllocatedPlaces(), this.getPlace(), null, "allocatedPlaces", null, 0, -1, HWStorageResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hwCommunicationResourceEClass, HWCommunicationResource.class, "HWCommunicationResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwPlatformEClass, HWPlatform.class, "HWPlatform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHWPlatform_OwnedHWResources(), this.getHWRessource(), this.getHWRessource_Owner(), "ownedHWResources", null, 0, -1, HWPlatform.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemEClass, org.gemoc.sample.sigpml.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_OwnedApplication(), this.getApplication(), null, "ownedApplication", null, 0, 1, org.gemoc.sample.sigpml.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_OwnedHWPlatform(), this.getHWPlatform(), null, "ownedHWPlatform", null, 0, 1, org.gemoc.sample.sigpml.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystem_SharedMemory(), this.getLinkedListMultimap(), "sharedMemory", null, 0, 1, org.gemoc.sample.sigpml.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sizeTypeEEnum, sizeType.class, "sizeType");
		addEEnumLiteral(sizeTypeEEnum, sizeType.B);
		addEEnumLiteral(sizeTypeEEnum, sizeType.KB);
		addEEnumLiteral(sizeTypeEEnum, sizeType.MB);
		addEEnumLiteral(sizeTypeEEnum, sizeType.GB);

		// Initialize data types
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(linkedListMultimapEDataType, LinkedListMultimap.class, "LinkedListMultimap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// aspect
		createAspectAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });	
		addAnnotation
		  (placeEClass, 
		   source, 
		   new String[] {
			 "constraints", "matchRates"
		   });
	}

	/**
	 * Initializes the annotations for <b>aspect</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAspectAnnotations() {
		String source = "aspect";	
		addAnnotation
		  (getAgent__IsExecuting(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent__Execute(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent__Stop(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent_IsCurrentlyExecuting(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getInputPort__Read(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getInputPort__LogSizeToReadWhenZero(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getInputPort__LogSizeToReadWhenNotZero(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getInputPort_SizeToread(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getOutputPort__Write(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getOutputPort_SizeWritten(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getPlace__Push(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getPlace__Pop(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getPlace_Fifo(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getPlace_IsInitialized(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getHWComputationalResource__IncCycle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSystem_SharedMemory(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";	
		addAnnotation
		  (placeEClass, 
		   source, 
		   new String[] {
			 "matchRates", "if byteSize > 0 then byteSize >= itsOutputPort.byteRate and byteSize >= itsInputPort.byteRate else true endif"
		   });
	}

} //SigpmlPackageImpl
