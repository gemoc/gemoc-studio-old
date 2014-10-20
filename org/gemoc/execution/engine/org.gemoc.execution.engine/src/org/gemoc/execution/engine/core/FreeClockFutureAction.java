package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class FreeClockFutureAction implements IFutureAction
{

	private ModelSpecificEvent _mseToBeForced;
	private ModelSpecificEvent _triggeringMSE;
	private IClockController _clockController;
	
	public FreeClockFutureAction(ModelSpecificEvent mseToBeForced, ModelSpecificEvent triggeringMSE, IClockController clockController) 
	{
		_mseToBeForced = mseToBeForced;
		_triggeringMSE = triggeringMSE;
		_clockController = clockController;
	}

	@Override
	public ModelSpecificEvent getTriggeringMSE() 
	{
		return _triggeringMSE;
	}

	@Override
	public void perform() 
	{
		_clockController.freeInTheFuture(_mseToBeForced);
	}

}
