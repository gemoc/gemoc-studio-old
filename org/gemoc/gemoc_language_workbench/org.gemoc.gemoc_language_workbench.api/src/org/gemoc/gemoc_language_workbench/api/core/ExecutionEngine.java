package org.gemoc.gemoc_language_workbench.api.core;

import glml.DomainSpecificEvent;
import glml.MocEvent;
import glml.ModelSpecificEvent;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
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
	 * @param modelOfExecutionURI
	 *            : URI of the model of execution (linked to the model that will run)
	 * @param modelLoader
	 *            : Facility able to load the model. By default should be XMI.
	 */
	void initialize(String modelURI, String modelOfExecutionURI, ModelLoader modelLoader);

	/**
	 * Starts the {@link ExecutionEngine}.
	 */
	void start();
	
}
