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
		
		switch(deciderKind)
		{
			case GemocModelLauncherConfigurationConstants.DECIDER_RANDOM:
				decider = new RandomDecider();
				break;

			case GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER:
				decider = new UserDecider(false);
				break;

			case GemocModelLauncherConfigurationConstants.DECIDER_ASKUSER_STEP_BY_STEP:
				decider = new UserDecider(true);			
				break;

			default:
				if (solver instanceof CcslSolver) {
					// use solver proposition
					decider = new CcslSolverDecider((CcslSolver) solver);
				} else {
					// use random as the only compatible decider
					decider = new RandomDecider();
				}				
				break;
		}
		return decider;
	}
	
}
