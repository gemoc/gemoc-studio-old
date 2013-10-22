package org.gemoc.gemoc_language_workbench.api.moc;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

import fr.inria.aoste.trace.LogicalStep;

/**
 * A Solver is the visible interface of any constraint solver system that runs
 * on the Model of Execution of a model, returns Steps upon requests and
 * provides an API to influence the constraint-solving.
 * 
 * @author flatombe
 */
public interface Solver {
	/**
	 * Forces the underlying MoC structure to forbid the triggering of the given
	 * Domain Specific Event.
	 * 
	 * @param event
	 */
	public void forbidEventOccurrenceReferencing(EObject target,
			EOperation operation);

	/**
	 * Forces the underlying MoC structure to trigger the given Domain Specific
	 * Event.
	 * 
	 * @param event
	 */
	public void forceEventOccurrenceReferencing(EObject target,
			EOperation operation);

	/**
	 * Returns the next step on the MoC's agenda.
	 * 
	 * @return
	 */
	public LogicalStep getNextStep();

	/**
	 * Sets the model of execution (constraints instanciated for the model) for
	 * this solver. We use a file URI to allow different formats.
	 * 
	 * @param modelOfExecutionURI
	 */
	public void setModelOfExecutionFile(URI modelOfExecutionURI);
}
