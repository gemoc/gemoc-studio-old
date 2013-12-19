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
package org.gemoc.mocc.cometaccsl.model.cometa.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.gemoc.mocc.cometaccsl.model.cometa.CometaPackage;
import org.gemoc.mocc.cometaccsl.model.cometa.CometaSystemSpecification;

import org.gemoc.mocc.cometaccsl.model.cometa.cometadatatype.DataTypeLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometastructure.StructureLibrary;

import org.gemoc.mocc.cometaccsl.model.cometa.cometatime.TimeLibrary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl#getDataLib <em>Data Lib</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl#getStructureLib <em>Structure Lib</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.impl.CometaSystemSpecificationImpl#getTimeLib <em>Time Lib</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CometaSystemSpecificationImpl extends MoCSystemSpecificationImpl implements CometaSystemSpecification {
	/**
	 * The cached value of the '{@link #getDataLib() <em>Data Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataLib()
	 * @generated
	 * @ordered
	 */
	protected DataTypeLibrary dataLib;

	/**
	 * The cached value of the '{@link #getStructureLib() <em>Structure Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructureLib()
	 * @generated
	 * @ordered
	 */
	protected StructureLibrary structureLib;

	/**
	 * The cached value of the '{@link #getTimeLib() <em>Time Lib</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeLib()
	 * @generated
	 * @ordered
	 */
	protected TimeLibrary timeLib;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CometaSystemSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CometaPackage.Literals.COMETA_SYSTEM_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeLibrary getDataLib() {
		return dataLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataLib(DataTypeLibrary newDataLib, NotificationChain msgs) {
		DataTypeLibrary oldDataLib = dataLib;
		dataLib = newDataLib;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB, oldDataLib, newDataLib);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataLib(DataTypeLibrary newDataLib) {
		if (newDataLib != dataLib) {
			NotificationChain msgs = null;
			if (dataLib != null)
				msgs = ((InternalEObject)dataLib).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB, null, msgs);
			if (newDataLib != null)
				msgs = ((InternalEObject)newDataLib).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB, null, msgs);
			msgs = basicSetDataLib(newDataLib, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB, newDataLib, newDataLib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureLibrary getStructureLib() {
		return structureLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructureLib(StructureLibrary newStructureLib, NotificationChain msgs) {
		StructureLibrary oldStructureLib = structureLib;
		structureLib = newStructureLib;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB, oldStructureLib, newStructureLib);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructureLib(StructureLibrary newStructureLib) {
		if (newStructureLib != structureLib) {
			NotificationChain msgs = null;
			if (structureLib != null)
				msgs = ((InternalEObject)structureLib).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB, null, msgs);
			if (newStructureLib != null)
				msgs = ((InternalEObject)newStructureLib).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB, null, msgs);
			msgs = basicSetStructureLib(newStructureLib, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB, newStructureLib, newStructureLib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeLibrary getTimeLib() {
		return timeLib;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeLib(TimeLibrary newTimeLib, NotificationChain msgs) {
		TimeLibrary oldTimeLib = timeLib;
		timeLib = newTimeLib;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB, oldTimeLib, newTimeLib);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeLib(TimeLibrary newTimeLib) {
		if (newTimeLib != timeLib) {
			NotificationChain msgs = null;
			if (timeLib != null)
				msgs = ((InternalEObject)timeLib).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB, null, msgs);
			if (newTimeLib != null)
				msgs = ((InternalEObject)newTimeLib).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB, null, msgs);
			msgs = basicSetTimeLib(newTimeLib, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB, newTimeLib, newTimeLib));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB:
				return basicSetDataLib(null, msgs);
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB:
				return basicSetStructureLib(null, msgs);
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB:
				return basicSetTimeLib(null, msgs);
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
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB:
				return getDataLib();
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB:
				return getStructureLib();
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB:
				return getTimeLib();
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
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB:
				setDataLib((DataTypeLibrary)newValue);
				return;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB:
				setStructureLib((StructureLibrary)newValue);
				return;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB:
				setTimeLib((TimeLibrary)newValue);
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
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB:
				setDataLib((DataTypeLibrary)null);
				return;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB:
				setStructureLib((StructureLibrary)null);
				return;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB:
				setTimeLib((TimeLibrary)null);
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
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__DATA_LIB:
				return dataLib != null;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__STRUCTURE_LIB:
				return structureLib != null;
			case CometaPackage.COMETA_SYSTEM_SPECIFICATION__TIME_LIB:
				return timeLib != null;
		}
		return super.eIsSet(featureID);
	}

} //CometaSystemSpecificationImpl
