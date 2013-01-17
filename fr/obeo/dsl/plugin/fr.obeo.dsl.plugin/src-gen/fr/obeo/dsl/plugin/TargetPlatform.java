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
 * A representation of the model object '<em><b>Target Platform</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.TargetPlatform#getOwnedBundles <em>Owned Bundles</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.TargetPlatform#getRootFeature <em>Root Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getTargetPlatform()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface TargetPlatform extends CDOObject {
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
	 * @see fr.obeo.dsl.plugin.PluginPackage#getTargetPlatform_OwnedBundles()
	 * @model containment="true" keys="name"
	 * @generated
	 */
    EList<Bundle> getOwnedBundles();

    /**
	 * Returns the value of the '<em><b>Root Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root Feature</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Feature</em>' containment reference.
	 * @see #setRootFeature(Component)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getTargetPlatform_RootFeature()
	 * @model containment="true"
	 * @generated
	 */
    Component getRootFeature();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.TargetPlatform#getRootFeature <em>Root Feature</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Feature</em>' containment reference.
	 * @see #getRootFeature()
	 * @generated
	 */
    void setRootFeature(Component value);

} // TargetPlatform
