/**
 */
package sigpmlextended.impl;

import com.google.common.collect.LinkedListMultimap;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sigpmlextended.impl.SystemImpl#getSharedMemory <em>Shared Memory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends org.gemoc.sigpml.impl.SystemImpl implements sigpmlextended.System {
	/**
	 * The default value of the '{@link #getSharedMemory() <em>Shared Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedMemory()
	 * @generated
	 * @ordered
	 */
	protected static final LinkedListMultimap SHARED_MEMORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharedMemory() <em>Shared Memory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedMemory()
	 * @generated
	 * @ordered
	 */
	protected LinkedListMultimap sharedMemory = SHARED_MEMORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlextendedPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkedListMultimap getSharedMemory() {
		return sharedMemory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedMemory(LinkedListMultimap newSharedMemory) {
		LinkedListMultimap oldSharedMemory = sharedMemory;
		sharedMemory = newSharedMemory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.SYSTEM__SHARED_MEMORY, oldSharedMemory, sharedMemory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SigpmlextendedPackage.SYSTEM__SHARED_MEMORY:
				return getSharedMemory();
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
			case SigpmlextendedPackage.SYSTEM__SHARED_MEMORY:
				setSharedMemory((LinkedListMultimap)newValue);
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
			case SigpmlextendedPackage.SYSTEM__SHARED_MEMORY:
				setSharedMemory(SHARED_MEMORY_EDEFAULT);
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
			case SigpmlextendedPackage.SYSTEM__SHARED_MEMORY:
				return SHARED_MEMORY_EDEFAULT == null ? sharedMemory != null : !SHARED_MEMORY_EDEFAULT.equals(sharedMemory);
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
		result.append(" (sharedMemory: ");
		result.append(sharedMemory);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
