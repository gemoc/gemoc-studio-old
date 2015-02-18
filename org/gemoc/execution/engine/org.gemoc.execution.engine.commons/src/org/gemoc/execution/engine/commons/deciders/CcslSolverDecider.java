package org.gemoc.execution.engine.commons.deciders;

import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

/**
 * Decider that will delegate its choice to the solver
 *
 */
public class CcslSolverDecider implements ILogicalStepDecider {

	@Override
	public LogicalStep decide(IExecutionEngine engine, List<LogicalStep> possibleLogicalSteps) {
		return engine.getExecutionContext().getExecutionPlatform().getSolver().proposeLogicalStep();
	}

	@Override
	public void dispose() {
		// nothing to do
	}

	@Override
	public void preempt() {
		// not possible
	}
}
