package org.gemoc.sample.sigpml.xdsml;

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
    	org.gemoc.sample.sigpml.SigpmlPackage.eNS_URI,
    	org.gemoc.sample.sigpml.SigpmlPackage.eINSTANCE
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
    MelangeRegistry.LanguageDescriptor sigpml = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.sigpml.xdsml.Sigpml", "", "http://org.gemoc.sigpml.model/1.0", "org.gemoc.sample.sigpml.xdsml.SigpmlMT"
    );
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.sigpml.xdsml.Sigpml",
    	sigpml
    );
    MelangeRegistry.ModelTypeDescriptor sigpmlMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.sigpml.xdsml.SigpmlMT", "", "http://sigpmlmt/"
    );
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.sigpml.xdsml.SigpmlMT",
    	sigpmlMT
    );
  }
}
