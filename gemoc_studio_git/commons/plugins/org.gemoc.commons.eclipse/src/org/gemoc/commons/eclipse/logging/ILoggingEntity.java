package org.gemoc.commons.eclipse.logging;

import org.eclipse.core.runtime.ILog;

public interface ILoggingEntity {

	public String getName();

	public String getId();
	
	public ILog getLog();

}
