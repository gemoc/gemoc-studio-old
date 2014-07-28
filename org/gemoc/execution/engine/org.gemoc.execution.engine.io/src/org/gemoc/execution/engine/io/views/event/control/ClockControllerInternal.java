package org.gemoc.execution.engine.io.views.event.control;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.gemoc.execution.engine.commons.dsa.DefaultClockController;

public class ClockControllerInternal extends DefaultClockController implements IClockController2
{

	@Override
	public void makeClocksTickOrNotTick() 
	{
		for(Entry<String, Boolean> entry : _clockNextStates.entrySet())
		{
			if (entry.getValue())
			{
				tick(entry.getKey());
			}
			else
			{
				noTick(entry.getKey());				
			}
		}
	}

	private Map<String, Boolean> _clockNextStates = new HashMap<String, Boolean>();
	
	@Override
	public void tickInTheFuture(String clockQualifiedName)
	{
		setFutureClockState(clockQualifiedName, true);
	}

	@Override
	public void doNotTickInTheFuture(String clockQualifiedName)
	{
		setFutureClockState(clockQualifiedName, false);		
	}

	private void setFutureClockState(String clockQualifiedName, Boolean willTick)
	{
		_clockNextStates.put(clockQualifiedName, willTick);		
	}
	
	public void resetFutureClockState(String clockQualifiedName){
		_clockNextStates.remove(clockQualifiedName);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
}
