package org.gemoc.execution.engine.io.views;

import java.util.List;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class RemoveLeftBindingClock implements IEventFilterStrategy {

	@Override
	public void applyFilter(Relation relation, EventManagementCache engineCache) {
		List<Binding> bindings = relation.getBindings();
		Binding leftBinding = bindings.get(0);
		String clockNameLeftBinding = leftBinding.getBindable().getName();
		engineCache.removeFromClockCache(clockNameLeftBinding);
	}
}
