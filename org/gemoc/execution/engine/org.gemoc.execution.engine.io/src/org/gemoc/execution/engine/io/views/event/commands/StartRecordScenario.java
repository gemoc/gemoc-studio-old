package org.gemoc.execution.engine.io.views.event.commands;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.event.EventManagerView.SourceProviderControls;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

public class StartRecordScenario extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		if(eventView.getEngine()!=null &&
		   !eventView.getEngine().getEngineStatus().getRunningStatus().equals(RunStatus.Stopped))
		{
			eventView.informationMsg("Record Scenario", "Beginning of the operation");
			eventView.startRecordScenario();
			eventView.executeService(SourceProviderControls.RECORD);
		}
		else
		{
			eventView.informationMsg("Record Scenario", "Operation not possible, please select an engine");
		}
		return null;			
	}	
}
