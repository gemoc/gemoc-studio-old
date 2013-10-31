/**
 */
package gmml;

import glml.GlmlPackage;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gmml.GmmlFactory
 * @model kind="package"
 * @generated
 */
public interface GmmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gmml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.dse_language.model_level/gmml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.dse_language.model_level.gmml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GmmlPackage eINSTANCE = gmml.impl.GmmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link gmml.impl.ModelSpecificEventFileImpl <em>Model Specific Event File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gmml.impl.ModelSpecificEventFileImpl
	 * @see gmml.impl.GmmlPackageImpl#getModelSpecificEventFile()
	 * @generated
	 */
	int MODEL_SPECIFIC_EVENT_FILE = 0;

	/**
	 * The feature id for the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FILE__IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FILE__EVENTS = 1;

	/**
	 * The number of structural features of the '<em>Model Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FILE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gmml.impl.ModelSpecificEventImpl <em>Model Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gmml.impl.ModelSpecificEventImpl
	 * @see gmml.impl.GmmlPackageImpl#getModelSpecificEvent()
	 * @generated
	 */
	int MODEL_SPECIFIC_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__NAME = GlmlPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__TARGET = GlmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__OPERATIONS = GlmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__CONDITION = GlmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__REIFICATION = GlmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FEATURE_COUNT = GlmlPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Model Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_OPERATION_COUNT = GlmlPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link gmml.impl.ImportStatementImpl <em>Import Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gmml.impl.ImportStatementImpl
	 * @see gmml.impl.GmmlPackageImpl#getImportStatement()
	 * @generated
	 */
	int IMPORT_STATEMENT = 2;

	/**
	 * The feature id for the '<em><b>Domain Specific Event File URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI = 0;

	/**
	 * The number of structural features of the '<em>Import Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_STATEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Import Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_STATEMENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link gmml.ModelSpecificEventFile <em>Model Specific Event File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Specific Event File</em>'.
	 * @see gmml.ModelSpecificEventFile
	 * @generated
	 */
	EClass getModelSpecificEventFile();

	/**
	 * Returns the meta object for the reference '{@link gmml.ModelSpecificEventFile#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Import</em>'.
	 * @see gmml.ModelSpecificEventFile#getImport()
	 * @see #getModelSpecificEventFile()
	 * @generated
	 */
	EReference getModelSpecificEventFile_Import();

	/**
	 * Returns the meta object for the reference list '{@link gmml.ModelSpecificEventFile#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see gmml.ModelSpecificEventFile#getEvents()
	 * @see #getModelSpecificEventFile()
	 * @generated
	 */
	EReference getModelSpecificEventFile_Events();

	/**
	 * Returns the meta object for class '{@link gmml.ModelSpecificEvent <em>Model Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Specific Event</em>'.
	 * @see gmml.ModelSpecificEvent
	 * @generated
	 */
	EClass getModelSpecificEvent();

	/**
	 * Returns the meta object for the reference '{@link gmml.ModelSpecificEvent#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see gmml.ModelSpecificEvent#getTarget()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Target();

	/**
	 * Returns the meta object for the reference list '{@link gmml.ModelSpecificEvent#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see gmml.ModelSpecificEvent#getOperations()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Operations();

	/**
	 * Returns the meta object for the attribute '{@link gmml.ModelSpecificEvent#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see gmml.ModelSpecificEvent#getCondition()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EAttribute getModelSpecificEvent_Condition();

	/**
	 * Returns the meta object for the reference '{@link gmml.ModelSpecificEvent#getReification <em>Reification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reification</em>'.
	 * @see gmml.ModelSpecificEvent#getReification()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Reification();

	/**
	 * Returns the meta object for class '{@link gmml.ImportStatement <em>Import Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Statement</em>'.
	 * @see gmml.ImportStatement
	 * @generated
	 */
	EClass getImportStatement();

	/**
	 * Returns the meta object for the attribute '{@link gmml.ImportStatement#getDomainSpecificEventFileURI <em>Domain Specific Event File URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Specific Event File URI</em>'.
	 * @see gmml.ImportStatement#getDomainSpecificEventFileURI()
	 * @see #getImportStatement()
	 * @generated
	 */
	EAttribute getImportStatement_DomainSpecificEventFileURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GmmlFactory getGmmlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gmml.impl.ModelSpecificEventFileImpl <em>Model Specific Event File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gmml.impl.ModelSpecificEventFileImpl
		 * @see gmml.impl.GmmlPackageImpl#getModelSpecificEventFile()
		 * @generated
		 */
		EClass MODEL_SPECIFIC_EVENT_FILE = eINSTANCE.getModelSpecificEventFile();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT_FILE__IMPORT = eINSTANCE.getModelSpecificEventFile_Import();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT_FILE__EVENTS = eINSTANCE.getModelSpecificEventFile_Events();

		/**
		 * The meta object literal for the '{@link gmml.impl.ModelSpecificEventImpl <em>Model Specific Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gmml.impl.ModelSpecificEventImpl
		 * @see gmml.impl.GmmlPackageImpl#getModelSpecificEvent()
		 * @generated
		 */
		EClass MODEL_SPECIFIC_EVENT = eINSTANCE.getModelSpecificEvent();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__TARGET = eINSTANCE.getModelSpecificEvent_Target();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__OPERATIONS = eINSTANCE.getModelSpecificEvent_Operations();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_SPECIFIC_EVENT__CONDITION = eINSTANCE.getModelSpecificEvent_Condition();

		/**
		 * The meta object literal for the '<em><b>Reification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__REIFICATION = eINSTANCE.getModelSpecificEvent_Reification();

		/**
		 * The meta object literal for the '{@link gmml.impl.ImportStatementImpl <em>Import Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gmml.impl.ImportStatementImpl
		 * @see gmml.impl.GmmlPackageImpl#getImportStatement()
		 * @generated
		 */
		EClass IMPORT_STATEMENT = eINSTANCE.getImportStatement();

		/**
		 * The meta object literal for the '<em><b>Domain Specific Event File URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_STATEMENT__DOMAIN_SPECIFIC_EVENT_FILE_URI = eINSTANCE.getImportStatement_DomainSpecificEventFileURI();

	}

} //GmmlPackage
