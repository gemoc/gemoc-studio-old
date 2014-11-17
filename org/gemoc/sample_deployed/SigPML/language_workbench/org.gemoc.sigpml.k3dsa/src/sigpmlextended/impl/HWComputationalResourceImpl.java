/**
 */
package sigpmlextended.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import sigpmlextended.HWComputationalResource;
import sigpmlextended.SigpmlextendedPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HW Computational Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link sigpmlextended.impl.HWComputationalResourceImpl#getCurrentExecCycle <em>Current Exec Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HWComputationalResourceImpl extends org.gemoc.sigpml.impl.HWComputationalResourceImpl implements HWComputationalResource {
	/**
	 * The default value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected static final int CURRENT_EXEC_CYCLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCurrentExecCycle() <em>Current Exec Cycle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentExecCycle()
	 * @generated
	 * @ordered
	 */
	protected int currentExecCycle = CURRENT_EXEC_CYCLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HWComputationalResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlextendedPackage.Literals.HW_COMPUTATIONAL_RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCurrentExecCycle() {
		return currentExecCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentExecCycle(int newCurrentExecCycle) {
		int oldCurrentExecCycle = currentExecCycle;
		currentExecCycle = newCurrentExecCycle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE, oldCurrentExecCycle, currentExecCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void incCycle() {
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
			case SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				return getCurrentExecCycle();
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
			case SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle((Integer)newValue);
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
			case SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				setCurrentExecCycle(CURRENT_EXEC_CYCLE_EDEFAULT);
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
			case SigpmlextendedPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
				return currentExecCycle != CURRENT_EXEC_CYCLE_EDEFAULT;
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
		result.append(" (currentExecCycle: ");
		result.append(currentExecCycle);
		result.append(')');
		return result.toString();
	}

} //HWComputationalResourceImpl
