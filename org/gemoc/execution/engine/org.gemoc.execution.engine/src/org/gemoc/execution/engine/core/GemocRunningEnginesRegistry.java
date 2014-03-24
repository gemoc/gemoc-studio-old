package org.gemoc.execution.engine.core;


import java.util.HashMap;
import java.util.Observable;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public class GemocRunningEnginesRegistry extends Observable {

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
	synchronized public String registerNewEngine(String baseName, GemocExecutionEngine engine){
		int uniqueInstance = 0;
		String engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
		while(runningEngines.containsKey(engineName)){
			uniqueInstance = uniqueInstance +1;
			engineName = Thread.currentThread().getName() + " ("+uniqueInstance+")";
		}
		runningEngines.put(engineName, engine);
		this.setChanged();
		this.notifyObservers();
		return engineName;
	}


	public HashMap<String, GemocExecutionEngine> getRunningEngines() {
		return runningEngines;
	}
}
