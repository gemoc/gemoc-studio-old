package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public class EventInjectionContext 
{

	private Solver _solver;
	private ClockConstraintSystem _clockConstraintSystem;

	public EventInjectionContext(Solver solver, ClockConstraintSystem clockConstraintSystem)
	{
		if (solver == null)
			throw new IllegalArgumentException("solver");
		_solver = solver;
		if (clockConstraintSystem == null)
			throw new IllegalArgumentException("clockConstraintSystem");
		_clockConstraintSystem = clockConstraintSystem;
	}	
	
	public ClockConstraintSystem getClockConstraintSystem()
	{
		return _clockConstraintSystem;
	}
	
	public Solver getSolver()
	{
		return _solver;
	}
	
}
