package org.gemoc.execution.engine.io.views;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public interface IEventFilterStrategy {
	public void applyFilter(Relation relation, EventManagementCache engineCache);
}

