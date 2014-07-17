package org.gemoc.execution.engine.core;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.capabilitites.ModelExecutionTracingCapability;
import org.gemoc.execution.engine.commons.deciders.CcslSolverDecider;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.commons.dsa.IAliveClockController;
import org.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine.EngineRunnable;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EngineEventOccurence;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.IDSLDebugger;

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
public class ObservableBasicExecutionEngine extends Observable implements GemocExecutionEngine {

	private IDSLDebugger _debugger;

	private IGemocModelAnimator 	animator;

	private boolean started = false;
	private boolean terminated = false;

	
	private IRunConfiguration _runConfiguration;
	
	protected EngineStatus engineStatus = new EngineStatus();

	// todo place this in the run configuration
	protected int nbLastStepRunObservedForStopDetection = 10;
	
	/**
	 * used to detect
	 */
	protected ArrayDeque<LogicalStep> lastStepsRun = new ArrayDeque<LogicalStep>(nbLastStepRunObservedForStopDetection);

	/**
	 * Given at the language-level initialization.
	 */
	protected Solver solver = null;
	protected EventExecutor _eventExecutor = null;
	private CodeExecutor _codeExecutor = null;
	protected FeedbackPolicy feedbackPolicy = null;
	protected ILogicalStepDecider logicalStepDecider = null;

	public ILogicalStepDecider getLogicalStepDecider() {
		return logicalStepDecider;
	}

	protected Set<IEngineHook> registeredEngineHooks = new HashSet<IEngineHook>();

	private ModelExecutionContext _executionContext;
	/**
	 * resource of the user model being executed this is the resource with
	 * dynamic information (from DSA) (not the raw model)
	 */
	protected Resource _modelUnderExecutionResource = null;

	private Choice _lastChoice;

//	public ExecutionTraceModel getExecutionTrace() {
//		return _executionTraceModel;
//	}

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
	public ObservableBasicExecutionEngine(Solver solver, EventExecutor executor, CodeExecutor codeExecutor, FeedbackPolicy feedbackPolicy, ILogicalStepDecider decider,
			ModelExecutionContext executionContext,
			IRunConfiguration runConfiguration) {

		_runConfiguration = runConfiguration;
		
		// The engine needs AT LEAST a mocEventsResource,
		// domainSpecificEventsResource, a Solver,
		// an EventExecutor.
		if (solver == null | executor == null | feedbackPolicy == null) {
			StringBuilder exceptionMessage = new StringBuilder();
			if (solver == null) {
				exceptionMessage.append(", solver is null, ");
			}
			if (executor == null) {
				exceptionMessage.append(", eventExecutor is null, ");
			}
			String message = "Language definition is incomplete" + exceptionMessage; 
			Activator.getDefault().error(message);
			throw new EngineNotCorrectlyInitialized(message);
		} else {
			Activator.getDefault().info("\tSolver=" + solver);
			Activator.getDefault().info("\tExecutor=" + executor);

			if (feedbackPolicy == null) {
				String msg = "FeedbackPolicy is null";
				Activator.getDefault().warn(msg, new NullPointerException(msg));
			} else {
				this.feedbackPolicy = feedbackPolicy;
				Activator.getDefault().info("\tFeedbackPolicy=" + feedbackPolicy);
			}

			_executionContext = executionContext;

			this.solver = solver;
			_codeExecutor = codeExecutor;
			this._eventExecutor = executor;
			this._eventExecutor.initialize();
			this.logicalStepDecider = decider;
			if (this.logicalStepDecider == null) {
				if (solver instanceof CcslSolver) {
					Activator.getDefault().warn("LogicalStepDecider not set,  using default SolverDecider");
					this.logicalStepDecider = new CcslSolverDecider((CcslSolver) solver);
				} else {
					throw new EngineNotCorrectlyInitialized("LogicalStepDecider not set and cannot use default CcslSolverDecider");
				}
			}
		}
	}

	private TransactionalEditingDomain _editingDomain;

