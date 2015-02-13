/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Gemoc_execution_traceFactoryImpl extends EFactoryImpl implements Gemoc_execution_traceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Gemoc_execution_traceFactory init() {
		try {
			Gemoc_execution_traceFactory theGemoc_execution_traceFactory = (Gemoc_execution_traceFactory)EPackage.Registry.INSTANCE.getEFactory(Gemoc_execution_tracePackage.eNS_URI);
			if (theGemoc_execution_traceFactory != null) {
				return theGemoc_execution_traceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Gemoc_execution_traceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_execution_traceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Gemoc_execution_tracePackage.CHOICE: return createChoice();
			case Gemoc_execution_tracePackage.EXECUTION_TRACE_MODEL: return createExecutionTraceModel();
			case Gemoc_execution_tracePackage.SOLVER_STATE: return createSolverState();
			case Gemoc_execution_tracePackage.MODEL_STATE: return createModelState();
			case Gemoc_execution_tracePackage.CONTEXT_STATE: return createContextState();
			case Gemoc_execution_tracePackage.LOGICAL_STEP: return createLogicalStep();
			case Gemoc_execution_tracePackage.MSE_EXECUTION_CONTEXT: return createMSEExecutionContext();
			case Gemoc_execution_tracePackage.BRANCH: return createBranch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Gemoc_execution_tracePackage.ISERIALIZABLE:
				return createISerializableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Gemoc_execution_tracePackage.ISERIALIZABLE:
				return convertISerializableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTraceModel createExecutionTraceModel() {
		ExecutionTraceModelImpl executionTraceModel = new ExecutionTraceModelImpl();
		return executionTraceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverState createSolverState() {
		SolverStateImpl solverState = new SolverStateImpl();
		return solverState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelState createModelState() {
		ModelStateImpl modelState = new ModelStateImpl();
		return modelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextState createContextState() {
		ContextStateImpl contextState = new ContextStateImpl();
		return contextState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalStep createLogicalStep() {
		LogicalStepImpl logicalStep = new LogicalStepImpl();
		return logicalStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MSEExecutionContext createMSEExecutionContext() {
		MSEExecutionContextImpl mseExecutionContext = new MSEExecutionContextImpl();
		return mseExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] createISerializableFromString(EDataType eDataType, String initialValue) {
		return (byte[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertISerializableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gemoc_execution_tracePackage getGemoc_execution_tracePackage() {
		return (Gemoc_execution_tracePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Gemoc_execution_tracePackage getPackage() {
		return Gemoc_execution_tracePackage.eINSTANCE;
	}

} //Gemoc_execution_traceFactoryImpl
