package org.gemoc.execution.engine.io.views.step;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;

public class LogicalStepsViewContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() 
	{
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) 
	{
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof GemocExecutionEngine)
		{
			GemocExecutionEngine engine = (GemocExecutionEngine)inputElement;
			return engine.getEngineStatus().getCurrentLogicalStepChoice().toArray();
		}
		else if (inputElement instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)inputElement;
			ArrayList<Event> events = new ArrayList<Event>();
			for(Event event : LogicalStepHelper.getTickedEvents(ls))
			{
				events.add(event);
			}
			return events.toArray();
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof GemocExecutionEngine)
		{
			GemocExecutionEngine engine = (GemocExecutionEngine)parentElement;
			return engine.getEngineStatus().getCurrentLogicalStepChoice().toArray();
		}
		else if (parentElement instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)parentElement;
			ArrayList<Event> events = new ArrayList<Event>();
			for(Event event : LogicalStepHelper.getTickedEvents(ls))
			{
				events.add(event);
			}
			return events.toArray();
		}
		return new Object[0];	
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) 
	{
		if (element instanceof GemocExecutionEngine)
		{
			GemocExecutionEngine engine = (GemocExecutionEngine)element;
			return engine.getEngineStatus().getCurrentLogicalStepChoice().size() > 0;
		}
		else if (element instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)element;
			ArrayList<Event> events = new ArrayList<Event>();
			for(Event event : LogicalStepHelper.getTickedEvents(ls))
			{
				events.add(event);
			}
			return events.size() > 0;
		}
		return false;	
	}



}
