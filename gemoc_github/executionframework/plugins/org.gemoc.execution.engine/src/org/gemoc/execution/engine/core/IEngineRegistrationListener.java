package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public interface IEngineRegistrationListener {

	void engineRegistered(IExecutionEngine engine);

	void engineUnregistered(IExecutionEngine engine);
	
}
