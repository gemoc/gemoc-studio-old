package org.gemoc.execution.engine.feedback.data.impl.simple;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * An implementation of the feedback using a map of booleans and EObjects.
 * 
 * @author flatombe
 * */
public class BooleanAndReferenceFeedbackData implements FeedbackData {
    Map<Boolean, EObject> map;

    public BooleanAndReferenceFeedbackData() {
        // TODO constructeur à partir des données du retour des DSA/DSE,
        // attention au format.
    }
}
