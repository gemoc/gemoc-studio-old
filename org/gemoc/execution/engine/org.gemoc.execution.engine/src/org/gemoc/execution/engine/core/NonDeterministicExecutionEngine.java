package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.dse.DefaultMSEStateController;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.core.INonDeterministicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

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
public class NonDeterministicExecutionEngine extends AbstractExecutionEngine implements IDisposable,INonDeterministicExecutionEngine {

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
	public NonDeterministicExecutionEngine(IExecutionContext executionContext) 
	{
		super(executionContext);
		_mseStateController = new DefaultMSEStateController();
		_executionContext.getExecutionPlatform().getMSEStateControllers().add(_mseStateController);
		Activator.getDefault().info("*** Engine initialization done. ***");
	}
	
	private void switchDeciderIfNecessary()
	{
		if (getLogicalStepDecider() != null
			&& getLogicalStepDecider() != _logicalStepDecider)
		{
			_logicalStepDecider = getLogicalStepDecider();
		}
	}
	

	private ILogicalStepDecider _logicalStepDecider;

	
	@Override
	public ILogicalStepDecider getLogicalStepDecider()
	{
		return _logicalStepDecider;
	}

	@Override
	public void changeLogicalStepDecider(ILogicalStepDecider newDecider)
	{
		_logicalStepDecider = newDecider;
	}
	
	
	private void computePossibleLogicalSteps() 
	{
		_possibleLogicalSteps = getSolver().computeAndGetPossibleLogicalSteps();
	}
	

	private void updatePossibleLogicalSteps()
	{
		for(IMSEStateController c : getExecutionContext().getExecutionPlatform().getMSEStateControllers())
		{
			c.applyMSEFutureStates(getSolver());
		}
		synchronized(this)
		{
			_possibleLogicalSteps = getSolver().updatePossibleLogicalSteps();
		}
	}
	
	@Override
	public void recomputePossibleLogicalSteps()
	{
		getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();	
		notifyProposedLogicalStepsChanged();
	}
	

	protected List<LogicalStep> _possibleLogicalSteps = new ArrayList<>();
	
	
	@Override
	public List<LogicalStep> getPossibleLogicalSteps() 
	{
		synchronized (this)
		{
			return new ArrayList<LogicalStep>(_possibleLogicalSteps);
		}
	}
	
	@Override
	public void stop() 
	{
		if (!_isStopped)
		{
			notifyAboutToStop(); // notification occurs only if not already stopped
			_isStopped = true;
			setSelectedLogicalStep(null);
			if (getLogicalStepDecider() != null)
			{
				// unlock decider if this is a user decider
				getLogicalStepDecider().preempt();
			}
		}
	}
	
	protected void notifyLogicalStepSelected() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			try {
				addon.logicalStepSelected(this, getSelectedLogicalStep());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon "+addon+", "+e.getMessage(), e);
			}
		}
	}
	
	protected void notifyAboutToSelectLogicalStep() {
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			try {
				addon.aboutToSelectLogicalStep(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon "+addon+", "+e.getMessage(), e);
			}
		}
	}


	
	protected LogicalStep _selectedLogicalStep;

	@Override
	public LogicalStep getSelectedLogicalStep() 
	{
		synchronized (this) {
			return _selectedLogicalStep;
		}
	}
	
	protected void setSelectedLogicalStep(LogicalStep ls)
	{
		synchronized (this) {
			_selectedLogicalStep = ls;
		}
	}
	

	private ISolver _solver;

	@Override
	public ISolver getSolver() 
	{
		return _solver;
	}

	
	protected void notifyProposedLogicalStepsChanged(){
		for (IEngineAddon addon : getExecutionContext().getExecutionPlatform().getEngineAddons()) 
		{
			try {
				addon.proposedLogicalStepsChanged(this, getPossibleLogicalSteps());
			} catch (Exception e) {
				Activator.getDefault().error("Exception in Addon "+addon+", "+e.getMessage(), e);
			}
		}
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver() + " ; ModelResource=" + _executionContext.getResourceModel()+ "]";
	}
	
	protected void performExecutionStep() throws InterruptedException {
		switchDeciderIfNecessary();
						
		computePossibleLogicalSteps();
		updatePossibleLogicalSteps();
		// 2- select one solution from available logical step /
		// select interactive vs batch
		if (_possibleLogicalSteps.size() == 0) {
			Activator.getDefault().debug("No more LogicalStep to run");
			stop();
		} else {
			//Activator.getDefault().debug("\t\t ---------------- LogicalStep " + count);
			LogicalStep selectedLogicalStep = selectAndExecuteLogicalStep();						
			// 3 - run the selected logical step
			// inform the solver that we will run this step
			if (selectedLogicalStep != null)
			{
				getSolver().applyLogicalStep(selectedLogicalStep);
				engineStatus.incrementNbLogicalStepRun();
			} else {
				// no logical step was selected, this is most probably due to a preempt on the LogicalStepDecider  and a change of Decider, 
				//notify Addons that we'll rerun this ExecutionStep
				//recomputePossibleLogicalSteps();
			}
		}
	}
	
	
	class EngineRunnable implements Runnable {
		
		public void run() {
			engineStatus.setNbLogicalStepRun(0);
			try 
			{
				while (!_isStopped) 
				{					
					performExecutionStep();							
				} 
			} catch (Throwable e) {
				throw new RuntimeException(e);
			}
		}

	}
	
	private LogicalStep selectAndExecuteLogicalStep() throws InterruptedException 
	{
		setEngineStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
		notifyAboutToSelectLogicalStep();
		LogicalStep selectedLogicalStep = getLogicalStepDecider().decide(this, getPossibleLogicalSteps());
		if (selectedLogicalStep != null)
		{
			setSelectedLogicalStep(selectedLogicalStep);
			setEngineStatus(EngineStatus.RunStatus.Running);
			notifyLogicalStepSelected();
			// run all the event occurrences of this logical
			// step
			notifyAboutToExecuteLogicalStep(selectedLogicalStep);
			executeSelectedLogicalStep();
			notifyLogicalStepExecuted(selectedLogicalStep);
		}
		return selectedLogicalStep;
	}
	
	
	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 */
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

	@Override
	public void setSolver(ISolver solver) {
		_solver = solver;
		
	}
	
	@Override
	public void dispose() {
		super.dispose();
		_solver.dispose();
	}
	
}
