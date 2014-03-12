/**
 */
package gepl.impl;

import gepl.And;
import gepl.Atom;
import gepl.GeplPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
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
	 * The cached value of the '{@link #getFirstParameter() <em>First Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstParameter()
	 * @generated
	 * @ordered
	 */
	protected Atom firstParameter;

	/**
	 * The cached value of the '{@link #getSecondParameter() <em>Second Parameter</em>}' containment reference.
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
		return firstParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstParameter(Atom newFirstParameter, NotificationChain msgs) {
		Atom oldFirstParameter = firstParameter;
		firstParameter = newFirstParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeplPackage.AND__FIRST_PARAMETER, oldFirstParameter, newFirstParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstParameter(Atom newFirstParameter) {
		if (newFirstParameter != firstParameter) {
			NotificationChain msgs = null;
			if (firstParameter != null)
				msgs = ((InternalEObject)firstParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeplPackage.AND__FIRST_PARAMETER, null, msgs);
			if (newFirstParameter != null)
				msgs = ((InternalEObject)newFirstParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeplPackage.AND__FIRST_PARAMETER, null, msgs);
			msgs = basicSetFirstParameter(newFirstParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeplPackage.AND__FIRST_PARAMETER, newFirstParameter, newFirstParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Atom getSecondParameter() {
		return secondParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondParameter(Atom newSecondParameter, NotificationChain msgs) {
		Atom oldSecondParameter = secondParameter;
		secondParameter = newSecondParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeplPackage.AND__SECOND_PARAMETER, oldSecondParameter, newSecondParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondParameter(Atom newSecondParameter) {
		if (newSecondParameter != secondParameter) {
			NotificationChain msgs = null;
			if (secondParameter != null)
				msgs = ((InternalEObject)secondParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeplPackage.AND__SECOND_PARAMETER, null, msgs);
			if (newSecondParameter != null)
				msgs = ((InternalEObject)newSecondParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeplPackage.AND__SECOND_PARAMETER, null, msgs);
			msgs = basicSetSecondParameter(newSecondParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeplPackage.AND__SECOND_PARAMETER, newSecondParameter, newSecondParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeplPackage.AND__FIRST_PARAMETER:
				return basicSetFirstParameter(null, msgs);
			case GeplPackage.AND__SECOND_PARAMETER:
				return basicSetSecondParameter(null, msgs);
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
			case GeplPackage.AND__FIRST_PARAMETER:
				return getFirstParameter();
			case GeplPackage.AND__SECOND_PARAMETER:
				return getSecondParameter();
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
