package org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt;

import fr.inria.diverse.melange.adapters.ResourceAdapter;
import java.io.IOException;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.gemoc.sample.tfsm.concurrent.XTfsmMT;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmFactory;

@SuppressWarnings("all")
public class XTfsmAdapter extends ResourceAdapter implements XTfsmMT {
  public XTfsmAdapter() {
    super(org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
  }
  
  @Override
  public TfsmFactory getTfsmFactory() {
    return new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TfsmFactoryAdapter();
  }
  
  @Override
  public Set getFactories() {
    java.util.Set<org.eclipse.emf.ecore.EFactory> res = new java.util.HashSet<org.eclipse.emf.ecore.EFactory>();
    res.add(getTfsmFactory());
    return res;
  }
  
  @Override
  public void save(final String uri) throws IOException {
    this.adaptee.setURI(URI.createURI(uri));
    this.adaptee.save(null);
  }
}
