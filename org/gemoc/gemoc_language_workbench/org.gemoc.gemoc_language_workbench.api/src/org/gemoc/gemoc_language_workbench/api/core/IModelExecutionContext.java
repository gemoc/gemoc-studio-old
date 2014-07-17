package org.gemoc.gemoc_language_workbench.api.core;

import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public interface IModelExecutionContext {

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

}
