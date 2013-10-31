/**
 */
package gmml.impl;

import glml.LanguageSpecificEvent;

import glml.impl.NamedElementImpl;

import gmml.GmmlPackage;
import gmml.ModelSpecificEvent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Specific Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gmml.impl.ModelSpecificEventImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link gmml.impl.ModelSpecificEventImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link gmml.impl.ModelSpecificEventImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link gmml.impl.ModelSpecificEventImpl#getReification <em>Reification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelSpecificEventImpl extends NamedElementImpl implements ModelSpecificEvent {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject target;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<EOperation> operations;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReification() <em>Reification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReification()
	 * @generated
	 * @ordered
	 */
	protected LanguageSpecificEvent reification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSpecificEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GmmlPackage.Literals.MODEL_SPECIFIC_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		EObject oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EOperation> getOperations() {
		if (operations == null) {
			operations = new EObjectResolvingEList<EOperation>(EOperation.class, this, GmmlPackage.MODEL_SPECIFIC_EVENT__OPERATIONS);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GmmlPackage.MODEL_SPECIFIC_EVENT__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageSpecificEvent getReification() {
		if (reification != null && reification.eIsProxy()) {
			InternalEObject oldReification = (InternalEObject)reification;
			reification = (LanguageSpecificEvent)eResolveProxy(oldReification);
			if (reification != oldReification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION, oldReification, reification));
			}
		}
		return reification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LanguageSpecificEvent basicGetReification() {
		return reification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReification(LanguageSpecificEvent newReification) {
		LanguageSpecificEvent oldReification = reification;
		reification = newReification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION, oldReification, reification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GmmlPackage.MODEL_SPECIFIC_EVENT__OPERATIONS:
				return getOperations();
			case GmmlPackage.MODEL_SPECIFIC_EVENT__CONDITION:
				return getCondition();
			case GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION:
				if (resolve) return getReification();
				return basicGetReification();
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET:
				setTarget((EObject)newValue);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends EOperation>)newValue);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__CONDITION:
				setCondition((String)newValue);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION:
				setReification((LanguageSpecificEvent)newValue);
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET:
				setTarget((EObject)null);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__OPERATIONS:
				getOperations().clear();
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION:
				setReification((LanguageSpecificEvent)null);
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
			case GmmlPackage.MODEL_SPECIFIC_EVENT__TARGET:
				return target != null;
			case GmmlPackage.MODEL_SPECIFIC_EVENT__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case GmmlPackage.MODEL_SPECIFIC_EVENT__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
			case GmmlPackage.MODEL_SPECIFIC_EVENT__REIFICATION:
				return reification != null;
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
		result.append(" (condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} //ModelSpecificEventImpl
