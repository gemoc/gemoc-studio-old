package org.gemoc.gemoc_process.executable_metamodel_creator;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import org.gemoc.gemoc_process.executable_metamodel_creator.impl.KM2KMTexecutable_metamodel_creatorImpl4Eclipse;


public class Activator implements BundleActivator{

	
	ServiceRegistration serviceRegistration;
	public void start(BundleContext ctx) throws Exception {
		//property for the service
		Dictionary<String, ? extends Object> args = new Hashtable<String,  Object>() ;
		serviceRegistration = ctx.registerService(KM2KMTexecutable_metamodel_creator.class.getName(), new KM2KMTexecutable_metamodel_creatorImpl4Eclipse(), args);
	}

	public void stop(BundleContext ctx) throws Exception {
		if (serviceRegistration!=null)
			serviceRegistration.unregister();
		
	}

}
