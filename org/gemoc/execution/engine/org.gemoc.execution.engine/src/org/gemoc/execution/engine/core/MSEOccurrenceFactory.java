package org.gemoc.execution.engine.core;

import java.util.ArrayList;
import java.util.Collection;

import org.gemoc.gemoc_language_workbench.api.dse.IMSEOccurrence;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.Event;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ActionModel;
import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.LogicalStep;

public class MSEOccurrenceFactory {

	public static IMSEOccurrence createMSEOccurrence(Event event, ActionModel feedbackModel) 
	{
		MSEOccurrence occurrence = null;
		for (ModelSpecificEvent mse : feedbackModel.getEvents())
		{
			if (mse.getName().replace("MSE_", "").equals(event.getName().replace("evt_", "")))
			{
				occurrence = new MSEOccurrence(mse);
				break;
			}
		}
		return occurrence;
	}

	
	public static Collection<IMSEOccurrence> createMSEOccurrences(LogicalStep logicalStep, ActionModel feedbackModel)
	{
		ArrayList<IMSEOccurrence> mseOccurences = new ArrayList<IMSEOccurrence>();
		for (Event event : LogicalStepHelper.getTickedEvents(logicalStep))
		{
			IMSEOccurrence mseOccurrence = MSEOccurrenceFactory.createMSEOccurrence(event, feedbackModel);
			if (mseOccurrence != null)
			{
				mseOccurences.add(mseOccurrence);				
			}
		}
		return mseOccurences;
	}
	
}
