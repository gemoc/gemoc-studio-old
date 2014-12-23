package org.gemoc.execution.engine.commons;

import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingHook;
import org.gemoc.execution.engine.core.AbstractExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public class CCSLExecutionEngine extends AbstractExecutionEngine {

	public CCSLExecutionEngine(ModelExecutionContext executionContext) {
		super(executionContext);
		if (getExecutionContext().getRunConfiguration().isTraceActive())
		{
			IEngineAddon traceHook = new ModelExecutionTracingHook();
			getExecutionContext().getExecutionPlatform().addEngineAddon(traceHook);						
		}

	}

}
