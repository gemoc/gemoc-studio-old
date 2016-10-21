package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt;

import fr.inria.diverse.melange.adapters.ResourceAdapter;
import java.io.IOException;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.gemoc.sample.legacytfsm.xstfsm.XSTFSMMT;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmFactory;

@SuppressWarnings("all")
public class XSTFSMAdapter extends ResourceAdapter implements XSTFSMMT {
  public XSTFSMAdapter() {
    super(org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory.getInstance());
  }
  
  @Override
  public TfsmFactory getTfsmFactory() {
    return new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TfsmFactoryAdapter();
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
