package org.gemoc.execution.engine.dse;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class DefaultMSEStateController implements IMSEStateController
{

	private void applyForcePresence(ISolver solver, EventOccurrence eventOccurrence) 
	{
		solver.forceEventOccurrence(eventOccurrence);
	}
	
	private void applyForceAbsence(ISolver solver, EventOccurrence eventOccurrence) 
	{
		solver.forbidEventOccurrence(eventOccurrence);
	}
	
	private EventOccurrence createEventoccurence(ModelSpecificEvent mse) 
	{
		EventOccurrence eo = TraceFactory.eINSTANCE.createEventOccurrence();
		ModelElementReference mer = TraceFactory.eINSTANCE.createModelElementReference();
		mer.getElementRef().add(mse.getSolverEvent().eContainer().eContainer());
		mer.getElementRef().add(mse.getSolverEvent().eContainer());
		mer.getElementRef().add(mse.getSolverEvent());
		eo.setReferedElement(mer);
		return eo;
	}

	public void applyMSEFutureStates(ISolver solver) 
	{
		for(Entry<ModelSpecificEvent, Boolean> entry : _mseNextStates.entrySet())
		{
			EventOccurrence eo = createEventoccurence(entry.getKey());
			if (entry.getValue())
			{
				applyForcePresence(solver, eo);
			}
			else
			{
				applyForceAbsence(solver, eo);				
			}
		}
	}

	private Map<ModelSpecificEvent, Boolean> _mseNextStates = new HashMap<ModelSpecificEvent, Boolean>();
	
	@Override
	public void forcePresenceInTheFuture(ModelSpecificEvent mse)
	{
		setFutureClockState(mse, true);
	}

	@Override
	public void forceAbsenceTickInTheFuture(ModelSpecificEvent mse)
	{
		setFutureClockState(mse, false);		
	}

	private void setFutureClockState(ModelSpecificEvent mse, Boolean willTick)
	{
		_mseNextStates.put(mse, willTick);		
	}
	
	public void freeInTheFuture(ModelSpecificEvent mse)
	{
		_mseNextStates.remove(mse);
	}
	
}
