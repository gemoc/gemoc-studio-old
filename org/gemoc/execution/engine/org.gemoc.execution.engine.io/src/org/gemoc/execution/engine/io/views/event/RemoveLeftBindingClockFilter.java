package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class RemoveLeftBindingClockFilter implements IEventFilterStrategy {

	@Override
	public Collection<EventManagerClockWrapper> applyFilter(
			List<Relation> relations,
			Collection<EventManagerClockWrapper> wrapperList) {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			Binding leftBinding = bindings.get(0);
			// We copy the collection and scan the copy to be able to delete some of the element while we are in the for()
			// else there is a problem.
			List<EventManagerClockWrapper> copyWrapperList = new ArrayList<EventManagerClockWrapper>(wrapperList);
			for(EventManagerClockWrapper clockWrapper: copyWrapperList)
			{
				if(clockWrapper.get_clock().getName() == leftBinding.getBindable().getName()) 
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		return wrapperList;
	}
}
