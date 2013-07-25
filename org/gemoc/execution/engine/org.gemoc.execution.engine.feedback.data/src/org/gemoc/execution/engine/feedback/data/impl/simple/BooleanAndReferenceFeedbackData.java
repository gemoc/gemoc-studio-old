package org.gemoc.execution.engine.feedback.data.impl.simple;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.gemoc.execution.engine.feedback.data.FeedbackData;

/**
 * An implementation of the feedback using a map of booleans and EObjects.
 * 
 * @author flatombe
 * */
public class BooleanAndReferenceFeedbackData implements FeedbackData {
    Map<Boolean, List<EObject>> map;

    public BooleanAndReferenceFeedbackData() {
        // TODO : constructeur à partir du format renvoyé par les DSAs ... donc
        // ça va être un mix de EList etc. A settle avec le DSA-designer qui
        // devra comply à la structure utilisée ici.
    }

    public Map<Boolean, List<EObject>> getMap() {
        return this.map;
    }
}
