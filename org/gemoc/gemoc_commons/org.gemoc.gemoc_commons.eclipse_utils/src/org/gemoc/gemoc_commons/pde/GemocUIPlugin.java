package org.gemoc.gemoc_commons.pde;

import java.util.ArrayList;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.gemoc_commons.logging.ILoggingBackend;

public abstract class GemocUIPlugin extends AbstractUIPlugin {

	public abstract String getPluginId();

	private static ArrayList<ILoggingBackend> _loggingBackends = new ArrayList<ILoggingBackend>();
	public static void addLoggingBackend(ILoggingBackend backend) 
	{
		if (backend == null)
			throw new IllegalArgumentException("backend");
		_loggingBackends.add(backend);
	}
	
	public static void debug(String message) {
		for(ILoggingBackend b : _loggingBackends)
			b.debug(message);
	}

	public static void error(String message) {
		for(ILoggingBackend b : _loggingBackends)
			b.error(message);
	}
	
	public static void info(String message) {
		for(ILoggingBackend b : _loggingBackends)
			b.info(message);
	}
	
	public static void warn(String message) {
		for(ILoggingBackend b : _loggingBackends)
			b.warn(message);
	}
	
	public static void error(String message, Throwable e) {
		for(ILoggingBackend b : _loggingBackends)
			b.error(message, e);
	}
	
	public static void warn(String message, Throwable e) {
		for(ILoggingBackend b : _loggingBackends)
			b.warn(message, e);
	}
	
	public static void info(String message, Throwable e) {
		for(ILoggingBackend b : _loggingBackends)
			b.info(message, e);
	}

}
