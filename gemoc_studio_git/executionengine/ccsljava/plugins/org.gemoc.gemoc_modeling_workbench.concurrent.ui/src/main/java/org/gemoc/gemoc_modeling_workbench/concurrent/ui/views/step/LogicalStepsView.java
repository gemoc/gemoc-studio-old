package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.step;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuListener2;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
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
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.gemoc.commons.eclipse.ui.TreeViewerHelper;
import org.gemoc.execution.engine.core.GemocRunningEnginesRegistry;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.execution.engine.trace.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.executionengine.ccsljava.api.core.INonDeterministicExecutionEngine;
import org.gemoc.executionframework.ui.IMSEPresenter;
import org.gemoc.executionframework.ui.views.engine.EngineSelectionDependentViewPart;
import org.gemoc.executionframework.ui.views.engine.actions.DisposeAllStoppedEnginesAction;
import org.gemoc.executionframework.ui.views.engine.actions.DisposeStoppedEngineAction;
import org.gemoc.executionframework.ui.views.engine.actions.StopEngineAction;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.Activator;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.SharedIcons;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.deciders.actions.PauseResumeEngineDeciderAction;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.deciders.actions.SwitchDeciderAction;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class LogicalStepsView extends EngineSelectionDependentViewPart implements IMSEPresenter
{

	public static final String ID = "org.gemoc.execution.engine.io.views.steps.LogicalStepsView";

	private Color _representedEventColor;

	private TreeViewer _viewer;

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
		buildActionToolbar();
		org.gemoc.executionframework.ui.Activator.getDefault().getEventPresenters().add(this);
	}

	private void createTreeViewer(Composite parent)
	{
		_viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.SINGLE);
		_viewer.setUseHashlookup(true);
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
		_column1LabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element)
			{
				if (element instanceof LogicalStep)
				{
					LogicalStep ls = (LogicalStep) element;
					return LogicalStepHelper.getLogicalStepName(ls);
				} else if (element instanceof MSEOccurrence)
				{
					MSEOccurrence event = (MSEOccurrence) element;
					if (event.getMse() != null)
						return event.getMse().getName();
					else
						return "No EOperation";
				}
				return super.getText(element);
			}

			@Override
			public Image getImage(Object element)
			{
				if (element instanceof LogicalStep)
				{
					LogicalStep ls = (LogicalStep) element;
					if (_currentEngine != null && ls == _currentEngine.getSelectedLogicalStep())
					{
						return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_RUNNING_ICON);
					} else
					{
						return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_ICON);
					}
				} else if (element instanceof MSEOccurrence)
				{
					return SharedIcons.getSharedImage(SharedIcons.VISIBLE_EVENT_ICON);
				}
				return null;
			}

			@Override
			public Color getBackground(Object element)
			{
				final Color res;

				if (element instanceof MSEOccurrence)
				{
					ModelSpecificEvent mse = ((MSEOccurrence) element).getMse();
					if (mse != null && _eventsToPresent.contains(EcoreUtil.getURI(mse)))
						res = _representedEventColor;
					else
						res = super.getBackground(element);

				} else
				{
					res = super.getBackground(element);
				}

				return res;
			}

		};
		viewerColumn1.setLabelProvider(_column1LabelProvider);

		TreeColumn column2 = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		column1.setText("Logical Steps");
		TreeViewerColumn viewerColumn2 = new TreeViewerColumn(_viewer, column2);
		_column2LabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element)
			{
				if (element instanceof MSEOccurrence)
				{
					ModelSpecificEvent mse = ((MSEOccurrence) element).getMse();
					if (mse != null)
						return "   " + ViewUtils.eventToString(mse);
					else
						return "    (no MSE)";

				}
				return "";
			}

			@Override
			public Color getBackground(Object element)
			{
				final Color res;

				if (element instanceof MSEOccurrence)
				{
					ModelSpecificEvent mse = ((MSEOccurrence) element).getMse();
					if (mse != null && _eventsToPresent.contains(EcoreUtil.getURI(mse)))
						res = _representedEventColor;
					else
						res = super.getBackground(element);

				} else
				{
					res = super.getBackground(element);
				}

				return res;
			}

		};
		viewerColumn2.setLabelProvider(_column2LabelProvider);
	}

	private void createMenuManager()
	{
		MenuManager menuManager = new MenuManager();
		_menuManager = menuManager;
		_menuManager.setRemoveAllWhenShown(true);
		_menuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr)
			{
				fillContextMenu(mgr);
			}
		});
		Menu menu = _menuManager.createContextMenu(_viewer.getControl());
		_viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(_menuManager, _viewer);
		// make the selection available
		getSite().setSelectionProvider(_viewer);
	}

	private void fillContextMenu(IMenuManager mgr)
	{
		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		//mgr.add(new SwitchDeciderAction());
	}

	private void buildActionToolbar()
	{
		addActionToToolbar(new PauseResumeEngineDeciderAction());
		addActionToToolbar(new StopEngineAction());
		addSeparatorToToolbar();
		addActionToToolbar(new SwitchDeciderAction());
	}
	private void addSeparatorToToolbar()
	{
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBar = actionBars.getToolBarManager();
		toolBar.add(new Separator());		
	}
	
	private void addActionToToolbar(Action action)
	{
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBar = actionBars.getToolBarManager();
		toolBar.add(action);	
	}
	
	@Override
	public void setFocus()
	{
		_viewer.getControl().setFocus();
	}

	private INonDeterministicExecutionEngine _currentEngine;

	@Override
	public void engineSelectionChanged(IExecutionEngine engine)
	{
		if (engine != null && engine instanceof INonDeterministicExecutionEngine && engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Animation))
		{
			_currentEngine = (INonDeterministicExecutionEngine)engine;
			_viewer.setInput(_currentEngine);
			if (_currentEngine != null && !_currentEngine.getRunningStatus().equals(RunStatus.Stopped))
			{
				_viewer.expandAll();
				TreeViewerHelper.resizeColumns(_viewer);
			} else
			{
				_viewer.setInput(null);
			}
			
			// display engine full name in tooltip
			GemocRunningEnginesRegistry registry = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry;
			for (Entry<String, IExecutionEngine> e : registry.getRunningEngines().entrySet())
			{
				if (e.getValue() == engine)
				{
					setTitleToolTip(e.getKey()); // the key is the full name for this engine 
					break;
				}								
			}
			
		}
	}

	@Override
	public void dispose()
	{
		org.gemoc.executionframework.ui.Activator.getDefault().getEventPresenters().remove(this);
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
		try
		{
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run()
				{
					TreeSelection selection = (TreeSelection) _viewer.getSelection();
					if (selection.getPaths().length > 0)
					{
						TreePath path = selection.getPaths()[0];
						_lastSelectedLogicalStep = null;
						if (path.getLastSegment() instanceof LogicalStep)
						{
							_lastSelectedLogicalStep = (LogicalStep) path.getLastSegment();
						} else if (path.getLastSegment() instanceof MSEOccurrence)
						{
							_lastSelectedLogicalStep = (LogicalStep) path.getFirstSegment();
						}
					}
				}
			});
		} catch (Exception e)
		{
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

	public TreeViewer getTreeViewer()
	{
		return _viewer;
	}

	@Override
	public void present(List<URI> events)
	{
		_eventsToPresent = events;
		if (_currentEngine != null)
		{
			ResourceSet rs = _currentEngine.getExecutionContext().getResourceModel().getResourceSet();
			for (URI uri : _eventsToPresent)
			{
				final EObject event = rs.getEObject(uri, false);
				if (event != null)
				{
					_viewer.refresh(event);
				}
			}
		}
	}

}
