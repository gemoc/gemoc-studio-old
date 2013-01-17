/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.plugin.PluginFactory
 * @model kind="package"
 * @generated
 */
public interface PluginPackage extends EPackage {
    /**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "plugin";

    /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.obeo.fr/dsl/plugin";

    /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "plugin";

    /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    PluginPackage eINSTANCE = fr.obeo.dsl.plugin.impl.PluginPackageImpl.init();

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.ExtensionLocationImpl <em>Extension Location</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.ExtensionLocationImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getExtensionLocation()
	 * @generated
	 */
    int EXTENSION_LOCATION = 0;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_LOCATION__NAME = 0;

    /**
	 * The feature id for the '<em><b>Owned Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_LOCATION__OWNED_BUNDLES = 1;

    /**
	 * The feature id for the '<em><b>Owned Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_LOCATION__OWNED_GROUPS = 2;

    /**
	 * The number of structural features of the '<em>Extension Location</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_LOCATION_FEATURE_COUNT = 3;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl <em>Physical Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPhysicalArchitecture()
	 * @generated
	 */
	int PHYSICAL_ARCHITECTURE = 1;

				/**
	 * The feature id for the '<em><b>Owned Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ARCHITECTURE__OWNED_BUNDLES = 0;

				/**
	 * The feature id for the '<em><b>Root Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ARCHITECTURE__ROOT_FEATURE = 1;

				/**
	 * The number of structural features of the '<em>Physical Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_ARCHITECTURE_FEATURE_COUNT = 2;

				/**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.ComponentImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getComponent()
	 * @generated
	 */
    int COMPONENT = 2;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__NAME = 0;

    /**
	 * The feature id for the '<em><b>Sub Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__SUB_COMPONENTS = 1;

    /**
	 * The feature id for the '<em><b>Referenced Components</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REFERENCED_COMPONENTS = 2;

				/**
	 * The feature id for the '<em><b>Bundles</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__BUNDLES = 3;

    /**
	 * The feature id for the '<em><b>Expected Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__EXPECTED_DEPENDENCIES = 4;

    /**
	 * The feature id for the '<em><b>Expected Extensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__EXPECTED_EXTENSIONS = 5;

    /**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__PORTS = 6;

    /**
	 * The feature id for the '<em><b>Classifiers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__CLASSIFIERS = 7;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT__DESCRIPTION = 8;

    /**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int COMPONENT_FEATURE_COUNT = 9;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.PortImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPort()
	 * @generated
	 */
    int PORT = 3;

    /**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT__KIND = 0;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT__NAME = 1;

    /**
	 * The feature id for the '<em><b>Delegation</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT__DELEGATION = 2;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT__DESCRIPTION = 3;

    /**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT__LINKS = 4;

    /**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PORT_FEATURE_COUNT = 5;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.LinkImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getLink()
	 * @generated
	 */
    int LINK = 4;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int LINK__NAME = 0;

    /**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int LINK__TYPE = 1;

    /**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int LINK_FEATURE_COUNT = 2;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.BundleImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getBundle()
	 * @generated
	 */
    int BUNDLE = 5;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int BUNDLE__NAME = 0;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int BUNDLE__DESCRIPTION = 1;

    /**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int BUNDLE_FEATURE_COUNT = 2;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.FeatureImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getFeature()
	 * @generated
	 */
    int FEATURE = 6;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int FEATURE__NAME = BUNDLE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int FEATURE__DESCRIPTION = BUNDLE__DESCRIPTION;

    /**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int FEATURE_FEATURE_COUNT = BUNDLE_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.PluginImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPlugin()
	 * @generated
	 */
    int PLUGIN = 7;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__NAME = BUNDLE__NAME;

    /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__DESCRIPTION = BUNDLE__DESCRIPTION;

    /**
	 * The feature id for the '<em><b>Require</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__REQUIRE = BUNDLE_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Owned Extension Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__OWNED_EXTENSION_POINTS = BUNDLE_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Extensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__EXTENSIONS = BUNDLE_FEATURE_COUNT + 2;

    /**
	 * The feature id for the '<em><b>Exported Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN__EXPORTED_PACKAGES = BUNDLE_FEATURE_COUNT + 3;

    /**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PLUGIN_FEATURE_COUNT = BUNDLE_FEATURE_COUNT + 4;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.ExtensionPointImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getExtensionPoint()
	 * @generated
	 */
    int EXTENSION_POINT = 8;

