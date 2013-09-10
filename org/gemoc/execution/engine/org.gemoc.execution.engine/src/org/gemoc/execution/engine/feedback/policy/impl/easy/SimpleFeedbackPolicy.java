package org.gemoc.execution.engine.feedback.policy.impl.easy;

import java.util.logging.Logger;

import org.gemoc.execution.engine.feedback.data.impl.easy.EObjectFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;

/**
 * 
 * 
 * @author flatombe
 */
public class SimpleFeedbackPolicy implements FeedbackPolicy<EObjectFeedbackData> {

    Logger logger;

    public SimpleFeedbackPolicy(String parentLoggerName) {
        this.logger = Logger.getLogger(parentLoggerName + "." + this.getClass().getName());
    }

    @Override
    public void processFeedback(EObjectFeedbackData feedbackData, Solver solver) {

    }

    public String toString() {
        return this.getClass().getName() + "@[]";
    }
}
