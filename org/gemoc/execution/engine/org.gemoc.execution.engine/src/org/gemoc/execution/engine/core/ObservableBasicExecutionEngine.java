package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;

import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventExecutionException;
import org.gemoc.gemoc_language_workbench.api.exceptions.InvokationResultConvertionException;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.trace.LogicalStep;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol. It
 * can display the runtime execution information to its registered observers.
 * 
 * @author flatombe
 * 
 */
public abstract class ObservableBasicExecutionEngine extends Observable
		implements ExecutionEngine {

	protected ModelLoader modelLoader = null;
	protected Solver solver = null;
	protected EventExecutor executor = null;
	protected FeedbackPolicy feedbackPolicy = null;
	protected Resource domainSpecificEventsResource = null;

	protected Resource modelResource = null;
	protected String modelStringURI = null;

	protected List<DomainSpecificEvent> domainSpecificEvents = null;

	public ObservableBasicExecutionEngine(
			Resource domainSpecificEventsResource, Solver solver,
			EventExecutor executor, FeedbackPolicy feedbackPolicy) {

		// TODO : REMOVE ME
		if (domainSpecificEventsResource == null) {
			ResourceSet resSet = new ResourceSetImpl();
			domainSpecificEventsResource = resSet
					.getResource(
							URI.createURI("platform:/resource/org.gemoc.sample.tfsm.ecldse/dse/TFSM.ecl"),
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
		}
	}

	@Override
	public abstract void initialize(String modelURI, ModelLoader modelLoader);

	/**
	 * Instantiates a Collection of Model-Specific Events depending on which
	 * event occurrences are in the Step returned by the Solver.
	 * 
	 * Depends on the implementation used for the Solver, Step and Domain
	 * Specific Event.
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
			this.runOneStep(null);
		}
	}

	@Override
	public void runOneStep(final ModelSpecificEvent mse) {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				Activator.error(e.getMessage(), e);
			}

			@Override
			public void run() throws Exception {
				Activator.getMessagingSystem().info(">>Running one step",
						Activator.PLUGIN_ID);
				ObservableBasicExecutionEngine.this.doOneStep(mse);
				Activator.getMessagingSystem().info("<<Step finished",
						Activator.PLUGIN_ID);
			}
		};
		SafeRunner.run(runnable);
	}

	private LogicalStep getSolverStep() {
		LogicalStep step = this.solver.getNextStep();
		Activator.getMessagingSystem().debug(
				"The solver has correctly returned a step to the engine",
				Activator.PLUGIN_ID);
		return step;
	}

	@Override
	public Collection<ModelSpecificEvent> getNextEvents() {
		LogicalStep step = this.getSolverStep();

		// Create the Domain Specific Events according to the information
		// returned to us by the solver.
		Collection<ModelSpecificEvent> events = this.match(step);

		return events;
	}

	private void doOneStep(ModelSpecificEvent mse) {
		Collection<ModelSpecificEvent> events;
		if (mse != null) {
			// The MSE has been chosen beforehand (via controlpanel)
			events = new ArrayList<ModelSpecificEvent>();
			events.add(mse);
			this.setChanged();
			this.notifyObservers("User required execution of MSE: " + mse.getName()
					+ ")");
		} else {
			// The MSE has not been chosen beforehand, so it's more of an
			// automatic mode.
			events = this.getNextEvents();
		}

		// For each event, execute its action(s) and take into account the
		// feedback the Domain Specific Action returns.
		for (ModelSpecificEvent event : events) {
			Activator.getMessagingSystem().debug(
					"Executing the following event: " + event.toString(),
					Activator.PLUGIN_ID);
			this.setChanged();
			this.notifyObservers(event.toString());

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
