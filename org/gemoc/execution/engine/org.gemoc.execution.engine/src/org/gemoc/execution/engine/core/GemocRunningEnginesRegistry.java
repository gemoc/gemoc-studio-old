package org.gemoc.execution.engine.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public class GemocRunningEnginesRegistry {

	/**
	 * List of engines that have registered to be running in this eclipse
	 */
	protected HashMap<String, GemocExecutionEngine> runningEngines = new HashMap<String, GemocExecutionEngine>();
	
	
	/**
	 * Add the given engine with this name, return the unique name really used for this engine
	 * @param baseName
	 * @param engine
	 * @return
	 */
	synchronized public String registerEngine(String baseName, GemocExecutionEngine engine){
		int uniqueInstance = 0;
		String engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
		while(runningEngines.containsKey(engineName)){
			uniqueInstance = uniqueInstance +1;
			engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
		}
		runningEngines.put(engineName, engine);
		notifyEngineRegistered(engine);
		return engineName;
	}

	public void unregisterEngine(String engineName) 
	{
		GemocExecutionEngine engine = runningEngines.get(engineName);
		runningEngines.remove(engine);
		if (engine != null)
		{
			notifyEngineUnregistered(engine);
		}
	}

	public HashMap<String, GemocExecutionEngine> getRunningEngines() {
		return runningEngines;
	}
	
	
	private List<IEngineRegistrationListener> _engineRegistrationListeners = new ArrayList<IEngineRegistrationListener>();
	
	private void notifyEngineRegistered(GemocExecutionEngine engine) {
		synchronized (_engineRegistrationListeners) {
			for (IEngineRegistrationListener l : _engineRegistrationListeners)
			{
				l.engineRegistered(engine);
			}			
		}
	}
	
	private void notifyEngineUnregistered(GemocExecutionEngine engine) {
		synchronized (_engineRegistrationListeners) {
			for (IEngineRegistrationListener l : _engineRegistrationListeners)
			{
				l.engineUnregistered(engine);
			}			
		}
	}


	public void addEngineRegistrationListener(IEngineRegistrationListener listener) 
	{
		synchronized (_engineRegistrationListeners) {
			_engineRegistrationListeners.add(listener);
		}
	}

	public void removeEngineRegistrationListener(IEngineRegistrationListener listener) 
	{
		synchronized (_engineRegistrationListeners) {
			_engineRegistrationListeners.remove(listener);
		}
	}



}
