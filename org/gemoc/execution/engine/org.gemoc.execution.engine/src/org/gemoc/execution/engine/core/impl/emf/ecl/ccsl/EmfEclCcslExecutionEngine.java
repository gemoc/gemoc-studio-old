package org.gemoc.execution.engine.core.impl.emf.ecl.ccsl;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.core.BasicExecutionEngine;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.events.impl.ecl.EclEvent;
import org.gemoc.execution.engine.executors.impl.emf.EmfExecutor;
import org.gemoc.execution.engine.feedback.policy.impl.easygoing.EasyGoingFeedbackPolicy;
import org.gemoc.execution.engine.solvers.Step;
import org.gemoc.execution.engine.solvers.impl.ccsl.CcslSolver;

import fr.inria.aoste.trace.EventOccurrence;

/**
 * An implementation of the engine using the EMF Executor, the ECL events, the
 * CCSL solver and the EasyGoing Feedback Policy.
 * 
 * @author flatombe
 * 
 */
public class EmfEclCcslExecutionEngine extends BasicExecutionEngine {

    public EmfEclCcslExecutionEngine() {
        super();
        this.solver = new CcslSolver();
        this.executor = new EmfExecutor();
        this.feedbackPolicy = new EasyGoingFeedbackPolicy();

        // TODO : création des DSE (et DSA) associées à partir des infos du ECL.
        // c-a-d que le fichier ECL devrait permettre d'instancier correctement
        // les EclEvent (EclEvent étant liés à un domain specific concept (le
        // context), une dsa (éventuellement avec des arguments?) et les
        // horloges CCSL générées à partir du ECL.
        /*
         * this.events = new ArrayList<DomainSpecificEvent>(); for(Truc truc :
         * entréeECL){ EclEvent event = new EclEvent(truc) events.add(event); }
         */
    }

    /**
     * 
     * @param step
     * @return the list of Domain Specific Event which are triggered by the
     *         step.
     */
    protected List<DomainSpecificEvent> match(Step step) {
        List<DomainSpecificEvent> res = new ArrayList<DomainSpecificEvent>();
        for (EventOccurrence eventOccurrence : step.getEventOccurrences()) {
            res.add(new EclEvent(eventOccurrence));
        }
        return res;
    }
}
