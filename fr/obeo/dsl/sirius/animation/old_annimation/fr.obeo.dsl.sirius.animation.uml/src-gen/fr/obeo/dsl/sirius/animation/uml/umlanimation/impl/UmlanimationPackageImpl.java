/**
 */
package fr.obeo.dsl.sirius.animation.uml.umlanimation.impl;

import fr.obeo.dsl.sirius.animation.uml.umlanimation.StateMachineExecution;
import fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationFactory;
import fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlanimationPackageImpl extends EPackageImpl implements UmlanimationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineExecutionEClass = null;

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
	 * @see fr.obeo.dsl.sirius.animation.uml.umlanimation.UmlanimationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlanimationPackageImpl() {
		super(eNS_URI, UmlanimationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UmlanimationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlanimationPackage init() {
		if (isInited) return (UmlanimationPackage)EPackage.Registry.INSTANCE.getEPackage(UmlanimationPackage.eNS_URI);

		// Obtain or create and register package
		UmlanimationPackageImpl theUmlanimationPackage = (UmlanimationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlanimationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlanimationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlanimationPackage.createPackageContents();

		// Initialize created meta-data
		theUmlanimationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlanimationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlanimationPackage.eNS_URI, theUmlanimationPackage);
		return theUmlanimationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachineExecution() {
		return stateMachineExecutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineExecution_Statemachine() {
		return (EReference)stateMachineExecutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineExecution_Current() {
		return (EReference)stateMachineExecutionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachineExecution_Candidates() {
		return (EReference)stateMachineExecutionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlanimationFactory getUmlanimationFactory() {
		return (UmlanimationFactory)getEFactoryInstance();
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
		stateMachineExecutionEClass = createEClass(STATE_MACHINE_EXECUTION);
		createEReference(stateMachineExecutionEClass, STATE_MACHINE_EXECUTION__STATEMACHINE);
		createEReference(stateMachineExecutionEClass, STATE_MACHINE_EXECUTION__CURRENT);
		createEReference(stateMachineExecutionEClass, STATE_MACHINE_EXECUTION__CANDIDATES);
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
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(stateMachineExecutionEClass, StateMachineExecution.class, "StateMachineExecution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachineExecution_Statemachine(), theUMLPackage.getStateMachine(), null, "statemachine", null, 1, 1, StateMachineExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineExecution_Current(), theUMLPackage.getState(), null, "current", null, 1, 1, StateMachineExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineExecution_Candidates(), theUMLPackage.getState(), null, "candidates", null, 0, -1, StateMachineExecution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UmlanimationPackageImpl
