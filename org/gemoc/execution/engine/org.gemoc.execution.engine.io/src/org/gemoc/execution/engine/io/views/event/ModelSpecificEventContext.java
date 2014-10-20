package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.execution.engine.commons.dsa.DefaultClockController;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
import org.gemoc.execution.engine.scenario.Future;

public class ModelSpecificEventContext 
{

	private ObservableBasicExecutionEngine _engine;
	
	private ModelSpecificEventSet _mseSet;
	
	private DefaultClockController _clockController = new DefaultClockController();

	private ScenarioManager _scenarioManager;

	
	public ModelSpecificEventContext(ObservableBasicExecutionEngine engine)
	{
		_engine = engine;
		_executionStep = (int) engine.getEngineStatus().getNbLogicalStepRun();
		_scenarioManager = new ScenarioManager(this);
		configure();
	}

	private void configure()
	{
		_mseSet = new ModelSpecificEventSet(_engine.getExecutionContext().getFeedbackModel());
		EventInjectionContext context = new EventInjectionContext(_engine.getExecutionContext().getSolver());
		_clockController.initialize(context);
		_engine.get_clockControllers().add(_clockController);
	}

	public void forceClock(ModelSpecificEventWrapper mse, ClockStatus state) 
	{
		ArrayList<ModelSpecificEventWrapper> c = new ArrayList<ModelSpecificEventWrapper>();
		c.add(mse);
		forceClocks(c, state);
	}
	
	public void forceClocks(Collection<ModelSpecificEventWrapper> mses, ClockStatus state) 
	{
		for(ModelSpecificEventWrapper mse : mses)
		{
			if (mse.getState() != state)
			{
				setState(mse, state);
			}
		}
		_engine.recomputePossibleLogicalSteps();
	}
	
	public ModelSpecificEventWrapper getMSE(String clockName) 
	{
		return _mseSet.getMSE(clockName);
	}
	
	private void setState(ModelSpecificEventWrapper wrapper, ClockStatus state)
	{
		wrapper.setState(state);
		boolean isForced = state.isForced();
		Future future = state.getState();
		if (isForced)
		{
			if (future.equals(Future.TICK))
			{
				_clockController.tickInTheFuture(wrapper.getMSE());			
			}
			else
			{
				_clockController.doNotTickInTheFuture(wrapper.getMSE());	
			}
		}
		else
		{
			_clockController.freeInTheFuture(wrapper.getMSE());
		}
	}
	
	/**
	 * Clean the non forced clock which will tick in the future
	 * between 2 steps.
	 */
	public void refreshFutureTickingFreeClocks() 
	{
		for(ModelSpecificEventWrapper mse: _mseSet.getMSEs())
		{
			if(!mse.getState().isForced())
			{
				mse.setState(ClockStatus.NOTFORCED_NOTSET);
			}
		}
	}
	
	/**
	 * Match the current step of its engine;
	 */
	private int _executionStep;

	public ScenarioManager getScenarioManager() {
		return _scenarioManager;
	}
	
	public int getCacheStep() {
		return _executionStep;
	}

	public void setCacheStep(int cacheStep) {
		_executionStep = cacheStep;
	}

	/**
	 * Set all the wrappers state to not forced with no tick in the future.
	 */
	public void freeAllClocks()
	{
		for(ModelSpecificEventWrapper mse : _mseSet.getMSEs())
		{
			setState(mse, ClockStatus.NOTFORCED_NOTSET);
		}
	}

	public Collection<ModelSpecificEventWrapper> getMSEs() 
	{
		return _mseSet.getMSEs();
	}
	
	public ObservableBasicExecutionEngine getEngine()
	{
		return _engine;
	}

	public ModelSpecificEventSet getMSESet() 
	{
		return _mseSet;
	}
}
