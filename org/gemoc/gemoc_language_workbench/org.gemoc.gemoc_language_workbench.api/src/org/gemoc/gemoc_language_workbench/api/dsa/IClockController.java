package org.gemoc.gemoc_language_workbench.api.dsa;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;



public interface IClockController
{

	void makeClocksTickOrNotTick();
	public void tickInTheFuture(ModelSpecificEvent mse);
	public void doNotTickInTheFuture(ModelSpecificEvent mse);
	public void freeInTheFuture(ModelSpecificEvent mse);
	
}
