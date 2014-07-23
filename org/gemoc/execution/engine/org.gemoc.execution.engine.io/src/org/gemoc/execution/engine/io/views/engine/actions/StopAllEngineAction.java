package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;

public class StopAllEngineAction extends Action 
{

	public StopAllEngineAction()
	{
		setText("Stop all engine");
		setToolTipText("Stop and remove all engine");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_REMOVEALL);
		setImageDescriptor(id);
	}
	
	@Override
	public void run()
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeStoppedEngines();
	}

}
