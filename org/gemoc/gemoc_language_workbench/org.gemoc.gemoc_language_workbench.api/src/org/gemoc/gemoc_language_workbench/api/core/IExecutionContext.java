package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public interface IExecutionContext extends IDisposable
{

	IExecutionWorkspace getWorkspace();
	
	/**
	 * 
	 * @return The solver to use for the model execution.
	 */
	Solver getSolver();

	/**
	 * 
	 * @return The code executor to use for the model execution.
	 */
	ICodeExecutor getCodeExecutor();
		
	Collection<IEngineHook> getHooks();
	
	Collection<IMSEStateController> getMSEStateControllers();

	IRunConfiguration getRunConfiguration();

	Resource getResourceModel();

	ExecutionMode getExecutionMode();

	ActionModel getFeedbackModel();
	
	IModelLoader getModelLoader();

	String getQVTOPath();
}
