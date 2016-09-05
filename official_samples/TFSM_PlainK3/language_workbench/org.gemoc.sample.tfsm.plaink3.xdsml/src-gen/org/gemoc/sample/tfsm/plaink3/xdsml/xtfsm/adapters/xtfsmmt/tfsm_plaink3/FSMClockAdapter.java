package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;

@SuppressWarnings("all")
public class FSMClockAdapter extends EObjectAdapter<FSMClock> implements org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMClock {
  private org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory adaptersFactory;
  
  public FSMClockAdapter() {
    super(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
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
  public Integer getNumberOfTicks() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect.numberOfTicks(adaptee);
  }
  
  @Override
  public void setNumberOfTicks(final Integer numberOfTicks) {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect.numberOfTicks(adaptee, numberOfTicks
    );
  }
  
  @Override
  public Integer ticks() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspect.ticks(adaptee);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static Integer NUMBER_OF_TICKS_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE.getFSMClock();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
    		return getNumberOfTicks();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
    		return getNumberOfTicks() != NUMBER_OF_TICKS_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.FSM_CLOCK__NUMBER_OF_TICKS:
    		setNumberOfTicks(
    		(java.lang.Integer)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
