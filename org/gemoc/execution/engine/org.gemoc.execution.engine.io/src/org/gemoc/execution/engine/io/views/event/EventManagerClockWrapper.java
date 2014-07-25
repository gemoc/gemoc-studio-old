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
	private boolean _stateFutureTick;

	public EventManagerClockWrapper(Clock clock, ClockControllerInternal clockController) {
		_clock = clock;
		_stateForced = null;
		_stateFutureTick = false;
		_clockController = clockController;
	}
	public Boolean isForced() {
		return _stateForced;
	}

	public void setStateFutureTick(boolean state){
		_stateFutureTick = state;
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
			setStateFutureTick(_stateForced);
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
		String result = "";
		if(_stateForced == null)
		{
			result = _stateFutureTick ? "NOTFORCED_CLOCK_SET" : "NOTFORCED_CLOCK_NOTSET";
		}
		else
		{
			result = _stateForced ? "FORCED_CLOCK_SET" : "FORCED_CLOCK_NOTSET";
		}
		return result;
	}


}
