package org.gemoc.execution.engine.io.views.event.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.execution.engine.io.views.event.ModelSpecificEvent;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class LeftBindedClockFilter extends Filter {

	@Override
	public Collection<ModelSpecificEvent> applyFilter() {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			Binding leftBinding = bindings.get(0);
			// We copy the collection and scan the copy to be able to delete some of the element while we are in the for()
			// else there is a problem.
			List<ModelSpecificEvent> copyWrapperList = new ArrayList<ModelSpecificEvent>(wrapperList);
			for(ModelSpecificEvent clockWrapper: copyWrapperList)
			{
				if(clockWrapper.getClock().getName() == leftBinding.getBindable().getName()) 
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks();
		return wrapperList;
	}
}
