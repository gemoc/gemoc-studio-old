package org.gemoc.gemoc_process.aspectgenerator;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import org.gemoc.gemoc_process.aspectgenerator.impl.KM2KMTAspectGeneratorImpl4Eclipse;;


public class Activator implements BundleActivator{

	
	ServiceRegistration serviceRegistration;
	@Override
	public void start(BundleContext ctx) throws Exception {
		//property for the service
		Dictionary<String, ? extends Object> args = new Hashtable<String,  Object>() ;
		serviceRegistration = ctx.registerService(KM2KMTAspectGenerator.class.getName(), new KM2KMTAspectGeneratorImpl4Eclipse(), args);
	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		if (serviceRegistration!=null)
			serviceRegistration.unregister();
		
	}

}
