package org.gemoc.execution.engine.commons.deciders;

import java.util.List;
import java.util.Random;

import org.gemoc.execution.engine.trace.gemoc_execution_trace.LogicalStep;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.ILogicalStepDecider;

/**
 * Decider that will choose randomly
 * 
 */
public class RandomDecider implements ILogicalStepDecider {

	private Random rand = new Random();

	public RandomDecider() {
		super();
	}

	@Override
	public LogicalStep decide(IExecutionEngine engine, List<LogicalStep> possibleLogicalSteps) {
		int index = -1;
		if (possibleLogicalSteps.size() < 2)
		{
			index = 0;
		}
		else
		{
			index = rand.nextInt(possibleLogicalSteps.size());
		}
		return possibleLogicalSteps.get(index);
	}

	@Override
	public void dispose() {
		// nothing to do
	}

	@Override
	public void preempt() {
		// not possible
	}

}
