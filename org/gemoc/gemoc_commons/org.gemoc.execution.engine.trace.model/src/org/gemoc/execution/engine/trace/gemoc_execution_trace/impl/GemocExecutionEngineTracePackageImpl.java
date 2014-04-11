/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import fr.inria.aoste.trace.TracePackage;
import fr.inria.aoste.trace.impl.TracePackageImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GemocExecutionEngineTracePackageImpl extends EPackageImpl implements GemocExecutionEngineTracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTraceModelEClass = null;

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
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GemocExecutionEngineTracePackageImpl() {
		super(eNS_URI, GemocExecutionEngineTraceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GemocExecutionEngineTracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GemocExecutionEngineTracePackage init() {
		if (isInited) return (GemocExecutionEngineTracePackage)EPackage.Registry.INSTANCE.getEPackage(GemocExecutionEngineTracePackage.eNS_URI);

		// Obtain or create and register package
		GemocExecutionEngineTracePackageImpl theGemocExecutionEngineTracePackage = (GemocExecutionEngineTracePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GemocExecutionEngineTracePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GemocExecutionEngineTracePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TracePackageImpl theTracePackage = (TracePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) instanceof TracePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI) : TracePackage.eINSTANCE);

		// Create package meta-data objects
		theGemocExecutionEngineTracePackage.createPackageContents();
		theTracePackage.createPackageContents();

		// Initialize created meta-data
		theGemocExecutionEngineTracePackage.initializePackageContents();
		theTracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGemocExecutionEngineTracePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GemocExecutionEngineTracePackage.eNS_URI, theGemocExecutionEngineTracePackage);
		return theGemocExecutionEngineTracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_NextChoice() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_PossibleLogicalSteps() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_ChosenLogicalStep() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTraceModel() {
		return executionTraceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTraceModel_Choices() {
		return (EReference)executionTraceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocExecutionEngineTraceFactory getGemocExecutionEngineTraceFactory() {
		return (GemocExecutionEngineTraceFactory)getEFactoryInstance();
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
		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__NEXT_CHOICE);
		createEReference(choiceEClass, CHOICE__POSSIBLE_LOGICAL_STEPS);
		createEReference(choiceEClass, CHOICE__CHOSEN_LOGICAL_STEP);

		executionTraceModelEClass = createEClass(EXECUTION_TRACE_MODEL);
		createEReference(executionTraceModelEClass, EXECUTION_TRACE_MODEL__CHOICES);
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
		TracePackage theTracePackage = (TracePackage)EPackage.Registry.INSTANCE.getEPackage(TracePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_NextChoice(), this.getChoice(), null, "nextChoice", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoice_PossibleLogicalSteps(), theTracePackage.getLogicalStep(), null, "possibleLogicalSteps", null, 0, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getChoice_ChosenLogicalStep(), theTracePackage.getLogicalStep(), null, "chosenLogicalStep", null, 0, 1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionTraceModelEClass, ExecutionTraceModel.class, "ExecutionTraceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionTraceModel_Choices(), this.getChoice(), null, "choices", null, 0, -1, ExecutionTraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GemocExecutionEngineTracePackageImpl
