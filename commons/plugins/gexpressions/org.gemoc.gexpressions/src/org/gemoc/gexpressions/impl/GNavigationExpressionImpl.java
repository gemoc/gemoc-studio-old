/**
 */
package org.gemoc.gexpressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.gexpressions.GExpression;
import org.gemoc.gexpressions.GNavigationExpression;
import org.gemoc.gexpressions.GexpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GNavigation Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.gexpressions.impl.GNavigationExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.gemoc.gexpressions.impl.GNavigationExpressionImpl#getReferencedEObject <em>Referenced EObject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GNavigationExpressionImpl extends GExpressionImpl implements GNavigationExpression {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected GExpression body;

	/**
	 * The cached value of the '{@link #getReferencedEObject() <em>Referenced EObject</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedEObject()
	 * @generated
	 * @ordered
	 */
	protected EObject referencedEObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GNavigationExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GexpressionsPackage.Literals.GNAVIGATION_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GExpression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(GExpression newBody, NotificationChain msgs) {
		GExpression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(GExpression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getReferencedEObject() {
		if (referencedEObject != null && referencedEObject.eIsProxy()) {
			InternalEObject oldReferencedEObject = (InternalEObject)referencedEObject;
			referencedEObject = eResolveProxy(oldReferencedEObject);
			if (referencedEObject != oldReferencedEObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT, oldReferencedEObject, referencedEObject));
			}
		}
		return referencedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetReferencedEObject() {
		return referencedEObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedEObject(EObject newReferencedEObject) {
		EObject oldReferencedEObject = referencedEObject;
		referencedEObject = newReferencedEObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT, oldReferencedEObject, referencedEObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY:
				return basicSetBody(null, msgs);
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
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY:
				return getBody();
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT:
				if (resolve) return getReferencedEObject();
				return basicGetReferencedEObject();
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
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY:
				setBody((GExpression)newValue);
				return;
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT:
				setReferencedEObject((EObject)newValue);
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
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY:
				setBody((GExpression)null);
				return;
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT:
				setReferencedEObject((EObject)null);
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
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__BODY:
				return body != null;
			case GexpressionsPackage.GNAVIGATION_EXPRESSION__REFERENCED_EOBJECT:
				return referencedEObject != null;
		}
		return super.eIsSet(featureID);
	}

} //GNavigationExpressionImpl