    /**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_POINT__ID = 0;

    /**
	 * The feature id for the '<em><b>Xsd</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_POINT__XSD = 1;

    /**
	 * The feature id for the '<em><b>Extending Plugins</b></em>' reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_POINT__EXTENDING_PLUGINS = 2;

    /**
	 * The number of structural features of the '<em>Extension Point</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int EXTENSION_POINT_FEATURE_COUNT = 3;


    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.PackageImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPackage()
	 * @generated
	 */
    int PACKAGE = 9;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__NAME = 0;

    /**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE_FEATURE_COUNT = 1;

    /**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.LogicalArchitectureImpl <em>Logical Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.LogicalArchitectureImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getLogicalArchitecture()
	 * @generated
	 */
	int LOGICAL_ARCHITECTURE = 10;

				/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ARCHITECTURE__COMPONENTS = 0;

				/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ARCHITECTURE__STATES = 1;

				/**
	 * The number of structural features of the '<em>Logical Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_ARCHITECTURE_FEATURE_COUNT = 2;

				/**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.impl.StateImpl
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getState()
	 * @generated
	 */
	int STATE = 11;

				/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = 0;

				/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ECLASS = 1;

				/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 2;

				/**
	 * The meta object id for the '{@link fr.obeo.dsl.plugin.PortKind <em>Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see fr.obeo.dsl.plugin.PortKind
	 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPortKind()
	 * @generated
	 */
    int PORT_KIND = 12;


    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.ExtensionLocation <em>Extension Location</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Location</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionLocation
	 * @generated
	 */
    EClass getExtensionLocation();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.ExtensionLocation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionLocation#getName()
	 * @see #getExtensionLocation()
	 * @generated
	 */
    EAttribute getExtensionLocation_Name();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.ExtensionLocation#getOwnedBundles <em>Owned Bundles</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Bundles</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionLocation#getOwnedBundles()
	 * @see #getExtensionLocation()
	 * @generated
	 */
    EReference getExtensionLocation_OwnedBundles();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.ExtensionLocation#getOwnedGroups <em>Owned Groups</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Groups</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionLocation#getOwnedGroups()
	 * @see #getExtensionLocation()
	 * @generated
	 */
    EReference getExtensionLocation_OwnedGroups();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.PhysicalArchitecture <em>Physical Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Physical Architecture</em>'.
	 * @see fr.obeo.dsl.plugin.PhysicalArchitecture
	 * @generated
	 */
	EClass getPhysicalArchitecture();

				/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.PhysicalArchitecture#getOwnedBundles <em>Owned Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Bundles</em>'.
	 * @see fr.obeo.dsl.plugin.PhysicalArchitecture#getOwnedBundles()
	 * @see #getPhysicalArchitecture()
	 * @generated
	 */
	EReference getPhysicalArchitecture_OwnedBundles();

				/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.plugin.PhysicalArchitecture#getRootFeature <em>Root Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Feature</em>'.
	 * @see fr.obeo.dsl.plugin.PhysicalArchitecture#getRootFeature()
	 * @see #getPhysicalArchitecture()
	 * @generated
	 */
	EReference getPhysicalArchitecture_RootFeature();

				/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see fr.obeo.dsl.plugin.Component
	 * @generated
	 */
    EClass getComponent();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
    EAttribute getComponent_Name();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Component#getSubComponents <em>Sub Components</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Components</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getSubComponents()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_SubComponents();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Component#getReferencedComponents <em>Referenced Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referenced Components</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getReferencedComponents()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_ReferencedComponents();

