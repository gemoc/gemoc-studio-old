package org.gemoc.executionengine.ccsljava.api.core;

import org.gemoc.executionengine.ccsljava.api.extensions.languages.ConcurrentLanguageDefinitionExtension;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

public interface IConcurrentExecutionContext extends IExecutionContext
{
	ConcurrentLanguageDefinitionExtension getConcurrentLanguageDefinitionExtension();
	IConcurrentExecutionPlatform getConcurrentExecutionPlatform();
	ILogicalStepDecider getLogicalStepDecider();
	 
}
