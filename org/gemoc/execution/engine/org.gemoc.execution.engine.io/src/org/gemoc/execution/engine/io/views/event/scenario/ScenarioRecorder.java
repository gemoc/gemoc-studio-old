package org.gemoc.execution.engine.io.views.event.scenario;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.event.ClockWrapper;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;

public class ScenarioRecorder extends ScenarioTool
{
	public ScenarioRecorder(ScenarioManager manager, int index)
	{
		super(manager, index);
	}

	private void createResource() 
	{
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet rs = _manager.getWrapperCache().getSystem().eResource().getResourceSet(); 				
				URI uri = URI.createURI("platform:/resource" + _manager.getWrapperCache().getEngine().getExecutionContext().getWorkspace().getExecutionPath().append("fragment["+_index+"].scenario").toString());
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
		//		if (_currentScenarioStep == null)
		//		{
		//			_currentScenarioStep = engine.getEngineStatus().getNbLogicalStepRun() - 1;
		//		}
		Runnable runnable = new Runnable() 
		{
			public void run() {
				List<ExecutionStep> stepList =  _scenario.getStepList();
				ExecutionStep newStep = _factory.createExecutionStep();
				List<EventState> newListEvent = newStep.getEventList();
				for(ClockWrapper cw: _manager.getWrapperCache().getClockWrapperList())
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

				newStep.setStep((int)engine.getEngineStatus().getNbLogicalStepRun()-1);
				stepList.add(newStep);

				save();
			}
		};
		safeModelModification(runnable);			
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
