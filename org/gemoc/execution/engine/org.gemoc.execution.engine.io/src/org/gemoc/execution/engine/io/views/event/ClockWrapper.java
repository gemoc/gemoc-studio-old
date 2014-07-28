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
public class ClockWrapper {
	private Clock _clock;
	private ClockControllerInternal _clockController;
	private Boolean _stateForced;
	private boolean _stateFutureTick;

	public ClockWrapper(Clock clock, ClockControllerInternal clockController) {
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
		else
		{
			_clockController.resetFutureClockState(getClockQualifiedName());
			setStateFutureTick(false);
		}
	}
	
	public void free(){
		setStateForced(null);
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


	public ClockStatus getBehavior(){
		ClockStatus result;
		if(_stateForced == null)
		{
			result = _stateFutureTick ? ClockStatus.NOTFORCED_SET : ClockStatus.NOTFORCED_NOTSET;
		}
		else
		{
			result = _stateForced ? ClockStatus.FORCED_SET : ClockStatus.FORCED_NOTSET;
		}
		return result;
	}


}
