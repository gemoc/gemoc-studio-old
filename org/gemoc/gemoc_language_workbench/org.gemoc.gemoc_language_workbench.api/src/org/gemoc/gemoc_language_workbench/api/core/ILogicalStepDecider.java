package org.gemoc.gemoc_language_workbench.api.core;

import java.util.List;

import fr.inria.aoste.trace.LogicalStep;

/**
 * allows to choose a LogicalStep among possible ones  
 * @author dvojtise
 *
 */
public interface ILogicalStepDecider {
	/**
	 * 
	 * @param possibleLogicalSteps
	 * @return The index of the selected logical step, -1 if no logical step selected.
	 */
	public int decide(List<LogicalStep> possibleLogicalSteps)  throws InterruptedException;
	
	/**
	 * decider no longer used, (probably because the engine has been asked to stop)
	 */
	public void dispose();

	/**
	 * Stop the decision making in progress.
	 * This should result in no chosen logical step.
	 * Has no effect if no decision making is in progress.
	 */
	public void preempt();
}
