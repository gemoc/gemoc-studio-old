package org.gemoc.execution.engine.io.core.impl;

import org.gemoc.execution.engine.io.core.ControlPanel;
import org.gemoc.execution.engine.io.exceptions.ImpossibleOperationException;

public abstract class BasicControlPanel extends BasicFrontend implements
		ControlPanel {
	public void run() throws ImpossibleOperationException {
		this.engine.run(-1);
	}

	public void run(int numberOfSteps) throws ImpossibleOperationException {
		this.engine.run(numberOfSteps);
	}

	public void pause() throws ImpossibleOperationException{
		this.engine.pause();
	}

	public void reset() throws ImpossibleOperationException {
		this.engine.reset();
	}

	public void stepBack(int numberOfSteps)
			throws ImpossibleOperationException{
		this.engine.stepBack(numberOfSteps);
	}
}
