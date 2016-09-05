/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;

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
 * </p>
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl#getNumberOfTicksSequence <em>Number Of Ticks Sequence</em>}</li>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedFSMClockImpl#getOriginalObject <em>Original Object</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected FSMClock originalObject;

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
	public FSMClock getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = (FSMClock)eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FSMClock basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(FSMClock newOriginalObject) {
		FSMClock oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT:
				setOriginalObject((FSMClock)newValue);
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT:
				setOriginalObject((FSMClock)null);
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
			case Tfsm_plaink3Package.TRACED_FSM_CLOCK__ORIGINAL_OBJECT:
				return originalObject != null;
		}
		return super.eIsSet(featureID);
	}

} //TracedFSMClockImpl
