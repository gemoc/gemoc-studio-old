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
package org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl;

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

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.CometastructurePackage;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCComponent;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCConnector;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.MoCPort;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Part;
import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getParts <em>Parts</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getConnectorInstances <em>Connector Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getComponentInstances <em>Component Instances</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.impl.StructureContainerImpl#getPortInstances <em>Port Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureContainerImpl extends MinimalEObjectImpl.Container implements StructureContainer {
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
	 * The cached value of the '{@link #getParts() <em>Parts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParts()
	 * @generated
	 * @ordered
	 */
	protected EList<Part> parts;

	/**
	 * The cached value of the '{@link #getConnectorInstances() <em>Connector Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectorInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCConnector> connectorInstances;

	/**
	 * The cached value of the '{@link #getComponentInstances() <em>Component Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCComponent> componentInstances;

	/**
	 * The cached value of the '{@link #getPortInstances() <em>Port Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<MoCPort> portInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometastructurePackage.Literals.STRUCTURE_CONTAINER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_CONTAINER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_CONTAINER__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CometastructurePackage.STRUCTURE_CONTAINER__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Part> getParts() {
		if (parts == null) {
			parts = new EObjectContainmentWithInverseEList<Part>(Part.class, this, CometastructurePackage.STRUCTURE_CONTAINER__PARTS, CometastructurePackage.PART__CONTAINER);
		}
		return parts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCConnector> getConnectorInstances() {
		if (connectorInstances == null) {
			connectorInstances = new EObjectContainmentEList<MoCConnector>(MoCConnector.class, this, CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES);
		}
		return connectorInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCComponent> getComponentInstances() {
		if (componentInstances == null) {
			componentInstances = new EObjectContainmentEList<MoCComponent>(MoCComponent.class, this, CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES);
		}
		return componentInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MoCPort> getPortInstances() {
		if (portInstances == null) {
			portInstances = new EObjectContainmentEList<MoCPort>(MoCPort.class, this, CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES);
		}
		return portInstances;
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
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParts()).basicAdd(otherEnd, msgs);
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
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				return ((InternalEList<?>)getParts()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES:
				return ((InternalEList<?>)getConnectorInstances()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES:
				return ((InternalEList<?>)getComponentInstances()).basicRemove(otherEnd, msgs);
			case CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES:
				return ((InternalEList<?>)getPortInstances()).basicRemove(otherEnd, msgs);
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
			case CometastructurePackage.STRUCTURE_CONTAINER__NAME:
				return getName();
			case CometastructurePackage.STRUCTURE_CONTAINER__VERSION:
				return getVersion();
			case CometastructurePackage.STRUCTURE_CONTAINER__DEFINITION:
				return getDefinition();
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				return getParts();
			case CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES:
				return getConnectorInstances();
			case CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES:
				return getComponentInstances();
			case CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES:
				return getPortInstances();
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
			case CometastructurePackage.STRUCTURE_CONTAINER__NAME:
				setName((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__VERSION:
				setVersion((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__DEFINITION:
				setDefinition((String)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				getParts().clear();
				getParts().addAll((Collection<? extends Part>)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES:
				getConnectorInstances().clear();
				getConnectorInstances().addAll((Collection<? extends MoCConnector>)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES:
				getComponentInstances().clear();
				getComponentInstances().addAll((Collection<? extends MoCComponent>)newValue);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES:
				getPortInstances().clear();
				getPortInstances().addAll((Collection<? extends MoCPort>)newValue);
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
			case CometastructurePackage.STRUCTURE_CONTAINER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__DEFINITION:
				setDefinition(DEFINITION_EDEFAULT);
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				getParts().clear();
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES:
				getConnectorInstances().clear();
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES:
				getComponentInstances().clear();
				return;
			case CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES:
				getPortInstances().clear();
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
			case CometastructurePackage.STRUCTURE_CONTAINER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CometastructurePackage.STRUCTURE_CONTAINER__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case CometastructurePackage.STRUCTURE_CONTAINER__DEFINITION:
				return DEFINITION_EDEFAULT == null ? definition != null : !DEFINITION_EDEFAULT.equals(definition);
			case CometastructurePackage.STRUCTURE_CONTAINER__PARTS:
				return parts != null && !parts.isEmpty();
			case CometastructurePackage.STRUCTURE_CONTAINER__CONNECTOR_INSTANCES:
				return connectorInstances != null && !connectorInstances.isEmpty();
			case CometastructurePackage.STRUCTURE_CONTAINER__COMPONENT_INSTANCES:
				return componentInstances != null && !componentInstances.isEmpty();
			case CometastructurePackage.STRUCTURE_CONTAINER__PORT_INSTANCES:
				return portInstances != null && !portInstances.isEmpty();
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
		if (baseClass == org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container.class) {
			switch (derivedFeatureID) {
				case CometastructurePackage.STRUCTURE_CONTAINER__PARTS: return CometastructurePackage.CONTAINER__PARTS;
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
		if (baseClass == org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.Container.class) {
			switch (baseFeatureID) {
				case CometastructurePackage.CONTAINER__PARTS: return CometastructurePackage.STRUCTURE_CONTAINER__PARTS;
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

} //StructureContainerImpl
