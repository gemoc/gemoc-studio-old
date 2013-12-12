/**
 */
package javasolverinput.usage;

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
 * @see javasolverinput.usage.UsageFactory
 * @model kind="package"
 * @generated
 */
public interface UsagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "usage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://gemoc.org/javasolverinput/usage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "usage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsagePackage eINSTANCE = javasolverinput.usage.impl.UsagePackageImpl.init();

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.ClockImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__NAME = JavasolverinputPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_FEATURE_COUNT = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_OPERATION_COUNT = JavasolverinputPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.ConstraintImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = JavasolverinputPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ARGUMENTS = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = JavasolverinputPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.CustomConstraintImpl <em>Custom Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.CustomConstraintImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getCustomConstraint()
	 * @generated
	 */
	int CUSTOM_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__ARGUMENTS = CONSTRAINT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT__TYPE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Custom Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Custom Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.BootstrappedConstraintImpl <em>Bootstrapped Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.BootstrappedConstraintImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getBootstrappedConstraint()
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
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT__ARGUMENTS = CONSTRAINT__ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Bootstrapped Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bootstrapped Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOTSTRAPPED_CONSTRAINT_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.OnceImpl <em>Once</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.OnceImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getOnce()
	 * @generated
	 */
	int ONCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__NAME = BOOTSTRAPPED_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__ARGUMENTS = BOOTSTRAPPED_CONSTRAINT__ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_FEATURE_COUNT = BOOTSTRAPPED_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_OPERATION_COUNT = BOOTSTRAPPED_CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.PrecedesImpl <em>Precedes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.PrecedesImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getPrecedes()
	 * @generated
	 */
	int PRECEDES = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__NAME = BOOTSTRAPPED_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
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
	 * Returns the meta object for class '{@link javasolverinput.usage.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see javasolverinput.usage.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for class '{@link javasolverinput.usage.CustomConstraint <em>Custom Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Constraint</em>'.
	 * @see javasolverinput.usage.CustomConstraint
	 * @generated
	 */
	EClass getCustomConstraint();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.usage.CustomConstraint#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see javasolverinput.usage.CustomConstraint#getType()
	 * @see #getCustomConstraint()
	 * @generated
	 */
	EReference getCustomConstraint_Type();

	/**
	 * Returns the meta object for class '{@link javasolverinput.usage.BootstrappedConstraint <em>Bootstrapped Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bootstrapped Constraint</em>'.
	 * @see javasolverinput.usage.BootstrappedConstraint
	 * @generated
	 */
	EClass getBootstrappedConstraint();

	/**
	 * Returns the meta object for class '{@link javasolverinput.usage.Once <em>Once</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Once</em>'.
	 * @see javasolverinput.usage.Once
	 * @generated
	 */
	EClass getOnce();

	/**
	 * Returns the meta object for class '{@link javasolverinput.usage.Precedes <em>Precedes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedes</em>'.
	 * @see javasolverinput.usage.Precedes
	 * @generated
	 */
	EClass getPrecedes();

	/**
	 * Returns the meta object for class '{@link javasolverinput.usage.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see javasolverinput.usage.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference list '{@link javasolverinput.usage.Constraint#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see javasolverinput.usage.Constraint#getArguments()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Arguments();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UsageFactory getUsageFactory();

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
		 * The meta object literal for the '{@link javasolverinput.usage.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.ClockImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getClock()
		 * @generated
		 */
		EClass CLOCK = eINSTANCE.getClock();

		/**
		 * The meta object literal for the '{@link javasolverinput.usage.impl.CustomConstraintImpl <em>Custom Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.CustomConstraintImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getCustomConstraint()
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
		 * The meta object literal for the '{@link javasolverinput.usage.impl.BootstrappedConstraintImpl <em>Bootstrapped Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.BootstrappedConstraintImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getBootstrappedConstraint()
		 * @generated
		 */
		EClass BOOTSTRAPPED_CONSTRAINT = eINSTANCE.getBootstrappedConstraint();

		/**
		 * The meta object literal for the '{@link javasolverinput.usage.impl.OnceImpl <em>Once</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.OnceImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getOnce()
		 * @generated
		 */
		EClass ONCE = eINSTANCE.getOnce();

		/**
		 * The meta object literal for the '{@link javasolverinput.usage.impl.PrecedesImpl <em>Precedes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.PrecedesImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getPrecedes()
		 * @generated
		 */
		EClass PRECEDES = eINSTANCE.getPrecedes();

		/**
		 * The meta object literal for the '{@link javasolverinput.usage.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.ConstraintImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__ARGUMENTS = eINSTANCE.getConstraint_Arguments();

	}

} //UsagePackage
