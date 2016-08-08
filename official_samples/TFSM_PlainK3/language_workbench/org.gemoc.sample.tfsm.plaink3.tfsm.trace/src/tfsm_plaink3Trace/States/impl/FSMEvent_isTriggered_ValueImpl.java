/**
 */
package tfsm_plaink3Trace.States.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm_plaink3Trace.States.FSMEvent_isTriggered_Value;
import tfsm_plaink3Trace.States.State;
import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Event is Triggered Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl#getStatesNoOpposite <em>States No Opposite</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl#isIsTriggered <em>Is Triggered</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMEvent_isTriggered_ValueImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMEvent_isTriggered_ValueImpl extends MinimalEObjectImpl.Container implements FSMEvent_isTriggered_Value {
	/**
	 * The default value of the '{@link #isIsTriggered() <em>Is Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTriggered()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TRIGGERED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsTriggered() <em>Is Triggered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTriggered()
	 * @generated
	 * @ordered
	 */
	protected boolean isTriggered = IS_TRIGGERED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMEvent_isTriggered_ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatesPackage.Literals.FSM_EVENT_IS_TRIGGERED_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStatesNoOpposite() {
		return this.getStates();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsTriggered() {
		return isTriggered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTriggered(boolean newIsTriggered) {
		boolean oldIsTriggered = isTriggered;
		isTriggered = newIsTriggered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED, oldIsTriggered, isTriggered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMEvent getParent() {
		if (eContainerFeatureID() != StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT) return null;
		return (TracedFSMEvent)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TracedFSMEvent newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TracedFSMEvent newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, Tfsm_plaink3Package.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE, TracedFSMEvent.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES, StatesPackage.STATE__FSM_EVENT_IS_TRIGGERED_VALUES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((TracedFSMEvent)otherEnd, msgs);
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStates()).basicAdd(otherEnd, msgs);
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
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				return basicSetParent(null, msgs);
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				return eInternalContainer().eInverseRemove(this, Tfsm_plaink3Package.TRACED_FSM_EVENT__IS_TRIGGERED_SEQUENCE, TracedFSMEvent.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES_NO_OPPOSITE:
				return getStatesNoOpposite();
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED:
				return isIsTriggered();
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				return getParent();
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				return getStates();
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
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED:
				setIsTriggered((Boolean)newValue);
				return;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				setParent((TracedFSMEvent)newValue);
				return;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
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
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED:
				setIsTriggered(IS_TRIGGERED_EDEFAULT);
				return;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				setParent((TracedFSMEvent)null);
				return;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				getStates().clear();
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
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES_NO_OPPOSITE:
				return !getStatesNoOpposite().isEmpty();
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__IS_TRIGGERED:
				return isTriggered != IS_TRIGGERED_EDEFAULT;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__PARENT:
				return getParent() != null;
			case StatesPackage.FSM_EVENT_IS_TRIGGERED_VALUE__STATES:
				return states != null && !states.isEmpty();
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
		result.append(" (isTriggered: ");
		result.append(isTriggered);
		result.append(')');
		return result.toString();
	}

} //FSMEvent_isTriggered_ValueImpl
