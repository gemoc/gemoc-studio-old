package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.resource.Resource;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public interface IExecutionContext extends IDisposable
{

	IExecutionWorkspace getWorkspace();

	IExecutionPlatform getExecutionPlatform();
	
	IRunConfiguration getRunConfiguration();

	Resource getResourceModel();

	ExecutionMode getExecutionMode();

	ActionModel getFeedbackModel();
	
	String getQVTOPath();

}
