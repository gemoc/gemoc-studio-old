/**
 */
package glml.impl;

import gepl.Pattern;

import glml.DomainSpecificAction;
import glml.DomainSpecificEvent;
import glml.GlmlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.DomainSpecificEventImpl#getDomainSpecificActions <em>Domain Specific Actions</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificEventImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEventImpl extends NamedElementImpl implements DomainSpecificEvent {
	/**
	 * The cached value of the '{@link #getDomainSpecificActions() <em>Domain Specific Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainSpecificActions()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainSpecificAction> domainSpecificActions;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Pattern condition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSpecificEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.DOMAIN_SPECIFIC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainSpecificAction> getDomainSpecificActions() {
		if (domainSpecificActions == null) {
			domainSpecificActions = new EObjectContainmentWithInverseEList<DomainSpecificAction>(DomainSpecificAction.class, this, GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS, GlmlPackage.DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT);
		}
		return domainSpecificActions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (Pattern)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Pattern newCondition) {
		Pattern oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDomainSpecificActions()).basicAdd(otherEnd, msgs);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return ((InternalEList<?>)getDomainSpecificActions()).basicRemove(otherEnd, msgs);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return getDomainSpecificActions();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				getDomainSpecificActions().clear();
				getDomainSpecificActions().addAll((Collection<? extends DomainSpecificAction>)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				setCondition((Pattern)newValue);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				getDomainSpecificActions().clear();
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				setCondition((Pattern)null);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return domainSpecificActions != null && !domainSpecificActions.isEmpty();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				return condition != null;
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificEventImpl
