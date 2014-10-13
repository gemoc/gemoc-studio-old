/**
 */
package fr.obeo.dsl.processworkspace.impl;

import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspaceFactory;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ProcessworkspaceFactoryImpl extends EFactoryImpl implements ProcessworkspaceFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ProcessworkspaceFactory init() {
		try {
			ProcessworkspaceFactory theProcessworkspaceFactory = (ProcessworkspaceFactory)EPackage.Registry.INSTANCE
					.getEFactory("http://www.obeo.fr/dsl/processworkspace");
			if (theProcessworkspaceFactory != null) {
				return theProcessworkspaceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ProcessworkspaceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessworkspaceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ProcessworkspacePackage.FILE_VARIABLE:
				return createFileVariable();
			case ProcessworkspacePackage.FOLDER_VARIABLE:
				return createFolderVariable();
			case ProcessworkspacePackage.PROJECT_VARIABLE:
				return createProjectVariable();
			case ProcessworkspacePackage.WINDOW_VARIABLE:
				return createWindowVariable();
			case ProcessworkspacePackage.PAGE_VARIABLE:
				return createPageVariable();
			case ProcessworkspacePackage.PART_VARIABLE:
				return createPartVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName()
						+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FileVariable createFileVariable() {
		FileVariableImpl fileVariable = new FileVariableImpl();
		return fileVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FolderVariable createFolderVariable() {
		FolderVariableImpl folderVariable = new FolderVariableImpl();
		return folderVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectVariable createProjectVariable() {
		ProjectVariableImpl projectVariable = new ProjectVariableImpl();
		return projectVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WindowVariable createWindowVariable() {
		WindowVariableImpl windowVariable = new WindowVariableImpl();
		return windowVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PageVariable createPageVariable() {
		PageVariableImpl pageVariable = new PageVariableImpl();
		return pageVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PartVariable createPartVariable() {
		PartVariableImpl partVariable = new PartVariableImpl();
		return partVariable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessworkspacePackage getProcessworkspacePackage() {
		return (ProcessworkspacePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ProcessworkspacePackage getPackage() {
		return ProcessworkspacePackage.eINSTANCE;
	}

} // ProcessworkspaceFactoryImpl
