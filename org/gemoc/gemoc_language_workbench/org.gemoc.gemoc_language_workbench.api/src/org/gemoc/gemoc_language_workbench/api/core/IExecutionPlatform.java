package org.gemoc.gemoc_language_workbench.api.core;

import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public interface IExecutionPlatform {

	/**
	 * @return The solver to use for the model execution.
	 */
	Solver getSolver();

	/**
	 * @return The code executor to use for the model execution.
	 */
	ICodeExecutor getCodeExecutor();

	/**
	 * @return The model loader used to load the model to be executed.
	 */
	IModelLoader getModelLoader();

}
