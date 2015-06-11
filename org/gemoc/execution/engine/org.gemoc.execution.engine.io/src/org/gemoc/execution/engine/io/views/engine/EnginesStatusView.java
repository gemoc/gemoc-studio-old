package org.gemoc.execution.engine.io.views.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.TreeViewerHelper;
import org.gemoc.execution.engine.core.GemocRunningEnginesRegistry;
import org.gemoc.execution.engine.core.IEngineRegistrationListener;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.actions.PauseResumeEngineDeciderAction;
import org.gemoc.execution.engine.io.views.engine.actions.StopAllEngineAction;
import org.gemoc.execution.engine.io.views.engine.actions.StopEngineAction;
import org.gemoc.execution.engine.io.views.engine.actions.SwitchDeciderAction;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtensionPoint;

public class EnginesStatusView extends ViewPart implements IEngineAddon, IEngineRegistrationListener {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.gemoc.execution.engine.io.views.engine.EnginesStatusView";

	public TreeViewer _viewer;
	private ViewContentProvider _contentProvider;
	
	/**
	 * The constructor.
	 */
	public EnginesStatusView() {
	}

	@Override
	public void dispose() {
//		org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.deleteObserver(this);
		org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.removeEngineRegistrationListener(this);
		super.dispose();
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		_viewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		_contentProvider = new ViewContentProvider();
		_viewer.setContentProvider(_contentProvider);
		ColumnViewerToolTipSupport.enableFor(_viewer);
		_viewer.addSelectionChangedListener(
				new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						fireEngineSelectionChanged();
					}
				});
		
		createColumns();
