package org.gemoc.execution.engine.io.core.impl;

import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public abstract class BasicFrontend implements Frontend {

	protected GemocExecutionEngine engine;

	@Override
	public void initialize(GemocExecutionEngine engine) {
		this.engine = engine;
	}

}
