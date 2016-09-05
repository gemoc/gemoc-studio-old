package org.gemoc.sample.tfsm.plaink3.xdsml;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT;

@SuppressWarnings("all")
public class Tfsm implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static Tfsm load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    Tfsm mm = new Tfsm();
    mm.setResource(res);
    return mm ;
  }
  
  public TfsmMT toTfsmMT() {
    org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmAdapter adaptee = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
