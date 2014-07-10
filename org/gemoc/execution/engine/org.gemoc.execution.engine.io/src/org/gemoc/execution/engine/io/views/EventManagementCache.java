package org.gemoc.execution.engine.io.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class EventManagementCache 
{
	private Map<String, EventManagerClockWrapper> _clocksCache;
	private ClockControllerInternal _clockController;
	private ClockConstraintSystem _system;
	private EventFilter _selectedFilter;
	private List<Relation> _relations;

	public EventManagementCache()
	{
		_clocksCache = new HashMap<String, EventManagerClockWrapper>();
		_clockController = new ClockControllerInternal();
		_selectedFilter = new EventFilter();
	}

	public void configure(ObservableBasicExecutionEngine engine, ClockConstraintSystem clockConstraintSystem)
	{
		engine.addClockController(_clockController);
		_system = clockConstraintSystem;
		EventInjectionContext context = new EventInjectionContext(engine.getSolver(), clockConstraintSystem);
		_clockController.initialize(context);
		_relations = new ArrayList<Relation>();
		for(Relation r : _system.getSubBlock().get(0).getRelations())
		{
			if(r instanceof Relation)
			{
				_relations.add((Relation)r);
			}
		}
		return;
	}

	public void addClock(Clock clock) 
	{
		EventManagerClockWrapper newClockWrapper = new EventManagerClockWrapper(clock, _clockController);
		_clocksCache.put(clock.getName(), newClockWrapper);
	}

	public Collection<EventManagerClockWrapper> getWrappers() {
		return _selectedFilter.applyFilter(_relations, new ArrayList<EventManagerClockWrapper>(_clocksCache.values()));
	}

	public EventManagerClockWrapper getWrapper(String clockName) {
		return _clocksCache.get(clockName);
	}

	public void removeFromClockCache(String clockName){
		_clocksCache.remove(clockName);
	}
	
	public void setFilter(IEventFilterStrategy filter) {
		_selectedFilter.set_filterStrategy(filter);
	}

	public void disableAllEvents(){
		Collection<EventManagerClockWrapper> clockWrappers = _clocksCache.values();
		for(EventManagerClockWrapper wrapper: clockWrappers)
		{
			wrapper.set_state(false);
		}
	}
}
