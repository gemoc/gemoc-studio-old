/**
 */
package org.gemoc.execution.engine.trace.gemoc_execution_trace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTracePackage;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solver State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.SolverStateImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.gemoc.execution.engine.trace.gemoc_execution_trace.impl.SolverStateImpl#getSerializableModel <em>Serializable Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolverStateImpl extends MinimalEObjectImpl.Container implements SolverState {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EObject model;
	/**
	 * The default value of the '{@link #getSerializableModel() <em>Serializable Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerializableModel()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] SERIALIZABLE_MODEL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSerializableModel() <em>Serializable Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerializableModel()
	 * @generated
	 * @ordered
	 */
	protected byte[] serializableModel = SERIALIZABLE_MODEL_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolverStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GemocExecutionEngineTracePackage.Literals.SOLVER_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject)model;
			model = eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL, oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EObject newModel) {
		EObject oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL, oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getSerializableModel() {
		return serializableModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerializableModel(byte[] newSerializableModel) {
		byte[] oldSerializableModel = serializableModel;
		serializableModel = newSerializableModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GemocExecutionEngineTracePackage.SOLVER_STATE__SERIALIZABLE_MODEL, oldSerializableModel, serializableModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL:
				if (resolve) return getModel();
				return basicGetModel();
			case GemocExecutionEngineTracePackage.SOLVER_STATE__SERIALIZABLE_MODEL:
				return getSerializableModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL:
				setModel((EObject)newValue);
				return;
			case GemocExecutionEngineTracePackage.SOLVER_STATE__SERIALIZABLE_MODEL:
				setSerializableModel((byte[])newValue);
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
			case GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL:
				setModel((EObject)null);
				return;
			case GemocExecutionEngineTracePackage.SOLVER_STATE__SERIALIZABLE_MODEL:
				setSerializableModel(SERIALIZABLE_MODEL_EDEFAULT);
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
			case GemocExecutionEngineTracePackage.SOLVER_STATE__MODEL:
				return model != null;
			case GemocExecutionEngineTracePackage.SOLVER_STATE__SERIALIZABLE_MODEL:
				return SERIALIZABLE_MODEL_EDEFAULT == null ? serializableModel != null : !SERIALIZABLE_MODEL_EDEFAULT.equals(serializableModel);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serializableModel: ");
		result.append(serializableModel);
		result.append(')');
		return result.toString();
	}

} //SolverStateImpl
