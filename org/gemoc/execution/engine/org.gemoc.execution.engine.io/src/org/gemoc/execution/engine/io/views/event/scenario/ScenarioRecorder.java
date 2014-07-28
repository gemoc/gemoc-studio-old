package org.gemoc.execution.engine.io.views.event.scenario;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.event.EventManagerClockWrapper;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;

public class ScenarioRecorder extends ScenarioTool
{
	public ScenarioRecorder(ScenarioManager manager)
	{
		super(manager);
	}
	
	private void createResource() 
	{
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet rs = _manager.getWrapperCache().getSystem().eResource().getResourceSet(); 				
				URI uri = URI.createURI("platform:/resource" + _manager.getWrapperCache().getEngine().getExecutionContext().getWorkspace().getExecutionPath().append("Scenario.scenario").toString());
				_resource = rs.createResource(uri);
			}
		};
		safeModelModification(runnable);
	}

	private void createScenario()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				_scenario = _factory.createScenario();
				_resource.getContents().add(_scenario);
				save();
			}
		};
		safeModelModification(runnable);
	}
	
	public void startRecord()
	{
		createResource();
		createScenario();
	}

	public void record()
	{
		final ObservableBasicExecutionEngine engine = _manager.getWrapperCache().getEngine();
		if (_currentScenarioStep == null)
		{
			_currentScenarioStep = engine.getEngineStatus().getNbLogicalStepRun() - 1;
		}
		if (engine.getEngineStatus().getNbLogicalStepRun() > _currentScenarioStep)
		{
			_currentScenarioStep++;
			Runnable runnable = new Runnable() 
			{
				public void run() {
					List<ExecutionStep> stepList =  _scenario.getStepList();
					ExecutionStep newStep = _factory.createExecutionStep();
					List<EventState> newListEvent = newStep.getEventList();
					for(EventManagerClockWrapper cw: _manager.getWrapperCache().getWrappers())
					{
						Boolean state = cw.isForced();
						if(state != null)
						{
							EventState newState = _factory.createEventState();
							newState.setClock(cw.getClock());
							newState.setIsForced(state);
							newListEvent.add(newState);
						}
					}
					if(!newListEvent.isEmpty())
					{
						newStep.setStep((int)engine.getEngineStatus().getNbLogicalStepRun());
						stepList.add(newStep);
					}
					save();
				}
			};
			safeModelModification(runnable);			
		}		
	}

	public void stopRecord(){
		createResource();
		_currentScenarioStep = null;
	}
	
	private void save()
	{
		try 
		{
			_resource.save(null);
		} 
		catch (IOException e) {
			String message = "Cannot save scenario, see inner exception";
			Activator.getDefault().error(message, e);
		}
	}
}
