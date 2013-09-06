/**
 */
package gee_configuration.util;

import gee_configuration.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see gee_configuration.Gee_configurationPackage
 * @generated
 */
public class Gee_configurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Gee_configurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gee_configurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Gee_configurationPackage.eINSTANCE;
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
	protected Gee_configurationSwitch<Adapter> modelSwitch =
		new Gee_configurationSwitch<Adapter>() {
			@Override
			public Adapter caseGemocConfiguration(GemocConfiguration object) {
				return createGemocConfigurationAdapter();
			}
			@Override
			public Adapter caseDSAModel(DSAModel object) {
				return createDSAModelAdapter();
			}
			@Override
			public Adapter caseMoccModel(MoccModel object) {
				return createMoccModelAdapter();
			}
			@Override
			public Adapter caseDSEModel(DSEModel object) {
				return createDSEModelAdapter();
			}
			@Override
			public Adapter caseDomainSpecificMetamodel(DomainSpecificMetamodel object) {
				return createDomainSpecificMetamodelAdapter();
			}
			@Override
			public Adapter caseLocalResource(LocalResource object) {
				return createLocalResourceAdapter();
			}
			@Override
			public Adapter caseDomainSpecificEditor(DomainSpecificEditor object) {
				return createDomainSpecificEditorAdapter();
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
	 * Creates a new adapter for an object of class '{@link gee_configuration.GemocConfiguration <em>Gemoc Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.GemocConfiguration
	 * @generated
	 */
	public Adapter createGemocConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.DSAModel <em>DSA Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.DSAModel
	 * @generated
	 */
	public Adapter createDSAModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.MoccModel <em>Mocc Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.MoccModel
	 * @generated
	 */
	public Adapter createMoccModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.DSEModel <em>DSE Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.DSEModel
	 * @generated
	 */
	public Adapter createDSEModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.DomainSpecificMetamodel <em>Domain Specific Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.DomainSpecificMetamodel
	 * @generated
	 */
	public Adapter createDomainSpecificMetamodelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.LocalResource <em>Local Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.LocalResource
	 * @generated
	 */
	public Adapter createLocalResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link gee_configuration.DomainSpecificEditor <em>Domain Specific Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see gee_configuration.DomainSpecificEditor
	 * @generated
	 */
	public Adapter createDomainSpecificEditorAdapter() {
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

} //Gee_configurationAdapterFactory
