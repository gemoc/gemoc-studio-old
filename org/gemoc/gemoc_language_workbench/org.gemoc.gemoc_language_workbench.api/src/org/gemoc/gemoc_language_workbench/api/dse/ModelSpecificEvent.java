package org.gemoc.gemoc_language_workbench.api.dse;

import java.util.List;

import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;

/**
 * For now, DomainSpecificEvents are wrappers for DomainSpecificActions built
 * thanks to the information contained by the CcslSolver's steps.
 * 
 * TODO: When we change ECL, then the Domain Specific Events should come from
 * analyzing the new file containing the DSE informations.
 * 
 * @author flatombe
 */
public interface ModelSpecificEvent {
	/**
	 * Returns the ModelSpecificActions contained by this event.
	 * 
	 * 
	 * @return the ModelSpecificActions contained by this event.
	 */
	public List<ModelSpecificAction> getActions();

	/**
	 * 
	 * @return the language-level Domain-Specific Event of which this MSE is an
	 *         instance.
	 */
	public DomainSpecificEvent getReification();

	/**
	 * 
	 * @return the name of this event
	 */
	public String getName();
}
