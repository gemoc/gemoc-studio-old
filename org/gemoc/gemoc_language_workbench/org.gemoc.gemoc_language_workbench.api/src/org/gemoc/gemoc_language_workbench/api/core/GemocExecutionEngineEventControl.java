package org.gemoc.gemoc_language_workbench.api.core;

import glml.DomainSpecificEvent;
import glml.MocEvent;
import glml.ModelSpecificEvent;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/** Part of the ExecutionEngine API that  allows the
* caller to influence the constraints of the MoC at runtime.

* */
public interface GemocExecutionEngineEventControl {

	/**
	 * Retrieve the Domain-Specific Events of the language.
	 * 
	 * @return the collection of DomainSpecificEvents for the language of the
	 *         model being executed.
	 */
	public Collection<DomainSpecificEvent> getDomainSpecificEvents();

	/**
	 * Retrieve the Model-Specific Events of the model being executed.
	 * 
	 * @return
	 */
	public Collection<ModelSpecificEvent> getModelSpecificEvents();

	/**
	 * Returns the ModelSpecificEvent corresponding to the given couple of DSE
	 * and target.
	 * 
	 * @param dse
	 * @param target
	 * @return
	 */
	public ModelSpecificEvent getCorrespondingModelSpecificEvent(
			DomainSpecificEvent dse, EObject target);

	/**
	 * Returns the map between the MoC Events and their String representation.
	 * 
	 * @return
	 */
	public Map<String, MocEvent> getMocEventsRegistry();

	/**
	 * Retrieve the model being executed.
	 * 
	 * @return the EMF Resource corresponding to the model being executed.
	 */
	public Resource getModelResource();

//	/**
//	 * Inject an event.
//	 * 
//	 * @param dse
//	 * @param target
//	 */
//	public void injectEvent(DomainSpecificEvent dse, EObject target)
//			throws EventInjectionException;

	/**
	 * Query to retrieve the MSEs which can be triggered by the user, in no
	 * particular order.
	 * 
	 * @return the collection of ModelSpecificEvents which can be triggered by
	 *         the user.
	 */
	public Collection<ModelSpecificEvent> getCurrentPossibleEvents();

	/** --------------- Influence the MoC Constraints --------------- **/
	/**
	 * 
	 * Forces the solver to arrange its internals so as to create an occurrence
	 * of the given MSE at the next round.
	 * 
	 * TODO: There should be some exception thrown if by undoing the MSE's
	 * pattern we detect that this MSE just cannot be triggered.
	 */
	public void forceModelSpecificEventOccurrence(ModelSpecificEvent mse);

	/**
	 * Forces the solver to arrange its internals so as to forbid an occurrence
	 * of the given MSE at the next round.
	 * 
	 * TODO: There should be some exception thrown if by undoing the MSE's
	 * pattern we detect that forbidding this MSE is impossible.
	 */
	public void forbidModelSpecificEventOccurrence(ModelSpecificEvent mse);

	/**
	 * Moc-event level Feedback to force a specific instance of MoCEvent to
	 * occur at the next step.
	 * 
	 * @param mocEvent
	 * @param target
	 */
	public void forceMocEventOccurrence(MocEvent mocEvent, EObject target);

	/**
	 * Moc-event level Feedback to force a specific instance of MoCEvent to NOT
	 * occur at the next step.
	 * 
	 * @param mocEvent
	 * @param target
	 */
	public void forbidMocEventOccurrence(MocEvent mocEvent, EObject target);

}
