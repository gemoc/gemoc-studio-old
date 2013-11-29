package org.gemoc.gemoc_language_workbench.extensions.k3;

import org.kermeta.utils.systemservices.eclipse.api.ConsoleLogLevel;
import org.kermeta.utils.systemservices.eclipse.api.EclipseMessagingSystem;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}
	
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.extensions.k3"; //$NON-NLS-1$


	protected static EclipseMessagingSystem messagingSystem = null;

	public static EclipseMessagingSystem getMessagingSystem() {
		if (messagingSystem == null) {
			messagingSystem = new EclipseMessagingSystem(PLUGIN_ID,
					"GEMOC extensions k3");
			((EclipseMessagingSystem) messagingSystem)
					.setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
		}
		return messagingSystem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
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

}
