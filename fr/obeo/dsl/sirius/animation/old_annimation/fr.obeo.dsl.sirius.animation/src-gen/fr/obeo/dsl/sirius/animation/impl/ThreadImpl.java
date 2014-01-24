/**
 * 
 * Copyright  2013 Obeo. All Rights Reserved.
 * 
 *  This file is part of Obeo Designer.
 * This software and the attached documentation are the exclusive ownership of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1, L123-12)"
 * By installing this software, you acknowledge being aware of this rights and accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * Obeo is a  trademark owned by Obeo.
 * 
 */
package fr.obeo.dsl.sirius.animation.impl;

import fr.obeo.dsl.sirius.animation.AnimationPackage;
import fr.obeo.dsl.sirius.animation.AnimationTarget;
import fr.obeo.dsl.sirius.animation.StackFrame;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl#getStackFrames <em>Stack Frames</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl#getTopStackFrame <em>Top Stack Frame</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.ThreadImpl#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadImpl extends EObjectImpl implements fr.obeo.dsl.sirius.animation.Thread {
	/**
	 * The cached value of the '{@link #getStackFrames() <em>Stack Frames</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<StackFrame> stackFrames;

	/**
	 * The cached value of the '{@link #getTopStackFrame() <em>Top Stack Frame</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopStackFrame()
	 * @generated
	 * @ordered
	 */
	protected StackFrame topStackFrame;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EObject data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnimationPackage.Literals.THREAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StackFrame> getStackFrames() {
		if (stackFrames == null) {
			stackFrames = new EObjectContainmentWithInverseEList<StackFrame>(StackFrame.class, this, AnimationPackage.THREAD__STACK_FRAMES, AnimationPackage.STACK_FRAME__PARENT);
		}
		return stackFrames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrame getTopStackFrame() {
		if (topStackFrame != null && topStackFrame.eIsProxy()) {
			InternalEObject oldTopStackFrame = (InternalEObject)topStackFrame;
			topStackFrame = (StackFrame)eResolveProxy(oldTopStackFrame);
			if (topStackFrame != oldTopStackFrame) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnimationPackage.THREAD__TOP_STACK_FRAME, oldTopStackFrame, topStackFrame));
			}
		}
		return topStackFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrame basicGetTopStackFrame() {
		return topStackFrame;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopStackFrame(StackFrame newTopStackFrame) {
		StackFrame oldTopStackFrame = topStackFrame;
		topStackFrame = newTopStackFrame;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.THREAD__TOP_STACK_FRAME, oldTopStackFrame, topStackFrame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.THREAD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnimationTarget getParent() {
		if (eContainerFeatureID() != AnimationPackage.THREAD__PARENT) return null;
		return (AnimationTarget)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(AnimationTarget newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, AnimationPackage.THREAD__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(AnimationTarget newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != AnimationPackage.THREAD__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, AnimationPackage.ANIMATION_TARGET__THREADS, AnimationTarget.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.THREAD__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetData(EObject newData, NotificationChain msgs) {
		EObject oldData = data;
		data = newData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnimationPackage.THREAD__DATA, oldData, newData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(EObject newData) {
		if (newData != data) {
			NotificationChain msgs = null;
			if (data != null)
				msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnimationPackage.THREAD__DATA, null, msgs);
			if (newData != null)
				msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnimationPackage.THREAD__DATA, null, msgs);
			msgs = basicSetData(newData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.THREAD__DATA, newData, newData));
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getStackFrames()).basicAdd(otherEnd, msgs);
			case AnimationPackage.THREAD__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((AnimationTarget)otherEnd, msgs);
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				return ((InternalEList<?>)getStackFrames()).basicRemove(otherEnd, msgs);
			case AnimationPackage.THREAD__PARENT:
				return basicSetParent(null, msgs);
			case AnimationPackage.THREAD__DATA:
				return basicSetData(null, msgs);
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
			case AnimationPackage.THREAD__PARENT:
				return eInternalContainer().eInverseRemove(this, AnimationPackage.ANIMATION_TARGET__THREADS, AnimationTarget.class, msgs);
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				return getStackFrames();
			case AnimationPackage.THREAD__TOP_STACK_FRAME:
				if (resolve) return getTopStackFrame();
				return basicGetTopStackFrame();
			case AnimationPackage.THREAD__NAME:
				return getName();
			case AnimationPackage.THREAD__PARENT:
				return getParent();
			case AnimationPackage.THREAD__DATA:
				return getData();
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				getStackFrames().clear();
				getStackFrames().addAll((Collection<? extends StackFrame>)newValue);
				return;
			case AnimationPackage.THREAD__TOP_STACK_FRAME:
				setTopStackFrame((StackFrame)newValue);
				return;
			case AnimationPackage.THREAD__NAME:
				setName((String)newValue);
				return;
			case AnimationPackage.THREAD__PARENT:
				setParent((AnimationTarget)newValue);
				return;
			case AnimationPackage.THREAD__DATA:
				setData((EObject)newValue);
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				getStackFrames().clear();
				return;
			case AnimationPackage.THREAD__TOP_STACK_FRAME:
				setTopStackFrame((StackFrame)null);
				return;
			case AnimationPackage.THREAD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AnimationPackage.THREAD__PARENT:
				setParent((AnimationTarget)null);
				return;
			case AnimationPackage.THREAD__DATA:
				setData((EObject)null);
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
			case AnimationPackage.THREAD__STACK_FRAMES:
				return stackFrames != null && !stackFrames.isEmpty();
			case AnimationPackage.THREAD__TOP_STACK_FRAME:
				return topStackFrame != null;
			case AnimationPackage.THREAD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AnimationPackage.THREAD__PARENT:
				return getParent() != null;
			case AnimationPackage.THREAD__DATA:
				return data != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ThreadImpl
