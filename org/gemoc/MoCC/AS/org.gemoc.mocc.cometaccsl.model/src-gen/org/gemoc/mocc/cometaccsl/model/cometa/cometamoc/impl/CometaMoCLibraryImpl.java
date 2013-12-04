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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.NamedElement;

import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometaMoCLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.CometamocPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCDomain;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.MoCEvent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.Queue;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cometa Mo CLibrary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getMocDomains <em>Moc Domains</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getMocEvents <em>Moc Events</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometamoc.impl.CometaMoCLibraryImpl#getQueues <em>Queues</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CometaMoCLibraryImpl extends MoCLibraryImpl implements CometaMoCLibrary {
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
	 * The cached value of the '{@link #getMocDomains() <em>Moc Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCDomain> mocDomains;

	/**
	 * The cached value of the '{@link #getMocEvents() <em>Moc Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMocEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCEvent> mocEvents;

	/**
	 * The cached value of the '{@link #getQueues() <em>Queues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueues()
	 * @generated
	 * @ordered
	 */
	protected EList<Queue> queues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CometaMoCLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometamocPackage.Literals.COMETA_MO_CLIBRARY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.COMETA_MO_CLIBRARY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.COMETA_MO_CLIBRARY__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCDomain> getMocDomains() {
		if (mocDomains == null) {
			mocDomains = new EObjectContainmentEList<MoCDomain>(MoCDomain.class, this, CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS);
		}
		return mocDomains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCEvent> getMocEvents() {
		if (mocEvents == null) {
			mocEvents = new EObjectContainmentEList<MoCEvent>(MoCEvent.class, this, CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS);
		}
		return mocEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Queue> getQueues() {
		if (queues == null) {
			queues = new EObjectContainmentEList<Queue>(Queue.class, this, CometamocPackage.COMETA_MO_CLIBRARY__QUEUES);
		}
		return queues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS:
				return ((InternalEList<?>)getMocDomains()).basicRemove(otherEnd, msgs);
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS:
				return ((InternalEList<?>)getMocEvents()).basicRemove(otherEnd, msgs);
			case CometamocPackage.COMETA_MO_CLIBRARY__QUEUES:
				return ((InternalEList<?>)getQueues()).basicRemove(otherEnd, msgs);
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
			case CometamocPackage.COMETA_MO_CLIBRARY__NAME:
				return getName();
			case CometamocPackage.COMETA_MO_CLIBRARY__VERSION:
				return getVersion();
			case CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION:
				return getDefinition();
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS:
				return getMocDomains();
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS:
				return getMocEvents();
			case CometamocPackage.COMETA_MO_CLIBRARY__QUEUES:
				return getQueues();
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
			case CometamocPackage.COMETA_MO_CLIBRARY__NAME:
				setName((String)newValue);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__VERSION:
				setVersion((String)newValue);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS:
				getMocDomains().clear();
				getMocDomains().addAll((Collection<? extends MoCDomain>)newValue);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS:
				getMocEvents().clear();
				getMocEvents().addAll((Collection<? extends MoCEvent>)newValue);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__QUEUES:
				getQueues().clear();
				getQueues().addAll((Collection<? extends Queue>)newValue);
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
			case CometamocPackage.COMETA_MO_CLIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS:
				getMocDomains().clear();
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS:
				getMocEvents().clear();
				return;
			case CometamocPackage.COMETA_MO_CLIBRARY__QUEUES:
				getQueues().clear();
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
			case CometamocPackage.COMETA_MO_CLIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometamocPackage.COMETA_MO_CLIBRARY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_DOMAINS:
				return mocDomains != null && !mocDomains.isEmpty();
			case CometamocPackage.COMETA_MO_CLIBRARY__MOC_EVENTS:
				return mocEvents != null && !mocEvents.isEmpty();
			case CometamocPackage.COMETA_MO_CLIBRARY__QUEUES:
				return queues != null && !queues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case CometamocPackage.COMETA_MO_CLIBRARY__NAME: return CometaPackage.NAMED_ELEMENT__NAME;
				case CometamocPackage.COMETA_MO_CLIBRARY__VERSION: return CometaPackage.NAMED_ELEMENT__VERSION;
				case CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION: return CometaPackage.NAMED_ELEMENT__DEFINITION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case CometaPackage.NAMED_ELEMENT__NAME: return CometamocPackage.COMETA_MO_CLIBRARY__NAME;
				case CometaPackage.NAMED_ELEMENT__VERSION: return CometamocPackage.COMETA_MO_CLIBRARY__VERSION;
				case CometaPackage.NAMED_ELEMENT__DEFINITION: return CometamocPackage.COMETA_MO_CLIBRARY__DEFINITION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //CometaMoCLibraryImpl
