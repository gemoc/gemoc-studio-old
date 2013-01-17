/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extension Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionLocation#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionLocation#getOwnedBundles <em>Owned Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionLocation#getOwnedGroups <em>Owned Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionLocation()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ExtensionLocation extends CDOObject {
    /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionLocation_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.ExtensionLocation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Owned Bundles</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Bundle}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Bundles</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Bundles</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionLocation_OwnedBundles()
	 * @model containment="true"
	 * @generated
	 */
    EList<Bundle> getOwnedBundles();

    /**
	 * Returns the value of the '<em><b>Owned Groups</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Groups</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Groups</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionLocation_OwnedGroups()
	 * @model containment="true"
	 * @generated
	 */
    EList<Component> getOwnedGroups();

} // ExtensionLocation
