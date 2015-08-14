package org.gemoc.executionengine.ccsljava.api.core;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

public interface IConcurrentExecutionContext extends IExecutionContext
{
	
	ILogicalStepDecider getLogicalStepDecider();
	 
}
