package org.gemoc.execution.engine.io.core;

import org.gemoc.execution.engine.io.exceptions.ImpossibleCommandException;

public interface ControlPanel extends Frontend {
	public void run() throws ImpossibleCommandException;

	public void run(int numberOfSteps) throws ImpossibleCommandException;

	public void pause() throws ImpossibleCommandException;

	public void reset() throws ImpossibleCommandException;

	public void stepBack(int numberOfSteps)
			throws ImpossibleCommandException;
}
