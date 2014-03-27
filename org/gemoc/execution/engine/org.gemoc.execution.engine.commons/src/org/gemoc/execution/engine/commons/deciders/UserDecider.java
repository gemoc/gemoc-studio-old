package org.gemoc.execution.engine.commons.deciders;

import java.util.List;
import java.util.Random;

import org.gemoc.gemoc_language_workbench.api.core.LogicalStepDecider;

import fr.inria.aoste.trace.LogicalStep;

public class UserDecider implements LogicalStepDecider {

	Random rand = new Random();

	public UserDecider() {
		super();
	}

	@Override
	public int decide(List<LogicalStep> possibleLogicalSteps) {
		if (possibleLogicalSteps.size() < 2)
			return 0;
		return rand.nextInt(possibleLogicalSteps.size());
	}

}
