package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.gemoc.execution.engine.commons.deciders.CcslSolverDecider;
import org.gemoc.execution.engine.commons.deciders.RandomDecider;
import org.gemoc.execution.engine.commons.solvers.ccsl.CcslSolver;
import org.gemoc.execution.engine.io.views.UserDecider;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public class LogicalStepDeciderFactory {

	public static ILogicalStepDecider CreateDecider(String deciderKind, Solver solver) {
		ILogicalStepDecider decider = null;
		if (deciderKind.equals(GemocModelLauncherConfigurationConstants.DECIDER_RANDOM)) {
			decider = new RandomDecider();
		} else if (deciderKind.equals(GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER)) {
			// use random as the only compatible decider
			decider = new UserDecider(false);
			
		} else if (deciderKind.equals(GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER_STEP_BY_STEP)) {
			// use random as the only compatible decider
			decider = new UserDecider(true);			
		} else 	{
			if (solver instanceof CcslSolver) {
				// use solver proposition
				decider = new CcslSolverDecider((CcslSolver) solver);
			} else {
				// use random as the only compatible decider
				decider = new RandomDecider();
			}			
		}
		return decider;
	}
	
}
