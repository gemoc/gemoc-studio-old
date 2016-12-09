package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;

@SuppressWarnings("all")
public class FSMClockAdapter extends EObjectAdapter<FSMClock> implements org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMClock {
  private XSFSMMTAdaptersFactory adaptersFactory;
  
  public FSMClockAdapter() {
    super(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory.getInstance();
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
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspect.numberOfTicks(adaptee);
  }
  
  @Override
  public void setNumberOfTicks(final Integer numberOfTicks) {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspect.numberOfTicks(adaptee, numberOfTicks
    );
  }
  
  @Override
  public Integer ticks() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspect.ticks(adaptee);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static Integer NUMBER_OF_TICKS_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.eINSTANCE.getFSMClock();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NAME:
    		return getName();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		return getNumberOfTicks();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		return getNumberOfTicks() != NUMBER_OF_TICKS_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		setNumberOfTicks(
    		(java.lang.Integer)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
