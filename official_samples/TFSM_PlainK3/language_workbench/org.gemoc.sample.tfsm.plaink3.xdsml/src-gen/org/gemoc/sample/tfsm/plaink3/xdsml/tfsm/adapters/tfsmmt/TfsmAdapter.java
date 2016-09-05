package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt;

import fr.inria.diverse.melange.adapters.ResourceAdapter;
import java.io.IOException;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.gemoc.sample.tfsm.plaink3.xdsml.TfsmMT;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Factory;

@SuppressWarnings("all")
public class TfsmAdapter extends ResourceAdapter implements TfsmMT {
  public TfsmAdapter() {
    super(org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory.getInstance());
  }
  
  @Override
  public Tfsm_plaink3Factory getTfsm_plaink3Factory() {
    return new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.Tfsm_plaink3FactoryAdapter();
  }
  
  @Override
  public Set getFactories() {
    java.util.Set<org.eclipse.emf.ecore.EFactory> res = new java.util.HashSet<org.eclipse.emf.ecore.EFactory>();
    res.add(getTfsm_plaink3Factory());
    return res;
  }
  
  @Override
  public void save(final String uri) throws IOException {
    this.adaptee.setURI(URI.createURI(uri));
    this.adaptee.save(null);
  }
}
