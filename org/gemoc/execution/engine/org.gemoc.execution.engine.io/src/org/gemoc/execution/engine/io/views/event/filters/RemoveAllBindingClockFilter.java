package org.gemoc.execution.engine.io.views.event.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

/**
 * @author: lguillem
 */
public class RemoveAllBindingClockFilter extends Filter {

	@Override
	public Collection<EventManagerClockWrapper> applyFilter(
			List<Relation> relations,
			Collection<EventManagerClockWrapper> wrapperList) {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			String leftBindingClockName = bindings.get(0).getBindable().getName();
			String rightBindingClockName = bindings.get(1).getBindable().getName();
	
			List<EventManagerClockWrapper> copyWrapperList = new ArrayList<EventManagerClockWrapper>(wrapperList);
			
			for(EventManagerClockWrapper clockWrapper: copyWrapperList)
			{
				String nameClock = clockWrapper.getClock().getName();
				if(  nameClock == leftBindingClockName || nameClock == rightBindingClockName )
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks(wrapperList);
		return wrapperList;
	}
}
