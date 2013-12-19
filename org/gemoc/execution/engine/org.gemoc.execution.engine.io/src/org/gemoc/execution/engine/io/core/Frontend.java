package org.gemoc.execution.engine.io.core;

import org.gemoc.gemoc_language_workbench.api.core.ExecutionEngine;

/**
 * A ControlPanel implements a GUI that makes use of the ExecutionEngine API.
 * 
 * @author flatombe
 * 
 */
public interface Frontend {

	public void initialize(ExecutionEngine engine);

}
