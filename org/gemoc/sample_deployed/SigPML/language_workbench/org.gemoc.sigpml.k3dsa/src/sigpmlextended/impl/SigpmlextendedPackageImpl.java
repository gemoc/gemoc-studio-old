/**
 */
package sigpmlextended.impl;

import cnrs.luchogie.up.SwingPlotter;

import cnrs.luchogie.up.data.Figure;

import com.google.common.collect.LinkedListMultimap;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.gemoc.sigpml.SigpmlPackage;

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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SigpmlextendedPackageImpl extends EPackageImpl implements SigpmlextendedPackage {
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
	private EDataType figureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType jFrameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType swingPlotterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType arrayListEDataType = null;

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
	 * @see sigpmlextended.SigpmlextendedPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SigpmlextendedPackageImpl() {
		super(eNS_URI, SigpmlextendedFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SigpmlextendedPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SigpmlextendedPackage init() {
		if (isInited) return (SigpmlextendedPackage)EPackage.Registry.INSTANCE.getEPackage(SigpmlextendedPackage.eNS_URI);

		// Obtain or create and register package
		SigpmlextendedPackageImpl theSigpmlextendedPackage = (SigpmlextendedPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SigpmlextendedPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SigpmlextendedPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SigpmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSigpmlextendedPackage.createPackageContents();

		// Initialize created meta-data
		theSigpmlextendedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSigpmlextendedPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SigpmlextendedPackage.eNS_URI, theSigpmlextendedPackage);
		return theSigpmlextendedPackage;
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
	public EClass getAgent() {
		return agentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_CurrentExecCycle() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_Figure() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_Frame() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgent_Plotter() {
		return (EAttribute)agentEClass.getEStructuralFeatures().get(0);
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
	public EClass getPlace() {
		return placeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_CurrentSize() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_Fifo() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlace_IsInitialized() {
		return (EAttribute)placeEClass.getEStructuralFeatures().get(1);
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
	public EClass getHWRessource() {
		return hwRessourceEClass;
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
	public EAttribute getHWComputationalResource_CurrentExecCycle() {
		return (EAttribute)hwComputationalResourceEClass.getEStructuralFeatures().get(0);
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
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystem_SharedMemory() {
		return (EAttribute)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFigure() {
		return figureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJFrame() {
		return jFrameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSwingPlotter() {
		return swingPlotterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getArrayList() {
		return arrayListEDataType;
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
	public SigpmlextendedFactory getSigpmlextendedFactory() {
		return (SigpmlextendedFactory)getEFactoryInstance();
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

		agentEClass = createEClass(AGENT);
		createEAttribute(agentEClass, AGENT__PLOTTER);
		createEAttribute(agentEClass, AGENT__FRAME);
		createEAttribute(agentEClass, AGENT__FIGURE);
		createEAttribute(agentEClass, AGENT__CURRENT_EXEC_CYCLE);

		portEClass = createEClass(PORT);

		inputPortEClass = createEClass(INPUT_PORT);
		createEAttribute(inputPortEClass, INPUT_PORT__SIZE_TOREAD);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEAttribute(outputPortEClass, OUTPUT_PORT__SIZE_WRITTEN);

		placeEClass = createEClass(PLACE);
		createEAttribute(placeEClass, PLACE__FIFO);
		createEAttribute(placeEClass, PLACE__IS_INITIALIZED);
		createEAttribute(placeEClass, PLACE__CURRENT_SIZE);

		namedElementEClass = createEClass(NAMED_ELEMENT);

		hwRessourceEClass = createEClass(HW_RESSOURCE);

		hwComputationalResourceEClass = createEClass(HW_COMPUTATIONAL_RESOURCE);
		createEAttribute(hwComputationalResourceEClass, HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE);

		hwStorageResourceEClass = createEClass(HW_STORAGE_RESOURCE);

		hwCommunicationResourceEClass = createEClass(HW_COMMUNICATION_RESOURCE);

		hwPlatformEClass = createEClass(HW_PLATFORM);

		systemEClass = createEClass(SYSTEM);
		createEAttribute(systemEClass, SYSTEM__SHARED_MEMORY);

		// Create data types
		swingPlotterEDataType = createEDataType(SWING_PLOTTER);
		jFrameEDataType = createEDataType(JFRAME);
		figureEDataType = createEDataType(FIGURE);
		arrayListEDataType = createEDataType(ARRAY_LIST);
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

		// Obtain other dependent packages
		SigpmlPackage theSigpmlPackage = (SigpmlPackage)EPackage.Registry.INSTANCE.getEPackage(SigpmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		applicationEClass.getESuperTypes().add(theSigpmlPackage.getApplication());
		agentEClass.getESuperTypes().add(theSigpmlPackage.getAgent());
		portEClass.getESuperTypes().add(theSigpmlPackage.getPort());
		inputPortEClass.getESuperTypes().add(theSigpmlPackage.getInputPort());
		outputPortEClass.getESuperTypes().add(theSigpmlPackage.getOutputPort());
		placeEClass.getESuperTypes().add(theSigpmlPackage.getPlace());
		namedElementEClass.getESuperTypes().add(theSigpmlPackage.getNamedElement());
		hwRessourceEClass.getESuperTypes().add(theSigpmlPackage.getHWRessource());
		hwComputationalResourceEClass.getESuperTypes().add(theSigpmlPackage.getHWComputationalResource());
		hwStorageResourceEClass.getESuperTypes().add(theSigpmlPackage.getHWStorageResource());
		hwCommunicationResourceEClass.getESuperTypes().add(theSigpmlPackage.getHWCommunicationResource());
		hwPlatformEClass.getESuperTypes().add(theSigpmlPackage.getHWPlatform());
		systemEClass.getESuperTypes().add(theSigpmlPackage.getSystem());

		// Initialize classes and features; add operations and parameters
		initEClass(applicationEClass, Application.class, "Application", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(agentEClass, Agent.class, "Agent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAgent_Plotter(), this.getSwingPlotter(), "plotter", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_Frame(), this.getJFrame(), "frame", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_Figure(), this.getFigure(), "figure", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgent_CurrentExecCycle(), ecorePackage.getEInt(), "currentExecCycle", null, 0, 1, Agent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(agentEClass, null, "isExecuting", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(agentEClass, null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputPort_SizeToread(), ecorePackage.getEInt(), "sizeToread", null, 0, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(inputPortEClass, null, "read", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutputPort_SizeWritten(), ecorePackage.getEInt(), "sizeWritten", null, 0, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(outputPortEClass, null, "write", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(placeEClass, Place.class, "Place", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlace_Fifo(), this.getArrayList(), "fifo", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_IsInitialized(), ecorePackage.getEBoolean(), "isInitialized", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlace_CurrentSize(), ecorePackage.getEInt(), "currentSize", null, 0, 1, Place.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(placeEClass, null, "push", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(placeEClass, null, "pop", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(namedElementEClass, this.getLinkedListMultimap(), "sharedMemory", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hwRessourceEClass, HWRessource.class, "HWRessource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwComputationalResourceEClass, HWComputationalResource.class, "HWComputationalResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHWComputationalResource_CurrentExecCycle(), ecorePackage.getEInt(), "currentExecCycle", null, 0, 1, HWComputationalResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(hwComputationalResourceEClass, null, "incCycle", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(hwStorageResourceEClass, HWStorageResource.class, "HWStorageResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwCommunicationResourceEClass, HWCommunicationResource.class, "HWCommunicationResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hwPlatformEClass, HWPlatform.class, "HWPlatform", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemEClass, sigpmlextended.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSystem_SharedMemory(), this.getLinkedListMultimap(), "sharedMemory", null, 0, 1, sigpmlextended.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(swingPlotterEDataType, SwingPlotter.class, "SwingPlotter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(jFrameEDataType, JFrame.class, "JFrame", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(figureEDataType, Figure.class, "Figure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(arrayListEDataType, ArrayList.class, "ArrayList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(linkedListMultimapEDataType, LinkedListMultimap.class, "LinkedListMultimap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// aspect
		createAspectAnnotations();
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
		  (agentEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (agentEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent_Plotter(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent_Frame(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent_Figure(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getAgent_CurrentExecCycle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (inputPortEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getInputPort_SizeToread(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (outputPortEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getOutputPort_SizeWritten(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (placeEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (placeEClass.getEOperations().get(1), 
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
		  (getPlace_CurrentSize(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (namedElementEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (hwComputationalResourceEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getHWComputationalResource_CurrentExecCycle(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getSystem_SharedMemory(), 
		   source, 
		   new String[] {
		   });
	}

} //SigpmlextendedPackageImpl
