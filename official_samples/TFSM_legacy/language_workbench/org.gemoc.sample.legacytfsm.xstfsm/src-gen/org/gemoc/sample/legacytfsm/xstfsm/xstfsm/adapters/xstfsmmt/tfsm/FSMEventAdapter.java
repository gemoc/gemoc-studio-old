package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.Transition;

@SuppressWarnings("all")
public class FSMEventAdapter extends EObjectAdapter<FSMEvent> implements org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.FSMEvent {
  private XSTFSMMTAdaptersFactory adaptersFactory;
  
  public FSMEventAdapter() {
    super(org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  private EList<Transition> sollicitingTransitions_;
  
  @Override
  public EList<Transition> getSollicitingTransitions() {
    if (sollicitingTransitions_ == null)
    	sollicitingTransitions_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getSollicitingTransitions(), adaptersFactory, eResource);
    return sollicitingTransitions_;
  }
  
  @Override
  public boolean isIsTriggered() {
    return org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect.isTriggered(adaptee);
  }
  
  @Override
  public void setIsTriggered(final boolean isTriggered) {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect.isTriggered(adaptee, isTriggered
    );
  }
  
  @Override
  public void trigger() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect.trigger(adaptee);
  }
  
  @Override
  public void unTrigger() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMEventAspect.unTrigger(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static boolean IS_TRIGGERED_EDEFAULT = false;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.eINSTANCE.getFSMEvent();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__IS_TRIGGERED:
    		return isIsTriggered() ? Boolean.TRUE : Boolean.FALSE;
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions() != null && !getSollicitingTransitions().isEmpty();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__IS_TRIGGERED:
    		return isIsTriggered() != IS_TRIGGERED_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		getSollicitingTransitions().clear();
    		getSollicitingTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.FSM_EVENT__IS_TRIGGERED:
    		setIsTriggered(((java.lang.Boolean) newValue).booleanValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
