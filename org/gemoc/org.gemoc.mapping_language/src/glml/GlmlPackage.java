/**
 */
package glml;

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
 * @see glml.GlmlFactory
 * @model kind="package"
 * @generated
 */
public interface GlmlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "glml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.gemoc.dse_language.language_level/glml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.gemoc.dse_language.language_level.glml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GlmlPackage eINSTANCE = glml.impl.GlmlPackageImpl.init();

	/**
	 * The meta object id for the '{@link glml.impl.DomainSpecificEventFileImpl <em>Domain Specific Event File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.DomainSpecificEventFileImpl
	 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEventFile()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Language Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS = 1;

	/**
	 * The number of structural features of the '<em>Domain Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Domain Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.NamedElementImpl
	 * @see glml.impl.GlmlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.LanguageSpecificEventImpl <em>Language Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.LanguageSpecificEventImpl
	 * @see glml.impl.GlmlPackageImpl#getLanguageSpecificEvent()
	 * @generated
	 */
	int LANGUAGE_SPECIFIC_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT__TARGET_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Language Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Language Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANGUAGE_SPECIFIC_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.ImportStatementImpl <em>Import Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ImportStatementImpl
	 * @see glml.impl.GlmlPackageImpl#getImportStatement()
	 * @generated
	 */
	int IMPORT_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_STATEMENT__IMPORT_URI = 0;

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
	 * Returns the meta object for class '{@link glml.DomainSpecificEventFile <em>Domain Specific Event File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Event File</em>'.
	 * @see glml.DomainSpecificEventFile
	 * @generated
	 */
	EClass getDomainSpecificEventFile();

	/**
	 * Returns the meta object for the containment reference '{@link glml.DomainSpecificEventFile#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Imports</em>'.
	 * @see glml.DomainSpecificEventFile#getImports()
	 * @see #getDomainSpecificEventFile()
	 * @generated
	 */
	EReference getDomainSpecificEventFile_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link glml.DomainSpecificEventFile#getLanguageEvents <em>Language Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Language Events</em>'.
	 * @see glml.DomainSpecificEventFile#getLanguageEvents()
	 * @see #getDomainSpecificEventFile()
	 * @generated
	 */
	EReference getDomainSpecificEventFile_LanguageEvents();

	/**
	 * Returns the meta object for class '{@link glml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see glml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link glml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see glml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link glml.LanguageSpecificEvent <em>Language Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Language Specific Event</em>'.
	 * @see glml.LanguageSpecificEvent
	 * @generated
	 */
	EClass getLanguageSpecificEvent();

	/**
	 * Returns the meta object for the reference '{@link glml.LanguageSpecificEvent#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see glml.LanguageSpecificEvent#getTargetClass()
	 * @see #getLanguageSpecificEvent()
	 * @generated
	 */
	EReference getLanguageSpecificEvent_TargetClass();

	/**
	 * Returns the meta object for the reference list '{@link glml.LanguageSpecificEvent#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see glml.LanguageSpecificEvent#getOperations()
	 * @see #getLanguageSpecificEvent()
	 * @generated
	 */
	EReference getLanguageSpecificEvent_Operations();

	/**
	 * Returns the meta object for the attribute '{@link glml.LanguageSpecificEvent#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see glml.LanguageSpecificEvent#getCondition()
	 * @see #getLanguageSpecificEvent()
	 * @generated
	 */
	EAttribute getLanguageSpecificEvent_Condition();

	/**
	 * Returns the meta object for class '{@link glml.ImportStatement <em>Import Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Statement</em>'.
	 * @see glml.ImportStatement
	 * @generated
	 */
	EClass getImportStatement();

	/**
	 * Returns the meta object for the attribute list '{@link glml.ImportStatement#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Import URI</em>'.
	 * @see glml.ImportStatement#getImportURI()
	 * @see #getImportStatement()
	 * @generated
	 */
	EAttribute getImportStatement_ImportURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GlmlFactory getGlmlFactory();

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
		 * The meta object literal for the '{@link glml.impl.DomainSpecificEventFileImpl <em>Domain Specific Event File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.DomainSpecificEventFileImpl
		 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEventFile()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_EVENT_FILE = eINSTANCE.getDomainSpecificEventFile();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS = eINSTANCE.getDomainSpecificEventFile_Imports();

		/**
		 * The meta object literal for the '<em><b>Language Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS = eINSTANCE.getDomainSpecificEventFile_LanguageEvents();

		/**
		 * The meta object literal for the '{@link glml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.NamedElementImpl
		 * @see glml.impl.GlmlPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link glml.impl.LanguageSpecificEventImpl <em>Language Specific Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.LanguageSpecificEventImpl
		 * @see glml.impl.GlmlPackageImpl#getLanguageSpecificEvent()
		 * @generated
		 */
		EClass LANGUAGE_SPECIFIC_EVENT = eINSTANCE.getLanguageSpecificEvent();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_SPECIFIC_EVENT__TARGET_CLASS = eINSTANCE.getLanguageSpecificEvent_TargetClass();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANGUAGE_SPECIFIC_EVENT__OPERATIONS = eINSTANCE.getLanguageSpecificEvent_Operations();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LANGUAGE_SPECIFIC_EVENT__CONDITION = eINSTANCE.getLanguageSpecificEvent_Condition();

		/**
		 * The meta object literal for the '{@link glml.impl.ImportStatementImpl <em>Import Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.ImportStatementImpl
		 * @see glml.impl.GlmlPackageImpl#getImportStatement()
		 * @generated
		 */
		EClass IMPORT_STATEMENT = eINSTANCE.getImportStatement();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_STATEMENT__IMPORT_URI = eINSTANCE.getImportStatement_ImportURI();

	}

} //GlmlPackage
