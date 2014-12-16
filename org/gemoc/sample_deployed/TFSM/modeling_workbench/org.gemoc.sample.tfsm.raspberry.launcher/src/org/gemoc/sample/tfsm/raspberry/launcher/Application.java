package org.gemoc.sample.tfsm.raspberry.launcher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.sample.tfsm.impl.TfsmPackageImpl;
import org.gemoc.sample.tfsm.raspberry.engine.ExecutionContext;
import org.gemoc.sample.tfsm.raspberry.engine.ExecutionEngine;
import org.gemoc.sample.tfsm.raspberry.engine.RunConfiguration;
import org.gemoc.sample.tfsm.single_traffic_light_sample.mocc.models.TrafficControlModel;

import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.ClockConstraintSystem;
import fr.inria.aoste.timesquare.ccslkernel.model.TimeModel.CCSLModel.impl.CCSLModelPackageImpl;
import fr.inria.aoste.timesquare.ccslkernel.runtime.AbstractRuntimeModel;

public class Application implements IApplication {

	@Override
	public Object start(IApplicationContext context) throws Exception {
	
		try {
//			IWorkspace workspace = ResourcesPlugin.getWorkspace();
//
//			System.out.println("Workspace root: " + workspace.getRoot().getLocation().toString());
//			
//			for (IProject p : workspace.getRoot().getProjects()) {
//				System.out.println("Project " + p.getLocation().toString());				
//			}
//			
//			IWorkspaceDescription desc= workspace.getDescription();
//			desc.setAutoBuilding(false);
//			workspace.setDescription(desc);
//
//			if (org.eclipse.core.internal.registry.RegistryProviderFactory.getDefault() == null) {
//				System.out.println("Exiting because RegistryProviderFactory.getDefault() returned null.");
//				return null;
//			}
//			System.out.println("ExtendedCCSLStandaloneSetup.doSetup succeeded.");
			TfsmPackageImpl.init();
		
			ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap().put("timemodel", new XMIResourceFactoryImpl());
			URI uri = URI.createFileURI("C:/Users/ftanguy/git/gemoc-dev/org/gemoc/sample_deployed/TFSM/modeling_workbench/org.gemoc.sample.tfsm.single_traffic_light_sample/single_traffic_light.timemodel");
			
			
			RunConfiguration runConfiguration = new RunConfiguration(uri);
			ExecutionContext executionContext = new ExecutionContext(runConfiguration);
									
			ExecutionEngine engine = new ExecutionEngine(executionContext);
			engine.start();
			
			Thread.sleep(50000);
//			ModelRunner2 runner = new ModelRunner2();
//			runner.run("tfsm", 
//					new Path("/org.gemoc.sample.tfsm.single_traffic_light_sample"),
//					new Path("/org.gemoc.sample.tfsm.single_traffic_light_sample/single_traffic_light.tfsm"),
//					new Path("/org.gemoc.sample.tfsm.single_traffic_light_sample/gemoc-gen/single_traffic_light_executionModel.xmi"));
//		} catch (CoreException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
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
