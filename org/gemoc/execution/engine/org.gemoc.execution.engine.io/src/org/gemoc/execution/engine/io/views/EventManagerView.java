package org.gemoc.execution.engine.io.views;



import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Binding;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;



/**
 * No content provider or label provider used, may be 
 * in the future if its require to properly work.
 */

public class EventManagerView extends ViewPart implements IMotorSelectionListener, Observer {

	public static final String ID = "org.gemoc.execution.engine.io.views.EventManagerView";

	private TableViewer _viewer;
	private Composite _parent;
	private EnginesStatusView _enginesStatusView;
	private ObservableBasicExecutionEngine _currentEngine;
	private Map<ObservableBasicExecutionEngine, EventManagementCache> _cache;

	/**
	 * The constructor.
	 */
	public EventManagerView() {
		_cache = new HashMap<ObservableBasicExecutionEngine, EventManagementCache>();
	}


	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(final Composite parent) {
		_parent = parent;		
		createViewer();
		// get the motor view to listen to motor selection
		startListeningToMotorSelectionChange();
	}

	public void createViewer(){
		// Define the TableViewer
		// First column of its table will be a CHECK BUTTON
		_viewer = new TableViewer(_parent, SWT.BORDER| SWT.CHECK);
		// Initialise the column
		createColumn();
		
		// make lines and header visible
		final Table table = _viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// We enable or disable our clocks with checking or unchecking the button.
		table.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK){
					TableItem item = (TableItem) event.item;
					MessageDialog.openInformation(table.getShell(), "Event", item.getText() +" : Enable.");
					EventManagementCache cache = _cache.get(_currentEngine);
					EventManagerClockWrapper selectedWrapper = cache.getWrapper(item.getText());
					selectedWrapper.set_state(item.getChecked());
				}
			}
		});
	}

	public void createColumn(){		
		// First and unique column
		TableViewerColumn viewerColumn = new TableViewerColumn(_viewer, SWT.NONE);
		TableColumn column = viewerColumn.getColumn();
		column.setText("Event");
		column.setWidth(100);
		column.setResizable(true);
		column.setMoveable(true);
		// LabelProvider to display the name of the clock, attribute text of a CHECK button
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String result = new String();          
				if (element instanceof Clock){
					Clock c = (Clock)element;
					result = c.getName();
				}
				return result;
			}
		});
	}

	//TODO: rafraichir vue qd le moteur est eteint.
	private void updateView() {
		RunStatus engineStatus = _currentEngine.getEngineStatus().getRunningStatus();
		if(engineStatus.equals(RunStatus.Stopped))
		{
			try
			{
				_cache.remove(_currentEngine);
			}
			catch(Exception e)
			{
				System.out.println("Engine already removed from the cache");
			}
			_viewer.getTable().removeAll();
			return;
		}
		if(!_cache.containsKey(_currentEngine))
		{
			createCacheForEngine();
		}
		//Remodeling of the view
		_viewer.getTable().removeAll();
		//Getting the clock list for the given engine
		Collection<EventManagerClockWrapper> listClock = getWrapperList();
		// for each clock we display the name and the button state ( enable or disable) is updated
		for(EventManagerClockWrapper c : listClock){
			TableItem ligne = new TableItem(_viewer.getTable(), SWT.NONE);
			ligne.setText(c.get_clock().getName());
			ligne.setChecked(c.is_state());
		}
	}


	private Collection<EventManagerClockWrapper> getWrapperList() {
		EventManagementCache cache = _cache.get(_currentEngine);
		return cache.getWrappers();
	}


	private void createCacheForEngine() {
		EventManagementCache engineCache = new EventManagementCache();
		ClockConstraintSystem system = extractSystem();
		if (system != null)
		{
			for(Element e : system.getSubBlock().get(0).getElements())
			{
				if (e instanceof Clock)
				{
					engineCache.addClock((Clock)e);
				}
				
			}
			EventFilter selectedFilter = new EventFilter();
			
			for(Relation r : system.getSubBlock().get(0).getRelations())
			{
				if(r instanceof Relation)
				{
					selectedFilter.applyFilter(r, engineCache);
				}
			}
		}
		engineCache.configure(_currentEngine, system);
		//engineCache.disableAllEvents();
		_cache.put(_currentEngine, engineCache);
	}


	private void filtreEvent(Relation relation, EventManagementCache engineCache) {
			List<Binding> bindings = relation.getBindings();
			Binding leftBinding = bindings.get(0);
			String clockNameLeftBinding = leftBinding.getBindable().getName();
			engineCache.removeFromClockCache(clockNameLeftBinding);
	}


	private ClockConstraintSystem extractSystem() 
	{
		ClockConstraintSystem system = null;
		for(Resource r : _currentEngine.getModelUnderExecutionResource().getResourceSet().getResources())
		{
			if(r.getContents().get(0) instanceof ClockConstraintSystem)
			{
				system = (ClockConstraintSystem)r.getContents().get(0);
				break;
			}
		}
		return system;
	}

	@Override
	public void update(Observable o, Object arg) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				updateView();
			}
		});
		
	}



	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) {
			// Cast on engine to access the clockcontroller
			_currentEngine = (ObservableBasicExecutionEngine) engine;
			_currentEngine.deleteObserver(this);
			_currentEngine.addObserver(this);
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					updateView();
				}				
			});
		}
	}

	private void startListeningToMotorSelectionChange() {
		_enginesStatusView = ViewHelper.retrieveView(EnginesStatusView.ID);
		if (_enginesStatusView != null) {
			_enginesStatusView.addMotorSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView != null) {
			_enginesStatusView.removeMotorSelectionListener(this);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		_currentEngine = null;
		stopListeningToMotorSelectionChange();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		_viewer.getTable().setFocus();
	}



}