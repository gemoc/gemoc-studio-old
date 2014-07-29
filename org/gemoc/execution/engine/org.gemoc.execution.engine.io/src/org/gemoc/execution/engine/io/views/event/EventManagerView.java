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
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
import org.gemoc.execution.engine.io.views.event.commands.DoInit;
import org.gemoc.execution.engine.io.views.event.commands.StopPlayScenario;
import org.gemoc.execution.engine.io.views.event.commands.StopRecordScenario;
import org.gemoc.execution.engine.io.views.event.commands.UndoInit;
import org.gemoc.execution.engine.io.views.event.filters.AllBindedClockFilter;
import org.gemoc.execution.engine.io.views.event.filters.Filter;
import org.gemoc.execution.engine.io.views.event.filters.LeftBindedClockFilter;
import org.gemoc.execution.engine.io.views.event.filters.NoFilter;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
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
	private ViewContentProvider _contentProvider;
	private EnginesStatusView _enginesStatusView;
	private ObservableBasicExecutionEngine _engine;
	private Map<ObservableBasicExecutionEngine, WrapperCache> _cacheEngineWrapper;
	private Map<ObservableBasicExecutionEngine, ScenarioManager> _cacheEngineScenario;
	private WrapperCache _wrapperCache;
	private ScenarioManager _scenarioManager;
	private Scenario scenario;
	private int _progressPlayScenario;
	private boolean _playFlag;
	private boolean _recordFlag;
	private int _eventManagerStep;
	private Filter _strategyFilterSelected;
	private StateView _stateFlagsView;

	private Button _quickFreeClock;
	private Button _quickForceClock_to_1;
	private Button _quickForceClock_to_0;
	
	private Label _viewStateLabel; 

	/**
	 * Store the 4 possible states of a Clock
	 * <p> - A clock can be forced to tick or not tick in the future
	 * <br>- A clock not forced can either tick or not tick in the future
	 */
	public enum ClockStatus 
	{
		NOTFORCED_SET(false, true),
		NOTFORCED_NOTSET(false, false),
		FORCED_SET(true, true),
		FORCED_NOTSET(true, false);

		private boolean isForced;
		private boolean tick;

		ClockStatus(boolean isForced, boolean tick)
		{
			this.isForced = isForced;
			this.tick = tick;
		}

		public boolean isForced()
		{
			return isForced;
		}

		public boolean getTick()
		{
			return tick;
		}
	}

	/**
	 * Store a "mapping" of all declared filters with a name
	 */
	public enum Filters
	{
		ALL("All Clocks", new NoFilter()),
		NO_LEFT_BIND("No Left binded Clocks", new LeftBindedClockFilter()),
		NO_BIND("No binded Clocks", new AllBindedClockFilter());

		private Filter f;
		private String name;

		Filters(String name, Filter f)
		{
			this.name = name;
			this.f = f;
		}

		Filter getFilter()
		{
			return f;
		}

		String getName()
		{
			return name;
		}
	}

	/**
	 * Player and Recorder commands
	 */
	public enum Commands
	{
		STOP_PLAY_SCENARIO(StopPlayScenario.ID),
		STOP_RECORD_SCENARIO(StopRecordScenario.ID),
		DO_INIT(DoInit.ID),
		UNDO_INIT(UndoInit.ID);

		String id;

		Commands(String id)
		{
			this.id = id;
		}

		public String getID()
		{
			return id;
		}
	}

	/**
	 * Coontrols for the source provider flags to control
	 * wether commands handlers are enabled or not.
	 */
	public enum SourceProviderControls 
	{
		PLAY,
		RECORD,
		INIT,
		RESET;
	}
	
	public enum StateView
	{
		WAITING("Waiting"),
		RECORDING("Recording"),
		PLAYING("Playing"),
		STOPPED("No Engine selected");
		
		private String text;
		
		StateView(String text)
		{
			this.text = text;
		}
		
		String getText()
		{
			return text;
		}
		
	}


	/**
	 * The constructor.
	 */
	public EventManagerView() 
	{
		_cacheEngineWrapper = new HashMap<ObservableBasicExecutionEngine, WrapperCache>();
		_cacheEngineScenario = new HashMap<ObservableBasicExecutionEngine, ScenarioManager>();
		_progressPlayScenario = 0;
		_recordFlag = false;
		_playFlag = false;
		_wrapperCache = null;
		scenario = null;
		_strategyFilterSelected = new NoFilter();
		_stateFlagsView = StateView.STOPPED;
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		decisionView.addSelectionListener(new ISelectionChangedListener() 
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event) 
			{
				updateView();
			}
		});
	}


	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) 
	{
		// The main parent will be made of a single column
		GridLayout layout = new GridLayout();
		_parent = parent;	
		_parent.setLayout(layout);
		// In the first row there will be a 2 column gridLayout
		createFilterSelectionBar();
		// In the second row there will be our table with clocks
		createViewer();
		// Create a selection Listener for buttons and pop up menu
		SelectionListener listener = createSelectionListener();
		// Create a menu which will show when right click is pressed on a row
		createPopUpMenu(listener);
		// Create a display of the eventview status and create the buttons
		createInformationAndButtons(listener);
		// get the view to listen to motor selection
		startListeningToMotorSelectionChange();
	}

	/**
	 * Generate a label and a combo to make the user able to change the filter strategy
	 */
	private void createFilterSelectionBar() 
	{
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
		Filters[] strategyFilters = Filters.values();
		Arrays.sort(strategyFilters);
		// We add all existing filters on our combo
		for(Filters myFilters: strategyFilters)
		{
			// The name of the filter will be displayed on the combo cells
			combo.add(myFilters.getName());
			// We map an instance of the Filter with his name
			combo.setData(myFilters.getName(), myFilters.getFilter());
		}
		combo.addSelectionListener(new SelectionListener() 
		{
			public void widgetSelected(SelectionEvent e) 
			{
				// We get the name of the selected strategy
				String filterName = combo.getItem(combo.getSelectionIndex());
				// Thanks to our map we can select the proper instance of Filter
				_strategyFilterSelected = (Filter) combo.getData(filterName);
				// We refresh the view
				updateView();
			}
			//If the combo is clicked but no item selected:
			public void widgetDefaultSelected(SelectionEvent e) 
			{
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




	/**
	 * Create the tableViewer and all its components like its ContentProvider or its
	 * layout structure.
	 */
	private void createViewer()
	{
		// Define the TableViewer
		_contentProvider = new ViewContentProvider();
		_viewer = new TableViewer(_parent, SWT.BORDER| SWT.MULTI);
		_viewer.setContentProvider(_contentProvider);
		createColumn();
		// make lines and header visible
		final Table table = _viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// The table will take all the horizontal and vertical excess space
		GridData grid = new GridData(SWT.FILL, SWT.FILL, true, true);
		_viewer.getControl().setLayoutData(grid);
	}


	/**
	 * Create the pop up menu which will be displayed following the right click
	 * operation on a row of the tableViewer.
	 * <br>The user can choose an action to realise on the selected Clock(s).
	 * @param listener
	 */
	private void createPopUpMenu(SelectionListener listener) 
	{
		final Menu menu = new Menu(_parent.getShell(), SWT.POP_UP);
		final Table table = _viewer.getTable();
		table.setMenu(menu);


		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to tick");
		item.setData(ClockStatus.FORCED_SET);
		item.addSelectionListener(listener);
		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to not tick");
		item.setData(ClockStatus.FORCED_NOTSET);
		item.addSelectionListener(listener);
		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Free the clock(s)");
		item.setData(ClockStatus.NOTFORCED_NOTSET);
		item.addSelectionListener(listener);
	}

	/**
	 * Force or Free a list of clocks
	 * @param clockToForce The clock list to force or free
	 * @param state The future state of the clock(s) to force
	 */
	private void forceClock(List<String> clockToForce, ClockStatus state) 
	{
		for(String clockName : clockToForce)
		{
			//	TODO: if( ! map get(clocktoforce).getState() == NOTFORCED_SET ) pour pas liberer une clock libre qui va tick
			ClockWrapper wrapper  = _wrapperCache.getClockWrapper(clockName);
			wrapper.setState(state);
		}
		updateView();
	}

	/**
	 * Create the column(s) of the tableViewer
	 */
	private void createColumn()
	{		
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
				if (element instanceof ClockWrapper)
				{
					Clock c = ((ClockWrapper)element).getClock();
					result = c.getName();
				}
				return result;
			}

			@Override
			public Image getImage(Object element) 
			{
				if (element instanceof ClockWrapper) 
				{
					ClockStatus state = ((ClockWrapper) element).getState();
					switch(state)
					{
					case NOTFORCED_SET: return SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_SET);
					case FORCED_SET: return SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_SET);
					case NOTFORCED_NOTSET: return SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_NOTSET);
					case FORCED_NOTSET: return SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_NOTSET);
					}
				}
				return null;
			}

			@Override
			public Color getBackground(Object element) 
			{
				if (element instanceof ClockWrapper)
				{
					ClockStatus state = ((ClockWrapper) element).getState();

					switch(state)
					{
					case NOTFORCED_SET: return new Color(_parent.getDisplay(), 212, 255, 141);
					case FORCED_SET: return new Color(_parent.getDisplay(), 255, 217, 142);
					case FORCED_NOTSET: return new Color(_parent.getDisplay(), 255, 217, 142);
					default: break;
					}
				}
				return super.getBackground(element);
			}
		});
	}

	/**
	 * Refresh the input of the ContentProvider with the selected strategy
	 */
	public void updateView()
	{
		Display.getDefault().asyncExec(new Runnable() 
		{
			@Override
			public void run() 
			{
				if(_engine != null)
				{
					_wrapperCache.refreshFutureTickingFreeClocks();
					_contentProvider.setFilterStrategy(_strategyFilterSelected);
				}
				updateButtons();
				updateInformationLabel();
				_viewer.setInput(_wrapperCache);
			}				
		});
	}

	/**
	 * Initialize the cache of wrappers for the current engine.
	 */
	private void createCacheForEngine() 
	{
		ClockConstraintSystem system = extractSystem();
		_wrapperCache = new WrapperCache(_engine);

		if (system != null)
		{
			for(Element e : system.getSubBlock().get(0).getElements())
			{
				if (e instanceof Clock)
				{
					_wrapperCache.add((Clock)e);
				}
			}
		}
		_wrapperCache.configure(_engine, system);
		_cacheEngineWrapper.put(_engine, _wrapperCache);
	}

	/**
	 * Initialize the cache of ScenarioManager for the current engine.
	 */
	private void createCacheForScenario(){
		_scenarioManager = new ScenarioManager();
		_scenarioManager.setCache(_wrapperCache);
		_cacheEngineScenario.put(_engine, _scenarioManager);
	}

	private ClockConstraintSystem extractSystem() 
	{
		ClockConstraintSystem system = null;
		for(Resource r : _engine.getExecutionContext().getResourceModel().getResourceSet().getResources())
		{
			if(r.getContents().get(0) instanceof ClockConstraintSystem)
			{
				system = (ClockConstraintSystem)r.getContents().get(0);
				break;
			}
		}
		return system;
	}

	/**
	 * Listen the engine change of state.
	 */
	@Override
	public void update(Observable o, Object arg) 
	{
		int engineStep = (int)_engine.getEngineStatus().getNbLogicalStepRun();
		//We check when the engine reach a new step
		if(engineStep > _eventManagerStep)
		{
			if(_wrapperCache!= null)
			{
				if(_recordFlag)
				{	
					recordScenario();
				}
				// The View step is set to the engine new step
				_eventManagerStep = engineStep;
				if(_playFlag)
				{
					playScenario();
				}
			}
			updateView();
		}
	}



	/**
	 * Listen the engine selection in the enginesStatusView
	 */
	@Override
	public void motorSelectionChanged(GemocExecutionEngine engine) {
		if (engine != null) 
		{
			// Cast on engine to access the clockController
			_engine = (ObservableBasicExecutionEngine) engine;
			if(engine.getEngineStatus().getRunningStatus().equals((RunStatus.Stopped)))
			{
				if(_recordFlag)
				{
					executeCommand(Commands.STOP_RECORD_SCENARIO);
				}
				if(_playFlag)
				{
					executeCommand(Commands.STOP_PLAY_SCENARIO);
				}
				_stateFlagsView = StateView.STOPPED;
				_engine.deleteObserver(this);
				_engine = null;
				_wrapperCache = null;
				executeCommand(Commands.UNDO_INIT);
			}
			else
			{
				_engine.deleteObserver(this);
				_engine.addObserver(this);
				executeCommand(Commands.DO_INIT);
				if(_cacheEngineWrapper.get(_engine) == null)
				{
					createCacheForEngine();
					createCacheForScenario();
				}
				_wrapperCache = _cacheEngineWrapper.get(_engine);
				if(!(_stateFlagsView.equals(StateView.PLAYING) ||_stateFlagsView.equals(StateView.RECORDING)))
				{
					_stateFlagsView = StateView.WAITING;
				}
			}
			updateView();
		}
	}

	/**
	 * Call the execute function of a command.
	 * @param command : The name of the command to be called
	 */
	private void executeCommand(Commands command){
		IHandlerService handlerService = (IHandlerService) getSite().getService(IHandlerService.class);
		try 
		{
			handlerService.executeCommand(command.getID(), null);
		} 
		catch (Exception ex) 
		{
			throw new RuntimeException(command.getID() + " command not found");
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
		_contentProvider.dispose();
		if(_engine != null)
		{
			_engine.deleteObserver(this);
		}
		_engine = null;
		stopListeningToMotorSelectionChange();
	}


	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() 
	{
		_viewer.getTable().setFocus();
	}

	public void startRecordScenario() 
	{
		_scenarioManager.startRecord();
		_recordFlag = true;
		_stateFlagsView = StateView.RECORDING;
	}

	public void recordScenario()
	{
		_scenarioManager.record();
	}

	public void stopRecordScenario()
	{
		_scenarioManager.stopRecord();
		_recordFlag = false;
		_stateFlagsView = StateView.WAITING;
	}

	/**
	 * If the path is correct, the scenario is loaded and played step by step.
	 * @param path
	 */
	public void loadScenario(String path)
	{
		if(path != null)
		{
			_scenarioManager.load(path);
			if(scenario != null)
			{
				_playFlag = true;
				_stateFlagsView = StateView.PLAYING;
			}
			playScenario();	
		}
	}

	/**
	 * While the scenario possess execution step to be done, playScenario() is called.
	 * When the last step has been played, we stop the replay.
	 */
	public void playScenario()
	{
		if(scenario != null)
		{
			if(_progressPlayScenario < scenario.getStepList().size())
			{
				_scenarioManager.play();
			}
			else
			{
				executeCommand(Commands.STOP_PLAY_SCENARIO);
			}
		}
	}

	public void stopPlayScenario()
	{
		_scenarioManager.stop();
		_playFlag = false;
		_stateFlagsView = StateView.WAITING;
		_wrapperCache.freeAllClocks();
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
	public void executeService(ExecutionEvent event, SourceProviderControls command)
	{
		// Get the source provider service
		ISourceProviderService sourceProviderService = (ISourceProviderService) HandlerUtil
				.getActiveWorkbenchWindow(event).getService(ISourceProviderService.class);
		// now get my service
		CommandState commandStateService = (CommandState) sourceProviderService
				.getSourceProvider(CommandState.ID);
		switch(command)
		{
		case PLAY: commandStateService.togglePlayEnabled(); break;
		case RECORD: commandStateService.toggleRecordEnabled(); break;
		case INIT: commandStateService.setInit(); break;
		case RESET: commandStateService.resetInit(); break;
		default: break;
		}
	}

	public void setScenario(Scenario scenario)
	{
		this.scenario = scenario;
	}

	public Scenario getScenario()
	{
		return scenario;
	}

	public GemocExecutionEngine getEngine() 
	{
		return _engine;
	}

	public int getProgressPlayScenario() 
	{
		return _progressPlayScenario;
	}

	public void resetProgressPlayScenario() 
	{
		_progressPlayScenario = 0;
	}

	public void incProgressPlayScenario() 
	{
		_progressPlayScenario++;
	}

	public void createInformationAndButtons(SelectionListener listener)
	{
		// The bar will be placed in the first row of the parent's grid ( which has a single column )
		Composite informationBar = new Composite(_parent, SWT.BORDER);
		// The bar will be made of 3 parts :
		informationBar.setLayout(new GridLayout(3, false));
		informationBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		informationBar.setBackground(new Color(_parent.getDisplay(), 255, 255, 255));
		//An icon on the first column
		Label icon = new Label(informationBar, SWT.IMAGE_PNG);
		icon.setImage(SharedIcons.getSharedImage(SharedIcons.ENGINE_ICON));
		// A label on the second column
		_viewStateLabel = new Label(informationBar, SWT.NULL);
		// 3 buttons on the third column
		Composite buttonBar = new Composite(informationBar, SWT.NONE);
		buttonBar.setLayout(new GridLayout(3, false));
		buttonBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// Button which will freed the selected Clocks
		_quickFreeClock = new Button(buttonBar, SWT.PUSH);
		_quickFreeClock.setImage(SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_NOTSET));
		_quickFreeClock.setToolTipText("Free");
		_quickFreeClock.setData(ClockStatus.NOTFORCED_NOTSET);
		_quickFreeClock.setLayoutData(new GridData(SWT.END,SWT.NONE,true, false));
		// Button which will forced to not tick the selected Clocks
		_quickForceClock_to_0 = new Button(buttonBar, SWT.PUSH);
		_quickForceClock_to_0.setImage(SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_NOTSET));
		_quickForceClock_to_0.setToolTipText("Force to not tick");
		_quickForceClock_to_0.setData(ClockStatus.FORCED_NOTSET);
		_quickForceClock_to_0.setLayoutData(new GridData(SWT.END,SWT.NONE,false, false));
		// Button which will forced to tick the selected Clocks
		_quickForceClock_to_1 = new Button(buttonBar, SWT.PUSH);
		_quickForceClock_to_1.setImage(SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_SET));
		_quickForceClock_to_1.setToolTipText("Force to tick");
		_quickForceClock_to_1.setData(ClockStatus.FORCED_SET);
		_quickForceClock_to_1.setLayoutData(new GridData(SWT.END,SWT.NONE,false, false));
		
		_quickFreeClock.addSelectionListener(listener);
		_quickForceClock_to_0.addSelectionListener(listener);
		_quickForceClock_to_1.addSelectionListener(listener);
		
		updateButtons();
		updateInformationLabel();
	}

	public void updateButtons()
	{
		_quickFreeClock.setEnabled(_engine!=null);
		_quickForceClock_to_0.setEnabled(_engine!=null);
		_quickForceClock_to_1.setEnabled(_engine!=null);
	}
	
	public void updateInformationLabel()
	{
		_viewStateLabel.setText(_stateFlagsView.getText()+" ...");
	}

	public SelectionListener createSelectionListener()
	{
		final Table table = _viewer.getTable();

		SelectionListener listener = new SelectionListener() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				List<String> clockToForce = new ArrayList<String>();
				ClockStatus state = ClockStatus.NOTFORCED_NOTSET;
				for(TableItem item : table.getSelection())
				{
					clockToForce.add(item.getText());
				}

				if(e.getSource() instanceof MenuItem)
				{
					state = (ClockStatus) ((MenuItem)e.getSource()).getData();
				}
				if(e.getSource() instanceof Button)
				{
					state = (ClockStatus) ((Button)e.getSource()).getData();
				}
				forceClock(clockToForce, state);	
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		return listener;
	}
}
