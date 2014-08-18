package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.EventExecutor;
import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;
import org.gemoc.gemoc_language_workbench.api.feedback.FeedbackPolicy;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

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
	public CodeExecutor getCodeExecutor();
	
	public EventExecutor getEventExecutor();
	
	public Collection<IEngineHook> getHooks();
	
	public FeedbackPolicy getFeedbackPolicy();

	public Collection<IClockController> getClockControllers();

	public IRunConfiguration getRunConfiguration();

	public IPath getDebuggerViewModelPath();

	public TransactionalEditingDomain getEditingDomain();

	public Resource getResourceModel();

}
