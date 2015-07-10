package org.gemoc.gemoc_language_workbench.api.moc;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;

/**
 * A Solver is the visible interface of any constraint solver system that runs
 * on its corresponding input based on a Model of Execution, returns Steps upon
 * requests and provides an API to influence the constraint-solving.
 * 
 * The steps it returns are based on the trace metamodel fr.inria.aoste.trace.
 * 
 * @author flatombe
 */
public interface ISolver extends IDisposable {
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
	 * Returns the currently possible LogicalSteps
	 * @return a list of LogicalSteps
	 */
	public List<LogicalStep> computeAndGetPossibleLogicalSteps();
	
	/**
	 * Returns the currently possible LogicalSteps
	 * @return a list of LogicalSteps
	 */
	public List<LogicalStep> updatePossibleLogicalSteps();
	
	/**
	 * among the currently possible LogicalStep (see {@link getPossibleLogicalSteps} ), asks the solver to choose one
	 * @return the logical step proposed from possible LogicalSteps 
	 */
	public LogicalStep proposeLogicalStep();
	
	/**
	 * ask the solver to apply the given LogicalStep and thus compute next step
	 * @param the LogicalStep to apply
	 */
	public void applyLogicalStep(LogicalStep logicalStep);


	public ArrayList<ModelElementReference> getAllDiscreteClocks();
	
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

	public void revertForceClockEffect();

	public void setUp(IExecutionContext context);
}
