package org.gemoc.sample.legacytfsm.tfsm;

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
    	org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eNS_URI,
    	org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE
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
    MelangeRegistry.LanguageDescriptor tFSM = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.legacytfsm.tfsm.TFSM", "", "http://www.gemoc.org/legacytfsm/tfsm", "org.gemoc.sample.legacytfsm.tfsm.TFSMMT"
    );
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.legacytfsm.tfsm.TFSM",
    	tFSM
    );
    MelangeRegistry.ModelTypeDescriptor tFSMMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.legacytfsm.tfsm.TFSMMT", "", "http://org.gemoc.sample.legacytfsm.tfsm.tfsmmt/"
    );
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.legacytfsm.tfsm.TFSMMT",
    	tFSMMT
    );
  }
}
