package org.gemoc.execution.engine.io.views.engine;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPartSite;
import org.gemoc.commons.eclipse.ui.ViewHelper;

public class StopEngine extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		if(view.getSelectedEngine() != null)
		{
			view.getSelectedEngine().stop();
		}
		else
		{
			showMessage(view.getSite(), "please select an engine to stop");		
		}
		return null;			
	}

	private void showMessage(IWorkbenchPartSite partSite, String message) {
		MessageDialog.openInformation(
			partSite.getShell(),
			"Gemoc Engines Status",
			message);
	}
}
