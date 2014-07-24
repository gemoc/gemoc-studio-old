package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;

import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;

public class NoEventFilter extends Filter {

	@Override
	public Collection<EventManagerClockWrapper> applyFilter() {
		addFutureTickingClocks();
		return wrapperList;
	}
}
