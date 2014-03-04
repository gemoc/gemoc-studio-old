/**
 * Copyright (c) 2013 Obeo. All Rights Reserved.
 * 
 * This software and the attached documentation are the exclusive ownership
 * of its authors and was conceded to the profit of Obeo SARL.
 * This software and the attached documentation are protected under the rights
 * of intellectual ownership, including the section "Titre II  Droits des auteurs (Articles L121-1 L123-12)"
 * By installing this software, you acknowledge being aware of this rights and
 * accept them, and as a consequence you must:
 * - be in possession of a valid license of use conceded by Obeo only.
 * - agree that you have read, understood, and will comply with the license terms and conditions.
 * - agree not to do anything that could conflict with intellectual ownership owned by Obeo or its beneficiaries
 * or the authors of this software
 * 
 * Should you not agree with these terms, you must stop to use this software and give it back to its legitimate owner.
 */
package fr.obeo.dsl.workspace.workbench.impl;

import fr.obeo.dsl.workspace.WorkspacePackage;
import fr.obeo.dsl.workspace.impl.WorkspacePackageImpl;
import fr.obeo.dsl.workspace.workbench.EditorReference;
import fr.obeo.dsl.workspace.workbench.ViewReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchFactory;
import fr.obeo.dsl.workspace.workbench.WorkbenchPackage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPage;
import fr.obeo.dsl.workspace.workbench.WorkbenchPartReference;
import fr.obeo.dsl.workspace.workbench.WorkbenchRoot;
import fr.obeo.dsl.workspace.workbench.WorkbenchWindow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class WorkbenchPackageImpl extends EPackageImpl implements WorkbenchPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workbenchRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workbenchWindowEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workbenchPageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass workbenchPartReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass editorReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass viewReferenceEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()},
	 * which also performs initialization of the package, or returns the registered package, if one already
	 * exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkbenchPackageImpl() {
		super(eNS_URI, WorkbenchFactory.eINSTANCE);
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
	 * This method is used to initialize {@link WorkbenchPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the
	 * package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkbenchPackage init() {
		if (isInited)
			return (WorkbenchPackage)EPackage.Registry.INSTANCE.getEPackage(WorkbenchPackage.eNS_URI);

		// Obtain or create and register package
		WorkbenchPackageImpl theWorkbenchPackage = (WorkbenchPackageImpl)(EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof WorkbenchPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new WorkbenchPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		WorkspacePackageImpl theWorkspacePackage = (WorkspacePackageImpl)(EPackage.Registry.INSTANCE
				.getEPackage(WorkspacePackage.eNS_URI) instanceof WorkspacePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(WorkspacePackage.eNS_URI)
				: WorkspacePackage.eINSTANCE);

		// Create package meta-data objects
		theWorkbenchPackage.createPackageContents();
		theWorkspacePackage.createPackageContents();

		// Initialize created meta-data
		theWorkbenchPackage.initializePackageContents();
		theWorkspacePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkbenchPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkbenchPackage.eNS_URI, theWorkbenchPackage);
		return theWorkbenchPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkbenchRoot() {
		return workbenchRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchRoot_Windows() {
		return (EReference)workbenchRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchRoot_ActiveWindow() {
		return (EReference)workbenchRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkbenchWindow() {
		return workbenchWindowEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchWindow_Pages() {
		return (EReference)workbenchWindowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchWindow_ActivePage() {
		return (EReference)workbenchWindowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkbenchPage() {
		return workbenchPageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchPage_Editors() {
		return (EReference)workbenchPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchPage_Views() {
		return (EReference)workbenchPageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getWorkbenchPage_ActivePart() {
		return (EReference)workbenchPageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getWorkbenchPartReference() {
		return workbenchPartReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWorkbenchPartReference_Title() {
		return (EAttribute)workbenchPartReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWorkbenchPartReference_TitleToolTip() {
		return (EAttribute)workbenchPartReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWorkbenchPartReference_Id() {
		return (EAttribute)workbenchPartReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getWorkbenchPartReference_Name() {
		return (EAttribute)workbenchPartReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEditorReference() {
		return editorReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getViewReference() {
		return viewReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkbenchFactory getWorkbenchFactory() {
		return (WorkbenchFactory)getEFactoryInstance();
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
		workbenchRootEClass = createEClass(WORKBENCH_ROOT);
		createEReference(workbenchRootEClass, WORKBENCH_ROOT__WINDOWS);
		createEReference(workbenchRootEClass, WORKBENCH_ROOT__ACTIVE_WINDOW);

		workbenchWindowEClass = createEClass(WORKBENCH_WINDOW);
		createEReference(workbenchWindowEClass, WORKBENCH_WINDOW__PAGES);
		createEReference(workbenchWindowEClass, WORKBENCH_WINDOW__ACTIVE_PAGE);

		workbenchPageEClass = createEClass(WORKBENCH_PAGE);
		createEReference(workbenchPageEClass, WORKBENCH_PAGE__EDITORS);
		createEReference(workbenchPageEClass, WORKBENCH_PAGE__VIEWS);
		createEReference(workbenchPageEClass, WORKBENCH_PAGE__ACTIVE_PART);

		workbenchPartReferenceEClass = createEClass(WORKBENCH_PART_REFERENCE);
		createEAttribute(workbenchPartReferenceEClass, WORKBENCH_PART_REFERENCE__TITLE);
		createEAttribute(workbenchPartReferenceEClass, WORKBENCH_PART_REFERENCE__TITLE_TOOL_TIP);
		createEAttribute(workbenchPartReferenceEClass, WORKBENCH_PART_REFERENCE__ID);
		createEAttribute(workbenchPartReferenceEClass, WORKBENCH_PART_REFERENCE__NAME);

		editorReferenceEClass = createEClass(EDITOR_REFERENCE);

		viewReferenceEClass = createEClass(VIEW_REFERENCE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		editorReferenceEClass.getESuperTypes().add(this.getWorkbenchPartReference());
		viewReferenceEClass.getESuperTypes().add(this.getWorkbenchPartReference());

		// Initialize classes and features; add operations and parameters
		initEClass(workbenchRootEClass, WorkbenchRoot.class, "WorkbenchRoot", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkbenchRoot_Windows(), this.getWorkbenchWindow(), null, "windows", null, 0, -1,
				WorkbenchRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchRoot_ActiveWindow(), this.getWorkbenchWindow(), null, "activeWindow",
				null, 0, 1, WorkbenchRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workbenchWindowEClass, WorkbenchWindow.class, "WorkbenchWindow", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkbenchWindow_Pages(), this.getWorkbenchPage(), null, "pages", null, 0, -1,
				WorkbenchWindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchWindow_ActivePage(), this.getWorkbenchPage(), null, "activePage", null, 0,
				1, WorkbenchWindow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workbenchPageEClass, WorkbenchPage.class, "WorkbenchPage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorkbenchPage_Editors(), this.getEditorReference(), null, "editors", null, 0, -1,
				WorkbenchPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPage_Views(), this.getViewReference(), null, "views", null, 0, -1,
				WorkbenchPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorkbenchPage_ActivePart(), this.getWorkbenchPartReference(), null, "activePart",
				null, 0, 1, WorkbenchPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(workbenchPartReferenceEClass, WorkbenchPartReference.class, "WorkbenchPartReference",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWorkbenchPartReference_Title(), ecorePackage.getEString(), "title", null, 0, 1,
				WorkbenchPartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkbenchPartReference_TitleToolTip(), ecorePackage.getEString(), "titleToolTip",
				null, 0, 1, WorkbenchPartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkbenchPartReference_Id(), ecorePackage.getEString(), "id", null, 0, 1,
				WorkbenchPartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorkbenchPartReference_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				WorkbenchPartReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editorReferenceEClass, EditorReference.class, "EditorReference", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(viewReferenceEClass, ViewReference.class, "ViewReference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
	}

} // WorkbenchPackageImpl
