package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.gemoc.execution.engine.io.views.event.filters.IEventFilterStrategy;

public class ViewContentProvider implements IStructuredContentProvider {
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	public void dispose() {
	}
	public Object[] getElements(Object parent) 
	{
		if(parent instanceof EventManagementCache){
			EventManagementCache cache = (EventManagementCache) parent;
			ArrayList<EventManagerClockWrapper> listeClockWrapper = new ArrayList<EventManagerClockWrapper>(cache.getFilteredWrappers(_filterStrategy));
			return listeClockWrapper.toArray();
		}
		return new Object[0];
	}

	
	private IEventFilterStrategy _filterStrategy;
	
	public void setFilterStrategy(IEventFilterStrategy filterStrategy) 
	{
		_filterStrategy = filterStrategy;
	}
}

