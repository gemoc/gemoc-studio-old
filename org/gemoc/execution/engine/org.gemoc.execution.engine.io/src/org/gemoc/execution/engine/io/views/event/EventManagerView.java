package org.gemoc.execution.engine.io.views.event;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
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
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.IEvenPresenter;
import org.gemoc.execution.engine.io.SharedIcons;
import org.gemoc.execution.engine.io.views.IMotorSelectionListener;
import org.gemoc.execution.engine.io.views.engine.EnginesStatusView;
import org.gemoc.execution.engine.io.views.event.actions.PlayScenarioAction;
import org.gemoc.execution.engine.io.views.event.actions.RecordScenarioAction;
import org.gemoc.execution.engine.io.views.event.actions.StopAction;
import org.gemoc.execution.engine.io.views.event.filters.Filter;
import org.gemoc.execution.engine.io.views.event.filters.Filters;
import org.gemoc.execution.engine.io.views.event.filters.NoFilter;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioException;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManagerState;
import org.gemoc.execution.engine.io.views.step.LogicalStepsView;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.EngineStatus.RunStatus;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.obeo.dsl.debug.ide.DSLBreakpoint;
import fr.obeo.dsl.debug.ide.ui.provider.DSLLabelDecorator;
import fr.obeo.dsl.debug.ide.ui.provider.DecoratingColumLabelProvider;

/**
 * @author lguillem
 * @version 1.6
 */
public class EventManagerView extends ViewPart implements IMotorSelectionListener, IEngineAddon, IEvenPresenter {

	private static final class GemocLabelDecorator extends DSLLabelDecorator {

		public GemocLabelDecorator() {
			super(LogicalStepsView.MODEL_ID);
		}
		
		private Map<ModelSpecificEvent, ModelSpecificEventWrapper> mapping = new HashMap<ModelSpecificEvent, ModelSpecificEventWrapper>();			
		
		@Override
		public Image decorateImage(Image image, Object element) {
			final Image res;
			
			if (element instanceof ModelSpecificEventWrapper) {
				final ModelSpecificEvent solverEvent = ((ModelSpecificEventWrapper) element).getMSE();
				mapping.put(solverEvent, (ModelSpecificEventWrapper) element);
				res = super.decorateImage(image, solverEvent);
			} else {
				res = super.decorateImage(image, element);
			}

			return res;
		}
		
		@Override
		public String decorateText(String text, Object element) {
			final String res;
			
			if (element instanceof ModelSpecificEventWrapper) {
				final ModelSpecificEvent solverEvent = ((ModelSpecificEventWrapper) element).getMSE();
				mapping.put(solverEvent, (ModelSpecificEventWrapper) element);
				res = super.decorateText(text, solverEvent);
			} else {
				res = super.decorateText(text, element);
			}

			return res;
		}
		
		protected Object getElement(ResourceSet rs, DSLBreakpoint breakpoint) {
			final Object res;
			
			EObject instruction = rs.getEObject(breakpoint.getURI(), false);
			if (instruction instanceof ModelSpecificEvent) {
				res = mapping.get(instruction);
			} else {
				res = super.getElement(rs, breakpoint);
			}
			
			return res;
		};
		
		@Override
		public void dispose() {
			mapping.clear();
			super.dispose();
		}
	}
	
	public static final String ID = "org.gemoc.execution.engine.io.views.event.EventManagerView";

	private Color notForcedSetColor;
	private Color forcedSetColor;
	private Color forcedNotSetColor;
	private Color representedEventColor;
	private TableViewer _viewer;
	private ViewContentProvider _contentProvider;
	private ExecutionEngine _currentSelectedEngine;
	private Map<ExecutionEngine, ModelSpecificEventContext> _mseContextMap = new HashMap<ExecutionEngine, ModelSpecificEventContext>();
	private Filter _strategyFilterSelected;
	private ISelectionChangedListener _decisionViewListener;
	private SelectionListener _menuAndButtonListener;
	private Composite _bottomComposite;
	private Composite _informationBar;
	private MenuManager _menuManager;
	private ColumnLabelProvider _column1LabelProvider;
	private GemocLabelDecorator _decorator;
	private List<URI> _eventsToPresent = new ArrayList<URI>(); 

	private List<Button> _mseControlButtons;

	private Label _viewStateLabel; 

	/**
	 * The constructor.
	 */
	public EventManagerView() 
	{
		super();
		_strategyFilterSelected = new NoFilter();
	}

	private ModelSpecificEventContext getMSEContext()
	{
		if (_currentSelectedEngine == null)
		{
			return null;
		}
		return _mseContextMap.get(_currentSelectedEngine);
	}
	
