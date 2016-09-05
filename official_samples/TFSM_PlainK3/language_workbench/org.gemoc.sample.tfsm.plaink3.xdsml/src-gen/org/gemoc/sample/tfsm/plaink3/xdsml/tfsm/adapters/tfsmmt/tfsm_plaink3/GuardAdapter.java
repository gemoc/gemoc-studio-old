package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Guard;

@SuppressWarnings("all")
public class GuardAdapter extends EObjectAdapter<Guard> implements org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Guard {
  private TfsmMTAdaptersFactory adaptersFactory;
  
  public GuardAdapter() {
    super(org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.GuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE.getGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.GUARD__NAME:
    		return getName();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
