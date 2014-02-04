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
	 * The meta object id for the '{@link glml.impl.DomainSpecificEventFileImpl <em>Domain Specific Event File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.DomainSpecificEventFileImpl
	 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEventFile()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__IMPORTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Language Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__LANGUAGE_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Domain Specific Event File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FILE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.ImportStatementImpl <em>Import Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ImportStatementImpl
	 * @see glml.impl.GlmlPackageImpl#getImportStatement()
	 * @generated
	 */
	int IMPORT_STATEMENT = 2;

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
	 * The meta object id for the '{@link glml.impl.DomainSpecificEventImpl <em>Domain Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.DomainSpecificEventImpl
	 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEvent()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Specific Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Domain Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Domain Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.PatternImpl
	 * @see glml.impl.GlmlPackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 4;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.IdentityImpl <em>Identity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.IdentityImpl
	 * @see glml.impl.GlmlPackageImpl#getIdentity()
	 * @generated
	 */
	int IDENTITY = 5;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY__ARGUMENT = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Identity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTITY_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.SpatialCoincidenceImpl <em>Spatial Coincidence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.SpatialCoincidenceImpl
	 * @see glml.impl.GlmlPackageImpl#getSpatialCoincidence()
	 * @generated
	 */
	int SPATIAL_COINCIDENCE = 6;

	/**
	 * The feature id for the '<em><b>First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_COINCIDENCE__FIRST_ARGUMENT = PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_COINCIDENCE__SECOND_ARGUMENT = PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Spatial Coincidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_COINCIDENCE_FEATURE_COUNT = PATTERN_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Spatial Coincidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPATIAL_COINCIDENCE_OPERATION_COUNT = PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.DomainSpecificActionImpl <em>Domain Specific Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.DomainSpecificActionImpl
	 * @see glml.impl.GlmlPackageImpl#getDomainSpecificAction()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION__TARGET_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION__OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Owning Domain Specific Event</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT = 3;

	/**
	 * The number of structural features of the '<em>Domain Specific Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Domain Specific Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.MocEventImpl <em>Moc Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.MocEventImpl
	 * @see glml.impl.GlmlPackageImpl#getMocEvent()
	 * @generated
	 */
	int MOC_EVENT = 8;

	/**
	 * The number of structural features of the '<em>Moc Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_EVENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Moc Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_EVENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.ECLEventImpl <em>ECL Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ECLEventImpl
	 * @see glml.impl.GlmlPackageImpl#getECLEvent()
	 * @generated
	 */
	int ECL_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT__ELEMENT = MOC_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ECL Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT_FEATURE_COUNT = MOC_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ECL Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECL_EVENT_OPERATION_COUNT = MOC_EVENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.ModelSpecificEventImpl <em>Model Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ModelSpecificEventImpl
	 * @see glml.impl.GlmlPackageImpl#getModelSpecificEvent()
	 * @generated
	 */
	int MODEL_SPECIFIC_EVENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__REIFICATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Model Specific Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__MODEL_SPECIFIC_ACTIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Model Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.ModelSpecificActionImpl <em>Model Specific Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ModelSpecificActionImpl
	 * @see glml.impl.GlmlPackageImpl#getModelSpecificAction()
	 * @generated
	 */
	int MODEL_SPECIFIC_ACTION = 11;

	/**
	 * The feature id for the '<em><b>Reification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION__REIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION__OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION__PARAMETERS = 3;

	/**
	 * The feature id for the '<em><b>Owning Model Specific Event</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION__OWNING_MODEL_SPECIFIC_EVENT = 4;

	/**
	 * The number of structural features of the '<em>Model Specific Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Model Specific Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_ACTION_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link glml.DomainSpecificEventFile#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
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
	 * Returns the meta object for the containment reference list '{@link glml.DomainSpecificEventFile#getModelEvents <em>Model Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Events</em>'.
	 * @see glml.DomainSpecificEventFile#getModelEvents()
	 * @see #getDomainSpecificEventFile()
	 * @generated
	 */
	EReference getDomainSpecificEventFile_ModelEvents();

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
	 * Returns the meta object for class '{@link glml.DomainSpecificEvent <em>Domain Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Event</em>'.
	 * @see glml.DomainSpecificEvent
	 * @generated
	 */
	EClass getDomainSpecificEvent();

	/**
	 * Returns the meta object for the containment reference '{@link glml.DomainSpecificEvent#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see glml.DomainSpecificEvent#getCondition()
	 * @see #getDomainSpecificEvent()
	 * @generated
	 */
	EReference getDomainSpecificEvent_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link glml.DomainSpecificEvent#getDomainSpecificActions <em>Domain Specific Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Specific Actions</em>'.
	 * @see glml.DomainSpecificEvent#getDomainSpecificActions()
	 * @see #getDomainSpecificEvent()
	 * @generated
	 */
	EReference getDomainSpecificEvent_DomainSpecificActions();

	/**
	 * Returns the meta object for class '{@link glml.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see glml.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for class '{@link glml.Identity <em>Identity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identity</em>'.
	 * @see glml.Identity
	 * @generated
	 */
	EClass getIdentity();

	/**
	 * Returns the meta object for the containment reference '{@link glml.Identity#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Argument</em>'.
	 * @see glml.Identity#getArgument()
	 * @see #getIdentity()
	 * @generated
	 */
	EReference getIdentity_Argument();

	/**
	 * Returns the meta object for class '{@link glml.SpatialCoincidence <em>Spatial Coincidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Spatial Coincidence</em>'.
	 * @see glml.SpatialCoincidence
	 * @generated
	 */
	EClass getSpatialCoincidence();

	/**
	 * Returns the meta object for the containment reference '{@link glml.SpatialCoincidence#getFirstArgument <em>First Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Argument</em>'.
	 * @see glml.SpatialCoincidence#getFirstArgument()
	 * @see #getSpatialCoincidence()
	 * @generated
	 */
	EReference getSpatialCoincidence_FirstArgument();

	/**
	 * Returns the meta object for the containment reference '{@link glml.SpatialCoincidence#getSecondArgument <em>Second Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Argument</em>'.
	 * @see glml.SpatialCoincidence#getSecondArgument()
	 * @see #getSpatialCoincidence()
	 * @generated
	 */
	EReference getSpatialCoincidence_SecondArgument();

	/**
	 * Returns the meta object for class '{@link glml.DomainSpecificAction <em>Domain Specific Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Action</em>'.
	 * @see glml.DomainSpecificAction
	 * @generated
	 */
	EClass getDomainSpecificAction();

	/**
	 * Returns the meta object for the reference '{@link glml.DomainSpecificAction#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see glml.DomainSpecificAction#getTargetClass()
	 * @see #getDomainSpecificAction()
	 * @generated
	 */
	EReference getDomainSpecificAction_TargetClass();

	/**
	 * Returns the meta object for the reference '{@link glml.DomainSpecificAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see glml.DomainSpecificAction#getOperation()
	 * @see #getDomainSpecificAction()
	 * @generated
	 */
	EReference getDomainSpecificAction_Operation();

	/**
	 * Returns the meta object for the reference list '{@link glml.DomainSpecificAction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameter Types</em>'.
	 * @see glml.DomainSpecificAction#getParameterTypes()
	 * @see #getDomainSpecificAction()
	 * @generated
	 */
	EReference getDomainSpecificAction_ParameterTypes();

	/**
	 * Returns the meta object for the container reference '{@link glml.DomainSpecificAction#getOwningDomainSpecificEvent <em>Owning Domain Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Domain Specific Event</em>'.
	 * @see glml.DomainSpecificAction#getOwningDomainSpecificEvent()
	 * @see #getDomainSpecificAction()
	 * @generated
	 */
	EReference getDomainSpecificAction_OwningDomainSpecificEvent();

	/**
	 * Returns the meta object for class '{@link glml.MocEvent <em>Moc Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moc Event</em>'.
	 * @see glml.MocEvent
	 * @generated
	 */
	EClass getMocEvent();

	/**
	 * Returns the meta object for class '{@link glml.ECLEvent <em>ECL Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECL Event</em>'.
	 * @see glml.ECLEvent
	 * @generated
	 */
	EClass getECLEvent();

	/**
	 * Returns the meta object for the reference '{@link glml.ECLEvent#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see glml.ECLEvent#getElement()
	 * @see #getECLEvent()
	 * @generated
	 */
	EReference getECLEvent_Element();

	/**
	 * Returns the meta object for class '{@link glml.ModelSpecificEvent <em>Model Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Specific Event</em>'.
	 * @see glml.ModelSpecificEvent
	 * @generated
	 */
	EClass getModelSpecificEvent();

	/**
	 * Returns the meta object for the reference '{@link glml.ModelSpecificEvent#getReification <em>Reification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reification</em>'.
	 * @see glml.ModelSpecificEvent#getReification()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Reification();

	/**
	 * Returns the meta object for the containment reference '{@link glml.ModelSpecificEvent#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see glml.ModelSpecificEvent#getCondition()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Condition();

	/**
	 * Returns the meta object for the containment reference list '{@link glml.ModelSpecificEvent#getModelSpecificActions <em>Model Specific Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Specific Actions</em>'.
	 * @see glml.ModelSpecificEvent#getModelSpecificActions()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_ModelSpecificActions();

	/**
	 * Returns the meta object for class '{@link glml.ModelSpecificAction <em>Model Specific Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Specific Action</em>'.
	 * @see glml.ModelSpecificAction
	 * @generated
	 */
	EClass getModelSpecificAction();

	/**
	 * Returns the meta object for the reference '{@link glml.ModelSpecificAction#getReification <em>Reification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reification</em>'.
	 * @see glml.ModelSpecificAction#getReification()
	 * @see #getModelSpecificAction()
	 * @generated
	 */
	EReference getModelSpecificAction_Reification();

	/**
	 * Returns the meta object for the reference '{@link glml.ModelSpecificAction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see glml.ModelSpecificAction#getTarget()
	 * @see #getModelSpecificAction()
	 * @generated
	 */
	EReference getModelSpecificAction_Target();

	/**
	 * Returns the meta object for the reference '{@link glml.ModelSpecificAction#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see glml.ModelSpecificAction#getOperation()
	 * @see #getModelSpecificAction()
	 * @generated
	 */
	EReference getModelSpecificAction_Operation();

	/**
	 * Returns the meta object for the reference list '{@link glml.ModelSpecificAction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see glml.ModelSpecificAction#getParameters()
	 * @see #getModelSpecificAction()
	 * @generated
	 */
	EReference getModelSpecificAction_Parameters();

	/**
	 * Returns the meta object for the container reference '{@link glml.ModelSpecificAction#getOwningModelSpecificEvent <em>Owning Model Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Model Specific Event</em>'.
	 * @see glml.ModelSpecificAction#getOwningModelSpecificEvent()
	 * @see #getModelSpecificAction()
	 * @generated
	 */
	EReference getModelSpecificAction_OwningModelSpecificEvent();

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
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
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
		 * The meta object literal for the '<em><b>Model Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT_FILE__MODEL_EVENTS = eINSTANCE.getDomainSpecificEventFile_ModelEvents();

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

		/**
		 * The meta object literal for the '{@link glml.impl.DomainSpecificEventImpl <em>Domain Specific Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.DomainSpecificEventImpl
		 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEvent()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_EVENT = eINSTANCE.getDomainSpecificEvent();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT__CONDITION = eINSTANCE.getDomainSpecificEvent_Condition();

		/**
		 * The meta object literal for the '<em><b>Domain Specific Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT__DOMAIN_SPECIFIC_ACTIONS = eINSTANCE.getDomainSpecificEvent_DomainSpecificActions();

		/**
		 * The meta object literal for the '{@link glml.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.PatternImpl
		 * @see glml.impl.GlmlPackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '{@link glml.impl.IdentityImpl <em>Identity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.IdentityImpl
		 * @see glml.impl.GlmlPackageImpl#getIdentity()
		 * @generated
		 */
		EClass IDENTITY = eINSTANCE.getIdentity();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IDENTITY__ARGUMENT = eINSTANCE.getIdentity_Argument();

		/**
		 * The meta object literal for the '{@link glml.impl.SpatialCoincidenceImpl <em>Spatial Coincidence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.SpatialCoincidenceImpl
		 * @see glml.impl.GlmlPackageImpl#getSpatialCoincidence()
		 * @generated
		 */
		EClass SPATIAL_COINCIDENCE = eINSTANCE.getSpatialCoincidence();

		/**
		 * The meta object literal for the '<em><b>First Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_COINCIDENCE__FIRST_ARGUMENT = eINSTANCE.getSpatialCoincidence_FirstArgument();

		/**
		 * The meta object literal for the '<em><b>Second Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPATIAL_COINCIDENCE__SECOND_ARGUMENT = eINSTANCE.getSpatialCoincidence_SecondArgument();

		/**
		 * The meta object literal for the '{@link glml.impl.DomainSpecificActionImpl <em>Domain Specific Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.DomainSpecificActionImpl
		 * @see glml.impl.GlmlPackageImpl#getDomainSpecificAction()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_ACTION = eINSTANCE.getDomainSpecificAction();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_ACTION__TARGET_CLASS = eINSTANCE.getDomainSpecificAction_TargetClass();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_ACTION__OPERATION = eINSTANCE.getDomainSpecificAction_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_ACTION__PARAMETER_TYPES = eINSTANCE.getDomainSpecificAction_ParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Owning Domain Specific Event</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_ACTION__OWNING_DOMAIN_SPECIFIC_EVENT = eINSTANCE.getDomainSpecificAction_OwningDomainSpecificEvent();

		/**
		 * The meta object literal for the '{@link glml.impl.MocEventImpl <em>Moc Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.MocEventImpl
		 * @see glml.impl.GlmlPackageImpl#getMocEvent()
		 * @generated
		 */
		EClass MOC_EVENT = eINSTANCE.getMocEvent();

		/**
		 * The meta object literal for the '{@link glml.impl.ECLEventImpl <em>ECL Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.ECLEventImpl
		 * @see glml.impl.GlmlPackageImpl#getECLEvent()
		 * @generated
		 */
		EClass ECL_EVENT = eINSTANCE.getECLEvent();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECL_EVENT__ELEMENT = eINSTANCE.getECLEvent_Element();

		/**
		 * The meta object literal for the '{@link glml.impl.ModelSpecificEventImpl <em>Model Specific Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.ModelSpecificEventImpl
		 * @see glml.impl.GlmlPackageImpl#getModelSpecificEvent()
		 * @generated
		 */
		EClass MODEL_SPECIFIC_EVENT = eINSTANCE.getModelSpecificEvent();

		/**
		 * The meta object literal for the '<em><b>Reification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__REIFICATION = eINSTANCE.getModelSpecificEvent_Reification();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__CONDITION = eINSTANCE.getModelSpecificEvent_Condition();

		/**
		 * The meta object literal for the '<em><b>Model Specific Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__MODEL_SPECIFIC_ACTIONS = eINSTANCE.getModelSpecificEvent_ModelSpecificActions();

		/**
		 * The meta object literal for the '{@link glml.impl.ModelSpecificActionImpl <em>Model Specific Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.ModelSpecificActionImpl
		 * @see glml.impl.GlmlPackageImpl#getModelSpecificAction()
		 * @generated
		 */
		EClass MODEL_SPECIFIC_ACTION = eINSTANCE.getModelSpecificAction();

		/**
		 * The meta object literal for the '<em><b>Reification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_ACTION__REIFICATION = eINSTANCE.getModelSpecificAction_Reification();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_ACTION__TARGET = eINSTANCE.getModelSpecificAction_Target();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_ACTION__OPERATION = eINSTANCE.getModelSpecificAction_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_ACTION__PARAMETERS = eINSTANCE.getModelSpecificAction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Owning Model Specific Event</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_ACTION__OWNING_MODEL_SPECIFIC_EVENT = eINSTANCE.getModelSpecificAction_OwningModelSpecificEvent();

	}

} //GlmlPackage
