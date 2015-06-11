package org.gemoc.execution.engine.io.views.engine.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.AbstractUserDecider;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

public class PauseResumeEngineDeciderAction extends Action implements IMenuCreator, IMotorSelectionListener
{
	
	
	private DeciderAction _currentAction;
	
	private DeciderAction _stepByStepDeciderAction;
	
	public PauseResumeEngineDeciderAction()
	{
		super("fake", AS_PUSH_BUTTON);
		setMenuCreator(this);
		
		_stepByStepDeciderAction = DeciderManager.getStepByStepDeciderAction();
		_currentAction = _stepByStepDeciderAction;		
		updateThis();
		
		setEnabled(false);
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.addMotorSelectionListener(this);
	}
	
	private void updateThis() {
		if (_currentAction != null)
		{
			// base text from Decider
			setText(_currentAction.getText());
			setToolTipText(_currentAction.getToolTipText());
			//setImageDescriptor(_currentAction.getImageDescriptor());
			if (_currentSelectedEngine == null || _currentSelectedEngine.getRunningStatus().equals(RunStatus.Stopped))
			{
				setEnabled(false);
				setImageDescriptor(SharedIcons.SUSPEND_ENGINE_DECIDER_ICON);
			}
			else
			{
				setEnabled(	true);
				
				// find the decider opposed to the one currently used by the engine
				_currentAction = DeciderManager.getSwitchDeciderAction(_currentSelectedEngine.getExecutionContext().getLogicalStepDecider());
				if(_currentAction.equals(_stepByStepDeciderAction)){
					setToolTipText("Suspend selected engine using "+ _currentAction.getText());
					setImageDescriptor(SharedIcons.SUSPEND_ENGINE_DECIDER_ICON);
				} else {
					setToolTipText("Resume selected engine using "+ _currentAction.getText());
					setImageDescriptor(SharedIcons.RESUME_ENGINE_DECIDER_ICON);
				}
			}
			
			
		}
	}

	@Override
	public void run()
	{
		if (_currentSelectedEngine != null
			&& _currentAction != null)
		{
			
			ILogicalStepDecider savedDecider = _currentSelectedEngine.getExecutionContext().getLogicalStepDecider();
			// apply the decider change
			_currentAction.run();			
			// now switch UI to the alternative Action by  refreshing UI
			updateThis();
			// relaunch the engine Ie. unlock possibly locked StepByStepDecider, for non "StepByStepDecider, simply let them run one more time
			if(savedDecider instanceof AbstractUserDecider){
				// get the equivalent decision from the new Decider
				org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep selectedlogicalStep;
				try {
					selectedlogicalStep = _currentSelectedEngine.getExecutionContext().getLogicalStepDecider().decide(_currentSelectedEngine, _currentSelectedEngine.getPossibleLogicalSteps());
					((AbstractUserDecider) savedDecider).decideFromTimeLine(selectedlogicalStep);
				} catch (InterruptedException e) {
				}
			}
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
	
	@Override
	public void dispose() 
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeMotorSelectionListener(this);
	}

	private IExecutionEngine _currentSelectedEngine;
	
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
			
			_currentAction.setEngine(engine);
			updateThis();
		}
	}

}
