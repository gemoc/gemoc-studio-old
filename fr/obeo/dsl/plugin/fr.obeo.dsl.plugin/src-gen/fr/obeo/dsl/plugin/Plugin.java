/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.obeo.dsl.plugin.Plugin#getRequire <em>Require</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Plugin#getOwnedExtensionPoints <em>Owned Extension Points</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Plugin#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link fr.obeo.dsl.plugin.Plugin#getExportedPackages <em>Exported Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.obeo.dsl.plugin.PluginPackage#getPlugin()
 * @model
 * @generated
 */
public interface Plugin extends Bundle {
    /**
	 * Returns the value of the '<em><b>Require</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Plugin}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Require</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Require</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPlugin_Require()
	 * @model ordered="false"
	 * @generated
	 */
    EList<Plugin> getRequire();

    /**
	 * Returns the value of the '<em><b>Owned Extension Points</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.ExtensionPoint}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Owned Extension Points</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Extension Points</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPlugin_OwnedExtensionPoints()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
    EList<ExtensionPoint> getOwnedExtensionPoints();

    /**
	 * Returns the value of the '<em><b>Extensions</b></em>' reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.ExtensionPoint}.
	 * It is bidirectional and its opposite is '{@link fr.obeo.dsl.plugin.ExtensionPoint#getExtendingPlugins <em>Extending Plugins</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extensions</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPlugin_Extensions()
	 * @see fr.obeo.dsl.plugin.ExtensionPoint#getExtendingPlugins
	 * @model opposite="extendingPlugins" ordered="false"
	 * @generated
	 */
    EList<ExtensionPoint> getExtensions();

    /**
	 * Returns the value of the '<em><b>Exported Packages</b></em>' containment reference list.
	 * The list contents are of type {@link fr.obeo.dsl.plugin.Package}.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exported Packages</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Exported Packages</em>' containment reference list.
	 * @see fr.obeo.dsl.plugin.PluginPackage#getPlugin_ExportedPackages()
	 * @model containment="true" keys="name" ordered="false"
	 * @generated
	 */
    EList<fr.obeo.dsl.plugin.Package> getExportedPackages();

} // Plugin
