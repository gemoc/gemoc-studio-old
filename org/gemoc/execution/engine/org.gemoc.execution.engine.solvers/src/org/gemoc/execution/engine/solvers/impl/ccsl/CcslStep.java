package org.gemoc.execution.engine.solvers.impl.ccsl;

import java.util.List;

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
     * @see org.gemoc.execution.engine.solvers.Step#getEventOccurrences()
     */
    @Override
    public List<EventOccurrence> getEventOccurrences() {
        return this.step.getEventOccurrences();
    }

}
