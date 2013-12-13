package org.gemoc.gemoc_language_workbench.api.feedback;

import glml.ModelSpecificAction;

import java.lang.reflect.InvocationTargetException;

import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;

/**
 * TODO : instead of doing it in Java, create a DSL for this.
 * 
 * A FeedbackPolicy is in charge of interpreting some FeedbackData in order to
 * (indirectly) call correctly the API of the solver.
 * 
 * @author flatombe
 */
public interface FeedbackPolicy {
	/**
	 * Using the data contained in the FeedbackData, calls (indirectly) the
	 * solver API to influence the constraints.
	 * 
	 * @param feedback
	 * @param solver
	 */
	public void processFeedback(FeedbackData feedback, ExecutionEngine engine);

	public FeedbackData convertToFeedbackDataImplementation(Object o,
			ModelSpecificAction causalAction) throws IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException;

}
