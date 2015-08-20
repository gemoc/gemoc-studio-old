package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.StimuliManagerView;

public class StopAction extends Action
{

	public StopAction() 
	{
		setText("Stop");
		setToolTipText("Stop playing or recording");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_STOP);
		setImageDescriptor(id);
	}
	
	@Override
	public void run() 
	{
		StimuliManagerView eventView = ViewHelper.retrieveView(StimuliManagerView.ID);
		eventView.stopPlayScenario();
		eventView.stopRecordScenario();
	}
	
}
