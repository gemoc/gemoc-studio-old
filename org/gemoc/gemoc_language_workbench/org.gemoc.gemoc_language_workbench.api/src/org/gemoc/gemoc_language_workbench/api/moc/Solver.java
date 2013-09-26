package org.gemoc.gemoc_language_workbench.api.moc;

import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;

import fr.inria.aoste.trace.LogicalStep;

/**
 * A Solver is the visible interface of any constraint solver system that runs
 * on the Model of Execution of a model, returns Steps upon requests and
 * provides an API to influence the constraint-solving.
 * 
 * @author flatombe
 */
public interface Solver {
	/**
	 * Forces the underlying MoC structure to forbid the triggering of the given
	 * Domain Specific Event.
	 * 
	 * @param event
	 */
	public void forceEventNonOccurrence(DomainSpecificEvent event);

	/**
	 * Forces the underlying MoC structure to trigger the given Domain Specific
	 * Event.
	 * 
	 * @param event
	 */
	public void forceEventOccurrence(DomainSpecificEvent event);

	/**
	 * Returns the next step on the MoC's agenda.
	 * 
	 * @return
	 */
	public LogicalStep getNextStep();
}
