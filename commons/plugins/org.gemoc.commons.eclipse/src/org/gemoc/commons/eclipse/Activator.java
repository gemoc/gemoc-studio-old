package org.gemoc.commons.eclipse;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.commons.eclipse"; //$NON-NLS-1$

	
	@Override
	public void start(BundleContext context) throws Exception {
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {


	}
	
	public static void warn(String msg, Throwable e){
		Platform.getLog(Platform.getBundle(PLUGIN_ID)).log(new Status(Status.WARNING, PLUGIN_ID,
                Status.OK, 
                msg, 
                e));
	}
	public static void error(String msg, Throwable e){
		Platform.getLog(Platform.getBundle(PLUGIN_ID)).log(new Status(Status.WARNING, PLUGIN_ID,
                Status.OK, 
                msg, 
                e));
	}

}
