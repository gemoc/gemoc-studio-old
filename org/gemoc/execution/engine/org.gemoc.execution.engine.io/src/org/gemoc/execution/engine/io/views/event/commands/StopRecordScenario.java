package org.gemoc.execution.engine.io.views.event.commands;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;

public class StopRecordScenario extends AbstractHandler {

	public static final String ID = "org.gemoc.execution.engine.io.views.event.commands.StopRecordScenario";
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		eventView.informationMsg("Record Scenario", "Recording operation is completed");
		eventView.stopRecordScenario();
		return null;			
	}
}
