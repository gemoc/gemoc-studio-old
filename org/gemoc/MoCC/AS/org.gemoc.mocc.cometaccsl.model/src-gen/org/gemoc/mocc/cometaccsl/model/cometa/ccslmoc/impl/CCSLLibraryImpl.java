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
package org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Type;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ClockExpressionAndRelationPackage;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.ExpressionLibrary;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Library;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.RelationLibrary;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.ImportStatement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.NamedElement;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.TimeModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CCSLLibrary;
import org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.CcslmocPackage;

import org.gemoc.mocc.cometaccsl.model.cometa.impl.MoCLibraryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CCSL Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl#getExpressionLibraries <em>Expression Libraries</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl#getRelationLibraries <em>Relation Libraries</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl#getPredefinedTypes <em>Predefined Types</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometaccsl.model.cometa.ccslmoc.impl.CCSLLibraryImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CCSLLibraryImpl extends MoCLibraryImpl implements CCSLLibrary {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The cached value of the '{@link #getExpressionLibraries() <em>Expression Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<ExpressionLibrary> expressionLibraries;

	/**
	 * The cached value of the '{@link #getRelationLibraries() <em>Relation Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationLibrary> relationLibraries;

	/**
	 * The cached value of the '{@link #getPredefinedTypes() <em>Predefined Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredefinedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> predefinedTypes;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportStatement> imports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CCSLLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CcslmocPackage.Literals.CCSL_LIBRARY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CcslmocPackage.CCSL_LIBRARY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExpressionLibrary> getExpressionLibraries() {
		if (expressionLibraries == null) {
			expressionLibraries = new EObjectContainmentEList<ExpressionLibrary>(ExpressionLibrary.class, this, CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES);
		}
		return expressionLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelationLibrary> getRelationLibraries() {
		if (relationLibraries == null) {
			relationLibraries = new EObjectContainmentEList<RelationLibrary>(RelationLibrary.class, this, CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES);
		}
		return relationLibraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getPredefinedTypes() {
		if (predefinedTypes == null) {
			predefinedTypes = new EObjectContainmentEList<Type>(Type.class, this, CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES);
		}
		return predefinedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportStatement> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportStatement>(ImportStatement.class, this, CcslmocPackage.CCSL_LIBRARY__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
				return ((InternalEList<?>)getExpressionLibraries()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
				return ((InternalEList<?>)getRelationLibraries()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
				return ((InternalEList<?>)getPredefinedTypes()).basicRemove(otherEnd, msgs);
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
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
			case CcslmocPackage.CCSL_LIBRARY__NAME:
				return getName();
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
				return getExpressionLibraries();
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
				return getRelationLibraries();
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
				return getPredefinedTypes();
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
				return getImports();
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
			case CcslmocPackage.CCSL_LIBRARY__NAME:
				setName((String)newValue);
				return;
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
				getExpressionLibraries().clear();
				getExpressionLibraries().addAll((Collection<? extends ExpressionLibrary>)newValue);
				return;
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
				getRelationLibraries().clear();
				getRelationLibraries().addAll((Collection<? extends RelationLibrary>)newValue);
				return;
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
				getPredefinedTypes().clear();
				getPredefinedTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ImportStatement>)newValue);
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
			case CcslmocPackage.CCSL_LIBRARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
				getExpressionLibraries().clear();
				return;
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
				getRelationLibraries().clear();
				return;
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
				getPredefinedTypes().clear();
				return;
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
				getImports().clear();
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
			case CcslmocPackage.CCSL_LIBRARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES:
				return expressionLibraries != null && !expressionLibraries.isEmpty();
			case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES:
				return relationLibraries != null && !relationLibraries.isEmpty();
			case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES:
				return predefinedTypes != null && !predefinedTypes.isEmpty();
			case CcslmocPackage.CCSL_LIBRARY__IMPORTS:
				return imports != null && !imports.isEmpty();
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
				case CcslmocPackage.CCSL_LIBRARY__NAME: return TimeModelPackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == Library.class) {
			switch (derivedFeatureID) {
				case CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES: return ClockExpressionAndRelationPackage.LIBRARY__EXPRESSION_LIBRARIES;
				case CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES: return ClockExpressionAndRelationPackage.LIBRARY__RELATION_LIBRARIES;
				case CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES: return ClockExpressionAndRelationPackage.LIBRARY__PREDEFINED_TYPES;
				case CcslmocPackage.CCSL_LIBRARY__IMPORTS: return ClockExpressionAndRelationPackage.LIBRARY__IMPORTS;
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
				case TimeModelPackage.NAMED_ELEMENT__NAME: return CcslmocPackage.CCSL_LIBRARY__NAME;
				default: return -1;
			}
		}
		if (baseClass == Library.class) {
			switch (baseFeatureID) {
				case ClockExpressionAndRelationPackage.LIBRARY__EXPRESSION_LIBRARIES: return CcslmocPackage.CCSL_LIBRARY__EXPRESSION_LIBRARIES;
				case ClockExpressionAndRelationPackage.LIBRARY__RELATION_LIBRARIES: return CcslmocPackage.CCSL_LIBRARY__RELATION_LIBRARIES;
				case ClockExpressionAndRelationPackage.LIBRARY__PREDEFINED_TYPES: return CcslmocPackage.CCSL_LIBRARY__PREDEFINED_TYPES;
				case ClockExpressionAndRelationPackage.LIBRARY__IMPORTS: return CcslmocPackage.CCSL_LIBRARY__IMPORTS;
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
		result.append(')');
		return result.toString();
	}

} //CCSLLibraryImpl
