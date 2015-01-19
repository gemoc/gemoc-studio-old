/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Gemoc_execution_tracePackage
 * @generated
 */
public class Gemoc_execution_traceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Gemoc_execution_tracePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_execution_traceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Gemoc_execution_tracePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
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
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Gemoc_execution_traceSwitch<Adapter> modelSwitch =
		new Gemoc_execution_traceSwitch<Adapter>() {
			@Override
			public Adapter caseChoice(Choice object) {
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseExecutionTraceModel(ExecutionTraceModel object) {
				return createExecutionTraceModelAdapter();
			}
			@Override
			public Adapter caseSolverState(SolverState object) {
				return createSolverStateAdapter();
			}
			@Override
			public Adapter caseModelState(ModelState object) {
				return createModelStateAdapter();
			}
			@Override
			public Adapter caseContextState(ContextState object) {
				return createContextStateAdapter();
			}
			@Override
			public Adapter caseLogicalStep(LogicalStep object) {
				return createLogicalStepAdapter();
			}
			@Override
			public Adapter caseMSEExecutionContext(MSEExecutionContext object) {
				return createMSEExecutionContextAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel <em>Execution Trace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel
	 * @generated
	 */
	public Adapter createExecutionTraceModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState <em>Solver State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState
	 * @generated
	 */
	public Adapter createSolverStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState <em>Model State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState
	 * @generated
	 */
	public Adapter createModelStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState <em>Context State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState
	 * @generated
	 */
	public Adapter createContextStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep <em>Logical Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep
	 * @generated
	 */
	public Adapter createLogicalStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext <em>MSE Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext
	 * @generated
	 */
	public Adapter createMSEExecutionContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Gemoc_execution_traceAdapterFactory
