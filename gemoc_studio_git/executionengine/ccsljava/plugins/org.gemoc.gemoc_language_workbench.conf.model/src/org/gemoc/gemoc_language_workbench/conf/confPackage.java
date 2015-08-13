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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl <em>Project Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.ProjectResourceImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectResource()
	 * @generated
	 */
	int PROJECT_RESOURCE = 1;

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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl <em>Language Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.LanguageDefinitionImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getLanguageDefinition()
	 * @generated
	 */
	int LANGUAGE_DEFINITION = 0;

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
	 * The feature id for the '<em><b>Mo CC Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__MO_CC_PROJECT = 3;

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
	 * The feature id for the '<em><b>Melange URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__MELANGE_URI = 7;

	/**
	 * The feature id for the '<em><b>Need Melange Synchronization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__NEED_MELANGE_SYNCHRONIZATION = 8;

	/**
	 * The feature id for the '<em><b>Language Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION__LANGUAGE_KIND = 9;

	/**
	 * The number of structural features of the '<em>Language Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_DEFINITION_FEATURE_COUNT = 10;

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
	 * The feature id for the '<em><b>Code Executor Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT__CODE_EXECUTOR_CLASS = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT__ENTRY_POINT = PROJECT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSA Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl <em>Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.EditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getEditorProject()
	 * @generated
	 */
	int EDITOR_PROJECT = 3;

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
	int DOMAIN_MODEL_PROJECT = 4;

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
	 * The feature id for the '<em><b>Default Root EObject Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Genmodeluri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT__GENMODELURI = PROJECT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Loader Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT__MODEL_LOADER_CLASS = PROJECT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain Model Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_MODEL_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.MoCCProjectImpl <em>Mo CC Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.MoCCProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getMoCCProject()
	 * @generated
	 */
	int MO_CC_PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CC_PROJECT__PROJECT_NAME = PROJECT_RESOURCE__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CC_PROJECT__PROJECT_KIND = PROJECT_RESOURCE__PROJECT_KIND;

	/**
	 * The number of structural features of the '<em>Mo CC Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MO_CC_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl <em>Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.AnimatorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getAnimatorProject()
	 * @generated
	 */
	int ANIMATOR_PROJECT = 6;

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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusAnimatorProject()
	 * @generated
	 */
	int SIRIUS_ANIMATOR_PROJECT = 9;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl <em>DSE Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.DSEProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getDSEProject()
	 * @generated
	 */
	int DSE_PROJECT = 7;

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
	 * The feature id for the '<em><b>Qvto URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT__QVTO_URI = PROJECT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solver Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT__SOLVER_CLASS = PROJECT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSE Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_PROJECT_FEATURE_COUNT = PROJECT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusEditorProjectImpl <em>Sirius Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusEditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusEditorProject()
	 * @generated
	 */
	int SIRIUS_EDITOR_PROJECT = 8;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_EDITOR_PROJECT__PROJECT_NAME = EDITOR_PROJECT__PROJECT_NAME;

	/**
	 * The feature id for the '<em><b>Project Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_EDITOR_PROJECT__PROJECT_KIND = EDITOR_PROJECT__PROJECT_KIND;

	/**
	 * The feature id for the '<em><b>File Extension</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_EDITOR_PROJECT__FILE_EXTENSION = EDITOR_PROJECT__FILE_EXTENSION;

	/**
	 * The number of structural features of the '<em>Sirius Editor Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_EDITOR_PROJECT_FEATURE_COUNT = EDITOR_PROJECT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Sirius Animator Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIRIUS_ANIMATOR_PROJECT_FEATURE_COUNT = ANIMATOR_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl <em>XText Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.XTextEditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getXTextEditorProject()
	 * @generated
	 */
	int XTEXT_EDITOR_PROJECT = 10;

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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getTreeEditorProject()
	 * @generated
	 */
	int TREE_EDITOR_PROJECT = 11;

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
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.ProjectKind <em>Project Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.ProjectKind
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectKind()
	 * @generated
	 */
	int PROJECT_KIND = 12;


	/**
	 * The meta object id for the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageKind <em>Language Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageKind
	 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getLanguageKind()
	 * @generated
	 */
	int LANGUAGE_KIND = 13;


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
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getCodeExecutorClass <em>Code Executor Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code Executor Class</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSAProject#getCodeExecutorClass()
	 * @see #getDSAProject()
	 * @generated
	 */
	EAttribute getDSAProject_CodeExecutorClass();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DSAProject#getEntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Point</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSAProject#getEntryPoint()
	 * @see #getDSAProject()
	 * @generated
	 */
	EAttribute getDSAProject_EntryPoint();

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
	 * Returns the meta object for the containment reference '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCCProject <em>Mo CC Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mo CC Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMoCCProject()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EReference getLanguageDefinition_MoCCProject();

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
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMelangeURI <em>Melange URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Melange URI</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getMelangeURI()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EAttribute getLanguageDefinition_MelangeURI();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#isNeedMelangeSynchronization <em>Need Melange Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Need Melange Synchronization</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#isNeedMelangeSynchronization()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EAttribute getLanguageDefinition_NeedMelangeSynchronization();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getLanguageKind <em>Language Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Kind</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageDefinition#getLanguageKind()
	 * @see #getLanguageDefinition()
	 * @generated
	 */
	EAttribute getLanguageDefinition_LanguageKind();

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
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getDefaultRootEObjectQualifiedName <em>Default Root EObject Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Root EObject Qualified Name</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getDefaultRootEObjectQualifiedName()
	 * @see #getDomainModelProject()
	 * @generated
	 */
	EAttribute getDomainModelProject_DefaultRootEObjectQualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getGenmodeluri <em>Genmodeluri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Genmodeluri</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getGenmodeluri()
	 * @see #getDomainModelProject()
	 * @generated
	 */
	EAttribute getDomainModelProject_Genmodeluri();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getModelLoaderClass <em>Model Loader Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Loader Class</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DomainModelProject#getModelLoaderClass()
	 * @see #getDomainModelProject()
	 * @generated
	 */
	EAttribute getDomainModelProject_ModelLoaderClass();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.MoCCProject <em>Mo CC Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mo CC Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.MoCCProject
	 * @generated
	 */
	EClass getMoCCProject();

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
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject <em>Sirius Animator Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sirius Animator Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.SiriusAnimatorProject
	 * @generated
	 */
	EClass getSiriusAnimatorProject();

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
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DSEProject#getQvtoURI <em>Qvto URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qvto URI</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSEProject#getQvtoURI()
	 * @see #getDSEProject()
	 * @generated
	 */
	EAttribute getDSEProject_QvtoURI();

	/**
	 * Returns the meta object for the attribute '{@link org.gemoc.gemoc_language_workbench.conf.DSEProject#getSolverClass <em>Solver Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solver Class</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.DSEProject#getSolverClass()
	 * @see #getDSEProject()
	 * @generated
	 */
	EAttribute getDSEProject_SolverClass();

	/**
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject <em>Sirius Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sirius Editor Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.SiriusEditorProject
	 * @generated
	 */
	EClass getSiriusEditorProject();

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
	 * Returns the meta object for class '{@link org.gemoc.gemoc_language_workbench.conf.TreeEditorProject <em>Tree Editor Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tree Editor Project</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.TreeEditorProject
	 * @generated
	 */
	EClass getTreeEditorProject();

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
	 * Returns the meta object for enum '{@link org.gemoc.gemoc_language_workbench.conf.LanguageKind <em>Language Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language Kind</em>'.
	 * @see org.gemoc.gemoc_language_workbench.conf.LanguageKind
	 * @generated
	 */
	EEnum getLanguageKind();

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
		 * The meta object literal for the '<em><b>Code Executor Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSA_PROJECT__CODE_EXECUTOR_CLASS = eINSTANCE.getDSAProject_CodeExecutorClass();

		/**
		 * The meta object literal for the '<em><b>Entry Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSA_PROJECT__ENTRY_POINT = eINSTANCE.getDSAProject_EntryPoint();

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
		 * The meta object literal for the '<em><b>Mo CC Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_DEFINITION__MO_CC_PROJECT = eINSTANCE.getLanguageDefinition_MoCCProject();

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
		 * The meta object literal for the '<em><b>Melange URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_DEFINITION__MELANGE_URI = eINSTANCE.getLanguageDefinition_MelangeURI();

		/**
		 * The meta object literal for the '<em><b>Need Melange Synchronization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_DEFINITION__NEED_MELANGE_SYNCHRONIZATION = eINSTANCE.getLanguageDefinition_NeedMelangeSynchronization();

		/**
		 * The meta object literal for the '<em><b>Language Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_DEFINITION__LANGUAGE_KIND = eINSTANCE.getLanguageDefinition_LanguageKind();

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
		 * The meta object literal for the '<em><b>Default Root EObject Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MODEL_PROJECT__DEFAULT_ROOT_EOBJECT_QUALIFIED_NAME = eINSTANCE.getDomainModelProject_DefaultRootEObjectQualifiedName();

		/**
		 * The meta object literal for the '<em><b>Genmodeluri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MODEL_PROJECT__GENMODELURI = eINSTANCE.getDomainModelProject_Genmodeluri();

		/**
		 * The meta object literal for the '<em><b>Model Loader Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_MODEL_PROJECT__MODEL_LOADER_CLASS = eINSTANCE.getDomainModelProject_ModelLoaderClass();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.MoCCProjectImpl <em>Mo CC Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.MoCCProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getMoCCProject()
		 * @generated
		 */
		EClass MO_CC_PROJECT = eINSTANCE.getMoCCProject();

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
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl <em>Sirius Animator Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusAnimatorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusAnimatorProject()
		 * @generated
		 */
		EClass SIRIUS_ANIMATOR_PROJECT = eINSTANCE.getSiriusAnimatorProject();

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
		 * The meta object literal for the '<em><b>Qvto URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSE_PROJECT__QVTO_URI = eINSTANCE.getDSEProject_QvtoURI();

		/**
		 * The meta object literal for the '<em><b>Solver Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DSE_PROJECT__SOLVER_CLASS = eINSTANCE.getDSEProject_SolverClass();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.SiriusEditorProjectImpl <em>Sirius Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.SiriusEditorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getSiriusEditorProject()
		 * @generated
		 */
		EClass SIRIUS_EDITOR_PROJECT = eINSTANCE.getSiriusEditorProject();

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
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl <em>Tree Editor Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.TreeEditorProjectImpl
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getTreeEditorProject()
		 * @generated
		 */
		EClass TREE_EDITOR_PROJECT = eINSTANCE.getTreeEditorProject();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.ProjectKind <em>Project Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.ProjectKind
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getProjectKind()
		 * @generated
		 */
		EEnum PROJECT_KIND = eINSTANCE.getProjectKind();

		/**
		 * The meta object literal for the '{@link org.gemoc.gemoc_language_workbench.conf.LanguageKind <em>Language Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.gemoc.gemoc_language_workbench.conf.LanguageKind
		 * @see org.gemoc.gemoc_language_workbench.conf.impl.confPackageImpl#getLanguageKind()
		 * @generated
		 */
		EEnum LANGUAGE_KIND = eINSTANCE.getLanguageKind();

	}

} //confPackage
