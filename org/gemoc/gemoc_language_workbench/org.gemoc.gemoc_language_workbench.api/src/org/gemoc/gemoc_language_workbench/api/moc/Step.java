package org.gemoc.gemoc_language_workbench.api.moc;

import java.util.List;

import fr.inria.aoste.trace.EventOccurrence;

/**
 * A Step is an atomical unit of the solver which contains informations about
 * clocks
 * 
 * @author flatombe
 */
public interface Step {
	/**
	 * Returns the list of EventOccurrences contained by this step.
	 * 
	 * @return
	 */
	public List<EventOccurrence> getEventOccurrences();
}
