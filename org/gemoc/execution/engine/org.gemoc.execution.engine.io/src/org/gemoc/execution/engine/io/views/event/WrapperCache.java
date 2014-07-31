package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.EventManagerView.ClockStatus;
import org.gemoc.execution.engine.io.views.event.control.ClockControllerInternal;
import org.gemoc.execution.engine.io.views.event.filters.IEventFilterStrategy;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class WrapperCache 
{
	/**
	 * All the wrappers for the current engine.
	 */
	private Map<String, ClockWrapper> _wrapperMap;
	private ClockControllerInternal _clockController;
	/**
	 * All the relations between clocks.
	 */
	private List<Relation> _relations;
	private ObservableBasicExecutionEngine _engine;
	private ClockConstraintSystem _system;


	public WrapperCache(ObservableBasicExecutionEngine engine)
	{
		_wrapperMap = new HashMap<String, ClockWrapper>();
		_clockController = new ClockControllerInternal();
	}

	/**
	 * Initialize the wrapper cache values.
	 * @param engine the new engine selected.
	 * @param clockConstraintSystem to get the context and relations.
	 */
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

	/**
	 * Wrap a clock and add it to the wrapper amp. 
	 * @param clock the clock to be 'wrapped' 
	 */
	public void add(Clock clock) 
	{
		ClockWrapper newClockWrapper = new ClockWrapper(clock, _clockController);
		_wrapperMap.put(clock.getName(), newClockWrapper);
	}
	
	/**
	 * 
	 * @return All the wrappers for the current cache.
	 */
	public Collection<ClockWrapper> getClockWrapperList() 
	{
		return _wrapperMap.values();
	}

	/**
	 * Return the wrappers for the corresponding strategy.
	 * @param filter the strategy to applied on the wrapper map
	 * @return The filtered wrappers for the current cache
	 */
	public Collection<ClockWrapper> getFilteredClockWrapperList(IEventFilterStrategy filter) 
	{
		filter.setParamFilter(_relations, _wrapperMap);
		return filter.applyFilter();
	}

	public ClockWrapper getClockWrapper(String clockName) 
	{
		return _wrapperMap.get(clockName);
	}

	/**
	 * Set all the wrappers state to not forced with no tick in the future.
	 */
	public void freeAllClocks()
	{
		for(ClockWrapper wrapper: _wrapperMap.values())
		{
			wrapper.setState(ClockStatus.NOTFORCED_NOTSET);
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

	/**
	 * Clean the non forced clock which will tick in the future
	 * between 2 steps.
	 */
	public void refreshFutureTickingFreeClocks() 
	{
		for(ClockWrapper wrapper: _wrapperMap.values())
		{
			if(!wrapper.getState().isForced())
			{
				wrapper.setState(ClockStatus.NOTFORCED_NOTSET);
			}
		}
	}
}
