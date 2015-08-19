package org.gemoc.gemoc_modeling_workbench.ui.debug;

import java.util.function.BiPredicate;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;

public interface IGemocDebugger extends IEngineAddon {

	public abstract void addPredicateBreak(BiPredicate<IExecutionEngine, MSEOccurrence> predicate);

	public abstract void addPredicateBreakpoint(BiPredicate<IExecutionEngine, MSEOccurrence> predicate);

}
