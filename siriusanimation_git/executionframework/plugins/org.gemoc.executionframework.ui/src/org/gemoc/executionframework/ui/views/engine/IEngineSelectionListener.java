package org.gemoc.executionframework.ui.views.engine;

import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;

public interface IEngineSelectionListener {

	/***
	 * Notify when engine is selected by user.
	 * @param engine The selected engine.
	 */
	public void engineSelectionChanged(IExecutionEngine engine);
	
}
