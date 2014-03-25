package org.gemoc.gemoc_language_workbench.api.core;
import java.util.ArrayList;
import java.util.List;

import fr.inria.aoste.trace.LogicalStep;
public class  EngineStatus {
	long nbLogicalStepRun = 0;
	RunStatus runningStatus = RunStatus.Initializing;
	
	List<LogicalStep> currentLogicalStepChoice = new ArrayList<LogicalStep>();
	
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
	
	
	public void updateCurrentLogicalStepChoice(List<LogicalStep> newCurrentLogicalStepChoice){
		synchronized (this){
			currentLogicalStepChoice.clear();
			currentLogicalStepChoice.addAll(newCurrentLogicalStepChoice);
		}
	}
	
	public List<LogicalStep> getCurrentLogicalStepChoice(){
		List<LogicalStep> newCurrentLogicalStepChoice = new ArrayList<LogicalStep>();
		synchronized (this){
			newCurrentLogicalStepChoice.addAll(currentLogicalStepChoice);
		}
		return newCurrentLogicalStepChoice;
	}
}
