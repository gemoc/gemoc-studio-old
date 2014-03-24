package org.gemoc.gemoc_language_workbench.api.core;

public class  EngineStatus {
	long nbLogicalStepRun = 0;
	RunStatus runningStatus = RunStatus.Initializing;
	
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

	public RunStatus getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(RunStatus runningStatus) {
		this.runningStatus = runningStatus;
	};
	
}
