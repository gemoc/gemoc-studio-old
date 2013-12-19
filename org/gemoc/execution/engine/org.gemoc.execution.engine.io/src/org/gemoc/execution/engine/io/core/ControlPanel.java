package org.gemoc.execution.engine.io.core;

import org.gemoc.execution.engine.io.exceptions.ImpossibleOperationException;

public interface ControlPanel extends Frontend {
	public void run() throws ImpossibleOperationException;

	public void run(int numberOfSteps) throws ImpossibleOperationException;

	public void pause() throws ImpossibleOperationException;

	public void reset() throws ImpossibleOperationException;

	public void stepBack(int numberOfSteps)
			throws ImpossibleOperationException;
}
