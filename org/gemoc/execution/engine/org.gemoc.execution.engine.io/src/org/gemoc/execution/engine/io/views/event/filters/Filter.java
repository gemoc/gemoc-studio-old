package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;

import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;

import fr.inria.aoste.trace.LogicalStep;


public abstract class Filter implements IEventFilterStrategy{
	public void addFutureTickingClocks(Collection<EventManagerClockWrapper> wrapperLists){
		//wrapperLists.addAll(null); // recuperer toutes les clocks qui vont ticker dans le future
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		LogicalStep l = decisionView.getSelectedLogicalStep();
		if(l!=null)
		{
			for(Object o : l.eContents())
			{
//				if(o instanceof Event)
//				{
//					((Event)o).getName();
//				}
			}
		}
	}
}
