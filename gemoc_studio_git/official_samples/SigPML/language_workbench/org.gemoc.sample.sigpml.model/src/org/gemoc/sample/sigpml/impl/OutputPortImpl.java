/**
 */
package org.gemoc.sample.sigpml.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.sample.sigpml.OutputPort;
import org.gemoc.sample.sigpml.SigpmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.sample.sigpml.impl.OutputPortImpl#getSizeWritten <em>Size Written</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPortImpl extends PortImpl implements OutputPort {
	/**
	 * The default value of the '{@link #getSizeWritten() <em>Size Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeWritten()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_WRITTEN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSizeWritten() <em>Size Written</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSizeWritten()
	 * @generated
	 * @ordered
	 */
	protected int sizeWritten = SIZE_WRITTEN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SigpmlPackage.Literals.OUTPUT_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSizeWritten() {
		return sizeWritten;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeWritten(int newSizeWritten) {
		int oldSizeWritten = sizeWritten;
		sizeWritten = newSizeWritten;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SigpmlPackage.OUTPUT_PORT__SIZE_WRITTEN, oldSizeWritten, sizeWritten));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void write() {
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
			case SigpmlPackage.OUTPUT_PORT__SIZE_WRITTEN:
				return getSizeWritten();
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
			case SigpmlPackage.OUTPUT_PORT__SIZE_WRITTEN:
				setSizeWritten((Integer)newValue);
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
			case SigpmlPackage.OUTPUT_PORT__SIZE_WRITTEN:
				setSizeWritten(SIZE_WRITTEN_EDEFAULT);
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
			case SigpmlPackage.OUTPUT_PORT__SIZE_WRITTEN:
				return sizeWritten != SIZE_WRITTEN_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SigpmlPackage.OUTPUT_PORT___WRITE:
				write();
				return null;
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (sizeWritten: ");
		result.append(sizeWritten);
		result.append(')');
		return result.toString();
	}

} //OutputPortImpl
