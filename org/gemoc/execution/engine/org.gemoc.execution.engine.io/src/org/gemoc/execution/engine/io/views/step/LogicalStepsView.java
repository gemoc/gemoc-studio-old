package org.gemoc.execution.engine.io.views.step;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.gemoc.commons.eclipse.ui.TreeViewerHelper;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.IEvenPresenter;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.DependantViewPart;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.execution.engine.io.views.event.ModelSpecificEventWrapper;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;
import fr.obeo.dsl.debug.ide.ui.provider.DSLLabelDecorator;
import fr.obeo.dsl.debug.ide.ui.provider.DecoratingColumLabelProvider;

public class LogicalStepsView extends DependantViewPart implements IEvenPresenter
{

	public static final String ID = "org.gemoc.execution.engine.io.views.steps.LogicalStepsView";
	
	// TODO should use Launcher.MODEL_ID
	public final static String MODEL_ID = "org.gemoc.gemoc_modeling_workbench.ui.debugModel";

	private Color _representedEventColor;

	private TreeViewer _viewer;

	private DSLLabelDecorator _decorator;
	
	private ColumnLabelProvider _column1LabelProvider;

	private ColumnLabelProvider _column2LabelProvider;

	private List<URI> _eventsToPresent = new ArrayList<URI>(); 

	public LogicalStepsView() 
	{
	}

	private LogicalStepsViewContentProvider _contentProvider;

	private MenuManager _menuManager;
	
	@Override
	public void createPartControl(Composite parent) 
	{
		_representedEventColor = new Color(parent.getDisplay(), 255, 235, 174);
		createTreeViewer(parent);
	    createMenuManager();
	    Activator.getDefault().getEventPresenters().add(this);
	}

	private void createTreeViewer(Composite parent) {
		_viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.SINGLE);
		_viewer.setUseHashlookup(true);
		_contentProvider = new LogicalStepsViewContentProvider();
		_viewer.setContentProvider(_contentProvider);
		_decorator = new DSLLabelDecorator(MODEL_ID);
		Font mono = JFaceResources.getFont(JFaceResources.TEXT_FONT);
		_viewer.getTree().setFont(mono);
		createColumns();
	}
	

	private void createColumns() 
	{
		TreeColumn column1 = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		column1.setText("Logical Steps");
		TreeViewerColumn viewerColumn1 = new TreeViewerColumn(_viewer, column1);
		_column1LabelProvider = new DecoratingColumLabelProvider(new ColumnLabelProvider()
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
					if(ls == _currentEngine.getSelectedLogicalStep())
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
			
			@Override
			public Color getBackground(Object element) {
				final Color res;
				
				if (element instanceof Event && _eventsToPresent.contains(EcoreUtil.getURI((Event)element))) {
					res = _representedEventColor;
				} else {
					res = super.getBackground(element);
				}
				
				return res;
			}
			
		}, _decorator);
		viewerColumn1.setLabelProvider(_column1LabelProvider);

	
		TreeColumn column2 = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		column1.setText("Logical Steps");
		TreeViewerColumn viewerColumn2 = new TreeViewerColumn(_viewer, column2);
		_column2LabelProvider = new DecoratingColumLabelProvider(new ColumnLabelProvider()
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
		
			@Override
			public Color getBackground(Object element) {
				final Color res;
				
				if (element instanceof Event && _eventsToPresent.contains(EcoreUtil.getURI((Event)element))) {
					res = _representedEventColor;
				} else {
					res = super.getBackground(element);
				}
				
				return res;
			}
			
		}, _decorator);
		viewerColumn2.setLabelProvider(_column2LabelProvider);
		}

	private void createMenuManager() {
		MenuManager menuManager = new MenuManager();
		_menuManager = menuManager;
		_menuManager.setRemoveAllWhenShown(true);
		_menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});
	    Menu menu = _menuManager.createContextMenu(_viewer.getControl());
	    _viewer.getControl().setMenu(menu);
	    getSite().registerContextMenu(_menuManager, _viewer);
	    // make the selection available
	    getSite().setSelectionProvider(_viewer);
	}

	private void fillContextMenu(IMenuManager mgr) {
		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	@Override
	public void setFocus() 
	{
		_viewer.getControl().setFocus();
	}

	
	private IExecutionEngine _currentEngine;
	
	@Override
	public void motorSelectionChanged(IExecutionEngine engine) {
		if (engine != null
			&&  engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Animation)) 
		{
			_currentEngine = engine;	
			_decorator.setResourceSet(_currentEngine.getExecutionContext().getResourceModel().getResourceSet());
			_viewer.setInput(_currentEngine);
			if (_currentEngine != null
				&& !_currentEngine.getRunningStatus().equals(RunStatus.Stopped))
			{
				_viewer.expandAll();
				TreeViewerHelper.resizeColumns(_viewer);				
			}
			else 
			{
				_viewer.setInput(null);				
			}
		}
	}

	@Override
	public void dispose() {
		Activator.getDefault().getEventPresenters().remove(this);
		super.dispose();
		_column1LabelProvider.dispose();
		_column2LabelProvider.dispose();
		_menuManager.dispose();
		_contentProvider.dispose();
		_representedEventColor.dispose();
		_eventsToPresent.clear();
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

	@Override
	public void present(List<URI> events) {
		_eventsToPresent = events;
		if (_currentEngine != null) {
			ResourceSet rs = _currentEngine.getExecutionContext().getResourceModel().getResourceSet();
			for (URI uri : _eventsToPresent) {
				final EObject event = rs.getEObject(uri, false);
				if (event != null) {
					_viewer.refresh(event);
				}
			}
		}
	}

}
