package org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.Guard;

@SuppressWarnings("all")
public class GuardAdapter extends EObjectAdapter<Guard> implements org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.Guard {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public GuardAdapter() {
    super(org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
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
    org.gemoc.sample.tfsm.sequential.xtfsm.aspects.GuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.GUARD__NAME:
    		return getName();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
