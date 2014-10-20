package org.gemoc.execution.engine.io.views.event.filters;

import java.util.Collection;

import org.gemoc.execution.engine.io.views.event.ModelSpecificEventWrapper;

public class NoFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		addFutureTickingClocks();
		return wrapperList;
	}
}
