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
package fr.obeo.dsl.workspace.workbench.util;

import fr.obeo.dsl.workspace.workbench.EditorReference;
import fr.obeo.dsl.workspace.workbench.ViewReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPartReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage
 * @generated
 */
public class WorkbenchAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static WorkbenchPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WorkbenchPackage.eINSTANCE;
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
	protected WorkbenchSwitch<Adapter> modelSwitch = new WorkbenchSwitch<Adapter>() {
		@Override
		public Adapter caseWorkbenchRoot(WorkbenchRoot object) {
			return createWorkbenchRootAdapter();
		}

		@Override
		public Adapter caseWorkbenchWindow(WorkbenchWindow object) {
			return createWorkbenchWindowAdapter();
		}

		@Override
		public Adapter caseWorkbenchPage(WorkbenchPage object) {
			return createWorkbenchPageAdapter();
		}

		@Override
		public Adapter caseWorkbenchPartReference(WorkbenchPartReference object) {
			return createWorkbenchPartReferenceAdapter();
		}

		@Override
		public Adapter caseEditorReference(EditorReference object) {
			return createEditorReferenceAdapter();
		}

		@Override
		public Adapter caseViewReference(ViewReference object) {
			return createViewReferenceAdapter();
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
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot
	 * <em>Root</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchRoot
	 * @generated
	 */
	public Adapter createWorkbenchRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchWindow
	 * <em>Window</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchWindow
	 * @generated
	 */
	public Adapter createWorkbenchWindowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPage
	 * <em>Page</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPage
	 * @generated
	 */
	public Adapter createWorkbenchPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference <em>Part Reference</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
	 * @generated
	 */
	public Adapter createWorkbenchPartReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.workbench.EditorReference
	 * <em>Editor Reference</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.EditorReference
	 * @generated
	 */
	public Adapter createEditorReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.workspace.workbench.ViewReference
	 * <em>View Reference</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.workspace.workbench.ViewReference
	 * @generated
	 */
	public Adapter createViewReferenceAdapter() {
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

} // WorkbenchAdapterFactory
