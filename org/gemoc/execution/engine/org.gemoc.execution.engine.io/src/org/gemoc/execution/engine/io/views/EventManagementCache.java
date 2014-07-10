package org.gemoc.execution.engine.io.views;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class EventManagementCache 
{
	private Map<String, EventManagerClockWrapper> _clocksCache;
	private ClockControllerInternal _clockController;
	
	public EventManagementCache()
	{
		_clocksCache = new HashMap<String, EventManagerClockWrapper>();
		_clockController = new ClockControllerInternal();
	}

	public void configure(ObservableBasicExecutionEngine engine, ClockConstraintSystem clockConstraintSystem)
	{
		engine.addClockController(_clockController);
		EventInjectionContext context = new EventInjectionContext(engine.getSolver(), clockConstraintSystem);
		_clockController.initialize(context);
	}
	
	public void addClock(Clock clock) 
	{
		EventManagerClockWrapper newClockWrapper = new EventManagerClockWrapper(clock, _clockController);
		_clocksCache.put(clock.getName(), newClockWrapper);
	}

	public Collection<EventManagerClockWrapper> getWrappers() {
		return _clocksCache.values();
	}

	public EventManagerClockWrapper getWrapper(String clockName) {
		return _clocksCache.get(clockName);
	}
	
	public void removeFromClockCache(String clockName){
		_clocksCache.remove(clockName);
	}
	
	public void disableAllEvents(){
		Collection<EventManagerClockWrapper> clockWrappers = _clocksCache.values();
		for(EventManagerClockWrapper wrapper: clockWrappers)
		{
			wrapper.set_state(false);
		}
	}
}
