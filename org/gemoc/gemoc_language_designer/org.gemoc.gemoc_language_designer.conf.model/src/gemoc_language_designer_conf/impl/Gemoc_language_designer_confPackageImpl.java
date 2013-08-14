/**
 */
package gemoc_language_designer_conf.impl;

import gemoc_language_designer_conf.AnimatorProject;
import gemoc_language_designer_conf.CCSLMoCProject;
import gemoc_language_designer_conf.DSAProject;
import gemoc_language_designer_conf.DSEProject;
import gemoc_language_designer_conf.DomainModelProject;
import gemoc_language_designer_conf.ECLProject;
import gemoc_language_designer_conf.EMFEcoreProject;
import gemoc_language_designer_conf.EcoreModel;
import gemoc_language_designer_conf.EditorProject;
import gemoc_language_designer_conf.FileResource;
import gemoc_language_designer_conf.GemocLanguageDesignerConfiguration;
import gemoc_language_designer_conf.Gemoc_language_designer_confFactory;
import gemoc_language_designer_conf.Gemoc_language_designer_confPackage;
import gemoc_language_designer_conf.Kermeta2DSAProject;
import gemoc_language_designer_conf.LanguageDefinition;
import gemoc_language_designer_conf.MoCProject;
import gemoc_language_designer_conf.ModHelXMoCProject;
import gemoc_language_designer_conf.ODProject;
import gemoc_language_designer_conf.ProjectResource;
import gemoc_language_designer_conf.SiriusAnimatorProject;
import gemoc_language_designer_conf.TreeEditorProject;

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
public class Gemoc_language_designer_confPackageImpl extends EPackageImpl implements Gemoc_language_designer_confPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gemocLanguageDesignerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dsaProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass kermeta2DSAProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass languageDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editorProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainModelProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moCProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ccslMoCProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass animatorProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emfEcoreProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass odProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siriusAnimatorProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modHelXMoCProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dseProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eclProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass treeEditorProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecoreModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileResourceEClass = null;

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
	 * @see gemoc_language_designer_conf.Gemoc_language_designer_confPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Gemoc_language_designer_confPackageImpl() {
		super(eNS_URI, Gemoc_language_designer_confFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Gemoc_language_designer_confPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Gemoc_language_designer_confPackage init() {
		if (isInited) return (Gemoc_language_designer_confPackage)EPackage.Registry.INSTANCE.getEPackage(Gemoc_language_designer_confPackage.eNS_URI);

		// Obtain or create and register package
		Gemoc_language_designer_confPackageImpl theGemoc_language_designer_confPackage = (Gemoc_language_designer_confPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Gemoc_language_designer_confPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Gemoc_language_designer_confPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGemoc_language_designer_confPackage.createPackageContents();

		// Initialize created meta-data
		theGemoc_language_designer_confPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGemoc_language_designer_confPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Gemoc_language_designer_confPackage.eNS_URI, theGemoc_language_designer_confPackage);
		return theGemoc_language_designer_confPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGemocLanguageDesignerConfiguration() {
		return gemocLanguageDesignerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGemocLanguageDesignerConfiguration_LanguageDefinitions() {
		return (EReference)gemocLanguageDesignerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProjectResource() {
		return projectResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSAProject() {
		return dsaProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKermeta2DSAProject() {
		return kermeta2DSAProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLanguageDefinition() {
		return languageDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_DsaProjects() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_DomainModelProject() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_EditorProjects() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_MoCModelProjects() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_AnimatorProjects() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLanguageDefinition_DSEProjects() {
		return (EReference)languageDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditorProject() {
		return editorProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainModelProject() {
		return domainModelProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMoCProject() {
		return moCProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCCSLMoCProject() {
		return ccslMoCProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnimatorProject() {
		return animatorProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMFEcoreProject() {
		return emfEcoreProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMFEcoreProject_EcoreModel() {
		return (EReference)emfEcoreProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getODProject() {
		return odProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSiriusAnimatorProject() {
		return siriusAnimatorProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSiriusAnimatorProject_ODProject() {
		return (EReference)siriusAnimatorProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModHelXMoCProject() {
		return modHelXMoCProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDSEProject() {
		return dseProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECLProject() {
		return eclProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTreeEditorProject() {
		return treeEditorProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEcoreModel() {
		return ecoreModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileResource() {
		return fileResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_language_designer_confFactory getGemoc_language_designer_confFactory() {
		return (Gemoc_language_designer_confFactory)getEFactoryInstance();
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
		gemocLanguageDesignerConfigurationEClass = createEClass(GEMOC_LANGUAGE_DESIGNER_CONFIGURATION);
		createEReference(gemocLanguageDesignerConfigurationEClass, GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS);

		projectResourceEClass = createEClass(PROJECT_RESOURCE);

		dsaProjectEClass = createEClass(DSA_PROJECT);

		kermeta2DSAProjectEClass = createEClass(KERMETA2_DSA_PROJECT);

		languageDefinitionEClass = createEClass(LANGUAGE_DEFINITION);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__DSA_PROJECTS);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__EDITOR_PROJECTS);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__ANIMATOR_PROJECTS);
		createEReference(languageDefinitionEClass, LANGUAGE_DEFINITION__DSE_PROJECTS);

		editorProjectEClass = createEClass(EDITOR_PROJECT);

		domainModelProjectEClass = createEClass(DOMAIN_MODEL_PROJECT);

		moCProjectEClass = createEClass(MO_CPROJECT);

		ccslMoCProjectEClass = createEClass(CCSL_MO_CPROJECT);

		animatorProjectEClass = createEClass(ANIMATOR_PROJECT);

		emfEcoreProjectEClass = createEClass(EMF_ECORE_PROJECT);
		createEReference(emfEcoreProjectEClass, EMF_ECORE_PROJECT__ECORE_MODEL);

		odProjectEClass = createEClass(OD_PROJECT);

		siriusAnimatorProjectEClass = createEClass(SIRIUS_ANIMATOR_PROJECT);
		createEReference(siriusAnimatorProjectEClass, SIRIUS_ANIMATOR_PROJECT__OD_PROJECT);

		modHelXMoCProjectEClass = createEClass(MOD_HEL_XMO_CPROJECT);

		dseProjectEClass = createEClass(DSE_PROJECT);

		eclProjectEClass = createEClass(ECL_PROJECT);

		treeEditorProjectEClass = createEClass(TREE_EDITOR_PROJECT);

		ecoreModelEClass = createEClass(ECORE_MODEL);

		fileResourceEClass = createEClass(FILE_RESOURCE);
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
		dsaProjectEClass.getESuperTypes().add(this.getProjectResource());
		kermeta2DSAProjectEClass.getESuperTypes().add(this.getDSAProject());
		editorProjectEClass.getESuperTypes().add(this.getProjectResource());
		domainModelProjectEClass.getESuperTypes().add(this.getProjectResource());
		moCProjectEClass.getESuperTypes().add(this.getProjectResource());
		ccslMoCProjectEClass.getESuperTypes().add(this.getMoCProject());
		animatorProjectEClass.getESuperTypes().add(this.getProjectResource());
		emfEcoreProjectEClass.getESuperTypes().add(this.getDomainModelProject());
		odProjectEClass.getESuperTypes().add(this.getEditorProject());
		siriusAnimatorProjectEClass.getESuperTypes().add(this.getAnimatorProject());
		modHelXMoCProjectEClass.getESuperTypes().add(this.getMoCProject());
		dseProjectEClass.getESuperTypes().add(this.getProjectResource());
		eclProjectEClass.getESuperTypes().add(this.getDSEProject());
		treeEditorProjectEClass.getESuperTypes().add(this.getEditorProject());
		ecoreModelEClass.getESuperTypes().add(this.getFileResource());

		// Initialize classes and features; add operations and parameters
		initEClass(gemocLanguageDesignerConfigurationEClass, GemocLanguageDesignerConfiguration.class, "GemocLanguageDesignerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGemocLanguageDesignerConfiguration_LanguageDefinitions(), this.getLanguageDefinition(), null, "languageDefinitions", null, 0, -1, GemocLanguageDesignerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(projectResourceEClass, ProjectResource.class, "ProjectResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dsaProjectEClass, DSAProject.class, "DSAProject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(kermeta2DSAProjectEClass, Kermeta2DSAProject.class, "Kermeta2DSAProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(languageDefinitionEClass, LanguageDefinition.class, "LanguageDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLanguageDefinition_DsaProjects(), this.getDSAProject(), null, "dsaProjects", null, 1, -1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageDefinition_DomainModelProject(), this.getDomainModelProject(), null, "domainModelProject", null, 1, 1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageDefinition_EditorProjects(), this.getEditorProject(), null, "editorProjects", null, 1, -1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageDefinition_MoCModelProjects(), this.getMoCProject(), null, "moCModelProjects", null, 1, -1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageDefinition_AnimatorProjects(), this.getAnimatorProject(), null, "animatorProjects", null, 1, -1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLanguageDefinition_DSEProjects(), this.getDSEProject(), null, "dSEProjects", null, 0, -1, LanguageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorProjectEClass, EditorProject.class, "EditorProject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(domainModelProjectEClass, DomainModelProject.class, "DomainModelProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moCProjectEClass, MoCProject.class, "MoCProject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ccslMoCProjectEClass, CCSLMoCProject.class, "CCSLMoCProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(animatorProjectEClass, AnimatorProject.class, "AnimatorProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emfEcoreProjectEClass, EMFEcoreProject.class, "EMFEcoreProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMFEcoreProject_EcoreModel(), this.getEcoreModel(), null, "ecoreModel", null, 1, 1, EMFEcoreProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(odProjectEClass, ODProject.class, "ODProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(siriusAnimatorProjectEClass, SiriusAnimatorProject.class, "SiriusAnimatorProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSiriusAnimatorProject_ODProject(), this.getODProject(), null, "oDProject", null, 1, 1, SiriusAnimatorProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modHelXMoCProjectEClass, ModHelXMoCProject.class, "ModHelXMoCProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dseProjectEClass, DSEProject.class, "DSEProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eclProjectEClass, ECLProject.class, "ECLProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(treeEditorProjectEClass, TreeEditorProject.class, "TreeEditorProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ecoreModelEClass, EcoreModel.class, "EcoreModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileResourceEClass, FileResource.class, "FileResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Gemoc_language_designer_confPackageImpl
