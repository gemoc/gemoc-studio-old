package org.gemoc.execution.engine.io.views.event;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;
import org.gemoc.commons.eclipse.ui.ViewHelper;

public class StopScenario extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		showMessage(eventView.getSite(), "Recording scenario session stopped");
		 // Get the source provider service
		eventView.StopRecordScenario();
	    ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
	        .getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
	    // now get my service
	    RecordState commandStateService = (RecordState) sourceProviderService
	        .getSourceProvider(RecordState.RECORD_STATE);
	    commandStateService.toogleEnabled();
	    return null;			
	}

	private void showMessage(IWorkbenchPartSite partSite, String message) {
		MessageDialog.openInformation(
			partSite.getShell(),
			"Event Manager",
			message);
	}
	
}
