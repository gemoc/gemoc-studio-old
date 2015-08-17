package org.gemoc.executionengine.ccsljava.api.core;

import java.util.Collection;

import org.gemoc.executionengine.ccsljava.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionPlatform;

public interface IConcurrentExecutionPlatform extends IExecutionPlatform
{

	/**
	 * return this if this is an IConcurrentExecutionPlatform, null otherwise 
	 * @return
	 */
	IConcurrentExecutionPlatform asConcurrentExecutionPlatform();
	
	Collection<IMSEStateController> getMSEStateControllers();

}
