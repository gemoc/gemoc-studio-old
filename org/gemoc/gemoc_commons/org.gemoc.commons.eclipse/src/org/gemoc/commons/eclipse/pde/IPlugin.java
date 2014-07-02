package org.gemoc.commons.eclipse.pde;

import org.eclipse.core.runtime.ILog;

public interface IPlugin {

	public String getName();

	public String getId();

	public ILog getLog();

}
