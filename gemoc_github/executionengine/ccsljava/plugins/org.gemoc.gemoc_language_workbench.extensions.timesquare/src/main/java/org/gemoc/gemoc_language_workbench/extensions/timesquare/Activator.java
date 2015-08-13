package org.gemoc.gemoc_language_workbench.extensions.timesquare;

import org.gemoc.commons.eclipse.logging.backends.DefaultLoggingBackend;
import org.gemoc.commons.eclipse.pde.GemocPlugin;
import org.osgi.framework.BundleContext;

import fr.inria.diverse.commons.eclipse.messagingsystem.api.MessagingSystemManager;
import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;

public class Activator extends GemocPlugin {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}
	
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.extensions.timesquare"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		context = bundleContext;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	private DefaultLoggingBackend _loggingBackend;
	
	@Override
	public DefaultLoggingBackend resolveLoggingBackend() 
	{
		if (_loggingBackend == null)
		{
			_loggingBackend = new DefaultLoggingBackend(this);
			MessagingSystemManager msm = new MessagingSystemManager();
			MessagingSystem ms = msm.createBestPlatformMessagingSystem(Activator.PLUGIN_ID, "Execution Engine");
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
