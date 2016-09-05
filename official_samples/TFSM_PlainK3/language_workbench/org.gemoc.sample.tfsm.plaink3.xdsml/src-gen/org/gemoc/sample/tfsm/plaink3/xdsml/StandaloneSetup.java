package org.gemoc.sample.tfsm.plaink3.xdsml;

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
    	org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Tfsm_plaink3Package.eNS_URI,
    	org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE
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
    MelangeRegistry.LanguageDescriptor tfsm = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.tfsm.plaink3.xdsml.Tfsm", "", "http://tfsm/tfsm_plaink3/", "org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT"
    );
    tfsm.addAdapter("org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT", org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmAdapter.class);
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.tfsm.plaink3.xdsml.Tfsm",
    	tfsm
    );
    MelangeRegistry.ModelTypeDescriptor tfsmMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT", "", "http://tfsmmt/"
    );
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT",
    	tfsmMT
    );
  }
}
