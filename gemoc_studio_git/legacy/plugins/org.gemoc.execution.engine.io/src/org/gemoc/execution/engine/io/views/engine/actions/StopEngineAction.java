package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;

public class StopEngineAction extends AbstractEngineAction 
{

	public StopEngineAction()
	{
		super();
	}
	
	
	@Override
	protected void init() {
		super.init();
		setText("Stop");
		setToolTipText("Stop selected engines");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_STOP);
		setImageDescriptor(id);
	}


	@Override
	protected void updateButton() {
		super.updateButton();
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

	

}
