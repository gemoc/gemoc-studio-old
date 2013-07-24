package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import fr.inria.aoste.timesquare.ECL.EventKind;
import fr.inria.aoste.timesquare.backend.manager.visible.BehaviorManager;
import fr.inria.aoste.timesquare.ccslkernel.solver.CCSLKernelSolver;
import fr.inria.aoste.timesquare.ccslkernel.solver.TimeModel.SolverClock;

public class BasicExecutionEngine implements ExecutionEngine {

    private BehaviorManager backend;
    private boolean finished = false;
    private int rounds = 0;
    private CCSLKernelSolver solver;

    public BehaviorManager getBackend() {
        return backend;
    }
    
    public int getRounds() {
        return this.rounds;
    }

    public CCSLKernelSolver getSolver() {
        return solver;
    }

    /*private void integrateFeedback(Map<Integer, EObject> feedback) {
        for (Integer value : feedback.keySet()) {

            // target est l'objet qui fait suite selon le bon chemin.
            // Par exemple pour une decision node qui branche vers soit un
            // State A soit un State B,
            // target sera soit A soit B.
            EObject target = feedback.get(value);

            // Ensemble des clocks liées à l'event de type Start qui a pour
            // cible le EObject considéré.
            List<SolverClock> clocksOfEvent = this.getEclInterpreter().getDomainSpecificEvents().whereTargetIs(target)
                    .filterByKind(EventKind.START).getTruc().getClocks();
            if (value.equals(1)) {
                // Appeler l'API pour "forcer" les bonnes branches sur le MoC.
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
    }*/

    private List<EclEvent> match(Truc clockInputs) {
        List<EclEvent> res = new ArrayList<EclEvent>();

        return res;
    }

    @Override
    public void run() {
        this.run(-1);
    }

    public void run(int maxRounds) {
        while (!finished) {
            this.rounds++;

            Truc clockInputs = this.getSolver().getNext();
            List<EclEvent> events = this.match(clockInputs);

            for (EclEvent event : events) {
                Map<Integer, EObject> feedback = this.getBackend().execute(event);
                /*integrateFeedback(feedback);*/
            }

            finished = finished || this.rounds < maxRounds;
        } // end while
    }
}

interface EclEvent {
    // Event from ECL
}


interface Truc {
    // Trace fournie par CCSL ?
}
