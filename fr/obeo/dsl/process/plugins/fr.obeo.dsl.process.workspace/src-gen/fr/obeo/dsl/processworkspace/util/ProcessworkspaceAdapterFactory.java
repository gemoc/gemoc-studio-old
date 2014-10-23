/**
 */
package fr.obeo.dsl.processworkspace.util;

import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.processworkspace.FileVariable;
import fr.obeo.dsl.processworkspace.FolderVariable;
import fr.obeo.dsl.processworkspace.PageVariable;
import fr.obeo.dsl.processworkspace.PartVariable;
import fr.obeo.dsl.processworkspace.ProcessworkspacePackage;
import fr.obeo.dsl.processworkspace.ProjectVariable;
import fr.obeo.dsl.processworkspace.WindowVariable;
import fr.obeo.dsl.processworkspace.WorkspaceVariable;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see fr.obeo.dsl.processworkspace.ProcessworkspacePackage
 * @generated
 */
public class ProcessworkspaceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ProcessworkspacePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProcessworkspaceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProcessworkspacePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance
	 * object of the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessworkspaceSwitch<Adapter> modelSwitch = new ProcessworkspaceSwitch<Adapter>() {
		@Override
		public Adapter caseWorkspaceVariable(WorkspaceVariable object) {
			return createWorkspaceVariableAdapter();
		}

		@Override
		public Adapter caseFileVariable(FileVariable object) {
			return createFileVariableAdapter();
		}

		@Override
		public Adapter caseFolderVariable(FolderVariable object) {
			return createFolderVariableAdapter();
		}

		@Override
		public Adapter caseProjectVariable(ProjectVariable object) {
			return createProjectVariableAdapter();
		}

		@Override
		public Adapter caseWindowVariable(WindowVariable object) {
			return createWindowVariableAdapter();
		}

		@Override
		public Adapter casePageVariable(PageVariable object) {
			return createPageVariableAdapter();
		}

		@Override
		public Adapter casePartVariable(PartVariable object) {
			return createPartVariableAdapter();
		}

		@Override
		public Adapter caseProcessVariable(ProcessVariable object) {
			return createProcessVariableAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.WorkspaceVariable
	 * <em>Workspace Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.WorkspaceVariable
	 * @generated
	 */
	public Adapter createWorkspaceVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.FileVariable
	 * <em>File Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.FileVariable
	 * @generated
	 */
	public Adapter createFileVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.FolderVariable
	 * <em>Folder Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.FolderVariable
	 * @generated
	 */
	public Adapter createFolderVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.ProjectVariable
	 * <em>Project Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.ProjectVariable
	 * @generated
	 */
	public Adapter createProjectVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.WindowVariable
	 * <em>Window Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.WindowVariable
	 * @generated
	 */
	public Adapter createWindowVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.PageVariable
	 * <em>Page Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.PageVariable
	 * @generated
	 */
	public Adapter createPageVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.processworkspace.PartVariable
	 * <em>Part Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.processworkspace.PartVariable
	 * @generated
	 */
	public Adapter createPartVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.obeo.dsl.process.ProcessVariable
	 * <em>Variable</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see fr.obeo.dsl.process.ProcessVariable
	 * @generated
	 */
	public Adapter createProcessVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns
	 * null. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ProcessworkspaceAdapterFactory
