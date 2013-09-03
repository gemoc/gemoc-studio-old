package org.gemoc.execution.engine.feedback.policy.impl.easygoing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.console.MessageConsoleStream;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.feedback.data.impl.simple.BooleanAndReferenceFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.feedback.policy.impl.easygoing.exceptions.CorrespondingDomainSpecificEventNotFoundException;
import org.gemoc.execution.engine.solvers.Solver;

/**
 * An easy-going policy which forces the presence of all the clocks
 * corresponding to the event whose key in the feedback data is true, and forces
 * the abscence of all the clocks corresponding to the events whose key in the
 * feedback data is false.
 * 
 * @author flatombe
 */
public class EasyGoingFeedbackPolicy implements FeedbackPolicy<BooleanAndReferenceFeedbackData> {

    public EasyGoingFeedbackPolicy(MessageConsoleStream out) {
        out.println("Creating :" + this);
    }

    /**
     * Searches in the list of possible events given if any of these events is
     * "first" (entryPoint) and has for target the EObject given. Throws an
     * exception if no event is found as we expect the application to always the
     * right list of possible events.
     */
    private DomainSpecificEvent findEventWhereTargetIs(EObject eobject, List<DomainSpecificEvent> possibleEvents)
            throws CorrespondingDomainSpecificEventNotFoundException {
        for (DomainSpecificEvent event : possibleEvents) {
            if (event.getTarget().equals(eobject) && event.isEntryPoint()) {
                return event;
            }
        }
        throw new CorrespondingDomainSpecificEventNotFoundException();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.feedback.policy.FeedbackPolicy#processFeedback
     * (org.gemoc.execution.engine.feedback.data.FeedbackData)
     */
    @Override
    public void processFeedback(BooleanAndReferenceFeedbackData feedbackData, Solver solver,
            List<DomainSpecificEvent> possibleEvents) {
        for (Boolean key : feedbackData.getMap().keySet()) {
            for (EObject eobject : feedbackData.getMap().get(key)) {
                try {
                    DomainSpecificEvent eventToForce = this.findEventWhereTargetIs(eobject, possibleEvents);
                    if (key) {
                        solver.forceEventOccurrence(eventToForce);
                    } else {
                        solver.forceEventNonOccurrence(eventToForce);
                    }
                } catch (CorrespondingDomainSpecificEventNotFoundException e) {
                    // TODO : Maybe do something, we were not able to match the
                    // feedback information with a DSE.
                    e.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        return "EasyGoingFeedbackPolicy@[]";
    }
}
