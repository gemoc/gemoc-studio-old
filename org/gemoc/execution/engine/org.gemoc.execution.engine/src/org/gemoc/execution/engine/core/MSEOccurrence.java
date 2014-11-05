package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.dse.IMSEOccurrence;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;

public class MSEOccurrence implements IMSEOccurrence {

	private ModelSpecificEvent _mse;
	
	public MSEOccurrence(ModelSpecificEvent mse) 
	{
		_mse = mse;
	}

	@Override
	public ModelSpecificEvent getMSE() 
	{
		return _mse;
	}

}