	/* IHM *********************************************************************************************************/
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) 
	{
		notForcedSetColor = new Color(parent.getDisplay(), 212, 255, 141);
		forcedSetColor = new Color(parent.getDisplay(), 212, 255, 141);
		forcedNotSetColor = new Color(parent.getDisplay(), 212, 255, 141);
		representedEventColor = new Color(parent.getDisplay(), 255, 235, 174);
		// The main parent will be made of a single column
		GridLayout layout = new GridLayout();
		parent.setLayout(layout);
		// In the first row there will be a 2 column gridLayout
		createFilterSelectionBar(parent);
		// In the second row there will be our table with clocks
		createViewer(parent);
		// Create a selection Listener for buttons and pop up menu
		_menuAndButtonListener = createSelectionListener();
		// Create a menu which will show when right click is pressed on a row
//		createPopUpMenu(parent);
		// Create a display of the eventview status and create the buttons

		_bottomComposite = new Composite(parent, SWT.NONE);
		_bottomComposite.setLayout(new StackLayout());
		_bottomComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//		_bottomComposite.setLayout(new GridLayout(1, false));

		createInformationAndButtons(parent);

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
		updateView();
		createMenuManager();
		Activator.getDefault().getEventPresenters().add(this);
	}

	/**
	 * Generate a label and a combo to make the user able to change the filter strategy
	 */
	private void createFilterSelectionBar(Composite parent) 
	{
		// The bar will be placed in the first row of the parent's grid ( which has a single column )
		Composite filterSelectionBar = new Composite(parent, SWT.BORDER);

		buildMenu();
		
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

	private PlayScenarioAction _playAction = new PlayScenarioAction();
	private RecordScenarioAction _recordAction = new RecordScenarioAction();
	private StopAction _stopAction = new StopAction();
	
	private void buildMenu()
	{
		updateActionsVisibility();
		addActionToToolbar(_playAction);
		addActionToToolbar(_recordAction);
		addActionToToolbar(_stopAction);
	}

	private void updateActionsVisibility() {
		_stopAction.setEnabled(false);
		_recordAction.setEnabled(false);
		_playAction.setEnabled(false);
		if (_currentSelectedEngine != null
			&& !isEngineStopped())
		{
			ScenarioManager sm = getScenarioManager();
			if (sm.getState().equals(ScenarioManagerState.Recording))
			{
				_stopAction.setEnabled(true);
			} 
			else if (sm.getState().equals(ScenarioManagerState.Playing))
			{
				_stopAction.setEnabled(true);
			}
			else
			{
				_recordAction.setEnabled(true);
				_playAction.setEnabled(true);					
			}
		}
	}
	
	private void addActionToToolbar(Action action)
	{
		IActionBars actionBars = getViewSite().getActionBars();
		IToolBarManager toolBar = actionBars.getToolBarManager();
		toolBar.add(action);	
	}
	
	/**
	 * Create the tableViewer and all its components like its ContentProvider or its
	 * layout structure.
	 */
	private void createViewer(Composite parent)
	{
		// Define the TableViewer
		_contentProvider = new ViewContentProvider();
		_viewer = new TableViewer(parent, SWT.BORDER| SWT.MULTI);
		_viewer.setContentProvider(_contentProvider);
		_decorator = new GemocLabelDecorator();
		createColumn(parent);
		// make lines and header visible
		final Table table = _viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// The table will take all the horizontal and vertical excess space
		GridData grid = new GridData(SWT.FILL, SWT.FILL, true, true);
		_viewer.getControl().setLayoutData(grid);
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

	/**
	 * Create the column(s) of the tableViewer
	 */
	private void createColumn(final Composite parent)
	{	
		TableViewerColumn viewerColumn1 = new TableViewerColumn(_viewer, SWT.LEFT);
		TableColumn column1 = viewerColumn1.getColumn();
		column1.setText("Clock");
		column1.setWidth(100);
		column1.setResizable(true);
		column1.setMoveable(true);
		_column1LabelProvider = new DecoratingColumLabelProvider(new ColumnLabelProvider() 
		{
			@Override
			public String getText(Object element) 
			{
				String result = new String();          
				if (element instanceof ModelSpecificEventWrapper)
				{
					ModelSpecificEvent mse = ((ModelSpecificEventWrapper)element).getMSE();
					//result = ViewUtils.eventToString(c.getTickingEvent());
					result = mse.getName();
				}
				return result;
			}

			@Override
			public Image getImage(Object element) 
			{
				if (element instanceof ModelSpecificEventWrapper) 
				{
					ClockStatus state = ((ModelSpecificEventWrapper) element).getState();
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
				if (element instanceof ModelSpecificEventWrapper)
				{
					final ModelSpecificEvent solverEvent = ((ModelSpecificEventWrapper) element).getMSE();
					boolean isRepresented = _eventsToPresent.contains(EcoreUtil.getURI(solverEvent));
					if (isRepresented) {
						return representedEventColor;
					} else {
						ClockStatus state = ((ModelSpecificEventWrapper) element).getState();
						switch(state)
						{
						case NOTFORCED_SET: return notForcedSetColor;
						case FORCED_SET: return forcedSetColor;
						case FORCED_NOTSET: return forcedNotSetColor;
						default: break;
						}
					}
				}
				return super.getBackground(element);
			}
		}, _decorator);
		viewerColumn1.setLabelProvider(_column1LabelProvider);
	}


	/**
	 * Create the pop up menu which will be displayed following the right click
	 * operation on a row of the tableViewer.
	 * <br>The user can choose an action to realize on the selected Clock(s).
	 * @param listener
	 */
//	private void createPopUpMenu(Composite parent) 
//	{
//		final Menu menu = new Menu(parent.getShell(), SWT.POP_UP);
//		final Table table = _viewer.getTable();
//		table.setMenu(menu);
//
//		MenuItem item = new MenuItem(menu, SWT.PUSH);
//		item.setText("Force  to tick");
//		item.setData(ClockStatus.FORCED_SET);
//		item.addSelectionListener(_menuAndButtonListener);
//
//		new MenuItem(menu, SWT.SEPARATOR);
//		item = new MenuItem(menu, SWT.PUSH);
//		item.setText("Force  to not tick");
//		item.setData(ClockStatus.FORCED_NOTSET);
//		item.addSelectionListener(_menuAndButtonListener);
//
//		new MenuItem(menu, SWT.SEPARATOR);
//		item = new MenuItem(menu, SWT.PUSH);
//		item.setText("Free the clock(s)");
//		item.setData(ClockStatus.NOTFORCED_NOTSET);
//		item.addSelectionListener(_menuAndButtonListener);
//	}

	/**
	 * <p>Here two differents parts are created and added to _bottomComposite. Depending on the current
	 * state, one on these components will be displayed by _bottomComposite<p> 
	 * <p> The two differents parts are :<ul><li>an information panel with three MSE control buttons;</li>
	 * <li>a validation button to resume the execution</li></ul><p>
	 */
	private void createInformationAndButtons(Composite parent)
	{	
		/*************************************  information bar ****************************************/
		// The bar will be placed in the first row of the parent's grid ( which has a single column )
		_informationBar = new Composite(_bottomComposite, SWT.BORDER);
		// The bar will be made of 3 parts :
		_informationBar.setLayout(new GridLayout(3, false));
		_informationBar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		_informationBar.setBackground(new Color(parent.getDisplay(), 255, 255, 255));
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
		Button _freeButton = new Button(buttonBar, SWT.PUSH);
		_freeButton.setImage(SharedIcons.getSharedImage(SharedIcons.NOTFORCED_CLOCK_NOTSET));
		_freeButton.setToolTipText("Free");
		_freeButton.setData(ClockStatus.NOTFORCED_NOTSET);
		_freeButton.setLayoutData(new GridData(SWT.END,SWT.NONE,true, false));
		// Button which will forced to not tick the selected Clocks
		Button _forceFalseButton = new Button(buttonBar, SWT.PUSH);
		_forceFalseButton.setImage(SharedIcons.getSharedImage(SharedIcons.FORCED_CLOCK_NOTSET));
		_forceFalseButton.setToolTipText("Force to not tick");
		_forceFalseButton.setData(ClockStatus.FORCED_NOTSET);
		_forceFalseButton.setLayoutData(new GridData(SWT.END,SWT.NONE,false, false));
		// Button which will forced to tick the selected Clocks
		Button _forceTrueButton = new Button(buttonBar, SWT.PUSH);
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
		updateInformationAndButtons();
	}

	private SelectionListener createSelectionListener()
	{
		SelectionListener listener = new SelectionListener() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				StructuredSelection selection = (StructuredSelection)_viewer.getSelection();
				ArrayList<ModelSpecificEventWrapper> mses = new ArrayList<ModelSpecificEventWrapper>();
				for (Object o : selection.toList())
				{
					mses.add((ModelSpecificEventWrapper)o);
				}
								
				ClockStatus state = ClockStatus.NOTFORCED_NOTSET;

				if (e.getSource() instanceof MenuItem)
				{
					state = (ClockStatus) ((MenuItem)e.getSource()).getData();
				}
				if (e.getSource() instanceof Button)
				{
					state = (ClockStatus) ((Button)e.getSource()).getData();
				}

				forceClocks(mses, state);	
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
	private void forceClocks(Collection<ModelSpecificEventWrapper> mses, ClockStatus state) 
	{
		getMSEContext().forceClocks(mses, state);
		updateView();
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
				updateActionsVisibility();
				if(!isEngineStopped()
					&& getMSEContext() != null)
				{
					getMSEContext().refreshFutureTickingFreeClocks();
					_contentProvider.setFilterStrategy(_strategyFilterSelected);
					_decorator.setResourceSet(getMSEContext().getEngine().getExecutionContext().getResourceModel().getResourceSet());
					_decorator.mapping.clear();
					_viewer.setInput(getMSEContext().getMSESet());					
				}
				else
				{
					_viewer.setInput(null);										
				}
				updateComposites();
				for (TableColumn c : _viewer.getTable().getColumns())
				{
					c.pack();
				}
			}				
		});
	}

	private boolean isEngineStopped()
	{
		if (_currentSelectedEngine != null)
		{
			return _currentSelectedEngine.getRunningStatus().equals(RunStatus.Stopped);
		}
		return false;
	}

	/**
	 * Listen the engine change of state.
	 */
	private void update(IExecutionEngine engine) 
	{
		if (engine == _currentSelectedEngine)
		{
			int engineStep = (int)_currentSelectedEngine.getEngineStatus().getNbLogicalStepRun();
			//We check when the engine reach a new step
			if(engineStep > getMSEContext().getCacheStep()
				&& !isEngineStopped())
			{
				ScenarioManager sm = getScenarioManager();
				if(sm.getState().equals(ScenarioManagerState.Recording))
				{
					sm.record();
				}
				getMSEContext().setCacheStep(engineStep);
				
				if(sm.getState().equals(ScenarioManagerState.Playing))
				{
					sm.play();
				}
			}
			updateView();
		}
	}

	/**
	 * Listen the engine selection in the enginesStatusView
	 */
	@Override
	public void motorSelectionChanged(IExecutionEngine engine) {
		if (engine != null) 
		{
			_currentSelectedEngine = (ExecutionEngine) engine;
			// if the selected engine is stopped we clean its cache and disable all commands
			if (isEngineStopped())
			{
				if(_mseContextMap.get(engine) != null)
				{
					ScenarioManager sm = getScenarioManager();
					if (sm.getState().equals(ScenarioManagerState.Recording))
					{
						sm.stopRecord();
					}
					if (sm.getState().equals(ScenarioManagerState.Playing))
					{
						sm.stopPlaying();
					}
					engine.getExecutionContext().getExecutionPlatform().removeEngineAddon(this);
					_mseContextMap.remove(engine);
				}
			}
			else // else we set the current state according to the selected engine cache state
			{
				engine.getExecutionContext().getExecutionPlatform().removeEngineAddon(this);
				engine.getExecutionContext().getExecutionPlatform().addEngineAddon(this);
				//executeCommand(Commands.DO_INIT);
				if(_mseContextMap.get(engine) == null)
				{
					createMSEContext();
					if(engine.getExecutionContext().getExecutionMode().equals(ExecutionMode.Animation))
					{
						bring2Top();
					}
				}
				
				_recordAction.setEnabled(true);
				_playAction.setEnabled(true);
			}
			updateView();
		}
		else
		{
			_viewer.setInput(null);
		}
	}

	private void createMSEContext()
	{
		ModelSpecificEventContext context = new ModelSpecificEventContext(_currentSelectedEngine);
		_mseContextMap.put(_currentSelectedEngine, context);
	}

	private void startListeningToMotorSelectionChange() {
		EnginesStatusView enginesStatusView = getEngineStatusView();
		if (enginesStatusView != null) 
		{
			enginesStatusView.addMotorSelectionListener(this);
		}
	}

	private void stopListeningToMotorSelectionChange() {
		EnginesStatusView enginesStatusView = getEngineStatusView();
		if (enginesStatusView != null) 
		{
			enginesStatusView.removeMotorSelectionListener(this);
		}
	}

	private EnginesStatusView getEngineStatusView() {
		return ViewHelper.retrieveView(EnginesStatusView.ID);
	}



	@Override
	public void dispose() 
	{
		Activator.getDefault().getEventPresenters().remove(this);
		super.dispose();
		LogicalStepsView decisionView = ViewHelper.<LogicalStepsView>retrieveView(LogicalStepsView.ID);
		decisionView.removeSelectionChangedListener(_decisionViewListener);
		_contentProvider.dispose();
		if(_currentSelectedEngine != null) {
			_currentSelectedEngine.getExecutionContext().getExecutionPlatform().removeEngineAddon(this);
		}
		_currentSelectedEngine = null;	
		stopListeningToMotorSelectionChange();
		_column1LabelProvider.dispose();
		notForcedSetColor.dispose();
		forcedSetColor.dispose();
		forcedNotSetColor.dispose();
		representedEventColor.dispose();
		_eventsToPresent.clear();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() 
	{
		_viewer.getTable().setFocus();
	}

	public IExecutionEngine getEngine() 
	{
		return _currentSelectedEngine;
	}

	private ScenarioManager getCurrentScenarioManager()
	{
		if (getMSEContext() != null)
		{
			return getMSEContext().getScenarioManager();			
		}
		return null;
	}

	public void startRecordScenario() 
	{
		getCurrentScenarioManager().startRecord();
		updateView();
	}

	private ScenarioManager getScenarioManager()
	{
		if (getMSEContext() == null)
		{
			return null;
		}
		return getMSEContext().getScenarioManager();
	}

	public void stopRecordScenario()
	{
		getScenarioManager().stopRecord();
		updateView();	 
	}

	/**
	 * While the scenario possess execution step to be done, playScenario() is called.
	 * When the last step has been played, we stop the replay.
	 * @throws ScenarioException 
	 */
	public void playScenario(IPath path) throws ScenarioException
	{
		if (path == null)
		{
			throw new ScenarioException("Cannot start playing because the scenario path is null.");			
		}
		ScenarioManager sm = getScenarioManager();
		if (sm != null
			&& sm.getState().equals(ScenarioManagerState.Idle))
		{
			getScenarioManager().startPlaying(path);
		}
		else
		{
			throw new ScenarioException("Cannot start playing because a scenario is already being played.");
		}
		
//		if(fragment != null)
//		{
//			if(getScenarioManager().getProgress() < fragment.getStepList().size())
//			{
//			}
//			else
//			{
//				executeCommand(Commands.STOP_PLAY_SCENARIO);
//			}
//		}
	}

	public void stopPlayScenario()
	{
		getScenarioManager().stopPlaying();
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
		layout.topControl = _informationBar;
		_bottomComposite.layout();
		updateInformationAndButtons();
	}

	private void updateInformationAndButtons()
	{
		if (_viewStateLabel != null)
		{
			enableOrDisableButtons(_mseControlButtons);
			ScenarioManager sm = getScenarioManager();
			if (sm == null
				|| sm.getState() == ScenarioManagerState.Idle)
			{
				_viewStateLabel.setText("");							
			}
			else
			{
				_viewStateLabel.setText(sm.getState().toString() + " ...");								
			}
		}
	}

	private void enableOrDisableButtons(List<Button> controlButtons)
	{
		if (controlButtons != null)
		{
			for(Button b : controlButtons)
			{
				b.setEnabled(getMSEContext() != null);
			}			
		}
	}
	
	private void bring2Top()
	{
		getSite().getPage().bringToTop(this);
	}

	@Override
	public void present(List<URI> events) {
		_eventsToPresent = events;
		if (_currentSelectedEngine != null) {
			ResourceSet rs = _currentSelectedEngine.getExecutionContext().getResourceModel().getResourceSet();
			for (URI uri : _eventsToPresent) {
				final EObject event = rs.getEObject(uri, false);
				ModelSpecificEventWrapper toRefresh = _decorator.mapping.get(event);
				if (toRefresh != null) {
					_viewer.refresh(toRefresh);
				}
			}
		}
	}

	@Override
	public void engineAboutToStart(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStarted(IExecutionEngine executionEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineAboutToStop(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStopped(IExecutionEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToSelectLogicalStep(IExecutionEngine engine) {
		update(engine);
	}

	@Override
	public void logicalStepSelected(IExecutionEngine engine, LogicalStep selectedLogicalStep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToExecuteLogicalStep(IExecutionEngine engine,
			LogicalStep logicalStepToExecute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logicalStepExecuted(IExecutionEngine engine,
			LogicalStep logicalStepExecuted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aboutToExecuteMSE(IExecutionEngine engine,
			ModelSpecificEvent mse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mseExecuted(IExecutionEngine engine, ModelSpecificEvent mse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void engineStatusChanged(IExecutionEngine engine, RunStatus newStatus) {
		// TODO Auto-generated method stub
		
	}

}
