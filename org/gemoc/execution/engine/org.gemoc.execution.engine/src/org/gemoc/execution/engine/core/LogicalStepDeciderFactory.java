package org.gemoc.execution.engine.core;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtensionPoint;

public class LogicalStepDeciderFactory {

	public static ILogicalStepDecider createDecider(String deciderKind, ExecutionMode executionMode) throws CoreException {
		ILogicalStepDecider decider = null;

		if (executionMode.equals(ExecutionMode.Run))
		{
			DeciderSpecificationExtension extension = DeciderSpecificationExtensionPoint.findDefinition(RunConfiguration.DECIDER_SOLVER_PROPOSITION);
			decider = extension.instanciateDecider();
			//decider = new CcslSolverDecider();			
		}
		else 
		{
			DeciderSpecificationExtension extension = DeciderSpecificationExtensionPoint.findDefinition(deciderKind);
			decider = extension.instanciateDecider();
//			switch(deciderKind)
//			{
//				case RunConfiguration.DECIDER_RANDOM:
//					decider = new RandomDecider();
//					break;
//
//				case RunConfiguration.DECIDER_ASKUSER:
//					decider = new UserDecider();
//					break;
//
//				case RunConfiguration.DECIDER_ASKUSER_STEP_BY_STEP:
//					decider = new StepByStepUserDecider();			
//					break;
//
//				case RunConfiguration.DECIDER_SOLVER_PROPOSITION:
//					decider = new CcslSolverDecider();
//					break;
//
//				default:
//					decider = new CcslSolverDecider();
//					break;
//			}			
		}		
		return decider;
	}
	
}
