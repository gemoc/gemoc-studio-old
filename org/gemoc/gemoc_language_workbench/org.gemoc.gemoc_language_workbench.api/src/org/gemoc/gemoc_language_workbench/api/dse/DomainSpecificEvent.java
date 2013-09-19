package org.gemoc.gemoc_language_workbench.api.dse;

import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;

/**
 * For now, DomainSpecificEvents are wrappers for DomainSpecificActions built
 * thanks to the information contained by the CcslSolver's steps.
 * 
 * TODO: When we change ECL, then the Domain Specific Events should come from
 * analyzing the new file containing the DSE informations.
 * 
 * @author flatombe
 */
public interface DomainSpecificEvent {
	/**
	 * Returns the DomainSpecificAction contained by this event.
	 * 
	 * TODO: Needs to be changed when we authorize a DSE to refer to multiple
	 * DSAs.
	 * 
	 * @return the DomainSpecificAction contained by this event.
	 */
	public DomainSpecificAction getAction();
}
