/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.PluginPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl#getOwnedBundles <em>Owned Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl#getRootFeature <em>Root Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PhysicalArchitectureImpl extends CDOObjectImpl implements PhysicalArchitecture {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PluginPackage.Literals.PHYSICAL_ARCHITECTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Bundle> getOwnedBundles() {
		return (EList<Bundle>)eDynamicGet(PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES, PluginPackage.Literals.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getRootFeature() {
		return (Component)eDynamicGet(PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE, PluginPackage.Literals.PHYSICAL_ARCHITECTURE__ROOT_FEATURE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootFeature(Component newRootFeature, NotificationChain msgs) {
		msgs = eDynamicInverseAdd((InternalEObject)newRootFeature, PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootFeature(Component newRootFeature) {
		eDynamicSet(PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE, PluginPackage.Literals.PHYSICAL_ARCHITECTURE__ROOT_FEATURE, newRootFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES:
				return ((InternalEList<?>)getOwnedBundles()).basicRemove(otherEnd, msgs);
			case PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE:
				return basicSetRootFeature(null, msgs);
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
			case PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES:
				return getOwnedBundles();
			case PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE:
				return getRootFeature();
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
			case PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES:
				getOwnedBundles().clear();
				getOwnedBundles().addAll((Collection<? extends Bundle>)newValue);
				return;
			case PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE:
				setRootFeature((Component)newValue);
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
			case PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES:
				getOwnedBundles().clear();
				return;
			case PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE:
				setRootFeature((Component)null);
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
			case PluginPackage.PHYSICAL_ARCHITECTURE__OWNED_BUNDLES:
				return !getOwnedBundles().isEmpty();
			case PluginPackage.PHYSICAL_ARCHITECTURE__ROOT_FEATURE:
				return getRootFeature() != null;
		}
		return super.eIsSet(featureID);
	}

} //PhysicalArchitectureImpl
