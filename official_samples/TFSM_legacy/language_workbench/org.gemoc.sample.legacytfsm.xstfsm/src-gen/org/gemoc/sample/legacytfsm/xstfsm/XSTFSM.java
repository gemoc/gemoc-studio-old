package org.gemoc.sample.legacytfsm.xstfsm;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.sample.legacytfsm.xstfsm.TFSMMT;
import org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT;

@SuppressWarnings("all")
public class XSTFSM implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static XSTFSM load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    XSTFSM mm = new XSTFSM();
    mm.setResource(res);
    return mm ;
  }
  
  public TFSMMT toTFSMMT() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.XSTFSMAdapter adaptee = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.XSTFSMAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
  
  public XSTFSMMT toXSTFSMMT() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMAdapter adaptee = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
