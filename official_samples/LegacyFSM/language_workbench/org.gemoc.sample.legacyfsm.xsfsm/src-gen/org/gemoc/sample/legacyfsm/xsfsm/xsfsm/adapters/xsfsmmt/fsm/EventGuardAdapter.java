package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMEvent;

@SuppressWarnings("all")
public class EventGuardAdapter extends EObjectAdapter<EventGuard> implements org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.EventGuard {
  private XSFSMMTAdaptersFactory adaptersFactory;
  
  public EventGuardAdapter() {
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
  public FSMEvent getTriggeringEvent() {
    return (FSMEvent) adaptersFactory.createAdapter(adaptee.getTriggeringEvent(), eResource);
  }
  
  @Override
  public void setTriggeringEvent(final FSMEvent o) {
    if (o != null)
    	adaptee.setTriggeringEvent(((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMEventAdapter) o).getAdaptee());
    else adaptee.setTriggeringEvent(null);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.eINSTANCE.getEventGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		setTriggeringEvent(
    		(org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMEvent)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
