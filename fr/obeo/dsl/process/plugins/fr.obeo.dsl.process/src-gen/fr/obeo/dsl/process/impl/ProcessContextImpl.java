/**
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.IllegalVariableAccessException;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.ProcessVariable;
import fr.obeo.dsl.process.Task;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link fr.obeo.dsl.process.impl.ProcessContextImpl#getDefinition <em>Definition</em>}</li>
 * <li>{@link fr.obeo.dsl.process.impl.ProcessContextImpl#getProgress <em>Progress</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProcessContextImpl extends EObjectImpl implements ProcessContext {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected fr.obeo.dsl.process.Process definition;

	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EMap<ProcessVariable, Object> variables;

	/**
	 * The current progress of this instance of {@link Process}.
	 * 
	 * @generated NOT
	 */
	private final Map<ActionTask, Object> progress = new HashMap<ActionTask, Object>();

	/**
	 * Reasons of an {@link ActionTask} not been done.
	 * 
	 * @generated NOT
	 */
	private final Map<ActionTask, String> reasons = new HashMap<ActionTask, String>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProcessContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.PROCESS_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_CONTEXT__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fr.obeo.dsl.process.Process getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (fr.obeo.dsl.process.Process)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ProcessPackage.PROCESS_CONTEXT__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public fr.obeo.dsl.process.Process basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefinition(fr.obeo.dsl.process.Process newDefinition) {
		fr.obeo.dsl.process.Process oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.PROCESS_CONTEXT__DEFINITION,
					oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EMap<ProcessVariable, Object> getVariables() {
		if (variables == null) {
			variables = new EcoreEMap<ProcessVariable, Object>(
					ProcessPackage.Literals.PROCESS_VARIABLE_TO_OBJECT_MAP,
					ProcessVariableToObjectMapImpl.class, this, ProcessPackage.PROCESS_CONTEXT__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isDone(ActionTask task) {
		return progress.containsKey(task);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setDone(ActionTask task, Object value) {
		final Object oldValue = progress.put(task, value);
		reasons.remove(task);
		// recursively notifies tasks
		notifyTasks(task, oldValue, value);
	}

	protected void notifyTasks(Task currentTask, Object oldValue, Object value) {
		if (((BasicNotifierImpl)currentTask).eNotificationRequired()) {
			currentTask.eNotify(new ENotificationImpl((InternalEObject)currentTask, Notification.SET,
					Notification.NO_FEATURE_ID, oldValue, value));
		}
		// recursively notifies the parent tasks
		if (ProcessUtils.isFinalTask(currentTask)) {
			notifyTasks(currentTask.getParentTask(), oldValue, value);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setUndone(ActionTask task, String reason) {
		reasons.put(task, reason);
		final Object oldValue = progress.remove(task);
		// recursively notifies the parent tasks
		notifyTasks(task, oldValue, null);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getResult(ActionTask task) {
		return progress.get(task);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setVariableValue(ProcessVariable variable, Object variableValue, ActionTask writer)
			throws IllegalVariableAccessException {
		if (writer != null) {
			if (!writer.getWrittenVariables().contains(variable)) {
				throw new IllegalVariableAccessException("Task " + writer.getName()
						+ " hasn't declared to be able to write in Variable " + variable.getName());
			} else {
				getVariables().put(variable, variableValue);
			}
		} else {
			throw new IllegalVariableAccessException(
					"You need to provide a writer ActionTask in order to write to the varaible "
							+ variable.getName());
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getVariableValue(ProcessVariable variable, ActionTask observer) {
		if (observer != null) {
			if (!observer.getObservedVariables().contains(variable)
					&& !observer.getWrittenVariables().contains(variable)) {
				throw new IllegalVariableAccessException("Task " + observer.getName()
						+ " hasn't declared to be able to read or write the Variable " + variable.getName());
			} else {
				return getVariables().get(variable);
			}
		} else {
			throw new IllegalVariableAccessException(
					"You need to provide a writer ActionTask in order to write to the varaible "
							+ variable.getName());
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getUndoneReason(ActionTask task) {
		return this.reasons.get(task);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ProcessVariable getProcessVariable(String variableName) {
		ProcessVariable searchedVariableDefinition = null;
		for (ProcessVariable variableDefinition : this.getDefinition().getVariables()) {
			if (variableDefinition.getName().equals(variableName)) {
				searchedVariableDefinition = variableDefinition;
				break;
			}
		}
		return searchedVariableDefinition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				return getName();
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				if (resolve)
					return getDefinition();
				return basicGetDefinition();
			case ProcessPackage.PROCESS_CONTEXT__VARIABLES:
				if (coreType)
					return getVariables();
				else
					return getVariables().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				setDefinition((fr.obeo.dsl.process.Process)newValue);
				return;
			case ProcessPackage.PROCESS_CONTEXT__VARIABLES:
				((EStructuralFeature.Setting)getVariables()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				setDefinition((fr.obeo.dsl.process.Process)null);
				return;
			case ProcessPackage.PROCESS_CONTEXT__VARIABLES:
				getVariables().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProcessPackage.PROCESS_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.PROCESS_CONTEXT__DEFINITION:
				return definition != null;
			case ProcessPackage.PROCESS_CONTEXT__VARIABLES:
				return variables != null && !variables.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // ProcessContextImpl
