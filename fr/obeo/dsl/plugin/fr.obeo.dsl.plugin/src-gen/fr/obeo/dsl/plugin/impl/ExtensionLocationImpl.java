/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.ExtensionLocation;
import fr.obeo.dsl.plugin.PluginPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionLocationImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionLocationImpl#getOwnedBundles <em>Owned Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionLocationImpl#getOwnedGroups <em>Owned Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionLocationImpl extends CDOObjectImpl implements ExtensionLocation {
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
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ExtensionLocationImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PluginPackage.Literals.EXTENSION_LOCATION;
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
    public String getName() {
		return (String)eDynamicGet(PluginPackage.EXTENSION_LOCATION__NAME, PluginPackage.Literals.EXTENSION_LOCATION__NAME, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setName(String newName) {
		eDynamicSet(PluginPackage.EXTENSION_LOCATION__NAME, PluginPackage.Literals.EXTENSION_LOCATION__NAME, newName);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Bundle> getOwnedBundles() {
		return (EList<Bundle>)eDynamicGet(PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES, PluginPackage.Literals.EXTENSION_LOCATION__OWNED_BUNDLES, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Component> getOwnedGroups() {
		return (EList<Component>)eDynamicGet(PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS, PluginPackage.Literals.EXTENSION_LOCATION__OWNED_GROUPS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES:
				return ((InternalEList<?>)getOwnedBundles()).basicRemove(otherEnd, msgs);
			case PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS:
				return ((InternalEList<?>)getOwnedGroups()).basicRemove(otherEnd, msgs);
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
			case PluginPackage.EXTENSION_LOCATION__NAME:
				return getName();
			case PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES:
				return getOwnedBundles();
			case PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS:
				return getOwnedGroups();
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
			case PluginPackage.EXTENSION_LOCATION__NAME:
				setName((String)newValue);
				return;
			case PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES:
				getOwnedBundles().clear();
				getOwnedBundles().addAll((Collection<? extends Bundle>)newValue);
				return;
			case PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS:
				getOwnedGroups().clear();
				getOwnedGroups().addAll((Collection<? extends Component>)newValue);
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
			case PluginPackage.EXTENSION_LOCATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES:
				getOwnedBundles().clear();
				return;
			case PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS:
				getOwnedGroups().clear();
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
			case PluginPackage.EXTENSION_LOCATION__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case PluginPackage.EXTENSION_LOCATION__OWNED_BUNDLES:
				return !getOwnedBundles().isEmpty();
			case PluginPackage.EXTENSION_LOCATION__OWNED_GROUPS:
				return !getOwnedGroups().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExtensionLocationImpl
