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
import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPartReference;

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
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Page</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl#getEditors <em>Editors</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl#getViews <em>Views</em>}</li>
 * <li>{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl#getActivePart <em>Active Part</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class WorkbenchPageImpl extends EObjectImpl implements WorkbenchPage {
	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<EditorReference> editors;

	/**
	 * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getViews()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewReference> views;

	/**
	 * The cached value of the '{@link #getActivePart() <em>Active Part</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getActivePart()
	 * @generated
	 * @ordered
	 */
	protected WorkbenchPartReference activePart;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected WorkbenchPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkbenchPackage.Literals.WORKBENCH_PAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EditorReference> getEditors() {
		if (editors == null) {
			editors = new EObjectContainmentEList<EditorReference>(EditorReference.class, this,
					WorkbenchPackage.WORKBENCH_PAGE__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ViewReference> getViews() {
		if (views == null) {
			views = new EObjectContainmentEList<ViewReference>(ViewReference.class, this,
					WorkbenchPackage.WORKBENCH_PAGE__VIEWS);
		}
		return views;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPartReference getActivePart() {
		if (activePart != null && activePart.eIsProxy()) {
			InternalEObject oldActivePart = (InternalEObject)activePart;
			activePart = (WorkbenchPartReference)eResolveProxy(oldActivePart);
			if (activePart != oldActivePart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART, oldActivePart, activePart));
			}
		}
		return activePart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchPartReference basicGetActivePart() {
		return activePart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setActivePart(WorkbenchPartReference newActivePart) {
		WorkbenchPartReference oldActivePart = activePart;
		activePart = newActivePart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART, oldActivePart, activePart));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkbenchPackage.WORKBENCH_PAGE__EDITORS:
				return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
			case WorkbenchPackage.WORKBENCH_PAGE__VIEWS:
				return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
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
			case WorkbenchPackage.WORKBENCH_PAGE__EDITORS:
				return getEditors();
			case WorkbenchPackage.WORKBENCH_PAGE__VIEWS:
				return getViews();
			case WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART:
				if (resolve)
					return getActivePart();
				return basicGetActivePart();
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
			case WorkbenchPackage.WORKBENCH_PAGE__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends EditorReference>)newValue);
				return;
			case WorkbenchPackage.WORKBENCH_PAGE__VIEWS:
				getViews().clear();
				getViews().addAll((Collection<? extends ViewReference>)newValue);
				return;
			case WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART:
				setActivePart((WorkbenchPartReference)newValue);
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
			case WorkbenchPackage.WORKBENCH_PAGE__EDITORS:
				getEditors().clear();
				return;
			case WorkbenchPackage.WORKBENCH_PAGE__VIEWS:
				getViews().clear();
				return;
			case WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART:
				setActivePart((WorkbenchPartReference)null);
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
			case WorkbenchPackage.WORKBENCH_PAGE__EDITORS:
				return editors != null && !editors.isEmpty();
			case WorkbenchPackage.WORKBENCH_PAGE__VIEWS:
				return views != null && !views.isEmpty();
			case WorkbenchPackage.WORKBENCH_PAGE__ACTIVE_PART:
				return activePart != null;
		}
		return super.eIsSet(featureID);
	}

} // WorkbenchPageImpl
