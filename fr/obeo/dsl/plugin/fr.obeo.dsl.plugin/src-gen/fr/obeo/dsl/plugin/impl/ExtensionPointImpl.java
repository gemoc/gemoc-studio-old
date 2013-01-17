/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import fr.obeo.dsl.plugin.ExtensionPoint;
import fr.obeo.dsl.plugin.Plugin;
import fr.obeo.dsl.plugin.PluginPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionPointImpl#getId <em>Id</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionPointImpl#getXsd <em>Xsd</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.impl.ExtensionPointImpl#getExtendingPlugins <em>Extending Plugins</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionPointImpl extends CDOObjectImpl implements ExtensionPoint {
    /**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
    protected static final String ID_EDEFAULT = null;

    /**
	 * The default value of the '{@link #getXsd() <em>Xsd</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getXsd()
	 * @generated
	 * @ordered
	 */
    protected static final String XSD_EDEFAULT = null;

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ExtensionPointImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return PluginPackage.Literals.EXTENSION_POINT;
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
    public String getId() {
		return (String)eDynamicGet(PluginPackage.EXTENSION_POINT__ID, PluginPackage.Literals.EXTENSION_POINT__ID, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setId(String newId) {
		eDynamicSet(PluginPackage.EXTENSION_POINT__ID, PluginPackage.Literals.EXTENSION_POINT__ID, newId);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String getXsd() {
		return (String)eDynamicGet(PluginPackage.EXTENSION_POINT__XSD, PluginPackage.Literals.EXTENSION_POINT__XSD, true, true);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void setXsd(String newXsd) {
		eDynamicSet(PluginPackage.EXTENSION_POINT__XSD, PluginPackage.Literals.EXTENSION_POINT__XSD, newXsd);
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
				public EList<Plugin> getExtendingPlugins() {
		return (EList<Plugin>)eDynamicGet(PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS, PluginPackage.Literals.EXTENSION_POINT__EXTENDING_PLUGINS, true, true);
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
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtendingPlugins()).basicAdd(otherEnd, msgs);
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
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				return ((InternalEList<?>)getExtendingPlugins()).basicRemove(otherEnd, msgs);
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
			case PluginPackage.EXTENSION_POINT__ID:
				return getId();
			case PluginPackage.EXTENSION_POINT__XSD:
				return getXsd();
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				return getExtendingPlugins();
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
			case PluginPackage.EXTENSION_POINT__ID:
				setId((String)newValue);
				return;
			case PluginPackage.EXTENSION_POINT__XSD:
				setXsd((String)newValue);
				return;
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				getExtendingPlugins().clear();
				getExtendingPlugins().addAll((Collection<? extends Plugin>)newValue);
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
			case PluginPackage.EXTENSION_POINT__ID:
				setId(ID_EDEFAULT);
				return;
			case PluginPackage.EXTENSION_POINT__XSD:
				setXsd(XSD_EDEFAULT);
				return;
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				getExtendingPlugins().clear();
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
			case PluginPackage.EXTENSION_POINT__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case PluginPackage.EXTENSION_POINT__XSD:
				return XSD_EDEFAULT == null ? getXsd() != null : !XSD_EDEFAULT.equals(getXsd());
			case PluginPackage.EXTENSION_POINT__EXTENDING_PLUGINS:
				return !getExtendingPlugins().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExtensionPointImpl
