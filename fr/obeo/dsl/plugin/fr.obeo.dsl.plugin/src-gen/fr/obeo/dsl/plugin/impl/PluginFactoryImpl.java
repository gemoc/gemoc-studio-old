/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.impl;

import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.ExtensionLocation;
import fr.obeo.dsl.plugin.ExtensionPoint;
import fr.obeo.dsl.plugin.Feature;
import fr.obeo.dsl.plugin.Link;
import fr.obeo.dsl.plugin.LogicalArchitecture;
import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.MetaClassRef;
import fr.obeo.dsl.plugin.Plugin;
import fr.obeo.dsl.plugin.PluginFactory;
import fr.obeo.dsl.plugin.PluginPackage;
import fr.obeo.dsl.plugin.Port;
import fr.obeo.dsl.plugin.PortKind;
import fr.obeo.dsl.plugin.State;
import fr.obeo.dsl.plugin.Root;
import fr.obeo.dsl.plugin.TargetPlatform;
import fr.obeo.dsl.plugin.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PluginFactoryImpl extends EFactoryImpl implements PluginFactory {
    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static PluginFactory init() {
		try {
			PluginFactory thePluginFactory = (PluginFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.obeo.fr/dsl/plugin"); 
			if (thePluginFactory != null) {
				return thePluginFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PluginFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PluginFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PluginPackage.EXTENSION_LOCATION: return (EObject)createExtensionLocation();
			case PluginPackage.PHYSICAL_ARCHITECTURE: return (EObject)createPhysicalArchitecture();
			case PluginPackage.COMPONENT: return (EObject)createComponent();
			case PluginPackage.PORT: return (EObject)createPort();
			case PluginPackage.LINK: return (EObject)createLink();
			case PluginPackage.FEATURE: return (EObject)createFeature();
			case PluginPackage.PLUGIN: return (EObject)createPlugin();
			case PluginPackage.EXTENSION_POINT: return (EObject)createExtensionPoint();
			case PluginPackage.PACKAGE: return (EObject)createPackage();
			case PluginPackage.LOGICAL_ARCHITECTURE: return (EObject)createLogicalArchitecture();
			case PluginPackage.STATE: return (EObject)createState();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PluginPackage.PORT_KIND:
				return createPortKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PluginPackage.PORT_KIND:
				return convertPortKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ExtensionLocation createExtensionLocation() {
		ExtensionLocationImpl extensionLocation = new ExtensionLocationImpl();
		return extensionLocation;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalArchitecture createPhysicalArchitecture() {
		PhysicalArchitectureImpl physicalArchitecture = new PhysicalArchitectureImpl();
		return physicalArchitecture;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Plugin createPlugin() {
		PluginImpl plugin = new PluginImpl();
		return plugin;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ExtensionPoint createExtensionPoint() {
		ExtensionPointImpl extensionPoint = new ExtensionPointImpl();
		return extensionPoint;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public fr.obeo.dsl.plugin.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalArchitecture createLogicalArchitecture() {
		LogicalArchitectureImpl logicalArchitecture = new LogicalArchitectureImpl();
		return logicalArchitecture;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

				/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PortKind createPortKindFromString(EDataType eDataType, String initialValue) {
		PortKind result = PortKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public String convertPortKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PluginPackage getPluginPackage() {
		return (PluginPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static PluginPackage getPackage() {
		return PluginPackage.eINSTANCE;
	}

} //PluginFactoryImpl
