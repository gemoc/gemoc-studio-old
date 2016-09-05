package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMEvent;

@SuppressWarnings("all")
public class EventGuardAdapter extends EObjectAdapter<EventGuard> implements org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.EventGuard {
  private org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory adaptersFactory;
  
  public EventGuardAdapter() {
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
  public FSMEvent getTriggeringEvent() {
    return (FSMEvent) adaptersFactory.createAdapter(adaptee.getTriggeringEvent(), eResource);
  }
  
  @Override
  public void setTriggeringEvent(final FSMEvent o) {
    if (o != null)
    	adaptee.setTriggeringEvent(((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMEventAdapter) o).getAdaptee());
    else adaptee.setTriggeringEvent(null);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.EventGuardVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE.getEventGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.EVENT_GUARD__TRIGGERING_EVENT:
    		setTriggeringEvent(
    		(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMEvent)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
