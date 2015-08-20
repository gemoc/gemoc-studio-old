package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.StimuliManagerView;

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
		StimuliManagerView eventView = ViewHelper.retrieveView(StimuliManagerView.ID);
		if(eventView.getEngine()!=null &&
		   !eventView.getEngine().getRunningStatus().equals(RunStatus.Stopped))
		{
			eventView.startRecordScenario();
		}
		else
		{
			eventView.informationMsg("Record Scenario", "Operation not possible, please select an engine");
		}			
	}	
	
}
