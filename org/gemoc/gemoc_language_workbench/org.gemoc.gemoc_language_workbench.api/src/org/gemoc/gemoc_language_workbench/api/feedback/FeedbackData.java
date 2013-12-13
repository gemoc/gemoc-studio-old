package org.gemoc.gemoc_language_workbench.api.feedback;

import glml.ModelSpecificAction;
import glml.ModelSpecificEvent;

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
	 * The original content of this FeedbackData.
	 * 
	 * @return the original object returned by the MSA which created this
	 *         FeedbackData.
	 */
	public Object getContent();

	/**
	 * 
	 * 
	 * @return the MSA that caused this feedback.
	 */
	public ModelSpecificAction getCausalAction();

	/**
	 * 
	 * @return the DSE instance (== ModelSpecificEvent) that caused this
	 *         feedback.
	 */
	public ModelSpecificEvent getCausalEvent();

}
