/**
 */
package tfsmextended.tfsmextended.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tfsmextended.tfsmextended.FSMEvent;
import tfsmextended.tfsmextended.TfsmextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>FSM Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsmextended.tfsmextended.impl.FSMEventImpl#isIsTriggered <em>Is Triggered</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FSMEventImpl extends org.gemoc.sample.tfsm.impl.FSMEventImpl implements FSMEvent {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FSMEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TfsmextendedPackage.Literals.FSM_EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TfsmextendedPackage.FSM_EVENT__IS_TRIGGERED, oldIsTriggered, isTriggered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TfsmextendedPackage.FSM_EVENT__IS_TRIGGERED:
				return isIsTriggered();
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
			case TfsmextendedPackage.FSM_EVENT__IS_TRIGGERED:
				setIsTriggered((Boolean)newValue);
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
			case TfsmextendedPackage.FSM_EVENT__IS_TRIGGERED:
				setIsTriggered(IS_TRIGGERED_EDEFAULT);
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
			case TfsmextendedPackage.FSM_EVENT__IS_TRIGGERED:
				return isTriggered != IS_TRIGGERED_EDEFAULT;
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

} //FSMEventImpl
