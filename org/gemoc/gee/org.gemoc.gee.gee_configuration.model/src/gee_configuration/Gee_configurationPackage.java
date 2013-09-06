/**
 */
package gee_configuration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see gee_configuration.Gee_configurationFactory
 * @model kind="package"
 * @generated
 */
public interface Gee_configurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gee_configuration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.gemoc.org/gee_configuration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gee_configuration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Gee_configurationPackage eINSTANCE = gee_configuration.impl.Gee_configurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link gee_configuration.impl.GemocConfigurationImpl <em>Gemoc Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.GemocConfigurationImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getGemocConfiguration()
	 * @generated
	 */
	int GEMOC_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Dsa Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION__DSA_MODELS = 0;

	/**
	 * The feature id for the '<em><b>Mocc Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION__MOCC_MODELS = 1;

	/**
	 * The feature id for the '<em><b>Dse Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION__DSE_MODELS = 2;

	/**
	 * The feature id for the '<em><b>Domain Specific Metamodels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS = 3;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION__EDITORS = 4;

	/**
	 * The number of structural features of the '<em>Gemoc Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEMOC_CONFIGURATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.LocalResourceImpl <em>Local Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.LocalResourceImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getLocalResource()
	 * @generated
	 */
	int LOCAL_RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE__LOCATION = 0;

	/**
	 * The number of structural features of the '<em>Local Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.DSAModelImpl <em>DSA Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.DSAModelImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDSAModel()
	 * @generated
	 */
	int DSA_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_MODEL__LOCATION = LOCAL_RESOURCE__LOCATION;

	/**
	 * The number of structural features of the '<em>DSA Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSA_MODEL_FEATURE_COUNT = LOCAL_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.MoccModelImpl <em>Mocc Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.MoccModelImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getMoccModel()
	 * @generated
	 */
	int MOCC_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOCC_MODEL__LOCATION = LOCAL_RESOURCE__LOCATION;

	/**
	 * The number of structural features of the '<em>Mocc Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOCC_MODEL_FEATURE_COUNT = LOCAL_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.DSEModelImpl <em>DSE Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.DSEModelImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDSEModel()
	 * @generated
	 */
	int DSE_MODEL = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_MODEL__LOCATION = LOCAL_RESOURCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Mapped mocc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_MODEL__MAPPED_MOCC = LOCAL_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapped dsa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_MODEL__MAPPED_DSA = LOCAL_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>DSE Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DSE_MODEL_FEATURE_COUNT = LOCAL_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.DomainSpecificMetamodelImpl <em>Domain Specific Metamodel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.DomainSpecificMetamodelImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDomainSpecificMetamodel()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_METAMODEL = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_METAMODEL__LOCATION = LOCAL_RESOURCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_METAMODEL__EDITORS = LOCAL_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Domain Specific Metamodel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_METAMODEL_FEATURE_COUNT = LOCAL_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link gee_configuration.impl.DomainSpecificEditorImpl <em>Domain Specific Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gee_configuration.impl.DomainSpecificEditorImpl
	 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDomainSpecificEditor()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_EDITOR = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EDITOR__LOCATION = LOCAL_RESOURCE__LOCATION;

	/**
	 * The number of structural features of the '<em>Domain Specific Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EDITOR_FEATURE_COUNT = LOCAL_RESOURCE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link gee_configuration.GemocConfiguration <em>Gemoc Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gemoc Configuration</em>'.
	 * @see gee_configuration.GemocConfiguration
	 * @generated
	 */
	EClass getGemocConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link gee_configuration.GemocConfiguration#getDsaModels <em>Dsa Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dsa Models</em>'.
	 * @see gee_configuration.GemocConfiguration#getDsaModels()
	 * @see #getGemocConfiguration()
	 * @generated
	 */
	EReference getGemocConfiguration_DsaModels();

	/**
	 * Returns the meta object for the containment reference list '{@link gee_configuration.GemocConfiguration#getMoccModels <em>Mocc Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mocc Models</em>'.
	 * @see gee_configuration.GemocConfiguration#getMoccModels()
	 * @see #getGemocConfiguration()
	 * @generated
	 */
	EReference getGemocConfiguration_MoccModels();

	/**
	 * Returns the meta object for the containment reference list '{@link gee_configuration.GemocConfiguration#getDseModels <em>Dse Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dse Models</em>'.
	 * @see gee_configuration.GemocConfiguration#getDseModels()
	 * @see #getGemocConfiguration()
	 * @generated
	 */
	EReference getGemocConfiguration_DseModels();

	/**
	 * Returns the meta object for the containment reference list '{@link gee_configuration.GemocConfiguration#getDomainSpecificMetamodels <em>Domain Specific Metamodels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Specific Metamodels</em>'.
	 * @see gee_configuration.GemocConfiguration#getDomainSpecificMetamodels()
	 * @see #getGemocConfiguration()
	 * @generated
	 */
	EReference getGemocConfiguration_DomainSpecificMetamodels();

	/**
	 * Returns the meta object for the containment reference list '{@link gee_configuration.GemocConfiguration#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see gee_configuration.GemocConfiguration#getEditors()
	 * @see #getGemocConfiguration()
	 * @generated
	 */
	EReference getGemocConfiguration_Editors();

	/**
	 * Returns the meta object for class '{@link gee_configuration.DSAModel <em>DSA Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSA Model</em>'.
	 * @see gee_configuration.DSAModel
	 * @generated
	 */
	EClass getDSAModel();

	/**
	 * Returns the meta object for class '{@link gee_configuration.MoccModel <em>Mocc Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mocc Model</em>'.
	 * @see gee_configuration.MoccModel
	 * @generated
	 */
	EClass getMoccModel();

	/**
	 * Returns the meta object for class '{@link gee_configuration.DSEModel <em>DSE Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>DSE Model</em>'.
	 * @see gee_configuration.DSEModel
	 * @generated
	 */
	EClass getDSEModel();

	/**
	 * Returns the meta object for the reference '{@link gee_configuration.DSEModel#getMapped_mocc <em>Mapped mocc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapped mocc</em>'.
	 * @see gee_configuration.DSEModel#getMapped_mocc()
	 * @see #getDSEModel()
	 * @generated
	 */
	EReference getDSEModel_Mapped_mocc();

	/**
	 * Returns the meta object for the reference '{@link gee_configuration.DSEModel#getMapped_dsa <em>Mapped dsa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapped dsa</em>'.
	 * @see gee_configuration.DSEModel#getMapped_dsa()
	 * @see #getDSEModel()
	 * @generated
	 */
	EReference getDSEModel_Mapped_dsa();

	/**
	 * Returns the meta object for class '{@link gee_configuration.DomainSpecificMetamodel <em>Domain Specific Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Metamodel</em>'.
	 * @see gee_configuration.DomainSpecificMetamodel
	 * @generated
	 */
	EClass getDomainSpecificMetamodel();

	/**
	 * Returns the meta object for the reference list '{@link gee_configuration.DomainSpecificMetamodel#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see gee_configuration.DomainSpecificMetamodel#getEditors()
	 * @see #getDomainSpecificMetamodel()
	 * @generated
	 */
	EReference getDomainSpecificMetamodel_Editors();

	/**
	 * Returns the meta object for class '{@link gee_configuration.LocalResource <em>Local Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Resource</em>'.
	 * @see gee_configuration.LocalResource
	 * @generated
	 */
	EClass getLocalResource();

	/**
	 * Returns the meta object for the attribute '{@link gee_configuration.LocalResource#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see gee_configuration.LocalResource#getLocation()
	 * @see #getLocalResource()
	 * @generated
	 */
	EAttribute getLocalResource_Location();

	/**
	 * Returns the meta object for class '{@link gee_configuration.DomainSpecificEditor <em>Domain Specific Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Editor</em>'.
	 * @see gee_configuration.DomainSpecificEditor
	 * @generated
	 */
	EClass getDomainSpecificEditor();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Gee_configurationFactory getGee_configurationFactory();

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
		 * The meta object literal for the '{@link gee_configuration.impl.GemocConfigurationImpl <em>Gemoc Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.GemocConfigurationImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getGemocConfiguration()
		 * @generated
		 */
		EClass GEMOC_CONFIGURATION = eINSTANCE.getGemocConfiguration();

		/**
		 * The meta object literal for the '<em><b>Dsa Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_CONFIGURATION__DSA_MODELS = eINSTANCE.getGemocConfiguration_DsaModels();

		/**
		 * The meta object literal for the '<em><b>Mocc Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_CONFIGURATION__MOCC_MODELS = eINSTANCE.getGemocConfiguration_MoccModels();

		/**
		 * The meta object literal for the '<em><b>Dse Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_CONFIGURATION__DSE_MODELS = eINSTANCE.getGemocConfiguration_DseModels();

		/**
		 * The meta object literal for the '<em><b>Domain Specific Metamodels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_CONFIGURATION__DOMAIN_SPECIFIC_METAMODELS = eINSTANCE.getGemocConfiguration_DomainSpecificMetamodels();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEMOC_CONFIGURATION__EDITORS = eINSTANCE.getGemocConfiguration_Editors();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.DSAModelImpl <em>DSA Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.DSAModelImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDSAModel()
		 * @generated
		 */
		EClass DSA_MODEL = eINSTANCE.getDSAModel();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.MoccModelImpl <em>Mocc Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.MoccModelImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getMoccModel()
		 * @generated
		 */
		EClass MOCC_MODEL = eINSTANCE.getMoccModel();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.DSEModelImpl <em>DSE Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.DSEModelImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDSEModel()
		 * @generated
		 */
		EClass DSE_MODEL = eINSTANCE.getDSEModel();

		/**
		 * The meta object literal for the '<em><b>Mapped mocc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSE_MODEL__MAPPED_MOCC = eINSTANCE.getDSEModel_Mapped_mocc();

		/**
		 * The meta object literal for the '<em><b>Mapped dsa</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DSE_MODEL__MAPPED_DSA = eINSTANCE.getDSEModel_Mapped_dsa();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.DomainSpecificMetamodelImpl <em>Domain Specific Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.DomainSpecificMetamodelImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDomainSpecificMetamodel()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_METAMODEL = eINSTANCE.getDomainSpecificMetamodel();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_METAMODEL__EDITORS = eINSTANCE.getDomainSpecificMetamodel_Editors();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.LocalResourceImpl <em>Local Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.LocalResourceImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getLocalResource()
		 * @generated
		 */
		EClass LOCAL_RESOURCE = eINSTANCE.getLocalResource();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_RESOURCE__LOCATION = eINSTANCE.getLocalResource_Location();

		/**
		 * The meta object literal for the '{@link gee_configuration.impl.DomainSpecificEditorImpl <em>Domain Specific Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gee_configuration.impl.DomainSpecificEditorImpl
		 * @see gee_configuration.impl.Gee_configurationPackageImpl#getDomainSpecificEditor()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_EDITOR = eINSTANCE.getDomainSpecificEditor();

	}

} //Gee_configurationPackage
