package org.gemoc.execution.engine.core;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.capabilitites.ModelExecutionTracingCapability;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponent;
import org.gemoc.gemoc_language_workbench.api.extensions.IDataProcessingComponentExtension;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.When;
import fr.inria.aoste.trace.LogicalStep;

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
 * @see GemocExecutionEngine
 * 
 * @author flatombe
 * @author didier.vojtisek@inria.fr
 * @param <T>
 * 
 */
public abstract class ObservableBasicExecutionEngine extends Observable implements GemocExecutionEngine {

	private boolean _started = false;
	private boolean terminated = false;

	protected EngineStatus engineStatus = new EngineStatus();

	/**
	 * used to detect
	 */
	protected ArrayDeque<LogicalStep> _lastStepsRun;

	private IExecutionContext _executionContext;

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
	public ObservableBasicExecutionEngine(ModelExecutionContext executionContext) {
		//		if (decider == null)
		//			throw new IllegalArgumentException("decider");
		if (executionContext == null)
			throw new IllegalArgumentException("executionContext");

		_executionContext = executionContext;
		_lastStepsRun = new ArrayDeque<LogicalStep>(getDeadlockDetectionDepth());

		for(IMSEStateController c: _executionContext.getExecutionPlatform().getMSEStateControllers())
		{
			addMSEStateController(c);
		}
		_mseStateController = createEngineMSEStateController();
		addMSEStateController(_mseStateController);

		if (_executionContext.getRunConfiguration().isTraceActive())
			activateTrace();

		try {
			initialize();
		} catch (CoreException e) {
			throw new EngineNotCorrectlyInitialized(e.getMessage(), e);
		}
	}
	
	protected abstract IMSEStateController createEngineMSEStateController();

	private void initialize() throws CoreException 
	{
		for (IDataProcessingComponentExtension extension : _executionContext.getRunConfiguration().getActivatedComponentExtensions())
		{
			IDataProcessingComponent component = extension.instanciateComponent();
			_executionComponents.add(component);
			component.initialize(this);
		}	

		Activator.getDefault().info("*** Engine initialization done. ***");
	}

	private ArrayList<IDataProcessingComponent> _executionComponents = new ArrayList<>();

	private void activateTrace() {
		ModelExecutionTracingCapability capability = capability(ModelExecutionTracingCapability.class);
		capability.setModelExecutionContext(_executionContext);
	}

	
	private EngineRunnable _runnable;
	@Override
	public void start() 
	{
		if (!_started) 
		{
			for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
			{
				hook.engineAboutToStart(this);
			}
			engineStatus.setNbLogicalStepRun(0);
			_runnable = new EngineRunnable();
			Thread mainThread = new Thread(_runnable, "Gemoc engine " + _executionContext.getRunConfiguration().getExecutedModelURI());
			mainThread.start();
		}

	}

	@Override
	public void stop() 
	{
		terminated = true;
		if (_logicalStepDecider != null)
		{
			_logicalStepDecider.preempt();
		}
	}

	private void clean() {
		for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
		{
			hook.postStopEngine(this);
		}
		_mseStateControllers.clear();		
		_executionContext.dispose();

		for (IDataProcessingComponent component : _executionComponents)
		{
			component.dispose();
		}

		getEngineStatus().getCurrentLogicalStepChoice().clear();
		getEngineStatus().setChosenLogicalStep(null);
	}

	public EngineStatus getEngineStatus() {
		return engineStatus;
	}

	private static boolean areLogicalStepSimilar(LogicalStep ls1, LogicalStep ls2) {
		if (ls1 == ls2)
			return true;

		List<String> ls1TickedEventOccurences = new ArrayList<String>();
		for (Event event : LogicalStepHelper.getTickedEvents(ls1)) {
			ls1TickedEventOccurences.add(event.getName());
		}
		List<String> ls2TickedEventOccurences = new ArrayList<String>();
		for (Event event : LogicalStepHelper.getTickedEvents(ls2)) {
			ls2TickedEventOccurences.add(event.getName());
		}

		if (ls1TickedEventOccurences.size() == ls2TickedEventOccurences.size()) {
			if (ls1TickedEventOccurences.containsAll(ls2TickedEventOccurences)) {
				return true;
			}
		}
		return false;
	}

	private ILogicalStepDecider _logicalStepDecider;
	
	class EngineRunnable implements Runnable {
		
