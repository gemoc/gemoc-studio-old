package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacyfsm.fsm.Transition;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;

@SuppressWarnings("all")
public class FSMEventAdapter extends EObjectAdapter<FSMEvent> implements org.gemoc.sample.legacyfsm.fsm.FSMEvent {
  private FSMMTAdaptersFactory adaptersFactory;
  
  public FSMEventAdapter() {
    super(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.fsmmt.FSMMTAdaptersFactory.getInstance();
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
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacyfsm.fsm.FsmPackage.eINSTANCE.getFSMEvent();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__NAME:
    		return getName();
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions() != null && !getSollicitingTransitions().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.fsm.FsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		getSollicitingTransitions().clear();
    		getSollicitingTransitions().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
