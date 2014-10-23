package org.gemoc.gemoc_language_workbench.api.dse;

import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.timesquare.ecl.feedback.feedback.ModelSpecificEvent;



public interface IMSEStateController
{

	void applyMSEFutureStates(Solver solver);
	void forcePresenceInTheFuture(ModelSpecificEvent mse);
	void forceAbsenceTickInTheFuture(ModelSpecificEvent mse);
	void freeInTheFuture(ModelSpecificEvent mse);
	
}
