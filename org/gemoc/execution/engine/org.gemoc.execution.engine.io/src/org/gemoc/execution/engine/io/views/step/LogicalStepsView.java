package org.gemoc.execution.engine.io.views.step;


import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.gemoc.commons.eclipse.ui.TreeViewerHelper;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.DependantViewPart;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
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
	private MenuManager _menuManager;
	
	@Override
	public void createPartControl(Composite parent) 
	{
		createTreeViewer(parent);
	    createMenuManager();
	}

	private void createTreeViewer(Composite parent) {
		_viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.SINGLE);
		_contentProvider = new LogicalStepsViewContentProvider();
		_viewer.setContentProvider(_contentProvider);
		Font mono = JFaceResources.getFont(JFaceResources.TEXT_FONT);
		_viewer.getTree().setFont(mono);
		createColumns();
	}
	

	private void createColumns() 
	{
		TreeColumn column1 = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		column1.setText("Logical Steps");
		TreeViewerColumn viewerColumn1 = new TreeViewerColumn(_viewer, column1);
		viewerColumn1.setLabelProvider(new ColumnLabelProvider()
			{
				
				@Override
				public String getText(Object element) {
					if (element instanceof LogicalStep)
					{
						LogicalStep ls = (LogicalStep)element;
						return LogicalStepHelper.getLogicalStepName(ls);
					}
					else if (element instanceof Event)
					{
						Event event = (Event)element;
						return event.getName();
					}
					return super.getText(element);
				}
			
				@Override
				public Image getImage(Object element) {
					if (element instanceof LogicalStep)
					{
						LogicalStep ls = (LogicalStep)element;
						if(ls == _currentEngine.getEngineStatus().getChosenLogicalStep())
						{
							return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_RUNNING_ICON);
						}
						else {
							return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_ICON);					
						}
					}
					else if (element instanceof Event)
					{
						return SharedIcons.getSharedImage(SharedIcons.VISIBLE_EVENT_ICON);
					}
					return null;
				}
				
			});

	
		TreeColumn column2 = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		column1.setText("Logical Steps");
		TreeViewerColumn viewerColumn2 = new TreeViewerColumn(_viewer, column2);
		viewerColumn2.setLabelProvider(new ColumnLabelProvider()
			{
				
				@Override
				public String getText(Object element) {
					if (element instanceof Event)
					{
						String details = ViewUtils.eventToString((Event)element);
						return "   " + details;
					}
					return "";
				}
			
			});}

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
			_viewer.setInput(_currentEngine);
			if (_currentEngine != null
				&& !_currentEngine.getEngineStatus().getRunningStatus().equals(RunStatus.Stopped))
			{
				_viewer.expandAll();
				TreeViewerHelper.resizeColumns(_viewer);				
			}
//			else 
//			{
//				_viewer.setInput(null);				
//			}
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
					if (selection.getPaths().length > 0)
					{
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
	
	public void addSelectionChangedListener(ISelectionChangedListener listener)
	{
		_viewer.addSelectionChangedListener(listener);
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener)
	{
		_viewer.removeSelectionChangedListener(listener);
	}

	public void removeMenuListener(IMenuListener2 menuListener) 
	{
		_menuManager.removeMenuListener(menuListener);
	}

	public void removeDoubleClickListener(IDoubleClickListener doubleClickListener)
	{
		_viewer.removeDoubleClickListener(doubleClickListener);
	}
	
	public TreeViewer getTreeViewer(){
		return _viewer;
	}
}
