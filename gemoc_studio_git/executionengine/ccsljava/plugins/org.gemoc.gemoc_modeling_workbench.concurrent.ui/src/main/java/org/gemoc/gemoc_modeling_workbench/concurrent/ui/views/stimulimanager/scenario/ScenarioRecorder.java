package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.scenario;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.gemoc.execution.engine.io.Activator;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.EventState;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.ExecutionStep;
import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Reference;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ClockStatus;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventContext;
import org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager.ModelSpecificEventWrapper;

public class ScenarioRecorder extends ScenarioTool
{
	public ScenarioRecorder(ModelSpecificEventContext mseContext)
	{
		super(mseContext);
	}

	private void createResource() 
	{
		ResourceSet rs = _mseContext.getEngine().getExecutionContext().getResourceModel().getResourceSet(); 				
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss");
		String fileName = format.format(new Date()) + ".scenario";
		URI uri = URI.createURI("platform:/resource" 
				+ _mseContext.getEngine().getExecutionContext().getWorkspace().getExecutionPath().append(fileName).toString());
		_resource = rs.createResource(uri);
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
		safeModelModification(runnable, "create scenario");
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
				ref.setStartStep((int) _mseContext.getEngine().getEngineStatus().getNbLogicalStepRun());
				refList.add(ref);
				_fragment = _factory.createFragment();
				ref.setFragment(_fragment);
			}
		};
		safeModelModification(runnable, "start record scenario");	
	}

	public void record()
	{
		Runnable runnable = new Runnable() 
		{
			public void run() {

				List<ExecutionStep> stepList =  _fragment.getStepList();
				ExecutionStep newStep = _factory.createExecutionStep();
				List<EventState> newListEvent = newStep.getEventList();
				for(ModelSpecificEventWrapper cw: _mseContext.getMSEs())
				{
					ClockStatus state = cw.getState();
					boolean isForced = state.isForced();
					if(isForced)
					{
						EventState newState = _factory.createEventState();
						newState.setMse(cw.getMSE());
						newState.setState(state.getState());
						newListEvent.add(newState);
					} 

				}
				stepList.add(newStep);

				save();
			}
		};
		safeModelModification(runnable, "record scenario");			
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
