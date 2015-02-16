package org.gemoc.execution.engine.commons;

import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingAddon;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public class ExecutionEngine extends AbstractExecutionEngine {

	public ExecutionEngine(ModelExecutionContext executionContext) {
		super(executionContext);
		if (getExecutionContext().getRunConfiguration().isTraceActive())
		{
			IEngineAddon traceHook = new ModelExecutionTracingAddon();
			getExecutionContext().getExecutionPlatform().addEngineAddon(traceHook);						
		}

	}

}
