package org.gemoc.execution.engine.io.views.engine.actions;

import java.util.ArrayList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtensionPoint;

public class SwitchDeciderAction extends Action implements IMenuCreator, IMotorSelectionListener
{
	
	private ArrayList<DeciderAction> _subActions = new ArrayList<>();

	private DeciderAction _mainAction;
	
	public SwitchDeciderAction()
	{
		super("fake", AS_DROP_DOWN_MENU);
		setMenuCreator(this);
				
		for (DeciderSpecificationExtension spec : DeciderSpecificationExtensionPoint.getSpecifications())
		{
			DeciderAction action = new DeciderAction(spec);
			if (spec.getName().contains("step"))
				_mainAction = action;
			_subActions.add(action);	
		}
				
		updateThis();
		
		setEnabled(false);
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.addMotorSelectionListener(this);
	}
	
	private void updateThis() {
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
		if (_currentSelectedEngine != null
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
	public Menu getMenu(Menu parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose() 
	{
		EnginesStatusView view = ViewHelper.retrieveView(EnginesStatusView.ID);
		view.removeMotorSelectionListener(this);
		if (_menu != null)
			_menu.dispose();
	}

	private GemocExecutionEngine _currentSelectedEngine;
	
	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) 
	{
		_currentSelectedEngine = engine;
		for (DeciderAction action : _subActions)
		{
			action.setEngine(_currentSelectedEngine);
		}
		setEnabled(_currentSelectedEngine != null);
	}

}
