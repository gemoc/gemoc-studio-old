package org.gemoc.gemoc_language_workbench.api.feedback;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

/**
 * A FeedbackPolicy is in charge of interpreting some FeedbackData in order to
 * call correctly the API of the solver.
 * 
 * @author flatombe
 */
public interface FeedbackPolicy<F extends FeedbackData> {
	/**
	 * Using the data contained in the FeedbackData, calls the solver API to
	 * influence the constraints.
	 * 
	 * @param feedback
	 * @param solver
	 */
	public void processFeedback(F feedback, Solver solver);
}
