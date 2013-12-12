/**
 */
package javasolverinput.creation;

import javasolverinput.JavasolverinputPackage;

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
 * @see javasolverinput.creation.CreationFactory
 * @model kind="package"
 * @generated
 */
public interface CreationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "creation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://gemoc.org/javasolverinput/creation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "creation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CreationPackage eINSTANCE = javasolverinput.creation.impl.CreationPackageImpl.init();

	/**
	 * The meta object id for the '{@link javasolverinput.creation.impl.RelationDeclarationImpl <em>Relation Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.creation.impl.RelationDeclarationImpl
	 * @see javasolverinput.creation.impl.CreationPackageImpl#getRelationDeclaration()
	 * @generated
	 */
	int RELATION_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__NAME = JavasolverinputPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__PARAMETERS = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION__DEFINITION = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION_FEATURE_COUNT = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relation Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DECLARATION_OPERATION_COUNT = JavasolverinputPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.creation.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.creation.impl.ParameterImpl
	 * @see javasolverinput.creation.impl.CreationPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = JavasolverinputPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = JavasolverinputPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.creation.impl.RelationDefinitionImpl <em>Relation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.creation.impl.RelationDefinitionImpl
	 * @see javasolverinput.creation.impl.CreationPackageImpl#getRelationDefinition()
	 * @generated
	 */
	int RELATION_DEFINITION = 2;

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
	 * Returns the meta object for class '{@link javasolverinput.creation.RelationDeclaration <em>Relation Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Declaration</em>'.
	 * @see javasolverinput.creation.RelationDeclaration
	 * @generated
	 */
	EClass getRelationDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.creation.RelationDeclaration#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see javasolverinput.creation.RelationDeclaration#getParameters()
	 * @see #getRelationDeclaration()
	 * @generated
	 */
	EReference getRelationDeclaration_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link javasolverinput.creation.RelationDeclaration#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see javasolverinput.creation.RelationDeclaration#getDefinition()
	 * @see #getRelationDeclaration()
	 * @generated
	 */
	EReference getRelationDeclaration_Definition();

	/**
	 * Returns the meta object for class '{@link javasolverinput.creation.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see javasolverinput.creation.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.creation.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see javasolverinput.creation.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link javasolverinput.creation.RelationDefinition <em>Relation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Definition</em>'.
	 * @see javasolverinput.creation.RelationDefinition
	 * @generated
	 */
	EClass getRelationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link javasolverinput.creation.RelationDefinition#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see javasolverinput.creation.RelationDefinition#getConstraints()
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
	CreationFactory getCreationFactory();

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
		 * The meta object literal for the '{@link javasolverinput.creation.impl.RelationDeclarationImpl <em>Relation Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.creation.impl.RelationDeclarationImpl
		 * @see javasolverinput.creation.impl.CreationPackageImpl#getRelationDeclaration()
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
		 * The meta object literal for the '{@link javasolverinput.creation.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.creation.impl.ParameterImpl
		 * @see javasolverinput.creation.impl.CreationPackageImpl#getParameter()
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
		 * The meta object literal for the '{@link javasolverinput.creation.impl.RelationDefinitionImpl <em>Relation Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.creation.impl.RelationDefinitionImpl
		 * @see javasolverinput.creation.impl.CreationPackageImpl#getRelationDefinition()
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

} //CreationPackage
