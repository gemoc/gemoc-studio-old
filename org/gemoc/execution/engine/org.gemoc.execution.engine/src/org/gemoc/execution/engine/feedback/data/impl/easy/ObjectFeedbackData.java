package org.gemoc.execution.engine.feedback.data.impl.easy;

import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * A simple EObject.
 * 
 * @author flatombe
 * */
public class ObjectFeedbackData implements FeedbackData {
    Object o;

    public ObjectFeedbackData(Object feedback) {
        this.o = feedback;
    }

    public Object getObject() {
        return this.o;
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.o.toString() + "]";
    }
}
