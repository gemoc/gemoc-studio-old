package org.gemoc.execution.engine.feedback.data.impl.easy;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * A simple EObject.
 * 
 * @author flatombe
 * */
public class EObjectFeedbackData implements FeedbackData {
    EObject eo;

    public EObjectFeedbackData(EObject feedback) {
        this.eo = feedback;
    }
    
    public EObject getEObject(){
        return this.eo;
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.eo.toString() + "]";
    }
}
