package org.gemoc.sample.tfsm.sequential;

import fr.inria.diverse.melange.resource.MelangeRegistry;
import fr.inria.diverse.melange.resource.MelangeRegistryImpl;
import fr.inria.diverse.melange.resource.MelangeResourceFactoryImpl;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

@SuppressWarnings("all")
public class StandaloneSetup {
  public static void doSetup() {
    StandaloneSetup setup = new StandaloneSetup();
    setup.doEMFRegistration();
    setup.doAdaptersRegistration();
  }
  
  public void doEMFRegistration() {
    EPackage.Registry.INSTANCE.put(
    	org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eNS_URI,
    	org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TfsmPackage.eINSTANCE
    );
    
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
    	"*",
    	new XMIResourceFactoryImpl()
    );
    Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put(
    	"melange",
    	new MelangeResourceFactoryImpl()
    );
  }
  
  public void doAdaptersRegistration() {
    MelangeRegistry.LanguageDescriptor xTfsm = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.tfsm.sequential.XTfsm", "", "http://org.gemoc.sample.tfsm.sequential.xtfsm/tfsm/", "org.gemoc.sample.tfsm.sequential.XTfsmMT"
    );
    xTfsm.addAdapter("org.gemoc.sample.tfsm.sequential.XTfsmMT", org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmAdapter.class);
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.tfsm.sequential.XTfsm",
    	xTfsm
    );
    MelangeRegistry.ModelTypeDescriptor xTfsmMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.tfsm.sequential.XTfsmMT", "", "http://org.gemoc.sample.tfsm.sequential.xtfsmmt/"
    );
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.tfsm.sequential.XTfsmMT",
    	xTfsmMT
    );
  }
}
