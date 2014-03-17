package org.gemoc.gemoc_language_workbench.api.feedback;

import org.gemoc.gemoc_language_workbench.api.dsa.EngineEventOccurence;


/**
 * FeedbackData is the format of the data returned by the Domain-Specific
 * Action(s) through the Domain-Specific Event(s). They are interpreted by a
 * corresponding FeedbackPolicy in order to operate on the solver through the
 * API.
 * 
 * @author flatombe
 */
public class FeedbackData {
	/**
	 * Can be "anything". A good start is probably to be able to wrap and unwrap
	 * all the primitive types.
	 */
	private Object data;
	private EngineEventOccurence contextEngineEventOccurence;
	
	

	public FeedbackData(Object data,
			EngineEventOccurence contextEngineEventOccurence) {
		super();
		this.data = data;
		this.contextEngineEventOccurence = contextEngineEventOccurence;
	}

	/**
	 * The original content of this FeedbackData.
	 * 
	 * @return the original object returned by the MSA which created this
	 *         FeedbackData.
	 */
	public Object getData(){
		return data;
	}

	/**
	 * 
	 * 
	 * @return the EngineEventOccurence that caused this feedback.
	 */
	public EngineEventOccurence getContextEngineEventOccurence(){
		return contextEngineEventOccurence;
	}


	public String toString() {
		return this.getClass().getName() + "@[" + this.data + "]";
	}
}
