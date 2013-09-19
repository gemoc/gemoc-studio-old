package org.gemoc.execution.engine.api_implementations.moc;

import java.util.List;

import org.gemoc.gemoc_language_workbench.api.moc.Step;

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

    public List<EventOccurrence> getEventOccurrences() {
        return this.step.getEventOccurrences();
    }

    public String toString() {
        return this.getClass().getName() + "@[" + this.getEventOccurrences().toString() + "]";
    }

}
