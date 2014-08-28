package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPartSite;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;

public class StopEngineAction extends Action 
{

	public StopEngineAction()
	{
		setText("Stop");
		setToolTipText("Stop selected engines");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_STOP);
		setImageDescriptor(id);
	}
	
	@Override
	public void run()
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		if(view.getSelectedEngine() != null)
		{
			view.getSelectedEngine().stop();
		}
		else
		{
			showMessage(view.getSite(), "please select an engine to stop");		
		}
	}

	private void showMessage(IWorkbenchPartSite partSite, String message) {
		MessageDialog.openInformation(
			partSite.getShell(),
			"Gemoc Engines Status",
			message);
	}

}
