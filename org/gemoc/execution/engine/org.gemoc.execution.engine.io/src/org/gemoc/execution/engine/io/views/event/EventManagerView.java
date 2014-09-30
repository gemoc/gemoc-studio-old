package org.gemoc.execution.engine.io.views.event;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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
import org.eclipse.ui.PlatformUI;
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
import org.gemoc.execution.engine.io.views.event.commands.StartWait;
import org.gemoc.execution.engine.io.views.event.commands.StopPlayScenario;
import org.gemoc.execution.engine.io.views.event.commands.StopRecordScenario;
import org.gemoc.execution.engine.io.views.event.commands.StopWait;
import org.gemoc.execution.engine.io.views.event.commands.UndoInit;
import org.gemoc.execution.engine.io.views.event.filters.AllBindedClockFilter;
import org.gemoc.execution.engine.io.views.event.filters.Filter;
import org.gemoc.execution.engine.io.views.event.filters.LeftBindedClockFilter;
import org.gemoc.execution.engine.io.views.event.filters.NoFilter;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.scenario.Fragment;
import org.gemoc.execution.engine.scenario.Future;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;



/**
 * @author lguillem
 * @version 1.6
 */

public class EventManagerView extends ViewPart implements IMotorSelectionListener, Observer {

	public static final String ID = "org.gemoc.execution.engine.io.views.event.EventManagerView";

	private TableViewer _viewer;
	private Composite _parent;
	private ViewContentProvider _contentProvider;
	private EnginesStatusView _enginesStatusView;
	private ObservableBasicExecutionEngine _engine;
	private Map<ObservableBasicExecutionEngine, EngineCache> _cacheMap;
	private EngineCache _cache;
	private WrapperCache _wrapperCache;
	private ScenarioManager _scenarioManager;
	private Fragment fragment;
	private Filter _strategyFilterSelected;
	private CacheStatus _state;
	private CommandState _commandStateService; //the source provider to enable/ disable command handlers.
	private ISelectionChangedListener _decisionViewListener;
	private SelectionListener _menuAndButtonListener;
	private Button _freeButton;
	private Button _forceTrueButton;
	private Button _forceFalseButton;
	private Button _confirmationButton; 
	private Composite _bottomComposite;
	private Composite _informationBar;

	private List<Button> _mseControlButtons;

	private Label _viewStateLabel; 

	/**
	 * Store the 4 possible states of a Clock and a fifth state for advanced control:
	 * <p> - A clock can be forced to tick or not tick in the future;
	 * <br>- A clock not forced can either tick or not tick in the future;
	 * <br>- (new!) A clock can be forced to tick or not during a certain period.
	 */
	public enum ClockStatus 
	{
		NOTFORCED_SET(false, Future.TICK),
		NOTFORCED_NOTSET(false, Future.NO_TICK),
		FORCED_SET(true, Future.TICK),
		FORCED_NOTSET(true, Future.NO_TICK),
		DELAYED_CONTROL(null, null);

		private Boolean isForced;
		private Future future;

		ClockStatus(Boolean isForced, Future future)
		{
			this.isForced = isForced;
			this.future = future;
		}

		public Boolean isForced()
		{
			return isForced;
		}

		public Future getState()
		{
			return future;
		}
	}

	/**
	 * Store a "mapping" of all declared filters with a name
	 */
	public enum Filters
	{
		ALL("All Events", new NoFilter()),
		NO_LEFT_BIND("No Left binded Clocks", new LeftBindedClockFilter()),
		NO_BIND("Free Clocks", new AllBindedClockFilter());

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
		UNDO_INIT(UndoInit.ID),
		START_WAIT(StartWait.ID),
		STOP_WAIT(StopWait.ID);

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
	 * Controls for the source provider flags to control
	 * wether commands handlers are enabled or not.
	 */
	public enum SourceProviderControls 
	{
		WAIT,
		PLAY,
		RECORD,
		INIT,
		RESET;
	}

	public enum CacheStatus
	{
		WAITING("Waiting validation"),
		RUNNING("Running"),
		RECORDING("Recording"),
		PLAYING("Playing"),
		STOPPED("Engine not running");

		private String text;

		CacheStatus(String text)
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
		super();
		_cacheMap = new HashMap<ObservableBasicExecutionEngine, EngineCache>();
		_wrapperCache = null;
		_scenarioManager = null;
		fragment = null;
		_strategyFilterSelected = new NoFilter();
		_commandStateService = null;
		_state = CacheStatus.STOPPED;
		ISourceProviderService sourceProviderService = (ISourceProviderService) PlatformUI.getWorkbench()
				.getService(ISourceProviderService.class);
		_commandStateService = (CommandState) sourceProviderService
				.getSourceProvider(CommandState.ID);
	}