	@Override
	public void initialize(Resource resource, TransactionalEditingDomain editingDomain) {

		_editingDomain = editingDomain;

		// Create the modelResource from the modelURI using the modelLoader.
		_modelUnderExecutionResource = resource;

		ResourceSet rs = _modelUnderExecutionResource.getResourceSet();



		ClockConstraintSystem clockConstraintSystem = null;
		for(Resource r : rs.getResources())
		{
			if (r.getContents().get(0) instanceof ClockConstraintSystem) 
			{
				clockConstraintSystem = (ClockConstraintSystem)r.getContents().get(0);
				break;
			}			
		}
		for (IAliveClockController injector : _clockControllers)
		{
			EventInjectionContext context = new EventInjectionContext(solver, clockConstraintSystem);
			injector.initialize(context);
			injector.start();
		}
		
		Activator.getDefault().info("*** Engine initialization done. ***");
	}
	
	public void activateTrace() {
		ModelExecutionTracingCapability capability = capability(ModelExecutionTracingCapability.class);
		capability.setEditingDomain(_editingDomain);
		capability.setModelExecutionContext(_executionContext);
	}

	@Override
	public void start() {
		if (!this.started) {
			for (IEngineHook hook : registeredEngineHooks) {
				hook.preStartEngine(this);
			}
			engineStatus.setNbLogicalStepRun(0);
			Runnable execution = new EngineRunnable();
			Thread mainThread = new Thread(execution, "Gemoc engine " + _runConfiguration.getModelURIAsString());
			mainThread.start();
		}

	}

	@Override
	public void stop() {
		logicalStepDecider.dispose();
		terminated = true;
		for (IEngineHook hook : registeredEngineHooks) {
			hook.postStopEngine(this);
		}
	}

