package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.dsa.Executor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;

/**
 * The visible face of the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public interface ExecutionEngine {

	/**
	 * Runs the engine indefinitely. Equivalent as running the engine -1 number
	 * of steps.
	 */
	public void run();

	/**
	 * Runs the engine for a given number of steps.
	 * 
	 * @param numberOfSteps
	 */
	public void run(int numberOfSteps);

	/**
	 * Runs the engine for just one step.
	 */
	public void runOneStep();

	/**
	 * Returns the Executor used by the engine.
	 * 
	 * @return
	 */
	public Executor getExecutor();

	/**
	 * Returns the Solver used by the engine.
	 * 
	 * @return
	 */
	public Solver getSolver();

	/**
	 * Returns the feedbackpolicy defined by the engine, parameterized by the
	 * feedback data structure used to capture feedback information from the
	 * execution of the Domain-Specific Actions.
	 * 
	 * @return
	 */
	public FeedbackPolicy getFeedbackPolicy();

	/**
	 * Returns the ModelLoader used by the engine.
	 * 
	 * @return
	 */
	public ModelLoader getModelLoader();

	/**
	 * Returns the LanguageInitializer used by the engine.
	 * 
	 * @return
	 */
	public LanguageInitializer getLanguageInitializer();

}