	/* IHM *********************************************************************************************************/
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
		_menuAndButtonListener = createSelectionListener();
		// Create a menu which will show when right click is pressed on a row
		createPopUpMenu();
		// Create a display of the eventview status and create the buttons

		_bottomComposite = new Composite(_parent, SWT.NONE);
		_bottomComposite.setLayout(new StackLayout());
		_bottomComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//		_bottomComposite.setLayout(new GridLayout(1, false));

		createInformationAndButtons();

		//createInformationAndButtons();
		// get the view to listen to motor selection
		startListeningToMotorSelectionChange();

		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		_decisionViewListener = new ISelectionChangedListener() 
		{
			@Override
			public void selectionChanged(SelectionChangedEvent event) 
			{
				updateView();
			}
		};		
		decisionView.addSelectionChangedListener(_decisionViewListener);

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
	 * Create the column(s) of the tableViewer
	 */
	private void createColumn()
	{	
		TableViewerColumn viewerColumn1 = new TableViewerColumn(_viewer, SWT.LEFT);
		TableColumn column1 = viewerColumn1.getColumn();
		column1.setText("Clock");
		column1.setWidth(100);
		column1.setResizable(true);
		column1.setMoveable(true);

		viewerColumn1.setLabelProvider(new ColumnLabelProvider() 
		{
			@Override
			public String getText(Object element) 
			{
				String result = new String();          
				if (element instanceof ClockWrapper)
				{
					Clock c = ((ClockWrapper)element).getClock();
					//result = ViewUtils.eventToString(c.getTickingEvent());
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
					default: break;
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
	 * Create the pop up menu which will be displayed following the right click
	 * operation on a row of the tableViewer.
	 * <br>The user can choose an action to realize on the selected Clock(s).
	 * @param listener
	 */
	private void createPopUpMenu() 
	{
		final Menu menu = new Menu(_parent.getShell(), SWT.POP_UP);
		final Table table = _viewer.getTable();
		table.setMenu(menu);

		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to tick");
		item.setData(ClockStatus.FORCED_SET);
		item.addSelectionListener(_menuAndButtonListener);

		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Force  to not tick");
		item.setData(ClockStatus.FORCED_NOTSET);
		item.addSelectionListener(_menuAndButtonListener);

		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Free the clock(s)");
		item.setData(ClockStatus.NOTFORCED_NOTSET);
		item.addSelectionListener(_menuAndButtonListener);

		new MenuItem(menu, SWT.SEPARATOR);
		item = new MenuItem(menu, SWT.PUSH);
		item.setText("Advanced settings");
		item.setData(ClockStatus.DELAYED_CONTROL);
		item.addSelectionListener(_menuAndButtonListener);
	}

	/**
	 * <p>Here two differents parts are created and added to _bottomComposite. Depending on the current
	 * state, one on these components will be displayed by _bottomComposite<p> 
	 * <p> The two differents parts are :<ul><li>an information panel with three MSE control buttons;</li>
	 * <li>a validation button to resume the execution</li></ul><p>
	 */
	private void createInformationAndButtons()
	{	
		/*************************************  information bar ****************************************/
		// The bar will be placed in the first row of the parent's grid ( which has a single column )
		_informationBar = new Composite(_bottomComposite, SWT.BORDER);
		// The bar will be made of 3 parts :
		_informationBar.setLayout(new GridLayout(3, false));
		_informationBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		_informationBar.setBackground(new Color(_parent.getDisplay(), 255, 255, 255));
		//An icon on the first column
		Label icon = new Label(_informationBar, SWT.IMAGE_PNG);
		icon.setImage(SharedIcons.getSharedImage(SharedIcons.ENGINE_ICON));
		// A label on the second column
		_viewStateLabel = new Label(_informationBar, SWT.NONE);
		// 3 buttons on the third column
		Composite buttonBar = new Composite(_informationBar, SWT.NONE);
		buttonBar.setLayout(new GridLayout(3, false));
		buttonBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// Button which will freed the selected Clocks
		_freeButton = new Button(buttonBar, SWT.PUSH);
		_freeButton.setImage(SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_NOTSET));
		_freeButton.setToolTipText("Free");
		_freeButton.setData(ClockStatus.NOTFORCED_NOTSET);
		_freeButton.setLayoutData(new GridData(SWT.END,SWT.NONE,true, false));
		// Button which will forced to not tick the selected Clocks
		_forceFalseButton = new Button(buttonBar, SWT.PUSH);
		_forceFalseButton.setImage(SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_NOTSET));
		_forceFalseButton.setToolTipText("Force to not tick");
		_forceFalseButton.setData(ClockStatus.FORCED_NOTSET);
		_forceFalseButton.setLayoutData(new GridData(SWT.END,SWT.NONE,false, false));
		// Button which will forced to tick the selected Clocks
		_forceTrueButton = new Button(buttonBar, SWT.PUSH);
		_forceTrueButton.setImage(SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_SET));
		_forceTrueButton.setToolTipText("Force to tick");
		_forceTrueButton.setData(ClockStatus.FORCED_SET);
		_forceTrueButton.setLayoutData(new GridData(SWT.END,SWT.NONE,false, false));

		_mseControlButtons = new ArrayList<Button>();
		_mseControlButtons.add(_freeButton);
		_mseControlButtons.add(_forceFalseButton);
		_mseControlButtons.add(_forceTrueButton);

		for(Button b : _mseControlButtons){
			b.addSelectionListener(_menuAndButtonListener);
		}
		/************************************  validation button ***************************************/

		
		_confirmationButton = new Button(_bottomComposite, SWT.PUSH | SWT.CENTER);
		_confirmationButton.setText("Validate");
		_confirmationButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		_confirmationButton.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
				validate();
			}
			@Override
			public void mouseDown(MouseEvent e) {}
			@Override
			public void mouseDoubleClick(MouseEvent e) {}
		});

