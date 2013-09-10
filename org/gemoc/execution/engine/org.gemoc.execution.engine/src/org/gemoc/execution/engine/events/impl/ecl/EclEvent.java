package org.gemoc.execution.engine.events.impl.ecl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.gemoc.execution.engine.Activator;
import org.gemoc.execution.engine.actions.DomainSpecificAction;
import org.gemoc.execution.engine.actions.impl.simple.MethodReferenceAction;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.data.impl.easy.EObjectFeedbackData;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.Reference;

/**
 * 
 * 
 * @author flatombe
 */
public class EclEvent implements DomainSpecificEvent {
    private DomainSpecificAction action;

    public EclEvent(EventOccurrence eventOccurrence){
        Clock c = this.getClockLinkedToOccurrence(eventOccurrence);
        if (c != null) {
            // is c a DSA caller --> should be replaced with mapping
            // manipulation
            EList<EObject> linkedObjects = c.getTickingEvent().getReferencedObjectRefs();
            if (linkedObjects.size() == 2) {

                // first object is the object, second is the method
                EObject eObject = linkedObjects.get(0);
                EObject eObjectMethod = linkedObjects.get(1);

                String methodName = "";
                try {
                    if (eObjectMethod instanceof EOperation) {
                        FeedbackData feedback = (new EmfExecutor()).execute(eObjectMethod, "getName");
                        if (feedback instanceof EObjectFeedbackData) {
                            Object result = (Object) ((EObjectFeedbackData) feedback).getEObject();
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
        }
    }

    private Clock getClockLinkedToOccurrence(EventOccurrence eventOcc) {
        Reference ref = eventOcc.getReferedElement();
        if (ref instanceof ModelElementReference) {
            ModelElementReference mer = (ModelElementReference) ref;
            EList<EObject> eobjects = mer.getElementRef();
            EObject actualObject = eobjects.get(eobjects.size() - 1);
            if (actualObject instanceof Clock) {
                // you got the clock that ticked
                return (Clock) actualObject;
            } else {
                return null;
            }
        } else {
            return null;
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
        return this.getClass().getName() + "@[" + this.action.toString() + " ; isEntryPoint:" + "]";
    }

}
