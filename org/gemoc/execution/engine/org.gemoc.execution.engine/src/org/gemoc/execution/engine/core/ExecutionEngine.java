package org.gemoc.execution.engine.core;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class ExecutionEngine extends ExecutionEngineAbstract {
    private int rounds = 0;
    private boolean finished = false;

    public void run() {
        this.run(-1);
    }

    public void run(int maxRounds) {
        while (!finished) {
            Truc clockInputs = this.getSolver().getNext();
            List<ECLEvent> events = this.match(clockInputs);

            for (ECLEvent event : events) {
                Map<Integer, EObject> feedback = this.getBackend().execute(event);
                cutSomeBranches(feedback);
            }

            finished = finished || this.rounds < maxRounds;
        } // end while
    }

    private void cutSomeBranches(Map<Integer, EObject> feedback) {
        for (Integer value : feedback.keySet()) {
            if (value.equals(1)) {
                EObject target = feedback.get(value);
                // target est l'objet qui fait suite selon le bon chemin.
                // Par exemple pour une decision node qui branche vers soit un
                // State A soit un State B,
                // target sera soit A soit B.
                // Appeler l'API pour "forcer" les bonnes branches sur le MoC.
            } else {
                // API to cut some branches on the MoC.
            }
        }
    }
}

class ECLEvent {
    // Event from ECL
}

class Truc {
    // Trace fournie par CCSL ?
}
