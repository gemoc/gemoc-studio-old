package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class EventInjectionContext 
{

	private Solver _solver;

	public EventInjectionContext(Solver solver)
	{
		if (solver == null)
			throw new IllegalArgumentException("solver");
		_solver = solver;
	}	
	
	public Solver getSolver()
	{
		return _solver;
	}
	
}
