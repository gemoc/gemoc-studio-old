package org.gemoc.gemoc_language_workbench.api.core;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;

public interface IDisposable {

	/**
	 * Dispose the acquired resources.
	 */
	void dispose();
	
}
