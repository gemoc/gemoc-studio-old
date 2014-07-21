package org.gemoc.execution.engine.io.views.event;

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
	private Boolean _state;
	
	public EventManagerClockWrapper(Clock clock, ClockControllerInternal clockController) {
		_clock = clock;
		_state = false;
		_clockController = clockController;
	}
	public boolean isState() {
		return _state;
	}
	public void setState(boolean state) {
		_state = state;		
		if (_state)
		{
			_clockController.tickInTheFuture(getClockQualifiedName());			
		}
		else
		{
			_clockController.doNotTickInTheFuture(getClockQualifiedName());						
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
}
