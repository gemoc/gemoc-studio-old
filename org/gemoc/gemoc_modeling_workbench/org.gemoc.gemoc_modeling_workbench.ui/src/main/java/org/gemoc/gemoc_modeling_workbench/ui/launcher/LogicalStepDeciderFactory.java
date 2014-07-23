package org.gemoc.gemoc_modeling_workbench.ui.launcher;

import org.gemoc.execution.engine.commons.deciders.CcslSolverDecider;
import org.gemoc.execution.engine.commons.deciders.RandomDecider;
import org.gemoc.execution.engine.core.RunConfiguration;
import org.gemoc.execution.engine.io.views.StepByStepUserDecider;
import org.gemoc.execution.engine.io.views.UserDecider;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

public class LogicalStepDeciderFactory {

	public static ILogicalStepDecider createDecider(String deciderKind, Solver solver) {
		ILogicalStepDecider decider = null;
		
		switch(deciderKind)
		{
			case RunConfiguration.DECIDER_RANDOM:
				decider = new RandomDecider();
				break;

			case RunConfiguration.DECIDER_ASKUSER:
				decider = new UserDecider();
				break;

			case RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP:
				decider = new StepByStepUserDecider();			
				break;

			case RunConfiguration.DECIDER_SOLVER_PROPOSITION:
				decider = new CcslSolverDecider();
				break;

			default:
				decider = new CcslSolverDecider();
				break;
		}
		return decider;
	}
	
}
