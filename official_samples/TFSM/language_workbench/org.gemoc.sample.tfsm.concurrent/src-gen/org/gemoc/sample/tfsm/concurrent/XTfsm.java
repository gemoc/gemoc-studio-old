package org.gemoc.sample.tfsm.concurrent;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.sample.tfsm.concurrent.XTfsmMT;

@SuppressWarnings("all")
public class XTfsm implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static XTfsm load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    XTfsm mm = new XTfsm();
    mm.setResource(res);
    return mm ;
  }
  
  public XTfsmMT toXTfsmMT() {
    org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmAdapter adaptee = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
