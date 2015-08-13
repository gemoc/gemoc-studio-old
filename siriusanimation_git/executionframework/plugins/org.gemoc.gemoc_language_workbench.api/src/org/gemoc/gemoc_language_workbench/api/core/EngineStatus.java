package org.gemoc.gemoc_language_workbench.api.core;
import java.util.ArrayList;
import java.util.List;

import fr.inria.aoste.trace.LogicalStep;
public class  EngineStatus {
	long nbLogicalStepRun = 0;
	
	LogicalStep chosenLogicalStep;
	


	public enum RunStatus { Initializing, Running, WaitingLogicalStepSelection, Stopped}

	
	public long getNbLogicalStepRun() {
		return nbLogicalStepRun;
	}

	public void setNbLogicalStepRun(long nbLogicalStepRun) {
		this.nbLogicalStepRun = nbLogicalStepRun;
	}
	public void incrementNbLogicalStepRun() {
		this.nbLogicalStepRun +=1;
	}
		
	
}
