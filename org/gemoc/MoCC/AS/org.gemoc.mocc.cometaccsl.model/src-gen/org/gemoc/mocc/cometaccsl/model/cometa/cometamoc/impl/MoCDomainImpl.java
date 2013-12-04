/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Behavior;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mo CDomain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl#getMocBehaviors <em>Moc Behaviors</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.MoCDomainImpl#getDomainTimeConstraints <em>Domain Time Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MoCDomainImpl extends MinimalEObjectImpl.Container implements MoCDomain {
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected String definition = DEFINITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMocBehaviors() <em>Moc Behaviors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocBehaviors()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> mocBehaviors;

	/**
	 * The cached value of the '{@link #getDomainTimeConstraints() <em>Domain Time Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainTimeConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<TimeConstraint> domainTimeConstraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MoCDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.MO_CDOMAIN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.MO_CDOMAIN__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.MO_CDOMAIN__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinition(String newDefinition) {
		String oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.MO_CDOMAIN__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Behavior> getMocBehaviors() {
		if (mocBehaviors == null) {
			mocBehaviors = new EObjectContainmentWithInverseEList<Behavior>(Behavior.class, this, CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS, CometamocPackage.BEHAVIOR__MOC_DOMAIN);
		}
		return mocBehaviors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TimeConstraint> getDomainTimeConstraints() {
		if (domainTimeConstraints == null) {
			domainTimeConstraints = new EObjectContainmentEList<TimeConstraint>(TimeConstraint.class, this, CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS);
		}
		return domainTimeConstraints;
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
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMocBehaviors()).basicAdd(otherEnd, msgs);
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
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				return ((InternalEList<?>)getMocBehaviors()).basicRemove(otherEnd, msgs);
			case CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS:
				return ((InternalEList<?>)getDomainTimeConstraints()).basicRemove(otherEnd, msgs);
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
			case CometamocPackage.MO_CDOMAIN__NAME:
				return getName();
			case CometamocPackage.MO_CDOMAIN__VERSION:
				return getVersion();
			case CometamocPackage.MO_CDOMAIN__DEFINITION:
				return getDefinition();
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				return getMocBehaviors();
			case CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS:
				return getDomainTimeConstraints();
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
			case CometamocPackage.MO_CDOMAIN__NAME:
				setName((String)newValue);
				return;
			case CometamocPackage.MO_CDOMAIN__VERSION:
				setVersion((String)newValue);
				return;
			case CometamocPackage.MO_CDOMAIN__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				getMocBehaviors().clear();
				getMocBehaviors().addAll((Collection<? extends Behavior>)newValue);
				return;
			case CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS:
				getDomainTimeConstraints().clear();
				getDomainTimeConstraints().addAll((Collection<? extends TimeConstraint>)newValue);
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
			case CometamocPackage.MO_CDOMAIN__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometamocPackage.MO_CDOMAIN__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometamocPackage.MO_CDOMAIN__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				getMocBehaviors().clear();
				return;
			case CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS:
				getDomainTimeConstraints().clear();
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
			case CometamocPackage.MO_CDOMAIN__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometamocPackage.MO_CDOMAIN__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometamocPackage.MO_CDOMAIN__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometamocPackage.MO_CDOMAIN__MOC_BEHAVIORS:
				return mocBehaviors != null && !mocBehaviors.isEmpty();
			case CometamocPackage.MO_CDOMAIN__DOMAIN_TIME_CONSTRAINTS:
				return domainTimeConstraints != null && !domainTimeConstraints.isEmpty();
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
		result.append(", version: ");
		result.append(version);
		result.append(", definition: ");
		result.append(definition);
		result.append(')');
		return result.toString();
	}

} //MoCDomainImpl