		public void run() {
			
			for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
			{
				hook.engineStarted(ObservableBasicExecutionEngine.this);
			}
			
			// register this engine using a unique name
			String engineName = Thread.currentThread().getName();
			engineName = Activator.getDefault().gemocRunningEngineRegistry.registerEngine(engineName, ObservableBasicExecutionEngine.this);

			engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
			setChanged();
			notifyObservers("Starting " + engineName);
			long count = 0;
			
			try 
			{
				while (!terminated) 
				{
					switchDeciderIfNecessary();
					if (hasCapability(ModelExecutionTracingCapability.class))
						updateTraceModelBeforeAskingSolver(count);
									
					computePossibleLogicalSteps();
					updatePossibleLogicalSteps();
					// 2- select one solution from available logical step /
					// select interactive vs batch
					int selectedLogicalStepIndex;
					if (_possibleLogicalSteps.size() == 0) {
						Activator.getDefault().debug("No more LogicalStep to run");
						terminated = true;
					} else {
						Activator.getDefault().debug("\t\t ---------------- LogicalStep " + count);
						engineStatus.setRunningStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
						notifyEngineHasChanged();
						selectedLogicalStepIndex = _executionContext.getLogicalStepDecider().decide(ObservableBasicExecutionEngine.this, _possibleLogicalSteps);
						count++;

						if (selectedLogicalStepIndex == -1) {
							if (hasRewindHappened()) {
								//								getCapability(ModelExecutionTracingCapability.class).getLastChoice();
								Activator.getDefault().debug("Back to past happened --> let the engine ignoring current steps.");
							} else {
								Activator.getDefault().debug("Engine cannot continue because decider did not decide anything.");
								terminated = true;
							}
						} else {
							engineStatus.setChosenLogicalStep(_possibleLogicalSteps.get(selectedLogicalStepIndex));
							engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
							if (hasCapability(ModelExecutionTracingCapability.class))
								updateTraceModelAfterDeciding(selectedLogicalStepIndex);

							notifyEngineHasChanged();
							for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
							{
								hook.postLogicalStepSelection(ObservableBasicExecutionEngine.this);
							}

							// 3 - run the selected logical step
							final LogicalStep logicalStepToApply = _possibleLogicalSteps.get(selectedLogicalStepIndex);
							// inform the solver that we will run this step
							getSolver().applyLogicalStepByIndex(selectedLogicalStepIndex);
							// run all the event occurrences of this logical
							// step
							executeLogicalStep(logicalStepToApply);
							terminateIfLastStepsSimilar(logicalStepToApply);
						}
					}

					notifyEngineHasChanged();
					engineStatus.incrementNbLogicalStepRun();
				} 
			} catch (Throwable e) {
				Activator.getDefault().error("Exception received " + e.getMessage() + ", stopping engine.", e);
				terminated = true;
			}
			finally {
				clean();
			}

			engineStatus.setRunningStatus(EngineStatus.RunStatus.Stopped);
			ObservableBasicExecutionEngine.this.setChanged();
			ObservableBasicExecutionEngine.this.notifyObservers("Stopping " + engineName);
		}

		private boolean hasRewindHappened() {
			if (hasCapability(ModelExecutionTracingCapability.class)) {
				return capability(ModelExecutionTracingCapability.class).hasRewindHappened(true);
			}
			return false;
		}

		private void terminateIfLastStepsSimilar(final LogicalStep logicalStepToApply) {
			// if all lastStepsRun are the same, then we may have reached the
			// end of the simulation
			_lastStepsRun.add(logicalStepToApply);
			boolean allLastLogicalStepAreTheSame = true;
			for (LogicalStep logicalStep : _lastStepsRun) {
				allLastLogicalStepAreTheSame = allLastLogicalStepAreTheSame && areLogicalStepSimilar(logicalStep, logicalStepToApply);
			}
			if ((_lastStepsRun.size() >= getDeadlockDetectionDepth()) && allLastLogicalStepAreTheSame) {
				Activator.getDefault().debug("Detected " + getDeadlockDetectionDepth() + " identical LogicalStep, stopping engine");
				terminated = true;
			}
			// if queue is full, remove one
			if (_lastStepsRun.size() > getDeadlockDetectionDepth())
				_lastStepsRun.poll();
		}

	}

	private void notifyEngineHasChanged() {
		ObservableBasicExecutionEngine.this.setChanged();
		ObservableBasicExecutionEngine.this.notifyObservers(); 
	}

