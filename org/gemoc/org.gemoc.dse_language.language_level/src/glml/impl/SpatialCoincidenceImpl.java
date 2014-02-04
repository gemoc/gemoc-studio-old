/**
 */
package glml.impl;

import glml.GlmlPackage;
import glml.MocEvent;
import glml.SpatialCoincidence;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Spatial Coincidence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link glml.impl.SpatialCoincidenceImpl#getFirstArgument <em>First Argument</em>}</li>
 *   <li>{@link glml.impl.SpatialCoincidenceImpl#getSecondArgument <em>Second Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpatialCoincidenceImpl extends PatternImpl implements SpatialCoincidence {
	/**
	 * The cached value of the '{@link #getFirstArgument() <em>First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstArgument()
	 * @generated
	 * @ordered
	 */
	protected MocEvent firstArgument;

	/**
	 * The cached value of the '{@link #getSecondArgument() <em>Second Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondArgument()
	 * @generated
	 * @ordered
	 */
	protected MocEvent secondArgument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpatialCoincidenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GlmlPackage.Literals.SPATIAL_COINCIDENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MocEvent getFirstArgument() {
		return firstArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstArgument(MocEvent newFirstArgument, NotificationChain msgs) {
		MocEvent oldFirstArgument = firstArgument;
		firstArgument = newFirstArgument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT, oldFirstArgument, newFirstArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstArgument(MocEvent newFirstArgument) {
		if (newFirstArgument != firstArgument) {
			NotificationChain msgs = null;
			if (firstArgument != null)
				msgs = ((InternalEObject)firstArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT, null, msgs);
			if (newFirstArgument != null)
				msgs = ((InternalEObject)newFirstArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT, null, msgs);
			msgs = basicSetFirstArgument(newFirstArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT, newFirstArgument, newFirstArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MocEvent getSecondArgument() {
		return secondArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondArgument(MocEvent newSecondArgument, NotificationChain msgs) {
		MocEvent oldSecondArgument = secondArgument;
		secondArgument = newSecondArgument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT, oldSecondArgument, newSecondArgument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondArgument(MocEvent newSecondArgument) {
		if (newSecondArgument != secondArgument) {
			NotificationChain msgs = null;
			if (secondArgument != null)
				msgs = ((InternalEObject)secondArgument).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT, null, msgs);
			if (newSecondArgument != null)
				msgs = ((InternalEObject)newSecondArgument).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT, null, msgs);
			msgs = basicSetSecondArgument(newSecondArgument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT, newSecondArgument, newSecondArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT:
				return basicSetFirstArgument(null, msgs);
			case GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT:
				return basicSetSecondArgument(null, msgs);
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
			case GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT:
				return getFirstArgument();
			case GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT:
				return getSecondArgument();
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
			case GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT:
				setFirstArgument((MocEvent)newValue);
				return;
			case GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT:
				setSecondArgument((MocEvent)newValue);
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
			case GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT:
				setFirstArgument((MocEvent)null);
				return;
			case GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT:
				setSecondArgument((MocEvent)null);
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
			case GlmlPackage.SPATIAL_COINCIDENCE__FIRST_ARGUMENT:
				return firstArgument != null;
			case GlmlPackage.SPATIAL_COINCIDENCE__SECOND_ARGUMENT:
				return secondArgument != null;
		}
		return super.eIsSet(featureID);
	}

} //SpatialCoincidenceImpl
