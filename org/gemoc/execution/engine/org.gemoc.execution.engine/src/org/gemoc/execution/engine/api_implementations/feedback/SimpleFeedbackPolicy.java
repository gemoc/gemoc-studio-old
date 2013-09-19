package org.gemoc.execution.engine.api_implementations.feedback;

import org.gemoc.execution.engine.Activator;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

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
