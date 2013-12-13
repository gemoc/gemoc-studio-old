package org.gemoc.execution.engine.commons.feedback;

import glml.ModelSpecificAction;
import glml.ModelSpecificEvent;

import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackData;

/**
 * A simple Object wrapper.
 * 
 * @author flatombe
 * */
public class ObjectFeedbackData implements FeedbackData {
	private Object o;
	private ModelSpecificAction causalAction;

	public ObjectFeedbackData(Object feedback, ModelSpecificAction msa) {
		this.o = feedback;
		this.causalAction = msa;
	}

	@Override
	public Object getContent() {
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
	public ModelSpecificEvent getCausalEvent() {
		return this.causalAction.getOwningModelSpecificEvent();
	}
}
