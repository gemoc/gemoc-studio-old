/**
 *  Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 *  This software and the attached documentation are the exclusive ownership
 *  of its authors and was conceded to the profit of Obeo SARL.
 *  This software and the attached documentation are protected under the rights
 *  of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 *  By installing this software, you acknowledge being aware of this rights and
 *  accept them, and as a consequence you must:
 *  - be in possession of a valid license of use conceded by Obeo only.
 *  - agree that you have read, understood, and will comply with the license terms and conditions.
 *  - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 *  or the authors of this software
 * 
 *  Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * 
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.impl.ProcessVariableImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessVariableImpl extends EObjectImpl implements ProcessVariable {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWrittenBy() <em>Written By</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWrittenBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionTask> writtenBy;

	/**
	 * The cached value of the '{@link #getObservedBy() <em>Observed By</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getObservedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionTask> observedBy;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.PROCESS_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_VARIABLE__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ActionTask> getWrittenBy() {
		if (writtenBy == null) {
			writtenBy = new EObjectWithInverseResolvingEList.ManyInverse<ActionTask>(ActionTask.class, this,
					ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY,
					ProcessPackage.ACTION_TASK__WRITTEN_VARIABLES);
		}
		return writtenBy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ActionTask> getObservedBy() {
		if (observedBy == null) {
			observedBy = new EObjectWithInverseResolvingEList.ManyInverse<ActionTask>(ActionTask.class, this,
					ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY,
					ProcessPackage.ACTION_TASK__OBSERVED_VARIABLES);
		}
		return observedBy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getWrittenBy()).basicAdd(otherEnd,
						msgs);
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getObservedBy()).basicAdd(otherEnd,
						msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				return ((InternalEList<?>)getWrittenBy()).basicRemove(otherEnd, msgs);
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				return ((InternalEList<?>)getObservedBy()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.PROCESS_VARIABLE__NAME:
				return getName();
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				return getWrittenBy();
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				return getObservedBy();
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
			case ProcessPackage.PROCESS_VARIABLE__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				getWrittenBy().clear();
				getWrittenBy().addAll((Collection<? extends ActionTask>)newValue);
				return;
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				getObservedBy().clear();
				getObservedBy().addAll((Collection<? extends ActionTask>)newValue);
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
			case ProcessPackage.PROCESS_VARIABLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				getWrittenBy().clear();
				return;
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				getObservedBy().clear();
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
			case ProcessPackage.PROCESS_VARIABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY:
				return writtenBy != null && !writtenBy.isEmpty();
			case ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY:
				return observedBy != null && !observedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ProcessVariableImpl
