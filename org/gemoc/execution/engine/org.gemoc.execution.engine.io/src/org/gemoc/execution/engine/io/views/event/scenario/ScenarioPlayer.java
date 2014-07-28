package org.gemoc.execution.engine.io.views.event.scenario;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Scenario;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;

public class ScenarioPlayer extends ScenarioTool
{
	private EventManagerView _eventView;
	
	public ScenarioPlayer(ScenarioManager manager)
	{
		super(manager);
		_eventView = ViewHelper.retrieveView(EventManagerView.ID);
	}
	
	/**
	 * Load a previously created scenario model.
	 */
	public void load(final String path){
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				URI uri = URI.createURI("file:/" + path); 
				_resource = resourceSet.getResource(uri, true); 
				_scenario = (Scenario) _resource.getContents().get(0);
				_eventView.setScenario(_scenario);
			}
		};
		safeModelModification(runnable);
	}

	public void play()
	{
		ObservableBasicExecutionEngine engine = _manager.getWrapperCache().getEngine();
		if (_currentScenarioStep == null)
		{
			_currentScenarioStep = engine.getEngineStatus().getNbLogicalStepRun() - 1;
		}
		
		if (engine.getEngineStatus().getNbLogicalStepRun() > _currentScenarioStep)
		{
			_currentScenarioStep++;
			final int progressPlayscenario = _eventView.getProgressPlayScenario();
			if(_scenario != null && _scenario instanceof Scenario)
			{
				List<ExecutionStep> stepList = _scenario.getStepList();
				for(EventManagerClockWrapper cw : _manager.getWrapperCache().getWrappers())
				{
					_manager.getWrapperCache().getWrappers();
					List<EventState> eventList = stepList.get(progressPlayscenario).getEventList();
					Clock clock = cw.getClock();
					for(int i = 0; i< eventList.size(); i++)
					{	
						if(eventList.get(i).getClock().getName().equals(clock.getName()))
						{
							cw.setStateForced(eventList.get(i).isIsForced());
						}
					}
				}
				_eventView.incProgressPlayScenario();
				_eventView.updateView();
			}
			else
			{
				throw new RuntimeException("The scenario loaded is null or isn't an instance of Scenario");
			}
		}
	}

	public void stop(){
		_eventView.resetProgressPlayScenario();
		_currentScenarioStep = null;
		_scenario = null;
		_eventView.setScenario(null);
		_eventView.setPlayFlag(false);
	}
}
