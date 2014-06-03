package org.gemoc.execution.engine;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.execution.engine.core.GemocRunningEnginesRegistry;
import org.gemoc.gemoc_commons.logging.backends.DefaultLoggingBackend;
import org.gemoc.gemoc_commons.pde.GemocUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends GemocUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.execution.engine"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID,
				path);
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
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
		addLoggingBackend(new DefaultLoggingBackend(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		Activator.plugin = null;
		super.stop(context);
	}

	/**
	 * List of engines that have registered to be running in this eclipse
	 */
	public GemocRunningEnginesRegistry gemocRunningEngineRegistry = new GemocRunningEnginesRegistry();

	@Override
	public String getPluginId() {
		return PLUGIN_ID;
	}
	

}
