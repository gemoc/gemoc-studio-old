package org.gemoc.sample.tfsm.plaink3.xdsml;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

@SuppressWarnings("all")
public class XTfsm implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static org.gemoc.sample.tfsm.plaink3.xdsml.XTfsm load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    XTfsm mm = new XTfsm();
    mm.setResource(res);
    return mm ;
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.XTfsmMT toXTfsmMT() {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmAdapter adaptee = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
