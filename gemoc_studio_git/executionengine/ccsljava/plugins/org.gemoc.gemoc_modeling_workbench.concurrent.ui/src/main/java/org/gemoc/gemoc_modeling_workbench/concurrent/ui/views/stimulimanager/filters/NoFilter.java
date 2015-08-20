package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.filters;

import java.util.Collection;

import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventWrapper;

public class NoFilter extends Filter {

	@Override
	public Collection<ModelSpecificEventWrapper> applyFilter() {
		addFutureTickingClocks();
		return wrapperList;
	}
}
