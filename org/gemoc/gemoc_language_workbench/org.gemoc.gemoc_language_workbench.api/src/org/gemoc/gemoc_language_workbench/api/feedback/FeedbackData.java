package org.gemoc.gemoc_language_workbench.api.feedback;

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
}
