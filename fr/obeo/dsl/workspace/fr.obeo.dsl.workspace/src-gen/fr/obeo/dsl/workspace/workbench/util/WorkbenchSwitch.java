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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the
 * model, starting with the actual class of the object and proceeding up the inheritance hierarchy until a
 * non-null result is returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage
 * @generated
 */
public class WorkbenchSwitch<T> extends Switch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static WorkbenchPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchSwitch() {
		if (modelPackage == null) {
			modelPackage = WorkbenchPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields
	 * that result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WorkbenchPackage.WORKBENCH_ROOT: {
				WorkbenchRoot workbenchRoot = (WorkbenchRoot)theEObject;
				T result = caseWorkbenchRoot(workbenchRoot);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case WorkbenchPackage.WORKBENCH_WINDOW: {
				WorkbenchWindow workbenchWindow = (WorkbenchWindow)theEObject;
				T result = caseWorkbenchWindow(workbenchWindow);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case WorkbenchPackage.WORKBENCH_PAGE: {
				WorkbenchPage workbenchPage = (WorkbenchPage)theEObject;
				T result = caseWorkbenchPage(workbenchPage);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case WorkbenchPackage.WORKBENCH_PART_REFERENCE: {
				WorkbenchPartReference workbenchPartReference = (WorkbenchPartReference)theEObject;
				T result = caseWorkbenchPartReference(workbenchPartReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case WorkbenchPackage.EDITOR_REFERENCE: {
				EditorReference editorReference = (EditorReference)theEObject;
				T result = caseEditorReference(editorReference);
				if (result == null)
					result = caseWorkbenchPartReference(editorReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case WorkbenchPackage.VIEW_REFERENCE: {
				ViewReference viewReference = (ViewReference)theEObject;
				T result = caseViewReference(viewReference);
				if (result == null)
					result = caseWorkbenchPartReference(viewReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchRoot(WorkbenchRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Window</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Window</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchWindow(WorkbenchWindow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchPage(WorkbenchPage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Part Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Part Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWorkbenchPartReference(WorkbenchPartReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditorReference(EditorReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View Reference</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the
	 * switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseViewReference(ViewReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch, but this
	 * is the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // WorkbenchSwitch
