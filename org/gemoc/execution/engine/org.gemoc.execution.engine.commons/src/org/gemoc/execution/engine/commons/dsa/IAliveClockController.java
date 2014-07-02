package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;

public interface IAliveClockController extends IClockController
{

	void initialize(EventInjectionContext context);

	void start();
	
	void stop();
	
}
