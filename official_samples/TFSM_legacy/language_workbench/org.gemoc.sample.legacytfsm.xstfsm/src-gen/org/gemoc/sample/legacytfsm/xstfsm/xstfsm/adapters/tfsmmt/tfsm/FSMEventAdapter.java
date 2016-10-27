package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;

@SuppressWarnings("all")
public class FSMEventAdapter extends EObjectAdapter<FSMEvent> implements org.gemoc.sample.legacytfsm.tfsm.FSMEvent {
  private TFSMMTAdaptersFactory adaptersFactory;
  
  public FSMEventAdapter() {
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
    return org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE.getFSMEvent();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		return getSollicitingTransitions() != null && !getSollicitingTransitions().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.FSM_EVENT__SOLLICITING_TRANSITIONS:
    		getSollicitingTransitions().clear();
    		getSollicitingTransitions().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
