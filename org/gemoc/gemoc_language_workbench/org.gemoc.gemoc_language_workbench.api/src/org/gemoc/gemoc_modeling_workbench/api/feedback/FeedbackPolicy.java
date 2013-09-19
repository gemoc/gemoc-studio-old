package org.gemoc.gemoc_modeling_workbench.api.feedback;

import org.gemoc.gemoc_modeling_workbench.api.moc.Solver;

/**
 * A FeedbackPolicy is in charge of interpreting some FeedbackData in order to
 * call correctly the API of the solver.
 * 
 * @author flatombe
 */
public interface FeedbackPolicy<F extends FeedbackData> {
	public void processFeedback(F feedback, Solver solver);
}
