package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;

import org.gemoc.execution.engine.io.views.event.ModelSpecificEvent;

public class NoFilter extends Filter {

	@Override
	public Collection<ModelSpecificEvent> applyFilter() {
		addFutureTickingClocks();
		return wrapperList;
	}
}
