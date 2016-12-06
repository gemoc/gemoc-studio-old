/**
 */
package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.TransitionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.TransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.TransitionImpl#getOwnedGuard <em>Owned Guard</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.TransitionImpl#getGeneratedEvents <em>Generated Events</em>}</li>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.TransitionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends NamedElementImpl implements Transition {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected State source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected State target;

	/**
	 * The cached value of the '{@link #getOwnedGuard() <em>Owned Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuard()
	 * @generated
	 * @ordered
	 */
	protected Guard ownedGuard;

	/**
	 * The cached value of the '{@link #getGeneratedEvents() <em>Generated Events</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMEvent> generatedEvents;

	/**
	 * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected String action = ACTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3Package.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (State)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(State newSource, NotificationChain msgs) {
		State oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(State newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, Tfsm_plaink3Package.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, Tfsm_plaink3Package.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (State)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(State newTarget, NotificationChain msgs) {
		State oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(State newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, Tfsm_plaink3Package.STATE__INCOMING_TRANSITIONS, State.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, Tfsm_plaink3Package.STATE__INCOMING_TRANSITIONS, State.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard getOwnedGuard() {
		return ownedGuard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedGuard(Guard newOwnedGuard, NotificationChain msgs) {
		Guard oldOwnedGuard = ownedGuard;
		ownedGuard = newOwnedGuard;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__OWNED_GUARD, oldOwnedGuard, newOwnedGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedGuard(Guard newOwnedGuard) {
		if (newOwnedGuard != ownedGuard) {
			NotificationChain msgs = null;
			if (ownedGuard != null)
				msgs = ((InternalEObject)ownedGuard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Tfsm_plaink3Package.TRANSITION__OWNED_GUARD, null, msgs);
			if (newOwnedGuard != null)
				msgs = ((InternalEObject)newOwnedGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Tfsm_plaink3Package.TRANSITION__OWNED_GUARD, null, msgs);
			msgs = basicSetOwnedGuard(newOwnedGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__OWNED_GUARD, newOwnedGuard, newOwnedGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMEvent> getGeneratedEvents() {
		if (generatedEvents == null) {
			generatedEvents = new EObjectResolvingEList<FSMEvent>(FSMEvent.class, this, Tfsm_plaink3Package.TRANSITION__GENERATED_EVENTS);
		}
		return generatedEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(String newAction) {
		String oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRANSITION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fire() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void visit() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, Tfsm_plaink3Package.STATE__OUTGOING_TRANSITIONS, State.class, msgs);
				return basicSetSource((State)otherEnd, msgs);
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, Tfsm_plaink3Package.STATE__INCOMING_TRANSITIONS, State.class, msgs);
				return basicSetTarget((State)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				return basicSetSource(null, msgs);
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				return basicSetTarget(null, msgs);
			case Tfsm_plaink3Package.TRANSITION__OWNED_GUARD:
				return basicSetOwnedGuard(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case Tfsm_plaink3Package.TRANSITION__OWNED_GUARD:
				return getOwnedGuard();
			case Tfsm_plaink3Package.TRANSITION__GENERATED_EVENTS:
				return getGeneratedEvents();
			case Tfsm_plaink3Package.TRANSITION__ACTION:
				return getAction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				setSource((State)newValue);
				return;
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				setTarget((State)newValue);
				return;
			case Tfsm_plaink3Package.TRANSITION__OWNED_GUARD:
				setOwnedGuard((Guard)newValue);
				return;
			case Tfsm_plaink3Package.TRANSITION__GENERATED_EVENTS:
				getGeneratedEvents().clear();
				getGeneratedEvents().addAll((Collection<? extends FSMEvent>)newValue);
				return;
			case Tfsm_plaink3Package.TRANSITION__ACTION:
				setAction((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				setSource((State)null);
				return;
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				setTarget((State)null);
				return;
			case Tfsm_plaink3Package.TRANSITION__OWNED_GUARD:
				setOwnedGuard((Guard)null);
				return;
			case Tfsm_plaink3Package.TRANSITION__GENERATED_EVENTS:
				getGeneratedEvents().clear();
				return;
			case Tfsm_plaink3Package.TRANSITION__ACTION:
				setAction(ACTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRANSITION__SOURCE:
				return source != null;
			case Tfsm_plaink3Package.TRANSITION__TARGET:
				return target != null;
			case Tfsm_plaink3Package.TRANSITION__OWNED_GUARD:
				return ownedGuard != null;
			case Tfsm_plaink3Package.TRANSITION__GENERATED_EVENTS:
				return generatedEvents != null && !generatedEvents.isEmpty();
			case Tfsm_plaink3Package.TRANSITION__ACTION:
				return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (action: ");
		result.append(action);
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
