package org.gemoc.execution.engine.io.views.engine;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gemoc.execution.engine.core.GemocRunningEnginesRegistry;

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
			return registry.getRunningEngines().values().toArray();
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
}
