package org.gemoc.execution.engine.io.views.engine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.ViewUtils;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.trace.LogicalStep;

public class EnginesStatusView extends ViewPart implements Observer {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.gemoc.execution.engine.io.views.engine.EnginesStatusView";

	public TreeViewer viewer;
	private ViewContentProvider contentProvider;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class TreeObject implements IAdaptable {
		private String name;
		private TreeParent parent;
		
		private Object wrappedObject;
		
		public Object getWrappedObject() {
			return wrappedObject;
		}
		public void setWrappedObject(Object wrappedObject) {
			this.wrappedObject = wrappedObject;
		}
		public TreeObject(String name) {
			this.name = name;
		}
		public TreeObject(String name, Object wrappedObject) {
			this.name = name;
			this.wrappedObject = wrappedObject;
		}
		public String getName() {
			return name;
		}
		public void setParent(TreeParent parent) {
			this.parent = parent;
		}
		public TreeParent getParent() {
			return parent;
		}
		public String toString() {
			return getName();
		}
		public Object getAdapter(Class key) {
			return null;
		}
	}
	
	class TreeParent extends TreeObject {
		private ArrayList children;
		public TreeParent(String name) {
			super(name);
			children = new ArrayList();
		}
		public TreeParent(String name, Object wrappedObject) {
			super(name, wrappedObject);
			children = new ArrayList();
		}
		public void addChild(TreeObject child) {
			children.add(child);
			child.setParent(this);
		}
		public void removeChild(TreeObject child) {
			children.remove(child);
			child.setParent(null);
		}
		public void removeAllChildren() {
			children.clear();
		}
		public TreeObject [] getChildren() {
			return (TreeObject [])children.toArray(new TreeObject[children.size()]);
		}
		public List<TreeObject> getChildrenList() {
			return children;
		}
		public boolean hasChildren() {
			return children.size()>0;
		}
	}

	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		private List<TreeParent> roots;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (roots==null) initialize();
				return roots.toArray();
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}

		private void initialize() {
			roots = new ArrayList<TreeParent>();		
			refresh();
		}
		
		public void refresh(){
			
			// remove engines that are no more registered
			List<TreeParent> removedEngines = new ArrayList<TreeParent>();
			for (TreeParent root : roots) {
				GemocExecutionEngine engine = (GemocExecutionEngine) root.getWrappedObject();
				if(!org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values().contains(engine)){
					removedEngines.add(root);
				}
			}
			for (TreeParent treeParent : removedEngines) {
				roots.remove(treeParent);
			}
			
			// currently tracked engines
			Set<GemocExecutionEngine> currentlyListedEngines = new HashSet<GemocExecutionEngine>();
			for (TreeParent root : roots) {
				currentlyListedEngines.add((GemocExecutionEngine) root.getWrappedObject());
			}
			// add any new engine
			for( Entry<String, GemocExecutionEngine>  entry : org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().entrySet()){
				if(!currentlyListedEngines.contains(entry.getValue())){
					TreeParent engineTreeObject = new TreeParent(entry.getKey(), entry.getValue());
					roots.add(engineTreeObject);
				}
			}
			// For all current engines, refresh contents
			for( TreeParent  root : roots){
				GemocExecutionEngine engine = (GemocExecutionEngine) root.getWrappedObject();
				// add current possible logical steps
				// TODO for each logical step , add internal events
				switch(engine.getEngineStatus().getRunningStatus()){
				case Running:
				case WaitingLogicalStepSelection:
					List<LogicalStep> currentLogicalStepChoice = engine.getEngineStatus().getCurrentLogicalStepChoice();
					// remove unused previous choice and mark reused ones
					TreeObject[] previousChild = root.getChildren();
					Set<LogicalStep> currentlyListedLogicalStep = new HashSet<LogicalStep>();
					for (int i = 0; i < previousChild.length; i++) {
						if(!currentLogicalStepChoice.contains(previousChild[i].wrappedObject)){
							root.removeChild(previousChild[i]);
						}
						else{
							currentlyListedLogicalStep.add((LogicalStep) previousChild[i].wrappedObject);
						}
					}
					// current Logical Step
					for(LogicalStep logicalStep : currentLogicalStepChoice){
						if(!currentlyListedLogicalStep.contains(logicalStep)){
							TreeParent logicalStepTreeObject = new TreeParent(LogicalStepHelper.getLogicalStepName(logicalStep), logicalStep);
							root.addChild(logicalStepTreeObject);
							
							// Add internal events
							for(Event event : LogicalStepHelper.getTickedEvents(logicalStep)){
								TreeObject to = new TreeObject(event.getName(), event);
								logicalStepTreeObject.addChild(to);
								// expand the added Logical step  (previously closed one, will remain closed)
								//EnginesStatusView.this.viewer.getTree().indexOf(to);
								EnginesStatusView.this.viewer.expandToLevel(to, TreeViewer.ALL_LEVELS); // doesn't work ?								
							}
							EnginesStatusView.this.viewer.expandToLevel(logicalStepTreeObject, 3);// doesn't work ?
							// temp workaround for demo
							EnginesStatusView.this.viewer.expandAll();
							
						}
					}
					
					break;
				default:
					// remove any previous logical step
					root.removeAllChildren();
				}
				
			}
			
		}
	}
	
	
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		
		@Override
		public Image getColumnImage(Object obj, int columnIndex) {
			TreeObject treeObject = (TreeObject) obj;
			switch(columnIndex){
			case 0:
				// select image for LogicalStep, engine and internal step
				if(treeObject.wrappedObject != null ){
					if(treeObject.wrappedObject instanceof GemocExecutionEngine){
				
						// TODO change the image according to the running status, running, waiting logicalStep selection, paused (debug), stopped 
						return SharedIcons.getSharedImage(SharedIcons.ENGINE_ICON);
					}
					else if(treeObject.wrappedObject instanceof LogicalStep){
						if(treeObject.wrappedObject == ((GemocExecutionEngine)treeObject.getParent().getWrappedObject()).getEngineStatus().getChosenLogicalStep()){
							return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_RUNNING_ICON);
						}
						else{
							return SharedIcons.getSharedImage(SharedIcons.LOGICALSTEP_ICON);
						}
					}
					else if(treeObject.wrappedObject instanceof Event){
						return SharedIcons.getSharedImage(SharedIcons.VISIBLE_EVENT_ICON);
					}
					else return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
				}
			default:
				return null;
			}
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			TreeObject treeObject = (TreeObject) element;
			switch(columnIndex){
			case 0:
				return treeObject.getName();
			case 1:
				if(treeObject.wrappedObject != null){
					if(treeObject.wrappedObject instanceof GemocExecutionEngine){
				
						return ""+((GemocExecutionEngine)treeObject.wrappedObject).getEngineStatus().getNbLogicalStepRun();
					}
					//else if(treeObject.wrappedObject instanceof LogicalStep){
					//	return "("+((LogicalStep)treeObject.wrappedObject).getStepNumber()+")";
					//} 
					else return "";
				} else	return "";
			case 2:
				if(treeObject.wrappedObject != null && treeObject.wrappedObject instanceof GemocExecutionEngine){
					switch(((GemocExecutionEngine)treeObject.wrappedObject).getEngineStatus().getRunningStatus()){
						case Initializing : 
							return "Initializing";
					case Running:
						return "Running";
					case WaitingLogicalStepSelection:
						return "Waiting LogicalStep Selection";
					case Stopped:
						return "Stopped";
					default:
						return "";
					}					
				}
				if(treeObject.wrappedObject != null && treeObject.wrappedObject instanceof Event){
					Event event = (Event)treeObject.wrappedObject;
					return ViewUtils.eventToString(event);
				}
				return "";
			default:
				return "";
			}
		}
		
		
	}
	class NameSorter extends ViewerSorter {
	}

	
	
	/**
	 * The constructor.
	 */
	public EnginesStatusView() {
	}

	private Object _lastSelection;
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		//drillDownAdapter = new DrillDownAdapter(viewer);
		contentProvider = new ViewContentProvider();
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(new ViewLabelProvider());
		//viewer.setSorter(new NameSorter());
		viewer.addSelectionChangedListener(
				new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						if (event.getSelection() instanceof TreeSelection) {
							TreeSelection selection = (TreeSelection)event.getSelection();
							if (selection.getPaths().length > 0)
								_lastSelection = selection.getPaths()[0].getFirstSegment();
						}
						fireEngineSelectionChanged();
					}
				});
		
		createColumns(viewer);
		viewer.setColumnProperties( new String[] {"Identifier", "Step", "Status"} );
		viewer.getTree().setHeaderVisible(true);
		Font mono = JFaceResources.getFont(JFaceResources.TEXT_FONT);
		viewer.getTree().setFont(mono);
		viewer.setInput(getViewSite());
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.gemoc.execution.engine.io.viewer");
		hookContextMenu();
			
		// register for changes in the RunningEngineRegistry
		org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.addObserver(this);
	}

	/**
	 * used by createPartControl
	 * Creates the columns in the view
	 * @param viewer
	 */
	private void createColumns(TreeViewer viewer) {
		TreeColumn column1 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column1.setText("Identifier");
		column1.setWidth(400);
		column1.setResizable(true);
		//column1.addSelectionListener( new PackageNsURIColumnSelectionListener(viewer) );
		
		/*TreeColumn column2 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column2.setText("EPackage name");
		column2.setWidth(120);
		column2.setResizable(true);*/
		//column2.addSelectionListener( new PackageNameColumnSelectionListener(viewer) );
		
		TreeColumn column3 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column3.setText("Step");
		column3.setWidth(50);
		column3.setResizable(true);
		
		TreeColumn column4 = new TreeColumn(viewer.getTree(), SWT.LEFT);
		column4.setText("Details");
		column4.setWidth(350);
		column4.setResizable(true);
	}
	
	public MenuManager menuMgr;
	private void hookContextMenu() 
	{
	    //MenuManager menuManager = new MenuManager();
	    MenuManager menuManager = new MenuManager();
	    menuMgr = menuManager;
	    Menu menu = menuManager.createContextMenu(viewer.getControl());
	    viewer.getControl().setMenu(menu);
	    getSite().registerContextMenu(menuManager, viewer);
	    // make the selection available
	    getSite().setSelectionProvider(viewer);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	/**
	 * get the selection
	 * @return the engine selected or null if no engine selected
	 */
	public GemocExecutionEngine getSelectedEngine(){
		try{
			IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
			Iterator<?> iter = selection.iterator();
			while (iter.hasNext()){
				TreeObject treeObject = (TreeObject) iter.next();
				if(treeObject.wrappedObject instanceof GemocExecutionEngine){
					return (GemocExecutionEngine) treeObject.wrappedObject;
				}
				// try to retrieve the engine from internal leaves  (logical step, ...)
				if(treeObject.wrappedObject instanceof LogicalStep){
					return (GemocExecutionEngine) treeObject.getParent().getWrappedObject();
				}
				if(treeObject.wrappedObject instanceof Event){
					return (GemocExecutionEngine) treeObject.getParent().getParent().getWrappedObject();
				}
			}
		} catch(Exception e){
			Activator.getDefault().error(e.getMessage(), e);
		}
		return null;
	}
	
	private LogicalStep lastSelectedLogicalStep;

	/**
	 * get the selection
	 * @return the LogicalStep selected or null if no LogicalStep selected
	 */
	public LogicalStep getSelectedLogicalStep(){
		try{
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
					Iterator<?> iter = selection.iterator();
					while (iter.hasNext()){
						TreeObject treeObject = (TreeObject) iter.next();
						lastSelectedLogicalStep = null;
						if(treeObject.wrappedObject instanceof LogicalStep){
							lastSelectedLogicalStep =  (LogicalStep) treeObject.wrappedObject;
						}
						// try to retrieve the engine from internal leaves  (event occurrences)
						if(treeObject.wrappedObject instanceof Event){
							lastSelectedLogicalStep= (LogicalStep) treeObject.getParent().getWrappedObject();
						}
						
					}
				}
			});
			return lastSelectedLogicalStep;
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
			List<String> engineStopped = new ArrayList<String>();
		    for( Entry<String, GemocExecutionEngine> engineEntry :org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().entrySet()){
		    	  
		    	switch(engineEntry.getValue().getEngineStatus().getRunningStatus()){
		    	case Stopped:
		    		engineStopped.add(engineEntry.getKey());
		    		break;
		    	default:
		    	}
		    	
	    	}
	    	for(String engine : engineStopped){
	    		org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().remove(engine);
	    	}
	    	update(null, null);
	    	  
	      }
		 });
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Display.getDefault().asyncExec(new Runnable() {
		      public void run() {
		    	  // we may be triggered by a registry change or by an engine change
		    	  // if registry changes, then may need to observe the new engine
		    	  for( GemocExecutionEngine engine :org.gemoc.execution.engine.Activator.getDefault().gemocRunningEngineRegistry.getRunningEngines().values()){
		    		  ObservableBasicExecutionEngine observable = (ObservableBasicExecutionEngine) engine;
		    		  observable.addObserver(EnginesStatusView.this);
		    		  //EnginesStatusView.this
		    	  }
		    	  
		    	  contentProvider.refresh();

		    	  //ISelection previousSelection = EnginesStatusView.this.viewer.getSelection();
		    	  EnginesStatusView.this.viewer.refresh();
		    	  if (_lastSelection != null) {
		    		  TreePath treePath = new TreePath(new Object[] {_lastSelection});
		    		  TreeSelection newSelection = new TreeSelection(treePath);
			    	  EnginesStatusView.this.viewer.setSelection(newSelection, true);
		    	  }
		    	  //EnginesStatusView.this.viewer.setSelection(previousSelection, true);
		    	  EnginesStatusView.this.viewer.expandAll();
		    	  //EnginesStatusView.this.viewer.expandAll();
		    	  
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
		GemocExecutionEngine engine = getSelectedEngine();
		for(IMotorSelectionListener listener: _motorSelectionListeners) {
			listener.motorSelectionChanged(engine);
		}
	}

	
}