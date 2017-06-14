package org.eclipse.gemoc.commons.eclipse.messagingsystem.api;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gemoc.commons.messagingsystem.api.impl.StdioSimpleMessagingSystem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;



public class Activator implements BundleActivator {

	private static BundleContext context;
	// The shared instance
	private static Activator plugin;
	
	// best platform shared
	protected MessagingSystemManager messagingSystemManager= new MessagingSystemManager();

	public static BundleContext getContext() {
		return context;
	}
	
	public static Activator getDefault(){
		return plugin;
	}

	public static MessagingSystemManager getDefaultMessagingSystemManager(){
		return getDefault().messagingSystemManager;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Activator.plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	
	
}
