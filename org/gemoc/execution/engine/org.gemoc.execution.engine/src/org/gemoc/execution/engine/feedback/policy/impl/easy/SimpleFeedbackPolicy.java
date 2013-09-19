package org.gemoc.execution.engine.feedback.policy.impl.easy;

import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.api_implementations.feedback.ObjectFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;

/**
 * 
 * 
 * @author flatombe
 */
public class SimpleFeedbackPolicy implements FeedbackPolicy<ObjectFeedbackData> {

    public SimpleFeedbackPolicy() {
    }

    @Override
    public void processFeedback(ObjectFeedbackData feedbackData, Solver solver) {
        Activator.getMessagingSystem().warn("You need to complete processFeedback", Activator.PLUGIN_ID);
    }

    public String toString() {
        return this.getClass().getName() + "@[]";
    }
}
