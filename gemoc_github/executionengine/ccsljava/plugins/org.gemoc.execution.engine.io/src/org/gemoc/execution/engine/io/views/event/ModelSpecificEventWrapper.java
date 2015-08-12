package org.gemoc.execution.engine.io.views.event;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.Block;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;


/**
 *  
 * @author lguillem
 *	First implementation of the clock wrapper. We can access to 
 *	the clock and is state. In the future others features like
 *	statistics (nb of uses,etc ) will be added.
 */
public class ModelSpecificEventWrapper 
{
	private ModelSpecificEvent _mse;
	private ClockStatus _state;
	
	public ModelSpecificEventWrapper(ModelSpecificEvent mse) 
	{
		_mse = mse;
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
		Block block = (Block)_mse.eContainer();
		String result = block.getName();
		result += "::";
		result += _mse.getName();
		return result;
	}
	
	public ModelSpecificEvent getMSE() 
	{
		return _mse;
	}
}