		updateInformationAndButtons();
	}

	private SelectionListener createSelectionListener()
	{
		final Table table = _viewer.getTable();

		SelectionListener listener = new SelectionListener() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				// todo
				//				_viewer.getSelection()

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
	/* ***************************************************************************************************************/

	/**
	 * Force or Free a list of clocks
	 * @param clockToForce The clock list to force or free
	 * @param state The future state of the clock(s) to force
	 */
	private void forceClock(List<String> clockToForce, ClockStatus state) 
	{
		switch(state)
		{
		case DELAYED_CONTROL: 
			AdvancedControlDialog dialog = new AdvancedControlDialog(_parent.getShell());
			dialog.create();
			dialog.open();
			break;
		default:
			for(String clockName : clockToForce)
			{
				ClockWrapper wrapper  = _wrapperCache.getClockWrapper(clockName);
				if( ! (wrapper.getState().equals(ClockStatus.NOTFORCED_SET) 
						&& state.equals(ClockStatus.NOTFORCED_NOTSET)))
				{
					wrapper.setState(state);
				}
			}
			_engine.recomputePossibleLogicalSteps();
			updateView();
			break;	
		}
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
				updateCommands();
				if(!_state.equals(CacheStatus.STOPPED))
				{
					_wrapperCache.refreshFutureTickingFreeClocks();
					_contentProvider.setFilterStrategy(_strategyFilterSelected);
				}
				updateComposites();
				_viewer.setInput(_wrapperCache);
				for (TableColumn c : _viewer.getTable().getColumns())
				{
					c.pack();
				}
			}				
		});
	}

	/**
	 * Enable or disable commands handlers in function of the current cache state of a selected engine.
	 */
	private void updateCommands()
	{
		switch(_state)
		{
		case WAITING: //user must select the first forced MSE
			_commandStateService.resetRecordFLAG();
			_commandStateService.resetPlayFLAG();
			_commandStateService.resetInit();
			_commandStateService.startWait();
			break;
		case RUNNING: // engine running without recording or playing a fragment
			_commandStateService.resetPlayFLAG();
			_commandStateService.resetRecordFLAG();
			_commandStateService.stopWait();
			_commandStateService.setInit(); 
			break;
		case PLAYING: // engine running and playing a fragment
			_commandStateService.setInit();
			_commandStateService.resetRecordFLAG();
			_commandStateService.stopWait();
			_commandStateService.setPlayFLAG();
			break;
		case RECORDING: // engine running and recording a fragment
			_commandStateService.setInit();
			_commandStateService.resetPlayFLAG();
			_commandStateService.stopWait();
			_commandStateService.setRecordFLAG();
			break;
		case STOPPED: // engine stopped
			_commandStateService.resetPlayFLAG();
			_commandStateService.resetRecordFLAG();
			_commandStateService.stopWait();
			_commandStateService.resetInit();
			break;
		default: break;	
		}
	}

	/**
	 * Listen the engine change of state.
	 */
	@Override
	public void update(Observable o, Object arg) 
	{
		int engineStep = (int)_engine.getEngineStatus().getNbLogicalStepRun();
		_state = _cache.getState();
		//We check when the engine reach a new step
		if(engineStep > _cache.getCacheStep())
		{
			if(!_state.equals(CacheStatus.STOPPED))
			{
				if(_state.equals(CacheStatus.RECORDING))
				{	
					recordScenario();
				}
				// The View step is set to the engine new step
				_cache.setCacheStep(engineStep);
				if(_state.equals(CacheStatus.PLAYING))
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
		if (engine != null
			&&  engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Debug)) 
		{
			// Cast on engine to access the clockController
			_engine = (ObservableBasicExecutionEngine) engine;
			// if the selected engine is stopped we clean its cache and disable all commands
			if(engine.getEngineStatus().getRunningStatus().equals((RunStatus.Stopped)))
			{
				if(_cacheMap.get(_engine)!=null){
					_state = _cacheMap.get(_engine).getState();

					if(_state.equals(CacheStatus.RECORDING))
					{
						executeCommand(Commands.STOP_RECORD_SCENARIO);
					}
					if(_state.equals(CacheStatus.PLAYING))
					{
						executeCommand(Commands.STOP_PLAY_SCENARIO);
					}
					if(_state.equals(CacheStatus.WAITING))
					{
						executeCommand(Commands.STOP_WAIT);						
					}
					_engine.deleteObserver(this);
					_cacheMap.remove(_engine);
				}
				_state = CacheStatus.STOPPED;
				_wrapperCache = null;
				_scenarioManager = null;
				_cache = null;
				executeCommand(Commands.UNDO_INIT);
			}
			else // else we set the current state according to the selected engine cache state
			{
				_engine.deleteObserver(this);
				_engine.addObserver(this);
				//executeCommand(Commands.DO_INIT);
				if(_cacheMap.get(_engine) == null)
				{
					createcache();
				}
				_cache = _cacheMap.get(_engine);
				_wrapperCache = _cache.getWrapperCache();
				_scenarioManager = _cache.getScenarioManager();
				_state = _cache.getState();
			}
			updateView();
		}
		else
		{
			_viewer.setInput(null);
		}
	}

	private void createcache()
	{
		EngineCache cache = new EngineCache(_engine);
		_cacheMap.put(_engine, cache);
	}


	/**
	 * Call the execute function of a command.
	 * @param command : The name of the command to be called
	 */
	public void executeCommand(Commands command){
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

	/**
	 * Set or reset variables in the SourceProvider to enable or disable command's handlers 
	 * (to make them appear grayed).
	 * The mapping between value and command is done in the plugin.xml
	 * @param event
	 * @param command
	 */
	public void executeService(SourceProviderControls command)
	{
		switch(command)
		{
		case WAIT: _commandStateService.startWait(); break;
		case PLAY: _commandStateService.setPlayFLAG(); break;
		case RECORD: _commandStateService.setRecordFLAG(); break;
		case INIT: _commandStateService.setInit(); break;
		case RESET: _commandStateService.resetInit();	
		break;
		default: break;
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
	public void dispose() 
	{
		super.dispose();
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		decisionView.removeSelectionChangedListener(_decisionViewListener);
		_contentProvider.dispose();
		if(_engine != null) {
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

	public void setScenario(Fragment fragment)
	{
		this.fragment = fragment;
	}

	public Fragment getScenario()
	{
		return fragment;
	}

	public GemocExecutionEngine getEngine() 
	{
		return _engine;
	}

	public CacheStatus getState()
	{
		return _state;
	}

	private ScenarioManager getCurrentScenarioManager()
	{
		return _cache.getScenarioManager();
	}

	public void startRecordScenario() 
	{
		getCurrentScenarioManager().startRecord();
		_state = _cache.getState();
		updateView();

	}

	public void recordScenario()
	{
		_scenarioManager.record();
	}

	public void stopRecordScenario()
	{
		_scenarioManager.stopRecord();
		_state = _cache.getState();
		updateView();	
	}

	/**
	 * If the path is correct, the scenario is loaded.
	 * @param path
	 */
	public void loadScenario(String path)
	{
		if(path != null)
		{
			_scenarioManager.load(path);
			if(fragment != null)
			{
				_state = _cache.getState();
				updateView();
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
		if(fragment != null)
		{
			if(_scenarioManager.getProgress() < fragment.getStepList().size())
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
		_state = _cache.getState();
		_wrapperCache.freeAllClocks();
	}

	public void validate()
	{
		_engine.resume();
		_cache.setState(CacheStatus.RUNNING);
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
	 * switch between composites and update their content
	 */
	private void updateComposites()
	{
		StackLayout layout = (StackLayout)_bottomComposite.getLayout();
		switch(_state)
		{
		case WAITING: 
			layout.topControl = _confirmationButton;
			_bottomComposite.layout();
			break;
		default: 
			layout.topControl = _informationBar;
			_bottomComposite.layout();
			break;
		}

		updateInformationAndButtons();
	}

	private void updateInformationAndButtons()
	{
		if (_viewStateLabel != null)
		{
			enableOrDisableButtons(_mseControlButtons);
			_viewStateLabel.setText(_state.getText()+" ...");			
		}
	}

	private void enableOrDisableButtons(List<Button> controlButtons){
		if (controlButtons != null)
		{
			for(Button b : controlButtons){
				b.setEnabled(_cache!=null);
			}			
		}
	}


}
