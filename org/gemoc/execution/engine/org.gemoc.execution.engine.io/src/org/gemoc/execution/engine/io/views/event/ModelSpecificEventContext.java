package org.gemoc.execution.engine.io.views.event;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.commons.dsa.EventInjectionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.control.ClockControllerInternal;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
import org.gemoc.execution.engine.scenario.Future;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class ModelSpecificEventContext 
{

	private ObservableBasicExecutionEngine _engine;
	
	private ModelSpecificEventSet _mseSet;
	
	private ClockControllerInternal _clockController = new ClockControllerInternal();

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
		ClockConstraintSystem clockConstraintSystem = extractClockConstraintSystem();
		_mseSet = new ModelSpecificEventSet(clockConstraintSystem);
		EventInjectionContext context = new EventInjectionContext(_engine.getExecutionContext().getSolver(), clockConstraintSystem);
		_clockController.initialize(context);
		_engine.get_clockControllers().add(_clockController);
	}

	private ClockConstraintSystem extractClockConstraintSystem() 
	{
		ClockConstraintSystem system = null;
		for(Resource r : _engine.getExecutionContext().getResourceModel().getResourceSet().getResources())
		{
			if(r.getContents().get(0) instanceof ClockConstraintSystem)
			{
				system = (ClockConstraintSystem)r.getContents().get(0);
				break;
			}
		}
		return system;
	}

	public void forceClock(ModelSpecificEvent mse, ClockStatus state) 
	{
		ArrayList<ModelSpecificEvent> c = new ArrayList<ModelSpecificEvent>();
		c.add(mse);
		forceClocks(c, state);
	}
	
	public void forceClocks(Collection<ModelSpecificEvent> mses, ClockStatus state) 
	{
		for(ModelSpecificEvent mse : mses)
		{
			if (mse.getState() != state)
			{
				setState(mse, state);
			}
		}
		_engine.recomputePossibleLogicalSteps();
	}
	
	public ModelSpecificEvent getMSE(String clockName) 
	{
		return _mseSet.getMSE(clockName);
	}
	
	private void setState(ModelSpecificEvent mse, ClockStatus state)
	{
		mse.setState(state);
		boolean isForced = state.isForced();
		Future future = state.getState();
		if (isForced)
		{
			if (future.equals(Future.TICK))
			{
				_clockController.tickInTheFuture(mse.getClockQualifiedName());			
			}
			else
			{
				_clockController.doNotTickInTheFuture(mse.getClockQualifiedName());	
			}
		}
		else
		{
			_clockController.resetFutureClockState(mse.getClockQualifiedName());
		}
	}
	
	/**
	 * Clean the non forced clock which will tick in the future
	 * between 2 steps.
	 */
	public void refreshFutureTickingFreeClocks() 
	{
		for(ModelSpecificEvent mse: _mseSet.getMSEs())
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
		for(ModelSpecificEvent mse : _mseSet.getMSEs())
		{
			setState(mse, ClockStatus.NOTFORCED_NOTSET);
		}
	}

	public Collection<ModelSpecificEvent> getMSEs() 
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
