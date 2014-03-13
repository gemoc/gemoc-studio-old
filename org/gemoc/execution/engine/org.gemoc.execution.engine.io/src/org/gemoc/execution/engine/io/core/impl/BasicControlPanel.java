package org.gemoc.execution.engine.io.core.impl;

import org.gemoc.execution.engine.io.core.ControlPanel;
import org.gemoc.execution.engine.io.exceptions.ImpossibleCommandException;

public abstract class BasicControlPanel extends BasicFrontend implements
		ControlPanel {
	public void run() throws ImpossibleCommandException {
	//	this.engine.run(-1);
	}

	public void run(int numberOfSteps) throws ImpossibleCommandException {
	//	this.engine.run(numberOfSteps);
	}

	public void pause() throws ImpossibleCommandException{
	//	this.engine.pause();
	}

	public void reset() throws ImpossibleCommandException {
	//	this.engine.reset();
	}

	public void stepBack(int numberOfSteps)
			throws ImpossibleCommandException{
	//	this.engine.stepBack(numberOfSteps);
	}
}
