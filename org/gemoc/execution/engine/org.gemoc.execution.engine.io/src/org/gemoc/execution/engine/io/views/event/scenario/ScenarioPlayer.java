package org.gemoc.execution.engine.io.views.event.scenario;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.io.views.event.ClockWrapper;
import org.gemoc.execution.engine.io.views.event.EventManagerView;
import org.gemoc.execution.engine.io.views.event.EventManagerView.ClockStatus;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Fragment;
import org.gemoc.execution.engine.scenario.Future;
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
	public void load(final IPath path){
		Runnable runnable = new Runnable() 
		{
			public void run() 
			{
				ResourceSet resourceSet = new ResourceSetImpl(); 
				URI uri = URI.createURI("file:/" + path); 
				_resource = resourceSet.getResource(uri, true); 
				_scenario = (Scenario) _resource.getContents().get(0);
				//TODO: choisir dynamiquement le fragment voulu	ou lire tous les fragments d'un scenario bout à bout.		
				_fragment = _scenario.getRefList().get(0).getFragment();
				_eventView.setScenario(_fragment);
			}
		};
		safeModelModification(runnable, "load scenario");
	}

	public void play()
	{
		final int progressPlayscenario = _manager.getProgress();
		if(_fragment != null && _fragment instanceof Fragment)
		{
			List<ExecutionStep> stepList = _fragment.getStepList();
			for(ClockWrapper cw : _manager.getCache().getWrapperCache().getClockWrapperList())
			{
				_manager.getCache().getWrapperCache().getClockWrapperList();
				List<EventState> eventList = stepList.get(progressPlayscenario).getEventList();
				Clock clock = cw.getClock();
				cw.setState(ClockStatus.NOTFORCED_NOTSET);
				for(int i = 0; i< eventList.size(); i++)
				{	
					if(eventList.get(i).getClock().getName().equals(clock.getName()))
					{
						ClockStatus newState = eventList.get(i).getState().equals(Future.TICK) ? ClockStatus.FORCED_SET : ClockStatus.FORCED_NOTSET;
						cw.setState(newState); 
					}
				}
			}
			_manager.incProgress();
			_eventView.updateView();
		}
		else
		{
			throw new RuntimeException("The scenario loaded is null or isn't an instance of Scenario");
		}

	}

	/**
	 * Remove the fragment and reset the progress step counter.
	 */
	public void stop(){
		_manager.resetProgress();
		_fragment = null;
		_eventView.setScenario(_fragment);
	}
}
