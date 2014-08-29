/**
 *  Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 *  This software and the attached documentation are the exclusive ownership
 *  of its authors and was conceded to the profit of Obeo SARL.
 *  This software and the attached documentation are protected under the rights
 *  of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 *  By installing this software, you acknowledge being aware of this rights and
 *  accept them, and as a consequence you must:
 *  - be in possession of a valid license of use conceded by Obeo only.
 *  - agree that you have read, understood, and will comply with the license terms and conditions.
 *  - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 *  or the authors of this software
 * 
 *  Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 * 
 * 
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context Variable</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.impl.ContextVariableImpl#getVariableValue <em>Variable Value</em>}</li>
 * <li>{@link fr.obeo.dsl.process.impl.ContextVariableImpl#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ContextVariableImpl extends EObjectImpl implements ContextVariable {
	/**
	 * The default value of the '{@link #getVariableValue() <em>Variable Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariableValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VARIABLE_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableValue() <em>Variable Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariableValue()
	 * @generated
	 * @ordered
	 */
	protected Object variableValue = VARIABLE_VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected ProcessVariable definition;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ContextVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.CONTEXT_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getVariableValue() {
		return variableValue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setVariableValue(Object newVariableValue) {
		Object oldVariableValue = variableValue;
		variableValue = newVariableValue;
		// if (eNotificationRequired())
		if (((BasicNotifierImpl)this).eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE, oldVariableValue, variableValue));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessVariable getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (ProcessVariable)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.CONTEXT_VARIABLE__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessVariable basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefinition(ProcessVariable newDefinition) {
		ProcessVariable oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ProcessPackage.CONTEXT_VARIABLE__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE:
				return getVariableValue();
			case ProcessPackage.CONTEXT_VARIABLE__DEFINITION:
				if (resolve)
					return getDefinition();
				return basicGetDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE:
				setVariableValue(newValue);
				return;
			case ProcessPackage.CONTEXT_VARIABLE__DEFINITION:
				setDefinition((ProcessVariable)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE:
				setVariableValue(VARIABLE_VALUE_EDEFAULT);
				return;
			case ProcessPackage.CONTEXT_VARIABLE__DEFINITION:
				setDefinition((ProcessVariable)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProcessPackage.CONTEXT_VARIABLE__VARIABLE_VALUE:
				return VARIABLE_VALUE_EDEFAULT == null ? variableValue != null : !VARIABLE_VALUE_EDEFAULT
						.equals(variableValue);
			case ProcessPackage.CONTEXT_VARIABLE__DEFINITION:
				return definition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (variableValue: ");
		result.append(variableValue);
		result.append(')');
		return result.toString();
	}

} // ContextVariableImpl
