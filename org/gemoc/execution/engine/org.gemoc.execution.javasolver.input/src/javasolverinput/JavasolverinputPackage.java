/**
 */
package javasolverinput;

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
 * @see javasolverinput.JavasolverinputFactory
 * @model kind="package"
 * @generated
 */
public interface JavasolverinputPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javasolverinput";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://javasolverinput/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "javasolverinput";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavasolverinputPackage eINSTANCE = javasolverinput.impl.JavasolverinputPackageImpl.init();

	/**
	 * The meta object id for the '{@link javasolverinput.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.NamedElementImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

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
	 * The meta object id for the '{@link javasolverinput.impl.JavaSolverInputFileImpl <em>Java Solver Input File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.JavaSolverInputFileImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getJavaSolverInputFile()
	 * @generated
	 */
	int JAVA_SOLVER_INPUT_FILE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Clock Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE__CONSTRAINTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relation Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE__RELATION_DECLARATIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Java Solver Input File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Java Solver Input File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_SOLVER_INPUT_FILE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.ConstraintImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.BootstrappedConstraintImpl <em>Bootstrapped Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.BootstrappedConstraintImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getBootstrappedConstraint()
	 * @generated
	 */
	int BOOTSTRAPPED_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT__ARGUMENTS = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bootstrapped Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Bootstrapped Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.BootStrappedConstraintArgumentImpl <em>Boot Strapped Constraint Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.BootStrappedConstraintArgumentImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getBootStrappedConstraintArgument()
	 * @generated
	 */
	int BOOT_STRAPPED_CONSTRAINT_ARGUMENT = 3;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOT_STRAPPED_CONSTRAINT_ARGUMENT__PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Boot Strapped Constraint Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOT_STRAPPED_CONSTRAINT_ARGUMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Boot Strapped Constraint Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOT_STRAPPED_CONSTRAINT_ARGUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.PrecedesImpl <em>Precedes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.PrecedesImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getPrecedes()
	 * @generated
	 */
	int PRECEDES = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__NAME = BOOTSTRAPPED_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__ARGUMENTS = BOOTSTRAPPED_CONSTRAINT__ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Precedes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES_FEATURE_COUNT = BOOTSTRAPPED_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Precedes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES_OPERATION_COUNT = BOOTSTRAPPED_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.ClockImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.CustomConstraintImpl <em>Custom Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.CustomConstraintImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getCustomConstraint()
	 * @generated
	 */
	int CUSTOM_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__TYPE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__ARGUMENTS = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Custom Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Custom Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.RelationDeclarationImpl <em>Relation Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.RelationDeclarationImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getRelationDeclaration()
	 * @generated
	 */
	int RELATION_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__DEFINITION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relation Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.ParameterImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.impl.RelationDefinitionImpl <em>Relation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.impl.RelationDefinitionImpl
	 * @see javasolverinput.impl.JavasolverinputPackageImpl#getRelationDefinition()
	 * @generated
	 */
	int RELATION_DEFINITION = 10;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DEFINITION__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Relation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DEFINITION_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link javasolverinput.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see javasolverinput.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link javasolverinput.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see javasolverinput.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link javasolverinput.JavaSolverInputFile <em>Java Solver Input File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Solver Input File</em>'.
	 * @see javasolverinput.JavaSolverInputFile
	 * @generated
	 */
	EClass getJavaSolverInputFile();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.JavaSolverInputFile#getClockDeclarations <em>Clock Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Clock Declarations</em>'.
	 * @see javasolverinput.JavaSolverInputFile#getClockDeclarations()
	 * @see #getJavaSolverInputFile()
	 * @generated
	 */
	EReference getJavaSolverInputFile_ClockDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.JavaSolverInputFile#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see javasolverinput.JavaSolverInputFile#getConstraints()
	 * @see #getJavaSolverInputFile()
	 * @generated
	 */
	EReference getJavaSolverInputFile_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.JavaSolverInputFile#getRelationDeclarations <em>Relation Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relation Declarations</em>'.
	 * @see javasolverinput.JavaSolverInputFile#getRelationDeclarations()
	 * @see #getJavaSolverInputFile()
	 * @generated
	 */
	EReference getJavaSolverInputFile_RelationDeclarations();

	/**
	 * Returns the meta object for class '{@link javasolverinput.BootstrappedConstraint <em>Bootstrapped Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bootstrapped Constraint</em>'.
	 * @see javasolverinput.BootstrappedConstraint
	 * @generated
	 */
	EClass getBootstrappedConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.BootstrappedConstraint#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see javasolverinput.BootstrappedConstraint#getArguments()
	 * @see #getBootstrappedConstraint()
	 * @generated
	 */
	EReference getBootstrappedConstraint_Arguments();

	/**
	 * Returns the meta object for class '{@link javasolverinput.BootStrappedConstraintArgument <em>Boot Strapped Constraint Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boot Strapped Constraint Argument</em>'.
	 * @see javasolverinput.BootStrappedConstraintArgument
	 * @generated
	 */
	EClass getBootStrappedConstraintArgument();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.BootStrappedConstraintArgument#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see javasolverinput.BootStrappedConstraintArgument#getParameter()
	 * @see #getBootStrappedConstraintArgument()
	 * @generated
	 */
	EReference getBootStrappedConstraintArgument_Parameter();

	/**
	 * Returns the meta object for class '{@link javasolverinput.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see javasolverinput.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for class '{@link javasolverinput.Precedes <em>Precedes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedes</em>'.
	 * @see javasolverinput.Precedes
	 * @generated
	 */
	EClass getPrecedes();

	/**
	 * Returns the meta object for class '{@link javasolverinput.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see javasolverinput.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for class '{@link javasolverinput.CustomConstraint <em>Custom Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Constraint</em>'.
	 * @see javasolverinput.CustomConstraint
	 * @generated
	 */
	EClass getCustomConstraint();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.CustomConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see javasolverinput.CustomConstraint#getType()
	 * @see #getCustomConstraint()
	 * @generated
	 */
	EReference getCustomConstraint_Type();

	/**
	 * Returns the meta object for the reference list '{@link javasolverinput.CustomConstraint#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see javasolverinput.CustomConstraint#getArguments()
	 * @see #getCustomConstraint()
	 * @generated
	 */
	EReference getCustomConstraint_Arguments();

	/**
	 * Returns the meta object for class '{@link javasolverinput.RelationDeclaration <em>Relation Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Declaration</em>'.
	 * @see javasolverinput.RelationDeclaration
	 * @generated
	 */
	EClass getRelationDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.RelationDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see javasolverinput.RelationDeclaration#getParameters()
	 * @see #getRelationDeclaration()
	 * @generated
	 */
	EReference getRelationDeclaration_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link javasolverinput.RelationDeclaration#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see javasolverinput.RelationDeclaration#getDefinition()
	 * @see #getRelationDeclaration()
	 * @generated
	 */
	EReference getRelationDeclaration_Definition();

	/**
	 * Returns the meta object for class '{@link javasolverinput.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see javasolverinput.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see javasolverinput.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link javasolverinput.RelationDefinition <em>Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Definition</em>'.
	 * @see javasolverinput.RelationDefinition
	 * @generated
	 */
	EClass getRelationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.RelationDefinition#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see javasolverinput.RelationDefinition#getConstraints()
	 * @see #getRelationDefinition()
	 * @generated
	 */
	EReference getRelationDefinition_Constraints();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavasolverinputFactory getJavasolverinputFactory();

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
		 * The meta object literal for the '{@link javasolverinput.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.NamedElementImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link javasolverinput.impl.JavaSolverInputFileImpl <em>Java Solver Input File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.JavaSolverInputFileImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getJavaSolverInputFile()
		 * @generated
		 */
		EClass JAVA_SOLVER_INPUT_FILE = eINSTANCE.getJavaSolverInputFile();

		/**
		 * The meta object literal for the '<em><b>Clock Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS = eINSTANCE.getJavaSolverInputFile_ClockDeclarations();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SOLVER_INPUT_FILE__CONSTRAINTS = eINSTANCE.getJavaSolverInputFile_Constraints();

		/**
		 * The meta object literal for the '<em><b>Relation Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_SOLVER_INPUT_FILE__RELATION_DECLARATIONS = eINSTANCE.getJavaSolverInputFile_RelationDeclarations();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.BootstrappedConstraintImpl <em>Bootstrapped Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.BootstrappedConstraintImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getBootstrappedConstraint()
		 * @generated
		 */
		EClass BOOTSTRAPPED_CONSTRAINT = eINSTANCE.getBootstrappedConstraint();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOTSTRAPPED_CONSTRAINT__ARGUMENTS = eINSTANCE.getBootstrappedConstraint_Arguments();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.BootStrappedConstraintArgumentImpl <em>Boot Strapped Constraint Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.BootStrappedConstraintArgumentImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getBootStrappedConstraintArgument()
		 * @generated
		 */
		EClass BOOT_STRAPPED_CONSTRAINT_ARGUMENT = eINSTANCE.getBootStrappedConstraintArgument();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOT_STRAPPED_CONSTRAINT_ARGUMENT__PARAMETER = eINSTANCE.getBootStrappedConstraintArgument_Parameter();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.ConstraintImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.PrecedesImpl <em>Precedes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.PrecedesImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getPrecedes()
		 * @generated
		 */
		EClass PRECEDES = eINSTANCE.getPrecedes();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.ClockImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getClock()
		 * @generated
		 */
		EClass CLOCK = eINSTANCE.getClock();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.CustomConstraintImpl <em>Custom Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.CustomConstraintImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getCustomConstraint()
		 * @generated
		 */
		EClass CUSTOM_CONSTRAINT = eINSTANCE.getCustomConstraint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_CONSTRAINT__TYPE = eINSTANCE.getCustomConstraint_Type();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_CONSTRAINT__ARGUMENTS = eINSTANCE.getCustomConstraint_Arguments();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.RelationDeclarationImpl <em>Relation Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.RelationDeclarationImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getRelationDeclaration()
		 * @generated
		 */
		EClass RELATION_DECLARATION = eINSTANCE.getRelationDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DECLARATION__PARAMETERS = eINSTANCE.getRelationDeclaration_Parameters();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DECLARATION__DEFINITION = eINSTANCE.getRelationDeclaration_Definition();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.ParameterImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link javasolverinput.impl.RelationDefinitionImpl <em>Relation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.impl.RelationDefinitionImpl
		 * @see javasolverinput.impl.JavasolverinputPackageImpl#getRelationDefinition()
		 * @generated
		 */
		EClass RELATION_DEFINITION = eINSTANCE.getRelationDefinition();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DEFINITION__CONSTRAINTS = eINSTANCE.getRelationDefinition_Constraints();

	}

} //JavasolverinputPackage
