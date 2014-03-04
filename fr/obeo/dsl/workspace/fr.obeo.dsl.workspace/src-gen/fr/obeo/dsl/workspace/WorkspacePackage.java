/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.workspace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to
 * represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.WorkspaceFactory
 * @model kind="package"
 * @generated
 */
public interface WorkspacePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "workspace";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/workspace";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "workspace";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	WorkspacePackage eINSTANCE = fr.obeo.dsl.workspace.impl.WorkspacePackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.StateImpl <em>State</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.StateImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getState()
	 * @generated
	 */
	int STATE = 0;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Workbench</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__WORKBENCH = 1;

	/**
	 * The number of structural features of the '<em>State</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.WorkspaceRootImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getWorkspaceRoot()
	 * @generated
	 */
	int WORKSPACE_ROOT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.Resource <em>Resource</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.Resource
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE__FULLPATH = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE__PARENT = 2;

	/**
	 * The number of structural features of the '<em>Resource</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.Container <em>Container</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.Container
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER__FULLPATH = RESOURCE__FULLPATH;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER__PARENT = RESOURCE__PARENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER__MEMBERS = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__FULLPATH = CONTAINER__FULLPATH;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT__MEMBERS = CONTAINER__MEMBERS;

	/**
	 * The number of structural features of the '<em>Root</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_ROOT_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.FileImpl <em>File</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.FileImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getFile()
	 * @generated
	 */
	int FILE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE__FULLPATH = RESOURCE__FULLPATH;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE__PARENT = RESOURCE__PARENT;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE__EXTENSION = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.ProjectImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__FULLPATH = CONTAINER__FULLPATH;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__MEMBERS = CONTAINER__MEMBERS;

	/**
	 * The feature id for the '<em><b>Nature Id</b></em>' attribute list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__NATURE_ID = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__DEPENDENCIES = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Project</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.FolderImpl <em>Folder</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.FolderImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Fullpath</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER__FULLPATH = CONTAINER__FULLPATH;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER__PARENT = CONTAINER__PARENT;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER__MEMBERS = CONTAINER__MEMBERS;

	/**
	 * The number of structural features of the '<em>Folder</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.Dependency <em>Dependency</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.Dependency
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getDependency()
	 * @generated
	 */
	int DEPENDENCY = 7;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY__PROJECT = 0;

	/**
	 * The number of structural features of the '<em>Dependency</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl
	 * <em>Bundle Dependency</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.impl.BundleDependencyImpl
	 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getBundleDependency()
	 * @generated
	 */
	int BUNDLE_DEPENDENCY = 8;

	/**
	 * The feature id for the '<em><b>Project</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__PROJECT = DEPENDENCY__PROJECT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__ID = DEPENDENCY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Version</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__LOWER_VERSION = DEPENDENCY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Version Included</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED = DEPENDENCY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Version</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__UPPER_VERSION = DEPENDENCY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Upper Version Included</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED = DEPENDENCY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Exported</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__EXPORTED = DEPENDENCY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY__OPTIONAL = DEPENDENCY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Bundle Dependency</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUNDLE_DEPENDENCY_FEATURE_COUNT = DEPENDENCY_FEATURE_COUNT + 7;

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.State <em>State</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>State</em>'.
	 * @see fr.obeo.dsl.workspace.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.workspace.State#getWorkspace
	 * <em>Workspace</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Workspace</em>'.
	 * @see fr.obeo.dsl.workspace.State#getWorkspace()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Workspace();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.workspace.State#getWorkbench
	 * <em>Workbench</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Workbench</em>'.
	 * @see fr.obeo.dsl.workspace.State#getWorkbench()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Workbench();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.WorkspaceRoot <em>Root</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Root</em>'.
	 * @see fr.obeo.dsl.workspace.WorkspaceRoot
	 * @generated
	 */
	EClass getWorkspaceRoot();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.Resource <em>Resource</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see fr.obeo.dsl.workspace.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.Resource#getName <em>Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.workspace.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.Resource#getFullpath
	 * <em>Fullpath</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Fullpath</em>'.
	 * @see fr.obeo.dsl.workspace.Resource#getFullpath()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Fullpath();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.dsl.workspace.Resource#getParent
	 * <em>Parent</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see fr.obeo.dsl.workspace.Resource#getParent()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Parent();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.Container <em>Container</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Container</em>'.
	 * @see fr.obeo.dsl.workspace.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.Container#getMembers <em>Members</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see fr.obeo.dsl.workspace.Container#getMembers()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Members();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.File <em>File</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>File</em>'.
	 * @see fr.obeo.dsl.workspace.File
	 * @generated
	 */
	EClass getFile();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.File#getExtension
	 * <em>Extension</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see fr.obeo.dsl.workspace.File#getExtension()
	 * @see #getFile()
	 * @generated
	 */
	EAttribute getFile_Extension();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.Project <em>Project</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project</em>'.
	 * @see fr.obeo.dsl.workspace.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute list '{@link fr.obeo.dsl.workspace.Project#getNatureId
	 * <em>Nature Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Nature Id</em>'.
	 * @see fr.obeo.dsl.workspace.Project#getNatureId()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_NatureId();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.Project#getDependencies <em>Dependencies</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see fr.obeo.dsl.workspace.Project#getDependencies()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Dependencies();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.Folder <em>Folder</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see fr.obeo.dsl.workspace.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.Dependency <em>Dependency</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dependency</em>'.
	 * @see fr.obeo.dsl.workspace.Dependency
	 * @generated
	 */
	EClass getDependency();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.workspace.Dependency#getProject
	 * <em>Project</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Project</em>'.
	 * @see fr.obeo.dsl.workspace.Dependency#getProject()
	 * @see #getDependency()
	 * @generated
	 */
	EReference getDependency_Project();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.BundleDependency
	 * <em>Bundle Dependency</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Bundle Dependency</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency
	 * @generated
	 */
	EClass getBundleDependency();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.BundleDependency#getId
	 * <em>Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#getId()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.BundleDependency#getLowerVersion <em>Lower Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Lower Version</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#getLowerVersion()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_LowerVersion();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.BundleDependency#isLowerVersionIncluded <em>Lower Version Included</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Lower Version Included</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#isLowerVersionIncluded()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_LowerVersionIncluded();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.BundleDependency#getUpperVersion <em>Upper Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Upper Version</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#getUpperVersion()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_UpperVersion();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.BundleDependency#isUpperVersionIncluded <em>Upper Version Included</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Upper Version Included</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#isUpperVersionIncluded()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_UpperVersionIncluded();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.BundleDependency#isExported
	 * <em>Exported</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Exported</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#isExported()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_Exported();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.workspace.BundleDependency#isOptional
	 * <em>Optional</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see fr.obeo.dsl.workspace.BundleDependency#isOptional()
	 * @see #getBundleDependency()
	 * @generated
	 */
	EAttribute getBundleDependency_Optional();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkspaceFactory getWorkspaceFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.StateImpl <em>State</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.StateImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Workspace</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATE__WORKSPACE = eINSTANCE.getState_Workspace();

		/**
		 * The meta object literal for the '<em><b>Workbench</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATE__WORKBENCH = eINSTANCE.getState_Workbench();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.WorkspaceRootImpl <em>Root</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.WorkspaceRootImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getWorkspaceRoot()
		 * @generated
		 */
		EClass WORKSPACE_ROOT = eINSTANCE.getWorkspaceRoot();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.Resource <em>Resource</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.Resource
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Fullpath</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RESOURCE__FULLPATH = eINSTANCE.getResource_Fullpath();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RESOURCE__PARENT = eINSTANCE.getResource_Parent();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.Container <em>Container</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.Container
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTAINER__MEMBERS = eINSTANCE.getContainer_Members();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.FileImpl <em>File</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.FileImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getFile()
		 * @generated
		 */
		EClass FILE = eINSTANCE.getFile();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FILE__EXTENSION = eINSTANCE.getFile_Extension();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.ProjectImpl <em>Project</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.ProjectImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Nature Id</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__NATURE_ID = eINSTANCE.getProject_NatureId();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT__DEPENDENCIES = eINSTANCE.getProject_Dependencies();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.FolderImpl <em>Folder</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.FolderImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.Dependency <em>Dependency</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.Dependency
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getDependency()
		 * @generated
		 */
		EClass DEPENDENCY = eINSTANCE.getDependency();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPENDENCY__PROJECT = eINSTANCE.getDependency_Project();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.impl.BundleDependencyImpl
		 * <em>Bundle Dependency</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.impl.BundleDependencyImpl
		 * @see fr.obeo.dsl.workspace.impl.WorkspacePackageImpl#getBundleDependency()
		 * @generated
		 */
		EClass BUNDLE_DEPENDENCY = eINSTANCE.getBundleDependency();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__ID = eINSTANCE.getBundleDependency_Id();

		/**
		 * The meta object literal for the '<em><b>Lower Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__LOWER_VERSION = eINSTANCE.getBundleDependency_LowerVersion();

		/**
		 * The meta object literal for the '<em><b>Lower Version Included</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__LOWER_VERSION_INCLUDED = eINSTANCE
				.getBundleDependency_LowerVersionIncluded();

		/**
		 * The meta object literal for the '<em><b>Upper Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__UPPER_VERSION = eINSTANCE.getBundleDependency_UpperVersion();

		/**
		 * The meta object literal for the '<em><b>Upper Version Included</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__UPPER_VERSION_INCLUDED = eINSTANCE
				.getBundleDependency_UpperVersionIncluded();

		/**
		 * The meta object literal for the '<em><b>Exported</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__EXPORTED = eINSTANCE.getBundleDependency_Exported();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BUNDLE_DEPENDENCY__OPTIONAL = eINSTANCE.getBundleDependency_Optional();

	}

} // WorkspacePackage
