/**
 */
package glml.impl;

import glml.GlmlPackage;
import glml.Identity;
import glml.MocEvent;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.IdentityImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentityImpl extends PatternImpl implements Identity {
	/**
	 * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgument()
	 * @generated
	 * @ordered
	 */
	protected MocEvent argument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.IDENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MocEvent getArgument() {
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArgument(MocEvent newArgument, NotificationChain msgs) {
		MocEvent oldArgument = argument;
		argument = newArgument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlmlPackage.IDENTITY__ARGUMENT, oldArgument, newArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArgument(MocEvent newArgument) {
		if (newArgument != argument) {
			NotificationChain msgs = null;
			if (argument != null)
				msgs = ((InternalEObject)argument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.IDENTITY__ARGUMENT, null, msgs);
			if (newArgument != null)
				msgs = ((InternalEObject)newArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.IDENTITY__ARGUMENT, null, msgs);
			msgs = basicSetArgument(newArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.IDENTITY__ARGUMENT, newArgument, newArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.IDENTITY__ARGUMENT:
				return basicSetArgument(null, msgs);
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
			case GlmlPackage.IDENTITY__ARGUMENT:
				return getArgument();
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
			case GlmlPackage.IDENTITY__ARGUMENT:
				setArgument((MocEvent)newValue);
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
			case GlmlPackage.IDENTITY__ARGUMENT:
				setArgument((MocEvent)null);
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
			case GlmlPackage.IDENTITY__ARGUMENT:
				return argument != null;
		}
		return super.eIsSet(featureID);
	}

} //IdentityImpl
