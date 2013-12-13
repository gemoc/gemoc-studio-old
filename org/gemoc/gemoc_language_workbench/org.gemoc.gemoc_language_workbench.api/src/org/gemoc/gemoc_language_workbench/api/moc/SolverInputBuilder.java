package org.gemoc.gemoc_language_workbench.api.moc;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Service provided by the Solver, which gives the engine the ability to create
 * a correct input for the solver from the Model-Specific Events (Model of
 * Execution).
 * 
 * @author flatombe
 * 
 */
public interface SolverInputBuilder {

	/**
	 * 
	 * @param modelOfExecutionResource
	 *            the model of execution being executed.
	 * @return a Resource containing the input for the associated solver.
	 */
	public Resource build(Resource modelOfExecutionResource);
}
