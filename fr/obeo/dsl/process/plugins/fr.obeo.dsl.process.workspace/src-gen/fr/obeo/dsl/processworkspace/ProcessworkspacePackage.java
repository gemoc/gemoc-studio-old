/**
 */
package fr.obeo.dsl.processworkspace;

import fr.obeo.dsl.process.ProcessPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see fr.obeo.dsl.processworkspace.ProcessworkspaceFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessworkspacePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "processworkspace";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/processworkspace";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "processworkspace";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ProcessworkspacePackage eINSTANCE = fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.FileVariableImpl
	 * <em>File Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.FileVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getFileVariable()
	 * @generated
	 */
	int FILE_VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>File Variable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.FolderVariableImpl
	 * <em>Folder Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.FolderVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getFolderVariable()
	 * @generated
	 */
	int FOLDER_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>Folder Variable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FOLDER_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.ProjectVariableImpl
	 * <em>Project Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.ProjectVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getProjectVariable()
	 * @generated
	 */
	int PROJECT_VARIABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>Project Variable</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.WindowVariableImpl
	 * <em>Window Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.WindowVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getWindowVariable()
	 * @generated
	 */
	int WINDOW_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>Window Variable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOW_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.PageVariableImpl
	 * <em>Page Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.PageVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getPageVariable()
	 * @generated
	 */
	int PAGE_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>Page Variable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PAGE_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.processworkspace.impl.PartVariableImpl
	 * <em>Part Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.processworkspace.impl.PartVariableImpl
	 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getPartVariable()
	 * @generated
	 */
	int PART_VARIABLE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART_VARIABLE__NAME = ProcessPackage.PROCESS_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Written By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART_VARIABLE__WRITTEN_BY = ProcessPackage.PROCESS_VARIABLE__WRITTEN_BY;

	/**
	 * The feature id for the '<em><b>Observed By</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART_VARIABLE__OBSERVED_BY = ProcessPackage.PROCESS_VARIABLE__OBSERVED_BY;

	/**
	 * The number of structural features of the '<em>Part Variable</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PART_VARIABLE_FEATURE_COUNT = ProcessPackage.PROCESS_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.FileVariable
	 * <em>File Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>File Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.FileVariable
	 * @generated
	 */
	EClass getFileVariable();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.FolderVariable
	 * <em>Folder Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Folder Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.FolderVariable
	 * @generated
	 */
	EClass getFolderVariable();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.ProjectVariable
	 * <em>Project Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.ProjectVariable
	 * @generated
	 */
	EClass getProjectVariable();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.WindowVariable
	 * <em>Window Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Window Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.WindowVariable
	 * @generated
	 */
	EClass getWindowVariable();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.PageVariable
	 * <em>Page Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Page Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.PageVariable
	 * @generated
	 */
	EClass getPageVariable();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.processworkspace.PartVariable
	 * <em>Part Variable</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Part Variable</em>'.
	 * @see fr.obeo.dsl.processworkspace.PartVariable
	 * @generated
	 */
	EClass getPartVariable();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessworkspaceFactory getProcessworkspaceFactory();

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
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.FileVariableImpl
		 * <em>File Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.FileVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getFileVariable()
		 * @generated
		 */
		EClass FILE_VARIABLE = eINSTANCE.getFileVariable();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.FolderVariableImpl
		 * <em>Folder Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.FolderVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getFolderVariable()
		 * @generated
		 */
		EClass FOLDER_VARIABLE = eINSTANCE.getFolderVariable();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.ProjectVariableImpl
		 * <em>Project Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.ProjectVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getProjectVariable()
		 * @generated
		 */
		EClass PROJECT_VARIABLE = eINSTANCE.getProjectVariable();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.WindowVariableImpl
		 * <em>Window Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.WindowVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getWindowVariable()
		 * @generated
		 */
		EClass WINDOW_VARIABLE = eINSTANCE.getWindowVariable();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.PageVariableImpl
		 * <em>Page Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.PageVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getPageVariable()
		 * @generated
		 */
		EClass PAGE_VARIABLE = eINSTANCE.getPageVariable();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.processworkspace.impl.PartVariableImpl
		 * <em>Part Variable</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.processworkspace.impl.PartVariableImpl
		 * @see fr.obeo.dsl.processworkspace.impl.ProcessworkspacePackageImpl#getPartVariable()
		 * @generated
		 */
		EClass PART_VARIABLE = eINSTANCE.getPartVariable();

	}

} // ProcessworkspacePackage
