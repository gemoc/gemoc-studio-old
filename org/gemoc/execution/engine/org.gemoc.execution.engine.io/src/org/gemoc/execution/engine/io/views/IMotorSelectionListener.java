package org.gemoc.execution.engine.io.views;

import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;

public interface IMotorSelectionListener {

	/***
	 * Notify when engine is selected by user.
	 * @param engine The selected engine.
	 */
	public void motorSelectionChanged(GemocExecutionEngine engine);
	
}