				/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Component#getBundles <em>Bundles</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bundles</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getBundles()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_Bundles();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Component#getExpectedDependencies <em>Expected Dependencies</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expected Dependencies</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getExpectedDependencies()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_ExpectedDependencies();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Component#getExpectedExtensions <em>Expected Extensions</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Expected Extensions</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getExpectedExtensions()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_ExpectedExtensions();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Component#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getPorts()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_Ports();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Component#getClassifiers <em>Classifiers</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classifiers</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getClassifiers()
	 * @see #getComponent()
	 * @generated
	 */
    EReference getComponent_Classifiers();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Component#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.obeo.dsl.plugin.Component#getDescription()
	 * @see #getComponent()
	 * @generated
	 */
    EAttribute getComponent_Description();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see fr.obeo.dsl.plugin.Port
	 * @generated
	 */
    EClass getPort();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Port#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see fr.obeo.dsl.plugin.Port#getKind()
	 * @see #getPort()
	 * @generated
	 */
    EAttribute getPort_Kind();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
    EAttribute getPort_Name();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Port#getDelegation <em>Delegation</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delegation</em>'.
	 * @see fr.obeo.dsl.plugin.Port#getDelegation()
	 * @see #getPort()
	 * @generated
	 */
    EReference getPort_Delegation();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Port#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.obeo.dsl.plugin.Port#getDescription()
	 * @see #getPort()
	 * @generated
	 */
    EAttribute getPort_Description();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Port#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see fr.obeo.dsl.plugin.Port#getLinks()
	 * @see #getPort()
	 * @generated
	 */
    EReference getPort_Links();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see fr.obeo.dsl.plugin.Link
	 * @generated
	 */
    EClass getLink();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Link#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.Link#getName()
	 * @see #getLink()
	 * @generated
	 */
    EAttribute getLink_Name();

    /**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.plugin.Link#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.obeo.dsl.plugin.Link#getType()
	 * @see #getLink()
	 * @generated
	 */
    EReference getLink_Type();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see fr.obeo.dsl.plugin.Bundle
	 * @generated
	 */
    EClass getBundle();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Bundle#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.Bundle#getName()
	 * @see #getBundle()
	 * @generated
	 */
    EAttribute getBundle_Name();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Bundle#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.obeo.dsl.plugin.Bundle#getDescription()
	 * @see #getBundle()
	 * @generated
	 */
    EAttribute getBundle_Description();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see fr.obeo.dsl.plugin.Feature
	 * @generated
	 */
    EClass getFeature();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see fr.obeo.dsl.plugin.Plugin
	 * @generated
	 */
    EClass getPlugin();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Plugin#getRequire <em>Require</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Require</em>'.
	 * @see fr.obeo.dsl.plugin.Plugin#getRequire()
	 * @see #getPlugin()
	 * @generated
	 */
    EReference getPlugin_Require();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Plugin#getOwnedExtensionPoints <em>Owned Extension Points</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Extension Points</em>'.
	 * @see fr.obeo.dsl.plugin.Plugin#getOwnedExtensionPoints()
	 * @see #getPlugin()
	 * @generated
	 */
    EReference getPlugin_OwnedExtensionPoints();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.Plugin#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extensions</em>'.
	 * @see fr.obeo.dsl.plugin.Plugin#getExtensions()
	 * @see #getPlugin()
	 * @generated
	 */
    EReference getPlugin_Extensions();

    /**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.Plugin#getExportedPackages <em>Exported Packages</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exported Packages</em>'.
	 * @see fr.obeo.dsl.plugin.Plugin#getExportedPackages()
	 * @see #getPlugin()
	 * @generated
	 */
    EReference getPlugin_ExportedPackages();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Point</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionPoint
	 * @generated
	 */
    EClass getExtensionPoint();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.ExtensionPoint#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionPoint#getId()
	 * @see #getExtensionPoint()
	 * @generated
	 */
    EAttribute getExtensionPoint_Id();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.ExtensionPoint#getXsd <em>Xsd</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xsd</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionPoint#getXsd()
	 * @see #getExtensionPoint()
	 * @generated
	 */
    EAttribute getExtensionPoint_Xsd();

    /**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.plugin.ExtensionPoint#getExtendingPlugins <em>Extending Plugins</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extending Plugins</em>'.
	 * @see fr.obeo.dsl.plugin.ExtensionPoint#getExtendingPlugins()
	 * @see #getExtensionPoint()
	 * @generated
	 */
    EReference getExtensionPoint_ExtendingPlugins();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see fr.obeo.dsl.plugin.Package
	 * @generated
	 */
    EClass getPackage();

