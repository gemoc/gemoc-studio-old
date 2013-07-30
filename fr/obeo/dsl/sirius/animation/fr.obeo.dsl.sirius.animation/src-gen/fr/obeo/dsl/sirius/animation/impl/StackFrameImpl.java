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
import fr.obeo.dsl.sirius.animation.StackFrame;
import fr.obeo.dsl.sirius.animation.StackFrameState;
import fr.obeo.dsl.sirius.animation.Variable;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getSubFrames <em>Sub Frames</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getState <em>State</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getData <em>Data</em>}</li>
 *   <li>{@link fr.obeo.dsl.sirius.animation.impl.StackFrameImpl#getSourceElement <em>Source Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StackFrameImpl extends EObjectImpl implements StackFrame {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

	/**
	 * The cached value of the '{@link #getSubFrames() <em>Sub Frames</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubFrames()
	 * @generated
	 * @ordered
	 */
	protected EList<StackFrame> subFrames;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final StackFrameState STATE_EDEFAULT = StackFrameState.STEPING_RETURN;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected StackFrameState state = STATE_EDEFAULT;

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
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StackFrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnimationPackage.Literals.STACK_FRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<Variable>(Variable.class, this, AnimationPackage.STACK_FRAME__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StackFrame> getSubFrames() {
		if (subFrames == null) {
			subFrames = new EObjectContainmentEList<StackFrame>(StackFrame.class, this, AnimationPackage.STACK_FRAME__SUB_FRAMES);
		}
		return subFrames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackFrameState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(StackFrameState newState) {
		StackFrameState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.obeo.dsl.sirius.animation.Thread getParent() {
		if (eContainerFeatureID() != AnimationPackage.STACK_FRAME__PARENT) return null;
		return (fr.obeo.dsl.sirius.animation.Thread)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(fr.obeo.dsl.sirius.animation.Thread newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, AnimationPackage.STACK_FRAME__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(fr.obeo.dsl.sirius.animation.Thread newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != AnimationPackage.STACK_FRAME__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, AnimationPackage.THREAD__STACK_FRAMES, fr.obeo.dsl.sirius.animation.Thread.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__PARENT, newParent, newParent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__NAME, oldName, name));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__DATA, oldData, newData);
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
				msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnimationPackage.STACK_FRAME__DATA, null, msgs);
			if (newData != null)
				msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnimationPackage.STACK_FRAME__DATA, null, msgs);
			msgs = basicSetData(newData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__DATA, newData, newData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnimationPackage.STACK_FRAME__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(EObject newSourceElement) {
		EObject oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnimationPackage.STACK_FRAME__SOURCE_ELEMENT, oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnimationPackage.STACK_FRAME__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((fr.obeo.dsl.sirius.animation.Thread)otherEnd, msgs);
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
			case AnimationPackage.STACK_FRAME__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
				return ((InternalEList<?>)getSubFrames()).basicRemove(otherEnd, msgs);
			case AnimationPackage.STACK_FRAME__PARENT:
				return basicSetParent(null, msgs);
			case AnimationPackage.STACK_FRAME__DATA:
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
			case AnimationPackage.STACK_FRAME__PARENT:
				return eInternalContainer().eInverseRemove(this, AnimationPackage.THREAD__STACK_FRAMES, fr.obeo.dsl.sirius.animation.Thread.class, msgs);
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
			case AnimationPackage.STACK_FRAME__VARIABLES:
				return getVariables();
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
				return getSubFrames();
			case AnimationPackage.STACK_FRAME__STATE:
				return getState();
			case AnimationPackage.STACK_FRAME__PARENT:
				return getParent();
			case AnimationPackage.STACK_FRAME__NAME:
				return getName();
			case AnimationPackage.STACK_FRAME__DATA:
				return getData();
			case AnimationPackage.STACK_FRAME__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
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
			case AnimationPackage.STACK_FRAME__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
				getSubFrames().clear();
				getSubFrames().addAll((Collection<? extends StackFrame>)newValue);
				return;
			case AnimationPackage.STACK_FRAME__STATE:
				setState((StackFrameState)newValue);
				return;
			case AnimationPackage.STACK_FRAME__PARENT:
				setParent((fr.obeo.dsl.sirius.animation.Thread)newValue);
				return;
			case AnimationPackage.STACK_FRAME__NAME:
				setName((String)newValue);
				return;
			case AnimationPackage.STACK_FRAME__DATA:
				setData((EObject)newValue);
				return;
			case AnimationPackage.STACK_FRAME__SOURCE_ELEMENT:
				setSourceElement((EObject)newValue);
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
			case AnimationPackage.STACK_FRAME__VARIABLES:
				getVariables().clear();
				return;
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
				getSubFrames().clear();
				return;
			case AnimationPackage.STACK_FRAME__STATE:
				setState(STATE_EDEFAULT);
				return;
			case AnimationPackage.STACK_FRAME__PARENT:
				setParent((fr.obeo.dsl.sirius.animation.Thread)null);
				return;
			case AnimationPackage.STACK_FRAME__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AnimationPackage.STACK_FRAME__DATA:
				setData((EObject)null);
				return;
			case AnimationPackage.STACK_FRAME__SOURCE_ELEMENT:
				setSourceElement((EObject)null);
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
			case AnimationPackage.STACK_FRAME__VARIABLES:
				return variables != null && !variables.isEmpty();
			case AnimationPackage.STACK_FRAME__SUB_FRAMES:
				return subFrames != null && !subFrames.isEmpty();
			case AnimationPackage.STACK_FRAME__STATE:
				return state != STATE_EDEFAULT;
			case AnimationPackage.STACK_FRAME__PARENT:
				return getParent() != null;
			case AnimationPackage.STACK_FRAME__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AnimationPackage.STACK_FRAME__DATA:
				return data != null;
			case AnimationPackage.STACK_FRAME__SOURCE_ELEMENT:
				return sourceElement != null;
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
		result.append(" (state: ");
		result.append(state);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //StackFrameImpl
