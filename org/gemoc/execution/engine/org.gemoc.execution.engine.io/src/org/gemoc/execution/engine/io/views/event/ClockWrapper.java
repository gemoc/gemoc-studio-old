package org.gemoc.execution.engine.io.views.event;

import org.gemoc.execution.engine.io.views.event.EventManagerView.ClockStatus;
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
public class ClockWrapper 
{
	private Clock _clock;
	private ClockControllerInternal _clockController;
	private ClockStatus _state;
	private AdvancedWrapperControl _control;
	
	public ClockWrapper(Clock clock, ClockControllerInternal clockController) 
	{
		_clock = clock;
		_clockController = clockController;
		_state = ClockStatus.NOTFORCED_NOTSET;
		_control = null;
	}
	
	public void setState(ClockStatus state){
		_state = state;
		boolean isForced = _state.isForced();
		boolean tick = _state.getTick();
		if(isForced)
		{
			if (tick)
			{
				_clockController.tickInTheFuture(getClockQualifiedName());			
			}
			else
			{
				_clockController.doNotTickInTheFuture(getClockQualifiedName());	
			}
		}
		else
		{
			_clockController.resetFutureClockState(getClockQualifiedName());
		}
	}
	
	public ClockStatus getState(){
		return _state;
	}

	private String getClockQualifiedName() 
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
	
	public AdvancedWrapperControl getControl() {
		return _control;
	}

	public void setControl(AdvancedWrapperControl control) {
		_control = control;
	}

}
