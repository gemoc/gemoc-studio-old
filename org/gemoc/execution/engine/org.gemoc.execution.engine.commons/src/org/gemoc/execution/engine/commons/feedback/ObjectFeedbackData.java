package org.gemoc.execution.engine.commons.feedback;

import org.gemoc.gemoc_language_workbench.api.dsa.ModelSpecificAction;
import org.gemoc.gemoc_language_workbench.api.dse.ModelSpecificEvent;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * A simple Object wrapper.
 * 
 * @author flatombe
 * */
public class ObjectFeedbackData implements FeedbackData {
	private Object o;
	private ModelSpecificAction causalAction;

	public ObjectFeedbackData(Object feedback) {
		this.o = feedback;
	}

	public Object getObject() {
		return this.o;
	}

	public String toString() {
		return this.getClass().getName() + "@[" + this.o.toString() + "]";
	}

	@Override
	public ModelSpecificAction getCausalAction() {
		return this.causalAction;
	}

	@Override
	public void setCausalAction(ModelSpecificAction action) {
		this.causalAction = action;
	}

	@Override
	public ModelSpecificEvent getCausalEvent() {
		return this.causalAction.getOwningEvent();
	}
}
