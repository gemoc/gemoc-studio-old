/**
 */
package javasolverinput.impl;

import javasolverinput.JavaSolverInputFile;
import javasolverinput.JavasolverinputFactory;
import javasolverinput.JavasolverinputPackage;
import javasolverinput.NamedElement;

import javasolverinput.usage.UsagePackage;

import javasolverinput.usage.impl.UsagePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
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
public class JavasolverinputPackageImpl extends EPackageImpl implements JavasolverinputPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaSolverInputFileEClass = null;

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
	 * @see javasolverinput.JavasolverinputPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavasolverinputPackageImpl() {
		super(eNS_URI, JavasolverinputFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JavasolverinputPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavasolverinputPackage init() {
		if (isInited) return (JavasolverinputPackage)EPackage.Registry.INSTANCE.getEPackage(JavasolverinputPackage.eNS_URI);

		// Obtain or create and register package
		JavasolverinputPackageImpl theJavasolverinputPackage = (JavasolverinputPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavasolverinputPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavasolverinputPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		UsagePackageImpl theUsagePackage = (UsagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI) instanceof UsagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI) : UsagePackage.eINSTANCE);

		// Create package meta-data objects
		theJavasolverinputPackage.createPackageContents();
		theUsagePackage.createPackageContents();

		// Initialize created meta-data
		theJavasolverinputPackage.initializePackageContents();
		theUsagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavasolverinputPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavasolverinputPackage.eNS_URI, theJavasolverinputPackage);
		return theJavasolverinputPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaSolverInputFile() {
		return javaSolverInputFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaSolverInputFile_ClockDeclarations() {
		return (EReference)javaSolverInputFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaSolverInputFile_Constraints() {
		return (EReference)javaSolverInputFileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavasolverinputFactory getJavasolverinputFactory() {
		return (JavasolverinputFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		javaSolverInputFileEClass = createEClass(JAVA_SOLVER_INPUT_FILE);
		createEReference(javaSolverInputFileEClass, JAVA_SOLVER_INPUT_FILE__CLOCK_DECLARATIONS);
		createEReference(javaSolverInputFileEClass, JAVA_SOLVER_INPUT_FILE__CONSTRAINTS);
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
		UsagePackage theUsagePackage = (UsagePackage)EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theUsagePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		javaSolverInputFileEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", "", 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaSolverInputFileEClass, JavaSolverInputFile.class, "JavaSolverInputFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaSolverInputFile_ClockDeclarations(), theUsagePackage.getClock(), null, "clockDeclarations", null, 0, -1, JavaSolverInputFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaSolverInputFile_Constraints(), theUsagePackage.getConstraint(), null, "constraints", null, 0, -1, JavaSolverInputFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //JavasolverinputPackageImpl
