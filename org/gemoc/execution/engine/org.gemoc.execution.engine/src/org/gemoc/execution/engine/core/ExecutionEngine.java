package org.gemoc.execution.engine.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.dse.DefaultMSEStateController;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol. It
 * can display the runtime execution information to its registered observers.
 * 
 * There are two phases of initializations for this entity:
 * <ul>
 * <li>the constructor sets the language-specific elements such as
 * DomainSpecificEvents, Solver, EventExecutor, FeedbackPolicy</li>
 * <li>the initialize method sets the model-specific elements such as Model and
 * ModelLoader.</li>
 * </ul>
 * From the Model, we can derive :
 * <ul>
 * <li>the Model of Execution (using the DomainSpecificEvents)</li>
 * <li>the Higher-order-transformation (TODO)) and the Solver Input (using the
 * Model of Execution and the Solver Input Builder provided by the Solver).</li>
 * </ul>
 * 
 * There are a few elements that could enter the ExecutionEngine, maybe after
 * being reified as their own data structures:
 * <ul>
 * <li>{@link #scheduledSteps} is the FIFO of LogicalSteps. We use a FIFO
 * because sometimes we may want to memorize steps in order to go back in the
 * past and replay given steps. When the engine seeks to reach the next step of
 * execution, it will first check if there is something in this FIFO. If there
 * is not, then a new step is requested from the solver.</li>
 * <li>{@link #schedulingTrace} is a map recording the order in which the steps
 * of the solver have been used.</li>
 * <li>{@link #scheduledEventsMap} records which step is linked to which list of
 * MSEs. It is to be noticed that not all the MSEs were executed. Indeed, some
 * may have been illegal at the time (with regards to the MoC) and thus
 * discarded during the execution of this step.</li>
 * <li>{@link #executionTrace} records the steps and the actual MSEs that were
 * actually executed.</li>
 * </ul>
 * 
 * @see IExecutionEngine
 * 
 * @author flatombe
 * @author didier.vojtisek@inria.fr
 * @param <T>
 * 
 */
public class ExecutionEngine extends AbstractExecutionEngine implements IDisposable {

	/**
	 * used to detect
	 */
	protected ArrayDeque<LogicalStep> _lastStepsRun;

	private IMSEStateController _mseStateController;
	
	/**
	 * The constructor takes in all the language-specific elements. Creates the
	 * internal map of Domain-Specific Events and initializes the languages used
	 * for execution.
	 * 
	 * @param domainSpecificEventsResource
	 *            cannot be null
	 * @param solver
	 *            cannot be null
	 * @param executor
	 *            cannot be null
	 * @param feedbackPolicy
	 *            can be null (for now).
	 * @param isTraceActive 
	 * @param _executionContext
	 */
	public ExecutionEngine(IExecutionContext executionContext) 
	{
		super(executionContext);
		if(isDeadlockDetectionEnabled()){
			_lastStepsRun = new ArrayDeque<LogicalStep>(getDeadlockDetectionDepth());
		}
		_mseStateController = new DefaultMSEStateController();
		_executionContext.getExecutionPlatform().getMSEStateControllers().add(_mseStateController);
		Activator.getDefault().info("*** Engine initialization done. ***");
	}

	private static boolean areLogicalStepSimilar(LogicalStep ls1, LogicalStep ls2) {
		if (ls1 == ls2)
			return true;

		List<String> ls1TickedEventOccurences = new ArrayList<String>();
		for (MSEOccurrence mseOccurence : ls1.getMseOccurrences())
		{
			ls1TickedEventOccurences.add(mseOccurence.getMse().getName());
		}
		List<String> ls2TickedEventOccurences = new ArrayList<String>();
		for (MSEOccurrence mseOccurence : ls2.getMseOccurrences())
		{
			ls2TickedEventOccurences.add(mseOccurence.getMse().getName());
		}

		if (ls1TickedEventOccurences.size() == ls2TickedEventOccurences.size()) {
			if (ls1TickedEventOccurences.containsAll(ls2TickedEventOccurences)) {
				return true;
			}
		}
		return false;
	}
	
	class EngineRunnable implements Runnable {
		
		public void run() {
			engineStatus.setNbLogicalStepRun(0);
			try 
			{
				while (!_isStopped) 
				{					
					performExecutionStep();
					terminateIfLastStepsSimilar(getSelectedLogicalStep());							
				} 
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}

		private void terminateIfLastStepsSimilar(LogicalStep logicalStepToApply) {
			// if all lastStepsRun are the same, then we may have reached the
			// end of the simulation
			if (logicalStepToApply != null && isDeadlockDetectionEnabled() )
			{
				_lastStepsRun.add(logicalStepToApply);
				boolean allLastLogicalStepAreTheSame = true;
				for (LogicalStep logicalStep : _lastStepsRun) {
					allLastLogicalStepAreTheSame = allLastLogicalStepAreTheSame && areLogicalStepSimilar(logicalStep, logicalStepToApply);
				}
				if ((_lastStepsRun.size() >= getDeadlockDetectionDepth()) && allLastLogicalStepAreTheSame) {
					Activator.getDefault().debug("Detected " + getDeadlockDetectionDepth() + " identical LogicalStep, stopping engine");
					stop();
				}
				// if queue is full, remove one
				if (_lastStepsRun.size() > getDeadlockDetectionDepth())
					_lastStepsRun.poll();
			}
		}

	}
	private int getDeadlockDetectionDepth() 
	{
		return _executionContext.getRunConfiguration().getDeadlockDetectionDepth();
	}
	private boolean isDeadlockDetectionEnabled() 
	{
		return getDeadlockDetectionDepth() > 0;
	}
	
	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 */
	@Override
	protected void executeSelectedLogicalStep() {
		// = step in debug mode, goes to next logical step
		// -> run all event occurrences of the logical step
		// step into / open internal thread and pause them
		// each concurrent event occurrence is presented as a separate
		// thread in the debugger
		// execution feedback is sent to the solver so it can take internal
		// event into account
		for (final MSEOccurrence mseOccurence : getSelectedLogicalStep().getMseOccurrences()) 
		{
			executeAssociatedActions(mseOccurence.getMse());
			executeMSEOccurrence(mseOccurence);
		}
	}

	private void executeAssociatedActions(ModelSpecificEvent mse)
	{
		synchronized(_futureActionsLock)
		{
			ArrayList<IFutureAction> actionsToRemove = new ArrayList<IFutureAction>();
			for (IFutureAction action : _futureActions)
			{
				if (action.getTriggeringMSE() == mse)
				{
					actionsToRemove.add(action);
					action.perform();
				}
			}
			_futureActions.removeAll(actionsToRemove);
		}
	}
	
	private void executeMSEOccurrence(MSEOccurrence mseOccurrence)
	{
		ModelSpecificEvent mse = mseOccurrence.getMse();
		if (mse.getAction() != null) 
		{			
			ActionModel feedbackModel = _executionContext.getFeedbackModel();
			ArrayList<When> whenStatements = new ArrayList<When>();
			for (When w : feedbackModel.getWhenStatements())
			{
				if (w.getSource() == mse)
				{
					whenStatements.add(w);
				}
			}	
			OperationExecution execution = null;
			if (whenStatements.size() == 0)
			{
				execution = new SynchroneExecution(mseOccurrence, this);				
			}
			// if there is a future, execute async.
			else
			{
				execution = new ASynchroneExecution(mseOccurrence, whenStatements, _mseStateController, this);
			}
			execution.run();
		}
	}
	
	private ArrayList<IFutureAction> _futureActions = new ArrayList<>();
	private Object _futureActionsLock = new Object();
	@Override
	public void addFutureAction(IFutureAction action) 
	{
		synchronized(_futureActionsLock)
		{
			_futureActions.add(action);
		}
	}

	@Override
	protected Runnable getRunnable() 
	{
		return new EngineRunnable();
	}
	
}
