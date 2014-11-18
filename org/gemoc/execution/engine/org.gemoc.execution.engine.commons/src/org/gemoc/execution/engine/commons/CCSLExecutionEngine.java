package org.gemoc.execution.engine.commons;

import org.gemoc.execution.engine.commons.dsa.DefaultMSEStateController;
import org.gemoc.execution.engine.commons.trace.ModelExecutionTracingHook;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IEngineHook;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

public class CCSLExecutionEngine extends ObservableBasicExecutionEngine {

	public CCSLExecutionEngine(ModelExecutionContext executionContext) {
		super(executionContext);
		if (getExecutionContext().getRunConfiguration().isTraceActive())
		{
			IEngineHook traceHook = new ModelExecutionTracingHook();
			getExecutionContext().getExecutionPlatform().getHooks().add(traceHook);						
		}

	}

	@Override
	protected IMSEStateController createEngineMSEStateController() 
	{
		return new DefaultMSEStateController();
	}

}
