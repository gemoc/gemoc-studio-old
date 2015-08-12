package org.gemoc.gemoc_language_workbench.api.core;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

public interface IStackListener {

	public void notifyPushMSEOccurrence(MSEOccurrence mseOccurrence);

	public void notifyPopMSEOccurrence(MSEOccurrence mseOccurrence);

}
