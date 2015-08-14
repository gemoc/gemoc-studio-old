package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.extensions.languages.LanguageDefinitionExtension;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public interface IExecutionContext extends IDisposable
{

	LanguageDefinitionExtension getLanguageDefinitionExtension();
	
	IExecutionWorkspace getWorkspace();

	IExecutionPlatform getExecutionPlatform();
	
	IRunConfiguration getRunConfiguration();

	Resource getResourceModel();

	ExecutionMode getExecutionMode();

	ActionModel getFeedbackModel();

	// moved to IExecutionContext
	//ILogicalStepDecider getLogicalStepDecider();
	 
}
