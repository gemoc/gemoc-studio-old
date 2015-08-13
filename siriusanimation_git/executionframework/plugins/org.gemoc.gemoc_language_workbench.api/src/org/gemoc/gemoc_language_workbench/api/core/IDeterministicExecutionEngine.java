package org.gemoc.gemoc_language_workbench.api.core;

import java.util.Deque;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

public interface IDeterministicExecutionEngine extends IExecutionEngine {

	public Runnable getEntryPoint();

	public Deque<MSEOccurrence> getCurrentStack();

	public MSEOccurrence getCurrentMSEOccurrence();

	public void addStackListener(IStackListener stackListener);
}
