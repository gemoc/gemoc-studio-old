/**
 */
package gemoc_language_designer_conf;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see gemoc_language_designer_conf.Gemoc_language_designer_confFactory
 * @model kind="package"
 * @generated
 */
public interface Gemoc_language_designer_confPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gemoc_language_designer_conf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.gemoc.org/gemoc_language_designer_conf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gemoc_language_designer_conf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Gemoc_language_designer_confPackage eINSTANCE = gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl.init();

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.GemocLanguageDesignerConfigurationImpl <em>Gemoc Language Designer Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.GemocLanguageDesignerConfigurationImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getGemocLanguageDesignerConfiguration()
	 * @generated
	 */
	int GEMOC_LANGUAGE_DESIGNER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Language Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS = 0;

	/**
	 * The number of structural features of the '<em>Gemoc Language Designer Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_LANGUAGE_DESIGNER_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.ProjectResourceImpl <em>Project Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.ProjectResourceImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getProjectResource()
	 * @generated
	 */
	int PROJECT_RESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Project Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.DSAProjectImpl <em>DSA Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.DSAProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDSAProject()
	 * @generated
	 */
	int DSA_PROJECT = 2;

	/**
	 * The number of structural features of the '<em>DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.Kermeta2DSAProjectImpl <em>Kermeta2 DSA Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.Kermeta2DSAProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getKermeta2DSAProject()
	 * @generated
	 */
	int KERMETA2_DSA_PROJECT = 3;

	/**
	 * The number of structural features of the '<em>Kermeta2 DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERMETA2_DSA_PROJECT_FEATURE_COUNT = DSA_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.LanguageDefinitionImpl <em>Language Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.LanguageDefinitionImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getLanguageDefinition()
	 * @generated
	 */
	int LANGUAGE_DEFINITION = 4;

	/**
	 * The feature id for the '<em><b>Dsa Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__DSA_PROJECTS = 0;

	/**
	 * The feature id for the '<em><b>Domain Model Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Editor Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__EDITOR_PROJECTS = 2;

	/**
	 * The feature id for the '<em><b>Mo CModel Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS = 3;

	/**
	 * The feature id for the '<em><b>Animator Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__ANIMATOR_PROJECTS = 4;

	/**
	 * The feature id for the '<em><b>DSE Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__DSE_PROJECTS = 5;

	/**
	 * The number of structural features of the '<em>Language Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.EditorProjectImpl <em>Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.EditorProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEditorProject()
	 * @generated
	 */
	int EDITOR_PROJECT = 5;

	/**
	 * The number of structural features of the '<em>Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.DomainModelProjectImpl <em>Domain Model Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.DomainModelProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDomainModelProject()
	 * @generated
	 */
	int DOMAIN_MODEL_PROJECT = 6;

	/**
	 * The number of structural features of the '<em>Domain Model Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.MoCProjectImpl <em>Mo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.MoCProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getMoCProject()
	 * @generated
	 */
	int MO_CPROJECT = 7;

	/**
	 * The number of structural features of the '<em>Mo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.CCSLMoCProjectImpl <em>CCSL Mo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.CCSLMoCProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getCCSLMoCProject()
	 * @generated
	 */
	int CCSL_MO_CPROJECT = 8;

	/**
	 * The number of structural features of the '<em>CCSL Mo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_MO_CPROJECT_FEATURE_COUNT = MO_CPROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.AnimatorProjectImpl <em>Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.AnimatorProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getAnimatorProject()
	 * @generated
	 */
	int ANIMATOR_PROJECT = 9;

	/**
	 * The number of structural features of the '<em>Animator Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATOR_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.EMFEcoreProjectImpl <em>EMF Ecore Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.EMFEcoreProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEMFEcoreProject()
	 * @generated
	 */
	int EMF_ECORE_PROJECT = 10;

	/**
	 * The feature id for the '<em><b>Ecore Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT__ECORE_MODEL = DOMAIN_MODEL_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EMF Ecore Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT_FEATURE_COUNT = DOMAIN_MODEL_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.ODProjectImpl <em>OD Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.ODProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getODProject()
	 * @generated
	 */
	int OD_PROJECT = 11;

	/**
	 * The number of structural features of the '<em>OD Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OD_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.SiriusAnimatorProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getSiriusAnimatorProject()
	 * @generated
	 */
	int SIRIUS_ANIMATOR_PROJECT = 12;

	/**
	 * The feature id for the '<em><b>OD Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_ANIMATOR_PROJECT__OD_PROJECT = ANIMATOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sirius Animator Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_ANIMATOR_PROJECT_FEATURE_COUNT = ANIMATOR_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.ModHelXMoCProjectImpl <em>Mod Hel XMo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.ModHelXMoCProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getModHelXMoCProject()
	 * @generated
	 */
	int MOD_HEL_XMO_CPROJECT = 13;

	/**
	 * The number of structural features of the '<em>Mod Hel XMo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_HEL_XMO_CPROJECT_FEATURE_COUNT = MO_CPROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.DSEProjectImpl <em>DSE Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.DSEProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDSEProject()
	 * @generated
	 */
	int DSE_PROJECT = 14;

	/**
	 * The number of structural features of the '<em>DSE Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.ECLProjectImpl <em>ECL Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.ECLProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getECLProject()
	 * @generated
	 */
	int ECL_PROJECT = 15;

	/**
	 * The number of structural features of the '<em>ECL Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_PROJECT_FEATURE_COUNT = DSE_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.TreeEditorProjectImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getTreeEditorProject()
	 * @generated
	 */
	int TREE_EDITOR_PROJECT = 16;

	/**
	 * The number of structural features of the '<em>Tree Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_EDITOR_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.FileResourceImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 18;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link gemoc_language_designer_conf.impl.EcoreModelImpl <em>Ecore Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gemoc_language_designer_conf.impl.EcoreModelImpl
	 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEcoreModel()
	 * @generated
	 */
	int ECORE_MODEL = 17;

	/**
	 * The number of structural features of the '<em>Ecore Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_MODEL_FEATURE_COUNT = FILE_RESOURCE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.GemocLanguageDesignerConfiguration <em>Gemoc Language Designer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gemoc Language Designer Configuration</em>'.
	 * @see gemoc_language_designer_conf.GemocLanguageDesignerConfiguration
	 * @generated
	 */
	EClass getGemocLanguageDesignerConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.GemocLanguageDesignerConfiguration#getLanguageDefinitions <em>Language Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Language Definitions</em>'.
	 * @see gemoc_language_designer_conf.GemocLanguageDesignerConfiguration#getLanguageDefinitions()
	 * @see #getGemocLanguageDesignerConfiguration()
	 * @generated
	 */
	EReference getGemocLanguageDesignerConfiguration_LanguageDefinitions();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.ProjectResource <em>Project Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Resource</em>'.
	 * @see gemoc_language_designer_conf.ProjectResource
	 * @generated
	 */
	EClass getProjectResource();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.DSAProject <em>DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSA Project</em>'.
	 * @see gemoc_language_designer_conf.DSAProject
	 * @generated
	 */
	EClass getDSAProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.Kermeta2DSAProject <em>Kermeta2 DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kermeta2 DSA Project</em>'.
	 * @see gemoc_language_designer_conf.Kermeta2DSAProject
	 * @generated
	 */
	EClass getKermeta2DSAProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.LanguageDefinition <em>Language Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Definition</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition
	 * @generated
	 */
	EClass getLanguageDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.LanguageDefinition#getDsaProjects <em>Dsa Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dsa Projects</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getDsaProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DsaProjects();

	/**
	 * Returns the meta object for the containment reference '{@link gemoc_language_designer_conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain Model Project</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getDomainModelProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DomainModelProject();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.LanguageDefinition#getEditorProjects <em>Editor Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editor Projects</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getEditorProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_EditorProjects();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.LanguageDefinition#getMoCModelProjects <em>Mo CModel Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mo CModel Projects</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getMoCModelProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_MoCModelProjects();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.LanguageDefinition#getAnimatorProjects <em>Animator Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animator Projects</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getAnimatorProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_AnimatorProjects();

	/**
	 * Returns the meta object for the containment reference list '{@link gemoc_language_designer_conf.LanguageDefinition#getDSEProjects <em>DSE Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>DSE Projects</em>'.
	 * @see gemoc_language_designer_conf.LanguageDefinition#getDSEProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DSEProjects();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.EditorProject <em>Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Project</em>'.
	 * @see gemoc_language_designer_conf.EditorProject
	 * @generated
	 */
	EClass getEditorProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.DomainModelProject <em>Domain Model Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Model Project</em>'.
	 * @see gemoc_language_designer_conf.DomainModelProject
	 * @generated
	 */
	EClass getDomainModelProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.MoCProject <em>Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CProject</em>'.
	 * @see gemoc_language_designer_conf.MoCProject
	 * @generated
	 */
	EClass getMoCProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.CCSLMoCProject <em>CCSL Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Mo CProject</em>'.
	 * @see gemoc_language_designer_conf.CCSLMoCProject
	 * @generated
	 */
	EClass getCCSLMoCProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.AnimatorProject <em>Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animator Project</em>'.
	 * @see gemoc_language_designer_conf.AnimatorProject
	 * @generated
	 */
	EClass getAnimatorProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.EMFEcoreProject <em>EMF Ecore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Ecore Project</em>'.
	 * @see gemoc_language_designer_conf.EMFEcoreProject
	 * @generated
	 */
	EClass getEMFEcoreProject();

	/**
	 * Returns the meta object for the containment reference '{@link gemoc_language_designer_conf.EMFEcoreProject#getEcoreModel <em>Ecore Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ecore Model</em>'.
	 * @see gemoc_language_designer_conf.EMFEcoreProject#getEcoreModel()
	 * @see #getEMFEcoreProject()
	 * @generated
	 */
	EReference getEMFEcoreProject_EcoreModel();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.ODProject <em>OD Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OD Project</em>'.
	 * @see gemoc_language_designer_conf.ODProject
	 * @generated
	 */
	EClass getODProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.SiriusAnimatorProject <em>Sirius Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sirius Animator Project</em>'.
	 * @see gemoc_language_designer_conf.SiriusAnimatorProject
	 * @generated
	 */
	EClass getSiriusAnimatorProject();

	/**
	 * Returns the meta object for the reference '{@link gemoc_language_designer_conf.SiriusAnimatorProject#getODProject <em>OD Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>OD Project</em>'.
	 * @see gemoc_language_designer_conf.SiriusAnimatorProject#getODProject()
	 * @see #getSiriusAnimatorProject()
	 * @generated
	 */
	EReference getSiriusAnimatorProject_ODProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.ModHelXMoCProject <em>Mod Hel XMo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mod Hel XMo CProject</em>'.
	 * @see gemoc_language_designer_conf.ModHelXMoCProject
	 * @generated
	 */
	EClass getModHelXMoCProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.DSEProject <em>DSE Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSE Project</em>'.
	 * @see gemoc_language_designer_conf.DSEProject
	 * @generated
	 */
	EClass getDSEProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.ECLProject <em>ECL Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECL Project</em>'.
	 * @see gemoc_language_designer_conf.ECLProject
	 * @generated
	 */
	EClass getECLProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.TreeEditorProject <em>Tree Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Editor Project</em>'.
	 * @see gemoc_language_designer_conf.TreeEditorProject
	 * @generated
	 */
	EClass getTreeEditorProject();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.EcoreModel <em>Ecore Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Model</em>'.
	 * @see gemoc_language_designer_conf.EcoreModel
	 * @generated
	 */
	EClass getEcoreModel();

	/**
	 * Returns the meta object for class '{@link gemoc_language_designer_conf.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see gemoc_language_designer_conf.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Gemoc_language_designer_confFactory getGemoc_language_designer_confFactory();

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
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.GemocLanguageDesignerConfigurationImpl <em>Gemoc Language Designer Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.GemocLanguageDesignerConfigurationImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getGemocLanguageDesignerConfiguration()
		 * @generated
		 */
		EClass GEMOC_LANGUAGE_DESIGNER_CONFIGURATION = eINSTANCE.getGemocLanguageDesignerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Language Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_LANGUAGE_DESIGNER_CONFIGURATION__LANGUAGE_DEFINITIONS = eINSTANCE.getGemocLanguageDesignerConfiguration_LanguageDefinitions();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.ProjectResourceImpl <em>Project Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.ProjectResourceImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getProjectResource()
		 * @generated
		 */
		EClass PROJECT_RESOURCE = eINSTANCE.getProjectResource();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.DSAProjectImpl <em>DSA Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.DSAProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDSAProject()
		 * @generated
		 */
		EClass DSA_PROJECT = eINSTANCE.getDSAProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.Kermeta2DSAProjectImpl <em>Kermeta2 DSA Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.Kermeta2DSAProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getKermeta2DSAProject()
		 * @generated
		 */
		EClass KERMETA2_DSA_PROJECT = eINSTANCE.getKermeta2DSAProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.LanguageDefinitionImpl <em>Language Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.LanguageDefinitionImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getLanguageDefinition()
		 * @generated
		 */
		EClass LANGUAGE_DEFINITION = eINSTANCE.getLanguageDefinition();

		/**
		 * The meta object literal for the '<em><b>Dsa Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__DSA_PROJECTS = eINSTANCE.getLanguageDefinition_DsaProjects();

		/**
		 * The meta object literal for the '<em><b>Domain Model Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__DOMAIN_MODEL_PROJECT = eINSTANCE.getLanguageDefinition_DomainModelProject();

		/**
		 * The meta object literal for the '<em><b>Editor Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__EDITOR_PROJECTS = eINSTANCE.getLanguageDefinition_EditorProjects();

		/**
		 * The meta object literal for the '<em><b>Mo CModel Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__MO_CMODEL_PROJECTS = eINSTANCE.getLanguageDefinition_MoCModelProjects();

		/**
		 * The meta object literal for the '<em><b>Animator Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__ANIMATOR_PROJECTS = eINSTANCE.getLanguageDefinition_AnimatorProjects();

		/**
		 * The meta object literal for the '<em><b>DSE Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__DSE_PROJECTS = eINSTANCE.getLanguageDefinition_DSEProjects();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.EditorProjectImpl <em>Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.EditorProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEditorProject()
		 * @generated
		 */
		EClass EDITOR_PROJECT = eINSTANCE.getEditorProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.DomainModelProjectImpl <em>Domain Model Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.DomainModelProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDomainModelProject()
		 * @generated
		 */
		EClass DOMAIN_MODEL_PROJECT = eINSTANCE.getDomainModelProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.MoCProjectImpl <em>Mo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.MoCProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getMoCProject()
		 * @generated
		 */
		EClass MO_CPROJECT = eINSTANCE.getMoCProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.CCSLMoCProjectImpl <em>CCSL Mo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.CCSLMoCProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getCCSLMoCProject()
		 * @generated
		 */
		EClass CCSL_MO_CPROJECT = eINSTANCE.getCCSLMoCProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.AnimatorProjectImpl <em>Animator Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.AnimatorProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getAnimatorProject()
		 * @generated
		 */
		EClass ANIMATOR_PROJECT = eINSTANCE.getAnimatorProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.EMFEcoreProjectImpl <em>EMF Ecore Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.EMFEcoreProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEMFEcoreProject()
		 * @generated
		 */
		EClass EMF_ECORE_PROJECT = eINSTANCE.getEMFEcoreProject();

		/**
		 * The meta object literal for the '<em><b>Ecore Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMF_ECORE_PROJECT__ECORE_MODEL = eINSTANCE.getEMFEcoreProject_EcoreModel();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.ODProjectImpl <em>OD Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.ODProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getODProject()
		 * @generated
		 */
		EClass OD_PROJECT = eINSTANCE.getODProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.SiriusAnimatorProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getSiriusAnimatorProject()
		 * @generated
		 */
		EClass SIRIUS_ANIMATOR_PROJECT = eINSTANCE.getSiriusAnimatorProject();

		/**
		 * The meta object literal for the '<em><b>OD Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIRIUS_ANIMATOR_PROJECT__OD_PROJECT = eINSTANCE.getSiriusAnimatorProject_ODProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.ModHelXMoCProjectImpl <em>Mod Hel XMo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.ModHelXMoCProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getModHelXMoCProject()
		 * @generated
		 */
		EClass MOD_HEL_XMO_CPROJECT = eINSTANCE.getModHelXMoCProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.DSEProjectImpl <em>DSE Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.DSEProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getDSEProject()
		 * @generated
		 */
		EClass DSE_PROJECT = eINSTANCE.getDSEProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.ECLProjectImpl <em>ECL Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.ECLProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getECLProject()
		 * @generated
		 */
		EClass ECL_PROJECT = eINSTANCE.getECLProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.TreeEditorProjectImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getTreeEditorProject()
		 * @generated
		 */
		EClass TREE_EDITOR_PROJECT = eINSTANCE.getTreeEditorProject();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.EcoreModelImpl <em>Ecore Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.EcoreModelImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getEcoreModel()
		 * @generated
		 */
		EClass ECORE_MODEL = eINSTANCE.getEcoreModel();

		/**
		 * The meta object literal for the '{@link gemoc_language_designer_conf.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gemoc_language_designer_conf.impl.FileResourceImpl
		 * @see gemoc_language_designer_conf.impl.Gemoc_language_designer_confPackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

	}

} //Gemoc_language_designer_confPackage
