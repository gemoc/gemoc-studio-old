package org.gemoc.gemoc_language_workbench.extensions.timesquare;

import org.eclipse.core.runtime.Status;
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
	
	public static final String PLUGIN_ID = "org.gemoc.gemoc_language_workbench.extensions.timesquare"; //$NON-NLS-1$


	protected static MessagingSystem messagingSystem = null;


	// The shared instance
	private static Activator plugin;
	
	public static MessagingSystem getMessagingSystem() {
		if (messagingSystem == null) 
		{
			MessagingSystemManager msm = new MessagingSystemManager();
			messagingSystem = msm.createBestPlatformMessagingSystem(PLUGIN_ID, "GEMOC extensions TimeSquare");
			if (messagingSystem instanceof EclipseMessagingSystem)
				((EclipseMessagingSystem) messagingSystem).setConsoleLogLevel(ConsoleLogLevel.DEV_DEBUG);
		}
		return messagingSystem;
	}

	public static void warn(String msg){
		getMessagingSystem().warn(msg, "");
	}
	public static void warn(String msg, Throwable e){
		getMessagingSystem().warn(msg, "", e);
		/*Activator.getDefault().getLog().log(new Status(Status.WARNING, PLUGIN_ID,
                Status.OK, 
                msg, 
                e));*/
	}
	public static void error(String msg){
		getMessagingSystem().error(msg, "");
	}
	public static void error(String msg, Throwable e){
		getMessagingSystem().error(msg, "", e);
		/*Activator.getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID,
                Status.OK, 
                msg, 
                e));*/
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

}
