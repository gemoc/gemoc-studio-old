package org.gemoc.execution.engine.io.views.event.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.event.EventManagerView;

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
		EventManagerView eventView = ViewHelper.retrieveView(EventManagerView.ID);
		eventView.stopPlayScenario();
		eventView.stopRecordScenario();
	}
	
}
