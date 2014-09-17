package org.gemoc.execution.engine.io.views.event;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.execution.engine.io.views.event.EventManagerView.CacheStatus;
import org.gemoc.execution.engine.io.views.event.scenario.ScenarioManager;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class EngineCache {
	
	private ObservableBasicExecutionEngine _engine;
	
	private ExecutionMode _executionMode;
	private WrapperCache _wrapperCache;

	private ScenarioManager _scenarioManager;
	/**
	 * The state that event manager view will be in when the engine will be selected
	 */
	private CacheStatus _state;
	/**
	 * Match the current step of its engine;
	 */
	private int _cacheStep;
	private ClockConstraintSystem _system;
	
	
	
	public EngineCache(ObservableBasicExecutionEngine engine)
	{
		_engine = engine;
		_executionMode = _engine.getExecutionContext().getExecutionMode();
		_cacheStep = (int) engine.getEngineStatus().getNbLogicalStepRun();
		if(_executionMode.equals(ExecutionMode.Debug))
		{
			_state = CacheStatus.WAITING;
		}
		else
			_state = CacheStatus.RUNNING;
		createWrapperCache();
		createScenarioManager();
	}
	
	/* Controle du WrapperCache ***************************************************************************/
	
	private void createWrapperCache()
	{
		_system = extractSystem();
		_wrapperCache = new WrapperCache(this);

		if (_system != null)
		{
			for(Element e : _system.getSubBlock().get(0).getElements())
			{
				if (e instanceof Clock)
				{
					_wrapperCache.add((Clock)e);
				}
			}
		}
		_wrapperCache.configure();
	}
	
	private ClockConstraintSystem extractSystem() 
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
	

	/* Controle du Scenario Manager ***********************************************************************/
	
	private void createScenarioManager()
	{
		_scenarioManager = new ScenarioManager(this);
	}
	
	
	/* Getters and Setters ********************************************************************************/
	public WrapperCache getWrapperCache() {
		return _wrapperCache;
	}

	public ScenarioManager getScenarioManager() {
		return _scenarioManager;
	}
	
	public CacheStatus getState()
	{
		return _state;
	}
	
	public void setState(CacheStatus state)
	{
		_state = state;
	}

	public int getCacheStep() {
		return _cacheStep;
	}

	public void setCacheStep(int cacheStep) {
		_cacheStep = cacheStep;
	}
	
	public ObservableBasicExecutionEngine getEngine() {
		return _engine;
	}
	
	public ClockConstraintSystem getSystem() 
	{
		return _system;
	}
}
