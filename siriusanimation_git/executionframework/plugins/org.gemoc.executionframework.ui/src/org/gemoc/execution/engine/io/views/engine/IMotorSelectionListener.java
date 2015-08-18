package org.gemoc.execution.engine.io.views.engine;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public interface IMotorSelectionListener {

	/***
	 * Notify when engine is selected by user.
	 * @param engine The selected engine.
	 */
	public void motorSelectionChanged(IExecutionEngine engine);
	
}
