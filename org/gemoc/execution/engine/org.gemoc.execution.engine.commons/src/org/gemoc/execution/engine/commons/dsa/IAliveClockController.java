package org.gemoc.execution.engine.commons.dsa;

import org.gemoc.gemoc_language_workbench.api.dsa.IClockController;

public interface IAliveClockController extends IClockController
{

	void initialize(EventInjectionContext context);

	void start();
	
	void stop();
	
}
