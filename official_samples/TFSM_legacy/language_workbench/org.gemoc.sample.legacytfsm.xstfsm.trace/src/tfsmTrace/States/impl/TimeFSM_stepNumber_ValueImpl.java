/**
 */
package tfsmTrace.States.impl;

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

import tfsmTrace.States.State;
import tfsmTrace.States.StatesPackage;
import tfsmTrace.States.TimeFSM_stepNumber_Value;

import tfsmTrace.States.tfsm.TfsmPackage;
import tfsmTrace.States.tfsm.TracedTimeFSM;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time FSM step Number Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tfsmTrace.States.impl.TimeFSM_stepNumber_ValueImpl#getStatesNoOpposite <em>States No Opposite</em>}</li>
 *   <li>{@link tfsmTrace.States.impl.TimeFSM_stepNumber_ValueImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link tfsmTrace.States.impl.TimeFSM_stepNumber_ValueImpl#getStates <em>States</em>}</li>
 *   <li>{@link tfsmTrace.States.impl.TimeFSM_stepNumber_ValueImpl#getStepNumber <em>Step Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeFSM_stepNumber_ValueImpl extends MinimalEObjectImpl.Container implements TimeFSM_stepNumber_Value {
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
	 * The default value of the '{@link #getStepNumber() <em>Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepNumber() <em>Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepNumber()
	 * @generated
	 * @ordered
	 */
	protected int stepNumber = STEP_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeFSM_stepNumber_ValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatesPackage.Literals.TIME_FSM_STEP_NUMBER_VALUE;
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
	public TracedTimeFSM getParent() {
		if (eContainerFeatureID() != StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT) return null;
		return (TracedTimeFSM)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TracedTimeFSM newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TracedTimeFSM newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE, TracedTimeFSM.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectWithInverseResolvingEList.ManyInverse<State>(State.class, this, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES, StatesPackage.STATE__TIME_FSM_STEP_NUMBER_VALUES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepNumber() {
		return stepNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepNumber(int newStepNumber) {
		int oldStepNumber = stepNumber;
		stepNumber = newStepNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STEP_NUMBER, oldStepNumber, stepNumber));
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((TracedTimeFSM)otherEnd, msgs);
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				return basicSetParent(null, msgs);
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				return eInternalContainer().eInverseRemove(this, TfsmPackage.TRACED_TIME_FSM__STEP_NUMBER_SEQUENCE, TracedTimeFSM.class, msgs);
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES_NO_OPPOSITE:
				return getStatesNoOpposite();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				return getParent();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
				return getStates();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STEP_NUMBER:
				return getStepNumber();
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				setParent((TracedTimeFSM)newValue);
				return;
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STEP_NUMBER:
				setStepNumber((Integer)newValue);
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				setParent((TracedTimeFSM)null);
				return;
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
				getStates().clear();
				return;
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STEP_NUMBER:
				setStepNumber(STEP_NUMBER_EDEFAULT);
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
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES_NO_OPPOSITE:
				return !getStatesNoOpposite().isEmpty();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__PARENT:
				return getParent() != null;
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STATES:
				return states != null && !states.isEmpty();
			case StatesPackage.TIME_FSM_STEP_NUMBER_VALUE__STEP_NUMBER:
				return stepNumber != STEP_NUMBER_EDEFAULT;
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
		result.append(" (stepNumber: ");
		result.append(stepNumber);
		result.append(')');
		return result.toString();
	}

} //TimeFSM_stepNumber_ValueImpl
