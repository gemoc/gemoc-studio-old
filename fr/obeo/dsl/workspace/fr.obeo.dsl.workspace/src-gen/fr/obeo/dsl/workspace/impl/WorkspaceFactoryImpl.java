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
package fr.obeo.dsl.workspace.impl;

import fr.obeo.dsl.workspace.BundleDependency;
import fr.obeo.dsl.workspace.File;
import fr.obeo.dsl.workspace.Folder;
import fr.obeo.dsl.workspace.Project;
import fr.obeo.dsl.workspace.State;
import fr.obeo.dsl.workspace.WorkspaceFactory;
import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.WorkspaceRoot;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class WorkspaceFactoryImpl extends EFactoryImpl implements WorkspaceFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WorkspaceFactory init() {
		try {
			WorkspaceFactory theWorkspaceFactory = (WorkspaceFactory)EPackage.Registry.INSTANCE
					.getEFactory("http://www.obeo.fr/dsl/workspace");
			if (theWorkspaceFactory != null) {
				return theWorkspaceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkspaceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspaceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkspacePackage.STATE:
				return createState();
			case WorkspacePackage.WORKSPACE_ROOT:
				return createWorkspaceRoot();
			case WorkspacePackage.FILE:
				return createFile();
			case WorkspacePackage.PROJECT:
				return createProject();
			case WorkspacePackage.FOLDER:
				return createFolder();
			case WorkspacePackage.BUNDLE_DEPENDENCY:
				return createBundleDependency();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspaceRoot createWorkspaceRoot() {
		WorkspaceRootImpl workspaceRoot = new WorkspaceRootImpl();
		return workspaceRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BundleDependency createBundleDependency() {
		BundleDependencyImpl bundleDependency = new BundleDependencyImpl();
		return bundleDependency;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspacePackage getWorkspacePackage() {
		return (WorkspacePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkspacePackage getPackage() {
		return WorkspacePackage.eINSTANCE;
	}

} // WorkspaceFactoryImpl
