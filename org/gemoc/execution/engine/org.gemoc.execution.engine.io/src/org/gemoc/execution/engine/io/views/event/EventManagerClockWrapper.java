package org.gemoc.execution.engine.io.views.event;

import org.gemoc.execution.engine.io.views.event.control.ClockControllerInternal;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Clock;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.Block;


/**
 *  
 * @author lguillem
 *	First implementation of the clock wrapper. We can access to 
 *	the clock and is state. In the future others features like
 *	statistics (nb of uses,etc ) will be added.
 */
public class EventManagerClockWrapper {
	private Clock _clock;
	private ClockControllerInternal _clockController;
	private Boolean _stateForced;
	
	public EventManagerClockWrapper(Clock clock, ClockControllerInternal clockController) {
		_clock = clock;
		_stateForced = null;
		_clockController = clockController;
	}
	public Boolean isState() {
		return _stateForced;
	}
	public void setStateForced(Boolean state) {
		_stateForced = state;		
		if(_stateForced != null)
		{
			if (_stateForced)
			{
				_clockController.tickInTheFuture(getClockQualifiedName());			
			}
			else
			{
				_clockController.doNotTickInTheFuture(getClockQualifiedName());						
			}
		}
	}
	
	private String getClockQualifiedName() 
	{
		Block block = (Block)_clock.eContainer();
		String result = block.getName();
		result += "::";
		result += _clock.getName();
		return result;
	}
	public Clock getClock() {
		return _clock;
	}
	

	public String getBehavior(){
		String result = null;
		if(_stateForced == null)
		{
					result = "NOTFORCED_CLOCK_NOTSET";
		}
		else
		{
			if(_stateForced)
			{
				result = "FORCED_CLOCK_SET";
			}
			else
			{
				result = "FORCED_CLOCK_NOTSET";
			}
		}
		return result;
	}
	
	
}
