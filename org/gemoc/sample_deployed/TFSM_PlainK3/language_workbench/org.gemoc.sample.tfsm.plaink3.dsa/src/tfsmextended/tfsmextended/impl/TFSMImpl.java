/**
 */
package tfsmextended.tfsmextended.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tfsmextended.tfsmextended.State;
import tfsmextended.tfsmextended.TFSM;
import tfsmextended.tfsmextended.TfsmextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TFSM</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsmextended.tfsmextended.impl.TFSMImpl#getCurrentState <em>Current State</em>}</li>
 *   <li>{@link tfsmextended.tfsmextended.impl.TFSMImpl#getStepNumber <em>Step Number</em>}</li>
 *   <li>{@link tfsmextended.tfsmextended.impl.TFSMImpl#getLastStateChangeStepNumber <em>Last State Change Step Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TFSMImpl extends org.gemoc.sample.tfsm.impl.TFSMImpl implements TFSM {
	/**
	 * The cached value of the '{@link #getCurrentState() <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentState()
	 * @generated
	 * @ordered
	 */
	protected State currentState;

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
	 * The default value of the '{@link #getLastStateChangeStepNumber() <em>Last State Change Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStateChangeStepNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getLastStateChangeStepNumber() <em>Last State Change Step Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastStateChangeStepNumber()
	 * @generated
	 * @ordered
	 */
	protected int lastStateChangeStepNumber = LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TFSMImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmextendedPackage.Literals.TFSM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getCurrentState() {
		if (currentState != null && currentState.eIsProxy()) {
			InternalEObject oldCurrentState = (InternalEObject)currentState;
			currentState = (State)eResolveProxy(oldCurrentState);
			if (currentState != oldCurrentState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TfsmextendedPackage.TFSM__CURRENT_STATE, oldCurrentState, currentState));
			}
		}
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetCurrentState() {
		return currentState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentState(State newCurrentState) {
		State oldCurrentState = currentState;
		currentState = newCurrentState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmextendedPackage.TFSM__CURRENT_STATE, oldCurrentState, currentState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmextendedPackage.TFSM__STEP_NUMBER, oldStepNumber, stepNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLastStateChangeStepNumber() {
		return lastStateChangeStepNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastStateChangeStepNumber(int newLastStateChangeStepNumber) {
		int oldLastStateChangeStepNumber = lastStateChangeStepNumber;
		lastStateChangeStepNumber = newLastStateChangeStepNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmextendedPackage.TFSM__LAST_STATE_CHANGE_STEP_NUMBER, oldLastStateChangeStepNumber, lastStateChangeStepNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String init() {
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
			case TfsmextendedPackage.TFSM__CURRENT_STATE:
				if (resolve) return getCurrentState();
				return basicGetCurrentState();
			case TfsmextendedPackage.TFSM__STEP_NUMBER:
				return getStepNumber();
			case TfsmextendedPackage.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
				return getLastStateChangeStepNumber();
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
			case TfsmextendedPackage.TFSM__CURRENT_STATE:
				setCurrentState((State)newValue);
				return;
			case TfsmextendedPackage.TFSM__STEP_NUMBER:
				setStepNumber((Integer)newValue);
				return;
			case TfsmextendedPackage.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
				setLastStateChangeStepNumber((Integer)newValue);
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
			case TfsmextendedPackage.TFSM__CURRENT_STATE:
				setCurrentState((State)null);
				return;
			case TfsmextendedPackage.TFSM__STEP_NUMBER:
				setStepNumber(STEP_NUMBER_EDEFAULT);
				return;
			case TfsmextendedPackage.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
				setLastStateChangeStepNumber(LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT);
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
			case TfsmextendedPackage.TFSM__CURRENT_STATE:
				return currentState != null;
			case TfsmextendedPackage.TFSM__STEP_NUMBER:
				return stepNumber != STEP_NUMBER_EDEFAULT;
			case TfsmextendedPackage.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
				return lastStateChangeStepNumber != LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT;
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
		result.append(", lastStateChangeStepNumber: ");
		result.append(lastStateChangeStepNumber);
		result.append(')');
		return result.toString();
	}

} //TFSMImpl
