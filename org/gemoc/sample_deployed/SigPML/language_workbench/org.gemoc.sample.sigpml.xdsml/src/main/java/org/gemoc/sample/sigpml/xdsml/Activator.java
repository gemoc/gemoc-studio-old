package org.gemoc.sample.sigpml.xdsml;

import org.gemoc.commons.eclipse.logging.backends.DefaultLoggingBackend;
import org.gemoc.commons.eclipse.pde.ui.GemocUIPlugin;
import org.osgi.framework.BundleContext;

import fr.inria.diverse.commons.eclipse.messagingsystem.api.MessagingSystemManager;
import fr.inria.diverse.commons.eclipse.messagingsystem.ui.EclipseMessagingSystem;
import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;

public class Activator extends GemocUIPlugin {


	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.sample.sigpml.xdsml"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	protected static EclipseMessagingSystem messagingSystem = null;

	private DefaultLoggingBackend _loggingBackend;

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
	public DefaultLoggingBackend resolveLoggingBackend() {
		if (_loggingBackend == null)
		{
			_loggingBackend = new DefaultLoggingBackend(this);
			MessagingSystemManager msm = new MessagingSystemManager();
			MessagingSystem ms = msm.createBestPlatformMessagingSystem("org.gemoc.execution.engine", "Execution Engine");
			_loggingBackend.setMessagingSystem(ms);
		}
		return _loggingBackend;
	}

	@Override
	public String getId() 
	{
		return PLUGIN_ID;
	}
}
