package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ViewContentProvider implements IStructuredContentProvider {
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	public void dispose() {
	}
	public Object[] getElements(Object parent) 
	{
		if(parent instanceof EventManagementCache){
			EventManagementCache cache = (EventManagementCache) parent;
			ArrayList<EventManagerClockWrapper> listeClockWrapper = 
					new ArrayList<EventManagerClockWrapper>(cache.getWrappers());
			return listeClockWrapper.toArray();
		}
		return new Object[0];
	}
}

