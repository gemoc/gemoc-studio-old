package org.gemoc.execution.engine.feedback.policy.impl.easy;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.feedback.data.impl.easy.EObjectFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;

/**
 * 
 * 
 * @author flatombe
 */
public class SimpleFeedbackPolicy implements FeedbackPolicy<EObjectFeedbackData> {

    public SimpleFeedbackPolicy() {
    }

    @Override
    public void processFeedback(EObjectFeedbackData feedbackData, Solver solver) {
        Activator.getMessagingSystem().warn("You need to complete processFeedback", Activator.PLUGIN_ID);
    }

    public String toString() {
        return this.getClass().getName() + "@[]";
    }
}
