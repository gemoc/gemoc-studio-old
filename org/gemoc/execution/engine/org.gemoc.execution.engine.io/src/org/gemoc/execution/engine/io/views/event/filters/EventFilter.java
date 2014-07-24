package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class EventFilter {
	IEventFilterStrategy _filterStrategy;
	
	public EventFilter(){
		_filterStrategy = new RemoveAllBindingClockFilter(); // Default strategy
	}

	public void set_filterStrategy(IEventFilterStrategy filter) {
		_filterStrategy = filter;
	}
	
	public Collection<EventManagerClockWrapper> applyFilter(){
		return _filterStrategy.applyFilter();
	}
	
	public void setParamFilter(List<Relation> relations, Map<String, EventManagerClockWrapper> cache){
		_filterStrategy.setParamFilter(relations,  cache);
	}
}
