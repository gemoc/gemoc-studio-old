package org.gemoc.executionengine.ccsljava.api.core;

import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;

public interface INonDeterministicExecutionEngine extends IExecutionEngine{

	void recomputePossibleLogicalSteps();

	List<LogicalStep> getPossibleLogicalSteps();
	
	LogicalStep getSelectedLogicalStep();
		
	void addFutureAction(IFutureAction action);

	ILogicalStepDecider getLogicalStepDecider();

	void changeLogicalStepDecider(ILogicalStepDecider newDecider);

	ISolver getSolver();

	void setSolver(ISolver solver);

}
