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
	 * The meta object id for the '{@link glml.impl.DomainSpecificEventImpl <em>Domain Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.DomainSpecificEventImpl
	 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEvent()
	 * @generated
	 */
	int DOMAIN_SPECIFIC_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__TARGET_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Domain Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Domain Specific Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_SPECIFIC_EVENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The meta object id for the '{@link glml.impl.MocRelationImpl <em>Moc Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.MocRelationImpl
	 * @see glml.impl.GlmlPackageImpl#getMocRelation()
	 * @generated
	 */
	int MOC_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_RELATION__ARGUMENTS = 0;

	/**
	 * The number of structural features of the '<em>Moc Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_RELATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Moc Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOC_RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link glml.impl.ExtendedCcslRelationImpl <em>Extended Ccsl Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ExtendedCcslRelationImpl
	 * @see glml.impl.GlmlPackageImpl#getExtendedCcslRelation()
	 * @generated
	 */
	int EXTENDED_CCSL_RELATION = 5;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CCSL_RELATION__ARGUMENTS = MOC_RELATION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CCSL_RELATION__RELATION = MOC_RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extended Ccsl Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CCSL_RELATION_FEATURE_COUNT = MOC_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Extended Ccsl Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CCSL_RELATION_OPERATION_COUNT = MOC_RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link glml.impl.ModelSpecificEventImpl <em>Model Specific Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.ModelSpecificEventImpl
	 * @see glml.impl.GlmlPackageImpl#getModelSpecificEvent()
	 * @generated
	 */
	int MODEL_SPECIFIC_EVENT = 6;

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
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_SPECIFIC_EVENT__CONDITION = NAMED_ELEMENT_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link glml.impl.JavaSolverRelationImpl <em>Java Solver Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see glml.impl.JavaSolverRelationImpl
	 * @see glml.impl.GlmlPackageImpl#getJavaSolverRelation()
	 * @generated
	 */
	int JAVA_SOLVER_RELATION = 7;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_RELATION__ARGUMENTS = MOC_RELATION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_RELATION__RELATION = MOC_RELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Solver Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_RELATION_FEATURE_COUNT = MOC_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Solver Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_RELATION_OPERATION_COUNT = MOC_RELATION_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link glml.DomainSpecificEvent <em>Domain Specific Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Specific Event</em>'.
	 * @see glml.DomainSpecificEvent
	 * @generated
	 */
	EClass getDomainSpecificEvent();

	/**
	 * Returns the meta object for the reference '{@link glml.DomainSpecificEvent#getTargetClass <em>Target Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Class</em>'.
	 * @see glml.DomainSpecificEvent#getTargetClass()
	 * @see #getDomainSpecificEvent()
	 * @generated
	 */
	EReference getDomainSpecificEvent_TargetClass();

	/**
	 * Returns the meta object for the reference list '{@link glml.DomainSpecificEvent#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see glml.DomainSpecificEvent#getOperations()
	 * @see #getDomainSpecificEvent()
	 * @generated
	 */
	EReference getDomainSpecificEvent_Operations();

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
	 * Returns the meta object for class '{@link glml.MocRelation <em>Moc Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moc Relation</em>'.
	 * @see glml.MocRelation
	 * @generated
	 */
	EClass getMocRelation();

	/**
	 * Returns the meta object for the reference list '{@link glml.MocRelation#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see glml.MocRelation#getArguments()
	 * @see #getMocRelation()
	 * @generated
	 */
	EReference getMocRelation_Arguments();

	/**
	 * Returns the meta object for class '{@link glml.ExtendedCcslRelation <em>Extended Ccsl Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Ccsl Relation</em>'.
	 * @see glml.ExtendedCcslRelation
	 * @generated
	 */
	EClass getExtendedCcslRelation();

	/**
	 * Returns the meta object for the reference '{@link glml.ExtendedCcslRelation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relation</em>'.
	 * @see glml.ExtendedCcslRelation#getRelation()
	 * @see #getExtendedCcslRelation()
	 * @generated
	 */
	EReference getExtendedCcslRelation_Relation();

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
	 * Returns the meta object for the reference '{@link glml.ModelSpecificEvent#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see glml.ModelSpecificEvent#getTarget()
	 * @see #getModelSpecificEvent()
	 * @generated
	 */
	EReference getModelSpecificEvent_Target();

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
	 * Returns the meta object for class '{@link glml.JavaSolverRelation <em>Java Solver Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Solver Relation</em>'.
	 * @see glml.JavaSolverRelation
	 * @generated
	 */
	EClass getJavaSolverRelation();

	/**
	 * Returns the meta object for the reference '{@link glml.JavaSolverRelation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relation</em>'.
	 * @see glml.JavaSolverRelation#getRelation()
	 * @see #getJavaSolverRelation()
	 * @generated
	 */
	EReference getJavaSolverRelation_Relation();

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
		 * The meta object literal for the '{@link glml.impl.DomainSpecificEventImpl <em>Domain Specific Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.DomainSpecificEventImpl
		 * @see glml.impl.GlmlPackageImpl#getDomainSpecificEvent()
		 * @generated
		 */
		EClass DOMAIN_SPECIFIC_EVENT = eINSTANCE.getDomainSpecificEvent();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT__TARGET_CLASS = eINSTANCE.getDomainSpecificEvent_TargetClass();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT__OPERATIONS = eINSTANCE.getDomainSpecificEvent_Operations();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_SPECIFIC_EVENT__CONDITION = eINSTANCE.getDomainSpecificEvent_Condition();

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
		 * The meta object literal for the '{@link glml.impl.MocRelationImpl <em>Moc Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.MocRelationImpl
		 * @see glml.impl.GlmlPackageImpl#getMocRelation()
		 * @generated
		 */
		EClass MOC_RELATION = eINSTANCE.getMocRelation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MOC_RELATION__ARGUMENTS = eINSTANCE.getMocRelation_Arguments();

		/**
		 * The meta object literal for the '{@link glml.impl.ExtendedCcslRelationImpl <em>Extended Ccsl Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.ExtendedCcslRelationImpl
		 * @see glml.impl.GlmlPackageImpl#getExtendedCcslRelation()
		 * @generated
		 */
		EClass EXTENDED_CCSL_RELATION = eINSTANCE.getExtendedCcslRelation();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CCSL_RELATION__RELATION = eINSTANCE.getExtendedCcslRelation_Relation();

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
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__TARGET = eINSTANCE.getModelSpecificEvent_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_SPECIFIC_EVENT__CONDITION = eINSTANCE.getModelSpecificEvent_Condition();

		/**
		 * The meta object literal for the '{@link glml.impl.JavaSolverRelationImpl <em>Java Solver Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see glml.impl.JavaSolverRelationImpl
		 * @see glml.impl.GlmlPackageImpl#getJavaSolverRelation()
		 * @generated
		 */
		EClass JAVA_SOLVER_RELATION = eINSTANCE.getJavaSolverRelation();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SOLVER_RELATION__RELATION = eINSTANCE.getJavaSolverRelation_Relation();

	}

} //GlmlPackage
