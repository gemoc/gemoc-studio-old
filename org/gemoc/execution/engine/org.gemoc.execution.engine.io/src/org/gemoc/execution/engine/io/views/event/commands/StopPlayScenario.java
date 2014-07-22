package org.gemoc.execution.engine.io.views.event.commands;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;

public class StopPlayScenario extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		eventView.getCurrentEngineCache().stopPlayScenario();
		eventView.informationMsg("Replay", "End");
		eventView.executeService(event, "PLAY");
		return null;			
	}	
}
