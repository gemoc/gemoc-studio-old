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
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.Port#getKind <em>Kind</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Port#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Port#getDelegation <em>Delegation</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Port#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Port#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getPort()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Port extends CDOObject {
    /**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.obeo.dsl.plugin.PortKind}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Kind</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see fr.obeo.dsl.plugin.PortKind
	 * @see #setKind(PortKind)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPort_Kind()
	 * @model
	 * @generated
	 */
    PortKind getKind();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Port#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see fr.obeo.dsl.plugin.PortKind
	 * @see #getKind()
	 * @generated
	 */
    void setKind(PortKind value);

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
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPort_Name()
	 * @model
	 * @generated
	 */
    String getName();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Port#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
    void setName(String value);

    /**
	 * Returns the value of the '<em><b>Delegation</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Port}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delegation</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegation</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPort_Delegation()
	 * @model
	 * @generated
	 */
    EList<Port> getDelegation();

    /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPort_Description()
	 * @model
	 * @generated
	 */
    String getDescription();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.Port#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
    void setDescription(String value);

    /**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Link}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPort_Links()
	 * @model containment="true"
	 * @generated
	 */
    EList<Link> getLinks();

} // Port
