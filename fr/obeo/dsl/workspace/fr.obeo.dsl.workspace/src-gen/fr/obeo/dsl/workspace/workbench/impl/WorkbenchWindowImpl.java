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
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Window</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchWindowImpl#getPages <em>Pages</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkbenchWindowImpl extends EObjectImpl implements WorkbenchWindow {
	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkbenchPage> pages;

	/**
	 * The cached value of the '{@link #getActivePage() <em>Active Page</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getActivePage()
	 * @generated
	 * @ordered
	 */
	protected WorkbenchPage activePage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkbenchWindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.WORKBENCH_WINDOW;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<WorkbenchPage> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentEList<WorkbenchPage>(WorkbenchPage.class, this,
					WorkbenchPackage.WORKBENCH_WINDOW__PAGES);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPage getActivePage() {
		if (activePage != null && activePage.eIsProxy()) {
			InternalEObject oldActivePage = (InternalEObject)activePage;
			activePage = (WorkbenchPage)eResolveProxy(oldActivePage);
			if (activePage != oldActivePage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE, oldActivePage, activePage));
			}
		}
		return activePage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPage basicGetActivePage() {
		return activePage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActivePage(WorkbenchPage newActivePage) {
		WorkbenchPage oldActivePage = activePage;
		activePage = newActivePage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE, oldActivePage, activePage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.WORKBENCH_WINDOW__PAGES:
				return ((InternalEList<?>)getPages()).basicRemove(otherEnd, msgs);
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
			case WorkbenchPackage.WORKBENCH_WINDOW__PAGES:
				return getPages();
			case WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE:
				if (resolve)
					return getActivePage();
				return basicGetActivePage();
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
			case WorkbenchPackage.WORKBENCH_WINDOW__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends WorkbenchPage>)newValue);
				return;
			case WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE:
				setActivePage((WorkbenchPage)newValue);
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
			case WorkbenchPackage.WORKBENCH_WINDOW__PAGES:
				getPages().clear();
				return;
			case WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE:
				setActivePage((WorkbenchPage)null);
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
			case WorkbenchPackage.WORKBENCH_WINDOW__PAGES:
				return pages != null && !pages.isEmpty();
			case WorkbenchPackage.WORKBENCH_WINDOW__ACTIVE_PAGE:
				return activePage != null;
		}
		return super.eIsSet(featureID);
	}

} // WorkbenchWindowImpl
