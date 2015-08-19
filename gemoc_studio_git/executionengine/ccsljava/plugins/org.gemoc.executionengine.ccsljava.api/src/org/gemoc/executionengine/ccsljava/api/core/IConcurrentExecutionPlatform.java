package org.gemoc.executionengine.ccsljava.api.core;

import java.util.Collection;

import org.gemoc.executionengine.ccsljava.api.dsa.executors.ICodeExecutor;
import org.gemoc.executionengine.ccsljava.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;

public interface IConcurrentExecutionPlatform extends IExecutionPlatform
{

	/**
	 * @return The code executor to use for the model execution.
	 */
	ICodeExecutor getCodeExecutor();
	
	/**
	 * return this if this is an IConcurrentExecutionPlatform, null otherwise 
	 * @return
	 */
	IConcurrentExecutionPlatform asConcurrentExecutionPlatform();
	
	Collection<IMSEStateController> getMSEStateControllers();

}
