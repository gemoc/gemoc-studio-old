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
package fr.obeo.dsl.workspace.workbench;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to
 * represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.workspace.workbench.WorkbenchFactory
 * @model kind="package"
 * @generated
 */
public interface WorkbenchPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "workbench";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/workspace/workbench";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "workbench";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	WorkbenchPackage eINSTANCE = fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl
	 * <em>Root</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchRoot()
	 * @generated
	 */
	int WORKBENCH_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Windows</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_ROOT__WINDOWS = 0;

	/**
	 * The feature id for the '<em><b>Active Window</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_ROOT__ACTIVE_WINDOW = 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_ROOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchWindowImpl
	 * <em>Window</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchWindowImpl
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchWindow()
	 * @generated
	 */
	int WORKBENCH_WINDOW = 1;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_WINDOW__PAGES = 0;

	/**
	 * The feature id for the '<em><b>Active Page</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_WINDOW__ACTIVE_PAGE = 1;

	/**
	 * The number of structural features of the '<em>Window</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_WINDOW_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl
	 * <em>Page</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchPage()
	 * @generated
	 */
	int WORKBENCH_PAGE = 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' containment reference list. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PAGE__EDITORS = 0;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PAGE__VIEWS = 1;

	/**
	 * The feature id for the '<em><b>Active Part</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PAGE__ACTIVE_PART = 2;

	/**
	 * The number of structural features of the '<em>Page</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
	 * <em>Part Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchPartReference()
	 * @generated
	 */
	int WORKBENCH_PART_REFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_REFERENCE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Title Tool Tip</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_REFERENCE__TITLE_TOOL_TIP = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_REFERENCE__ID = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_REFERENCE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Part Reference</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKBENCH_PART_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.impl.EditorReferenceImpl
	 * <em>Editor Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.impl.EditorReferenceImpl
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getEditorReference()
	 * @generated
	 */
	int EDITOR_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_REFERENCE__TITLE = WORKBENCH_PART_REFERENCE__TITLE;

	/**
	 * The feature id for the '<em><b>Title Tool Tip</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_REFERENCE__TITLE_TOOL_TIP = WORKBENCH_PART_REFERENCE__TITLE_TOOL_TIP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_REFERENCE__ID = WORKBENCH_PART_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_REFERENCE__NAME = WORKBENCH_PART_REFERENCE__NAME;

	/**
	 * The number of structural features of the '<em>Editor Reference</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EDITOR_REFERENCE_FEATURE_COUNT = WORKBENCH_PART_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.workspace.workbench.impl.ViewReferenceImpl
	 * <em>View Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.workspace.workbench.impl.ViewReferenceImpl
	 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getViewReference()
	 * @generated
	 */
	int VIEW_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_REFERENCE__TITLE = WORKBENCH_PART_REFERENCE__TITLE;

	/**
	 * The feature id for the '<em><b>Title Tool Tip</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_REFERENCE__TITLE_TOOL_TIP = WORKBENCH_PART_REFERENCE__TITLE_TOOL_TIP;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_REFERENCE__ID = WORKBENCH_PART_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_REFERENCE__NAME = WORKBENCH_PART_REFERENCE__NAME;

	/**
	 * The number of structural features of the '<em>View Reference</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VIEW_REFERENCE_FEATURE_COUNT = WORKBENCH_PART_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot <em>Root</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Root</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchRoot
	 * @generated
	 */
	EClass getWorkbenchRoot();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getWindows <em>Windows</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Windows</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getWindows()
	 * @see #getWorkbenchRoot()
	 * @generated
	 */
	EReference getWorkbenchRoot_Windows();

	/**
	 * Returns the meta object for the reference '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getActiveWindow <em>Active Window</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Active Window</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchRoot#getActiveWindow()
	 * @see #getWorkbenchRoot()
	 * @generated
	 */
	EReference getWorkbenchRoot_ActiveWindow();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchWindow
	 * <em>Window</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Window</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchWindow
	 * @generated
	 */
	EClass getWorkbenchWindow();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchWindow#getPages <em>Pages</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchWindow#getPages()
	 * @see #getWorkbenchWindow()
	 * @generated
	 */
	EReference getWorkbenchWindow_Pages();

	/**
	 * Returns the meta object for the reference '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchWindow#getActivePage <em>Active Page</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Active Page</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchWindow#getActivePage()
	 * @see #getWorkbenchWindow()
	 * @generated
	 */
	EReference getWorkbenchWindow_ActivePage();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPage <em>Page</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Page</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPage
	 * @generated
	 */
	EClass getWorkbenchPage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPage#getEditors <em>Editors</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Editors</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPage#getEditors()
	 * @see #getWorkbenchPage()
	 * @generated
	 */
	EReference getWorkbenchPage_Editors();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPage#getViews <em>Views</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPage#getViews()
	 * @see #getWorkbenchPage()
	 * @generated
	 */
	EReference getWorkbenchPage_Views();

	/**
	 * Returns the meta object for the reference '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPage#getActivePart <em>Active Part</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Active Part</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPage#getActivePart()
	 * @see #getWorkbenchPage()
	 * @generated
	 */
	EReference getWorkbenchPage_ActivePart();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
	 * <em>Part Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Part Reference</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
	 * @generated
	 */
	EClass getWorkbenchPartReference();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitle <em>Title</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitle()
	 * @see #getWorkbenchPartReference()
	 * @generated
	 */
	EAttribute getWorkbenchPartReference_Title();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitleToolTip <em>Title Tool Tip</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Title Tool Tip</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getTitleToolTip()
	 * @see #getWorkbenchPartReference()
	 * @generated
	 */
	EAttribute getWorkbenchPartReference_TitleToolTip();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getId <em>Id</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getId()
	 * @see #getWorkbenchPartReference()
	 * @generated
	 */
	EAttribute getWorkbenchPartReference_Id();

	/**
	 * Returns the meta object for the attribute '
	 * {@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference#getName()
	 * @see #getWorkbenchPartReference()
	 * @generated
	 */
	EAttribute getWorkbenchPartReference_Name();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.EditorReference
	 * <em>Editor Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Editor Reference</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.EditorReference
	 * @generated
	 */
	EClass getEditorReference();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.workspace.workbench.ViewReference
	 * <em>View Reference</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>View Reference</em>'.
	 * @see fr.obeo.dsl.workspace.workbench.ViewReference
	 * @generated
	 */
	EClass getViewReference();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkbenchFactory getWorkbenchFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl
		 * <em>Root</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchRootImpl
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchRoot()
		 * @generated
		 */
		EClass WORKBENCH_ROOT = eINSTANCE.getWorkbenchRoot();

		/**
		 * The meta object literal for the '<em><b>Windows</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_ROOT__WINDOWS = eINSTANCE.getWorkbenchRoot_Windows();

		/**
		 * The meta object literal for the '<em><b>Active Window</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_ROOT__ACTIVE_WINDOW = eINSTANCE.getWorkbenchRoot_ActiveWindow();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchWindowImpl
		 * <em>Window</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchWindowImpl
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchWindow()
		 * @generated
		 */
		EClass WORKBENCH_WINDOW = eINSTANCE.getWorkbenchWindow();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_WINDOW__PAGES = eINSTANCE.getWorkbenchWindow_Pages();

		/**
		 * The meta object literal for the '<em><b>Active Page</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_WINDOW__ACTIVE_PAGE = eINSTANCE.getWorkbenchWindow_ActivePage();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl
		 * <em>Page</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPageImpl
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchPage()
		 * @generated
		 */
		EClass WORKBENCH_PAGE = eINSTANCE.getWorkbenchPage();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_PAGE__EDITORS = eINSTANCE.getWorkbenchPage_Editors();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_PAGE__VIEWS = eINSTANCE.getWorkbenchPage_Views();

		/**
		 * The meta object literal for the '<em><b>Active Part</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKBENCH_PAGE__ACTIVE_PART = eINSTANCE.getWorkbenchPage_ActivePart();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
		 * <em>Part Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.WorkbenchPartReference
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getWorkbenchPartReference()
		 * @generated
		 */
		EClass WORKBENCH_PART_REFERENCE = eINSTANCE.getWorkbenchPartReference();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WORKBENCH_PART_REFERENCE__TITLE = eINSTANCE.getWorkbenchPartReference_Title();

		/**
		 * The meta object literal for the '<em><b>Title Tool Tip</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WORKBENCH_PART_REFERENCE__TITLE_TOOL_TIP = eINSTANCE
				.getWorkbenchPartReference_TitleToolTip();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WORKBENCH_PART_REFERENCE__ID = eINSTANCE.getWorkbenchPartReference_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WORKBENCH_PART_REFERENCE__NAME = eINSTANCE.getWorkbenchPartReference_Name();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.impl.EditorReferenceImpl
		 * <em>Editor Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.impl.EditorReferenceImpl
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getEditorReference()
		 * @generated
		 */
		EClass EDITOR_REFERENCE = eINSTANCE.getEditorReference();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.workspace.workbench.impl.ViewReferenceImpl
		 * <em>View Reference</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.workspace.workbench.impl.ViewReferenceImpl
		 * @see fr.obeo.dsl.workspace.workbench.impl.WorkbenchPackageImpl#getViewReference()
		 * @generated
		 */
		EClass VIEW_REFERENCE = eINSTANCE.getViewReference();

	}

} // WorkbenchPackage
