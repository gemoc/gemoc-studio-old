package org.gemoc.gemoc_language_workbench.api.dse;

import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

/**
 * For now DomainSpecificEvents are wrappers for DomainSpecificActions since we
 * are instantiating them on the fly when the solver returns a step containing
 * interesting information. However it would be much nicer to not have the
 * solver have the notion of Event/EventOccurrence.
 * 
 * 
 * @author flatombe
 */
public interface DomainSpecificEvent {
	public DomainSpecificAction getAction();
}
