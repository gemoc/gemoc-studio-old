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

import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Root</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl#getWindows <em>Windows</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl#getActiveWindow <em>Active Window</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkbenchRootImpl extends EObjectImpl implements WorkbenchRoot {
	/**
	 * The cached value of the '{@link #getWindows() <em>Windows</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWindows()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkbenchWindow> windows;

	/**
	 * The cached value of the '{@link #getActiveWindow() <em>Active Window</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getActiveWindow()
	 * @generated
	 * @ordered
	 */
	protected WorkbenchWindow activeWindow;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkbenchRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.WORKBENCH_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<WorkbenchWindow> getWindows() {
		if (windows == null) {
			windows = new EObjectContainmentEList<WorkbenchWindow>(WorkbenchWindow.class, this,
					WorkbenchPackage.WORKBENCH_ROOT__WINDOWS);
		}
		return windows;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchWindow getActiveWindow() {
		if (activeWindow != null && activeWindow.eIsProxy()) {
			InternalEObject oldActiveWindow = (InternalEObject)activeWindow;
			activeWindow = (WorkbenchWindow)eResolveProxy(oldActiveWindow);
			if (activeWindow != oldActiveWindow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW, oldActiveWindow, activeWindow));
			}
		}
		return activeWindow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchWindow basicGetActiveWindow() {
		return activeWindow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActiveWindow(WorkbenchWindow newActiveWindow) {
		WorkbenchWindow oldActiveWindow = activeWindow;
		activeWindow = newActiveWindow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW, oldActiveWindow, activeWindow));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.WORKBENCH_ROOT__WINDOWS:
				return ((InternalEList<?>)getWindows()).basicRemove(otherEnd, msgs);
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
			case WorkbenchPackage.WORKBENCH_ROOT__WINDOWS:
				return getWindows();
			case WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW:
				if (resolve)
					return getActiveWindow();
				return basicGetActiveWindow();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WorkbenchPackage.WORKBENCH_ROOT__WINDOWS:
				getWindows().clear();
				getWindows().addAll((Collection<? extends WorkbenchWindow>)newValue);
				return;
			case WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW:
				setActiveWindow((WorkbenchWindow)newValue);
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
			case WorkbenchPackage.WORKBENCH_ROOT__WINDOWS:
				getWindows().clear();
				return;
			case WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW:
				setActiveWindow((WorkbenchWindow)null);
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
			case WorkbenchPackage.WORKBENCH_ROOT__WINDOWS:
				return windows != null && !windows.isEmpty();
			case WorkbenchPackage.WORKBENCH_ROOT__ACTIVE_WINDOW:
				return activeWindow != null;
		}
		return super.eIsSet(featureID);
	}

} // WorkbenchRootImpl
