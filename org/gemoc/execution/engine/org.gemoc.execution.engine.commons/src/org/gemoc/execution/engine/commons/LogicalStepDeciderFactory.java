package org.gemoc.execution.engine.commons;

import org.eclipse.core.runtime.CoreException;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionMode;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtension;
import org.gemoc.gemoc_language_workbench.api.extensions.deciders.DeciderSpecificationExtensionPoint;

public class LogicalStepDeciderFactory {

	public static ILogicalStepDecider createDecider(String deciderKind, ExecutionMode executionMode) throws CoreException 
	{
		ILogicalStepDecider decider = null;
		if (executionMode.equals(ExecutionMode.Run))
		{
			DeciderSpecificationExtension extension = DeciderSpecificationExtensionPoint.findDefinition(RunConfiguration.DECIDER_SOLVER_PROPOSITION);
			decider = extension.instanciateDecider();
		}
		else 
		{
			DeciderSpecificationExtension extension = DeciderSpecificationExtensionPoint.findDefinition(deciderKind);
			decider = extension.instanciateDecider();
		}		
		return decider;
	}
	
}
