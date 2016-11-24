package org.gemoc.sample.legacytfsm.xstfsm;

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
    	org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eNS_URI,
    	org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmPackage.eINSTANCE
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
    MelangeRegistry.LanguageDescriptor xSTFSM = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.legacytfsm.xstfsm.XSTFSM", "", "http://org.gemoc.sample.legacytfsm.xstfsm.xstfsm/tfsm/", "org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT"
    );
    xSTFSM.addAdapter("org.gemoc.sample.legacytfsm.tfsm.TFSMMT", org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.XSTFSMAdapter.class);
    xSTFSM.addAdapter("org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT", org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMAdapter.class);
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.legacytfsm.xstfsm.XSTFSM",
    	xSTFSM
    );
    MelangeRegistry.ModelTypeDescriptor xSTFSMMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT", "", "http://org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt/"
    );
    xSTFSMMT.addSuperType("org.gemoc.sample.legacytfsm.tfsm.TFSMMT");
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT",
    	xSTFSMMT
    );
  }
}
