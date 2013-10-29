package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
import org.gemoc.gemoc_language_workbench.api.utils.LanguageInitializer;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

/**
 * The visible face of the Execution Engine.
 * 
 * @author flatombe
 * 
 */
public interface ExecutionEngine {

	/**
	 * While the constructor of the engine initializes the engine with the
	 * components used for the whole LANGUAGE, this method initializes the
	 * engine for a given model conforming to the language used, most notably by
	 * loading the model and instantiating the Model of Computation to the
	 * model.
	 */
	public void initialize(String modelURI);

	/**
	 * Runs the engine indefinitely. Equivalent to calling run(-1).
	 */
	public void run();

	/**
	 * Runs the engine for a given number of steps.
	 * 
	 * @param numberOfSteps
	 */
	public void run(int numberOfSteps);

	/**
	 * Runs the engine for just one step. Equivalent to calling run(1).
	 */
	public void runOneStep();

	/**
	 * Returns the Executor used by the engine.
	 * 
	 * @return
	 */
	public EventExecutor getExecutor();

	/**
	 * Returns the Solver used by the engine.
	 * 
	 * @return
	 */
	public Solver getSolver();

	/**
	 * Returns the FeedbackPolicy used by the engine.
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