    /**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.Package#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.Package#getName()
	 * @see #getPackage()
	 * @generated
	 */
    EAttribute getPackage_Name();

    /**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.LogicalArchitecture <em>Logical Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Architecture</em>'.
	 * @see fr.obeo.dsl.plugin.LogicalArchitecture
	 * @generated
	 */
	EClass getLogicalArchitecture();

				/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.LogicalArchitecture#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see fr.obeo.dsl.plugin.LogicalArchitecture#getComponents()
	 * @see #getLogicalArchitecture()
	 * @generated
	 */
	EReference getLogicalArchitecture_Components();

				/**
	 * Returns the meta object for the containment reference list '{@link fr.obeo.dsl.plugin.LogicalArchitecture#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see fr.obeo.dsl.plugin.LogicalArchitecture#getStates()
	 * @see #getLogicalArchitecture()
	 * @generated
	 */
	EReference getLogicalArchitecture_States();

				/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.plugin.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see fr.obeo.dsl.plugin.State
	 * @generated
	 */
	EClass getState();

				/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.plugin.State#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.plugin.State#getName()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_Name();

				/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.plugin.State#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see fr.obeo.dsl.plugin.State#getEClass()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_EClass();

				/**
	 * Returns the meta object for enum '{@link fr.obeo.dsl.plugin.PortKind <em>Port Kind</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Kind</em>'.
	 * @see fr.obeo.dsl.plugin.PortKind
	 * @generated
	 */
    EEnum getPortKind();

    /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    PluginFactory getPluginFactory();

    /**
	 * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
	 * @generated
	 */
    interface Literals {
        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.ExtensionLocationImpl <em>Extension Location</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.ExtensionLocationImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getExtensionLocation()
		 * @generated
		 */
        EClass EXTENSION_LOCATION = eINSTANCE.getExtensionLocation();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute EXTENSION_LOCATION__NAME = eINSTANCE.getExtensionLocation_Name();

        /**
		 * The meta object literal for the '<em><b>Owned Bundles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference EXTENSION_LOCATION__OWNED_BUNDLES = eINSTANCE.getExtensionLocation_OwnedBundles();

        /**
		 * The meta object literal for the '<em><b>Owned Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference EXTENSION_LOCATION__OWNED_GROUPS = eINSTANCE.getExtensionLocation_OwnedGroups();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl <em>Physical Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.PhysicalArchitectureImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPhysicalArchitecture()
		 * @generated
		 */
		EClass PHYSICAL_ARCHITECTURE = eINSTANCE.getPhysicalArchitecture();

								/**
		 * The meta object literal for the '<em><b>Owned Bundles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_ARCHITECTURE__OWNED_BUNDLES = eINSTANCE.getPhysicalArchitecture_OwnedBundles();

								/**
		 * The meta object literal for the '<em><b>Root Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_ARCHITECTURE__ROOT_FEATURE = eINSTANCE.getPhysicalArchitecture_RootFeature();

								/**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.ComponentImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getComponent()
		 * @generated
		 */
        EClass COMPONENT = eINSTANCE.getComponent();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

        /**
		 * The meta object literal for the '<em><b>Sub Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__SUB_COMPONENTS = eINSTANCE.getComponent_SubComponents();

        /**
		 * The meta object literal for the '<em><b>Referenced Components</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REFERENCED_COMPONENTS = eINSTANCE.getComponent_ReferencedComponents();

								/**
		 * The meta object literal for the '<em><b>Bundles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__BUNDLES = eINSTANCE.getComponent_Bundles();

        /**
		 * The meta object literal for the '<em><b>Expected Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__EXPECTED_DEPENDENCIES = eINSTANCE.getComponent_ExpectedDependencies();

        /**
		 * The meta object literal for the '<em><b>Expected Extensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__EXPECTED_EXTENSIONS = eINSTANCE.getComponent_ExpectedExtensions();

        /**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__PORTS = eINSTANCE.getComponent_Ports();

        /**
		 * The meta object literal for the '<em><b>Classifiers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference COMPONENT__CLASSIFIERS = eINSTANCE.getComponent_Classifiers();

        /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute COMPONENT__DESCRIPTION = eINSTANCE.getComponent_Description();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.PortImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPort()
		 * @generated
		 */
        EClass PORT = eINSTANCE.getPort();

