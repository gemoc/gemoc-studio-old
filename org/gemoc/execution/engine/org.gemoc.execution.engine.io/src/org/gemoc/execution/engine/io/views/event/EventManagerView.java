package org.gemoc.execution.engine.io.views.event;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.services.ISourceProviderService;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.event.commands.CommandState;
import org.gemoc.execution.engine.io.views.event.filters.NoEventFilter;
import org.gemoc.execution.engine.io.views.event.filters.RemoveAllBindingClockFilter;
import org.gemoc.execution.engine.io.views.event.filters.RemoveLeftBindingClockFilter;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.scenario.Scenario;
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
	private int _strategySelectionIndex;
	private int _progressPlayScenario;
	private boolean _playFlag;
	private boolean _recordFlag;
	private EventManagementCache _currentEngineCache;
	private Scenario _scenario;
	
	/**
	 * The constructor.
	 */
	public EventManagerView() {
		_cache = new HashMap<ObservableBasicExecutionEngine, EventManagementCache>();
		_strategySelectionIndex = 0;
		_progressPlayScenario = 0;
		_recordFlag = false;
		_playFlag = false;
		_currentEngineCache = null;
		_scenario = null;
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		decisionView.addSelectionListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				updateView();
			}
		});
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
		// In the first row there will be a 2 column gridLayout
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
				updateView();
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

		_viewer = new TableViewer(_parent, SWT.BORDER| SWT.MULTI);
		_viewer.setContentProvider(new ViewContentProvider());

		createColumn();
		final Menu menu = new Menu(_parent.getShell(), SWT.POP_UP);

		// make lines and header visible
		final Table table = _viewer.getTable();
		//Add the menu to the table
		table.setMenu(menu);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// The table will take all the horizontal and vertical excess space
		GridData grid = new GridData(SWT.FILL, SWT.FILL, true, true);
		_viewer.getControl().setLayoutData(grid);

		SelectionListener listener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> clockToForce = new ArrayList<String>();
				for(TableItem item : table.getSelection())
				{
					clockToForce.add(item.getText());
				}
				int s = ((MenuItem)e.getSource()).getID();
				forceClock(clockToForce, s);	
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		};
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to 1");
		item.setID(1);
		item.addSelectionListener(listener);
		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to 0");
		item.setID(0);
		item.addSelectionListener(listener);
		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Free the clock");
		item.setID(2);
		item.addSelectionListener(listener);
	}

	private void forceClock(List<String> clockToForce, int id) {
		for(String clockName : clockToForce)
		{
			EventManagerClockWrapper wrapper  = _currentEngineCache.getWrapper(clockName);
			switch(id)
			{
			case 0: wrapper.setStateForced(false);break;
			case 1: wrapper.setStateForced(true); break;
			case 2: wrapper.setStateForced(null);break;
			}
		}
		updateView();
	}

	public void createColumn(){		
		TableViewerColumn viewerColumn1 = new TableViewerColumn(_viewer, SWT.LEFT);
		TableColumn column = viewerColumn1.getColumn();
		column.setText("Clock");
		column.setWidth(100);
		column.setResizable(true);
		column.setMoveable(true);

		viewerColumn1.setLabelProvider(new ColumnLabelProvider() 
		{
			@Override
			public String getText(Object element) 
			{
				String result = new String();          
				if (element instanceof EventManagerClockWrapper)// instance of clockwrapper
				{
					Clock c = ((EventManagerClockWrapper)element).getClock();
					result = c.getName();
				}
				return result;
			}

			@Override
			public Image getImage(Object element) {
				if (element instanceof EventManagerClockWrapper) // instance of clockwrapper
				{
					String state = ((EventManagerClockWrapper) element).getBehavior();
					switch(state)
					{
					case "NOTFORCED_CLOCK_SET": return SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_SET);
					case "FORCED_CLOCK_SET": return SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_SET);
					case "NOTFORCED_CLOCK_NOTSET": return SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_NOTSET);
					case "FORCED_CLOCK_NOTSET": return SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_NOTSET);
					case "INDECISION": return SharedIcons.getSharedImage(SharedIcons.INDECISION);
					}
				}
				return null;
			}
		});
	}


	public void updateView(){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				if(_currentEngine != null)
				{
					selectFilter();
				}
				_viewer.setInput(_currentEngineCache);
			}				
		});
	}




	private void selectFilter() {
		switch(_strategySelectionIndex)
		{
		case 0: _currentEngineCache.setFilter(new NoEventFilter()); break;
		case 1: _currentEngineCache.setFilter(new RemoveAllBindingClockFilter()); break;
		case 2: _currentEngineCache.setFilter(new RemoveLeftBindingClockFilter()); break;
		default: break;
		}
	}


	/**
	 * createCacheForEngine
	 * Initialize the cache for the current engine and disable all the free clocks
	 * which has been filtered by the default strategy.
	 */
	private void createCacheForEngine() {
		_currentEngineCache = new EventManagementCache();
		ClockConstraintSystem system = extractSystem();
		if (system != null)
		{
			for(Element e : system.getSubBlock().get(0).getElements())
			{
				if (e instanceof Clock)
				{
					_currentEngineCache.addClock((Clock)e);
				}
			}
		}
		_currentEngineCache.configure(_currentEngine, system);
		_cache.put(_currentEngine, _currentEngineCache);
	}

	private ClockConstraintSystem extractSystem() 
	{
		ClockConstraintSystem system = null;
		for(Resource r : _currentEngine.getExecutionContext().getResourceModel().getResourceSet().getResources())
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
		int step = (int) _currentEngine.getEngineStatus().getNbLogicalStepRun();
		if(_currentEngineCache!= null){
			if(step > _currentEngineCache.getEngineStep())
			{
				if(_recordFlag)
				{	
					_currentEngineCache.addExecutionStep();
				}
				_currentEngineCache.setEngineStep(step);
				if(_playFlag)
				{
					playScenario();
				}
				_currentEngineCache.disableFreeClocks();
			}
		}
		updateView();
	}



	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) 
		{
			// Cast on engine to access the clockController
			_currentEngine = (ObservableBasicExecutionEngine) engine;
			if(engine.getEngineStatus().getRunningStatus().equals((RunStatus.Stopped)))
			{
				if(_recordFlag)
				{
					executeCommand("StopRecordScenario");
				}
				if(_playFlag)
				{
					executeCommand("StopPlayScenario");
				}
				_currentEngine.deleteObserver(this);
				_currentEngine = null;
				_currentEngineCache = null;
				executeCommand("UndoInit");
			}
			else
			{
				_currentEngine.deleteObserver(this);
				_currentEngine.addObserver(this);
				executeCommand("DoInit");
				if(_cache.get(_currentEngine) == null)
				{
					createCacheForEngine();
				}
				_currentEngineCache = _cache.get(_currentEngine);
			}
			updateView();
		}
	}

	/**
	 * executeCommand(String command)
	 * Call execute function of a command.
	 * @param command : the name of the wanted command to be called
	 */
	protected void executeCommand(String command){
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		try 
		{
			handlerService.executeCommand("org.gemoc.execution.engine.io.views.event.commands." + command, null);
		} 
		catch (Exception ex) 
		{
			throw new RuntimeException(command + " command not found");
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
		if(_currentEngine != null)
		{
			_currentEngine.deleteObserver(this);
		}
		_currentEngine = null;
		stopListeningToMotorSelectionChange();
	}


	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		_viewer.getTable().setFocus();
	}

	public void startRecordScenario() {
		_currentEngineCache.createScenario();	
		_recordFlag = true;
	}

	public void stopRecordScenario(){
		_currentEngineCache.resetRessource();
		_recordFlag = false;
	}

	/**
	 * If the path is correct, the scenario is loaded and played step by step.
	 * @param path
	 */
	public void loadScenario(String path){
		if(path != null)
		{
			_currentEngineCache.loadScenario(path);
			if(_scenario != null){
				_playFlag = true;
			}
			playScenario();
			
		}
	}

	/**
	 * While the scenario possess execution step to be done, playScenario() is called.
	 * When the last step has been played, we stop the replay.
	 */
	public void playScenario(){
		if(_scenario != null)
		{
			if(_progressPlayScenario < _scenario.getStepList().size()-1)
			{
				_currentEngineCache.playScenario();
			}
			else
			{
				executeCommand("StopPlayScenario");
			}
		}
	}

	public void informationMsg(final String title, final String msg){
		final EventManagerView eventView = this;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(eventView.getSite().getShell(), title, msg);
			}				
		});
	}

	/**
	 * Set or reset variables in the SourceProvider to enable or disable command's handlers 
	 * (to make them appear grayed).
	 * The mapping is done in the plugin.xml
	 * @param event
	 * @param command
	 */
	public void executeService(ExecutionEvent event, String command){
		// Get the source provider service
		ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
				.getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
		// now get my service
		CommandState commandStateService = (CommandState) sourceProviderService
				.getSourceProvider(CommandState.ID);
		switch(command)
		{
		case "PLAY": commandStateService.togglePlayEnabled(); break;
		case "RECORD": commandStateService.toggleRecordEnabled(); break;
		case "INIT": commandStateService.setInit(); break;
		case "RESET": commandStateService.resetInit(); break;
		}
	}

	public void setScenario(Scenario scenario){
		_scenario = scenario;
	}
	
	public Scenario getScenario(){
		return _scenario;
	}

	public GemocExecutionEngine getEngine() {
		return _currentEngine;
	}

	public EventManagementCache getCurrentEngineCache(){
		return _currentEngineCache;
	}

	public void setPlayFlag(boolean state) {
		_playFlag = state;
	}

	public int getProgressPlayScenario() {
		return _progressPlayScenario;
	}

	public void resetProgressPlayScenario() {
		_progressPlayScenario = 0;
	}

	public void incProgressPlayScenario() {
		_progressPlayScenario++;
	}
}
