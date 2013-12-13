package org.gemoc.gemoc_language_workbench.api.core;

import glml.ModelSpecificEvent;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.gemoc_language_workbench.api.utils.ModelLoader;

/**
 * The interface of the GEMOC Execution Engine. The Execution Engine is an
 * entity able to execute models conforming to an xDSML as defined in the GEMOC
 * ANR INS project. This API allows the caller to initialize the engine for a
 * given model, and to run the engine in different ways. It also allows the
 * caller to influence the constraints of the MoC at runtime.
 * 
 * @author flatombe
 * 
 */
public interface ExecutionEngine {

	/** --------------- Initialization --------------- **/
	/**
	 * While the constructor of the engine initializes the engine with the
	 * components used for the whole LANGUAGE, this method initializes the
	 * engine for a given model conforming to the language used, most notably by
	 * loading the model (using the given ModelLoader), creating the Model Of
	 * Execution (Model Specific Events) and the Solver Input.
	 * 
	 * @param modelURI
	 *            : URI of the model to load
	 * @param modelLoader
	 *            : Facility able to load the model. By default should be XMI.
	 */
	public void initialize(String modelURI, ModelLoader modelLoader);

	/** --------------- Input/Output (ControlPanel) --------------- **/
	/**
	 * Runs the engine for a given number of steps. There are a few semantic
	 * variation points here: - When the Engine matches several DSEs at for a
	 * given step - When a DSE is linked to several DSAs - (consequence) when
	 * feedbacks from concurrent DSAs is incoherent.
	 * 
	 * @see ObservableBasicExecutionEngine
	 * @see GemocExecutionEngine
	 * 
	 * @param numberOfSteps
	 *            the number of steps of execution for the Execution Engine to
	 *            run.
	 */
	public void run(int numberOfSteps);

	/**
	 * Resets the engine and its components to its initial state.
	 */
	public void reset();

	/**
	 * Query to retrieve the next ModelSpecificEvents which can be triggered. In
	 * particular, this should be used to create a GUI for scheduling an
	 * execution.
	 * 
	 * @return the collection of ModelSpecificEvents which can be triggered by
	 *         the user.
	 */
	public Collection<ModelSpecificEvent> getNextEvents();

	/**
	 * Runs one step of the execution corresponding to an occurrence of the
	 * given ModelSpecificEvent, which should come from the getNextEvents()
	 * result.
	 */
	public void runOneStep(ModelSpecificEvent mse);

	/** --------------- Influence the MoC Constraints --------------- **/
	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 * @param target
	 *            the EObject targeted by the event we want to force.
	 * @param operation
	 *            the EOperation referenced by the event we want to force.
	 */
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation);

	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 * @param target
	 *            the EObject target by the event we want to forbid.
	 * @param operation
	 *            the EOperation referenced by the event we want to forbid.
	 */
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation);

}