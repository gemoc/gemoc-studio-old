package org.gemoc.execution.engine.io.views.engine;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;

public class RemoveAllEngines extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeStoppedEngines();
		return null;
	}

}
