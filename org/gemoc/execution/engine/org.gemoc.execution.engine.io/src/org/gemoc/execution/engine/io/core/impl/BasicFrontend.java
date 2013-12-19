package org.gemoc.execution.engine.io.core.impl;

import org.gemoc.execution.engine.io.core.Frontend;
import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;

public abstract class BasicFrontend implements Frontend {

	protected ExecutionEngine engine;

	@Override
	public void initialize(ExecutionEngine engine) {
		this.engine = engine;
	}

}
