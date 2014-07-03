package org.gemoc.gemoc_language_workbench.api.core;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

/**
 * The interface of the GEMOC Execution Engine. The Execution Engine is an
 * entity able to execute models conforming to an xDSML as defined in the GEMOC
 * ANR INS project. This API allows the caller to initialize the engine for a
 * given model, and to run the engine in different ways. It also allows the
 * caller to influence the constraints of the MoC at runtime.
 * 
 * @author didier.vojtisek@inria.fr
 * 
 */
public interface GemocExecutionEngine extends GemocExecutionEngineRunControl, GemocExecutionEngineEventControl {

	/** --------------- Initialization --------------- **/
	/**
	 * While the constructor of the engine initializes the engine with the
	 * components used for the whole LANGUAGE, this method initializes the
	 * engine for a given model conforming to the language used, most notably by
	 * loading the model (using the given ModelLoader), creating the Model Of
	 * Execution (Model Specific Events) and the Solver Input.
	 * 
	 * @param resource
	 *            the {@link Resource} containing the model to execute.
	 */
	//void initialize(Resource resource);

	/**
	 * Retrieve the model being executed.
	 * 
	 * @return the EMF Resource corresponding to the model being executed.
	 */
	public Resource getModelUnderExecutionResource();
	
	public ILogicalStepDecider getLogicalStepDecider();
	
	/**
	 * allows to add a  hook to the engine
	 * @param newEngineHook
	 */
	public void addEngineHook(IEngineHook newEngineHook);
	
	/**
	 * allows to remove a hook to the engine
	 * @param removedEngineHook
	 */
	public void removeEngineHook(IEngineHook removedEngineHook);


	/**
	 * Sets the delay to wait in millisecond between each logical step.
	 * 
	 * @param delay
	 *            the delay in millisecond
	 */
	void setDelay(int delay);

	void initialize(Resource resource, TransactionalEditingDomain editingDomain);

	public ExecutionTraceModel getExecutionTrace();

	/**
	 * 
	 * @param type
	 * @return true if the engine has the capability, false otherwise.
	 */
	public <T extends IExecutionEngineCapability> boolean hasCapability(Class<T> type);
	/**
	 * 
	 * @param type
	 * @return The capability of the given type if it exists.
	 */
	public <T extends IExecutionEngineCapability> T getCapability(Class<T> type);
	/**
	 * Get the capability of the given type.
	 * If it does not exist, it creates it.
	 * @param type
	 * @return The capability of the given type.
	 */
	public <T extends IExecutionEngineCapability> T capability(Class<T> type);

	public Solver getSolver();

	public CodeExecutor getCodeExecutor();
	
}
