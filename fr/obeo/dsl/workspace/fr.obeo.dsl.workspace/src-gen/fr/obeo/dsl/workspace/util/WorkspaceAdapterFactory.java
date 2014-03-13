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
package fr.obeo.dsl.workspace.util;

import fr.obeo.dsl.workspace.BundleDependency;
import fr.obeo.dsl.workspace.Container;
import fr.obeo.dsl.workspace.Dependency;
import fr.obeo.dsl.workspace.File;
import fr.obeo.dsl.workspace.Folder;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.Resource;
import fr.obeo.dsl.workspace.State;
import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.WorkspaceRoot;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.WorkspacePackage
 * @generated
 */
public class WorkspaceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static WorkspacePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspaceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WorkspacePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance
	 * object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkspaceSwitch<Adapter> modelSwitch = new WorkspaceSwitch<Adapter>() {
		@Override
		public Adapter caseState(State object) {
			return createStateAdapter();
		}

		@Override
		public Adapter caseWorkspaceRoot(WorkspaceRoot object) {
			return createWorkspaceRootAdapter();
		}

		@Override
		public Adapter caseResource(Resource object) {
			return createResourceAdapter();
		}

		@Override
		public Adapter caseContainer(Container object) {
			return createContainerAdapter();
		}

		@Override
		public Adapter caseFile(File object) {
			return createFileAdapter();
		}

		@Override
		public Adapter caseProject(Project object) {
			return createProjectAdapter();
		}

		@Override
		public Adapter caseFolder(Folder object) {
			return createFolderAdapter();
		}

		@Override
		public Adapter caseDependency(Dependency object) {
			return createDependencyAdapter();
		}

		@Override
		public Adapter caseBundleDependency(BundleDependency object) {
			return createBundleDependencyAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.State <em>State</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.WorkspaceRoot <em>Root</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.WorkspaceRoot
	 * @generated
	 */
	public Adapter createWorkspaceRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.Resource <em>Resource</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.Container
	 * <em>Container</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.File <em>File</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.File
	 * @generated
	 */
	public Adapter createFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.Project <em>Project</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.Project
	 * @generated
	 */
	public Adapter createProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.Folder
	 * @generated
	 */
	public Adapter createFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.Dependency
	 * <em>Dependency</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.Dependency
	 * @generated
	 */
	public Adapter createDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.BundleDependency
	 * <em>Bundle Dependency</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.BundleDependency
	 * @generated
	 */
	public Adapter createBundleDependencyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns
	 * null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // WorkspaceAdapterFactory
