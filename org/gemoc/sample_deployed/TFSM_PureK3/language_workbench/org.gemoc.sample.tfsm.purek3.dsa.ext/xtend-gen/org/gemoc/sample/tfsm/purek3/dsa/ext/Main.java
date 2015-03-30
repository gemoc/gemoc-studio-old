package org.gemoc.sample.tfsm.purek3.dsa.ext;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspect;
import org.gemoc.sample.tfsm.purek3.dsa.ext.MyVisitor;
import tfsmextended.tfsmextended.TimedSystem;
import tfsmextended.tfsmextended.impl.TfsmextendedPackageImpl;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final TimedSystem system = Main.loadModel();
    Main.main(system);
  }
  
  public static void main(final TimedSystem system) {
    EList<TFSM> _tfsms = system.getTfsms();
    final TFSM tfsm = _tfsms.get(0);
    final MyVisitor visitor = new MyVisitor();
    int i = 0;
    while ((i != 20)) {
      {
        TFSMAspect.accept(tfsm, visitor);
        i++;
      }
    }
  }
  
  private static TimedSystem loadModel() {
    try {
      Map<String, Object> _extensionToFactoryMap = ResourceFactoryRegistryImpl.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("tfsm", _xMIResourceFactoryImpl);
      EcorePackageImpl.init();
      TfsmextendedPackageImpl.init();
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
      final URI modelURI = Main.createModelURI();
      final Resource resource = resourceSet.createResource(modelURI);
      resource.load(null);
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(0);
      final TimedSystem system = ((TimedSystem) _get);
      return system;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static URI createModelURI() {
    String _property = System.getProperty("user.dir");
    final String directory = _property.replace("\\", "/");
    final String modelURIAsString = ((directory + "/../../modeling_workbench") + "/org.gemoc.tfsm.purek3.single_traffic_light_sample/single_traffic_light.tfsm");
    final URI modelURI = URI.createFileURI(modelURIAsString);
    return modelURI;
  }
}
