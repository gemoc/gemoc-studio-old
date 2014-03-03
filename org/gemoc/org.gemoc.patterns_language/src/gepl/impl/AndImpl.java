/**
 */
package gepl.impl;

import gepl.And;
import gepl.Atom;
import gepl.GeplPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gepl.impl.AndImpl#getFirstParameter <em>First Parameter</em>}</li>
 *   <li>{@link gepl.impl.AndImpl#getSecondParameter <em>Second Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AndImpl extends AtomImpl implements And {
	/**
	 * The cached value of the '{@link #getFirstParameter() <em>First Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstParameter()
	 * @generated
	 * @ordered
	 */
	protected Atom firstParameter;

	/**
	 * The cached value of the '{@link #getSecondParameter() <em>Second Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondParameter()
	 * @generated
	 * @ordered
	 */
	protected Atom secondParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeplPackage.Literals.AND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom getFirstParameter() {
		if (firstParameter != null && firstParameter.eIsProxy()) {
			InternalEObject oldFirstParameter = (InternalEObject)firstParameter;
			firstParameter = (Atom)eResolveProxy(oldFirstParameter);
			if (firstParameter != oldFirstParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeplPackage.AND__FIRST_PARAMETER, oldFirstParameter, firstParameter));
			}
		}
		return firstParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom basicGetFirstParameter() {
		return firstParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstParameter(Atom newFirstParameter) {
		Atom oldFirstParameter = firstParameter;
		firstParameter = newFirstParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeplPackage.AND__FIRST_PARAMETER, oldFirstParameter, firstParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom getSecondParameter() {
		if (secondParameter != null && secondParameter.eIsProxy()) {
			InternalEObject oldSecondParameter = (InternalEObject)secondParameter;
			secondParameter = (Atom)eResolveProxy(oldSecondParameter);
			if (secondParameter != oldSecondParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeplPackage.AND__SECOND_PARAMETER, oldSecondParameter, secondParameter));
			}
		}
		return secondParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom basicGetSecondParameter() {
		return secondParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondParameter(Atom newSecondParameter) {
		Atom oldSecondParameter = secondParameter;
		secondParameter = newSecondParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeplPackage.AND__SECOND_PARAMETER, oldSecondParameter, secondParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeplPackage.AND__FIRST_PARAMETER:
				if (resolve) return getFirstParameter();
				return basicGetFirstParameter();
			case GeplPackage.AND__SECOND_PARAMETER:
				if (resolve) return getSecondParameter();
				return basicGetSecondParameter();
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
			case GeplPackage.AND__FIRST_PARAMETER:
				setFirstParameter((Atom)newValue);
				return;
			case GeplPackage.AND__SECOND_PARAMETER:
				setSecondParameter((Atom)newValue);
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
			case GeplPackage.AND__FIRST_PARAMETER:
				setFirstParameter((Atom)null);
				return;
			case GeplPackage.AND__SECOND_PARAMETER:
				setSecondParameter((Atom)null);
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
			case GeplPackage.AND__FIRST_PARAMETER:
				return firstParameter != null;
			case GeplPackage.AND__SECOND_PARAMETER:
				return secondParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //AndImpl
