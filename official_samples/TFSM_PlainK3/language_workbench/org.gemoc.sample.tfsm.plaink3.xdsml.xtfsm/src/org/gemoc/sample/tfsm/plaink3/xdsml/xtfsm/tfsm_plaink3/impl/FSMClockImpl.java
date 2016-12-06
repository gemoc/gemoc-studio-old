/**
 */
package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Tfsm_plaink3Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Clock</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.impl.FSMClockImpl#getNumberOfTicks <em>Number Of Ticks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FSMClockImpl extends NamedElementImpl implements FSMClock {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMClockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3Package.Literals.FSM_CLOCK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS, oldNumberOfTicks, numberOfTicks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer ticks() {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
				return getNumberOfTicks();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
				setNumberOfTicks((Integer)newValue);
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
			case Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
				setNumberOfTicks(NUMBER_OF_TICKS_EDEFAULT);
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
			case Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
				return NUMBER_OF_TICKS_EDEFAULT == null ? numberOfTicks != null : !NUMBER_OF_TICKS_EDEFAULT.equals(numberOfTicks);
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

} //FSMClockImpl
