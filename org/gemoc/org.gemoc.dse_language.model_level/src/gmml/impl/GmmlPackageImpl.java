/**
 */
package gmml.impl;

import glml.GlmlPackage;

import gmml.GmmlFactory;
import gmml.GmmlPackage;
import gmml.ImportStatement;
import gmml.ModelSpecificEvent;
import gmml.ModelSpecificEventFile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GmmlPackageImpl extends EPackageImpl implements GmmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSpecificEventFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelSpecificEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importStatementEClass = null;

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
	 * @see gmml.GmmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GmmlPackageImpl() {
		super(eNS_URI, GmmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GmmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GmmlPackage init() {
		if (isInited) return (GmmlPackage)EPackage.Registry.INSTANCE.getEPackage(GmmlPackage.eNS_URI);

		// Obtain or create and register package
		GmmlPackageImpl theGmmlPackage = (GmmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GmmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GmmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GlmlPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGmmlPackage.createPackageContents();

		// Initialize created meta-data
		theGmmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGmmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GmmlPackage.eNS_URI, theGmmlPackage);
		return theGmmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSpecificEventFile() {
		return modelSpecificEventFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEventFile_Import() {
		return (EReference)modelSpecificEventFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEventFile_Events() {
		return (EReference)modelSpecificEventFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSpecificEvent() {
		return modelSpecificEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEvent_Target() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEvent_Operations() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSpecificEvent_Condition() {
		return (EAttribute)modelSpecificEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEvent_Reification() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportStatement() {
		return importStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportStatement_DomainSpecificEventFileURI() {
		return (EAttribute)importStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GmmlFactory getGmmlFactory() {
		return (GmmlFactory)getEFactoryInstance();
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
		modelSpecificEventFileEClass = createEClass(MODEL_SPECIFIC_EVENT_FILE);
		createEReference(modelSpecificEventFileEClass, MODEL_SPECIFIC_EVENT_FILE__IMPORT);
		createEReference(modelSpecificEventFileEClass, MODEL_SPECIFIC_EVENT_FILE__EVENTS);

		modelSpecificEventEClass = createEClass(MODEL_SPECIFIC_EVENT);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__TARGET);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__OPERATIONS);
		createEAttribute(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__CONDITION);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__REIFICATION);

		importStatementEClass = createEClass(IMPORT_STATEMENT);
		createEAttribute(importStatementEClass, IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI);
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
		GlmlPackage theGlmlPackage = (GlmlPackage)EPackage.Registry.INSTANCE.getEPackage(GlmlPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelSpecificEventEClass.getESuperTypes().add(theGlmlPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelSpecificEventFileEClass, ModelSpecificEventFile.class, "ModelSpecificEventFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSpecificEventFile_Import(), this.getImportStatement(), null, "import", null, 1, 1, ModelSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificEventFile_Events(), this.getModelSpecificEvent(), null, "events", null, 0, -1, ModelSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSpecificEventEClass, ModelSpecificEvent.class, "ModelSpecificEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSpecificEvent_Target(), ecorePackage.getEObject(), null, "target", null, 1, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificEvent_Operations(), theEcorePackage.getEOperation(), null, "operations", null, 0, -1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelSpecificEvent_Condition(), ecorePackage.getEString(), "condition", null, 1, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificEvent_Reification(), theGlmlPackage.getLanguageSpecificEvent(), null, "reification", null, 1, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importStatementEClass, ImportStatement.class, "ImportStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportStatement_DomainSpecificEventFileURI(), ecorePackage.getEString(), "DomainSpecificEventFileURI", null, 1, 1, ImportStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GmmlPackageImpl
