package org.gemoc.execution.engine.solvers;

import java.util.List;

import fr.inria.aoste.trace.EventOccurrence;

/**
 * A Step is an atomical unit of the solver which contains informations about
 * clocks
 * 
 * @author flatombe
 */
public interface Step {
    public List<EventOccurrence> getEventOccurrences();
}
