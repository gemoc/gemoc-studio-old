package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt;

import fr.inria.diverse.melange.adapters.ResourceAdapter;
import java.io.IOException;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.gemoc.sample.sigpml.XSigPMLMT;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlFactory;

@SuppressWarnings("all")
public class XSigPMLAdapter extends ResourceAdapter implements XSigPMLMT {
  public XSigPMLAdapter() {
    super(org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory.getInstance());
  }
  
  @Override
  public SigpmlFactory getSigpmlFactory() {
    return new org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.SigpmlFactoryAdapter();
  }
  
  @Override
  public Set getFactories() {
    java.util.Set<org.eclipse.emf.ecore.EFactory> res = new java.util.HashSet<org.eclipse.emf.ecore.EFactory>();
    res.add(getSigpmlFactory());
    return res;
  }
  
  @Override
  public void save(final String uri) throws IOException {
    this.adaptee.setURI(URI.createURI(uri));
    this.adaptee.save(null);
  }
}
