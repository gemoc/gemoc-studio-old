/**
 */
package glml.impl;

import glml.DomainSpecificAction;
import glml.DomainSpecificEvent;
import glml.GlmlPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.DomainSpecificActionImpl#getTargetClass <em>Target Class</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificActionImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificActionImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificActionImpl#getOwningDomainSpecificEvent <em>Owning Domain Specific Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificActionImpl extends MinimalEObjectImpl.Container implements DomainSpecificAction {
	/**
	 * The cached value of the '{@link #getTargetClass() <em>Target Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClass()
	 * @generated
	 * @ordered
	 */
	protected EClassifier targetClass;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected EOperation operation;

	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> parameterTypes;

	/**
	 * The cached value of the '{@link #getOwningDomainSpecificEvent() <em>Owning Domain Specific Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwningDomainSpecificEvent()
	 * @generated
	 * @ordered
	 */
	protected DomainSpecificEvent owningDomainSpecificEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSpecificActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.DOMAIN_SPECIFIC_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getTargetClass() {
		if (targetClass != null && targetClass.eIsProxy()) {
			InternalEObject oldTargetClass = (InternalEObject)targetClass;
			targetClass = (EClassifier)eResolveProxy(oldTargetClass);
			if (targetClass != oldTargetClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS, oldTargetClass, targetClass));
			}
		}
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetTargetClass() {
		return targetClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetClass(EClassifier newTargetClass) {
		EClassifier oldTargetClass = targetClass;
		targetClass = newTargetClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS, oldTargetClass, targetClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (EOperation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(EOperation newOperation) {
		EOperation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new EObjectResolvingEList<EClassifier>(EClassifier.class, this, GlmlPackage.DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES);
		}
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainSpecificEvent getOwningDomainSpecificEvent() {
		if (owningDomainSpecificEvent != null && owningDomainSpecificEvent.eIsProxy()) {
			InternalEObject oldOwningDomainSpecificEvent = (InternalEObject)owningDomainSpecificEvent;
			owningDomainSpecificEvent = (DomainSpecificEvent)eResolveProxy(oldOwningDomainSpecificEvent);
			if (owningDomainSpecificEvent != oldOwningDomainSpecificEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT, oldOwningDomainSpecificEvent, owningDomainSpecificEvent));
			}
		}
		return owningDomainSpecificEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainSpecificEvent basicGetOwningDomainSpecificEvent() {
		return owningDomainSpecificEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningDomainSpecificEvent(DomainSpecificEvent newOwningDomainSpecificEvent) {
		DomainSpecificEvent oldOwningDomainSpecificEvent = owningDomainSpecificEvent;
		owningDomainSpecificEvent = newOwningDomainSpecificEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT, oldOwningDomainSpecificEvent, owningDomainSpecificEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS:
				if (resolve) return getTargetClass();
				return basicGetTargetClass();
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES:
				return getParameterTypes();
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				if (resolve) return getOwningDomainSpecificEvent();
				return basicGetOwningDomainSpecificEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS:
				setTargetClass((EClassifier)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION:
				setOperation((EOperation)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES:
				getParameterTypes().clear();
				getParameterTypes().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				setOwningDomainSpecificEvent((DomainSpecificEvent)newValue);
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
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS:
				setTargetClass((EClassifier)null);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION:
				setOperation((EOperation)null);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES:
				getParameterTypes().clear();
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				setOwningDomainSpecificEvent((DomainSpecificEvent)null);
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
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__TARGET_CLASS:
				return targetClass != null;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OPERATION:
				return operation != null;
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES:
				return parameterTypes != null && !parameterTypes.isEmpty();
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				return owningDomainSpecificEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificActionImpl
