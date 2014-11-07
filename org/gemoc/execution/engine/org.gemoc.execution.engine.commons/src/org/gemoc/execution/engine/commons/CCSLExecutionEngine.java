package org.gemoc.execution.engine.commons;

import org.gemoc.execution.engine.commons.dsa.DefaultMSEStateController;
import org.gemoc.execution.engine.core.ModelExecutionContext;
import org.gemoc.execution.engine.core.ObservableBasicExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;

public class CCSLExecutionEngine extends ObservableBasicExecutionEngine {

	public CCSLExecutionEngine(ModelExecutionContext executionContext) {
		super(executionContext);
	}

	@Override
	protected IMSEStateController createEngineMSEStateController() 
	{
		return new DefaultMSEStateController();
	}

}
