package org.gemoc.execution.engine.io.views.event;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;



/**
 * @author lguillem
 */

public class EventManagerView extends ViewPart implements IMotorSelectionListener, Observer {

	public static final String ID = "org.gemoc.execution.engine.io.views.event.EventManagerView";
									 
	private TableViewer _viewer;
	private Composite _parent;
	private EnginesStatusView _enginesStatusView;
	private ObservableBasicExecutionEngine _currentEngine;
	private Map<ObservableBasicExecutionEngine, EventManagementCache> _cache;
	private Collection<EventManagerClockWrapper> _displayedClock;
	private int _strategySelectionIndex;

	/**
	 * The constructor.
	 */
	public EventManagerView() {
		_cache = new HashMap<ObservableBasicExecutionEngine, EventManagementCache>();
		_displayedClock = new ArrayList<EventManagerClockWrapper>();
		_strategySelectionIndex = 0;
	}


	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		// The main parent will be made of a single column
		GridLayout layout = new GridLayout();
		_parent = parent;	
		_parent.setLayout(layout);
		// In the first row there will be a 2 column gridlayout
		createFilterSelectionBar();
		// In the second column there will be our table with clocks
		createViewer();
		// get the view to listen to motor selection
		startListeningToMotorSelectionChange();
	}

	/**
	 * createFilterSelectionBar
	 * Generate a label and a combo to make the user able to change the filter strategy
	 */
	private void createFilterSelectionBar() {
		// The bar will be placed in the first row of the parent's grid ( which has a single column )
		Composite filterSelectionBar = new Composite(_parent, SWT.BORDER);
		// The bar will be made of 2 parts :
		filterSelectionBar.setLayout(new GridLayout(2, false));
		filterSelectionBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// A label on the first column
		(new Label(filterSelectionBar, SWT.NULL)).setText("Select an event filter: ");
		// A read only combo on the second
		final Combo combo = new Combo(filterSelectionBar, SWT.NULL | SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		String[] filters = new String[]{"All clocks","Free clocks","No left binded clocks"};
		Arrays.sort(filters);
		for(int i=0; i<filters.length; i++)
			combo.add(filters[i]);
		combo.addSelectionListener(new SelectionListener() 
		{
			public void widgetSelected(SelectionEvent e) {
				// Strategy filter selection
				_strategySelectionIndex = combo.getSelectionIndex();
				if(_currentEngine != null)
				{
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							updateView();
						}				
					});
				}
			}
			//If the combo is clicked but no item selected:
			public void widgetDefaultSelected(SelectionEvent e) {
				String text = combo.getText();
				if(combo.indexOf(text) < 0) { // Not in the list yet 
					combo.add(text);
					// Re-sort
					String[] items = combo.getItems();
					Arrays.sort(items);
					combo.setItems(items);
				}
			}
		});

	}


	public void createViewer(){
		// Define the TableViewer
		// First column of its table will be a CHECK BUTTON
		_viewer = new TableViewer(_parent, SWT.BORDER| SWT.CHECK);
		// Initialise an unique column
		createColumn();
		// make lines and header visible
		final Table table = _viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// The table will take all the horizontal and vertical excess space
		GridData grid = new GridData(SWT.FILL, SWT.FILL, true, true);
		_viewer.getControl().setLayoutData(grid);
		// We enable or disable our clocks with checking or unchecking the button.
		table.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK){
					TableItem item = (TableItem) event.item;
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
		column.setText("Clock");
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
		if(_currentEngine != null)
		{
			applyStrategy();
		}
		//Remodeling of the view
		_viewer.getTable().removeAll();
		//Getting the clock list for the given engine
		_displayedClock = getWrapperList();
		// for each clock we display the name and the button state ( enable or disable) is updated
		for(EventManagerClockWrapper c : _displayedClock){
			TableItem ligne = new TableItem(_viewer.getTable(), SWT.NONE);
			ligne.setText(c.get_clock().getName());
			ligne.setChecked(c.is_state());
		}

	}


	private void applyStrategy() {
		EventManagementCache engineCache = _cache.get(_currentEngine);
		switch(_strategySelectionIndex)
		{
		case 0: engineCache.setFilter(new NoEventFilter()); break;
		case 1: engineCache.setFilter(new RemoveAllBindingClockFilter()); break;
		case 2: engineCache.setFilter(new RemoveLeftBindingClockFilter()); break;
		default: break;
		}
	}

	/**
	 * getWrapperList
	 * @return The Filtered Clock Wrappers for the selected strategy
	 */
	private Collection<EventManagerClockWrapper> getWrapperList() {
		EventManagementCache cache = _cache.get(_currentEngine);
		return cache.getWrappers();
	}

	/**
	 * createCacheForEngine
	 * Initialise the cache for the current engine and disable all the free clocks
	 * which has been filtered by the default strategy.
	 */
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
		}
		engineCache.configure(_currentEngine, system);
		engineCache.disableClocks(_displayedClock);
		_cache.put(_currentEngine, engineCache);
		_displayedClock = getWrapperList();
		engineCache.disableClocks(_displayedClock);
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
			public void run() 
			{
				updateView();
			}
		});
	}



	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) 
		{
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
		if (_enginesStatusView != null) 
		{
			_enginesStatusView.addMotorSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		if (_enginesStatusView != null) 
		{
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
