package org.gemoc.execution.engine.io.views.event;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.services.ISourceProviderService;
import org.gemoc.commons.eclipse.ui.ViewHelper;

public class StopRecordScenario extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		eventView.informationMsg("Record Scenario", "Recording operation is completed");
		// Get the source provider service
		ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
				.getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
		eventView.stopRecordScenario();
		// now get my service
		PlayRecordState commandStateService = (PlayRecordState) sourceProviderService
				.getSourceProvider(PlayRecordState.RECORD_STATE);
		commandStateService.toogleRecordEnabled();
		return null;			
	}
}
