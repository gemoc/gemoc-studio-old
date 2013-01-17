/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.obeo.dsl.plugin.util;

import fr.obeo.dsl.plugin.Bundle;
import fr.obeo.dsl.plugin.Component;
import fr.obeo.dsl.plugin.ExtensionLocation;
import fr.obeo.dsl.plugin.ExtensionPoint;
import fr.obeo.dsl.plugin.Feature;
import fr.obeo.dsl.plugin.Link;
import fr.obeo.dsl.plugin.LogicalArchitecture;
import fr.obeo.dsl.plugin.PhysicalArchitecture;
import fr.obeo.dsl.plugin.MetaClassRef;
import fr.obeo.dsl.plugin.Plugin;
import fr.obeo.dsl.plugin.PluginPackage;
import fr.obeo.dsl.plugin.Port;
import fr.obeo.dsl.plugin.State;
import fr.obeo.dsl.plugin.Root;
import fr.obeo.dsl.plugin.TargetPlatform;
import fr.obeo.dsl.plugin.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.obeo.dsl.plugin.PluginPackage
 * @generated
 */
public class PluginAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static PluginPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PluginAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PluginPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    @Override
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected PluginSwitch<Adapter> modelSwitch =
        new PluginSwitch<Adapter>() {
			@Override
			public Adapter caseExtensionLocation(ExtensionLocation object) {
				return createExtensionLocationAdapter();
			}
			@Override
			public Adapter casePhysicalArchitecture(PhysicalArchitecture object) {
				return createPhysicalArchitectureAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseLink(Link object) {
				return createLinkAdapter();
			}
			@Override
			public Adapter caseBundle(Bundle object) {
				return createBundleAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter casePlugin(Plugin object) {
				return createPluginAdapter();
			}
			@Override
			public Adapter caseExtensionPoint(ExtensionPoint object) {
				return createExtensionPointAdapter();
			}
			@Override
			public Adapter casePackage(fr.obeo.dsl.plugin.Package object) {
				return createPackageAdapter();
			}
			@Override
			public Adapter caseLogicalArchitecture(LogicalArchitecture object) {
				return createLogicalArchitectureAdapter();
			}
			@Override
			public Adapter caseState(State object) {
				return createStateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    @Override
    public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.ExtensionLocation <em>Extension Location</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.ExtensionLocation
	 * @generated
	 */
    public Adapter createExtensionLocationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.PhysicalArchitecture <em>Physical Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.PhysicalArchitecture
	 * @generated
	 */
	public Adapter createPhysicalArchitectureAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Component
	 * @generated
	 */
    public Adapter createComponentAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Port
	 * @generated
	 */
    public Adapter createPortAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Link
	 * @generated
	 */
    public Adapter createLinkAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Bundle
	 * @generated
	 */
    public Adapter createBundleAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Feature
	 * @generated
	 */
    public Adapter createFeatureAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Plugin
	 * @generated
	 */
    public Adapter createPluginAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.ExtensionPoint <em>Extension Point</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.ExtensionPoint
	 * @generated
	 */
    public Adapter createExtensionPointAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.Package
	 * @generated
	 */
    public Adapter createPackageAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.LogicalArchitecture <em>Logical Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.LogicalArchitecture
	 * @generated
	 */
	public Adapter createLogicalArchitectureAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.plugin.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.obeo.dsl.plugin.State
	 * @generated
	 */
	public Adapter createStateAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //PluginAdapterFactory
