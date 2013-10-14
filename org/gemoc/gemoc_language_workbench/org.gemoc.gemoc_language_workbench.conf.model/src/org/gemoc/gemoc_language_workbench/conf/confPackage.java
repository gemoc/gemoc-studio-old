/**
 */
package org.gemoc.gemoc_language_workbench.conf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.gemoc.gemoc_language_workbench.conf.confFactory
 * @model kind="package"
 * @generated
 */
public interface confPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "conf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.gemoc.org/gemoc_language_workbench_conf";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "conf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	confPackage eINSTANCE = org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl <em>Gemoc Language Workbench Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getGemocLanguageWorkbenchConfiguration()
	 * @generated
	 */
	int GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Language Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITIONS = 0;

	/**
	 * The number of structural features of the '<em>Gemoc Language Workbench Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl <em>Project Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectResource()
	 * @generated
	 */
	int PROJECT_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESOURCE__PROJECT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESOURCE__PROJECT_KIND = 1;

	/**
	 * The number of structural features of the '<em>Project Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DSAProjectImpl <em>DSA Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.DSAProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDSAProject()
	 * @generated
	 */
	int DSA_PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.Kermeta2DSAProjectImpl <em>Kermeta2 DSA Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.Kermeta2DSAProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getKermeta2DSAProject()
	 * @generated
	 */
	int KERMETA2_DSA_PROJECT = 3;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERMETA2_DSA_PROJECT__PROJECT_NAME = DSA_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERMETA2_DSA_PROJECT__PROJECT_KIND = DSA_PROJECT__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Kermeta2 DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KERMETA2_DSA_PROJECT_FEATURE_COUNT = DSA_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl <em>Language Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getLanguageDefinition()
	 * @generated
	 */
	int LANGUAGE_DEFINITION = 4;

	/**
	 * The feature id for the '<em><b>Dsa Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__DSA_PROJECT = 0;

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
	 * The feature id for the '<em><b>Mo CModel Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__MO_CMODEL_PROJECT = 3;

	/**
	 * The feature id for the '<em><b>Animator Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__ANIMATOR_PROJECTS = 4;

	/**
	 * The feature id for the '<em><b>DSE Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__DSE_PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__NAME = 6;

	/**
	 * The number of structural features of the '<em>Language Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl <em>Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEditorProject()
	 * @generated
	 */
	int EDITOR_PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PROJECT__FILE_EXTENSION = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DomainModelProjectImpl <em>Domain Model Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.DomainModelProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDomainModelProject()
	 * @generated
	 */
	int DOMAIN_MODEL_PROJECT = 6;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Domain Model Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.MoCProjectImpl <em>Mo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.MoCProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getMoCProject()
	 * @generated
	 */
	int MO_CPROJECT = 7;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Mo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CPROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.CCSLMoCProjectImpl <em>CCSL Mo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.CCSLMoCProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getCCSLMoCProject()
	 * @generated
	 */
	int CCSL_MO_CPROJECT = 8;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_MO_CPROJECT__PROJECT_NAME = MO_CPROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_MO_CPROJECT__PROJECT_KIND = MO_CPROJECT__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>CCSL Mo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CCSL_MO_CPROJECT_FEATURE_COUNT = MO_CPROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl <em>Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getAnimatorProject()
	 * @generated
	 */
	int ANIMATOR_PROJECT = 9;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATOR_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATOR_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Animator Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANIMATOR_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl <em>EMF Ecore Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEMFEcoreProject()
	 * @generated
	 */
	int EMF_ECORE_PROJECT = 10;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT__PROJECT_NAME = DOMAIN_MODEL_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT__PROJECT_KIND = DOMAIN_MODEL_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>Emf Genmodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT__EMF_GENMODEL = DOMAIN_MODEL_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Root EObject Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME = DOMAIN_MODEL_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>EMF Ecore Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_ECORE_PROJECT_FEATURE_COUNT = DOMAIN_MODEL_PROJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ODProjectImpl <em>OD Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ODProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getODProject()
	 * @generated
	 */
	int OD_PROJECT = 11;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OD_PROJECT__PROJECT_NAME = EDITOR_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OD_PROJECT__PROJECT_KIND = EDITOR_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OD_PROJECT__FILE_EXTENSION = EDITOR_PROJECT__FILE_EXTENSION;

	/**
	 * The number of structural features of the '<em>OD Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OD_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusAnimatorProject()
	 * @generated
	 */
	int SIRIUS_ANIMATOR_PROJECT = 12;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_ANIMATOR_PROJECT__PROJECT_NAME = ANIMATOR_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_ANIMATOR_PROJECT__PROJECT_KIND = ANIMATOR_PROJECT__PROJECT_KIND;

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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ModHelXMoCProjectImpl <em>Mod Hel XMo CProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ModHelXMoCProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getModHelXMoCProject()
	 * @generated
	 */
	int MOD_HEL_XMO_CPROJECT = 13;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_HEL_XMO_CPROJECT__PROJECT_NAME = MO_CPROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_HEL_XMO_CPROJECT__PROJECT_KIND = MO_CPROJECT__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Mod Hel XMo CProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOD_HEL_XMO_CPROJECT_FEATURE_COUNT = MO_CPROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl <em>DSE Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDSEProject()
	 * @generated
	 */
	int DSE_PROJECT = 14;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>DSE Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl <em>ECL Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getECLProject()
	 * @generated
	 */
	int ECL_PROJECT = 15;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_PROJECT__PROJECT_NAME = DSE_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_PROJECT__PROJECT_KIND = DSE_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>Ecl File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_PROJECT__ECL_FILE = DSE_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ECL Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_PROJECT_FEATURE_COUNT = DSE_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getTreeEditorProject()
	 * @generated
	 */
	int TREE_EDITOR_PROJECT = 16;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_EDITOR_PROJECT__PROJECT_NAME = EDITOR_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_EDITOR_PROJECT__PROJECT_KIND = EDITOR_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_EDITOR_PROJECT__FILE_EXTENSION = EDITOR_PROJECT__FILE_EXTENSION;

	/**
	 * The number of structural features of the '<em>Tree Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREE_EDITOR_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.FileResourceImpl <em>File Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.FileResourceImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getFileResource()
	 * @generated
	 */
	int FILE_RESOURCE = 18;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE__LOCATION_URI = 0;

	/**
	 * The number of structural features of the '<em>File Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFGenmodelImpl <em>EMF Genmodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.EMFGenmodelImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEMFGenmodel()
	 * @generated
	 */
	int EMF_GENMODEL = 17;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_GENMODEL__LOCATION_URI = FILE_RESOURCE__LOCATION_URI;

	/**
	 * The number of structural features of the '<em>EMF Genmodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMF_GENMODEL_FEATURE_COUNT = FILE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl <em>XText Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getXTextEditorProject()
	 * @generated
	 */
	int XTEXT_EDITOR_PROJECT = 19;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEXT_EDITOR_PROJECT__PROJECT_NAME = EDITOR_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEXT_EDITOR_PROJECT__PROJECT_KIND = EDITOR_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEXT_EDITOR_PROJECT__FILE_EXTENSION = EDITOR_PROJECT__FILE_EXTENSION;

	/**
	 * The feature id for the '<em><b>Grammar Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEXT_EDITOR_PROJECT__GRAMMAR_NAME = EDITOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XText Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEXT_EDITOR_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.K3DSAProjectImpl <em>K3DSA Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.K3DSAProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getK3DSAProject()
	 * @generated
	 */
	int K3DSA_PROJECT = 20;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3DSA_PROJECT__PROJECT_NAME = DSA_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3DSA_PROJECT__PROJECT_KIND = DSA_PROJECT__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>K3DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int K3DSA_PROJECT_FEATURE_COUNT = DSA_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLFileImpl <em>ECL File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ECLFileImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getECLFile()
	 * @generated
	 */
	int ECL_FILE = 21;

	/**
	 * The feature id for the '<em><b>Location URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_FILE__LOCATION_URI = FILE_RESOURCE__LOCATION_URI;

	/**
	 * The number of structural features of the '<em>ECL File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_FILE_FEATURE_COUNT = FILE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.ProjectKind <em>Project Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectKind
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectKind()
	 * @generated
	 */
	int PROJECT_KIND = 22;


	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration <em>Gemoc Language Workbench Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gemoc Language Workbench Configuration</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration
	 * @generated
	 */
	EClass getGemocLanguageWorkbenchConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getLanguageDefinitions <em>Language Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Language Definitions</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.GemocLanguageWorkbenchConfiguration#getLanguageDefinitions()
	 * @see #getGemocLanguageWorkbenchConfiguration()
	 * @generated
	 */
	EReference getGemocLanguageWorkbenchConfiguration_LanguageDefinitions();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.ProjectResource <em>Project Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Resource</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectResource
	 * @generated
	 */
	EClass getProjectResource();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.ProjectResource#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectResource#getProjectName()
	 * @see #getProjectResource()
	 * @generated
	 */
	EAttribute getProjectResource_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.ProjectResource#getProjectKind <em>Project Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Kind</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectResource#getProjectKind()
	 * @see #getProjectResource()
	 * @generated
	 */
	EAttribute getProjectResource_ProjectKind();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject <em>DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSA Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSAProject
	 * @generated
	 */
	EClass getDSAProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.Kermeta2DSAProject <em>Kermeta2 DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Kermeta2 DSA Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.Kermeta2DSAProject
	 * @generated
	 */
	EClass getKermeta2DSAProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition <em>Language Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Definition</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition
	 * @generated
	 */
	EClass getLanguageDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDsaProject <em>Dsa Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dsa Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDsaProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DsaProject();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDomainModelProject <em>Domain Model Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain Model Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDomainModelProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DomainModelProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getEditorProjects <em>Editor Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editor Projects</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getEditorProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_EditorProjects();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCModelProject <em>Mo CModel Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mo CModel Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCModelProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_MoCModelProject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getAnimatorProjects <em>Animator Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Animator Projects</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getAnimatorProjects()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_AnimatorProjects();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDSEProject <em>DSE Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>DSE Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getDSEProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_DSEProject();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getName()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EAttribute getLanguageDefinition_Name();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.EditorProject <em>Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EditorProject
	 * @generated
	 */
	EClass getEditorProject();

	/**
	 * Returns the meta object for the attribute list '{@link org.gemoc.gemoc_language_workbench.conf.EditorProject#getFileExtension <em>File Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>File Extension</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EditorProject#getFileExtension()
	 * @see #getEditorProject()
	 * @generated
	 */
	EAttribute getEditorProject_FileExtension();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.DomainModelProject <em>Domain Model Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Model Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DomainModelProject
	 * @generated
	 */
	EClass getDomainModelProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.MoCProject <em>Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CProject</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.MoCProject
	 * @generated
	 */
	EClass getMoCProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.CCSLMoCProject <em>CCSL Mo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CCSL Mo CProject</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.CCSLMoCProject
	 * @generated
	 */
	EClass getCCSLMoCProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.AnimatorProject <em>Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Animator Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.AnimatorProject
	 * @generated
	 */
	EClass getAnimatorProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject <em>EMF Ecore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Ecore Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject
	 * @generated
	 */
	EClass getEMFEcoreProject();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getEmfGenmodel <em>Emf Genmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Emf Genmodel</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getEmfGenmodel()
	 * @see #getEMFEcoreProject()
	 * @generated
	 */
	EReference getEMFEcoreProject_EmfGenmodel();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getDefaultRootEObjectQualifiedName <em>Default Root EObject Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Root EObject Qualified Name</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFEcoreProject#getDefaultRootEObjectQualifiedName()
	 * @see #getEMFEcoreProject()
	 * @generated
	 */
	EAttribute getEMFEcoreProject_DefaultRootEObjectQualifiedName();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.ODProject <em>OD Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OD Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ODProject
	 * @generated
	 */
	EClass getODProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject <em>Sirius Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sirius Animator Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject
	 * @generated
	 */
	EClass getSiriusAnimatorProject();

	/**
	 * Returns the meta object for the reference '{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject#getODProject <em>OD Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>OD Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject#getODProject()
	 * @see #getSiriusAnimatorProject()
	 * @generated
	 */
	EReference getSiriusAnimatorProject_ODProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.ModHelXMoCProject <em>Mod Hel XMo CProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mod Hel XMo CProject</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ModHelXMoCProject
	 * @generated
	 */
	EClass getModHelXMoCProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.DSEProject <em>DSE Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSE Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSEProject
	 * @generated
	 */
	EClass getDSEProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.ECLProject <em>ECL Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECL Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ECLProject
	 * @generated
	 */
	EClass getECLProject();

	/**
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.ECLProject#getEclFile <em>Ecl File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ecl File</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ECLProject#getEclFile()
	 * @see #getECLProject()
	 * @generated
	 */
	EReference getECLProject_EclFile();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.TreeEditorProject <em>Tree Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Editor Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.TreeEditorProject
	 * @generated
	 */
	EClass getTreeEditorProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.EMFGenmodel <em>EMF Genmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EMF Genmodel</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.EMFGenmodel
	 * @generated
	 */
	EClass getEMFGenmodel();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Resource</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.FileResource
	 * @generated
	 */
	EClass getFileResource();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.FileResource#getLocationURI <em>Location URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location URI</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.FileResource#getLocationURI()
	 * @see #getFileResource()
	 * @generated
	 */
	EAttribute getFileResource_LocationURI();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.XTextEditorProject <em>XText Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XText Editor Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.XTextEditorProject
	 * @generated
	 */
	EClass getXTextEditorProject();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.XTextEditorProject#getGrammarName <em>Grammar Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grammar Name</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.XTextEditorProject#getGrammarName()
	 * @see #getXTextEditorProject()
	 * @generated
	 */
	EAttribute getXTextEditorProject_GrammarName();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.K3DSAProject <em>K3DSA Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>K3DSA Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.K3DSAProject
	 * @generated
	 */
	EClass getK3DSAProject();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.ECLFile <em>ECL File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECL File</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ECLFile
	 * @generated
	 */
	EClass getECLFile();

	/**
	 * Returns the meta object for enum '{@link org.gemoc.gemoc_language_workbench.conf.ProjectKind <em>Project Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Project Kind</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectKind
	 * @generated
	 */
	EEnum getProjectKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	confFactory getconfFactory();

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
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl <em>Gemoc Language Workbench Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.GemocLanguageWorkbenchConfigurationImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getGemocLanguageWorkbenchConfiguration()
		 * @generated
		 */
		EClass GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION = eINSTANCE.getGemocLanguageWorkbenchConfiguration();

		/**
		 * The meta object literal for the '<em><b>Language Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_LANGUAGE_WORKBENCH_CONFIGURATION__LANGUAGE_DEFINITIONS = eINSTANCE.getGemocLanguageWorkbenchConfiguration_LanguageDefinitions();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl <em>Project Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectResource()
		 * @generated
		 */
		EClass PROJECT_RESOURCE = eINSTANCE.getProjectResource();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_RESOURCE__PROJECT_NAME = eINSTANCE.getProjectResource_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Project Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_RESOURCE__PROJECT_KIND = eINSTANCE.getProjectResource_ProjectKind();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DSAProjectImpl <em>DSA Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.DSAProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDSAProject()
		 * @generated
		 */
		EClass DSA_PROJECT = eINSTANCE.getDSAProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.Kermeta2DSAProjectImpl <em>Kermeta2 DSA Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.Kermeta2DSAProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getKermeta2DSAProject()
		 * @generated
		 */
		EClass KERMETA2_DSA_PROJECT = eINSTANCE.getKermeta2DSAProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl <em>Language Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getLanguageDefinition()
		 * @generated
		 */
		EClass LANGUAGE_DEFINITION = eINSTANCE.getLanguageDefinition();

		/**
		 * The meta object literal for the '<em><b>Dsa Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__DSA_PROJECT = eINSTANCE.getLanguageDefinition_DsaProject();

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
		 * The meta object literal for the '<em><b>Mo CModel Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__MO_CMODEL_PROJECT = eINSTANCE.getLanguageDefinition_MoCModelProject();

		/**
		 * The meta object literal for the '<em><b>Animator Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__ANIMATOR_PROJECTS = eINSTANCE.getLanguageDefinition_AnimatorProjects();

		/**
		 * The meta object literal for the '<em><b>DSE Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__DSE_PROJECT = eINSTANCE.getLanguageDefinition_DSEProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_DEFINITION__NAME = eINSTANCE.getLanguageDefinition_Name();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl <em>Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEditorProject()
		 * @generated
		 */
		EClass EDITOR_PROJECT = eINSTANCE.getEditorProject();

		/**
		 * The meta object literal for the '<em><b>File Extension</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR_PROJECT__FILE_EXTENSION = eINSTANCE.getEditorProject_FileExtension();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DomainModelProjectImpl <em>Domain Model Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.DomainModelProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDomainModelProject()
		 * @generated
		 */
		EClass DOMAIN_MODEL_PROJECT = eINSTANCE.getDomainModelProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.MoCProjectImpl <em>Mo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.MoCProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getMoCProject()
		 * @generated
		 */
		EClass MO_CPROJECT = eINSTANCE.getMoCProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.CCSLMoCProjectImpl <em>CCSL Mo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.CCSLMoCProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getCCSLMoCProject()
		 * @generated
		 */
		EClass CCSL_MO_CPROJECT = eINSTANCE.getCCSLMoCProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl <em>Animator Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getAnimatorProject()
		 * @generated
		 */
		EClass ANIMATOR_PROJECT = eINSTANCE.getAnimatorProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl <em>EMF Ecore Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.EMFEcoreProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEMFEcoreProject()
		 * @generated
		 */
		EClass EMF_ECORE_PROJECT = eINSTANCE.getEMFEcoreProject();

		/**
		 * The meta object literal for the '<em><b>Emf Genmodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EMF_ECORE_PROJECT__EMF_GENMODEL = eINSTANCE.getEMFEcoreProject_EmfGenmodel();

		/**
		 * The meta object literal for the '<em><b>Default Root EObject Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMF_ECORE_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME = eINSTANCE.getEMFEcoreProject_DefaultRootEObjectQualifiedName();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ODProjectImpl <em>OD Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.ODProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getODProject()
		 * @generated
		 */
		EClass OD_PROJECT = eINSTANCE.getODProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusAnimatorProject()
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
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ModHelXMoCProjectImpl <em>Mod Hel XMo CProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.ModHelXMoCProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getModHelXMoCProject()
		 * @generated
		 */
		EClass MOD_HEL_XMO_CPROJECT = eINSTANCE.getModHelXMoCProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl <em>DSE Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDSEProject()
		 * @generated
		 */
		EClass DSE_PROJECT = eINSTANCE.getDSEProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl <em>ECL Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.ECLProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getECLProject()
		 * @generated
		 */
		EClass ECL_PROJECT = eINSTANCE.getECLProject();

		/**
		 * The meta object literal for the '<em><b>Ecl File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_PROJECT__ECL_FILE = eINSTANCE.getECLProject_EclFile();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getTreeEditorProject()
		 * @generated
		 */
		EClass TREE_EDITOR_PROJECT = eINSTANCE.getTreeEditorProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EMFGenmodelImpl <em>EMF Genmodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.EMFGenmodelImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEMFGenmodel()
		 * @generated
		 */
		EClass EMF_GENMODEL = eINSTANCE.getEMFGenmodel();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.FileResourceImpl <em>File Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.FileResourceImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getFileResource()
		 * @generated
		 */
		EClass FILE_RESOURCE = eINSTANCE.getFileResource();

		/**
		 * The meta object literal for the '<em><b>Location URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_RESOURCE__LOCATION_URI = eINSTANCE.getFileResource_LocationURI();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl <em>XText Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getXTextEditorProject()
		 * @generated
		 */
		EClass XTEXT_EDITOR_PROJECT = eINSTANCE.getXTextEditorProject();

		/**
		 * The meta object literal for the '<em><b>Grammar Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEXT_EDITOR_PROJECT__GRAMMAR_NAME = eINSTANCE.getXTextEditorProject_GrammarName();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.K3DSAProjectImpl <em>K3DSA Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.K3DSAProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getK3DSAProject()
		 * @generated
		 */
		EClass K3DSA_PROJECT = eINSTANCE.getK3DSAProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ECLFileImpl <em>ECL File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.ECLFileImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getECLFile()
		 * @generated
		 */
		EClass ECL_FILE = eINSTANCE.getECLFile();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.ProjectKind <em>Project Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.ProjectKind
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectKind()
		 * @generated
		 */
		EEnum PROJECT_KIND = eINSTANCE.getProjectKind();

	}

} //confPackage
