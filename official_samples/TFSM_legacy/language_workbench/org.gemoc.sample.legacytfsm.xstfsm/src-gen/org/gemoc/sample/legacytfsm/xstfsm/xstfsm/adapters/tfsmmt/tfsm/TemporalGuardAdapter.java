package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;

@SuppressWarnings("all")
public class TemporalGuardAdapter extends EObjectAdapter<TemporalGuard> implements org.gemoc.sample.legacytfsm.tfsm.TemporalGuard {
  private TFSMMTAdaptersFactory adaptersFactory;
  
  public TemporalGuardAdapter() {
    super(org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory.getInstance();
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
  public int getAfterDuration() {
    return adaptee.getAfterDuration();
  }
  
  @Override
  public void setAfterDuration(final int o) {
    adaptee.setAfterDuration(o);
  }
  
  @Override
  public FSMClock getOnClock() {
    return (FSMClock) adaptersFactory.createAdapter(adaptee.getOnClock(), eResource);
  }
  
  @Override
  public void setOnClock(final FSMClock o) {
    if (o != null)
    	adaptee.setOnClock(((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter) o).getAdaptee());
    else adaptee.setOnClock(null);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int AFTER_DURATION_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE.getTemporalGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		return getOnClock();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		return new java.lang.Integer(getAfterDuration());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		return getOnClock() != null;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		return getAfterDuration() != AFTER_DURATION_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__ON_CLOCK:
    		setOnClock(
    		(org.gemoc.sample.legacytfsm.tfsm.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TEMPORAL_GUARD__AFTER_DURATION:
    		setAfterDuration(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}