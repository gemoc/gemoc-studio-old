package org.gemoc.execution.engine.events.impl.ecl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.actions.impl.simple.MethodReferenceAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.data.impl.easy.ObjectFeedbackData;

/**
 * 
 * 
 * @author flatombe
 */
public class EclEvent implements DomainSpecificEvent {
    private DomainSpecificAction action;

    public EclEvent(EObject eObject, EObject eObjectMethod) {
        String methodName = "";
        try {
            if (eObjectMethod instanceof EOperation) {
                FeedbackData feedback = (new EmfExecutor()).execute(eObjectMethod, "getName");
                if (feedback instanceof ObjectFeedbackData) {
                    Object result = (Object) ((ObjectFeedbackData) feedback).getObject();
                    if (result instanceof String) {
                        methodName = (String) result;
                        this.action = new MethodReferenceAction(eObject, methodName);
                    }
                }
            }
        } catch (ClassCastException e) {
            String errorMessage = "ClassCastException when trying to cast EObject as EOperation or EObject as Object";
            Activator.error(errorMessage, e);

        }
    }

    public EclEvent(DomainSpecificAction action) {
        this.action = action;
    }

    @Override
    public DomainSpecificAction getAction() {
        return this.action;
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.action.toString() + "]";
    }

}
