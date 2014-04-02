package org.gemoc.execution.engine.commons.deciders;

import java.util.List;

import org.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

/**
 * Decider that will delegate its choice to the solver
 *
 */
public class CcslSolverDecider implements ILogicalStepDecider {

	protected CcslSolver solver;
	
	public CcslSolverDecider(CcslSolver solver) {
		super();
		this.solver = solver;
	}

	@Override
	public int decide(List<LogicalStep> possibleLogicalSteps) {
		return solver.proposeLogicalStepByIndex();
	}

}
