package org.gemoc.executionframework.ui.views.engine.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.executionframework.ui.Activator;
import org.gemoc.executionframework.ui.views.engine.EnginesStatusView;

public class DisposeAllStoppedEnginesAction extends Action 
{

	public DisposeAllStoppedEnginesAction()
	{
		setText("Dispose stopped engines");
		setToolTipText("Dispose all stopped engines");
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
