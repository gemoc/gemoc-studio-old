/**
 */
package glml.impl;

import gepl.GeplPackage;

import glml.DomainSpecificAction;
import glml.DomainSpecificEvent;
import glml.DomainSpecificEventFile;
import glml.GlmlFactory;
import glml.GlmlPackage;
import glml.ImportStatement;
import glml.ModelSpecificAction;
import glml.ModelSpecificEvent;
import glml.NamedElement;
import glml.Visibility;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
	private EClass importStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificActionEClass = null;

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
	private EClass modelSpecificActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

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
		GeplPackage.eINSTANCE.eClass();

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
	public EReference getDomainSpecificEventFile_ModelEvents() {
		return (EReference)domainSpecificEventFileEClass.getEStructuralFeatures().get(2);
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
	public EClass getDomainSpecificEvent() {
		return domainSpecificEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEvent_DomainSpecificActions() {
		return (EReference)domainSpecificEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificEvent_Condition() {
		return (EReference)domainSpecificEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainSpecificEvent_Visibility() {
		return (EAttribute)domainSpecificEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainSpecificAction() {
		return domainSpecificActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificAction_TargetClass() {
		return (EReference)domainSpecificActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificAction_Operation() {
		return (EReference)domainSpecificActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificAction_ParameterTypes() {
		return (EReference)domainSpecificActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificAction_OwningDomainSpecificEvent() {
		return (EReference)domainSpecificActionEClass.getEStructuralFeatures().get(3);
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
	public EReference getModelSpecificEvent_Reification() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEvent_ModelSpecificActions() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificEvent_Condition() {
		return (EReference)modelSpecificEventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelSpecificEvent_Visibility() {
		return (EAttribute)modelSpecificEventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelSpecificAction() {
		return modelSpecificActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificAction_Reification() {
		return (EReference)modelSpecificActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificAction_Target() {
		return (EReference)modelSpecificActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificAction_Operation() {
		return (EReference)modelSpecificActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificAction_Parameters() {
		return (EReference)modelSpecificActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelSpecificAction_OwningModelSpecificEvent() {
		return (EReference)modelSpecificActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibility() {
		return visibilityEEnum;
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
		createEReference(domainSpecificEventFileEClass, DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		importStatementEClass = createEClass(IMPORT_STATEMENT);
		createEAttribute(importStatementEClass, IMPORT_STATEMENT__IMPORT_URI);

		domainSpecificEventEClass = createEClass(DOMAIN_SPECIFIC_EVENT);
		createEReference(domainSpecificEventEClass, DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS);
		createEReference(domainSpecificEventEClass, DOMAIN_SPECIFIC_EVENT__CONDITION);
		createEAttribute(domainSpecificEventEClass, DOMAIN_SPECIFIC_EVENT__VISIBILITY);

		domainSpecificActionEClass = createEClass(DOMAIN_SPECIFIC_ACTION);
		createEReference(domainSpecificActionEClass, DOMAIN_SPECIFIC_ACTION__TARGET_CLASS);
		createEReference(domainSpecificActionEClass, DOMAIN_SPECIFIC_ACTION__OPERATION);
		createEReference(domainSpecificActionEClass, DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES);
		createEReference(domainSpecificActionEClass, DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT);

		modelSpecificEventEClass = createEClass(MODEL_SPECIFIC_EVENT);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__REIFICATION);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__MODEL_SPECIFIC_ACTIONS);
		createEReference(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__CONDITION);
		createEAttribute(modelSpecificEventEClass, MODEL_SPECIFIC_EVENT__VISIBILITY);

		modelSpecificActionEClass = createEClass(MODEL_SPECIFIC_ACTION);
		createEReference(modelSpecificActionEClass, MODEL_SPECIFIC_ACTION__REIFICATION);
		createEReference(modelSpecificActionEClass, MODEL_SPECIFIC_ACTION__TARGET);
		createEReference(modelSpecificActionEClass, MODEL_SPECIFIC_ACTION__OPERATION);
		createEReference(modelSpecificActionEClass, MODEL_SPECIFIC_ACTION__PARAMETERS);
		createEReference(modelSpecificActionEClass, MODEL_SPECIFIC_ACTION__OWNING_MODEL_SPECIFIC_EVENT);

		// Create enums
		visibilityEEnum = createEEnum(VISIBILITY);
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
		GeplPackage theGeplPackage = (GeplPackage)EPackage.Registry.INSTANCE.getEPackage(GeplPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		domainSpecificEventFileEClass.getESuperTypes().add(this.getNamedElement());
		domainSpecificEventEClass.getESuperTypes().add(this.getNamedElement());
		modelSpecificEventEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(domainSpecificEventFileEClass, DomainSpecificEventFile.class, "DomainSpecificEventFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificEventFile_Imports(), this.getImportStatement(), null, "imports", null, 0, -1, DomainSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEventFile_LanguageEvents(), this.getDomainSpecificEvent(), null, "languageEvents", null, 0, -1, DomainSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEventFile_ModelEvents(), this.getModelSpecificEvent(), null, "modelEvents", null, 0, -1, DomainSpecificEventFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importStatementEClass, ImportStatement.class, "ImportStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportStatement_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, -1, ImportStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainSpecificEventEClass, DomainSpecificEvent.class, "DomainSpecificEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificEvent_DomainSpecificActions(), this.getDomainSpecificAction(), this.getDomainSpecificAction_OwningDomainSpecificEvent(), "domainSpecificActions", null, 0, -1, DomainSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificEvent_Condition(), theGeplPackage.getPattern(), null, "condition", null, 1, 1, DomainSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainSpecificEvent_Visibility(), this.getVisibility(), "visibility", null, 1, 1, DomainSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainSpecificActionEClass, DomainSpecificAction.class, "DomainSpecificAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificAction_TargetClass(), theEcorePackage.getEClassifier(), null, "targetClass", null, 1, 1, DomainSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificAction_Operation(), theEcorePackage.getEOperation(), null, "operation", null, 1, 1, DomainSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificAction_ParameterTypes(), theEcorePackage.getEClassifier(), null, "parameterTypes", null, 0, -1, DomainSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainSpecificAction_OwningDomainSpecificEvent(), this.getDomainSpecificEvent(), this.getDomainSpecificEvent_DomainSpecificActions(), "owningDomainSpecificEvent", null, 1, 1, DomainSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSpecificEventEClass, ModelSpecificEvent.class, "ModelSpecificEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSpecificEvent_Reification(), this.getDomainSpecificEvent(), null, "reification", null, 0, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificEvent_ModelSpecificActions(), this.getModelSpecificAction(), this.getModelSpecificAction_OwningModelSpecificEvent(), "modelSpecificActions", null, 0, -1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificEvent_Condition(), theGeplPackage.getPattern(), null, "condition", null, 1, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelSpecificEvent_Visibility(), this.getVisibility(), "visibility", null, 1, 1, ModelSpecificEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelSpecificActionEClass, ModelSpecificAction.class, "ModelSpecificAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelSpecificAction_Reification(), this.getDomainSpecificAction(), null, "reification", null, 1, 1, ModelSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificAction_Target(), theEcorePackage.getEObject(), null, "target", null, 1, 1, ModelSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificAction_Operation(), theEcorePackage.getEOperation(), null, "operation", null, 1, 1, ModelSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificAction_Parameters(), theEcorePackage.getEObject(), null, "parameters", null, 0, -1, ModelSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelSpecificAction_OwningModelSpecificEvent(), this.getModelSpecificEvent(), this.getModelSpecificEvent_ModelSpecificActions(), "owningModelSpecificEvent", null, 1, 1, ModelSpecificAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);

		// Create resource
		createResource(eNS_URI);
	}

} //GlmlPackageImpl
