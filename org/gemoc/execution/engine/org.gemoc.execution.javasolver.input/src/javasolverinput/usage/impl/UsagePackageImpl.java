/**
 */
package javasolverinput.usage.impl;

import javasolverinput.JavasolverinputPackage;

import javasolverinput.impl.JavasolverinputPackageImpl;

import javasolverinput.usage.Clock;
import javasolverinput.usage.Constraint;
import javasolverinput.usage.Precedes;
import javasolverinput.usage.UsageFactory;
import javasolverinput.usage.UsagePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsagePackageImpl extends EPackageImpl implements UsagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass precedesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see javasolverinput.usage.UsagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UsagePackageImpl() {
		super(eNS_URI, UsageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UsagePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UsagePackage init() {
		if (isInited) return (UsagePackage)EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI);

		// Obtain or create and register package
		UsagePackageImpl theUsagePackage = (UsagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UsagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UsagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		JavasolverinputPackageImpl theJavasolverinputPackage = (JavasolverinputPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(JavasolverinputPackage.eNS_URI) instanceof JavasolverinputPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(JavasolverinputPackage.eNS_URI) : JavasolverinputPackage.eINSTANCE);

		// Create package meta-data objects
		theUsagePackage.createPackageContents();
		theJavasolverinputPackage.createPackageContents();

		// Initialize created meta-data
		theUsagePackage.initializePackageContents();
		theJavasolverinputPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUsagePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UsagePackage.eNS_URI, theUsagePackage);
		return theUsagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClock() {
		return clockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrecedes() {
		return precedesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrecedes_Clock1() {
		return (EReference)precedesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrecedes_Clock2() {
		return (EReference)precedesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageFactory getUsageFactory() {
		return (UsageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		clockEClass = createEClass(CLOCK);

		precedesEClass = createEClass(PRECEDES);
		createEReference(precedesEClass, PRECEDES__CLOCK1);
		createEReference(precedesEClass, PRECEDES__CLOCK2);

		constraintEClass = createEClass(CONSTRAINT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		JavasolverinputPackage theJavasolverinputPackage = (JavasolverinputPackage)EPackage.Registry.INSTANCE.getEPackage(JavasolverinputPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		clockEClass.getESuperTypes().add(theJavasolverinputPackage.getNamedElement());
		precedesEClass.getESuperTypes().add(this.getConstraint());
		constraintEClass.getESuperTypes().add(theJavasolverinputPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(clockEClass, Clock.class, "Clock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(precedesEClass, Precedes.class, "Precedes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrecedes_Clock1(), this.getClock(), null, "clock1", null, 1, 1, Precedes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrecedes_Clock2(), this.getClock(), null, "clock2", null, 1, 1, Precedes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //UsagePackageImpl
