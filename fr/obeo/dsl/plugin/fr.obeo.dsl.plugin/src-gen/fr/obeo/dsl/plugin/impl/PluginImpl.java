/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import fr.obeo.dsl.plugin.ExtensionPoint;
import fr.obeo.dsl.plugin.Plugin;
import fr.obeo.dsl.plugin.PluginPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PluginImpl#getRequire <em>Require</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PluginImpl#getOwnedExtensionPoints <em>Owned Extension Points</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PluginImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.PluginImpl#getExportedPackages <em>Exported Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PluginImpl extends BundleImpl implements Plugin {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PluginImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PluginPackage.Literals.PLUGIN;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Plugin> getRequire() {
		return (EList<Plugin>)eDynamicGet(PluginPackage.PLUGIN__REQUIRE, PluginPackage.Literals.PLUGIN__REQUIRE, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<ExtensionPoint> getOwnedExtensionPoints() {
		return (EList<ExtensionPoint>)eDynamicGet(PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS, PluginPackage.Literals.PLUGIN__OWNED_EXTENSION_POINTS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<ExtensionPoint> getExtensions() {
		return (EList<ExtensionPoint>)eDynamicGet(PluginPackage.PLUGIN__EXTENSIONS, PluginPackage.Literals.PLUGIN__EXTENSIONS, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<fr.obeo.dsl.plugin.Package> getExportedPackages() {
		return (EList<fr.obeo.dsl.plugin.Package>)eDynamicGet(PluginPackage.PLUGIN__EXPORTED_PACKAGES, PluginPackage.Literals.PLUGIN__EXPORTED_PACKAGES, true, true);
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
			case PluginPackage.PLUGIN__EXTENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtensions()).basicAdd(otherEnd, msgs);
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
			case PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS:
				return ((InternalEList<?>)getOwnedExtensionPoints()).basicRemove(otherEnd, msgs);
			case PluginPackage.PLUGIN__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case PluginPackage.PLUGIN__EXPORTED_PACKAGES:
				return ((InternalEList<?>)getExportedPackages()).basicRemove(otherEnd, msgs);
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
			case PluginPackage.PLUGIN__REQUIRE:
				return getRequire();
			case PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS:
				return getOwnedExtensionPoints();
			case PluginPackage.PLUGIN__EXTENSIONS:
				return getExtensions();
			case PluginPackage.PLUGIN__EXPORTED_PACKAGES:
				return getExportedPackages();
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
			case PluginPackage.PLUGIN__REQUIRE:
				getRequire().clear();
				getRequire().addAll((Collection<? extends Plugin>)newValue);
				return;
			case PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS:
				getOwnedExtensionPoints().clear();
				getOwnedExtensionPoints().addAll((Collection<? extends ExtensionPoint>)newValue);
				return;
			case PluginPackage.PLUGIN__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends ExtensionPoint>)newValue);
				return;
			case PluginPackage.PLUGIN__EXPORTED_PACKAGES:
				getExportedPackages().clear();
				getExportedPackages().addAll((Collection<? extends fr.obeo.dsl.plugin.Package>)newValue);
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
			case PluginPackage.PLUGIN__REQUIRE:
				getRequire().clear();
				return;
			case PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS:
				getOwnedExtensionPoints().clear();
				return;
			case PluginPackage.PLUGIN__EXTENSIONS:
				getExtensions().clear();
				return;
			case PluginPackage.PLUGIN__EXPORTED_PACKAGES:
				getExportedPackages().clear();
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
			case PluginPackage.PLUGIN__REQUIRE:
				return !getRequire().isEmpty();
			case PluginPackage.PLUGIN__OWNED_EXTENSION_POINTS:
				return !getOwnedExtensionPoints().isEmpty();
			case PluginPackage.PLUGIN__EXTENSIONS:
				return !getExtensions().isEmpty();
			case PluginPackage.PLUGIN__EXPORTED_PACKAGES:
				return !getExportedPackages().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PluginImpl
