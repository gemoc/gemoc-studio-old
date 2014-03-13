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
package fr.obeo.dsl.workspace.workbench.impl;

import fr.obeo.dsl.workspace.workbench.EditorReference;
import fr.obeo.dsl.workspace.workbench.ViewReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchFactory;
import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

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
public class WorkbenchFactoryImpl extends EFactoryImpl implements WorkbenchFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static WorkbenchFactory init() {
		try {
			WorkbenchFactory theWorkbenchFactory = (WorkbenchFactory)EPackage.Registry.INSTANCE
					.getEFactory("http://www.obeo.fr/dsl/workspace/workbench");
			if (theWorkbenchFactory != null) {
				return theWorkbenchFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkbenchFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchFactoryImpl() {
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
			case WorkbenchPackage.WORKBENCH_ROOT:
				return createWorkbenchRoot();
			case WorkbenchPackage.WORKBENCH_WINDOW:
				return createWorkbenchWindow();
			case WorkbenchPackage.WORKBENCH_PAGE:
				return createWorkbenchPage();
			case WorkbenchPackage.EDITOR_REFERENCE:
				return createEditorReference();
			case WorkbenchPackage.VIEW_REFERENCE:
				return createViewReference();
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
	public WorkbenchRoot createWorkbenchRoot() {
		WorkbenchRootImpl workbenchRoot = new WorkbenchRootImpl();
		return workbenchRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchWindow createWorkbenchWindow() {
		WorkbenchWindowImpl workbenchWindow = new WorkbenchWindowImpl();
		return workbenchWindow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPage createWorkbenchPage() {
		WorkbenchPageImpl workbenchPage = new WorkbenchPageImpl();
		return workbenchPage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EditorReference createEditorReference() {
		EditorReferenceImpl editorReference = new EditorReferenceImpl();
		return editorReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ViewReference createViewReference() {
		ViewReferenceImpl viewReference = new ViewReferenceImpl();
		return viewReference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPackage getWorkbenchPackage() {
		return (WorkbenchPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkbenchPackage getPackage() {
		return WorkbenchPackage.eINSTANCE;
	}

} // WorkbenchFactoryImpl
