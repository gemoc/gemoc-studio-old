package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.util.Queue;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.impl.GemocModelDebugger;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngineEventControl;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;
import org.gemoc.gemoc_language_workbench.api.exceptions.InvokationResultConvertionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.FiredStateKind;
import fr.inria.aoste.trace.LogicalStep;
import gepl.Every;
import gepl.MocEvent;
import gepl.Pattern;
import glml.DomainSpecificEvent;
import glml.DomainSpecificEventFile;
import glml.ModelSpecificEvent;
import glml.Visibility;

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
 * @see GemocExecutionEngine
 * 
 * @author flatombe
 * 
 */
public class ObservableBasicExecutionEngine extends Observable
		implements GemocExecutionEngine {

	private GemocModelDebugger debugger;

	private boolean started;
	
	boolean terminated;
	
	/**
	 * Derived from the language-specific elements using the loaded model.
	 */
	public Resource modelOfExecution = null;
	private Map<String, ModelSpecificEvent> modelSpecificEventsRegistry = null;
	private Resource solverInput = null;
	
	private EventInjector eventInjector = new BasicEventInjector();


	/**
	 * The current LogicalStep being "executed" by this engine. This means that
	 * any event, injected or internal, must be allowed by this LogicalStep. The
	 * associated events scheduled for this step can be retrieved in the map
	 * {@link #scheduledEventsMap}
	 * 
	 * @see scheduledEventsMap
	 */
	protected LogicalStep currentStep = null;

	/**
	 * Memorizing the MSEs found at the current step so we do not have to
	 * compute it everytime.
	 */
	protected Collection<ModelSpecificEvent> currentPossibleEvents = null;

	/**
	 * The stack of LogicalSteps. If there is no step in this stack when the
	 * engine needs to proceed to the next step, then a new step is required
	 * from the MoC Solver. This means that TODO if we want to be able to go
	 * back in the past, and then move forward towards a different future than
	 * the one we come from, then we need to change the logic of the engine in
	 * {@link #getScheduledOrSolverStep()}.
	 */
	protected Queue<LogicalStep> scheduledSteps = null;

	/**
	 * A map that associates a LogicalStep with its scheduled events. This means
	 * that not all the events scheduled are executed, since some may be illegal
	 * with regards to the MoC.
	 */
	protected Map<LogicalStep, List<ModelSpecificEvent>> scheduledEventsMap = null;

	/**
	 * A map containing all the LogicalSteps that have been "executed" (as in,
	 * execution has been done with this step as the MoC authority) and in which
	 * order.
	 */
	protected Map<Integer, LogicalStep> schedulingTrace;

	/**
	 * A map containing all the steps that have been "executed" and their
	 * associated ModelSpecificEvents which have actually been executed.
	 */
	protected Map<LogicalStep, List<ModelSpecificEvent>> executionTrace;

	/**
	 * Given at the model-level initialization.
	 */
	protected ModelLoader modelLoader = null;
	protected Resource modelResource = null;

	/**
	 * Derived from the above model-specific elements
	 */
	protected String modelStringURI = null;

	/**
	 * Given at the language-level initialization.
	 */
	protected Solver solver = null;
	protected EventExecutor executor = null;
	protected FeedbackPolicy feedbackPolicy = null;
	protected Resource domainSpecificEventsResource = null;
	protected Resource mocEventsResource = null;

	/**
	 * Derived from the above language-specific elements
	 */
	protected Map<String, DomainSpecificEvent> domainSpecificEventsRegistry = null;

	/**
	 * Given by the MoC at instanciation.
	 */
	protected Map<String, MocEvent> mocEventsRegistry = null;

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
	 */
	public ObservableBasicExecutionEngine(Resource mocEventsResource,
			Resource domainSpecificEventsResource, Solver solver,
			EventExecutor executor, FeedbackPolicy feedbackPolicy) {

		// The engine needs AT LEAST a mocEventsResource,
		// domainSpecificEventsResource, a Solver,
		// an EventExecutor.
		if (mocEventsResource == null | domainSpecificEventsResource == null
				| solver == null | executor == null | feedbackPolicy == null) {
			StringBuilder exceptionMessage = new StringBuilder();
			if (mocEventsResource == null) {
				exceptionMessage.append(", mocEventsResource is null, ");
			}
			if (domainSpecificEventsResource == null) {
				exceptionMessage
				exceptionMessage.append(", domainSpecificEventsResource is null, ");
			}
			if (solver == null) {
				exceptionMessage.append(", solver is null, ");
			}
			if (executor == null) {
				exceptionMessage.append(", eventExecutor is null, ");
			}
			Activator.getMessagingSystem().error(
					"Language definition is incomplete" + exceptionMessage,
					Activator.PLUGIN_ID);

			throw new EngineNotCorrectlyInitialized(
			throw new EngineNotCorrectlyInitialized("Language definition is incomplete"+exceptionMessage);	
		} else {
			Activator
					.getMessagingSystem()
					.info("...OK. Instantiating ObservableBasicExecutionEngine with...",
							Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info(
					"\tMocEventsResource=" + mocEventsResource,
					Activator.PLUGIN_ID);
			Activator
					.getMessagingSystem()
					.info("\tDomainSpecificEventsResource="
							+ domainSpecificEventsResource, Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info("\tSolver=" + solver,
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info("\tExecutor=" + executor,
					Activator.PLUGIN_ID);

			if (feedbackPolicy == null) {
				String msg = "FeedbackPolicy is null";
				Activator.warn(msg, new NullPointerException(msg));
			} else {
				this.feedbackPolicy = feedbackPolicy;
				Activator.getMessagingSystem().info(
						"\tFeedbackPolicy=" + feedbackPolicy,
						Activator.PLUGIN_ID);
			}

			this.mocEventsResource = mocEventsResource;
			this.domainSpecificEventsResource = domainSpecificEventsResource;
			this.solver = solver;
			this.executor = executor;
			this.executor.initialize();

			this.mocEventsRegistry = this.solver
					.createMocEventsRegistry(this.mocEventsResource);
			this.domainSpecificEventsRegistry = this
					.createDomainSpecificEventsRegistry(this.domainSpecificEventsResource);

			this.scheduledEventsMap = new LinkedHashMap<LogicalStep, List<ModelSpecificEvent>>();
			this.scheduledSteps = new LinkedList<LogicalStep>();
			this.schedulingTrace = new HashMap<Integer, LogicalStep>();
			this.executionTrace = new LinkedHashMap<LogicalStep, List<ModelSpecificEvent>>();
		}
	}

	
	
	/**
	 * Returns a map with Domain-Specific Events names as keys and the
	 * Domain-Specific Events as values. This is done like this because we will
	 * match the Domain-Specific Events using their names : they should appear
	 * in the LogicalStep produced by the MoC solver.
	 * 
	 * @param domainSpecificEventsResource
	 * @return
	 */
	private Map<String, DomainSpecificEvent> createDomainSpecificEventsRegistry(
			Resource domainSpecificEventsResource) {
		Map<String, DomainSpecificEvent> res = new HashMap<String, DomainSpecificEvent>();
		DomainSpecificEventFile dseFile = (DomainSpecificEventFile) domainSpecificEventsResource
				.getContents().get(0);
		for (DomainSpecificEvent dse : dseFile.getLanguageEvents()) {
			res.put(dse.getName(), dse);
		}
		return res;
	}

	@Override
	public void initialize(String modelURI, String modelOfExecutionURI, ModelLoader modelLoader) {
		Activator.getMessagingSystem().info(
				"Verifying input before instanciating GemocExecutionEngine...",
				Activator.PLUGIN_ID);

		// modelURI cannot be null, modelLoader cannot be null.
		if (modelURI == null | modelLoader == null) {
			String exceptionMessage = "";
			if (modelURI == null) {
				exceptionMessage += "modelURI is null, ";
			}
			if (modelOfExecutionURI == null) {
				exceptionMessage += "modelOfExecutionURI is null, ";
			}
			if (modelLoader == null) {
				exceptionMessage += "modelLoader is null, ";
			}
			Activator.getMessagingSystem().info(
					"...NOK. Throwing EngineNotCorrectlyInitialized.",
					Activator.PLUGIN_ID);
			throw new EngineNotCorrectlyInitialized("Engine not correctly initialized "+exceptionMessage);
		} else {
			Activator.getMessagingSystem().info(
					"...OK. Initializing GemocExecutionEngine with...",
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info("\tmodelURI: " + modelURI,
					Activator.PLUGIN_ID);
			Activator.getMessagingSystem().info(
					"\tmodelLoader: " + modelLoader, Activator.PLUGIN_ID);

			this.modelStringURI = modelURI;
			this.modelLoader = modelLoader;

			// Create the modelResource from the modelLoader and the modelURI.
			this.modelResource = this.modelLoader.loadModel(modelURI);

			Activator.getMessagingSystem().info(
					"Model was successfully loaded: "
							+ modelResource.toString(), Activator.PLUGIN_ID);

			// TODO: Invoke the transformation that creates the model of
			// execution from the DSEs.

			// TFSM Sample
			// this.modelOfExecution = new ResourceSetImpl()
			// .getResource(
			// URI.createPlatformResourceURI(
			// "/org.gemoc.sample.tfsm.instances/TrafficControl/test/MyModelSpecificEvents.glml",
			// true), true);

			// Petrinet Sample
			if(this.modelOfExecution == null){
				this.modelOfExecution = new ResourceSetImpl()
					.getResource(
							URI.createPlatformResourceURI(modelOfExecutionURI,
									true), true);
			}
			
			// TODO : remove when EclToCCslTranslator gets implemented.
			try {
				Resource solverInput = this.solver.getSolverInputBuilder()
						.build(this.modelOfExecution);

				this.solverInput = solverInput;

			} catch (UnsupportedOperationException e) {
				// TFSM Sample
				// String solverInputFilePath =
				// "/org.gemoc.sample.tfsm.instances/TrafficControl/test/test_executionModel.extendedCCSL";
				// Petrinet Sample
				String solverInputFilePath = "/org.gemoc.sample.petrinet/instances/test_1/BasicExample_MoCC.extendedCCSL";

				// String solverInputFilePath =
				// "/org.gemoc.sample.tfsm.instances/TrafficControl/test/MySolverInput.javasolverinput";
				this.solverInput = new ResourceSetImpl().getResource(URI
						.createPlatformResourceURI(solverInputFilePath, true),
						true);
				// this.solver.input.load(null) ???
			}

			// Then we place the created solverInput into the solver
			this.solver.setSolverInputFile(this.solverInput.getURI());

			// We create the internal representation of the MSEs.
			this.modelSpecificEventsRegistry = this
					.createModelSpecificEventsRegistry(this.modelOfExecution);

			// We proceed to the first step of execution (a new one coming from
			// the solver or the first coming from a loaded scenario !)
			this.setCurrentStepAndUpdateTraces(this.getScheduledOrSolverStep());

			Activator.getMessagingSystem().info(
					"*** Engine initialization done. ***", Activator.PLUGIN_ID);
		}
	}

	/**
	 * Instantiates a Collection of Model-Specific Events depending on which
	 * event occurrences are in the Step returned by the Solver.
	 * 
	 * @param step
	 * @return
	 */
	protected Collection<ModelSpecificEvent> match(Map<Integer, LogicalStep> schedulingTrace) {
		Activator.getMessagingSystem().debug(
				"Matching against the following scheduling trace:\n"
						+ this.mapToString(this.schedulingTrace),
				Activator.PLUGIN_ID);
		Collection<ModelSpecificEvent> res = new ArrayList<ModelSpecificEvent>();
		for (ModelSpecificEvent mse : this.modelSpecificEventsRegistry.values()) {
			if (this.patternOfEventOccursInSchedulingTrace(mse, schedulingTrace) == true) {
				res.add(mse);
			}
		}
		return res;
	}

	@Override
	public void start() {
		if (!this.started) {
			Runnable execution = new Runnable() {
				public void run() {
					if (getDebugger() != null) {
						getDebugger().spawnRunningThread(Thread.currentThread().getName(), modelResource.getContents().get(0));
					}

					Collection<ModelSpecificEvent> eventToRun = eventInjector.getEventToInject(getCurrentPossibleEvents());
//					Activator.getMessagingSystem().debug(
//							"Allowed events are: " + allowedEvents.toString(),
//							Activator.PLUGIN_ID);
					while (!terminated && eventToRun.size() != 0) {
						try {
							
							// 1- ask solver possible solutions for this step (set of logical steps | 1 logical step = set of simultaneous event occurence)
							// 2- select one solution from available logical step / select interactive vs batch
							// 3 - run the selected logical step 
							//		= step in debug mode, goes to next logical step
							//        ->  run all event occurrences of the logical step 
							//				step into / open internal thread and pause them
							//				each concurrent event occurrence is presented as a separate thread in the debugger
							//				
							
							
							injectEventsToCurrentStep(eventToRun);
						
							doOneStep();
							Activator.getMessagingSystem().info("<<Step finished",Activator.PLUGIN_ID);
							Activator.getMessagingSystem().info("Execution Trace: \n"
											+ mapToString(ObservableBasicExecutionEngine.this.executionTrace),
											Activator.PLUGIN_ID);
							setCurrentStepAndUpdateTraces(ObservableBasicExecutionEngine.this
											.getScheduledOrSolverStep());
							eventToRun = eventInjector.getEventToInject(getCurrentPossibleEvents());
						} catch (EventInjectionException e) {
							Activator.getMessagingSystem().error("Exception received "+e.getMessage()+", stopping engine.",Activator.PLUGIN_ID, e);
						}
					}
					
					if (getDebugger() != null && !getDebugger().isTerminated(Thread.currentThread().getName())) {
						getDebugger().terminated(Thread.currentThread().getName());
					}
				}
			};
			Thread mainThread = new Thread(execution, "Gemoc engine " + modelStringURI) ;
			mainThread.start() ;
		}
	}
	/**
	 * Update the engine variable with the new events
	 * @param eventToInject
	 * @throws EventInjectionException 
	 */
	protected void injectEventsToCurrentStep(Collection<ModelSpecificEvent> eventsToInject) throws EventInjectionException{
		for(ModelSpecificEvent mse : eventsToInject){
			// We get the events allowed by the MoC for the current step.
			Collection<ModelSpecificEvent> allowedEvents = getCurrentPossibleEvents();
	
			if (allowedEvents.contains(mse)) {
				// If the injected MSE is legal, then it is added to the
				// scheduled events of the current step.
				List<ModelSpecificEvent> scheduledEventsForCurrentStep = this.scheduledEventsMap.get(this.currentStep);
				scheduledEventsForCurrentStep.add(mse);
				Activator.getMessagingSystem().info("MSE "+mse.getName()+" added to the scheduled events of the current step.", Activator.PLUGIN_ID);
			} else {
				// If the MSE is not authorized by the MoC, we throw an
				// exception and stop the engine
				Activator.getMessagingSystem().debug("Allowed events are: " + allowedEvents.toString(),	Activator.PLUGIN_ID);
				Activator.getMessagingSystem().error("Injecting event "+mse.getName()+" is not allowed by the Model of Computation at that time.",	Activator.PLUGIN_ID);				
				throw new EventInjectionException(
						"Injecting event "+mse.getName()+" is not allowed by the Model of Computation at that time.");
			}
		}
	}
	
//	@Override
//	public void run(int numberOfSteps) {
//		Activator.getMessagingSystem().info(
//				"Running " + numberOfSteps + " steps", Activator.PLUGIN_ID);
//		this.setChanged();
//		this.notifyObservers("Received from ControlPanel: run(" + numberOfSteps
//				+ ")");
//		for (int i = 0; i < numberOfSteps; i++) {
//			this.runOneStep();
//		}
//	}

	/**
	 * Updates the scheduling trace and the execution trace. Updates the value
	 * of currentStep. Adds a new entry to the scheduledEventsMap. Matches the
	 * scheduling trace and updates the current possible events.
	 * 
	 * @param newStep
	 */
	protected void setCurrentStepAndUpdateTraces(LogicalStep newStep) {
		// Map<Integer, Map<LogicalStep, List<ModelSpecificEvent>>>
		Integer previousDate = 0;
		for (Integer index : this.schedulingTrace.keySet()) {
			if (index > previousDate) {
				previousDate = index;
			}
		}
		this.currentStep = newStep;
		this.scheduledEventsMap.put(newStep,
				new ArrayList<ModelSpecificEvent>());
		this.schedulingTrace.put(previousDate + 1, newStep);
		this.executionTrace.put(newStep, new ArrayList<ModelSpecificEvent>());
		this.currentPossibleEvents = this.match(this.schedulingTrace);
		
		// All internal events are interpreted as automatically scheduled.
		for(ModelSpecificEvent mse : this.currentPossibleEvents){
			if(mse.getVisibility().equals(Visibility.PRIVATE)){
				List<ModelSpecificEvent> scheduledEventsForCurrentStep = this.scheduledEventsMap
						.get(this.currentStep);
				scheduledEventsForCurrentStep.add(mse);
	}

	/**
	 * Runs one step of the execution. Retrieves a scheduling step (either from
	 * the solver or one scheduled earlier) then executes the associated events
	 * if there are some. After the execution, it makes the engine proceed to
	 * the next step of execution.
	 */
	protected void runOneStep() {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				Activator.error(e.getMessage(), e);
			}

			@Override
			public void run() throws Exception {
				Activator.getMessagingSystem().info(">>Running one step",
						Activator.PLUGIN_ID);
				ObservableBasicExecutionEngine.this.doOneStep();
				Activator.getMessagingSystem().info("<<Step finished",
						Activator.PLUGIN_ID);
				Activator
						.getMessagingSystem()
						.info("Execution Trace: \n"
								+ mapToString(ObservableBasicExecutionEngine.this.executionTrace),
								Activator.PLUGIN_ID);
				ObservableBasicExecutionEngine.this
						.setCurrentStepAndUpdateTraces(ObservableBasicExecutionEngine.this
								.getScheduledOrSolverStep());
			}
		};
		SafeRunner.run(runnable);
	}

	/**
	 * If there is a scheduled step then it is returned, else a new one is
	 * gotten from the solver.
	 * 
	 * @return
	 */
	protected LogicalStep getScheduledOrSolverStep() {
		if (this.scheduledSteps.isEmpty()) {
			return this.solver.getNextStep();
		} else {
			return this.scheduledSteps.remove();
		}
	}

	@Override
	public Collection<ModelSpecificEvent> getCurrentPossibleEvents() {
		return this.currentPossibleEvents;
	}

	/**
	 * One step of execution. Retrieves all the events scheduled for this round
	 * and executes them sequentially. If no exception was thrown, the scheduled
	 * events are removed fom the scheduled events map.
	 * 
	 * @param mse
	 */
	private void doOneStep() {
		Collection<ModelSpecificEvent> events;
		events = new ArrayList<ModelSpecificEvent>();

		Collection<ModelSpecificEvent> nextEvents = this.scheduledEventsMap
				.get(this.currentStep);
		if (nextEvents != null) {
			events.addAll(nextEvents);
		}

		// For each event, execute its action(s) and take into account the
		// feedback the Domain Specific Action returns.
		for (ModelSpecificEvent event : events) {
			this.setChanged();
			this.notifyObservers("Execution of MSE: " + event.getName());

			Activator.getMessagingSystem().debug(
					"Executing the following event: " + event.toString(),
					Activator.PLUGIN_ID);

			try {
				if (debugger != null) {
					terminated = !debugger.control(Thread.currentThread().getName(),event);
				}
				List<FeedbackData> feedbacks = this.executor.execute(event);
				this.executionTrace.get(this.currentStep).add(event);
				for (FeedbackData feedback : feedbacks) {
					Activator.getMessagingSystem().debug(
							"Feedback received: " + feedback.toString(),
							Activator.PLUGIN_ID);
					if (this.feedbackPolicy != null) {
						this.feedbackPolicy.processFeedback(feedback, this);
					}
				}
			} catch (EventExecutionException e) {
				// There was an exception during the execution of an event so we
				// send it to the Error log view. If there is a nested exception
				// then we also print its information (typically the case when
				// invoking code like the DSAs).
				String errorMessage = e.getClass().getSimpleName()
						+ " while executing this round's worth of events. Inner exception sent to the Error Log view.";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);

				Activator.error(
						"Inner exception: " + e.getCause().getMessage(),
						e.getCause());
				if (e.getCause().getCause() != null) {
					Activator.error("Inner inner exception: "
							+ e.getCause().getCause().getMessage(), e
							.getCause().getCause());
				}
			} catch (InvokationResultConvertionException e) {
				// Couldn't figure out how to convert the result of a DSA into
				// an appropriate object.
				String errorMessage = e.getClass().getSimpleName()
						+ " while executing this round's worth of events. Inner exception sent to the Error Log view.";
				Activator.getMessagingSystem().error(errorMessage,
						Activator.PLUGIN_ID);
				Activator.error(
						"Inner exception: " + e.getCause().getMessage(),
						e.getCause());
				if (e.getCause().getCause() != null) {
					Activator.error("Inner inner exception: "
							+ e.getCause().getCause().getMessage(), e
							.getCause().getCause());

				}
			}
		}
		this.scheduledEventsMap.remove(this.currentStep);
	}

	@Override
	public Collection<DomainSpecificEvent> getDomainSpecificEvents() {
		return this.domainSpecificEventsRegistry.values();
	}

	@Override
	public void forceModelSpecificEventOccurrence(ModelSpecificEvent mse) {
		this.setChanged();
		this.notifyObservers("Trying to force the solver to trigger an occurrence of MSE: "
				+ mse.toString());
		this.solver.forceEventOccurrence(this.findMappedMocElement(mse));
	}

	@Override
	public void forbidModelSpecificEventOccurrence(ModelSpecificEvent mse) {
		this.setChanged();
		this.notifyObservers("Trying to force the solver to forbid an occurrence of MSE: "
				+ mse.toString());
		this.solver.forbidEventOccurrence(this.findMappedMocElement(mse));
	}

	@Override
	public void forceMocEventOccurrence(MocEvent mocEvent, EObject target) {
		this.setChanged();
		this.notifyObservers("Trying to force an occurrence of the MocEvent: "
				+ mocEvent.toString() + " on target " + target.toString());
		this.solver.forceEventOccurrence(this.solver
				.getCorrespondingEventOccurrence(mocEvent, target));
	}

	@Override
	public void forbidMocEventOccurrence(MocEvent mocEvent, EObject target) {
		this.setChanged();
		this.notifyObservers("Trying to forbid an occurrence of the MocEvent: "
				+ mocEvent.toString() + " on target " + target.toString());
		this.solver.forbidEventOccurrence(this.solver
				.getCorrespondingEventOccurrence(mocEvent, target));
	}

	@Override
	public Map<String, MocEvent> getMocEventsRegistry() {
		return this.mocEventsRegistry;
	}

	/**
	 * Reverse interpretation of Pattern.
	 * 
	 * @param mse
	 * @return
	 */
	private EventOccurrence findMappedMocElement(ModelSpecificEvent mse) {
		Pattern pattern = mse.getCondition();
		if (pattern instanceof Every) {
			Every patternEvery = (Every) pattern;
			if (patternEvery.getAtom() instanceof gepl.Reference) {
				MocEvent mocEvent = ((gepl.Reference) patternEvery).getEvent();
				return this.solver.getCorrespondingEventOccurrence(mocEvent,
						mse.getModelSpecificActions().get(0).getTarget());
			} else if (patternEvery.getAtom() instanceof gepl.And) {
				// TODO: make it work recursively
				MocEvent firstParameter = (MocEvent) ((gepl.Reference) ((gepl.And) patternEvery)
						.getFirstParameter()).getEvent();
				MocEvent secondParameter = (MocEvent) ((gepl.Reference) ((gepl.And) patternEvery)
						.getSecondParameter()).getEvent();
				// Fair random, threw a coin ;-)
				return this.solver.getCorrespondingEventOccurrence(
						firstParameter, mse.getModelSpecificActions().get(0)
								.getTarget());
			} else {
				throw new UnsupportedOperationException(
						"Only expecting Atom Reference or Atom And for now...");
			}
		} else {
			throw new UnsupportedOperationException(
					"Can only deal with 'Every' pattern for now...");
		}
	}

	/**
	 * Pretty print for a map.
	 * 
	 * Outputs will be like this :
	 * 
	 * <ul>
	 * <li>---------------------</li>
	 * <li>key1 | value1</li>
	 * <li>---------------------</li>
	 * <li>key2 | value2</li>
	 * <li>---------------------</li>
	 * </ul>
	 * 
	 * If the values are collections, then each element of the collections will
	 * have its line but the associated key is not repeated.
	 * 
	 * <ul>
	 * <li>---------------------</li>
	 * <li>key1 | value1</li>
	 * <li>| value1'</li>
	 * <li>| value1''</li>
	 * <li>---------------------</li>
	 * <li>key2 | value2</li>
	 * <li>---------------------</li>
	 * </ul>
	 * 
	 * @param map
	 * @return
	 */
	protected String mapToString(Map<?, ?> map) {
		String res = "---------------------------------------------------------------------------------------------------------------\n";
		int maximumKeyLength = 0;
		for (Object key : map.keySet()) {
			if (key.toString().length() > maximumKeyLength) {
				maximumKeyLength = key.toString().length();
			}
		}
		for (Object key : map.keySet()) {
			Object value = map.get(key);
			res += key.toString();
			for (int i = 0; i < maximumKeyLength - key.toString().length(); i++) {
				res += " ";
			}
			res += " | ";
			if (value instanceof Collection<?>) {
				Iterator<?> iterator = (Iterator<?>) ((Collection<?>) value)
						.iterator();
				if (iterator.hasNext()) {
					res += iterator.next();
				}
				while (iterator.hasNext()) {
					res += "\n";
					for (int i = 0; i < maximumKeyLength; i++) {
						res += " ";
					}
					res += " | " + iterator.next();
				}
			} else {
				res += value.toString();
			}
			res += "\n---------------------------------------------------------------------------------------------------------------\n";
		}
		return res;
	}

	
	/**
	 * Builds a map with, as keys, the names of the ModelSpecificEvents, as
	 * values, the ModelSpecificEvents. This is so because we "recognize" the
	 * MSE occurrences allowed by the MoC solver's trace thanks to the name of
	 * the event.
	 * 
	 * @param modelOfExecution
	 * @return the registry of ModelSpecificEvents based on their names.
	 */
	private Map<String, ModelSpecificEvent> createModelSpecificEventsRegistry(
			Resource modelOfExecution) {
		Map<String, ModelSpecificEvent> res = new HashMap<String, ModelSpecificEvent>();
		DomainSpecificEventFile dseFile = (DomainSpecificEventFile) modelOfExecution
				.getContents().get(0);
		for (ModelSpecificEvent mse : dseFile.getModelEvents()) {
			res.put(mse.getName(), mse);
		}
		return res;
	}
	/**
	 * Returns the last "date" (integer) in the scheduling trace. We use this
	 * instead of this.currentStep because we need to match Patterns over a
	 * fixed period (for example t, t-1 and t-2 are involved for a given
	 * pattern) so we need to be able to position ourselves on the scheduling
	 * trace for navigation.
	 * 
	 * @return
	 */
	private Integer getCurrentDate() {
		int res = 0;
		for (Integer integer : this.schedulingTrace.keySet()) {
			if (this.schedulingTrace.get(integer).equals(this.currentStep)) {
				res = integer;
			}
		}
		return res;
	}
	
	/**
	 * Interpretation of the pattern...
	 * 
	 * @param mse
	 * @param schedulingTrace
	 * @return
	 */
	private Boolean patternOfEventOccursInSchedulingTrace(
			ModelSpecificEvent mse, Map<Integer, LogicalStep> schedulingTrace) {
		Boolean res = false;
		Pattern pattern = mse.getCondition();
		if (pattern instanceof Identity) {
			// Identity means the last scheduling step must contain an event
			// occurrence that has a named reference of same name as the mapped
			// MoC Event.
			Identity identity = (Identity) pattern;
			String mappedMocEventName = ((ECLEvent) identity.getArgument())
					.getElement().getName();
			LogicalStep lastStep = schedulingTrace.get(this.getCurrentDate());
			for (EventOccurrence eventOccurrence : lastStep
					.getEventOccurrences()) {
				if (eventOccurrence.getFState() == FiredStateKind.TICK
						& eventOccurrence.getReferedElement() != null) {
					if (eventOccurrence.getReferedElement() instanceof ModelElementReference) {
						// In our protocol, the scheduling trace's event
						// occurrences' refered element must be a named
						// reference to the clock (ECL event). This way we know
						// what MoC event it is related to.
						ModelElementReference mer = (ModelElementReference) eventOccurrence
								.getReferedElement();
						String stringOfTheECLEventCorrespondingToTheTickingClock = mer
								.getElementRef().get(0).toString();
						// MAYBE FILTER BY NAME HERE TOO
						String nameOfTheECLEventCorrespondingToTheTickingClock = EcoreHelper4Engine.getValueOfStringAttribute(mer.getElementRef()
										.get(0), "name");
						// In the MSE Specification, we have a link from MSE to
						// its reification (DSE).
						// We also have a link (pattern) from DSE to MSE.
						// Unfortunately we cannot explicitly know which clock
						// (EventOccurrence) came from which ECL Event, so we
						// cannot map MSEs directly to clocks and thus they are
						// mapped to the same Ecl Event as their reification.
						// Which is why we need to do this mapping by analyzing
						// the name of the clock (EventOccurrence) so as to see
						// if it indeed is an instanciation of the correct ECL
						// Event and if it aims the same EObject from the model
						// as our MSE's MSA does.
						String nameOfTheEObject = EcoreHelper4Engine.getValueOfStringAttribute(mse
										.getModelSpecificActions().get(0)
										.getTarget(), "name");

						res = nameOfTheECLEventCorrespondingToTheTickingClock
								.equals("evt_" + nameOfTheEObject + "_"
										+ mappedMocEventName)
								|| res;
					} else {
						throw new RuntimeException(
								"Unable to analyze correctly the scheduling step provided");
					}
				}
			}
		} else {
			throw new UnsupportedOperationException(
					"Not able to interpret the following pattern: "
							+ pattern.toString());
		}
		return res;
	}
	
	/**
	 * Searches through the given map for a Model-Specific Event which the
	 * following characteristics:
	 * <ul>
	 * <li>Its reification is "equals" to the DSE given in arguments. Because
	 * the DSE resource is loaded at two different places (once in the
	 * ModelOfExecution file, once by this Engine), the instances are not the
	 * same though the objects have the same features values. Which is why we
	 * use EcoreUtil.EqualityHelper.</li>
	 * </ul>
	 * Its first (and only... ?) MSA's target is equals to the target given in
	 * the parameters (same as above).
	 * 
	 * @param dse
	 *            A Domain-Specific Event
	 * @param target
	 *            An EObject of the model
	 * @param map
	 *            The ModelSpecificEvents registry
	 * @return the MSE corresponding to the DSE on the given target.
	 */
	private ModelSpecificEvent findCorrespondingModelSpecificEvent(
			DomainSpecificEvent dse, EObject target,
			Map<String, ModelSpecificEvent> map) {
		Activator.getMessagingSystem().debug(
				"Trying to find the MSE with the following characteristics:"
						+ "\n - DSE: " + dse + "\n - Target: "
						+ target.toString() + "\n Among the following MSE map:"
						+ "\n" + this.mapToString(map), Activator.PLUGIN_ID);
		EcoreUtil.EqualityHelper equalityHelper = new EcoreUtil.EqualityHelper();
		for (ModelSpecificEvent mse : map.values()) {
			// Adding a name-based equality because it doesn't work anymore... I
			// think it's when looking up the references...
			if ((equalityHelper.equals(mse.getReification(), dse) || mse
					.getReification().getName().equals(dse.getName()))
					&& equalityHelper.equals(
							mse.getModelSpecificActions().get(0).getTarget(),
							target)) {
				Activator.getMessagingSystem().debug(
						"Found corresponding MSE: " + mse.getName(),
						Activator.PLUGIN_ID);
				return mse;
			}
		}
		Activator
				.getMessagingSystem()
				.debug("Could not find corresponding MSE. Throwing NoSuchElementException.",
						Activator.PLUGIN_ID);
		throw new NoSuchElementException();
	}
	
	private boolean resourceContainsEObject(Resource resource, EObject eo) {
		
		// TODO inefficient, must use EcoreUtils !
		Iterator<EObject> it = resource.getAllContents();
		while (it.hasNext()) {
			EObject content = it.next();
			if (content.equals(eo)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + this.executor
				+ " ; Solver=" + this.solver + " ; ModelResource="
				+ this.modelResource + "]";
	}

	public GemocModelDebugger getDebugger() {
		return debugger;
	}

	public void setDebugger(GemocModelDebugger debugger) {
		this.debugger = debugger;
	}
	@Override
	public Resource getModelResource() {
		return this.modelResource;
	}
	@Override
	public Collection<ModelSpecificEvent> getModelSpecificEvents() {
		return this.modelSpecificEventsRegistry.values();
	}

	@Override
	public ModelSpecificEvent getCorrespondingModelSpecificEvent(
			DomainSpecificEvent dse, EObject target) {
		return this.findCorrespondingModelSpecificEvent(dse, target,
				this.modelSpecificEventsRegistry);
	}

}
