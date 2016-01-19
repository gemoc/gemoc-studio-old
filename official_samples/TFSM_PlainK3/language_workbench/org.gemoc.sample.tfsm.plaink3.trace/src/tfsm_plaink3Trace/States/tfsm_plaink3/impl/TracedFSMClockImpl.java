/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tfsm_plaink3Trace.States.FSMClock_numberOfTicks_Value;
import tfsm_plaink3Trace.States.StatesPackage;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedFSMClock;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced FSM Clock</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracedFSMClockImpl extends TracedNamedElementImpl implements TracedFSMClock {
	/**
	 * The cached value of the '{@link #getNumberOfTicksSequence() <em>Number Of Ticks Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfTicksSequence()
	 * @generated
	 * @ordered
	 */
	protected EList<FSMClock_numberOfTicks_Value> numberOfTicksSequence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedFSMClockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3Package.Literals.TRACED_FSM_CLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FSMClock_numberOfTicks_Value> getNumberOfTicksSequence() {
		if (numberOfTicksSequence == null) {
			numberOfTicksSequence = new EObjectContainmentWithInverseEList<FSMClock_numberOfTicks_Value>(FSMClock_numberOfTicks_Value.class, this, Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE, StatesPackage.FSM_CLOCK_NUMBER_OF_TICKS_VALUE__PARENT);
		}
		return numberOfTicksSequence;
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNumberOfTicksSequence()).basicAdd(otherEnd, msgs);
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				return ((InternalEList<?>)getNumberOfTicksSequence()).basicRemove(otherEnd, msgs);
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				return getNumberOfTicksSequence();
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				getNumberOfTicksSequence().clear();
				getNumberOfTicksSequence().addAll((Collection<? extends FSMClock_numberOfTicks_Value>)newValue);
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				getNumberOfTicksSequence().clear();
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__NUMBER_OF_TICKS_SEQUENCE:
				return numberOfTicksSequence != null && !numberOfTicksSequence.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TracedFSMClockImpl
