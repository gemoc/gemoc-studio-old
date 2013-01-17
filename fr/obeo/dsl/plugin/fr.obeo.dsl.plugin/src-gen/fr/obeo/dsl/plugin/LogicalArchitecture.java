/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.LogicalArchitecture#getComponents <em>Components</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.LogicalArchitecture#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getLogicalArchitecture()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface LogicalArchitecture extends CDOObject {
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
	 * @see fr.obeo.dsl.plugin.PluginPackage#getLogicalArchitecture_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getLogicalArchitecture_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

} // LogicalArchitecture
