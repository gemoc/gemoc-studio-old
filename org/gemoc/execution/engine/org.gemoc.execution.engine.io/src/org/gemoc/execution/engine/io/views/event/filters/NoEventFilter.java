package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;

import org.gemoc.execution.engine.io.views.event.ClockWrapper;

public class NoEventFilter extends Filter {

	@Override
	public Collection<ClockWrapper> applyFilter() {
		addFutureTickingClocks();
		return wrapperList;
	}
}
