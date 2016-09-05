package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EvaluateGuard;

@SuppressWarnings("all")
public class EvaluateGuardAdapter extends EObjectAdapter<EvaluateGuard> implements org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.EvaluateGuard {
  private TfsmMTAdaptersFactory adaptersFactory;
  
  public EvaluateGuardAdapter() {
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
  public String getCondition() {
    return adaptee.getCondition();
  }
  
  @Override
  public void setCondition(final String o) {
    adaptee.setCondition(o);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.GuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static String CONDITION_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE.getEvaluateGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__CONDITION:
    		return getCondition();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__CONDITION:
    		return getCondition() != CONDITION_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.tfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVALUATE_GUARD__CONDITION:
    		setCondition(
    		(java.lang.String)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
