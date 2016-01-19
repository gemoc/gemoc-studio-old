/**
 */
package tfsm_plaink3Trace.States.tfsm_plaink3.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.gemoc.sample.tfsm_plaink3.NamedElement;

import tfsm_plaink3Trace.States.tfsm_plaink3.Tfsm_plaink3Package;
import tfsm_plaink3Trace.States.tfsm_plaink3.TracedNamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Traced Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tfsm_plaink3Trace.States.tfsm_plaink3.impl.TracedNamedElementImpl#getOriginalObject_NamedElement <em>Original Object Named Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TracedNamedElementImpl extends MinimalEObjectImpl.Container implements TracedNamedElement {
	/**
	 * The cached value of the '{@link #getOriginalObject_NamedElement() <em>Original Object Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement originalObject_NamedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TracedNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tfsm_plaink3Package.Literals.TRACED_NAMED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getOriginalObject_NamedElement() {
		if (originalObject_NamedElement != null && originalObject_NamedElement.eIsProxy()) {
			InternalEObject oldOriginalObject_NamedElement = (InternalEObject)originalObject_NamedElement;
			originalObject_NamedElement = (NamedElement)eResolveProxy(oldOriginalObject_NamedElement);
			if (originalObject_NamedElement != oldOriginalObject_NamedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT, oldOriginalObject_NamedElement, originalObject_NamedElement));
			}
		}
		return originalObject_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetOriginalObject_NamedElement() {
		return originalObject_NamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject_NamedElement(NamedElement newOriginalObject_NamedElement) {
		NamedElement oldOriginalObject_NamedElement = originalObject_NamedElement;
		originalObject_NamedElement = newOriginalObject_NamedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT, oldOriginalObject_NamedElement, originalObject_NamedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT:
				if (resolve) return getOriginalObject_NamedElement();
				return basicGetOriginalObject_NamedElement();
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
			case Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT:
				setOriginalObject_NamedElement((NamedElement)newValue);
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
			case Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT:
				setOriginalObject_NamedElement((NamedElement)null);
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
			case Tfsm_plaink3Package.TRACED_NAMED_ELEMENT__ORIGINAL_OBJECT_NAMED_ELEMENT:
				return originalObject_NamedElement != null;
		}
		return super.eIsSet(featureID);
	}

} //TracedNamedElementImpl
