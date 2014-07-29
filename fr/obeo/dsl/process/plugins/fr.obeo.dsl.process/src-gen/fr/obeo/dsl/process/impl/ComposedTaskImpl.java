/**
 */
package fr.obeo.dsl.process.impl;

import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.Expression;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.Task;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Composed Task</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getId <em>Id</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getParentTask <em>Parent Task</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getPrecedingTasks <em>Preceding Tasks</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getFollowingTasks <em>Following Tasks</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getInstanceClassName <em>Instance Class Name</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getTasks <em>Tasks</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getInitialTasks <em>Initial Tasks</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getFinalTasks <em>Final Tasks</em>}</li>
 *   <li>{@link fr.obeo.dsl.process.impl.ComposedTaskImpl#getDoneExpression <em>Done Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComposedTaskImpl extends EObjectImpl implements ComposedTask {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrecedingTasks() <em>Preceding Tasks</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrecedingTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> precedingTasks;

	/**
	 * The cached value of the '{@link #getFollowingTasks() <em>Following Tasks</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFollowingTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> followingTasks;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected Expression precondition;

	/**
	 * The default value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceClassName() <em>Instance Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceClassName()
	 * @generated
	 * @ordered
	 */
	protected String instanceClassName = INSTANCE_CLASS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTasks() <em>Tasks</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> tasks;

	/**
	 * The cached value of the '{@link #getInitialTasks() <em>Initial Tasks</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInitialTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> initialTasks;

	/**
	 * The cached value of the '{@link #getFinalTasks() <em>Final Tasks</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFinalTasks()
	 * @generated
	 * @ordered
	 */
	protected EList<Task> finalTasks;

	/**
	 * The cached value of the '{@link #getDoneExpression() <em>Done Expression</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDoneExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression doneExpression;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.COMPOSED_TASK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedTask getParentTask() {
		if (eContainerFeatureID() != ProcessPackage.COMPOSED_TASK__PARENT_TASK) return null;
		return (ComposedTask)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentTask(ComposedTask newParentTask, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentTask, ProcessPackage.COMPOSED_TASK__PARENT_TASK, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentTask(ComposedTask newParentTask) {
		if (newParentTask != eInternalContainer() || (eContainerFeatureID() != ProcessPackage.COMPOSED_TASK__PARENT_TASK && newParentTask != null)) {
			if (EcoreUtil.isAncestor(this, newParentTask))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentTask != null)
				msgs = ((InternalEObject)newParentTask).eInverseAdd(this, ProcessPackage.COMPOSED_TASK__TASKS, ComposedTask.class, msgs);
			msgs = basicSetParentTask(newParentTask, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__PARENT_TASK, newParentTask, newParentTask));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getPrecedingTasks() {
		if (precedingTasks == null) {
			precedingTasks = new EObjectWithInverseResolvingEList.ManyInverse<Task>(Task.class, this, ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS, ProcessPackage.TASK__FOLLOWING_TASKS);
		}
		return precedingTasks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getFollowingTasks() {
		if (followingTasks == null) {
			followingTasks = new EObjectWithInverseResolvingEList.ManyInverse<Task>(Task.class, this, ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS, ProcessPackage.TASK__PRECEDING_TASKS);
		}
		return followingTasks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getPrecondition() {
		return precondition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrecondition(Expression newPrecondition, NotificationChain msgs) {
		Expression oldPrecondition = precondition;
		precondition = newPrecondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__PRECONDITION, oldPrecondition, newPrecondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecondition(Expression newPrecondition) {
		if (newPrecondition != precondition) {
			NotificationChain msgs = null;
			if (precondition != null)
				msgs = ((InternalEObject)precondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSED_TASK__PRECONDITION, null, msgs);
			if (newPrecondition != null)
				msgs = ((InternalEObject)newPrecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSED_TASK__PRECONDITION, null, msgs);
			msgs = basicSetPrecondition(newPrecondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__PRECONDITION, newPrecondition, newPrecondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceClassName() {
		return instanceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceClassName(String newInstanceClassName) {
		String oldInstanceClassName = instanceClassName;
		instanceClassName = newInstanceClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__INSTANCE_CLASS_NAME, oldInstanceClassName, instanceClassName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getTasks() {
		if (tasks == null) {
			tasks = new EObjectContainmentWithInverseEList<Task>(Task.class, this, ProcessPackage.COMPOSED_TASK__TASKS, ProcessPackage.TASK__PARENT_TASK);
		}
		return tasks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getInitialTasks() {
		if (initialTasks == null) {
			initialTasks = new EObjectResolvingEList<Task>(Task.class, this, ProcessPackage.COMPOSED_TASK__INITIAL_TASKS);
		}
		return initialTasks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Task> getFinalTasks() {
		if (finalTasks == null) {
			finalTasks = new EObjectResolvingEList<Task>(Task.class, this, ProcessPackage.COMPOSED_TASK__FINAL_TASKS);
		}
		return finalTasks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getDoneExpression() {
		return doneExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDoneExpression(Expression newDoneExpression, NotificationChain msgs) {
		Expression oldDoneExpression = doneExpression;
		doneExpression = newDoneExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION, oldDoneExpression, newDoneExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoneExpression(Expression newDoneExpression) {
		if (newDoneExpression != doneExpression) {
			NotificationChain msgs = null;
			if (doneExpression != null)
				msgs = ((InternalEObject)doneExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION, null, msgs);
			if (newDoneExpression != null)
				msgs = ((InternalEObject)newDoneExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION, null, msgs);
			msgs = basicSetDoneExpression(newDoneExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION, newDoneExpression, newDoneExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentTask((ComposedTask)otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrecedingTasks()).basicAdd(otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFollowingTasks()).basicAdd(otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__TASKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTasks()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				return basicSetParentTask(null, msgs);
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				return ((InternalEList<?>)getPrecedingTasks()).basicRemove(otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				return ((InternalEList<?>)getFollowingTasks()).basicRemove(otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__PRECONDITION:
				return basicSetPrecondition(null, msgs);
			case ProcessPackage.COMPOSED_TASK__TASKS:
				return ((InternalEList<?>)getTasks()).basicRemove(otherEnd, msgs);
			case ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION:
				return basicSetDoneExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				return eInternalContainer().eInverseRemove(this, ProcessPackage.COMPOSED_TASK__TASKS, ComposedTask.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__NAME:
				return getName();
			case ProcessPackage.COMPOSED_TASK__ID:
				return getId();
			case ProcessPackage.COMPOSED_TASK__DESCRIPTION:
				return getDescription();
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				return getParentTask();
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				return getPrecedingTasks();
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				return getFollowingTasks();
			case ProcessPackage.COMPOSED_TASK__PRECONDITION:
				return getPrecondition();
			case ProcessPackage.COMPOSED_TASK__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case ProcessPackage.COMPOSED_TASK__TASKS:
				return getTasks();
			case ProcessPackage.COMPOSED_TASK__INITIAL_TASKS:
				return getInitialTasks();
			case ProcessPackage.COMPOSED_TASK__FINAL_TASKS:
				return getFinalTasks();
			case ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION:
				return getDoneExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__ID:
				setId((String)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				setParentTask((ComposedTask)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				getPrecedingTasks().clear();
				getPrecedingTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				getFollowingTasks().clear();
				getFollowingTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__PRECONDITION:
				setPrecondition((Expression)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__TASKS:
				getTasks().clear();
				getTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__INITIAL_TASKS:
				getInitialTasks().clear();
				getInitialTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__FINAL_TASKS:
				getFinalTasks().clear();
				getFinalTasks().addAll((Collection<? extends Task>)newValue);
				return;
			case ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION:
				setDoneExpression((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.COMPOSED_TASK__ID:
				setId(ID_EDEFAULT);
				return;
			case ProcessPackage.COMPOSED_TASK__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				setParentTask((ComposedTask)null);
				return;
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				getPrecedingTasks().clear();
				return;
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				getFollowingTasks().clear();
				return;
			case ProcessPackage.COMPOSED_TASK__PRECONDITION:
				setPrecondition((Expression)null);
				return;
			case ProcessPackage.COMPOSED_TASK__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case ProcessPackage.COMPOSED_TASK__TASKS:
				getTasks().clear();
				return;
			case ProcessPackage.COMPOSED_TASK__INITIAL_TASKS:
				getInitialTasks().clear();
				return;
			case ProcessPackage.COMPOSED_TASK__FINAL_TASKS:
				getFinalTasks().clear();
				return;
			case ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION:
				setDoneExpression((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ProcessPackage.COMPOSED_TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.COMPOSED_TASK__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ProcessPackage.COMPOSED_TASK__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ProcessPackage.COMPOSED_TASK__PARENT_TASK:
				return getParentTask() != null;
			case ProcessPackage.COMPOSED_TASK__PRECEDING_TASKS:
				return precedingTasks != null && !precedingTasks.isEmpty();
			case ProcessPackage.COMPOSED_TASK__FOLLOWING_TASKS:
				return followingTasks != null && !followingTasks.isEmpty();
			case ProcessPackage.COMPOSED_TASK__PRECONDITION:
				return precondition != null;
			case ProcessPackage.COMPOSED_TASK__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case ProcessPackage.COMPOSED_TASK__TASKS:
				return tasks != null && !tasks.isEmpty();
			case ProcessPackage.COMPOSED_TASK__INITIAL_TASKS:
				return initialTasks != null && !initialTasks.isEmpty();
			case ProcessPackage.COMPOSED_TASK__FINAL_TASKS:
				return finalTasks != null && !finalTasks.isEmpty();
			case ProcessPackage.COMPOSED_TASK__DONE_EXPRESSION:
				return doneExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(", instanceClassName: ");
		result.append(instanceClassName);
		result.append(')');
		return result.toString();
	}

} // ComposedTaskImpl
