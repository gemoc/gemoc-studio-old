package org.gemoc.executionengine.ccsljava.api.core;

import java.util.List;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.executionengine.ccsljava.api.dsa.executors.ICodeExecutor;
import org.gemoc.executionengine.ccsljava.api.moc.ISolver;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IFutureAction;

public interface INonDeterministicExecutionEngine extends IExecutionEngine{

	IConcurrentExecutionContext getConcurrentExecutionContext();
	
	void recomputePossibleLogicalSteps();

	List<LogicalStep> getPossibleLogicalSteps();
	
	LogicalStep getSelectedLogicalStep();
		
	void addFutureAction(IFutureAction action);

	ILogicalStepDecider getLogicalStepDecider();

	void changeLogicalStepDecider(ILogicalStepDecider newDecider);

	ISolver getSolver();

	void setSolver(ISolver solver);

	ICodeExecutor getCodeExecutor();

}
