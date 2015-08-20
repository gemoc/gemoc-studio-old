package org.gemoc.executionframework.ui.views.engine;

import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.executionframework.ui.Activator;

/**
 * Views that are dependent on the engine selection in the EnginesStatusView may subclass this to get registered to it
 *
 */
public abstract class EngineSelectionDependentViewPart extends ViewPart implements
		IEngineSelectionListener {

	
	public EngineSelectionDependentViewPart()
	{
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		startListeningToEngineSelectionChange();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		stopListeningToEngineSelectionChange();
	}


	protected void startListeningToEngineSelectionChange() {
		// make sure the EngineStatusView is open
		ViewHelper.retrieveView(EnginesStatusView.ID);
		// register this view as listener
		Activator.getDefault().addEngineSelectionListener(this);
	}

	protected void stopListeningToEngineSelectionChange() {
		Activator.getDefault().removeEngineSelectionListener(this);
	}


}
