package org.gemoc.execution.engine.io.views;

import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;

public abstract class DependantViewPart extends ViewPart implements
		IMotorSelectionListener {

	
	public DependantViewPart()
	{
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
			_enginesStatusView.addMotorSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView != null) {
			_enginesStatusView.removeMotorSelectionListener(this);
		}
	}


}
