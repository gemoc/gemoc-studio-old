/**
 */
package glml.impl;

import glml.DomainSpecificAction;
import glml.DomainSpecificEvent;
import glml.GlmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT) return null;
		return (DomainSpecificEvent)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningDomainSpecificEvent(DomainSpecificEvent newOwningDomainSpecificEvent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningDomainSpecificEvent, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningDomainSpecificEvent(DomainSpecificEvent newOwningDomainSpecificEvent) {
		if (newOwningDomainSpecificEvent != eInternalContainer() || (eContainerFeatureID() != GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT && newOwningDomainSpecificEvent != null)) {
			if (EcoreUtil.isAncestor(this, newOwningDomainSpecificEvent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningDomainSpecificEvent != null)
				msgs = ((InternalEObject)newOwningDomainSpecificEvent).eInverseAdd(this, GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS, DomainSpecificEvent.class, msgs);
			msgs = basicSetOwningDomainSpecificEvent(newOwningDomainSpecificEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT, newOwningDomainSpecificEvent, newOwningDomainSpecificEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningDomainSpecificEvent((DomainSpecificEvent)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				return basicSetOwningDomainSpecificEvent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT:
				return eInternalContainer().eInverseRemove(this, GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS, DomainSpecificEvent.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
				return getOwningDomainSpecificEvent();
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
				return getOwningDomainSpecificEvent() != null;
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificActionImpl
