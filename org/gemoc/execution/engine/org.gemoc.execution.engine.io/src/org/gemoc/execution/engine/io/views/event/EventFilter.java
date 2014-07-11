package org.gemoc.execution.engine.io.views.event;

import java.util.Collection;
import java.util.List;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class EventFilter {
	IEventFilterStrategy _filterStrategy;
	
	public EventFilter(){
		_filterStrategy = new RemoveAllBindingClockFilter(); // Default strategy
	}

	public void set_filterStrategy(IEventFilterStrategy filter) {
		_filterStrategy = filter;
	}
	
	public Collection<EventManagerClockWrapper> applyFilter(List<Relation> relations, Collection<EventManagerClockWrapper> wrapperList){
		return _filterStrategy.applyFilter(relations, wrapperList);
	}
}
