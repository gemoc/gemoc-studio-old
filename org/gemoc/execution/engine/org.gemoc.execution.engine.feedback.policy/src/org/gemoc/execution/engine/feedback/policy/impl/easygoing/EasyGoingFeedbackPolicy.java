package org.gemoc.execution.engine.feedback.policy.impl.easygoing;

import java.util.List;

import org.gemoc.execution.engine.feedback.data.FeedbackData;
import org.gemoc.execution.engine.feedback.data.impl.simple.BooleanAndReferenceFeedbackData;
import org.gemoc.execution.engine.feedback.policy.FeedbackPolicy;
import org.gemoc.execution.engine.solvers.Solver;

import fr.inria.aoste.timesquare.ECL.EventKind;
import fr.inria.aoste.timesquare.ccslkernel.solver.TimeModel.SolverClock;

/**
 * An easy-going policy which forces the presence of all the clocks
 * corresponding to the event whose key in the feedback data is true, and forces
 * the abscence of all the clocks corresponding to the events whose key in the
 * feedback data is false.
 * 
 * @author flatombe
 */
public class EasyGoingFeedbackPolicy implements FeedbackPolicy<BooleanAndReferenceFeedbackData> {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.feedback.policy.FeedbackPolicy#processFeedback
     * (org.gemoc.execution.engine.feedback.data.FeedbackData)
     */
    @Override
    public void processFeedback(BooleanAndReferenceFeedbackData feedbackData, Solver solver) {
        for (Integer value : feedbackData.getMap().keySet()) {

            // target est l'objet qui fait suite selon le bon chemin.
            // Par exemple pour une decision node qui branche vers soit un
            // State A soit un State B,
            // target sera soit A soit B. EObject target = feedback.get(value);

            // Ensemble des clocks liées à l'event de type Start qui a pour
            // cible le EObject considéré.
            List<SolverClock> clocksOfEvent = this.getEclInterpreter().getDomainSpecificEvents().whereTargetIs(target)
                    .filterByKind(EventKind.START).getTruc().getClocks();
            if (value.equals(1)) {
                // Appeler l'API pour "forcer" les bonnes branches sur le MoC.
                this.getSolver().forceClocksOfEvent()
                for (SolverClock clock : clocksOfEvent) {
                    this.getSolver().forceClockPresence(clock);
                }
            } else {
                // API to cut some branches on the MoC.
                for (SolverClock clock : clocksOfEvent) {
                    this.getSolver().forceClockAbscence(clock);
                }
            }
        }
    }
}
