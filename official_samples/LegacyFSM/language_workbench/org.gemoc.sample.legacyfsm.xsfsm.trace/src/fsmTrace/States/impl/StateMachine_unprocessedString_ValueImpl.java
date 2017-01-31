/**
 */
package fsmTrace.States.impl;

import fsmTrace.States.State;
import fsmTrace.States.StateMachine_unprocessedString_Value;
import fsmTrace.States.StatesPackage;

import fsmTrace.States.fsm.FsmPackage;
import fsmTrace.States.fsm.TracedStateMachine;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine unprocessed String Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link fsmTrace.States.impl.StateMachine_unprocessedString_ValueImpl#getStatesNoOpposite <em>States No Opposite</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateMachine_unprocessedString_ValueImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateMachine_unprocessedString_ValueImpl#getStates <em>States</em>}</li>
 *   <li>{@link fsmTrace.States.impl.StateMachine_unprocessedString_ValueImpl#getUnprocessedString <em>Unprocessed String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StateMachine_unprocessedString_ValueImpl extends MinimalEObjectImpl.Container implements StateMachine_unprocessedString_Value {
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
	 * The default value of the '{@link #getUnprocessedString() <em>Unprocessed String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnprocessedString()
	 * @generated
	 * @ordered
	 */
	protected static final String UNPROCESSED_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnprocessedString() <em>Unprocessed String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnprocessedString()
	 * @generated
	 * @ordered
	 */
	protected String unprocessedString = UNPROCESSED_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachine_unprocessedString_ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatesPackage.Literals.STATE_MACHINE_UNPROCESSED_STRING_VALUE;
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
	public TracedStateMachine getParent() {
		if (eContainerFeatureID() != StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT) return null;
		return (TracedStateMachine)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TracedStateMachine newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TracedStateMachine newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE, TracedStateMachine.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES, StatesPackage.STATE__STATE_MACHINE_UNPROCESSED_STRING_VALUES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnprocessedString() {
		return unprocessedString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnprocessedString(String newUnprocessedString) {
		String oldUnprocessedString = unprocessedString;
		unprocessedString = newUnprocessedString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__UNPROCESSED_STRING, oldUnprocessedString, unprocessedString));
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((TracedStateMachine)otherEnd, msgs);
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				return basicSetParent(null, msgs);
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				return eInternalContainer().eInverseRemove(this, FsmPackage.TRACED_STATE_MACHINE__UNPROCESSED_STRING_SEQUENCE, TracedStateMachine.class, msgs);
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES_NO_OPPOSITE:
				return getStatesNoOpposite();
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				return getParent();
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
				return getStates();
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__UNPROCESSED_STRING:
				return getUnprocessedString();
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				setParent((TracedStateMachine)newValue);
				return;
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__UNPROCESSED_STRING:
				setUnprocessedString((String)newValue);
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				setParent((TracedStateMachine)null);
				return;
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
				getStates().clear();
				return;
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__UNPROCESSED_STRING:
				setUnprocessedString(UNPROCESSED_STRING_EDEFAULT);
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
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES_NO_OPPOSITE:
				return !getStatesNoOpposite().isEmpty();
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__PARENT:
				return getParent() != null;
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__STATES:
				return states != null && !states.isEmpty();
			case StatesPackage.STATE_MACHINE_UNPROCESSED_STRING_VALUE__UNPROCESSED_STRING:
				return UNPROCESSED_STRING_EDEFAULT == null ? unprocessedString != null : !UNPROCESSED_STRING_EDEFAULT.equals(unprocessedString);
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
		result.append(" (unprocessedString: ");
		result.append(unprocessedString);
		result.append(')');
		return result.toString();
	}

} //StateMachine_unprocessedString_ValueImpl
