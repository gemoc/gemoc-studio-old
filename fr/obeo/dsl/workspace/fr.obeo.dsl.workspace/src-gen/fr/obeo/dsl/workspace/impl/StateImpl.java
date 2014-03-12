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

import fr.obeo.dsl.workspace.State;
import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.WorkspaceRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>State</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.impl.StateImpl#getWorkspace <em>Workspace</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.impl.StateImpl#getWorkbench <em>Workbench</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StateImpl extends EObjectImpl implements State {
	/**
	 * The cached value of the '{@link #getWorkspace() <em>Workspace</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWorkspace()
	 * @generated
	 * @ordered
	 */
	protected WorkspaceRoot workspace;

	/**
	 * The cached value of the '{@link #getWorkbench() <em>Workbench</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWorkbench()
	 * @generated
	 * @ordered
	 */
	protected WorkbenchRoot workbench;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.STATE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkspaceRoot getWorkspace() {
		return workspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetWorkspace(WorkspaceRoot newWorkspace, NotificationChain msgs) {
		WorkspaceRoot oldWorkspace = workspace;
		workspace = newWorkspace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.STATE__WORKSPACE, oldWorkspace, newWorkspace);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWorkspace(WorkspaceRoot newWorkspace) {
		if (newWorkspace != workspace) {
			NotificationChain msgs = null;
			if (workspace != null)
				msgs = ((InternalEObject)workspace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.STATE__WORKSPACE, null, msgs);
			if (newWorkspace != null)
				msgs = ((InternalEObject)newWorkspace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.STATE__WORKSPACE, null, msgs);
			msgs = basicSetWorkspace(newWorkspace, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.STATE__WORKSPACE,
					newWorkspace, newWorkspace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchRoot getWorkbench() {
		return workbench;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetWorkbench(WorkbenchRoot newWorkbench, NotificationChain msgs) {
		WorkbenchRoot oldWorkbench = workbench;
		workbench = newWorkbench;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.STATE__WORKBENCH, oldWorkbench, newWorkbench);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setWorkbench(WorkbenchRoot newWorkbench) {
		if (newWorkbench != workbench) {
			NotificationChain msgs = null;
			if (workbench != null)
				msgs = ((InternalEObject)workbench).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.STATE__WORKBENCH, null, msgs);
			if (newWorkbench != null)
				msgs = ((InternalEObject)newWorkbench).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.STATE__WORKBENCH, null, msgs);
			msgs = basicSetWorkbench(newWorkbench, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.STATE__WORKBENCH,
					newWorkbench, newWorkbench));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.STATE__WORKSPACE:
				return basicSetWorkspace(null, msgs);
			case WorkspacePackage.STATE__WORKBENCH:
				return basicSetWorkbench(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkspacePackage.STATE__WORKSPACE:
				return getWorkspace();
			case WorkspacePackage.STATE__WORKBENCH:
				return getWorkbench();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkspacePackage.STATE__WORKSPACE:
				setWorkspace((WorkspaceRoot)newValue);
				return;
			case WorkspacePackage.STATE__WORKBENCH:
				setWorkbench((WorkbenchRoot)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WorkspacePackage.STATE__WORKSPACE:
				setWorkspace((WorkspaceRoot)null);
				return;
			case WorkspacePackage.STATE__WORKBENCH:
				setWorkbench((WorkbenchRoot)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WorkspacePackage.STATE__WORKSPACE:
				return workspace != null;
			case WorkspacePackage.STATE__WORKBENCH:
				return workbench != null;
		}
		return super.eIsSet(featureID);
	}

} // StateImpl
