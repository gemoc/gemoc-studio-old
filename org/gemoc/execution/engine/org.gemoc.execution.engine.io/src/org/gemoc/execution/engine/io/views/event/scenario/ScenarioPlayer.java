package org.gemoc.execution.engine.io.views.event.scenario;

import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.commons.eclipse.ui.ViewHelper;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.execution.engine.io.views.event.ClockStatus;
import org.gemoc.execution.engine.io.views.event.StimuliManagerView;
import org.gemoc.execution.engine.io.views.event.ModelSpecificEventContext;
import org.gemoc.execution.engine.io.views.event.ModelSpecificEventWrapper;
import org.gemoc.execution.engine.scenario.EventState;
import org.gemoc.execution.engine.scenario.ExecutionStep;
import org.gemoc.execution.engine.scenario.Future;
import org.gemoc.execution.engine.scenario.Scenario;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class ScenarioPlayer extends ScenarioTool
{
	private StimuliManagerView _eventView;

	public ScenarioPlayer(ModelSpecificEventContext mseContext)
	{
		super(mseContext);
		_eventView = ViewHelper.retrieveView(StimuliManagerView.ID);
	}

	/**
	 * Load a previously created scenario model.
	 */
	public void load(final IPath path)
	{
		ResourceSet resourceSet = new ResourceSetImpl(); 
		URI uri = URI.createURI("file:/" + path); 
		_resource = resourceSet.getResource(uri, true); 
		_scenario = (Scenario) _resource.getContents().get(0);
		//TODO: choisir dynamiquement le fragment voulu	ou lire tous les fragments d'un scenario bout à bout.		
		_fragment = _scenario.getRefList().get(0).getFragment();
//		Runnable runnable = new Runnable() 
//		{
//			public void run() 
//			{
//				ResourceSet resourceSet = new ResourceSetImpl(); 
//				URI uri = URI.createURI("file:/" + path); 
//				_resource = resourceSet.getResource(uri, true); 
//				_scenario = (Scenario) _resource.getContents().get(0);
//				//TODO: choisir dynamiquement le fragment voulu	ou lire tous les fragments d'un scenario bout à bout.		
//				_fragment = _scenario.getRefList().get(0).getFragment();
//				_eventView.setScenario(_fragment);
//			}
//		};
//		safeModelModification(runnable, "load scenario");
	}

	public boolean play() throws ScenarioException
	{
		if (_fragment != null)
		{
			List<ExecutionStep> stepList = _fragment.getStepList();
			if (getPlayProgressIndex() == stepList.size())
			{
				throw new ScenarioException("Current play progress index is greater than the scenario size.");
			}
			else
			{
				for(ModelSpecificEventWrapper wrapper : _mseContext.getMSEs())
				{
					List<EventState> eventStates = stepList.get(getPlayProgressIndex()).getEventList();
					ModelSpecificEvent mse = wrapper.getMSE();
					//mse.setState(ClockStatus.NOTFORCED_NOTSET);
					for (int i = 0; i< eventStates.size(); i++)
					{	
						if(eventStates.get(i).getMse().getName().equals(mse.getName()))
						{
							ClockStatus newState = eventStates.get(i).getState().equals(Future.TICK) ? ClockStatus.FORCED_SET : ClockStatus.FORCED_NOTSET;
							_mseContext.forceClock(wrapper, newState);
						}
					}
				}
				increasePlayProgressIndex();
				_eventView.updateView();
				return !(getPlayProgressIndex() == stepList.size());
			}
		}
		else
		{
			throw new ScenarioException("The scenario loaded is null or isn't an instance of Scenario");
		}

	}

	/**
	 * Remove the fragment and reset the progress step counter.
	 */
	public void stop(){
		resetPlayProgressIndex();
		_fragment = null;
		_mseContext.freeAllClocks();
		((ExecutionEngine)_mseContext.getEngine()).recomputePossibleLogicalSteps();
	}
	
	
	private int _playProgressIndex;

	private int getPlayProgressIndex()
	{
		return _playProgressIndex;
	}
	
	private void increasePlayProgressIndex()
	{
		_playProgressIndex++;
	}
	
	private void resetPlayProgressIndex()
	{
		_playProgressIndex = 0;
	}
}
