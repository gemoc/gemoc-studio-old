package org.gemoc.execution.engine.core;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public class GemocRunningEnginesRegistry {

	/**
	 * List of engines that have registered to be running in this eclipse
	 */
	protected HashMap<String, IExecutionEngine> runningEngines = new HashMap<String, IExecutionEngine>();
	
	
	/**
	 * Add the given engine with this name, return the unique name really used for this engine
	 * @param baseName
	 * @param engine
	 * @return
	 */
	synchronized public String registerEngine(String baseName, IExecutionEngine engine){
		int uniqueInstance = 0;
		String engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
		synchronized(runningEngines)
		{
			while(runningEngines.containsKey(engineName)){
				uniqueInstance = uniqueInstance +1;
				engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
			}
			runningEngines.put(engineName, engine);
		}
		notifyEngineRegistered(engine);			
		return engineName;
	}

	public void unregisterEngine(String engineName) 
	{
		synchronized(runningEngines)
		{
			IExecutionEngine engine = runningEngines.get(engineName);
			if (engine != null)
			{
				engine.dispose();
				runningEngines.remove(engineName);
				notifyEngineUnregistered(engine);
			}			
		}
	}

	public HashMap<String, IExecutionEngine> getRunningEngines() {
		synchronized(runningEngines)
		{
			return new HashMap<String, IExecutionEngine>(runningEngines);			
		}
	}
	
	
	private List<IEngineRegistrationListener> _engineRegistrationListeners = new ArrayList<IEngineRegistrationListener>();
	
	private void notifyEngineRegistered(IExecutionEngine engine) {
		synchronized (_engineRegistrationListeners) {
			for (IEngineRegistrationListener l : _engineRegistrationListeners)
			{
				l.engineRegistered(engine);
			}			
		}
	}
	
	private void notifyEngineUnregistered(IExecutionEngine engine) {
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
