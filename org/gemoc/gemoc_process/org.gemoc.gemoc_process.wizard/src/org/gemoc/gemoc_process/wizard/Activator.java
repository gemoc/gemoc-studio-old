package org.gemoc.gemoc_process.wizard;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.gemoc.gemoc_process.aspectgenerator.KM2KMTAspectGenerator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements BundleActivator, ServiceListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.gemoc.gemoc_process.wizard"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	ServiceReference serviceReference;
	KM2KMTAspectGenerator aspectGeneratorService;
	BundleContext bundleContext;
	
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.bundleContext = context;
		// property for the service
		Dictionary<String, ? extends Object> args = new Hashtable<String, Object>();
		serviceReference = bundleContext.getServiceReference(KM2KMTAspectGenerator.class.getName());
		aspectGeneratorService = (KM2KMTAspectGenerator) bundleContext.getService(serviceReference);

		//if (aspectGeneratorService != null)
		//	System.err.println(aspectGeneratorService.sayHello("Toto"));

		String filter = "(objectclass=" + KM2KMTAspectGenerator.class.getName() + ")";
		//context.
		context.addServiceListener(this, filter);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
	
	@Override
	public void serviceChanged(ServiceEvent event) {
		getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.INFO, "ServiceEvent received "+event.toString(), null));	
		if (event.getType() == ServiceEvent.REGISTERED) {
			aspectGeneratorService = (KM2KMTAspectGenerator) bundleContext.getService(event.getServiceReference());
			//if (aspectGeneratorService != null)
			//	System.err.println(aspectGeneratorService.sayHello("Toto"));
		} else if (event.getType() == ServiceEvent.UNREGISTERING) {
			bundleContext.ungetService(event.getServiceReference());
			aspectGeneratorService = null;
		}
	}
	
	public static KM2KMTAspectGenerator getKM2KMTAspectGenerator(){
		return getDefault().aspectGeneratorService;
	}
	
	/**
	 * This method logs an error message and an associated exception (as a trace)
	 * @param message String
	 */
	public static void logErrorMessage(String message, Throwable e) {
		if (message == null)
			message= "";
		// eclipse logger
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.ERROR, message, e));		
	}
	
}
