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
 * A representation of the model object '<em><b>Extension Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionPoint#getId <em>Id</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionPoint#getXsd <em>Xsd</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.ExtensionPoint#getExtendingPlugins <em>Extending Plugins</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionPoint()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ExtensionPoint extends CDOObject {
    /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionPoint_Id()
	 * @model unique="false"
	 * @generated
	 */
    String getId();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.ExtensionPoint#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
    void setId(String value);

    /**
	 * Returns the value of the '<em><b>Xsd</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xsd</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Xsd</em>' attribute.
	 * @see #setXsd(String)
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionPoint_Xsd()
	 * @model
	 * @generated
	 */
    String getXsd();

    /**
	 * Sets the value of the '{@link fr.obeo.dsl.plugin.ExtensionPoint#getXsd <em>Xsd</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xsd</em>' attribute.
	 * @see #getXsd()
	 * @generated
	 */
    void setXsd(String value);

    /**
	 * Returns the value of the '<em><b>Extending Plugins</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Plugin}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.plugin.Plugin#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extending Plugins</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Extending Plugins</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getExtensionPoint_ExtendingPlugins()
	 * @see fr.obeo.dsl.plugin.Plugin#getExtensions
	 * @model opposite="extensions"
	 * @generated
	 */
    EList<Plugin> getExtendingPlugins();

} // ExtensionPoint
