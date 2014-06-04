package org.gemoc.gemoc_language_workbench.api.moc;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;

/**
 * A Solver is the visible interface of any constraint solver system that runs
 * on its corresponding input based on a Model of Execution, returns Steps upon
 * requests and provides an API to influence the constraint-solving.
 * 
 * The steps it returns are based on the trace metamodel fr.inria.aoste.trace.
 * 
 * @author flatombe
 */
public interface Solver {
	/**
	 * Forces the underlying MoC structure to forbid the given EventOccurrence
	 * from ticking in the next step.
	 */
	public void forbidEventOccurrence(EventOccurrence eventOccurrence);

	/**
	 * Forces the underlying MoC structure to force the given EventOccurrence to
	 * tick in the next step.
	 */
	public void forceEventOccurrence(EventOccurrence eventOccurrence);

	/**
	 * Returns the Step that the solver has proposed and applied.
	 * This is equivalent to
	 * 		applyLogicalStepByIndex(getPossibleLogicalSteps().get(proposeLogicalStepByIndex()))
	 * @return a LogicalStep conforming to the (fr.inria.aoste.trace) scheduling
	 *         trace metamodel.
	 */
	public LogicalStep getNextStep();
	
	/**
	 * Returns the currently possible LogicalSteps
	 * @return a list of LogicalSteps
	 */
	public List<LogicalStep> getPossibleLogicalSteps();
	
	/**
	 * among the currently possible LogicalStep (see {@link getPossibleLogicalSteps} ), asks the solver to choose one
	 * @return the index of the proposed LogicalStep from possible LogicalSteps 
	 */
	public int proposeLogicalStepByIndex();
	
	/**
	 * ask the solver to apply the LogicalStep from possibleLogicalSteps and thus compute next step
	 * @param indexOfStepToApply
	 */
	public void applyLogicalStepByIndex(int indexOfStepToApply);

	

//	/**
//	 * Returns the facility that allows the Execution Engine to create an input
//	 * acceptable for the solver based on the Model-Specific Events file.
//	 * 
//	 * @return the SolverInputBuilder for this solver.
//	 */
	//public SolverInputBuilder getSolverInputBuilder();

//	/**
//	 * allows to define manually the facility that allows the Execution Engine to create an input
//	 * acceptable for the solver based on the Model-Specific Events file.
//	 * @param solverInputBuilder
//	 */
	//public void setSolverInputBuilder(SolverInputBuilder solverInputBuilder);
	
	
	public URI prepareSolverInputFileForUserModel(URI userModelURI);
	
	public boolean isSolverInputFileReadyForUserModel(URI userModelURI);
	
	/**
	 * Sets the input (constraints instanciated for the model) for this solver.
	 * We use a file URI to allow different formats.
	 * @param rs 
	 * 
	 * @param solverInputURI
	 */
	public void setSolverInputFile(ResourceSet rs, URI solverInputURI);

//	/**
//	 * Returns the instance of MocEvent for the EObject target. The Solver (or
//	 * its SolverInputBuilder more precisely) being responsible for
//	 * instanciating the Moc Events down to the model level, but this mapping
//	 * not being explicitly appearing in the trace metamodel, this method allows
//	 * us to keep track of this mapping.
//	 * 
//	 * @param mocEvent
//	 * @param target
//	 * @return
//	 */
//	public EventOccurrence getCorrespondingEventOccurrence(MocEvent mocEvent,
//			EObject target);
//
//	/**
//	 * Creates a registry which represents the mapping between a MocEvent and
//	 * its "name" (string representation...). Used for the feedback at the
//	 * Moc-event level since the feedback specification does not know of the Moc
//	 * Event implementation thus does not know if it really has a name. So this
//	 * registry is there to make sure we can somehow still create references to
//	 * these Moc Events.
//	 * 
//	 * @param mocEventsResource
//	 * @return
//	 */
//	public Map<String, MocEvent> createMocEventsRegistry(
//			Resource mocEventsResource);

	/**
	 * Gets the state of the solver at a given execution step.
	 * @return
	 */
	public byte[] getState();

	/**
	 * Sets the state of the solver as it was at a given step.
	 * @param serializableModel
	 */
	public void setState(byte[] serializableModel);
}
