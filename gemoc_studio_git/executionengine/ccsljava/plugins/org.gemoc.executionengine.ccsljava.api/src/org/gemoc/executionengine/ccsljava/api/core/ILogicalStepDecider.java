package org.gemoc.executionengine.ccsljava.api.core;

import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IDisposable;


/**
 * allows to choose a LogicalStep among possible ones  
 * @author dvojtise
 *
 */
public interface ILogicalStepDecider extends IDisposable
{
	/**
	 * 
	 * @param possibleLogicalSteps
	 * @return The index of the selected logical step, -1 if no logical step selected.
	 */
	LogicalStep decide(INonDeterministicExecutionEngine engine, List<LogicalStep> possibleLogicalSteps)  throws InterruptedException;
	
	/**
	 * Stop the decision making in progress.
	 * This should result in no chosen logical step.
	 * Has no effect if no decision making is in progress.
	 */
	void preempt();
	
}
