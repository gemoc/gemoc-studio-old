package org.gemoc.commons.eclipse.logging;


public interface ILoggingBackend {

	public void info(String message);	
	public void debug(String message);
	public void warn(String message);
	public void error(String message);

	public void info(String message, Throwable e);	
	public void warn(String msg, Throwable e);
	public void error(String msg, Throwable e);

}
