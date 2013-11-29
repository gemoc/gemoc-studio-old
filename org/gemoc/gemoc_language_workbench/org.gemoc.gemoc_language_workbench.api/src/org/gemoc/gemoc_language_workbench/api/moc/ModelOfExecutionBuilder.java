package org.gemoc.gemoc_language_workbench.api.moc;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Service provided by the Solver, which gives the engine the ability to
 * instanciate the Domain-Specific Events specification file down to the Model
 * of Execution level (or Model-Specific Events specification file) using the
 * model, which is the input for the solver.
 * 
 * 
 * @author flatombe
 * 
 */
public interface ModelOfExecutionBuilder {

	/**
	 * 
	 * @param modelResource
	 *            the model that is being executed.
	 * @return a Resource containing the Model of Execution.
	 */
	public Resource build(Resource domainSpecificEventsResource,
			Resource modelResource);
}
