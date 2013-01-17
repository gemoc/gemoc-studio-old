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
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.Root#getComponents <em>Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Root#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getRoot()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Root extends CDOObject {
    /**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Component}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getRoot_Components()
	 * @model containment="true"
	 * @generated
	 */
    EList<Component> getComponents();

    /**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(TargetPlatform)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getRoot_Target()
	 * @model containment="true"
	 * @generated
	 */
    TargetPlatform getTarget();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Root#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
    void setTarget(TargetPlatform value);

} // Root
