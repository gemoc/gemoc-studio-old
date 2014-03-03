/**
 */
package glml.impl;

import glml.DomainSpecificAction;
import glml.DomainSpecificEvent;
import glml.GlmlPackage;
import glml.Pattern;

import glml.Visibility;
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
 *   <li>{@link glml.impl.DomainSpecificEventImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificEventImpl#getDomainSpecificActions <em>Domain Specific Actions</em>}</li>
 *   <li>{@link glml.impl.DomainSpecificEventImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificEventImpl extends NamedElementImpl implements DomainSpecificEvent {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Pattern condition;

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
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.EXTERNAL;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected Visibility visibility = VISIBILITY_EDEFAULT;

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
	public Pattern getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Pattern newCondition, NotificationChain msgs) {
		Pattern oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Pattern newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION, newCondition, newCondition));
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
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.DOMAIN_SPECIFIC_EVENT__VISIBILITY, oldVisibility, visibility));
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				return basicSetCondition(null, msgs);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				return getCondition();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return getDomainSpecificActions();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__VISIBILITY:
				return getVisibility();
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				setCondition((Pattern)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				getDomainSpecificActions().clear();
				getDomainSpecificActions().addAll((Collection<? extends DomainSpecificAction>)newValue);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__VISIBILITY:
				setVisibility((Visibility)newValue);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				setCondition((Pattern)null);
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				getDomainSpecificActions().clear();
				return;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
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
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__CONDITION:
				return condition != null;
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS:
				return domainSpecificActions != null && !domainSpecificActions.isEmpty();
			case GlmlPackage.DOMAIN_SPECIFIC_EVENT__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
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
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //DomainSpecificEventImpl
