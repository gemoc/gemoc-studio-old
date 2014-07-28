package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.control.ClockControllerInternal;
import org.gemoc.execution.engine.io.views.event.filters.IEventFilterStrategy;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class WrapperCache 
{
	private Map<String, ClockWrapper> _clocksCache;
	private ClockControllerInternal _clockController;
	private List<Relation> _relations;
	private ObservableBasicExecutionEngine _engine;
	private ClockConstraintSystem _system;
	
	public WrapperCache(ObservableBasicExecutionEngine engine)
	{
		_clocksCache = new HashMap<String, ClockWrapper>();
		_clockController = new ClockControllerInternal();
	}

	public void configure(ObservableBasicExecutionEngine engine, ClockConstraintSystem clockConstraintSystem)
	{
		_engine = engine;
		engine.get_clockControllers().add(_clockController);
		_system = clockConstraintSystem;
		EventInjectionContext context = new EventInjectionContext(engine.getExecutionContext().getSolver(), clockConstraintSystem);
		_clockController.initialize(context);
		_relations = new ArrayList<Relation>();
		for(Relation r : _system.getSubBlock().get(0).getRelations())
		{
			if(r instanceof Relation)
			{
				_relations.add((Relation)r);
			}
		}
	}

	public void add(Clock clock) 
	{
		ClockWrapper newClockWrapper = new ClockWrapper(clock, _clockController);
		_clocksCache.put(clock.getName(), newClockWrapper);
	}

	public Collection<ClockWrapper> getClockWrapperList() 
	{
		return _clocksCache.values();
	}
	
	public Collection<ClockWrapper> getFilteredClockWrapperList(IEventFilterStrategy filter) 
	{
		filter.setParamFilter(_relations, _clocksCache);
		return filter.applyFilter();
	}

	public ClockWrapper getClockWrapper(String clockName) 
	{
		return _clocksCache.get(clockName);
	}

	public void remove(String clockName)
	{
		_clocksCache.remove(clockName);
	}

	public void freeAllClocks()
	{
		for(ClockWrapper wrapper: _clocksCache.values())
		{
			if(wrapper.isForced()==null)
			{
				wrapper.free();
			}
		}
	}

	public ObservableBasicExecutionEngine getEngine()
	{
		return _engine;
	}
	
	public ClockConstraintSystem getSystem()
	{
		return _system;
	}
}
