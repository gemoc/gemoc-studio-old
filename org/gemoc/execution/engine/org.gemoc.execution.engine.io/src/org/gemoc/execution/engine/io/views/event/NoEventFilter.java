package org.gemoc.execution.engine.io.views.event;

import java.util.Collection;
import java.util.List;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class NoEventFilter implements IEventFilterStrategy {

	@Override
	public Collection<EventManagerClockWrapper> applyFilter(
			List<Relation> relations,
			Collection<EventManagerClockWrapper> wrapperList) {
		return wrapperList;
	}

}
