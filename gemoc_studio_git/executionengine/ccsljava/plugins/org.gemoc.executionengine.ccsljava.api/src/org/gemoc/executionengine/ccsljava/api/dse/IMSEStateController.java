package org.gemoc.executionengine.ccsljava.api.dse;

import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;



public interface IMSEStateController
{

	void applyMSEFutureStates(ISolver solver);
	void forcePresenceInTheFuture(ModelSpecificEvent mse);
	void forceAbsenceTickInTheFuture(ModelSpecificEvent mse);
	void freeInTheFuture(ModelSpecificEvent mse);
	
}
