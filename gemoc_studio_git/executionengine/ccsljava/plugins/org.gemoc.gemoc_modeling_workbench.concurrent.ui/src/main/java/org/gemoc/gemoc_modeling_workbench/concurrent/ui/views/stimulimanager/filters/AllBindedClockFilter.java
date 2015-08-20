package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

/**
 * @author: lguillem
 */
public class AllBindedClockFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		for(Relation relation: relations)
		{
			List<Binding> bindings = relation.getBindings();
			String leftBindingClockName = bindings.get(0).getBindable().getName();
			String rightBindingClockName = bindings.get(1).getBindable().getName();
	
			List<ModelSpecificEventWrapper> copyWrapperList = new ArrayList<ModelSpecificEventWrapper>(wrapperList);
			
			for(ModelSpecificEventWrapper clockWrapper: copyWrapperList)
			{
				String nameClock = clockWrapper.getMSE().getName();
				if(  nameClock == leftBindingClockName || nameClock == rightBindingClockName )
				{
					wrapperList.remove(clockWrapper);
				}
			}
		}
		addFutureTickingClocks();
		return wrapperList;
	}
}
