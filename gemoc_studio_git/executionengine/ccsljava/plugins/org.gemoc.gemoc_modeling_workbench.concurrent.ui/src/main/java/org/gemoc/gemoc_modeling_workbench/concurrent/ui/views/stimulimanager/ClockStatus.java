package org.gemoc.gemoc_modeling_workbench.concurrent.ui.views.stimulimanager;

import org.gemoc.executionengine.ccsljava.stimuli_scenario.scenario.Future;



/**
 * Store the 4 possible states of a Clock:
 * <p> - A clock can be forced to tick or not tick in the future;
 * <br>- A clock not forced can either tick or not tick in the future;
 */
public enum ClockStatus {

	NOTFORCED_SET(false, Future.TICK),
	NOTFORCED_NOTSET(false, Future.NO_TICK),
	FORCED_SET(true, Future.TICK),
	FORCED_NOTSET(true, Future.NO_TICK);
	
	private Boolean isForced;
	private Future future;

	ClockStatus(Boolean isForced, Future future)
	{
		this.isForced = isForced;
		this.future = future;
	}

	public Boolean isForced()
	{
		return isForced;
	}

	public Future getState()
	{
		return future;
	}
	
}
