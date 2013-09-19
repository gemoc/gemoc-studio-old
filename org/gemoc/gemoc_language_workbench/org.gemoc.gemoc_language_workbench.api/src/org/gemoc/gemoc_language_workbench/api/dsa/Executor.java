package org.gemoc.gemoc_language_workbench.api.dsa;

import org.gemoc.gemoc_language_workbench.api.dse.DomainSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * An Executor is responsible for executing the Domain-Specific Action(s)
 * referenced by Domain-Specific Event(s).
 * 
 * @author flatombe
 */
public interface Executor {
	/**
	 * Executes the Domain-Specific Action.
	 * 
	 * @param dsa
	 * @return
	 */
	public FeedbackData execute(DomainSpecificAction dsa);

	/**
	 * Executes the Domain-Specific Action(s) referenced by the given
	 * Domain-Specific Event.
	 */
	public FeedbackData execute(DomainSpecificEvent dse);

}
