package org.gemoc.execution.engine.commons;

import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.kermeta.utils.systemservices.eclipse.api.ConsoleLogLevel;
import org.kermeta.utils.systemservices.eclipse.api.EclipseMessagingSystem;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.execution.engine.commons"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	protected static EclipseMessagingSystem messagingSystem = null;

	private static EclipseMessagingSystem getMessagingSystem() {
		if (messagingSystem == null) {
			messagingSystem = new EclipseMessagingSystem(PLUGIN_ID,
					"GEMOC Execution Engine Commons");
			((EclipseMessagingSystem) messagingSystem)
					.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
		}
		return messagingSystem;
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

	public static void warn(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.WARNING, PLUGIN_ID, Status.OK, msg, e));
	}

	public static void error(String msg, Throwable e) {
		Activator.getDefault().getLog()
				.log(new Status(Status.ERROR, PLUGIN_ID, Status.OK, msg, e));
	}
	
	public static void info(String s) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().info(s, PLUGIN_ID);
		else
			System.out.println(PLUGIN_ID + " INFO: " + s);
	}
	
	public static void warn(String s) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().info(s, PLUGIN_ID);
		else
			System.out.println(PLUGIN_ID + " WARN: " + s);
	}
	
	public static void debug(String s) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().info(s, PLUGIN_ID);
		else
			System.out.println(PLUGIN_ID + " DEBUG: " + s);
	}

	public static void error(String s) {
		if (PlatformUI.isWorkbenchRunning())
			getMessagingSystem().info(s, PLUGIN_ID);
		else
			System.out.println(PLUGIN_ID + " INFO: " + s);
	}

}
