package org.gemoc.execution.engine.io.views;

import java.util.Collection;
import java.util.List;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public interface IEventFilterStrategy {
	public Collection<EventManagerClockWrapper> applyFilter(List<Relation> relations, Collection<EventManagerClockWrapper> wrapperList);
}

