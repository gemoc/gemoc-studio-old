/**
 */
package fr.obeo.dsl.processworkspace.impl;

import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspaceFactory;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProcessworkspacePackageImpl extends EPackageImpl implements ProcessworkspacePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass fileVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass folderVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass windowVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass pageVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass partVariableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()},
	 * which also performs initialization of the package, or returns the registered package, if one already
	 * exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.obeo.dsl.processworkspace.ProcessworkspacePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessworkspacePackageImpl() {
		super(eNS_URI, ProcessworkspaceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it
	 * depends.
	 * <p>
	 * This method is used to initialize {@link ProcessworkspacePackage#eINSTANCE} when that field is
	 * accessed. Clients should not invoke it directly. Instead, they should simply access that field to
	 * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ProcessworkspacePackage init() {
		if (isInited)
			return (ProcessworkspacePackage)EPackage.Registry.INSTANCE
					.getEPackage(ProcessworkspacePackage.eNS_URI);

		// Obtain or create and register package
		ProcessworkspacePackageImpl theProcessworkspacePackage = (ProcessworkspacePackageImpl)(EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ProcessworkspacePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ProcessworkspacePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ProcessPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theProcessworkspacePackage.createPackageContents();

		// Initialize created meta-data
		theProcessworkspacePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theProcessworkspacePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ProcessworkspacePackage.eNS_URI, theProcessworkspacePackage);
		return theProcessworkspacePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFileVariable() {
		return fileVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFolderVariable() {
		return folderVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectVariable() {
		return projectVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWindowVariable() {
		return windowVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPageVariable() {
		return pageVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPartVariable() {
		return partVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessworkspaceFactory getProcessworkspaceFactory() {
		return (ProcessworkspaceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		fileVariableEClass = createEClass(FILE_VARIABLE);

		folderVariableEClass = createEClass(FOLDER_VARIABLE);

		projectVariableEClass = createEClass(PROJECT_VARIABLE);

		windowVariableEClass = createEClass(WINDOW_VARIABLE);

		pageVariableEClass = createEClass(PAGE_VARIABLE);

		partVariableEClass = createEClass(PART_VARIABLE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect
	 * on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ProcessPackage theProcessPackage = (ProcessPackage)EPackage.Registry.INSTANCE
				.getEPackage(ProcessPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fileVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());
		folderVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());
		projectVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());
		windowVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());
		pageVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());
		partVariableEClass.getESuperTypes().add(theProcessPackage.getProcessVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(fileVariableEClass, FileVariable.class, "FileVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(folderVariableEClass, FolderVariable.class, "FolderVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(projectVariableEClass, ProjectVariable.class, "ProjectVariable", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(windowVariableEClass, WindowVariable.class, "WindowVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageVariableEClass, PageVariable.class, "PageVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(partVariableEClass, PartVariable.class, "PartVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // ProcessworkspacePackageImpl
