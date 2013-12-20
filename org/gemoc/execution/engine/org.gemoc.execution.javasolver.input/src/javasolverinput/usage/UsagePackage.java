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
	int CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = JavasolverinputPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = JavasolverinputPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = JavasolverinputPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link javasolverinput.usage.impl.PrecedesImpl <em>Precedes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see javasolverinput.usage.impl.PrecedesImpl
	 * @see javasolverinput.usage.impl.UsagePackageImpl#getPrecedes()
	 * @generated
	 */
	int PRECEDES = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Clock1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__CLOCK1 = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Clock2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES__CLOCK2 = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Precedes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Precedes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRECEDES_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;


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
	 * Returns the meta object for class '{@link javasolverinput.usage.Precedes <em>Precedes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Precedes</em>'.
	 * @see javasolverinput.usage.Precedes
	 * @generated
	 */
	EClass getPrecedes();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.usage.Precedes#getClock1 <em>Clock1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock1</em>'.
	 * @see javasolverinput.usage.Precedes#getClock1()
	 * @see #getPrecedes()
	 * @generated
	 */
	EReference getPrecedes_Clock1();

	/**
	 * Returns the meta object for the reference '{@link javasolverinput.usage.Precedes#getClock2 <em>Clock2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Clock2</em>'.
	 * @see javasolverinput.usage.Precedes#getClock2()
	 * @see #getPrecedes()
	 * @generated
	 */
	EReference getPrecedes_Clock2();

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
		 * The meta object literal for the '{@link javasolverinput.usage.impl.PrecedesImpl <em>Precedes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.PrecedesImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getPrecedes()
		 * @generated
		 */
		EClass PRECEDES = eINSTANCE.getPrecedes();

		/**
		 * The meta object literal for the '<em><b>Clock1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECEDES__CLOCK1 = eINSTANCE.getPrecedes_Clock1();

		/**
		 * The meta object literal for the '<em><b>Clock2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRECEDES__CLOCK2 = eINSTANCE.getPrecedes_Clock2();

		/**
		 * The meta object literal for the '{@link javasolverinput.usage.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see javasolverinput.usage.impl.ConstraintImpl
		 * @see javasolverinput.usage.impl.UsagePackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

	}

} //UsagePackage
