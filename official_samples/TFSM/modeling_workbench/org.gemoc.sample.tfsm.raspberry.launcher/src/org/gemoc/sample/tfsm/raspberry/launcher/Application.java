package org.gemoc.sample.tfsm.raspberry.launcher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.gemoc.execution.engine.core.ExecutionEngine;
import org.gemoc.sample.tfsm.impl.TfsmPackageImpl;
import org.gemoc.sample.tfsm.raspberry.engine.ExecutionContext;
import org.gemoc.sample.tfsm.raspberry.engine.RunConfiguration;

public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
	
		try {
			TfsmPackageImpl.init();		
			ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put("timemodel", new XMIResourceFactoryImpl());
			ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put("feedback", new XMIResourceFactoryImpl());
			URI uri = URI.createPlatformPluginURI("/org.gemoc.sample.tfsm.raspberry.launcher/model/single_traffic_light.tfsm", true);				
			RunConfiguration runConfiguration = new RunConfiguration(uri);
			ExecutionContext executionContext = new ExecutionContext(runConfiguration);
			ExecutionEngine engine = new ExecutionEngine(executionContext);
			engine.start();			
			Thread.sleep(500000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
