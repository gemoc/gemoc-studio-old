/**
 */
package gee_configuration.impl;

import gee_configuration.*;

import org.eclipse.emf.ecore.EClass;
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
public class Gee_configurationFactoryImpl extends EFactoryImpl implements Gee_configurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Gee_configurationFactory init() {
		try {
			Gee_configurationFactory theGee_configurationFactory = (Gee_configurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.gemoc.org/gee_configuration"); 
			if (theGee_configurationFactory != null) {
				return theGee_configurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Gee_configurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gee_configurationFactoryImpl() {
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
			case Gee_configurationPackage.GEMOC_CONFIGURATION: return createGemocConfiguration();
			case Gee_configurationPackage.DSA_MODEL: return createDSAModel();
			case Gee_configurationPackage.MOCC_MODEL: return createMoccModel();
			case Gee_configurationPackage.DSE_MODEL: return createDSEModel();
			case Gee_configurationPackage.DOMAIN_SPECIFIC_METAMODEL: return createDomainSpecificMetamodel();
			case Gee_configurationPackage.LOCAL_RESOURCE: return createLocalResource();
			case Gee_configurationPackage.DOMAIN_SPECIFIC_EDITOR: return createDomainSpecificEditor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GemocConfiguration createGemocConfiguration() {
		GemocConfigurationImpl gemocConfiguration = new GemocConfigurationImpl();
		return gemocConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSAModel createDSAModel() {
		DSAModelImpl dsaModel = new DSAModelImpl();
		return dsaModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MoccModel createMoccModel() {
		MoccModelImpl moccModel = new MoccModelImpl();
		return moccModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DSEModel createDSEModel() {
		DSEModelImpl dseModel = new DSEModelImpl();
		return dseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainSpecificMetamodel createDomainSpecificMetamodel() {
		DomainSpecificMetamodelImpl domainSpecificMetamodel = new DomainSpecificMetamodelImpl();
		return domainSpecificMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalResource createLocalResource() {
		LocalResourceImpl localResource = new LocalResourceImpl();
		return localResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainSpecificEditor createDomainSpecificEditor() {
		DomainSpecificEditorImpl domainSpecificEditor = new DomainSpecificEditorImpl();
		return domainSpecificEditor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gee_configurationPackage getGee_configurationPackage() {
		return (Gee_configurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Gee_configurationPackage getPackage() {
		return Gee_configurationPackage.eINSTANCE;
	}

} //Gee_configurationFactoryImpl
