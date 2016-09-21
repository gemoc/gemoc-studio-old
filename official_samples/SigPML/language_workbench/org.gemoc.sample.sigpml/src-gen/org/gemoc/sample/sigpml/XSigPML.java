package org.gemoc.sample.sigpml;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.sample.sigpml.XSigPMLMT;

@SuppressWarnings("all")
public class XSigPML implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static XSigPML load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    XSigPML mm = new XSigPML();
    mm.setResource(res);
    return mm ;
  }
  
  public XSigPMLMT toXSigPMLMT() {
    org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLAdapter adaptee = new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