	private void clean() {
		URI uri = URI.createPlatformResourceURI(_executionContext.getDebuggerViewModelPath().toOSString(), true);
		Session session = SessionManager.INSTANCE.getSession(uri, new NullProgressMonitor());
		// for (Resource r :
		// session.getTransactionalEditingDomain().getResourceSet().getResources())
		// {
		// r.unload();
		// }
		// for (Resource r :
		// session.getTransactionalEditingDomain().getResourceSet().getResources())
		// {
		// try {
		// r.load(null);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		//

		for (IAliveClockController injector : _clockControllers)
		{
			injector.stop();
		}
		_clockControllers.clear();
		
		session.close(new NullProgressMonitor());
		SessionManager.INSTANCE.remove(session);
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

	class EngineRunnable implements Runnable {
		public void run() {
			// register this engine using a unique name
			String engineName = Thread.currentThread().getName();
			engineName = Activator.getDefault().gemocRunningEngineRegistry.registerNewEngine(engineName, ObservableBasicExecutionEngine.this);

			if (_debugger != null) {
				// connect the debugger to the model being executed (including
				// dynamic data)
				_debugger.spawnRunningThread(Thread.currentThread().getName(), _modelUnderExecutionResource.getContents().get(0));
			}
			engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
			ObservableBasicExecutionEngine.this.setChanged();
			ObservableBasicExecutionEngine.this.notifyObservers("Starting " + engineName); // use
																							// a
																							// simple
																							// message
																							// for
																							// the
																							// console
																							// observer
			long count = 0;

			try {
				while (!terminated) {
					try {
						if (hasCapability(ModelExecutionTracingCapability.class))
							updateTraceModelBeforeAskingSolver(count);
						
//						solver.freeEnvironmentBDD();
//						
						for(IAliveClockController cc : _clockControllers)
						{
							cc.makeClocksTickOrNotTick();
						}
						
						// 1- ask solver possible solutions for this step (set
						// of
						// logical steps | 1 logical step = set of simultaneous
						// event occurence)
						// TODO WARNING current implementation of
						// getPossibleLogicalSteps() applies a LogicalStep to
						// the
						// solver, make sure to call it only once
						List<LogicalStep> possibleLogicalSteps = solver.getPossibleLogicalSteps();
						engineStatus.updateCurrentLogicalStepChoice(possibleLogicalSteps);
						notifyEngineHasChanged();
						for (IEngineHook hook : registeredEngineHooks) {
							hook.preLogicalStepSelection(ObservableBasicExecutionEngine.this);
						}
						// 2- select one solution from available logical step /
						// select interactive vs batch
						int selectedLogicalStepIndex;
						if (possibleLogicalSteps.size() == 0) {
							Activator.getDefault().debug("No more LogicalStep to run");
							terminated = true;
						} else {
							Activator.getDefault().debug("\t\t ---------------- LogicalStep " + count);
							engineStatus.setRunningStatus(EngineStatus.RunStatus.WaitingLogicalStepSelection);
							if (hasCapability(ModelExecutionTracingCapability.class))
								updateTraceModelBeforeDeciding(possibleLogicalSteps);
							notifyEngineHasChanged();
							selectedLogicalStepIndex = logicalStepDecider.decide(possibleLogicalSteps);
							count++;

							if (selectedLogicalStepIndex == -1) {
								if (hasRewindHappened()) {
									_lastChoice = getCapability(ModelExecutionTracingCapability.class).getLastChoice();
									Activator.getDefault().debug("Back to past happened --> let the engine ignoring current steps.");
								} else {
									Activator.getDefault().debug("Engine cannot continue because decider did not decide anything.");
									terminated = true;
								}
							} else {
								engineStatus.setChosenLogicalStep(possibleLogicalSteps.get(selectedLogicalStepIndex));
								engineStatus.setRunningStatus(EngineStatus.RunStatus.Running);
								if (hasCapability(ModelExecutionTracingCapability.class))
									updateTraceModelAfterDeciding(selectedLogicalStepIndex);

								notifyEngineHasChanged();
								for (IEngineHook hook : registeredEngineHooks) {
									hook.postLogicalStepSelection(ObservableBasicExecutionEngine.this);
								}

								// 3 - run the selected logical step
								final LogicalStep logicalStepToApply = possibleLogicalSteps.get(selectedLogicalStepIndex);
								// inform the solver that we will run this step
								solver.applyLogicalStepByIndex(selectedLogicalStepIndex);
								// run all the event occurrences of this logical
								// step
								doLogicalStep(logicalStepToApply);
								// if not debugging wait if needed
								applyAnimationTime();
								terminateIfLastStepsSimilar(logicalStepToApply);
							}
						}

						notifyEngineHasChanged();
						engineStatus.incrementNbLogicalStepRun();

					} catch (Throwable e) {
						Activator.getDefault().error("Exception received " + e.getMessage() + ", stopping engine.", e);
						terminated = true;
					} finally {
						if (animator != null) {
							animator.clear(this);
						}
					}
				}

			} finally {
				clean();
			}

			// inform the debugger UI that the thread is terminated
			if (_debugger != null && !_debugger.isTerminated(Thread.currentThread().getName())) {
				_debugger.terminated(Thread.currentThread().getName());
				setDebugger(null); // make sure to release handles
			}

			engineStatus.setRunningStatus(EngineStatus.RunStatus.Stopped);
			ObservableBasicExecutionEngine.this.setChanged();
			ObservableBasicExecutionEngine.this.notifyObservers("Stopping " + engineName);

			// TODO remove the engine from registered running engines
		}

		private void applyAnimationTime() throws InterruptedException {
			int animationDelay = _runConfiguration.getAnimationDelay();								
			if (animationDelay != 0) 
			{
				Thread.sleep(animationDelay);
			}
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
			lastStepsRun.add(logicalStepToApply);
			boolean allLastLogicalStepAreTheSame = true;
			for (LogicalStep logicalStep : lastStepsRun) {
				allLastLogicalStepAreTheSame = allLastLogicalStepAreTheSame && areLogicalStepSimilar(logicalStep, logicalStepToApply);
			}
			if ((lastStepsRun.size() >= nbLastStepRunObservedForStopDetection) && allLastLogicalStepAreTheSame) {
				Activator.getDefault().debug("Detected " + nbLastStepRunObservedForStopDetection + " identical LogicalStep, stopping engine");
				terminated = true;
			}
			// if queue is full, remove one
			if (lastStepsRun.size() > nbLastStepRunObservedForStopDetection)
				lastStepsRun.poll();
		}

		private void notifyEngineHasChanged() {
			ObservableBasicExecutionEngine.this.setChanged();
			ObservableBasicExecutionEngine.this.notifyObservers(); 
		}

		private void updateTraceModelAfterDeciding(final int selectedLogicalStepIndex) {
			if (hasCapability(ModelExecutionTracingCapability.class))
				capability(ModelExecutionTracingCapability.class).updateTraceModelAfterDeciding(selectedLogicalStepIndex);
		}

		private void updateTraceModelBeforeAskingSolver(final long count) {
			if (hasCapability(ModelExecutionTracingCapability.class))
				capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeAskingSolver(count);
		}

		private void updateTraceModelBeforeDeciding(final List<LogicalStep> possibleLogicalSteps) {
			if (hasCapability(ModelExecutionTracingCapability.class))
				capability(ModelExecutionTracingCapability.class).updateTraceModelBeforeDeciding(possibleLogicalSteps);
		}

	}

	/**
	 * run all the event occurrences of this logical step
	 * 
	 * @param logicalStepToApply
	 */
	public void doLogicalStep(LogicalStep logicalStepToApply) {
		// = step in debug mode, goes to next logical step
		// -> run all event occurrences of the logical step
		// step into / open internal thread and pause them
		// each concurrent event occurrence is presented as a separate
		// thread in the debugger
		// execution feedback is sent to the solver so it can take internal
		// event into account

		if (_debugger != null) {
			terminated = !_debugger.control(Thread.currentThread().getName(), logicalStepToApply);
		}
		
		if (animator != null) {
			animator.activate(this, logicalStepToApply);
		}

		List<EngineEventOccurence> engineEventOccurences = new ArrayList<EngineEventOccurence>();
		for (Event event : LogicalStepHelper.getTickedEvents(logicalStepToApply)) {
			/*
			 * for (EventOccurrence eventOccurrence : logicalStepToApply
			 * .getEventOccurrences()) { if (eventOccurrence.getFState() ==
			 * FiredStateKind.TICK && eventOccurrence.getReferedElement() !=
			 * null) { if (eventOccurrence.getReferedElement() instanceof
			 * ModelElementReference) { ModelElementReference mer =
			 * (ModelElementReference) eventOccurrence .getReferedElement();
			 * if(mer.getElementRef().size() ==1 && mer.getElementRef().get(0)
			 * instanceof Event){ Event event = (Event)
			 * mer.getElementRef().get(0);
			 */
			if (event.getReferencedObjectRefs().size() == 2) {
				if (event.getReferencedObjectRefs().get(1) instanceof EOperation) {
					EObject targetModelElement = event.getReferencedObjectRefs().get(0);
					EOperation targetOperation = (EOperation) event.getReferencedObjectRefs().get(1);
					//Activator.getDefault().info("event occurence: target=" + targetModelElement.toString() + " operation=" + targetOperation.getName());
					// TODO verify that solver and engine work on the same
					// resource ...

					// build the list of simplified eventOccurence from solver
					EngineEventOccurence engineEventOccurence = new EngineEventOccurence(targetModelElement, targetOperation);
					engineEventOccurences.add(engineEventOccurence);
				} else {
					//Activator.getDefault().warn("event occurence: TICK Event=" + event.getName() + " ReferencedObjectRefs=" + event.getReferencedObjectRefs());
					EngineEventOccurence engineEventOccurence = new EngineEventOccurence(event.getReferencedObjectRefs().get(0), null);
					engineEventOccurences.add(engineEventOccurence);
				}
			} else {
				if (event.getReferencedObjectRefs().size() == 1) {
					//Activator.getDefault().warn("event occurence: TICK Event=" + event.getName() + " ReferencedObjectRefs=" + event.getReferencedObjectRefs());
					EngineEventOccurence engineEventOccurence = new EngineEventOccurence(event.getReferencedObjectRefs().get(0), null);
					engineEventOccurences.add(engineEventOccurence);
				} 
//				else {
//					Activator.getDefault().debug("event occurence: TICK Event=" + event.getName() + " ReferencedObjectRefs=" + event.getReferencedObjectRefs());
//				}
			}
			// }
			// else{
			// String stringOfTheECLEventCorrespondingToTheTickingClock = mer
			// .getElementRef().get(0).toString();
			// Activator.getMessagingSystem().debug(
			// "event occurence: TICK target="
			// + stringOfTheECLEventCorrespondingToTheTickingClock,
			// Activator.PLUGIN_ID);
			// }
		}
		// TODO verify if we need to pause on this LogicalStep due to breakpoint
		// on one of the eventOccurence

		// run the event
		for (final EngineEventOccurence engineEventOccurence : engineEventOccurences) {
			// FIXME can pause on each eventoccurence, should be done in
			// separate threads if we support step into or globally at the
			// LogicalStep level
			if (_debugger != null) {
				terminated = !_debugger.control(Thread.currentThread().getName(), engineEventOccurence.getTargetObject());
			}

			if (engineEventOccurence.getTargetOperation() != null) {
				final FeedbackData res = callExecutor(engineEventOccurence);
				// send result as feedback to the solver
				// process feedback may influence the solver results for
				// next step
				// FeedbackData feedbackData = new FeedbackData(res,
				// engineEventOccurence);
				if (res != null) {
					feedbackPolicy.processFeedback(res, ObservableBasicExecutionEngine.this);
				}
			}

		}
	}

	/**
	 * Calls the {@link EventExecutor} for the given
	 * {@link EngineEventOccurence}.
	 * 
	 * @param engineEventOccurence
	 *            the {@link EngineEventOccurence} to execute
	 * @return the {@link FeedbackData} if any, <code>null</code> other wise
	 */
	protected FeedbackData callExecutor(final EngineEventOccurence engineEventOccurence) {
		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(ObservableBasicExecutionEngine.this._modelUnderExecutionResource.getResourceSet());
		FeedbackData res = null;
		if (editingDomain != null) {
			final RecordingCommand command = new RecordingCommand(editingDomain) {
				private List<FeedbackData> result = new ArrayList<FeedbackData>();

				@Override
				protected void doExecute() {
					try {
						result.add(_eventExecutor.execute(engineEventOccurence));
					} catch (EventExecutionException e) {
						Activator.getDefault().error("Exception received " + e.getMessage(), e);
					}
				}

				@Override
				public Collection<?> getResult() {
					return result;
				}
			};
			editingDomain.getCommandStack().execute(command);
			res = (FeedbackData) command.getResult().iterator().next();
		} else {
			try {
				res = _eventExecutor.execute(engineEventOccurence);
			} catch (EventExecutionException e) { 
				Activator.getDefault().error("Exception received " + e.getMessage(), e);
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + this._eventExecutor + " ; Solver=" + this.solver + " ; ModelResource=" + this._modelUnderExecutionResource + "]";
	}

	/* Getters and Setters */
	@Override
	public Resource getModelUnderExecutionResource() {
		return _modelUnderExecutionResource;
	}

//	public IDSLDebugger getDebugger() {
//		return debugger;
//	}

	public void setDebugger(GemocModelDebugger debugger) {
		_debugger = debugger;
	}

//	public IGemocModelAnimator getAnimator() {
//		return animator;
//	}

	public void setAnimator(IGemocModelAnimator animator) {
		this.animator = animator;
	}

	public void addEngineHook(IEngineHook newEngineHook) {
		registeredEngineHooks.add(newEngineHook);
	}

	@Override
	public void removeEngineHook(IEngineHook removedEngineHook) {
		registeredEngineHooks.remove(removedEngineHook);
	}

	private ArrayList<IAliveClockController> _clockControllers = new ArrayList<IAliveClockController>();
	public void addClockController(IAliveClockController controller) 
	{
		_clockControllers.add(controller);
	}
	
	private ArrayList<IExecutionEngineCapability> _capabilities = new ArrayList<IExecutionEngineCapability>();

	public <T extends IExecutionEngineCapability> boolean hasCapability(Class<T> type) {
		for (IExecutionEngineCapability c : _capabilities) {
			if (c.getClass().equals(type))
				return true;
		}
		return false;
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return capability;
	}

	@Override
	public Solver getSolver() {
		return solver;
	}

	@Override
	public CodeExecutor getCodeExecutor() {
		return _codeExecutor;
	}

	public ArrayList<IAliveClockController> get_clockControllers() {
		return _clockControllers;
	}


}
