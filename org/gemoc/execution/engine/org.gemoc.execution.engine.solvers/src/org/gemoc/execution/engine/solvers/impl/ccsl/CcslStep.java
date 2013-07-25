package org.gemoc.execution.engine.solvers.impl.ccsl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.gemoc.execution.engine.events.DomainSpecificEvent;
import org.gemoc.execution.engine.solvers.Step;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;

/**
 * A CcslStep is the atomical unit of the CcslSolver.
 * 
 * @author flatombe
 * 
 */
public class CcslStep implements Step {
    LogicalStep step;

    public CcslStep(LogicalStep step) {
        this.step = step;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.gemoc.execution.engine.solvers.Step#match(org.gemoc.execution.engine
     * .events.DomainSpecificEvent)
     */
    @Override
    public Boolean match(DomainSpecificEvent event) {
        // Match the pattern of the event with some stuff from the logicalstep.
        List<EventOccurrence> pattern = null;
        try {
            pattern = (ArrayList<EventOccurrence>) event.getPattern();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return this.tryToMatch(pattern);
    }

    // TODO : Very simplistic way to match stuff, probably not the right one.
    private Boolean tryToMatch(List<EventOccurrence> pattern) {
        EList<EventOccurrence> ticks = this.step.getEventOccurrences();
        return ticks.containsAll(pattern);
    }
}
