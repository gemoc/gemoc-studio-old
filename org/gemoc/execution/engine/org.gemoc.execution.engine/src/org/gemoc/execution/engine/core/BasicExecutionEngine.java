package org.gemoc.execution.engine.core;

import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

import fr.inria.aoste.trace.LogicalStep;

/**
 * Basic abstract implementation of the ExecutionEngine, independent from the
 * technologies used for the solver, the executor and the feedback protocol.
 * 
 * 
 * @author flatombe
 * 
 */
public abstract class BasicExecutionEngine implements ExecutionEngine {

	protected LanguageInitializer languageInitializer = null;
	protected ModelLoader modelLoader = null;
	protected Solver solver = null;
	protected Executor executor = null;
	protected FeedbackPolicy feedbackPolicy = null;

	protected Resource modelResource = null;

	public BasicExecutionEngine(LanguageInitializer languageInitializer, ModelLoader modelLoader, String eclFilePath,
			Solver solver, Executor executor, FeedbackPolicy feedbackPolicy) {
		Activator.getMessagingSystem().info("Instantiating BasicExecutionEngine with...", Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tLanguageInitializer=" + languageInitializer, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tModelLoader=" + modelLoader, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tEclFilePath=" + eclFilePath, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tSolver=" + solver, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tExecutor=" + executor, Activator.PLUGIN_ID);
		Activator.getMessagingSystem().info("\tFeedbackPolicy=" + feedbackPolicy, Activator.PLUGIN_ID);

		// If one of the components is null we throw a null pointer exception.
		if (languageInitializer == null | modelLoader == null | eclFilePath == null | solver == null | executor == null
				| feedbackPolicy == null) {
			String exceptionMessage = "";
			if (languageInitializer == null) {
				exceptionMessage += "languageInitializer is null,";
			}
			if (modelLoader == null) {
				exceptionMessage += "modelLoader is null,";
			}
			if (eclFilePath == null) {
				exceptionMessage += "eclFilePath is null,";
			}
			if (solver == null) {
				exceptionMessage += "solver is null,";
			}
			if (executor == null) {
				exceptionMessage += "executor is null,";
			}
			if (feedbackPolicy == null) {
				exceptionMessage += "feedbackPolicy is null,";
			}
			if (exceptionMessage.endsWith(",")) {
				exceptionMessage = exceptionMessage.substring(0, exceptionMessage.length() - 2);
			}
			throw new NullPointerException(exceptionMessage);
		} else {
			this.languageInitializer = languageInitializer;
			this.modelLoader = modelLoader;
			this.solver = solver;
			this.executor = executor;
			this.feedbackPolicy = feedbackPolicy;

			this.languageInitializer.initialize();
		}
	}

	/**
	 * Instantiates a list of Domain Specific Events depending on which event
	 * occurrences are in the Step returned by the Solver.
	 * 
	 * Depends on the implementation used for the Solver, Step and Domain
	 * Specific Event.
	 * 
	 * @param step
	 * @return
	 */
	protected abstract List<DomainSpecificEvent> match(LogicalStep step);

	@Override
	public void run() {
		Activator.getMessagingSystem().info("Starting running indefinitely", Activator.PLUGIN_ID);
		this.run(-1);
		Activator.getMessagingSystem().info("Stopped running indefinitely", Activator.PLUGIN_ID);
	}

	@Override
	public void run(int numberOfSteps) {
		Activator.getMessagingSystem().info("Running " + numberOfSteps + " steps", Activator.PLUGIN_ID);
		for (int i = 0; i < numberOfSteps; i++) {
			this.runOneStep();
		}
	}

	@Override
	public void runOneStep() {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				Activator.error(e.getMessage(), e);
			}

			@Override
			public void run() throws Exception {
				Activator.getMessagingSystem().info(">>Running one step", Activator.PLUGIN_ID);
				BasicExecutionEngine.this.doOneStep();
				Activator.getMessagingSystem().info("<<Step finished", Activator.PLUGIN_ID);
			}
		};
		SafeRunner.run(runnable);

	}

	private void doOneStep() {
		// Retrieve information from the solver.
		LogicalStep step = this.solver.getNextStep();
		Activator.getMessagingSystem().debug("The solver has correctly returned a step to the engine",
				Activator.PLUGIN_ID);

		// Create the Domain Specific Events according to the information
		// returned to us by the solver.
		List<DomainSpecificEvent> events = this.match(step);
		Activator.getMessagingSystem().info("Number of events matched : " + events.size(), Activator.PLUGIN_ID);

		// For each event, execute its action(s) and take into account the
		// feedback the Domain Specific Action returns.
		for (DomainSpecificEvent event : events) {
			FeedbackData feedback = this.executor.execute(event);
			Activator.getMessagingSystem().info(
					"Feedback from event " + event.toString() + " is : " + feedback.toString(), Activator.PLUGIN_ID);
			this.feedbackPolicy.processFeedback(feedback, event, solver);
		}
	}

	@Override
	public Executor getExecutor() {
		return this.executor;
	}

	@Override
	public Solver getSolver() {
		return this.solver;
	}

	@Override
	public FeedbackPolicy getFeedbackPolicy() {
		return this.feedbackPolicy;
	}

	@Override
	public ModelLoader getModelLoader() {
		return this.modelLoader;
	}

	@Override
	public LanguageInitializer getLanguageInitializer() {
		return this.languageInitializer;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "@[Executor=" + this.executor + " ; Solver=" + this.solver
				+ " ; FeedbackPolicy=" + this.feedbackPolicy + "]";
	}
}
