/**
 */
package gee_configuration.impl;

import gee_configuration.DSAModel;
import gee_configuration.DSEModel;
import gee_configuration.DomainSpecificEditor;
import gee_configuration.DomainSpecificMetamodel;
import gee_configuration.Gee_configurationFactory;
import gee_configuration.Gee_configurationPackage;
import gee_configuration.GemocConfiguration;
import gee_configuration.LocalResource;
import gee_configuration.MoccModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Gee_configurationPackageImpl extends EPackageImpl implements Gee_configurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gemocConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dsaModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moccModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dseModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificMetamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainSpecificEditorEClass = null;

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
	 * @see gee_configuration.Gee_configurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Gee_configurationPackageImpl() {
		super(eNS_URI, Gee_configurationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Gee_configurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Gee_configurationPackage init() {
		if (isInited) return (Gee_configurationPackage)EPackage.Registry.INSTANCE.getEPackage(Gee_configurationPackage.eNS_URI);

		// Obtain or create and register package
		Gee_configurationPackageImpl theGee_configurationPackage = (Gee_configurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Gee_configurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Gee_configurationPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGee_configurationPackage.createPackageContents();

		// Initialize created meta-data
		theGee_configurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGee_configurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Gee_configurationPackage.eNS_URI, theGee_configurationPackage);
		return theGee_configurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGemocConfiguration() {
		return gemocConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocConfiguration_DsaModels() {
		return (EReference)gemocConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocConfiguration_MoccModels() {
		return (EReference)gemocConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocConfiguration_DseModels() {
		return (EReference)gemocConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocConfiguration_DomainSpecificMetamodels() {
		return (EReference)gemocConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocConfiguration_Editors() {
		return (EReference)gemocConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSAModel() {
		return dsaModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoccModel() {
		return moccModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSEModel() {
		return dseModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSEModel_Mapped_mocc() {
		return (EReference)dseModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDSEModel_Mapped_dsa() {
		return (EReference)dseModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainSpecificMetamodel() {
		return domainSpecificMetamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainSpecificMetamodel_Editors() {
		return (EReference)domainSpecificMetamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalResource() {
		return localResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocalResource_Location() {
		return (EAttribute)localResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainSpecificEditor() {
		return domainSpecificEditorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gee_configurationFactory getGee_configurationFactory() {
		return (Gee_configurationFactory)getEFactoryInstance();
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
		gemocConfigurationEClass = createEClass(GEMOC_CONFIGURATION);
		createEReference(gemocConfigurationEClass, GEMOC_CONFIGURATION__DSA_MODELS);
		createEReference(gemocConfigurationEClass, GEMOC_CONFIGURATION__MOCC_MODELS);
		createEReference(gemocConfigurationEClass, GEMOC_CONFIGURATION__DSE_MODELS);
		createEReference(gemocConfigurationEClass, GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS);
		createEReference(gemocConfigurationEClass, GEMOC_CONFIGURATION__EDITORS);

		dsaModelEClass = createEClass(DSA_MODEL);

		moccModelEClass = createEClass(MOCC_MODEL);

		dseModelEClass = createEClass(DSE_MODEL);
		createEReference(dseModelEClass, DSE_MODEL__MAPPED_MOCC);
		createEReference(dseModelEClass, DSE_MODEL__MAPPED_DSA);

		domainSpecificMetamodelEClass = createEClass(DOMAIN_SPECIFIC_METAMODEL);
		createEReference(domainSpecificMetamodelEClass, DOMAIN_SPECIFIC_METAMODEL__EDITORS);

		localResourceEClass = createEClass(LOCAL_RESOURCE);
		createEAttribute(localResourceEClass, LOCAL_RESOURCE__LOCATION);

		domainSpecificEditorEClass = createEClass(DOMAIN_SPECIFIC_EDITOR);
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
		dsaModelEClass.getESuperTypes().add(this.getLocalResource());
		moccModelEClass.getESuperTypes().add(this.getLocalResource());
		dseModelEClass.getESuperTypes().add(this.getLocalResource());
		domainSpecificMetamodelEClass.getESuperTypes().add(this.getLocalResource());
		domainSpecificEditorEClass.getESuperTypes().add(this.getLocalResource());

		// Initialize classes and features; add operations and parameters
		initEClass(gemocConfigurationEClass, GemocConfiguration.class, "GemocConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGemocConfiguration_DsaModels(), this.getDSAModel(), null, "dsaModels", null, 1, -1, GemocConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGemocConfiguration_MoccModels(), this.getMoccModel(), null, "moccModels", null, 1, -1, GemocConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGemocConfiguration_DseModels(), this.getDSEModel(), null, "dseModels", null, 1, -1, GemocConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGemocConfiguration_DomainSpecificMetamodels(), this.getDomainSpecificMetamodel(), null, "domainSpecificMetamodels", null, 1, -1, GemocConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGemocConfiguration_Editors(), this.getDomainSpecificEditor(), null, "editors", null, 0, -1, GemocConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dsaModelEClass, DSAModel.class, "DSAModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moccModelEClass, MoccModel.class, "MoccModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dseModelEClass, DSEModel.class, "DSEModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDSEModel_Mapped_mocc(), this.getMoccModel(), null, "mapped_mocc", null, 1, 1, DSEModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDSEModel_Mapped_dsa(), this.getDSAModel(), null, "mapped_dsa", null, 1, 1, DSEModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainSpecificMetamodelEClass, DomainSpecificMetamodel.class, "DomainSpecificMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainSpecificMetamodel_Editors(), this.getDomainSpecificEditor(), null, "editors", null, 0, -1, DomainSpecificMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localResourceEClass, LocalResource.class, "LocalResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocalResource_Location(), ecorePackage.getEString(), "location", null, 0, 1, LocalResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainSpecificEditorEClass, DomainSpecificEditor.class, "DomainSpecificEditor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Gee_configurationPackageImpl
