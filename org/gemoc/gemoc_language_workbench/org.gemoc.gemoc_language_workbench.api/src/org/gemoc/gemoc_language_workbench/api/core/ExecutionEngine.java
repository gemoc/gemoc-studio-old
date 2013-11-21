package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;
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
	 * loading the model (using the given ModelLoader) and instantiating the
	 * Model of Computation to the model.
	 */
	public void initialize(String modelURI, ModelLoader modelLoader);

	/**
	 * Runs the engine for a given number of steps.
	 * 
	 * @param numberOfSteps
	 *            the number of steps of execution to execute.+
	 */
	public void run(int numberOfSteps);

	/**
	 * 
	 * 
	 * @return Returns the EventExecutor used by the engine.
	 */
	public EventExecutor getExecutor();

	/**
	 * 
	 * 
	 * @return Returns the Solver used by the engine.
	 */
	public Solver getSolver();

	/**
	 * 
	 * 
	 * @return the FeedbackPolicy used by the engine.
	 */
	public FeedbackPolicy getFeedbackPolicy();

	/**
	 * 
	 * 
	 * @return the ModelLoader used by the engine.
	 */
	public ModelLoader getModelLoader();

	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 * @param target
	 * @param operation
	 */
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation);

	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 * @param target
	 * @param operation
	 */
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation);

}