	private int getDeadlockDetectionDepth() 
	{
		return _executionContext.getRunConfiguration().getDeadlockDetectionDepth();
	}
	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 */
	private void executeLogicalStep(LogicalStep logicalStepToApply) {
		// = step in debug mode, goes to next logical step
		// -> run all event occurrences of the logical step
		// step into / open internal thread and pause them
		// each concurrent event occurrence is presented as a separate
		// thread in the debugger
		// execution feedback is sent to the solver so it can take internal
		// event into account

		for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
		{
			hook.aboutToExecuteLogicalStep(this, logicalStepToApply);
		}

		Collection<IMSEOccurrence> mseOccurences = MSEOccurrenceFactory.createMSEOccurrences(logicalStepToApply, _executionContext.getFeedbackModel());	
		for (final IMSEOccurrence mseOccurence : mseOccurences) 
		{
			executeAssociatedActions(mseOccurence.getMSE());
			executeModelSpecificEvent(mseOccurence.getMSE());
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
	
	private void executeModelSpecificEvent(ModelSpecificEvent mse)
	{
		if (mse.getAction() != null) 
		{			
			for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
			{
				hook.aboutToExecuteMSE(this, mse);
			}
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
				execution = new SynchroneExecution(mse, this);				
			}
			else
			{
				execution = new ASynchroneExecution(mse, whenStatements, _mseStateController, this);
			}
			execution.run();
		}
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + getCodeExecutor() + " ; Solver=" + getSolver() + " ; ModelResource=" + _executionContext.getResourceModel()+ "]";
	}

	private ArrayList<IMSEStateController> _mseStateControllers = new ArrayList<IMSEStateController>();
	private void addMSEStateController(IMSEStateController controller) 
	{
		_mseStateControllers.add(controller);
	}

	private ArrayList<IExecutionEngineCapability> _capabilities = new ArrayList<IExecutionEngineCapability>();

	public <T extends IExecutionEngineCapability> boolean hasCapability(Class<T> type) {
		for (IExecutionEngineCapability c : _capabilities) {
			if (c.getClass().equals(type))
				return true;
		}
		return false;
	}

	@SuppressWarnings("all")
	public <T extends IExecutionEngineCapability> T getCapability(Class<T> type) {
		for (IExecutionEngineCapability c : _capabilities) {
			if (c.getClass().equals(type))
				return (T) c;
		}
		return null;
	}

	public <T extends IExecutionEngineCapability> T capability(Class<T> type) {
		T capability = getCapability(type);
		if (capability == null) {
			try {
				capability = type.newInstance();
				capability.initialize(this);
				_capabilities.add(capability);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return capability;
	}

	public ArrayList<IMSEStateController> get_clockControllers() {
		return _mseStateControllers;
	}

	@Override
	public IExecutionContext getExecutionContext() {
		return _executionContext;
	}

	private void switchDeciderIfNecessary()
	{
		if (_executionContext.getLogicalStepDecider() != null
			&& _executionContext.getLogicalStepDecider() != _logicalStepDecider)
		{
			_logicalStepDecider = _executionContext.getLogicalStepDecider();
		}
	}

	private List<LogicalStep> _possibleLogicalSteps;
	private void computePossibleLogicalSteps() 
	{
		_possibleLogicalSteps = getSolver().computeAndGetPossibleLogicalSteps();
	}

	@Override
	public List<LogicalStep> getPossibleLogicalSteps() 
	{
		return _possibleLogicalSteps;
	}
	
	private void updatePossibleLogicalSteps()
	{
		for(IMSEStateController c : _mseStateControllers)
		{
			c.applyMSEFutureStates(getSolver());
		}
		_possibleLogicalSteps = getSolver().updatePossibleLogicalSteps();
		engineStatus.updateCurrentLogicalStepChoice(_possibleLogicalSteps);
		updateTraceModelBeforeDeciding(_possibleLogicalSteps);			
		notifyEngineHasChanged();
		for (IEngineHook hook : _executionContext.getExecutionPlatform().getHooks()) 
		{
			hook.preLogicalStepSelection(ObservableBasicExecutionEngine.this);
		}
	}
	
	public void recomputePossibleLogicalSteps()
	{
		getSolver().revertForceClockEffect();
		updatePossibleLogicalSteps();
	}
	
	private void updateTraceModelAfterDeciding(final int selectedLogicalStepIndex) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelAfterDeciding(selectedLogicalStepIndex);
	}

	private void updateTraceModelBeforeAskingSolver(final long count) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeAskingSolver(count);
	}

	private void updateTraceModelBeforeDeciding(final List<LogicalStep> possibleLogicalSteps) 
	{
		if (hasCapability(ModelExecutionTracingCapability.class))
			capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeDeciding(possibleLogicalSteps);
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

	private ISolver getSolver()
	{
		return _executionContext.getExecutionPlatform().getSolver();
	}
	
	private ICodeExecutor getCodeExecutor()
	{
		return _executionContext.getExecutionPlatform().getCodeExecutor();		
	}
}
