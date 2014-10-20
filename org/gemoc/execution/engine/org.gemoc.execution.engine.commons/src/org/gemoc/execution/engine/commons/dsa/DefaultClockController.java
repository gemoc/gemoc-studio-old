package org.gemoc.execution.engine.commons.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public class DefaultClockController implements IAliveClockController
{

	private EventInjectionContext _eventInjectionContext;
	
	@Override
	public void initialize(EventInjectionContext context) {
		if (context == null)
			throw new IllegalArgumentException("context");
		_eventInjectionContext = context;
	}
//
//	private String getMSEQualifiedName(ModelSpecificEvent mse) 
//	{
//		Clock c = (Clock)mse.getSolverEvent();
//		Block block = (Block)c.eContainer();
//		String result = block.getName();
//		result += "::";
//		result += c.getName();
//		return result;
//	}
	
//	@Override
	protected void tick(EventOccurrence eventOccurrence) {
		getSolver().forceEventOccurrence(eventOccurrence);
	}
	
//	@Override
	protected void tick(ModelSpecificEvent mse) {
		EventOccurrence eo = createEventoccurence(mse);
		tick(eo);
	}

//	@Override
	protected void noTick(EventOccurrence eventOccurrence) {
		getSolver().forbidEventOccurrence(eventOccurrence);
	}
	
//	@Override
	protected void noTick(ModelSpecificEvent mse) {
		EventOccurrence eo = createEventoccurence(mse);
		noTick(eo);
	}

	private EventOccurrence createEventoccurence(ModelSpecificEvent mse) {
		EventOccurrence eo = TraceFactory.eINSTANCE.createEventOccurrence();
		ModelElementReference mer = TraceFactory.eINSTANCE.createModelElementReference();

		mer.getElementRef().add(mse.getSolverEvent().eContainer().eContainer());
		mer.getElementRef().add(mse.getSolverEvent().eContainer());
		mer.getElementRef().add(mse.getSolverEvent());
		
//		mer.getElementRef().add(_eventInjectionContext.getClockConstraintSystem());
//		mer.getElementRef().add(block);
//		mer.getElementRef().add(mainElement);
		eo.setReferedElement(mer);
		return eo;
	}

//	protected ClockConstraintSystem getClockConstraintSystem()
//	{
//		return _eventInjectionContext.getClockConstraintSystem();
//	}
	
	protected Solver getSolver()
	{
		return _eventInjectionContext.getSolver();
	}
	
	@Override
	public void makeClocksTickOrNotTick() 
	{
		for(Entry<ModelSpecificEvent, Boolean> entry : _mseNextStates.entrySet())
		{
			if (entry.getValue())
			{
				tick(entry.getKey());
			}
			else
			{
				noTick(entry.getKey());				
			}
		}
	}

	private Map<ModelSpecificEvent, Boolean> _mseNextStates = new HashMap<ModelSpecificEvent, Boolean>();
	
	@Override
	public void tickInTheFuture(ModelSpecificEvent mse)
	{
		setFutureClockState(mse, true);
	}

	@Override
	public void doNotTickInTheFuture(ModelSpecificEvent mse)
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

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}
