package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public interface IExecutionContext extends IDisposable
{

	IExecutionWorkspace getWorkspace();

	IExecutionPlatform getExecutionPlatform();
	
	Collection<IEngineHook> getHooks();
	
	Collection<IMSEStateController> getMSEStateControllers();

	IRunConfiguration getRunConfiguration();

	Resource getResourceModel();

	ExecutionMode getExecutionMode();

	ActionModel getFeedbackModel();
	
	String getQVTOPath();

}
