package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.MSEExecutionContext;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEOccurrence;

public class MSEOccurrenceFactory {
	
	public static Collection<IMSEOccurrence> createMSEOccurrences(LogicalStep logicalStep)
	{
		ArrayList<IMSEOccurrence> mseOccurences = new ArrayList<IMSEOccurrence>();
		for (MSEExecutionContext context : logicalStep.getEventExecutionContexts())
		{
			IMSEOccurrence mseOccurrence = new MSEOccurrence(context);
			if (mseOccurrence != null)
			{
				mseOccurences.add(mseOccurrence);				
			}
		}
		return mseOccurences;
	}
	
}
