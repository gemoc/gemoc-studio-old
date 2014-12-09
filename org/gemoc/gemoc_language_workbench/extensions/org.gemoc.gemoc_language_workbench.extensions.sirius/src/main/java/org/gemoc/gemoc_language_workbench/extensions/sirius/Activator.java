package org.gemoc.gemoc_language_workbench.extensions.sirius;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import fr.inria.diverse.commons.eclipse.messagingsystem.api.MessagingSystemManager;
import fr.inria.diverse.commons.eclipse.messagingsystem.ui.ConsoleLogLevel;
import fr.inria.diverse.commons.eclipse.messagingsystem.ui.EclipseMessagingSystem;
import fr.inria.diverse.commons.messagingsystem.api.MessagingSystem;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}
	
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.extensions.sirius"; //$NON-NLS-1$


	protected static MessagingSystem messagingSystem = null;

	public static MessagingSystem getMessagingSystem() {
		if (messagingSystem == null) 
		{
			MessagingSystemManager msm = new MessagingSystemManager();
			messagingSystem = msm.createBestPlatformMessagingSystem(PLUGIN_ID, "GEMOC extensions Sirius");
			if (messagingSystem instanceof EclipseMessagingSystem)
				((EclipseMessagingSystem) messagingSystem).setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
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
