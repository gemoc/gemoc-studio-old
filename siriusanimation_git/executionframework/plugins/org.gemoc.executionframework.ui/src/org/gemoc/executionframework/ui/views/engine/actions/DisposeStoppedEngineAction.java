package org.gemoc.executionframework.ui.views.engine.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.executionframework.ui.Activator;
import org.gemoc.executionframework.ui.views.engine.EnginesStatusView;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public class DisposeStoppedEngineAction extends AbstractEngineAction 
{

	public DisposeStoppedEngineAction()
	{
		setText("Dispose stopped engine");
		setToolTipText("Dispose stopped engine");
		ImageDescriptor id = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, ISharedImages.IMG_ELCL_REMOVE);
		setImageDescriptor(id);
	}
	
	@Override
	public void run()
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeStoppedEngines();
		
		//EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		if(view.getSelectedEngine() != null &&  view.getSelectedEngine().getRunningStatus().equals(RunStatus.Stopped))
		{
			view.getSelectedEngine().dispose();
		}
		else
		{
			showMessage(view.getSite(), "please stop the Engine before trying to dispose it");		
		}
	}

	
	@Override
	public void engineSelectionChanged(IExecutionEngine engine) 
	{
		super.engineSelectionChanged(engine);
		if (getCurrentSelectedEngine() != null)
		{
			setEnabled(	getCurrentSelectedEngine().getRunningStatus().equals(RunStatus.Stopped));
						
		}
	}
}
