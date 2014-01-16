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
package fr.obeo.dsl.debug.impl;

import fr.obeo.dsl.debug.DebugPackage;
import fr.obeo.dsl.debug.DebugTarget;
import fr.obeo.dsl.debug.DebugTargetState;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Target</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.debug.impl.DebugTargetImpl#getName <em>Name</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.impl.DebugTargetImpl#getState <em>State</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.impl.DebugTargetImpl#getThreads <em>Threads</em>}</li>
 * <li>{@link fr.obeo.dsl.debug.impl.DebugTargetImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DebugTargetImpl extends EObjectImpl implements DebugTarget {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2013 Obeo. All Rights Reserved.\n\nThis software and the attached documentation are the exclusive ownership\nof its authors and was conceded to the profit of Obeo SARL.\nThis software and the attached documentation are protected under the rights\nof intellectual ownership, including the section \"Titre II  Droits des auteurs (Articles L121-1 L123-12)\"\nBy installing this software, you acknowledge being aware of this rights and\naccept them, and as a consequence you must:\n- be in possession of a valid license of use conceded by Obeo only.\n- agree that you have read, understood, and will comply with the license terms and conditions.\n- agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries\nor the authors of this software\n\nShould you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.";

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EObject context;

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
	 * The default value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final DebugTargetState STATE_EDEFAULT = DebugTargetState.CONNECTED;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected DebugTargetState state = STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getThreads() <em>Threads</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getThreads()
	 * @generated
	 * @ordered
	 */
	protected EList<fr.obeo.dsl.debug.Thread> threads;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DebugTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DebugPackage.Literals.DEBUG_TARGET;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_TARGET__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DebugTargetState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setState(DebugTargetState newState) {
		DebugTargetState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_TARGET__STATE, oldState,
					state));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<fr.obeo.dsl.debug.Thread> getThreads() {
		if (threads == null) {
			threads = new EObjectContainmentWithInverseEList<fr.obeo.dsl.debug.Thread>(
					fr.obeo.dsl.debug.Thread.class, this, DebugPackage.DEBUG_TARGET__THREADS,
					DebugPackage.THREAD__DEBUG_TARGET);
		}
		return threads;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject)context;
			context = eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DebugPackage.DEBUG_TARGET__CONTEXT, oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContext(EObject newContext) {
		EObject oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DebugPackage.DEBUG_TARGET__CONTEXT,
					oldContext, context));
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
			case DebugPackage.DEBUG_TARGET__THREADS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getThreads()).basicAdd(otherEnd,
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
			case DebugPackage.DEBUG_TARGET__THREADS:
				return ((InternalEList<?>)getThreads()).basicRemove(otherEnd, msgs);
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
			case DebugPackage.DEBUG_TARGET__CONTEXT:
				if (resolve)
					return getContext();
				return basicGetContext();
			case DebugPackage.DEBUG_TARGET__NAME:
				return getName();
			case DebugPackage.DEBUG_TARGET__STATE:
				return getState();
			case DebugPackage.DEBUG_TARGET__THREADS:
				return getThreads();
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
			case DebugPackage.DEBUG_TARGET__CONTEXT:
				setContext((EObject)newValue);
				return;
			case DebugPackage.DEBUG_TARGET__NAME:
				setName((String)newValue);
				return;
			case DebugPackage.DEBUG_TARGET__STATE:
				setState((DebugTargetState)newValue);
				return;
			case DebugPackage.DEBUG_TARGET__THREADS:
				getThreads().clear();
				getThreads().addAll((Collection<? extends fr.obeo.dsl.debug.Thread>)newValue);
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
			case DebugPackage.DEBUG_TARGET__CONTEXT:
				setContext((EObject)null);
				return;
			case DebugPackage.DEBUG_TARGET__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DebugPackage.DEBUG_TARGET__STATE:
				setState(STATE_EDEFAULT);
				return;
			case DebugPackage.DEBUG_TARGET__THREADS:
				getThreads().clear();
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
			case DebugPackage.DEBUG_TARGET__CONTEXT:
				return context != null;
			case DebugPackage.DEBUG_TARGET__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DebugPackage.DEBUG_TARGET__STATE:
				return state != STATE_EDEFAULT;
			case DebugPackage.DEBUG_TARGET__THREADS:
				return threads != null && !threads.isEmpty();
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
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} // DebugTargetImpl
