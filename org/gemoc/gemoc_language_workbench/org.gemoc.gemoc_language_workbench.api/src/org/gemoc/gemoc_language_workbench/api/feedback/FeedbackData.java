package org.gemoc.gemoc_language_workbench.api.feedback;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionCall;


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
	private Object _data;
	private ActionCall _call;
	
	public FeedbackData(Object data, ActionCall call) 
	{
		super();
		_data = data;
		_call = call;
	}

	/**
	 * The original content of this FeedbackData.
	 * 
	 * @return the original object returned by the MSA which created this
	 *         FeedbackData.
	 */
	public Object getData()
	{
		return _data;
	}

	/**
	 * 
	 * 
	 * @return the EngineEventOccurence that caused this feedback.
	 */
	public ActionCall getCall()
	{
		return _call;
	}


	public String toString() {
		return this.getClass().getName() + "@[" + this._data + "]";
	}
}
