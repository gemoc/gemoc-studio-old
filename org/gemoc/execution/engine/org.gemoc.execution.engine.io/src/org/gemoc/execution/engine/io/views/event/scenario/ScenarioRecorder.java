package org.gemoc.execution.engine.io.views.event.scenario;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.execution.engine.io.views.event.ClockWrapper;
import org.gemoc.execution.engine.io.views.event.EventManagerView.ClockStatus;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Reference;

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
				ResourceSet rs = _manager.getCache().getSystem().eResource().getResourceSet(); 				
				URI uri = URI.createURI("platform:/resource" 
						+ _manager.getCache().getEngine().getExecutionContext().getWorkspace().getExecutionPath().append("container.scenario").toString());
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
		if(_scenario == null)
		{	
			createResource();
			createScenario();
		}
		Runnable runnable = new Runnable() 
		{
			public void run() {
				List<Reference> refList = _scenario.getRefList();
				Reference ref = _factory.createReference();
				ref.setStartStep((int) _manager.getCache().getEngine().getEngineStatus().getNbLogicalStepRun());
				refList.add(ref);
				_fragment = _factory.createFragment();
				ref.setFragment(_fragment);
			}
		};
		safeModelModification(runnable);	
	}

	public void record()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() {

				List<ExecutionStep> stepList =  _fragment.getStepList();
				ExecutionStep newStep = _factory.createExecutionStep();
				List<EventState> newListEvent = newStep.getEventList();
				for(ClockWrapper cw: _manager.getCache().getWrapperCache().getClockWrapperList())
				{
					ClockStatus state = cw.getState();
					boolean isForced = state.isForced();
					if(isForced)
					{
						EventState newState = _factory.createEventState();
						newState.setClock(cw.getClock());
						newState.setTick(state.getTick());
						newListEvent.add(newState);
					} 

				}
				stepList.add(newStep);

				save();
			}
		};
		safeModelModification(runnable);			
	}		


	protected void save()
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
