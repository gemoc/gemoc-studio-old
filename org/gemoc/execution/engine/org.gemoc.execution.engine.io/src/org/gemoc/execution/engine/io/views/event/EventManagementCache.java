package org.gemoc.execution.engine.io.views.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ModelExecutionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Scenario;
import org.gemoc.execution.engine.scenario.ScenarioFactory;
import org.gemoc.execution.engine.scenario.impl.ScenarioFactoryImpl;

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
	private Scenario _scenario;
	private ScenarioFactory _factory;
	private Resource _resource;

	public EventManagementCache()
	{
		_clocksCache = new HashMap<String, EventManagerClockWrapper>();
		_clockController = new ClockControllerInternal();
		_selectedFilter = new EventFilter();
		_factory = ScenarioFactoryImpl.eINSTANCE;
	}

	public void configure(ObservableBasicExecutionEngine engine, ClockConstraintSystem clockConstraintSystem)
	{
		engine.addClockController(_clockController);
		_system = clockConstraintSystem;
		EventInjectionContext context = new EventInjectionContext(engine.getSolver(), clockConstraintSystem);
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
	
	
	private void createResource(ModelExecutionContext context) {
		ResourceSet rs = _system.eResource().getResourceSet();
		URI uri = URI.createURI("scenario" + context.getRuntimePath().toString());
		_resource = rs.createResource(uri);
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
	
	/**
	 * Create a new model which follow the meta-model Scenario.
	 */
	public void createScenario(){
		_scenario = _factory.createScenario();
		_resource.getContents().add(_scenario);		
	
	}
	
	/**
	 * Add a new Execution Step to the model with all the clock states
	 * @param nbStep TODO
	 */
	public void addExecutionStep(int nbStep){
		List<ExecutionStep> stepList =  _scenario.getStepList();
		ExecutionStep newStep = _factory.createExecutionStep();
		// TODO:fixer le numero de pas logique dans ExecutionStep
		List<EventState> newListEvent = newStep.getEventList();
		for(EventManagerClockWrapper cw: getWrappers()){
			EventState newState = _factory.createEventState();
			newState.setClock(cw.getClock());
			newState.setIsForced(cw.isState());
			newListEvent.add(newState);
		}
		stepList.add(newStep);		
	}
	
	/**
	 * Load a previously created scenario model.
	 */
	public void loadScenario(){
//		//TODO: recupérer un modele de scenario sauvegardé dans les ressources
//		// et faire un truc du style _scenario = bidule.load; en fct de ce qui aura ete choisi dans les commandes de la view
//		URI uri = URI.createURI("platform:/resource//org.gemoc....scenario");
//		ResourceSet rs = new ResourceSetImpl();
//		Resource r = rs.getResource(uri, true);
//		try {
//			r.load(null);
//			_scenario = (Scenario)r.getContents().get(0);
//		} 
//		catch (IOException e) {}
	}
	
	public void saveScenario(){
		try 
		{
			_resource.save(null);
		} 
		catch (IOException e) {}
	}
	
	public void resetScenario(ObservableBasicExecutionEngine engine){
		createResource(engine.getExecutionContext());
	}
	
	
}
