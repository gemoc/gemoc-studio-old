/**
 */
package glml.impl;

import glml.ECLEvent;
import glml.GlmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.completeocl.completeoclcs.DefPropertyCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ECL Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.ECLEventImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ECLEventImpl extends MocEventImpl implements ECLEvent {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected DefPropertyCS element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ECLEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.ECL_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefPropertyCS getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (DefPropertyCS)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GlmlPackage.ECL_EVENT__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefPropertyCS basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(DefPropertyCS newElement) {
		DefPropertyCS oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.ECL_EVENT__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlmlPackage.ECL_EVENT__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
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
			case GlmlPackage.ECL_EVENT__ELEMENT:
				setElement((DefPropertyCS)newValue);
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
			case GlmlPackage.ECL_EVENT__ELEMENT:
				setElement((DefPropertyCS)null);
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
			case GlmlPackage.ECL_EVENT__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

} //ECLEventImpl
