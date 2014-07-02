package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.BasicType.Element;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.Block;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockExpressionAndRelation.Expression;
import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.ModelElementReference;
import fr.inria.aoste.trace.TraceFactory;

public abstract class DefaultClockController implements IAliveClockController
{

	private EventInjectionContext _eventInjectionContext;
	
	@Override
	public void initialize(EventInjectionContext context) {
		if (context == null)
			throw new IllegalArgumentException("context");
		_eventInjectionContext = context;
	}

//	@Override
	protected void tick(EventOccurrence eventOccurrence) {
		getSolver().forceEventOccurrence(eventOccurrence);
	}
	
//	@Override
	protected void tick(String eventQualifiedName) {
		EventOccurrence eo = createEventoccurence(eventQualifiedName);
		tick(eo);
	}

//	@Override
	protected void noTick(EventOccurrence eventOccurrence) {
		getSolver().forbidEventOccurrence(eventOccurrence);
	}
	
//	@Override
	protected void noTick(String eventQualifiedName) {
		EventOccurrence eo = createEventoccurence(eventQualifiedName);
		noTick(eo);
	}

	private EventOccurrence createEventoccurence(String eventQualifiedName) {
		String[] splits = eventQualifiedName.split("::");
		
		Block block = _eventInjectionContext.getClockConstraintSystem().getSuperBlock();
		Element mainElement = null;
		if (block.getName().equals(splits[0]))
		{
			for(Element e : block.getElements())
			{
				if (e.getName().equals(splits[1]))
				{
					mainElement = e;
				}
			}
		}
		EventOccurrence eo = TraceFactory.eINSTANCE.createEventOccurrence();
		ModelElementReference mer = TraceFactory.eINSTANCE.createModelElementReference();
		mer.getElementRef().add(_eventInjectionContext.getClockConstraintSystem());
		mer.getElementRef().add(block);
		mer.getElementRef().add(mainElement);
		eo.setReferedElement(mer);
		return eo;
	}

	protected ClockConstraintSystem getClockConstraintSystem()
	{
		return _eventInjectionContext.getClockConstraintSystem();
	}
	
	protected Solver getSolver()
	{
		return _eventInjectionContext.getSolver();
	}
	
}
