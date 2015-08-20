package org.gemoc.execution.engine.io;

import java.util.ArrayList;
import java.util.List;

import org.gemoc.commons.eclipse.logging.backends.DefaultLoggingBackend;
import org.gemoc.commons.eclipse.pde.ui.GemocUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends GemocUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.execution.engine.io"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;


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
	
//	protected static EclipseMessagingSystem messagingSystem = null;
//
//	public static EclipseMessagingSystem getMessagingSystem() {
//		if (messagingSystem == null) {
//			messagingSystem = new EclipseMessagingSystem(PLUGIN_ID,
//					"GEMOC Execution Engine Input/Output");
//			((EclipseMessagingSystem) messagingSystem)
//					.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
//		}
//		return messagingSystem;
//	}
//	
//	public static void eclipseWarn(String msg, Throwable e){
//		Activator.getDefault().getLog().log(new Status(Status.WARNING, PLUGIN_ID,
//                Status.OK, 
//                msg, 
//                e));
//	}
//	public static void eclipseError(String msg, Throwable e){
//		Activator.getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID,
//                Status.OK, 
//                msg, 
//                e));
//	}
//
//	public static void info(String s) {
//		if (PlatformUI.isWorkbenchRunning())
//			getMessagingSystem().info(s, PLUGIN_ID);
//		else
//			System.out.println(PLUGIN_ID + " INFO: " + s);
//	}

	@Override
	public String getId() {
		return PLUGIN_ID;
	}

	@Override
	public DefaultLoggingBackend resolveLoggingBackend() {
		return org.gemoc.execution.engine.commons.Activator.getDefault().resolveLoggingBackend();
	}



}
