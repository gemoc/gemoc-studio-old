package org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.sequential.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EvaluateGuard;

@SuppressWarnings("all")
public class EvaluateGuardAdapter extends EObjectAdapter<EvaluateGuard> implements org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.EvaluateGuard {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public EvaluateGuardAdapter() {
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
  public String getCondition() {
    return adaptee.getCondition();
  }
  
  @Override
  public void setCondition(final String o) {
    adaptee.setCondition(o);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.sequential.xtfsm.aspects.GuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static String CONDITION_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getEvaluateGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__CONDITION:
    		return getCondition();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__CONDITION:
    		return getCondition() != CONDITION_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.sequential.xtfsmmt.tfsm.TfsmPackage.EVALUATE_GUARD__CONDITION:
    		setCondition(
    		(java.lang.String)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
