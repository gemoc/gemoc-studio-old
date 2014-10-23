package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;

public interface IExecutionContext extends IDisposable
{

	public IExecutionWorkspace getWorkspace();
	
	/**
	 * 
	 * @return The solver to use for the model execution.
	 */
	public Solver getSolver();

	/**
	 * 
	 * @return The code executor to use for the model execution.
	 */
	public ICodeExecutor getCodeExecutor();
		
	public Collection<IEngineHook> getHooks();
	
	public Collection<IMSEStateController> getMSEStateControllers();

	public IRunConfiguration getRunConfiguration();

	public IPath getDebuggerViewModelPath();

	public TransactionalEditingDomain getEditingDomain();

	public Resource getResourceModel();

	public ExecutionMode getExecutionMode();

	public ActionModel getFeedbackModel();
}
