package org.gemoc.execution.engine.commons;

import org.eclipse.ui.PlatformUI;
import org.gemoc.commons.eclipse.logging.backends.DefaultLoggingBackend;
import org.gemoc.commons.eclipse.pde.ui.GemocUIPlugin;
import org.osgi.framework.BundleContext;

import fr.inria.diverse.commons.eclipse.messagingsystem.ui.EclipseMessagingSystem;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends GemocUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.execution.engine.commons"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

//	protected static EclipseMessagingSystem messagingSystem = null;
//
//	private static EclipseMessagingSystem getMessagingSystem() {
//		if (messagingSystem == null) {
//			messagingSystem = new EclipseMessagingSystem(PLUGIN_ID,
//					"GEMOC Execution Engine Commons");
//			((EclipseMessagingSystem) messagingSystem)
//					.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
//		}
//		return messagingSystem;
//	}

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

	@Override
	public String getId() {
		return PLUGIN_ID;
	}

	@Override
	public DefaultLoggingBackend resolveLoggingBackend() {
		DefaultLoggingBackend backend = new DefaultLoggingBackend(this);
		if (PlatformUI.isWorkbenchRunning())
		{
			backend.setMessagingSystem(new EclipseMessagingSystem(getId(), getName()));
		}
		return backend;
	}

}
