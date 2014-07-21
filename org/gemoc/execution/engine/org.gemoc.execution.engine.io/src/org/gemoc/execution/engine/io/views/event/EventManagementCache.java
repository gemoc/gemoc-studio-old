package org.gemoc.execution.engine.io.views.event;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.control.ClockControllerInternal;
import org.gemoc.execution.engine.io.views.event.filters.EventFilter;
import org.gemoc.execution.engine.io.views.event.filters.IEventFilterStrategy;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Scenario;
import org.gemoc.execution.engine.scenario.ScenarioFactory;
import org.gemoc.execution.engine.scenario.impl.ScenarioFactoryImpl;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Relation;

public class EventManagementCache 
{
	private Map<String, EventManagerClockWrapper> _clocksCache;
	private ClockControllerInternal _clockController;
	private ClockConstraintSystem _system;
	private EventFilter _selectedFilter;
	private List<Relation> _relations;
	private Scenario _scenarioSaved;
	private Scenario _scenarioLoaded;
	private EventManagerView _eventView;
	private ScenarioFactory _factory;
	private Resource _resource;
	private int _engineStep;
	public static final String scenarioPath  = "udd//lguillem//runtime-GEMOC//ScenarioFolder/";

	public EventManagementCache()
	{
		_clocksCache = new HashMap<String, EventManagerClockWrapper>();
		_clockController = new ClockControllerInternal();
		_selectedFilter = new EventFilter();
		_factory = ScenarioFactoryImpl.eINSTANCE;
		_scenarioLoaded = null;
		_eventView = ViewHelper.retrieveView(EventManagerView.ID);
		_engineStep = 0;
	}

	public void configure(ObservableBasicExecutionEngine engine, ClockConstraintSystem clockConstraintSystem)
	{
		engine.get_clockControllers().add(_clockController);
		_system = clockConstraintSystem;
		EventInjectionContext context = new EventInjectionContext(engine.getExecutionContext().getSolver(), clockConstraintSystem);
		_clockController.initialize(context);
		_relations = new ArrayList<Relation>();
		for(Relation r : _system.getSubBlock().get(0).getRelations())
		{
			if(r instanceof Relation)
			{
				_relations.add((Relation)r);
			}
		}
		createResource(engine.getExecutionContext());
	}


	private void createResource(IExecutionContext context) {
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet rs = _system.eResource().getResourceSet(); 
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				URI uri = URI.createURI("file:/"+scenarioPath+timeStamp+".scenario");
				_resource = rs.createResource(uri);
			}
		};
		safeModelModification(runnable);
	}


	public void addClock(Clock clock) 
	{
		EventManagerClockWrapper newClockWrapper = new EventManagerClockWrapper(clock, _clockController);
		_clocksCache.put(clock.getName(), newClockWrapper);
	}

	public Collection<EventManagerClockWrapper> getWrappers() {
		return _selectedFilter.applyFilter(_relations, new ArrayList<EventManagerClockWrapper>(_clocksCache.values()));
	}

	public EventManagerClockWrapper getWrapper(String clockName) {
		return _clocksCache.get(clockName);
	}

	public void removeFromClockCache(String clockName){
		_clocksCache.remove(clockName);
	}

	public void setFilter(IEventFilterStrategy filter) {
		_selectedFilter.set_filterStrategy(filter);
	}

	public void disableClocks(Collection<EventManagerClockWrapper> clocksToDisable){
		ArrayList<EventManagerClockWrapper> clockWrappers = new ArrayList<EventManagerClockWrapper>(clocksToDisable);
		for(EventManagerClockWrapper wrapper: clockWrappers)
		{
			wrapper.setState(false);
		}
	}

	private void safeModelModification(final Runnable runnable)
	{
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(_system);
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {
					public void doExecute() {
						runnable.run();
					}
				});		
	}

	/**
	 * Create a new model which follow the meta-model Scenario.
	 */
	public void createScenario()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				_scenarioSaved = _factory.createScenario();
				_resource.getContents().add(_scenarioSaved);
				saveScenario();
			}
		};
		safeModelModification(runnable);
	}

	/**
	 * Add a new Execution Step to the model scenario with all the clock states
	 */
	public void addExecutionStep()
	{

		Runnable runnable = new Runnable() 
		{
			public void run() {
				List<ExecutionStep> stepList =  _scenarioSaved.getStepList();
				ExecutionStep newStep = _factory.createExecutionStep();
				List<EventState> newListEvent = newStep.getEventList();
				for(EventManagerClockWrapper cw: getWrappers()){
					EventState newState = _factory.createEventState();
					newState.setClock(cw.getClock());
					newState.setIsForced(cw.isState());
					newListEvent.add(newState);
				}
				newStep.setStep(_engineStep);
				stepList.add(newStep);
				saveScenario();
			}
		};
		safeModelModification(runnable);
	}




	public void saveScenario(){
		try 
		{
			_resource.save(null);
		} 
		catch (IOException e) {}
	}

	public void resetRessource(){
		createResource(_eventView.getEngine().getExecutionContext());
	}

	/**
	 * Load a previously created scenario model.
	 */
	public void loadScenario(final String path){
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				URI uri = URI.createURI("file:/" + path); 
				_resource = resourceSet.getResource(uri, true); 
				_scenarioLoaded = (Scenario) _resource.getContents().get(0);
				_eventView.setScenario(_scenarioLoaded);
			}
		};
		safeModelModification(runnable);
	}

	public void playScenario(){ 
		final int progressPlayscenario = _eventView.getProgressPlayScenario();
		if(_scenarioLoaded != null && _scenarioLoaded instanceof Scenario)
		{
			List<ExecutionStep> stepList = _scenarioLoaded.getStepList();
			for(EventManagerClockWrapper cw :_clocksCache.values())
			{
				List<EventState> eventList = stepList.get(progressPlayscenario).getEventList();
				Clock clock = cw.getClock();
				for(int i = 0; i< eventList.size(); i++)
				{	
					if(eventList.get(i).getClock().getName().equals(clock.getName()))
					{
						cw.setState(eventList.get(i).isIsForced());
					}
				}
			}
			_eventView.incProgressPlayScenario();
		}
		else
		{
			throw new RuntimeException("The scenario loaded is null or isn't an instance of Scenario");
		}
	}

	public void stopPlayScenario(){
		_eventView.resetProgressPlayScenario();
		_scenarioLoaded = null;
		_eventView.setScenario(null);
		_eventView.setPlayFlag(false);
	}

	public Scenario getScenario() {
		return _scenarioLoaded;
	}

	public void setEngineStep(int step){
		_engineStep = step;
	}

	public int getEngineStep(){
		return _engineStep;
	}


}
