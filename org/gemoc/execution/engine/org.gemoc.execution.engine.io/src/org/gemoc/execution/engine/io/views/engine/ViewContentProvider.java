package org.gemoc.execution.engine.io.views.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gemoc.execution.engine.core.GemocRunningEnginesRegistry;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

class ViewContentProvider implements ITreeContentProvider 
{

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}
	
	public Object[] getElements(Object parent) {
		if (parent instanceof GemocRunningEnginesRegistry)
		{
			GemocRunningEnginesRegistry registry = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry;
			List<IExecutionEngine> engines = new ArrayList<IExecutionEngine>(registry.getRunningEngines().values());
			Collections.sort(engines, getComparator()); 
			return engines.toArray();
		}
		return null;
	}
	public Object getParent(Object child) 
	{
		return null;
	}
	
	public Object [] getChildren(Object parent) 
	{
		return new Object[0];
	}
	
	public boolean hasChildren(Object parent) 
	{
		return false;
	}
	
	private Comparator<IExecutionEngine> getComparator()
	{
		Comparator<IExecutionEngine> comparator = new Comparator<IExecutionEngine>() {
		    public int compare(IExecutionEngine c1, IExecutionEngine c2) 
		    {
		    	int c1Value = c1.getEngineStatus().getRunningStatus().ordinal();
		    	int c2Value = c2.getEngineStatus().getRunningStatus().ordinal();
		        if (c1Value < c2Value) 
		        {
		        	return -1;
		        } 
		        else if (c1Value > c2Value) 
		        {
		        	return 1;
		        }  
		        return 0;
		    }
		};
		return comparator;
	}
	
}
