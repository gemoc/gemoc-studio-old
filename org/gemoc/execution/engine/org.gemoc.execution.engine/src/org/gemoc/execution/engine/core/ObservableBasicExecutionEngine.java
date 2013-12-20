package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.core.impl.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;
import org.gemoc.gemoc_language_workbench.api.exceptions.InvokationResultConvertionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.trace.LogicalStep;
import glml.DomainSpecificEvent;
import glml.DomainSpecificEventFile;
import glml.ModelSpecificEvent;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol. It
 * can display the runtime execution information to its registered observers.
 * 
 * There are two phases of initializations for this entity:
 * <ul>
 * <li>the constructor sets the language-specific elements such as
 * DomainSpecificEvents, Solver, EventExecutor, FeedbackPolicy
 * <li>the initialize method sets the model-specific elements such as Model and
 * ModelLoader.
 * </ul>
 * From the Model, we can derive :
 * <ul>
 * <li>the Model of Execution (using the DomainSpecificEvents
 * <li>the Higher-order-transformation (TODO)) and the Solver Input (using the
 * Model of Execution and the Solver Input Builder provided by the Solver).
 * </ul>
 * 
 * @see ExecutionEngine
 * @see GemocExecutionEngine
 * 
 * @author flatombe
 * 
 */
public abstract class ObservableBasicExecutionEngine extends Observable
		implements ExecutionEngine {

	protected LogicalStep currentStep = null;
	protected Queue<LogicalStep> scheduledSteps = null;
	protected Map<LogicalStep, List<ModelSpecificEvent>> scheduledEvents = null;

	protected Map<Integer, LogicalStep> schedulingTrace;
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

	/**
	 * Derived from the above language-specific elements
	 */
	protected Map<String, DomainSpecificEvent> domainSpecificEventsRegistry = null;

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
	public ObservableBasicExecutionEngine(
			Resource domainSpecificEventsResource, Solver solver,
			EventExecutor executor, FeedbackPolicy feedbackPolicy) {

		// TODO : REMOVE ME. This is a temporary fix because I can't get an ECL
		// resource to be correctly detected...
		if (domainSpecificEventsResource == null) {
			ResourceSet resSet = new ResourceSetImpl();
			// domainSpecificEventsResource = resSet
			// .getResource(
			// URI.createURI("platform:/resource/org.gemoc.sample.tfsm.dse/ecl/TFSM.ecl"),
			// true);
			domainSpecificEventsResource = resSet
					.getResource(
							URI.createURI("platform:/plugin/org.gemoc.sample.tfsm.dse/glml/MyDomainSpecificEvents.glml"),
							true);
		}

		Activator
				.getMessagingSystem()
				.info("Verifying input before instanciating ObservableBasicExecutionEngine...",
						Activator.PLUGIN_ID);

		// The engine needs AT LEAST a domainSpecificEventsResource, a Solver,
		// an EventExecutor.
		if (domainSpecificEventsResource == null | solver == null
				| executor == null | feedbackPolicy == null) {
			String exceptionMessage = "";
			if (domainSpecificEventsResource == null) {
				exceptionMessage += "domainSpecificEventsResource is null, ";
			}
			if (solver == null) {
				exceptionMessage += "solver is null, ";
			}
			if (executor == null) {
				exceptionMessage += "eventExecutor is null, ";
			}
			if (exceptionMessage.endsWith(", ")) {
				exceptionMessage = exceptionMessage.substring(0,
						exceptionMessage.length() - 2);
			}
			Activator.getMessagingSystem().info(
					"...NOK. Throwing NullPointerException.",
					Activator.PLUGIN_ID);
			throw new NullPointerException(exceptionMessage);
		} else {
			Activator
					.getMessagingSystem()
					.info("...OK. Instantiating ObservableBasicExecutionEngine with...",
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

			this.domainSpecificEventsResource = domainSpecificEventsResource;
			this.solver = solver;
			this.executor = executor;
			this.executor.initialize();

			this.domainSpecificEventsRegistry = this
					.createDomainSpecificEventsRegistry(this.domainSpecificEventsResource);

			// TODO: Execution initialization, move them somewhere else and
			// place them in reset too.
			this.scheduledEvents = new HashMap<LogicalStep, List<ModelSpecificEvent>>();
			this.scheduledSteps = new LinkedList<LogicalStep>();
			this.schedulingTrace = new HashMap<Integer, LogicalStep>();
			this.executionTrace = new HashMap<LogicalStep, List<ModelSpecificEvent>>();
		}
	}

	/**
	 * Returns a map with Domain-Specific Events names as keys and the
	 * Domain-Specific Events as values.
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
	public abstract void initialize(String modelURI, ModelLoader modelLoader);

	@Override
	public abstract void reset();

	@Override
	public void pause() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void stepBack(int numberOfSteps) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Instantiates a Collection of Model-Specific Events depending on which
	 * event occurrences are in the Step returned by the Solver.
	 * 
	 * @param step
	 * @return
	 */
	protected abstract Collection<ModelSpecificEvent> match(LogicalStep step);

	@Override
	public void run(int numberOfSteps) {
		Activator.getMessagingSystem().info(
				"Running " + numberOfSteps + " steps", Activator.PLUGIN_ID);
		this.setChanged();
		this.notifyObservers("Received from ControlPanel: run(" + numberOfSteps
				+ ")");
		for (int i = 0; i < numberOfSteps; i++) {
			this.runOneStep();
		}
	}

	/**
	 * Updates the scheduling trace and the execution trace. Updates the value
	 * of currentStep.
	 * 
	 * @param newStep
	 */
	protected void setCurrentStep(LogicalStep newStep) {
		// Map<Integer, Map<LogicalStep, List<ModelSpecificEvent>>>
		Integer max = 0;
		for (Integer index : this.schedulingTrace.keySet()) {
			if (index > max) {
				max = index;
			}
		}
		this.currentStep = newStep;
		this.schedulingTrace.put(max + 1, newStep);
		this.executionTrace.put(newStep, new ArrayList<ModelSpecificEvent>());
	}

	/**
	 * Runs one step of the execution. Retrieves a scheduling step (either from
	 * the solver or one scheduled earlier) then executes the associated events
	 * if there are some.
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
				ObservableBasicExecutionEngine.this
						.setCurrentStep(ObservableBasicExecutionEngine.this
								.getScheduledOrSolverStep());
				Activator.getMessagingSystem().info("<<Step finished",
						Activator.PLUGIN_ID);
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
	public Collection<ModelSpecificEvent> getPossibleEvents() {
		return this.match(this.currentStep);
	}

	/**
	 * One step of execution. Retrieves all the events scheduled for this round
	 * and executes them sequentially.
	 * 
	 * @param mse
	 */
	private void doOneStep() {
		Collection<ModelSpecificEvent> events;
		events = new ArrayList<ModelSpecificEvent>();
		try {
			events.addAll(this.scheduledEvents.get(this.currentStep));
		} catch (NoSuchElementException e) {
			// Collection remains empty and the below loop is skipped so nothing
			// happens. As expected.
		}

		// For each event, execute its action(s) and take into account the
		// feedback the Domain Specific Action returns.
		for (ModelSpecificEvent event : events) {
			this.setChanged();
			this.notifyObservers("Execution of MSE: " + event.getName() + ")");

			Activator.getMessagingSystem().debug(
					"Executing the following event: " + event.toString(),
					Activator.PLUGIN_ID);

			try {
				List<FeedbackData> feedbacks = this.executor.execute(event);
				for (FeedbackData feedback : feedbacks) {
					Activator.getMessagingSystem().debug(
							"Feedback received: " + feedback.toString(),
							Activator.PLUGIN_ID);
					if (this.feedbackPolicy != null) {
						this.feedbackPolicy.processFeedback(feedback, this);
					}
				}
			} catch (EventExecutionException e) {
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
	}

	@Override
	public Collection<DomainSpecificEvent> getDomainSpecificEvents() {
		return this.domainSpecificEventsRegistry.values();
	}

	@Override
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		this.setChanged();
		this.notifyObservers("Forcing the solver to produce events leading to a MSE that references: "
				+ target.toString() + ", " + operation.toString());
		this.solver.forceEventOccurrenceReferencing(target, operation);
	}

	@Override
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation) {
		this.setChanged();
		this.notifyObservers("Forbidding the solver from producing events leading to a MSE that references: "
				+ target.toString() + ", " + operation.toString());
		this.solver.forbidEventOccurrenceReferencing(target, operation);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + this.executor
				+ " ; Solver=" + this.solver + " ; ModelResource="
				+ this.modelResource + "]";
	}
}
