package org.gemoc.execution.engine.io.views.event.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

public class RecordScenarioAction extends Action {

	public RecordScenarioAction()
	{
		setText("Record");
		setToolTipText("Record scenario");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/media-record.png");
		setImageDescriptor(id);
	}
	
	@Override
	public void run() {
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		if(eventView.getEngine()!=null &&
		   !eventView.getEngine().getEngineStatus().getRunningStatus().equals(RunStatus.Stopped))
		{
			eventView.startRecordScenario();
		}
		else
		{
			eventView.informationMsg("Record Scenario", "Operation not possible, please select an engine");
		}			
	}	
	
}
