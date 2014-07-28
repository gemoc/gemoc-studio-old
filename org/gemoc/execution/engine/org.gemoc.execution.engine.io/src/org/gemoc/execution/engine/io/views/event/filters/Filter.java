package org.gemoc.execution.engine.io.views.event.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.ClockWrapper;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;


public abstract class Filter implements IEventFilterStrategy{
	
	protected Map<String, ClockWrapper> cache;
	protected Collection<ClockWrapper> wrapperList;
	protected List<Relation> relations;
	
	@Override
	public void setParamFilter(List<Relation> relations,
			Map<String, ClockWrapper> cache) {
		this.relations = relations;
		this.cache = new HashMap<String, ClockWrapper>(cache);
		wrapperList = new ArrayList<ClockWrapper>(cache.values());
	}
	
	protected void addFutureTickingClocks(){
		//wrapperLists.addAll(null); // recuperer toutes les clocks qui vont ticker dans le future
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		TreeViewer treeViewer = decisionView.getTreeViewer();
		final Tree tree = treeViewer.getTree();
		
		/*
		TreeSelection treeSelection = (TreeSelection)treeViewer.getSelection();
		treeSelection.getPaths()[0].getFirstSegment()
		*/
		TreeItem[] selection = tree.getSelection();
		List<String> eventNameList = new ArrayList<String>();
		for(TreeItem item : selection)
		{
			if(item.getExpanded())
			{
				for(TreeItem events : item.getItems())
				{
					eventNameList.add(events.getText().substring(4));
				}
			}
			else
			{
				for(TreeItem events : item.getParentItem().getItems())
				{
					eventNameList.add(events.getText().substring(4));
				}
				
			}
			for(String event : eventNameList){
				ClockWrapper wrapper = cache.get(event);
				if(wrapper.isForced()==null)
				{
					wrapper.setStateFutureTick(true);
				}
				wrapperList.remove(wrapper);
				wrapperList.add(wrapper);
			}
		}
	}
}
