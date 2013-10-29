package org.gemoc.gemoc_language_workbench.api.feedback;

import org.gemoc.gemoc_language_workbench.api.dsa.DomainSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;

/**
 * FeedbackData is the format of the data returned by the Domain-Specific
 * Action(s) through the Domain-Specific Event(s). They are interpreted by a
 * corresponding FeedbackPolicy in order to operate on the solver through the
 * API.
 * 
 * @author flatombe
 */
public interface FeedbackData {
	/**
	 * Can be "anything". A good start is probably to be able to wrap and unwrap
	 * all the primitive types.
	 */

	/**
	 * 
	 * @return the DSA that caused this feedback.
	 */
	public ModelSpecificAction getCausalAction();

	/**
	 * @param dsa
	 * 
	 */
	public void setCausalAction(ModelSpecificAction action);

	/**
	 * 
	 * @return the DSE instance (== ModelSpecificEvent) that caused this
	 *         feedback.
	 */
	public ModelSpecificEvent getCausalEvent();

}
