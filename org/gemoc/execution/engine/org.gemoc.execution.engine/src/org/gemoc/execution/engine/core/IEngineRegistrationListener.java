package org.gemoc.execution.engine.core;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public interface IEngineRegistrationListener {

	void engineRegistered(GemocExecutionEngine engine);

	void engineUnregistered(GemocExecutionEngine engine);
	
}
