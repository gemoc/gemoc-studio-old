package org.gemoc.execution.engine.io.views.event;

import org.gemoc.execution.engine.io.views.event.EventManagerView.ClockStatus;

public class AdvancedWrapperControl 
{
	private int _step;
	private int _start;
	private int _delay;
	private int _duration;
	private ClockStatus _state;
	private ClockWrapper wrapper;
	private boolean _done;

	public AdvancedWrapperControl(ClockWrapper wrapper, int step, int delay, int duration)
	{
		this.wrapper = wrapper;
		_step = step;
		_delay = delay;
		_duration = duration;
		_done = false;
	}


	public void execute()
	{
		if(_step >= _start+_delay &&  _step <= _start+_duration+_delay)
		{
			wrapper.setState(_state);
		}
		_step++;
		if(_step > _start+_duration+_delay)
		{
			_done = true;
		}
	}
	
	public boolean getDone()
	{
		return _done;
	}
}