//		_viewer.setColumnProperties( new String[] {"Status", "Identifier", "Step", "Status"} );
//		_viewer.getTree().setHeaderVisible(true);
		Font mono = JFaceResources.getFont(JFaceResources.TEXT_FONT);
		_viewer.getTree().setFont(mono);
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(_viewer.getControl(), "org.gemoc.execution.engine.io.viewer");
			
		// register for changes in the RunningEngineRegistry
		//org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.addObserver(this);
		
		buildMenu();		

		org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.addEngineRegistrationListener(this);
	}

	private void buildMenu()
	{
		addActionToToolbar(new PauseResumeEngineDeciderAction());
		addActionToToolbar(new StopEngineAction());
		addActionToToolbar(new StopAllEngineAction());
		addSeparatorToToolbar();
		addActionToToolbar(new SwitchDeciderAction());
	}
	
	private void addActionToToolbar(Action action)
	{
		IActionBars actionBars = getViewSite().getActionBars();
//		IMenuManager dropDownMenu = actionBars.getMenuManager();
		IToolBarManager toolBar = actionBars.getToolBarManager();
//		dropDownMenu.add(action);
		toolBar.add(action);	
	}

	private void addSeparatorToToolbar()
	{
		IActionBars actionBars = getViewSite().getActionBars();
//		IMenuManager dropDownMenu = actionBars.getMenuManager();
		IToolBarManager toolBar = actionBars.getToolBarManager();
//		dropDownMenu.add(action);
		toolBar.add(new Separator());		
	}

	/**
	 * used by createPartControl
	 * Creates the columns in the view
	 * @param viewer
	 */
	private void createColumns() 
	{
		createColumn1();
		createColumn2();
		createColumn3();
//		createColumn4();
	}
	
	private void createColumn1() 
	{
		TreeColumn column = new TreeColumn(_viewer.getTree(), SWT.LEFT);
		//column.setText("Status");
		TreeViewerColumn viewerColumn = new TreeViewerColumn(_viewer, column);
		viewerColumn.setLabelProvider(
			new ColumnLabelProvider()
			{
				@Override
				public String getText(Object element) {
					return null;
				}
				
				@Override
				public Image getImage(Object element) 
				{
					Image result = null;
					if (element instanceof IExecutionEngine)
					{
						IExecutionEngine engine = (IExecutionEngine)element;
						switch (engine.getRunningStatus()) {
							case Running:
								result = SharedIcons.getSharedImage(SharedIcons.RUNNING_ENGINE_ICON);							
								break;
	
							case Stopped:
								result = SharedIcons.getSharedImage(SharedIcons.STOPPED_ENGINE_ICON);							
								break;

							case WaitingLogicalStepSelection:
								result = SharedIcons.getSharedImage(SharedIcons.WAITING_ENGINE_ICON);							
								break;

							case Initializing:
								result = SharedIcons.getSharedImage(SharedIcons.ENGINE_ICON);							
								break;

							default:
								break;
						}
					}
					return result;
				}			
			});	
	}
	
	private void createColumn2() 
	{
		TreeColumn column = new TreeColumn(_viewer.getTree(), SWT.LEFT);
//		column.setText("Identifier");
		TreeViewerColumn viewerColumn = new TreeViewerColumn(_viewer, column);
		viewerColumn.setLabelProvider(
			new ColumnLabelProvider()
			{	
				@Override
				public String getText(Object element) 
				{
					String result = "";
					if (element instanceof IExecutionEngine)
					{					
						IExecutionEngine engine = (IExecutionEngine)element;
						result = engine.getExecutionContext().getResourceModel().getURI().segmentsList().get(engine.getExecutionContext().getResourceModel().getURI().segments().length-1);	
					}
					return result;
				}
			
				@Override
				public Image getImage(Object element) 
				{
					Image result = null;
					ImageDescriptor imageDescriptor = null;
					if (element instanceof IExecutionEngine)
					{
						IExecutionEngine engine = (IExecutionEngine)element;
						for (DeciderSpecificationExtension spec : DeciderSpecificationExtensionPoint.getSpecifications())
						{
							if (engine.getExecutionContext().getLogicalStepDecider().getClass().getName().equals(spec.getDeciderClassName()))
							{
								imageDescriptor = ImageDescriptor.createFromURL(spec.getIconURL());
								break;
							}							
						}
					}
					if (imageDescriptor != null)
					{
						result = imageDescriptor.createImage();
					}
					return result;
				}
				
				@Override
				public String getToolTipText(Object element) 
				{
					String result = "";
					if (element instanceof IExecutionEngine)
					{					
						IExecutionEngine engine = (IExecutionEngine)element;
						GemocRunningEnginesRegistry registry = org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry;
						for (Entry<String, IExecutionEngine> e : registry.getRunningEngines().entrySet())
						{
							if (e.getValue() == engine)
							{
								result = e.getKey();
								break;
							}								
						}
						result += "\n";
						switch(engine.getRunningStatus())
						{
							case Initializing : 
								result += "Initializing";
								break;
							case Running:
								result += "Running";
								break;
							case WaitingLogicalStepSelection:
								result += "Waiting LogicalStep Selection";
								break;
							case Stopped:
								result += "Stopped";
								break;
						}	
						result += "\n";
						result += "Step " + engine.getEngineStatus().getNbLogicalStepRun();
					}
					return result;
				}				
			});
	}

	private void createColumn3() 
	{
		TreeColumn column = new TreeColumn(_viewer.getTree(), SWT.LEFT);
//		column.setText("Step");
		TreeViewerColumn viewerColumn = new TreeViewerColumn(_viewer, column);
		viewerColumn.setLabelProvider(
			new ColumnLabelProvider()
			{
				@Override
				public String getText(Object element) 
				{
					String result = "";
					if (element instanceof IExecutionEngine)
					{					
						IExecutionEngine engine = (IExecutionEngine)element;
						result = String.format("%d", engine.getEngineStatus().getNbLogicalStepRun());
					}
					return result;
				}			
			});
	}
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		_viewer.getControl().setFocus();
	}
	
	/**
	 * get the selection
	 * @return the engine selected or null if no engine selected
	 */
	public IExecutionEngine getSelectedEngine()
	{
		try{
			IStructuredSelection selection = (IStructuredSelection) _viewer.getSelection();
			return (IExecutionEngine)selection.getFirstElement();
		} catch(Exception e){
			Activator.getDefault().error(e.getMessage(), e);
		}
		return null;
	}
	
	public void removeStoppedEngines(){
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
		    // we may be triggered by a registry change or by an engine change
		    // if registry changes, then may need to observe the new engine
//			List<String> engineStopped = new ArrayList<String>();
		    for (Entry<String, IExecutionEngine> engineEntry : org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().entrySet())
		    {		    	  
		    	switch(engineEntry.getValue().getRunningStatus())
		    	{
		    		case Stopped:
		    			org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.unregisterEngine(engineEntry.getKey());		    			
		    			break;
		    		default:
		    	}		    	
	    	}
		    _viewer.setInput(org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry);
	      }
		 });
	}

	private ArrayList<IMotorSelectionListener> _motorSelectionListeners = new ArrayList<IMotorSelectionListener>();	

	public void addMotorSelectionListener(IMotorSelectionListener listener) {
		assert(listener != null);
		_motorSelectionListeners.add(listener);
	}
	public void removeMotorSelectionListener(IMotorSelectionListener listener) {
		assert(listener != null);
		_motorSelectionListeners.remove(listener);
	}
	private void fireEngineSelectionChanged() {
		IExecutionEngine engine = getSelectedEngine();
		for(IMotorSelectionListener listener: _motorSelectionListeners) {
			listener.motorSelectionChanged(engine);
		}
	}

	@Override
	public void engineRegistered(final IExecutionEngine engine) 
	{
		Display.getDefault().syncExec(new Runnable() {
		      public void run() {
		  		engine.getExecutionContext().getExecutionPlatform().addEngineAddon(EnginesStatusView.this);
		    	_viewer.setInput(org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry);
		    	TreeViewerHelper.resizeColumns(_viewer);
	    		TreePath treePath = new TreePath(new Object[] {engine});
	    		TreeSelection newSelection = new TreeSelection(treePath);
	    		_viewer.setSelection(newSelection, true);			      }
		 });
	}

	@Override
	public void engineUnregistered(IExecutionEngine engine) 
	{
		engine.getExecutionContext().getExecutionPlatform().removeEngineAddon(this);
	}

	private void updateUserInterface(final IExecutionEngine engine) {
    	_viewer.update(engine, null);
    	TreeViewerHelper.resizeColumns(_viewer);    	
	}

	private void reselectEngine(final IExecutionEngine engine)
	{
		Display.getDefault().syncExec(new Runnable() {
		      public void run() {
		    	  updateUserInterface(engine);
		    	  if (getSelectedEngine() == engine)
		    	  {
		    		  fireEngineSelectionChanged();
		    	  }
		      }
		 });

	}
	
	@Override
	public void engineAboutToStart(IExecutionEngine engine) 
	{
	}

	@Override
	public void engineStarted(IExecutionEngine engine) 
	{
		reselectEngine(engine);
	}

	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine executionEngine, LogicalStep logicalStepToApply) 
	{
	}

	@Override
	public void aboutToExecuteMSEOccurrence(IExecutionEngine executionEngine, MSEOccurrence mseOccurrence) 
	{
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStopped(IExecutionEngine engine) 
	{
		reselectEngine(engine);
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine, Collection<LogicalStep> logicalSteps) 
	{
		reselectEngine(engine);
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine,
			LogicalStep logicalStepExecuted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mseOccurrenceExecuted(IExecutionEngine engine, MSEOccurrence mseOccurrence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engine, RunStatus newStatus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void proposedLogicalStepsChanged(IExecutionEngine engine,
			Collection<LogicalStep> logicalSteps) {
		reselectEngine(engine);
		
	}
}