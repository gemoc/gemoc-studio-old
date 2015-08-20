package org.gemoc.gemoc_modeling_workbench.concurrent.ui.deciders.actions;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.executionframework.ui.views.engine.EnginesStatusView;
import org.gemoc.executionframework.ui.views.engine.actions.AbstractEngineAction;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public class SwitchDeciderAction extends AbstractEngineAction
{
	
	private ArrayList<DeciderAction> _subActions;

	private DeciderAction _mainAction;
	
	public SwitchDeciderAction()
	{
		super( AS_DROP_DOWN_MENU);
	}
	
	@Override
	protected void init(){
		_mainAction = DeciderManager.getStepByStepDeciderAction();
		_subActions = new ArrayList<>();
		for(DeciderAction action : DeciderManager.getAllDeciderActions()){
			_subActions.add(action);
		}
	}
	@Override
	protected void updateButton() {
		if (_mainAction != null)
		{
			setText(_mainAction.getText());
			setToolTipText(_mainAction.getToolTipText());
			setImageDescriptor(_mainAction.getImageDescriptor());			
		}
	}

	@Override
	public void run()
	{
		if (getCurrentSelectedEngine() != null
			&& _mainAction != null)
		{
			_mainAction.run();
		}
	}

	private Menu _menu;
	
	@Override
	public Menu getMenu(Control parent) {
		if (_menu == null)
		{
			_menu = new Menu(parent);
			for (Action action : _subActions) 
			{
				ActionContributionItem item = new ActionContributionItem(action);
				item.fill(_menu, -1);
			}
		} 
		return _menu;
	}

	

	@Override
	public void dispose() 
	{
		super.dispose();
		if (_menu != null)
			_menu.dispose();
	}

	
	@Override
	public void engineSelectionChanged(IExecutionEngine engine) 
	{
		super.engineSelectionChanged(engine);
		if (engine instanceof INonDeterministicExecutionEngine) {
			for (DeciderAction action : DeciderManager.getAllDeciderActions())
			{
				action.setEngine((INonDeterministicExecutionEngine)getCurrentSelectedEngine());
			}		
		}
	}

}
