/**
 */
package javasolverinput.usage.impl;

import javasolverinput.usage.Clock;
import javasolverinput.usage.Precedes;
import javasolverinput.usage.UsagePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Precedes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link javasolverinput.usage.impl.PrecedesImpl#getClock1 <em>Clock1</em>}</li>
 *   <li>{@link javasolverinput.usage.impl.PrecedesImpl#getClock2 <em>Clock2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrecedesImpl extends ConstraintImpl implements Precedes {
	/**
	 * The cached value of the '{@link #getClock1() <em>Clock1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClock1()
	 * @generated
	 * @ordered
	 */
	protected Clock clock1;

	/**
	 * The cached value of the '{@link #getClock2() <em>Clock2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClock2()
	 * @generated
	 * @ordered
	 */
	protected Clock clock2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrecedesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagePackage.Literals.PRECEDES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock getClock1() {
		if (clock1 != null && clock1.eIsProxy()) {
			InternalEObject oldClock1 = (InternalEObject)clock1;
			clock1 = (Clock)eResolveProxy(oldClock1);
			if (clock1 != oldClock1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagePackage.PRECEDES__CLOCK1, oldClock1, clock1));
			}
		}
		return clock1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock basicGetClock1() {
		return clock1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClock1(Clock newClock1) {
		Clock oldClock1 = clock1;
		clock1 = newClock1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagePackage.PRECEDES__CLOCK1, oldClock1, clock1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock getClock2() {
		if (clock2 != null && clock2.eIsProxy()) {
			InternalEObject oldClock2 = (InternalEObject)clock2;
			clock2 = (Clock)eResolveProxy(oldClock2);
			if (clock2 != oldClock2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagePackage.PRECEDES__CLOCK2, oldClock2, clock2));
			}
		}
		return clock2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clock basicGetClock2() {
		return clock2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClock2(Clock newClock2) {
		Clock oldClock2 = clock2;
		clock2 = newClock2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagePackage.PRECEDES__CLOCK2, oldClock2, clock2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagePackage.PRECEDES__CLOCK1:
				if (resolve) return getClock1();
				return basicGetClock1();
			case UsagePackage.PRECEDES__CLOCK2:
				if (resolve) return getClock2();
				return basicGetClock2();
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
			case UsagePackage.PRECEDES__CLOCK1:
				setClock1((Clock)newValue);
				return;
			case UsagePackage.PRECEDES__CLOCK2:
				setClock2((Clock)newValue);
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
			case UsagePackage.PRECEDES__CLOCK1:
				setClock1((Clock)null);
				return;
			case UsagePackage.PRECEDES__CLOCK2:
				setClock2((Clock)null);
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
			case UsagePackage.PRECEDES__CLOCK1:
				return clock1 != null;
			case UsagePackage.PRECEDES__CLOCK2:
				return clock2 != null;
		}
		return super.eIsSet(featureID);
	}

} //PrecedesImpl
