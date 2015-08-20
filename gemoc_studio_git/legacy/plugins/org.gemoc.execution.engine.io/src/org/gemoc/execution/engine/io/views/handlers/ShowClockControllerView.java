package org.gemoc.execution.engine.io.views.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.StimuliManagerView;


public class ShowClockControllerView extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ViewHelper.retrieveView(StimuliManagerView.ID);
		return null;
	}


}
