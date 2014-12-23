package org.gemoc.execution.engine.io.views.event.scenario;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.gemoc.execution.engine.io.Activator;

public class ScenarioException extends CoreException {

	public ScenarioException(String message)
	{
		this(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}
	
	public ScenarioException(IStatus status) 
	{
		super(status);
	}
	
}
