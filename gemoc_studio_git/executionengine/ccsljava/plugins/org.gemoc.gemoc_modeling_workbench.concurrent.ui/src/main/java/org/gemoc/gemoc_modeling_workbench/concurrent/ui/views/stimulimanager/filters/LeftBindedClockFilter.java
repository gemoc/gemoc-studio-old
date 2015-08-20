package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class LeftBindedClockFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			Binding leftBinding = bindings.get(0);
			// We copy the collection and scan the copy to be able to delete some of the element while we are in the for()
			// else there is a problem.
			List<ModelSpecificEventWrapper> copyWrapperList = new ArrayList<ModelSpecificEventWrapper>(wrapperList);
			for(ModelSpecificEventWrapper clockWrapper: copyWrapperList)
			{
				if(clockWrapper.getMSE().getName() == leftBinding.getBindable().getName()) 
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks();
		return wrapperList;
	}
}
