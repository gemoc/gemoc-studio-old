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
public class ModelSpecificEvent 
{
	private Clock _clock;
	private ClockStatus _state;
	
	public ModelSpecificEvent(Clock clock) 
	{
		_clock = clock;
		_state = ClockStatus.NOTFORCED_NOTSET;
	}
	
	public void setState(ClockStatus state)
	{
		_state = state;
	}
	
	public ClockStatus getState()
	{
		return _state;
	}

	public String getClockQualifiedName() 
	{
		Block block = (Block)_clock.eContainer();
		String result = block.getName();
		result += "::";
		result += _clock.getName();
		return result;
	}
	
	public Clock getClock() 
	{
		return _clock;
	}
}
