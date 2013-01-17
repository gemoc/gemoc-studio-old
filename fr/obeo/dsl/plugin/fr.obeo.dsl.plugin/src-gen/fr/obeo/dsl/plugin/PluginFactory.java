/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.plugin.PluginPackage
 * @generated
 */
public interface PluginFactory extends EFactory {
    /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    PluginFactory eINSTANCE = fr.obeo.dsl.plugin.impl.PluginFactoryImpl.init();

    /**
	 * Returns a new object of class '<em>Extension Location</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Location</em>'.
	 * @generated
	 */
    ExtensionLocation createExtensionLocation();

    /**
	 * Returns a new object of class '<em>Physical Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Physical Architecture</em>'.
	 * @generated
	 */
	PhysicalArchitecture createPhysicalArchitecture();

				/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
    Component createComponent();

    /**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
    Port createPort();

    /**
	 * Returns a new object of class '<em>Link</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link</em>'.
	 * @generated
	 */
    Link createLink();

    /**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
    Feature createFeature();

    /**
	 * Returns a new object of class '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin</em>'.
	 * @generated
	 */
    Plugin createPlugin();

    /**
	 * Returns a new object of class '<em>Extension Point</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Point</em>'.
	 * @generated
	 */
    ExtensionPoint createExtensionPoint();

    /**
	 * Returns a new object of class '<em>Package</em>'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package</em>'.
	 * @generated
	 */
    Package createPackage();

    /**
	 * Returns a new object of class '<em>Logical Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Architecture</em>'.
	 * @generated
	 */
	LogicalArchitecture createLogicalArchitecture();

				/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

				/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
    PluginPackage getPluginPackage();

} //PluginFactory
