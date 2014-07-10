package org.gemoc.execution.engine.io.views;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class EventFilter {
	IEventFilterStrategy _filterStrategy;
	
	public EventFilter(){
		_filterStrategy = new RemoveLeftBindingClock(); // Default strategy
	}

	public void set_filterStrategy(IEventFilterStrategy filter) {
		_filterStrategy = filter;
	}
	
	public void applyFilter(Relation relation, EventManagementCache engineCache){
		_filterStrategy.applyFilter(relation, engineCache);
	}
}
