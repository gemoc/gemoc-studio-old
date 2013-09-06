/**
 */
package gee_configuration.impl;

import gee_configuration.DomainSpecificEditor;
import gee_configuration.DomainSpecificMetamodel;
import gee_configuration.Gee_configurationPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Specific Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gee_configuration.impl.DomainSpecificMetamodelImpl#getEditors <em>Editors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainSpecificMetamodelImpl extends LocalResourceImpl implements DomainSpecificMetamodel {
	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainSpecificEditor> editors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DomainSpecificMetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Gee_configurationPackage.Literals.DOMAIN_SPECIFIC_METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainSpecificEditor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<DomainSpecificEditor>(DomainSpecificEditor.class, this, Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL__EDITORS:
				return getEditors();
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
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends DomainSpecificEditor>)newValue);
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
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL__EDITORS:
				getEditors().clear();
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
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL__EDITORS:
				return editors != null && !editors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DomainSpecificMetamodelImpl
