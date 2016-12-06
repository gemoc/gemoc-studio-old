package org.gemoc.sample.tfsm.plaink3.xdsml;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;
import fr.inria.diverse.commons.messagingsystem.api.impl.StdioSimpleMessagingSystem;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.sample.tfsm.plaink3.xdsml"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	protected static MessagingSystem messagingSystem = null;

	public static MessagingSystem getMessagingSystem() {
		if (messagingSystem == null) {
			messagingSystem = new StdioSimpleMessagingSystem();
			//messagingSystem = new EclipseMessagingSystem(PLUGIN_ID,
			//		"GEMOC Execution Engine");
			//((EclipseMessagingSystem) messagingSystem)
			//		.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
		}
		return messagingSystem;
	}

	public static void warnEclipse(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.WARNING, PLUGIN_ID, Status.OK, msg, e));
	}

	public static void errorEclipse(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.ERROR, PLUGIN_ID, Status.OK, msg, e));
	}

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
		
	public static void warn(String message) {
		log(message, LogLevel.WARN);
	}

	public static void info(String message) {
		log(message, LogLevel.INFO);
	}

	public static void debug(String message) {
		log(message, LogLevel.DEBUG);
	}

	private static void log(String message, LogLevel logLevel) {
		System.out.println(PLUGIN_ID + " " + logLevel + ": " + message);
//		if (PlatformUI.isWorkbenchRunning()) {
//			switch (logLevel) {
//				case DEBUG:
//					getMessagingSystem().debug(message, PLUGIN_ID);								
//					break;
//				case INFO:
//					getMessagingSystem().debug(message, PLUGIN_ID);								
//					break;
//				case WARN:
//					getMessagingSystem().debug(message, PLUGIN_ID);								
//					break;	
//				default:
//					break;
//			}
//		} 
//		else {
//			System.out.println(PLUGIN_ID + " " + logLevel + ": " + message);
//		}
	}

	public enum LogLevel {
		DEBUG,
		INFO,
		WARN
	}
	
}
