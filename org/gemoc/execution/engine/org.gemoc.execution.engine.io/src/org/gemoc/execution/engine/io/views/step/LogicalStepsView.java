package org.gemoc.execution.engine.io.views.step;

import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.DependantViewPart;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;

public class LogicalStepsView extends DependantViewPart 
{

	public static final String ID = "org.gemoc.execution.engine.io.views.steps.LogicalStepsView";
	
	private TreeViewer _viewer;


	public LogicalStepsView() 
	{
	}

	
	private LogicalStepsViewContentProvider _contentProvider;
	private LogicalStepsViewLabelProvider _labelProvider;
	private MenuManager _menuManager;
	
	@Override
	public void createPartControl(Composite parent) 
	{
		createTreeViewer(parent);
	    createMenuManager();
	}

	private void createTreeViewer(Composite parent) {
		_viewer = new TreeViewer(parent);
		_contentProvider = new LogicalStepsViewContentProvider();
		_labelProvider = new LogicalStepsViewLabelProvider();
		_viewer.setContentProvider(_contentProvider);
		_viewer.setLabelProvider(_labelProvider);
		Font mono = JFaceResources.getFont(JFaceResources.TEXT_FONT);
		_viewer.getTree().setFont(mono);
	}

	private void createMenuManager() {
		MenuManager menuManager = new MenuManager();
	    _menuManager = menuManager;
	    Menu menu = menuManager.createContextMenu(_viewer.getControl());
	    _viewer.getControl().setMenu(menu);
	    getSite().registerContextMenu(menuManager, _viewer);
	    // make the selection available
	    getSite().setSelectionProvider(_viewer);
	}

	@Override
	public void setFocus() 
	{
		_viewer.getControl().setFocus();
	}

	
	private GemocExecutionEngine _currentEngine;
	
	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) 
		{
			_currentEngine = engine;		
			_labelProvider.setEngine(engine);
			_viewer.setInput(_currentEngine);
			_viewer.expandAll();
		}
	}

	private LogicalStep _lastSelectedLogicalStep;
	public LogicalStep getSelectedLogicalStep() 
	{
		try{
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					TreeSelection selection = (TreeSelection) _viewer.getSelection();
					TreePath path = selection.getPaths()[0];
					_lastSelectedLogicalStep = null;
					if (path.getLastSegment() instanceof LogicalStep)
					{
						_lastSelectedLogicalStep = (LogicalStep)path.getLastSegment();						
					}
					else if (path.getLastSegment() instanceof Event)
					{
						_lastSelectedLogicalStep = (LogicalStep) path.getFirstSegment();
					}
				}
			});
		} catch(Exception e){
			Activator.getDefault().error(e.getMessage(), e);
		} 
		return _lastSelectedLogicalStep;			
	}

	public void addMenuListener(IMenuListener2 menuListener) 
	{
		_menuManager.addMenuListener(menuListener);	
	}

	public void addDoubleClickListener(IDoubleClickListener doubleClickListener) 
	{
		_viewer.addDoubleClickListener(doubleClickListener);
	}

	public void removeMenuListener(IMenuListener2 menuListener) 
	{
		_menuManager.removeMenuListener(menuListener);
	}

	public void removeDoubleClickListener(IDoubleClickListener doubleClickListener)
	{
		_viewer.removeDoubleClickListener(doubleClickListener);
	}
}
