package org.gemoc.gemoc_language_workbench.api.core;

import glml.DomainSpecificEvent;
import glml.MocEvent;
import glml.ModelSpecificEvent;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.exceptions.EventInjectionException;
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

	/** --------------- Input/Output (Frontend) --------------- **/
	/**
	 * Runs the engine for a given number of steps. There are a few semantic
	 * variation points here: - When the Engine matches several DSEs at for a
	 * given step - When a DSE is linked to several DSAs - (consequence) when
	 * feedbacks from concurrent DSAs is incoherent.
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
	 * Pauses the execution.
	 */
	public void pause();

	/**
	 * Go back in the past.
	 * 
	 * @param numberOfSteps
	 *            number of steps to go back.
	 */
	public void stepBack(int numberOfSteps);

	/**
	 * Retrieve the Domain-Specific Events of the language.
	 * 
	 * @return the collection of DomainSpecificEvents for the language of the
	 *         model being executed.
	 */
	public Collection<DomainSpecificEvent> getDomainSpecificEvents();
	
	/**
	 * Retrieve the Model-Specific Events of the model being executed.
	 * @return
	 */
	public Collection<ModelSpecificEvent> getModelSpecificEvents();
	
	/**
	 * Returns the ModelSpecificEvent corresponding to the given couple of DSE and target.
	 * @param dse
	 * @param target
	 * @return
	 */
	public ModelSpecificEvent getCorrespondingModelSpecificEvent(DomainSpecificEvent dse, EObject target);

	/**
	 * Retrieve the model being executed.
	 * 
	 * @return the EMF Resource corresponding to the model being executed.
	 */
	public Resource getModelResource();

	/**
	 * Inject an event.
	 * 
	 * @param dse
	 * @param target
	 */
	public void injectEvent(DomainSpecificEvent dse, EObject target)
			throws EventInjectionException;

	/**
	 * Query to retrieve the MSEs which can be triggered by the user, in no
	 * particular order.
	 * 
	 * @return the collection of ModelSpecificEvents which can be triggered by
	 *         the user.
	 */
	public Collection<ModelSpecificEvent> getCurrentPossibleEvents();

	/** --------------- Influence the MoC Constraints --------------- **/
	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 */
	public void forceEventOccurrence(ModelSpecificEvent mse);

	/**
	 * API that delegates to the Solver the application of the constraints to
	 * add to the MoC following a Feedback result from a/several DSA(s).
	 * 
	 */
	public void forbidEventOccurrence(ModelSpecificEvent mse);

	public void forceMocEventOccurrence(MocEvent mocEvent, EObject target);

	public void forbidMocEventOccurrence(MocEvent mocEvent, EObject target);

	Map<String, MocEvent> getMocEventsRegistry();

}
