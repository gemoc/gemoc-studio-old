package org.gemoc.execution.engine.solvers;

import org.gemoc.execution.engine.events.DomainSpecificEvent;

/**
 * A Step is an atomical unit of the solver which contains informations about
 * clocks
 * 
 * @author flatombe
 */
public interface Step {
    public Boolean match(DomainSpecificEvent event);
}
