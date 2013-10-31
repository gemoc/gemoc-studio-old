/**
 */
package glml.impl;

import glml.DomainSpecificEventFile;
import glml.GlmlFactory;
import glml.GlmlPackage;
import glml.ImportStatement;
import glml.LanguageSpecificEvent;
import glml.NamedElement;

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
public class GlmlPackageImpl extends EPackageImpl implements GlmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificEventFileEClass = null;

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
	private EClass languageSpecificEventEClass = null;

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
	 * @see glml.GlmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GlmlPackageImpl() {
		super(eNS_URI, GlmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GlmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GlmlPackage init() {
		if (isInited) return (GlmlPackage)EPackage.Registry.INSTANCE.getEPackage(GlmlPackage.eNS_URI);

		// Obtain or create and register package
		GlmlPackageImpl theGlmlPackage = (GlmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GlmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GlmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGlmlPackage.createPackageContents();

		// Initialize created meta-data
		theGlmlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGlmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GlmlPackage.eNS_URI, theGlmlPackage);
		return theGlmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainSpecificEventFile() {
		return domainSpecificEventFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEventFile_Imports() {
		return (EReference)domainSpecificEventFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEventFile_LanguageEvents() {
		return (EReference)domainSpecificEventFileEClass.getEStructuralFeatures().get(1);
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
	public EClass getLanguageSpecificEvent() {
		return languageSpecificEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageSpecificEvent_TargetClass() {
		return (EReference)languageSpecificEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageSpecificEvent_Operations() {
		return (EReference)languageSpecificEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLanguageSpecificEvent_Condition() {
		return (EAttribute)languageSpecificEventEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getImportStatement_ImportURI() {
		return (EAttribute)importStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlmlFactory getGlmlFactory() {
		return (GlmlFactory)getEFactoryInstance();
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
		domainSpecificEventFileEClass = createEClass(DOMAIN_SPECIFIC_EVENT_FILE);
		createEReference(domainSpecificEventFileEClass, DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS);
		createEReference(domainSpecificEventFileEClass, DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		languageSpecificEventEClass = createEClass(LANGUAGE_SPECIFIC_EVENT);
		createEReference(languageSpecificEventEClass, LANGUAGE_SPECIFIC_EVENT__TARGET_CLASS);
		createEReference(languageSpecificEventEClass, LANGUAGE_SPECIFIC_EVENT__OPERATIONS);
		createEAttribute(languageSpecificEventEClass, LANGUAGE_SPECIFIC_EVENT__CONDITION);

		importStatementEClass = createEClass(IMPORT_STATEMENT);
		createEAttribute(importStatementEClass, IMPORT_STATEMENT__IMPORT_URI);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		languageSpecificEventEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainSpecificEventFileEClass, DomainSpecificEventFile.class, "DomainSpecificEventFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificEventFile_Imports(), this.getImportStatement(), null, "imports", null, 0, 1, DomainSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEventFile_LanguageEvents(), this.getLanguageSpecificEvent(), null, "languageEvents", null, 0, -1, DomainSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(languageSpecificEventEClass, LanguageSpecificEvent.class, "LanguageSpecificEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguageSpecificEvent_TargetClass(), theEcorePackage.getEClass(), null, "targetClass", null, 1, 1, LanguageSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageSpecificEvent_Operations(), theEcorePackage.getEOperation(), null, "operations", null, 0, -1, LanguageSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLanguageSpecificEvent_Condition(), ecorePackage.getEString(), "condition", null, 1, 1, LanguageSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importStatementEClass, ImportStatement.class, "ImportStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportStatement_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, -1, ImportStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GlmlPackageImpl
