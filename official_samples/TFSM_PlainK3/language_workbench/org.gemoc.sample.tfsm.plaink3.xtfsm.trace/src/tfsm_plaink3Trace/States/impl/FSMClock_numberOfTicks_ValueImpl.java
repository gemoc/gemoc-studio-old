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

import tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value;
import tfsm_plaink3Trace.States.State;
import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Clock number Of Ticks Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl#getStatesNoOpposite <em>States No Opposite</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl#getNumberOfTicks <em>Number Of Ticks</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.impl.FSMClock_numberOfTicks_ValueImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMClock_numberOfTicks_ValueImpl extends MinimalEObjectImpl.Container implements FSMClock_numberOfTicks_Value {
	/**
	 * The default value of the '{@link #getNumberOfTicks() <em>Number Of Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfTicks()
	 * @generated
	 * @ordered
	 */
	protected static final Integer NUMBER_OF_TICKS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumberOfTicks() <em>Number Of Ticks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfTicks()
	 * @generated
	 * @ordered
	 */
	protected Integer numberOfTicks = NUMBER_OF_TICKS_EDEFAULT;

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
	protected FSMClock_numberOfTicks_ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatesPackage.Literals.FSM_CLOCK_NUMBER_OF_TICKS_VALUE;
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
	public Integer getNumberOfTicks() {
		return numberOfTicks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfTicks(Integer newNumberOfTicks) {
		Integer oldNumberOfTicks = numberOfTicks;
		numberOfTicks = newNumberOfTicks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS, oldNumberOfTicks, numberOfTicks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TracedFSMClock getParent() {
		if (eContainerFeatureID() != StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT) return null;
		return (TracedFSMClock)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TracedFSMClock newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TracedFSMClock newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE, TracedFSMClock.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES, StatesPackage.STATE__FSM_CLOCK_NUMBER_OF_TICKS_VALUES);
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((TracedFSMClock)otherEnd, msgs);
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				return basicSetParent(null, msgs);
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				return eInternalContainer().eInverseRemove(this, Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE, TracedFSMClock.class, msgs);
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES_NO_OPPOSITE:
				return getStatesNoOpposite();
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS:
				return getNumberOfTicks();
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				return getParent();
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS:
				setNumberOfTicks((Integer)newValue);
				return;
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				setParent((TracedFSMClock)newValue);
				return;
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS:
				setNumberOfTicks(NUMBER_OF_TICKS_EDEFAULT);
				return;
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				setParent((TracedFSMClock)null);
				return;
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES_NO_OPPOSITE:
				return !getStatesNoOpposite().isEmpty();
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__NUMBER_OF_TICKS:
				return NUMBER_OF_TICKS_EDEFAULT == null ? numberOfTicks != null : !NUMBER_OF_TICKS_EDEFAULT.equals(numberOfTicks);
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT:
				return getParent() != null;
			case StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__STATES:
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
		result.append(" (numberOfTicks: ");
		result.append(numberOfTicks);
		result.append(')');
		return result.toString();
	}

} //FSMClock_numberOfTicks_ValueImpl