        /**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PORT__KIND = eINSTANCE.getPort_Kind();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PORT__NAME = eINSTANCE.getPort_Name();

        /**
		 * The meta object literal for the '<em><b>Delegation</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PORT__DELEGATION = eINSTANCE.getPort_Delegation();

        /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PORT__DESCRIPTION = eINSTANCE.getPort_Description();

        /**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PORT__LINKS = eINSTANCE.getPort_Links();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.LinkImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getLink()
		 * @generated
		 */
        EClass LINK = eINSTANCE.getLink();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute LINK__NAME = eINSTANCE.getLink_Name();

        /**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference LINK__TYPE = eINSTANCE.getLink_Type();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.BundleImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getBundle()
		 * @generated
		 */
        EClass BUNDLE = eINSTANCE.getBundle();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute BUNDLE__NAME = eINSTANCE.getBundle_Name();

        /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute BUNDLE__DESCRIPTION = eINSTANCE.getBundle_Description();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.FeatureImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getFeature()
		 * @generated
		 */
        EClass FEATURE = eINSTANCE.getFeature();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.PluginImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPlugin()
		 * @generated
		 */
        EClass PLUGIN = eINSTANCE.getPlugin();

        /**
		 * The meta object literal for the '<em><b>Require</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PLUGIN__REQUIRE = eINSTANCE.getPlugin_Require();

        /**
		 * The meta object literal for the '<em><b>Owned Extension Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PLUGIN__OWNED_EXTENSION_POINTS = eINSTANCE.getPlugin_OwnedExtensionPoints();

        /**
		 * The meta object literal for the '<em><b>Extensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PLUGIN__EXTENSIONS = eINSTANCE.getPlugin_Extensions();

        /**
		 * The meta object literal for the '<em><b>Exported Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference PLUGIN__EXPORTED_PACKAGES = eINSTANCE.getPlugin_ExportedPackages();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.ExtensionPointImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getExtensionPoint()
		 * @generated
		 */
        EClass EXTENSION_POINT = eINSTANCE.getExtensionPoint();

        /**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute EXTENSION_POINT__ID = eINSTANCE.getExtensionPoint_Id();

        /**
		 * The meta object literal for the '<em><b>Xsd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute EXTENSION_POINT__XSD = eINSTANCE.getExtensionPoint_Xsd();

        /**
		 * The meta object literal for the '<em><b>Extending Plugins</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EReference EXTENSION_POINT__EXTENDING_PLUGINS = eINSTANCE.getExtensionPoint_ExtendingPlugins();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.PackageImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPackage()
		 * @generated
		 */
        EClass PACKAGE = eINSTANCE.getPackage();

        /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @generated
		 */
        EAttribute PACKAGE__NAME = eINSTANCE.getPackage_Name();

        /**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.LogicalArchitectureImpl <em>Logical Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.LogicalArchitectureImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getLogicalArchitecture()
		 * @generated
		 */
		EClass LOGICAL_ARCHITECTURE = eINSTANCE.getLogicalArchitecture();

								/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_ARCHITECTURE__COMPONENTS = eINSTANCE.getLogicalArchitecture_Components();

								/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGICAL_ARCHITECTURE__STATES = eINSTANCE.getLogicalArchitecture_States();

								/**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.impl.StateImpl
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

								/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__NAME = eINSTANCE.getState_Name();

								/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ECLASS = eINSTANCE.getState_EClass();

								/**
		 * The meta object literal for the '{@link fr.obeo.dsl.plugin.PortKind <em>Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
		 * @see fr.obeo.dsl.plugin.PortKind
		 * @see fr.obeo.dsl.plugin.impl.PluginPackageImpl#getPortKind()
		 * @generated
		 */
        EEnum PORT_KIND = eINSTANCE.getPortKind();

    }

} //PluginPackage
