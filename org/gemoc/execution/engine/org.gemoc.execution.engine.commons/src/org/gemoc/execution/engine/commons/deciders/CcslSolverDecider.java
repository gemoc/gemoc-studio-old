package org.gemoc.execution.engine.commons.deciders;

import java.util.List;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

/**
 * Decider that will delegate its choice to the solver
 *
 */
public class CcslSolverDecider implements ILogicalStepDecider {

	@Override
	public int decide(GemocExecutionEngine engine, List<LogicalStep> possibleLogicalSteps) {
		return engine.getExecutionContext().getExecutionPlatform().getSolver().proposeLogicalStepByIndex();
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
