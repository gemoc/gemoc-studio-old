package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;

public abstract class AbstractEngineAction extends Action  implements IMenuCreator, IMotorSelectionListener{

	public AbstractEngineAction(){	
		super("fake", AS_PUSH_BUTTON);
		setMenuCreator(this);
		setEnabled(false);
		
		init();
		updateButton();
		
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.addMotorSelectionListener(this);
	}
	
	protected void init(){
		
	}
	protected void updateButton(){
		
	}

	@Override
	public void dispose() 
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeMotorSelectionListener(this);
	}
	
	protected void showMessage(IWorkbenchPartSite partSite, String message) {
		MessageDialog.openInformation(
			partSite.getShell(),
			"Gemoc Engines Status",
			message);
	}
	
	
	private IExecutionEngine _currentSelectedEngine;
	public IExecutionEngine getCurrentSelectedEngine(){
		return _currentSelectedEngine;
	}
	
	@Override
	public void motorSelectionChanged(IExecutionEngine engine) 
	{
		_currentSelectedEngine = engine;
		
		if (_currentSelectedEngine == null)
		{
			setEnabled(false);			
		}
		else
		{
			setEnabled(
					!_currentSelectedEngine.getRunningStatus().equals(RunStatus.Stopped)
					&& _currentSelectedEngine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Animation));
						
		}
	}
	
	@Override
	public Menu getMenu(Control parent) {
		return null;
	}

	@Override
	public Menu getMenu(Menu parent) {
		return null;
	}
	
}
