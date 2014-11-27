package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public interface IExecutionPlatform extends IDisposable
{

	/**
	 * @return The solver to use for the model execution.
	 */
	ISolver getSolver();

	/**
	 * @return The code executor to use for the model execution.
	 */
	ICodeExecutor getCodeExecutor();

	/**
	 * @return The model loader used to load the model to be executed.
	 */
	IModelLoader getModelLoader();

	void addEngineAddon(IEngineAddon addon);
	void removeEngineAddon(IEngineAddon addon);
	Iterable<IEngineAddon> getEngineAddons();
	
	Collection<IMSEStateController> getMSEStateControllers();

}
