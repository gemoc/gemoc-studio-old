package org.gemoc.execution.engine.io.views;

import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.executionframework.ui.views.engine.EnginesStatusView;
import org.gemoc.executionframework.ui.views.engine.IEngineSelectionListener;

public abstract class DependantViewPart extends ViewPart implements
		IEngineSelectionListener {

	
	public DependantViewPart()
	{
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		startListeningToMotorSelectionChange();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		stopListeningToMotorSelectionChange();
	}

	private EnginesStatusView _enginesStatusView;

	private void startListeningToMotorSelectionChange() {
		_enginesStatusView = ViewHelper.retrieveView(EnginesStatusView.ID);
		if (_enginesStatusView != null) {
			_enginesStatusView.addEngineSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView != null) {
			_enginesStatusView.removeEngineSelectionListener(this);
		}
	}


}
