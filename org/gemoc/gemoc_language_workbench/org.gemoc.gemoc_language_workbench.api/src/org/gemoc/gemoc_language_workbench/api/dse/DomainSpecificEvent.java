package org.gemoc.gemoc_language_workbench.api.dse;

import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

/**
 * Language-level structure for the mapping between Domain-Specific Actions and
 * MoC relations.
 * 
 * @author flatombe
 * 
 */
public interface DomainSpecificEvent {
	/**
	 * 
	 * @return the name of this Domain Specific Event
	 */
	public String getName();

	/**
	 * 
	 * @return the list of Domain Specific Actions triggered by this event.
	 */
	public List<DomainSpecificAction> getActions();

	// TODO add constraint relations
}
