package org.gemoc.execution.engine.feedback.policy;

import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.solvers.Solver;

/**
 * A FeedbackPolicy is in charge of interpreting some FeedbackData in order to
 * call correctly the API of the solver.
 * 
 * @author flatombe
 */
public interface FeedbackPolicy<F extends FeedbackData> {
    public void processFeedback(F feedback, Solver solver);
}
