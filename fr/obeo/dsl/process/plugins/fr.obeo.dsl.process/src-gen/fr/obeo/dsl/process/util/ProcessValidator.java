/**
 */
package fr.obeo.dsl.process.util;

import fr.obeo.dsl.process.ActionTask;
import fr.obeo.dsl.process.AllDone;
import fr.obeo.dsl.process.And;
import fr.obeo.dsl.process.AnyDone;
import fr.obeo.dsl.process.ComposedTask;
import fr.obeo.dsl.process.ContextVariable;
import fr.obeo.dsl.process.Expression;
import fr.obeo.dsl.process.Not;
import fr.obeo.dsl.process.OneDone;
import fr.obeo.dsl.process.Or;
import fr.obeo.dsl.process.ProcessContext;
import fr.obeo.dsl.process.ProcessPackage;
import fr.obeo.dsl.process.ProcessUtils;
import fr.obeo.dsl.process.Task;
import fr.obeo.dsl.process.TasksExpression;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see fr.obeo.dsl.process.ProcessPackage
 * @generated
 */
public class ProcessValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final ProcessValidator INSTANCE = new ProcessValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "fr.obeo.dsl.process";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ProcessPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
			case ProcessPackage.PROCESS:
				return validateProcess((fr.obeo.dsl.process.Process)value, diagnostics, context);
			case ProcessPackage.TASK:
				return validateTask((Task)value, diagnostics, context);
			case ProcessPackage.COMPOSED_TASK:
				return validateComposedTask((ComposedTask)value, diagnostics, context);
			case ProcessPackage.ACTION_TASK:
				return validateActionTask((ActionTask)value, diagnostics, context);
			case ProcessPackage.EXPRESSION:
				return validateExpression((Expression)value, diagnostics, context);
			case ProcessPackage.TASKS_EXPRESSION:
				return validateTasksExpression((TasksExpression)value, diagnostics, context);
			case ProcessPackage.ALL_DONE:
				return validateAllDone((AllDone)value, diagnostics, context);
			case ProcessPackage.ANY_DONE:
				return validateAnyDone((AnyDone)value, diagnostics, context);
			case ProcessPackage.ONE_DONE:
				return validateOneDone((OneDone)value, diagnostics, context);
			case ProcessPackage.NOT:
				return validateNot((Not)value, diagnostics, context);
			case ProcessPackage.AND:
				return validateAnd((And)value, diagnostics, context);
			case ProcessPackage.OR:
				return validateOr((Or)value, diagnostics, context);
			case ProcessPackage.PROCESS_CONTEXT:
				return validateProcessContext((ProcessContext)value, diagnostics, context);
			case ProcessPackage.CONTEXT_VARIABLE:
				return validateContextVariable((ContextVariable)value, diagnostics, context);
			case ProcessPackage.OBJECT:
				return validateObject(value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcess(fr.obeo.dsl.process.Process process, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(process, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(task, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_Reachable(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_DeadEnd(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PrecedingTasksAtSameLevel(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_FollowingTasksAtSameLevel(task, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PreconditionTasksArePreceding(task, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Reachable constraint of '<em>Task</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTask_Reachable(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final boolean reachable = ProcessUtils.isReachable(task);

		if (!reachable) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, "Reachable"
						.hashCode(), "_UI_GenericConstraint_diagnostic", new Object[] {"Reachable",
						getObjectLabel(task, context) }, new Object[] {task }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DeadEnd constraint of '<em>Task</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTask_DeadEnd(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
		final boolean deadEnd = ProcessUtils.isDeadEnd(task);

		if (deadEnd) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.WARNING, DIAGNOSTIC_SOURCE, "DeadEnd".hashCode(),
						"_UI_GenericConstraint_diagnostic", new Object[] {"DeadEnd",
								getObjectLabel(task, context) }, new Object[] {task }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the PrecedingTasksAtSameLevel constraint of '<em>Task</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTask_PrecedingTasksAtSameLevel(Task task, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		List<Task> notAtSameLevel = new ArrayList<Task>();

		for (Task precedingTask : task.getPrecedingTasks()) {
			if (!ProcessUtils.atSameLevel(task, precedingTask)) {
				notAtSameLevel.add(precedingTask);
			}
		}

		if (notAtSameLevel.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
						"PrecedingTasksAtSameLevel".hashCode(), "_UI_GenericConstraint_diagnostic",
						new Object[] {
								"PrecedingTasksAtSameLevel",
								getObjectLabel(task, context) + " ("
										+ ProcessUtils.getListOfTaskNames(notAtSameLevel, ", ") + ")" },
						new Object[] {task }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the FollowingTasksAtSameLevel constraint of '<em>Task</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTask_FollowingTasksAtSameLevel(Task task, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		List<Task> notAtSameLevel = new ArrayList<Task>();

		for (Task followingTask : task.getFollowingTasks()) {
			if (!ProcessUtils.atSameLevel(task, followingTask)) {
				notAtSameLevel.add(followingTask);
			}
		}

		if (notAtSameLevel.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
						"FollowingTasksAtSameLevel".hashCode(), "_UI_GenericConstraint_diagnostic",
						new Object[] {
								"FollowingTasksAtSameLevel",
								getObjectLabel(task, context) + " ("
										+ ProcessUtils.getListOfTaskNames(notAtSameLevel, ", ") + ")" },
						new Object[] {task }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the PreconditionTasksArePreceding constraint of '<em>Task</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateTask_PreconditionTasksArePreceding(Task task, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		final List<Task> notPrecedingTasks = new ArrayList<Task>();

		final Expression precondition = task.getPrecondition();
		if (precondition != null) {
			final Set<Task> preconditionTasks = ProcessUtils.getReferencedTasks(precondition);
			final Set<Task> precedingTasks = ProcessUtils.getPrecedingTasks(task);
			for (Task expTask : preconditionTasks) {
				if (!precedingTasks.contains(expTask)) {
					notPrecedingTasks.add(expTask);
				}
			}
		}

		if (notPrecedingTasks.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
						"PreconditionTasksArePreceding".hashCode(), "_UI_GenericConstraint_diagnostic",
						new Object[] {"PreconditionTasksArePreceding", getObjectLabel(task, context) },
						new Object[] {task }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComposedTask(ComposedTask composedTask, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(composedTask, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_Reachable(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_DeadEnd(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PrecedingTasksAtSameLevel(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_FollowingTasksAtSameLevel(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PreconditionTasksArePreceding(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedTask_PathExistance(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedTask_InitialTasksAreContained(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedTask_FinalTasksAreContained(composedTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateComposedTask_DoneTasksAreFinal(composedTask, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PathExistance constraint of '<em>Composed Task</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateComposedTask_PathExistance(ComposedTask composedTask, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		final Set<Task> initialTasks = new HashSet<Task>(composedTask.getInitialTasks());
		final Set<Task> finalTasks = new HashSet<Task>(composedTask.getFinalTasks());

		if (!ProcessUtils.pathExists(initialTasks, finalTasks)) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, "PathExistance"
						.hashCode(), "_UI_GenericConstraint_diagnostic", new Object[] {"PathExistance",
						getObjectLabel(composedTask, context) }, new Object[] {composedTask }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the InitialTasksAreContained constraint of '<em>Composed Task</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateComposedTask_InitialTasksAreContained(ComposedTask composedTask,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		final List<Task> notContained = new ArrayList<Task>();

		for (Task initialTask : composedTask.getInitialTasks()) {
			if (!composedTask.getTasks().contains(initialTask)) {
				notContained.add(initialTask);
			}
		}

		if (notContained.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
						"InitialTasksAreContained".hashCode(), "_UI_GenericConstraint_diagnostic",
						new Object[] {
								"InitialTasksAreContained",
								getObjectLabel(composedTask, context) + " ("
										+ ProcessUtils.getListOfTaskNames(notContained, ", ") + ")" },
						new Object[] {composedTask }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the FinalTasksAreContained constraint of '<em>Composed Task</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateComposedTask_FinalTasksAreContained(ComposedTask composedTask,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		List<Task> notContained = new ArrayList<Task>();

		for (Task finalTask : composedTask.getFinalTasks()) {
			if (!composedTask.getTasks().contains(finalTask)) {
				notContained.add(finalTask);
			}
		}

		if (notContained.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE,
						"FinalTasksAreContained".hashCode(), "_UI_GenericConstraint_diagnostic",
						new Object[] {
								"FinalTasksAreContained",
								getObjectLabel(composedTask, context) + " ("
										+ ProcessUtils.getListOfTaskNames(notContained, ", ") + ")" },
						new Object[] {composedTask }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the DoneTasksAreFinal constraint of '<em>Composed Task</em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateComposedTask_DoneTasksAreFinal(ComposedTask composedTask,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		final List<Task> notFinalTasks = new ArrayList<Task>();

		final Expression doneExpression = composedTask.getDoneExpression();
		if (doneExpression != null) {
			final Set<Task> doneTasks = ProcessUtils.getReferencedTasks(doneExpression);
			final Set<Task> finalTasks = new HashSet<Task>(composedTask.getFinalTasks());
			for (Task doneTask : doneTasks) {
				if (!finalTasks.contains(doneTask)) {
					notFinalTasks.add(doneTask);
				}
			}
		}

		if (notFinalTasks.size() != 0) {
			if (diagnostics != null) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, "DoneTasksAreFinal"
						.hashCode(), "_UI_GenericConstraint_diagnostic", new Object[] {
						"DoneTasksAreFinal",
						getObjectLabel(composedTask, context) + " ("
								+ ProcessUtils.getListOfTaskNames(notFinalTasks, ", ") + ")" },
						new Object[] {composedTask }, context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionTask(ActionTask actionTask, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actionTask, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_Reachable(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_DeadEnd(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PrecedingTasksAtSameLevel(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_FollowingTasksAtSameLevel(actionTask, diagnostics, context);
		if (result || diagnostics != null) result &= validateTask_PreconditionTasksArePreceding(actionTask, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpression(Expression expression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTasksExpression(TasksExpression tasksExpression, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(tasksExpression, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAllDone(AllDone allDone, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(allDone, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnyDone(AnyDone anyDone, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(anyDone, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOneDone(OneDone oneDone, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(oneDone, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNot(Not not, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(not, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAnd(And and, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(and, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOr(Or or, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(or, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessContext(ProcessContext processContext, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processContext, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContextVariable(ContextVariable contextVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contextVariable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObject(Object object, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // ProcessValidator
