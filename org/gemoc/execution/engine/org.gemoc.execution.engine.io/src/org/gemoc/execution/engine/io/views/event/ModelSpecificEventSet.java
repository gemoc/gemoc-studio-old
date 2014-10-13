package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.gemoc.execution.engine.io.views.event.filters.IEventFilterStrategy;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class ModelSpecificEventSet 
{
	
	private Map<String, ModelSpecificEvent> _mseMap = new HashMap<String, ModelSpecificEvent>();

	private List<Relation> _relations = new ArrayList<Relation>();

	
	public ModelSpecificEventSet(ClockConstraintSystem clockConstraintSystem) 
	{
		for(Relation r : clockConstraintSystem.getSubBlock().get(0).getRelations())
		{
			if (r instanceof Relation)
			{
				_relations.add((Relation)r);
			}
		}
		if (clockConstraintSystem != null)
		{
			for (Element e : clockConstraintSystem.getSubBlock().get(0).getElements())
			{
				if (e instanceof Clock)
				{
					add((Clock)e);
				}
			}
		}
	}

	/**
	 * Wrap a clock and add it to the wrapper amp. 
	 * @param clock the clock to be 'wrapped' 
	 */
	private void add(Clock clock) 
	{
		ModelSpecificEvent mse = new ModelSpecificEvent(clock);
		_mseMap.put(clock.getName(), mse);
	}
	
	/**
	 * Return the wrappers for the corresponding strategy.
	 * @param filter the strategy to applied on the wrapper map
	 * @return The filtered wrappers for the current cache
	 */
	public Collection<ModelSpecificEvent> getFilteredMSEs(IEventFilterStrategy filter) 
	{
		filter.setParamFilter(_relations, _mseMap);
		return filter.applyFilter();
	}
	
	public ModelSpecificEvent getMSE(String clockName) 
	{
		return _mseMap.get(clockName);
	}

	public Collection<ModelSpecificEvent> getMSEs() 
	{
		return _mseMap.values();
	}

	
}
