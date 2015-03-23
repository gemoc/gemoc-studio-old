package org.gemoc.execution.engine.core;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEOccurrence;

public interface IMSEOccurrenceListener 
{

	void mseOccurenceRaised(MSEOccurrence occurrence);

	void mseOccurenceAboutToBeRaised(MSEOccurrence occurrence);
	
}
