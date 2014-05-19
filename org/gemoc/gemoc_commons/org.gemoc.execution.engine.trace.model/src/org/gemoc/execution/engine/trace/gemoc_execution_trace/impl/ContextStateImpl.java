/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ContextStateImpl#getModelState <em>Model State</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.ContextStateImpl#getSolverState <em>Solver State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextStateImpl extends MinimalEObjectImpl.Container implements ContextState {
	/**
	 * The cached value of the '{@link #getModelState() <em>Model State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelState()
	 * @generated
	 * @ordered
	 */
	protected ModelState modelState;

	/**
	 * The cached value of the '{@link #getSolverState() <em>Solver State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolverState()
	 * @generated
	 * @ordered
	 */
	protected SolverState solverState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GemocExecutionEngineTracePackage.Literals.CONTEXT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverState getSolverState() {
		return solverState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolverState(SolverState newSolverState, NotificationChain msgs) {
		SolverState oldSolverState = solverState;
		solverState = newSolverState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE, oldSolverState, newSolverState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolverState(SolverState newSolverState) {
		if (newSolverState != solverState) {
			NotificationChain msgs = null;
			if (solverState != null)
				msgs = ((InternalEObject)solverState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE, null, msgs);
			if (newSolverState != null)
				msgs = ((InternalEObject)newSolverState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE, null, msgs);
			msgs = basicSetSolverState(newSolverState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE, newSolverState, newSolverState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE:
				return basicSetModelState(null, msgs);
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE:
				return basicSetSolverState(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelState getModelState() {
		return modelState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelState(ModelState newModelState, NotificationChain msgs) {
		ModelState oldModelState = modelState;
		modelState = newModelState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE, oldModelState, newModelState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelState(ModelState newModelState) {
		if (newModelState != modelState) {
			NotificationChain msgs = null;
			if (modelState != null)
				msgs = ((InternalEObject)modelState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE, null, msgs);
			if (newModelState != null)
				msgs = ((InternalEObject)newModelState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE, null, msgs);
			msgs = basicSetModelState(newModelState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE, newModelState, newModelState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE:
				return getModelState();
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE:
				return getSolverState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE:
				setModelState((ModelState)newValue);
				return;
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE:
				setSolverState((SolverState)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE:
				setModelState((ModelState)null);
				return;
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE:
				setSolverState((SolverState)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__MODEL_STATE:
				return modelState != null;
			case GemocExecutionEngineTracePackage.CONTEXT_STATE__SOLVER_STATE:
				return solverState != null;
		}
		return super.eIsSet(featureID);
	}

} //ContextStateImpl
