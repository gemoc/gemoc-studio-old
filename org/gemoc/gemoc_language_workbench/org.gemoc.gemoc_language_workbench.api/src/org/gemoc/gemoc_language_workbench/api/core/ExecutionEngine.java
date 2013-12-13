package org.gemoc.gemoc_language_workbench.api.core;

import glml.ModelSpecificEvent;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
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
	 * Resets the engine and its components to its initial state.
	 */
	public void reset();

	/**
	 * Query to retrieve the MSEs which can be triggered by the user, in no
	 * particular order.
	 * 
	 * @return the collection of ModelSpecificEvents which can be triggered by
	 *         the user.
	 */
	public Collection<ModelSpecificEvent> getNextEvents();

	/**
	 * Runs one step of the execution corresponding to an occurrence of the
	 * given mse, which should come from the getNextEvents() result.
	 */
	public void runOneStep(ModelSpecificEvent mse);

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