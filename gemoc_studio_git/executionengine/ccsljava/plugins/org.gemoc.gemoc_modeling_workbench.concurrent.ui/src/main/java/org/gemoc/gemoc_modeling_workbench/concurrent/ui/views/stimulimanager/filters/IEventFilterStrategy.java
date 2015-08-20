package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.filters;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventWrapper;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public interface IEventFilterStrategy {
	public Collection<ModelSpecificEventWrapper> applyFilter();

	public void setParamFilter(List<Relation> relations, Map<String, ModelSpecificEventWrapper> cache);
}

