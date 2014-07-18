/**
 */
package fr.obeo.dsl.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see fr.obeo.dsl.process.ProcessFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "process";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.obeo.fr/dsl/process";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "process";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ProcessPackage eINSTANCE = fr.obeo.dsl.process.impl.ProcessPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.ProcessImpl <em>Process</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.ProcessImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS__TASK = 1;

	/**
	 * The number of structural features of the '<em>Process</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.Task <em>Task</em>}' class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.Task
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__NAME = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__ID = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Parent Task</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__PARENT_TASK = 3;

	/**
	 * The feature id for the '<em><b>Preceding Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__PRECEDING_TASKS = 4;

	/**
	 * The feature id for the '<em><b>Following Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__FOLLOWING_TASKS = 5;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK__PRECONDITION = 6;

	/**
	 * The number of structural features of the '<em>Task</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASK_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.ComposedTaskImpl <em>Composed Task</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.ComposedTaskImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getComposedTask()
	 * @generated
	 */
	int COMPOSED_TASK = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__NAME = TASK__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__DESCRIPTION = TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parent Task</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__PARENT_TASK = TASK__PARENT_TASK;

	/**
	 * The feature id for the '<em><b>Preceding Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__PRECEDING_TASKS = TASK__PRECEDING_TASKS;

	/**
	 * The feature id for the '<em><b>Following Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__FOLLOWING_TASKS = TASK__FOLLOWING_TASKS;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__PRECONDITION = TASK__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__TASKS = TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__INITIAL_TASKS = TASK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Final Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__FINAL_TASKS = TASK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Done Expression</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK__DONE_EXPRESSION = TASK_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Composed Task</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COMPOSED_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.ActionTaskImpl <em>Action Task</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.ActionTaskImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getActionTask()
	 * @generated
	 */
	int ACTION_TASK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__NAME = TASK__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__ID = TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__DESCRIPTION = TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Parent Task</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__PARENT_TASK = TASK__PARENT_TASK;

	/**
	 * The feature id for the '<em><b>Preceding Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__PRECEDING_TASKS = TASK__PRECEDING_TASKS;

	/**
	 * The feature id for the '<em><b>Following Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__FOLLOWING_TASKS = TASK__FOLLOWING_TASKS;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__PRECONDITION = TASK__PRECONDITION;

	/**
	 * The feature id for the '<em><b>Multiple Execution</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK__MULTIPLE_EXECUTION = TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Task</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTION_TASK_FEATURE_COUNT = TASK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.Expression <em>Expression</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.Expression
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 4;

	/**
	 * The number of structural features of the '<em>Expression</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.TasksExpression <em>Tasks Expression</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.TasksExpression
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getTasksExpression()
	 * @generated
	 */
	int TASKS_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASKS_EXPRESSION__TASKS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tasks Expression</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TASKS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.AllDoneImpl <em>All Done</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.AllDoneImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAllDone()
	 * @generated
	 */
	int ALL_DONE = 6;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALL_DONE__TASKS = TASKS_EXPRESSION__TASKS;

	/**
	 * The number of structural features of the '<em>All Done</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALL_DONE_FEATURE_COUNT = TASKS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.AnyDoneImpl <em>Any Done</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.AnyDoneImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAnyDone()
	 * @generated
	 */
	int ANY_DONE = 7;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANY_DONE__TASKS = TASKS_EXPRESSION__TASKS;

	/**
	 * The number of structural features of the '<em>Any Done</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ANY_DONE_FEATURE_COUNT = TASKS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.OneDoneImpl <em>One Done</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.OneDoneImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getOneDone()
	 * @generated
	 */
	int ONE_DONE = 8;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_DONE__TASKS = TASKS_EXPRESSION__TASKS;

	/**
	 * The number of structural features of the '<em>One Done</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ONE_DONE_FEATURE_COUNT = TASKS_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.NotImpl <em>Not</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.NotImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getNot()
	 * @generated
	 */
	int NOT = 9;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NOT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.AndImpl <em>And</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.AndImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 10;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>And</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.OrImpl <em>Or</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.OrImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getOr()
	 * @generated
	 */
	int OR = 11;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.obeo.dsl.process.impl.ProcessContextImpl <em>Context</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see fr.obeo.dsl.process.impl.ProcessContextImpl
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getProcessContext()
	 * @generated
	 */
	int PROCESS_CONTEXT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONTEXT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONTEXT__DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>Context</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROCESS_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '<em>Artifact</em>' data type. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see java.lang.Object
	 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getArtifact()
	 * @generated
	 */
	int ARTIFACT = 13;

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.Process <em>Process</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Process</em>'.
	 * @see fr.obeo.dsl.process.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.Process#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.process.Process#getName()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Name();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.process.Process#getTask
	 * <em>Task</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Task</em>'.
	 * @see fr.obeo.dsl.process.Process#getTask()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Task();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.Task <em>Task</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Task</em>'.
	 * @see fr.obeo.dsl.process.Task
	 * @generated
	 */
	EClass getTask();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.Task#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.process.Task#getName()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Name();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.Task#getId <em>Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see fr.obeo.dsl.process.Task#getId()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Id();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.Task#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see fr.obeo.dsl.process.Task#getDescription()
	 * @see #getTask()
	 * @generated
	 */
	EAttribute getTask_Description();

	/**
	 * Returns the meta object for the container reference '{@link fr.obeo.dsl.process.Task#getParentTask
	 * <em>Parent Task</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Parent Task</em>'.
	 * @see fr.obeo.dsl.process.Task#getParentTask()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_ParentTask();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.process.Task#getPrecedingTasks
	 * <em>Preceding Tasks</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Preceding Tasks</em>'.
	 * @see fr.obeo.dsl.process.Task#getPrecedingTasks()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_PrecedingTasks();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.process.Task#getFollowingTasks
	 * <em>Following Tasks</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Following Tasks</em>'.
	 * @see fr.obeo.dsl.process.Task#getFollowingTasks()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_FollowingTasks();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.process.Task#getPrecondition
	 * <em>Precondition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Precondition</em>'.
	 * @see fr.obeo.dsl.process.Task#getPrecondition()
	 * @see #getTask()
	 * @generated
	 */
	EReference getTask_Precondition();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.ComposedTask <em>Composed Task</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Composed Task</em>'.
	 * @see fr.obeo.dsl.process.ComposedTask
	 * @generated
	 */
	EClass getComposedTask();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.process.ComposedTask#getTasks <em>Tasks</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Tasks</em>'.
	 * @see fr.obeo.dsl.process.ComposedTask#getTasks()
	 * @see #getComposedTask()
	 * @generated
	 */
	EReference getComposedTask_Tasks();

	/**
	 * Returns the meta object for the reference list '
	 * {@link fr.obeo.dsl.process.ComposedTask#getInitialTasks <em>Initial Tasks</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Initial Tasks</em>'.
	 * @see fr.obeo.dsl.process.ComposedTask#getInitialTasks()
	 * @see #getComposedTask()
	 * @generated
	 */
	EReference getComposedTask_InitialTasks();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.process.ComposedTask#getFinalTasks
	 * <em>Final Tasks</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Final Tasks</em>'.
	 * @see fr.obeo.dsl.process.ComposedTask#getFinalTasks()
	 * @see #getComposedTask()
	 * @generated
	 */
	EReference getComposedTask_FinalTasks();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link fr.obeo.dsl.process.ComposedTask#getDoneExpression <em>Done Expression</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Done Expression</em>'.
	 * @see fr.obeo.dsl.process.ComposedTask#getDoneExpression()
	 * @see #getComposedTask()
	 * @generated
	 */
	EReference getComposedTask_DoneExpression();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.ActionTask <em>Action Task</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Action Task</em>'.
	 * @see fr.obeo.dsl.process.ActionTask
	 * @generated
	 */
	EClass getActionTask();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.ActionTask#isMultipleExecution
	 * <em>Multiple Execution</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Multiple Execution</em>'.
	 * @see fr.obeo.dsl.process.ActionTask#isMultipleExecution()
	 * @see #getActionTask()
	 * @generated
	 */
	EAttribute getActionTask_MultipleExecution();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.Expression <em>Expression</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see fr.obeo.dsl.process.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.TasksExpression
	 * <em>Tasks Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Tasks Expression</em>'.
	 * @see fr.obeo.dsl.process.TasksExpression
	 * @generated
	 */
	EClass getTasksExpression();

	/**
	 * Returns the meta object for the reference list '{@link fr.obeo.dsl.process.TasksExpression#getTasks
	 * <em>Tasks</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Tasks</em>'.
	 * @see fr.obeo.dsl.process.TasksExpression#getTasks()
	 * @see #getTasksExpression()
	 * @generated
	 */
	EReference getTasksExpression_Tasks();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.AllDone <em>All Done</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>All Done</em>'.
	 * @see fr.obeo.dsl.process.AllDone
	 * @generated
	 */
	EClass getAllDone();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.AnyDone <em>Any Done</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Any Done</em>'.
	 * @see fr.obeo.dsl.process.AnyDone
	 * @generated
	 */
	EClass getAnyDone();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.OneDone <em>One Done</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>One Done</em>'.
	 * @see fr.obeo.dsl.process.OneDone
	 * @generated
	 */
	EClass getOneDone();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.Not <em>Not</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Not</em>'.
	 * @see fr.obeo.dsl.process.Not
	 * @generated
	 */
	EClass getNot();

	/**
	 * Returns the meta object for the containment reference '{@link fr.obeo.dsl.process.Not#getExpression
	 * <em>Expression</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see fr.obeo.dsl.process.Not#getExpression()
	 * @see #getNot()
	 * @generated
	 */
	EReference getNot_Expression();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.And <em>And</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>And</em>'.
	 * @see fr.obeo.dsl.process.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.process.And#getExpressions <em>Expressions</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see fr.obeo.dsl.process.And#getExpressions()
	 * @see #getAnd()
	 * @generated
	 */
	EReference getAnd_Expressions();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.Or <em>Or</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Or</em>'.
	 * @see fr.obeo.dsl.process.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link fr.obeo.dsl.process.Or#getExpressions <em>Expressions</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see fr.obeo.dsl.process.Or#getExpressions()
	 * @see #getOr()
	 * @generated
	 */
	EReference getOr_Expressions();

	/**
	 * Returns the meta object for class '{@link fr.obeo.dsl.process.ProcessContext <em>Context</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Context</em>'.
	 * @see fr.obeo.dsl.process.ProcessContext
	 * @generated
	 */
	EClass getProcessContext();

	/**
	 * Returns the meta object for the attribute '{@link fr.obeo.dsl.process.ProcessContext#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.obeo.dsl.process.ProcessContext#getName()
	 * @see #getProcessContext()
	 * @generated
	 */
	EAttribute getProcessContext_Name();

	/**
	 * Returns the meta object for the reference '{@link fr.obeo.dsl.process.ProcessContext#getDefinition
	 * <em>Definition</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see fr.obeo.dsl.process.ProcessContext#getDefinition()
	 * @see #getProcessContext()
	 * @generated
	 */
	EReference getProcessContext_Definition();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Artifact</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for data type '<em>Artifact</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object" serializeable="false"
	 * @generated
	 */
	EDataType getArtifact();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessFactory getProcessFactory();

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
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.ProcessImpl <em>Process</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.ProcessImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROCESS__NAME = eINSTANCE.getProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCESS__TASK = eINSTANCE.getProcess_Task();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.Task <em>Task</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.Task
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getTask()
		 * @generated
		 */
		EClass TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TASK__NAME = eINSTANCE.getTask_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TASK__ID = eINSTANCE.getTask_Id();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TASK__DESCRIPTION = eINSTANCE.getTask_Description();

		/**
		 * The meta object literal for the '<em><b>Parent Task</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TASK__PARENT_TASK = eINSTANCE.getTask_ParentTask();

		/**
		 * The meta object literal for the '<em><b>Preceding Tasks</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TASK__PRECEDING_TASKS = eINSTANCE.getTask_PrecedingTasks();

		/**
		 * The meta object literal for the '<em><b>Following Tasks</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TASK__FOLLOWING_TASKS = eINSTANCE.getTask_FollowingTasks();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TASK__PRECONDITION = eINSTANCE.getTask_Precondition();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.ComposedTaskImpl
		 * <em>Composed Task</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.ComposedTaskImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getComposedTask()
		 * @generated
		 */
		EClass COMPOSED_TASK = eINSTANCE.getComposedTask();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSED_TASK__TASKS = eINSTANCE.getComposedTask_Tasks();

		/**
		 * The meta object literal for the '<em><b>Initial Tasks</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSED_TASK__INITIAL_TASKS = eINSTANCE.getComposedTask_InitialTasks();

		/**
		 * The meta object literal for the '<em><b>Final Tasks</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSED_TASK__FINAL_TASKS = eINSTANCE.getComposedTask_FinalTasks();

		/**
		 * The meta object literal for the '<em><b>Done Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSED_TASK__DONE_EXPRESSION = eINSTANCE.getComposedTask_DoneExpression();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.ActionTaskImpl
		 * <em>Action Task</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.ActionTaskImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getActionTask()
		 * @generated
		 */
		EClass ACTION_TASK = eINSTANCE.getActionTask();

		/**
		 * The meta object literal for the '<em><b>Multiple Execution</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ACTION_TASK__MULTIPLE_EXECUTION = eINSTANCE.getActionTask_MultipleExecution();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.Expression <em>Expression</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.Expression
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.TasksExpression
		 * <em>Tasks Expression</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.TasksExpression
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getTasksExpression()
		 * @generated
		 */
		EClass TASKS_EXPRESSION = eINSTANCE.getTasksExpression();

		/**
		 * The meta object literal for the '<em><b>Tasks</b></em>' reference list feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TASKS_EXPRESSION__TASKS = eINSTANCE.getTasksExpression_Tasks();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.AllDoneImpl <em>All Done</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.AllDoneImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAllDone()
		 * @generated
		 */
		EClass ALL_DONE = eINSTANCE.getAllDone();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.AnyDoneImpl <em>Any Done</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.AnyDoneImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAnyDone()
		 * @generated
		 */
		EClass ANY_DONE = eINSTANCE.getAnyDone();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.OneDoneImpl <em>One Done</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.OneDoneImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getOneDone()
		 * @generated
		 */
		EClass ONE_DONE = eINSTANCE.getOneDone();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.Not <em>Not</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.Not
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getNot()
		 * @generated
		 */
		EClass NOT = eINSTANCE.getNot();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NOT__EXPRESSION = eINSTANCE.getNot_Expression();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.And <em>And</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.And
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AND__EXPRESSIONS = eINSTANCE.getAnd_Expressions();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.Or <em>Or</em>}' class. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.Or
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OR__EXPRESSIONS = eINSTANCE.getOr_Expressions();

		/**
		 * The meta object literal for the '{@link fr.obeo.dsl.process.impl.ProcessContextImpl
		 * <em>Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see fr.obeo.dsl.process.impl.ProcessContextImpl
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getProcessContext()
		 * @generated
		 */
		EClass PROCESS_CONTEXT = eINSTANCE.getProcessContext();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROCESS_CONTEXT__NAME = eINSTANCE.getProcessContext_Name();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROCESS_CONTEXT__DEFINITION = eINSTANCE.getProcessContext_Definition();

		/**
		 * The meta object literal for the '<em>Artifact</em>' data type. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see java.lang.Object
		 * @see fr.obeo.dsl.process.impl.ProcessPackageImpl#getArtifact()
		 * @generated
		 */
		EDataType ARTIFACT = eINSTANCE.getArtifact();

	}

} // ProcessPackage
