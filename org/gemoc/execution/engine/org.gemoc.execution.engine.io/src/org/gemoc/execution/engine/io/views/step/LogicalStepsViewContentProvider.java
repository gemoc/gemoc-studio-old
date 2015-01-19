package org.gemoc.execution.engine.io.views.step;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

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
		if (inputElement instanceof IExecutionEngine)
		{
			IExecutionEngine engine = (IExecutionEngine)inputElement;
			if (engine.getRunningStatus().equals(RunStatus.Stopped))
			{
				String message = "Motor is not running";
				return new Object[] {
					message
				};				
			}
			else
			{
				return engine.getPossibleLogicalSteps().toArray();				
			}
		}
		else if (inputElement instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)inputElement;
			ArrayList<ModelSpecificEvent> events = new ArrayList<ModelSpecificEvent>();
			for (MSEExecutionContext context : ls.getEventExecutionContexts())
			{
				events.add(context.getMse());
			}
			return events.toArray();
		}
		return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IExecutionEngine)
		{
			IExecutionEngine engine = (IExecutionEngine)parentElement;
			return engine.getPossibleLogicalSteps().toArray();
		}
		else if (parentElement instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)parentElement;
			ArrayList<ModelSpecificEvent> events = new ArrayList<ModelSpecificEvent>();		
			for (MSEExecutionContext context : ls.getEventExecutionContexts())
			{
				events.add(context.getMse());
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
		if (element instanceof IExecutionEngine)
		{
			IExecutionEngine engine = (IExecutionEngine)element;
			return engine.getPossibleLogicalSteps().size() > 0;
		}
		else if (element instanceof LogicalStep)
		{
			LogicalStep ls = (LogicalStep)element;
			ArrayList<ModelSpecificEvent> events = new ArrayList<ModelSpecificEvent>();
			for (MSEExecutionContext context : ls.getEventExecutionContexts())
			{
				events.add(context.getMse());
			}
			return events.size() > 0;
		}
		return false;	
	}



}
