package org.gemoc.execution.engine.core;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEOccurrence;

public class MSEOccurrence implements IMSEOccurrence {

	private MSEExecutionContext _mseExecutionContext;
	
	public MSEOccurrence(MSEExecutionContext mseExecutionContext) 
	{
		_mseExecutionContext = mseExecutionContext;
	}

	@Override
	public MSEExecutionContext getMSEExecutionContext() 
	{
		return _mseExecutionContext;
	}

}
