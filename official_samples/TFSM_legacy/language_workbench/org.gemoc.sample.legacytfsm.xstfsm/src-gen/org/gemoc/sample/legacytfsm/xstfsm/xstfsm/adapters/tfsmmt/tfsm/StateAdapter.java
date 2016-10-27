package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;

@SuppressWarnings("all")
public class StateAdapter extends EObjectAdapter<State> implements org.gemoc.sample.legacytfsm.tfsm.State {
  private TFSMMTAdaptersFactory adaptersFactory;
  
  public StateAdapter() {
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
  public TimeFSM getOwningFSM() {
    return (TimeFSM) adaptersFactory.createAdapter(adaptee.getOwningFSM(), eResource);
  }
  
  @Override
  public void setOwningFSM(final TimeFSM o) {
    if (o != null)
    	adaptee.setOwningFSM(((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimeFSMAdapter) o).getAdaptee());
    else adaptee.setOwningFSM(null);
  }
  
  private EList<Transition> outgoingTransitions_;
  
  @Override
  public EList<Transition> getOutgoingTransitions() {
    if (outgoingTransitions_ == null)
    	outgoingTransitions_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOutgoingTransitions(), adaptersFactory, eResource);
    return outgoingTransitions_;
  }
  
  private EList<Transition> incomingTransitions_;
  
  @Override
  public EList<Transition> getIncomingTransitions() {
    if (incomingTransitions_ == null)
    	incomingTransitions_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getIncomingTransitions(), adaptersFactory, eResource);
    return incomingTransitions_;
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE.getState();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		return getOwningFSM();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		return getOutgoingTransitions();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		return getIncomingTransitions();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		return getOwningFSM() != null;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		return getOutgoingTransitions() != null && !getOutgoingTransitions().isEmpty();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		return getIncomingTransitions() != null && !getIncomingTransitions().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		setOwningFSM(
    		(org.gemoc.sample.legacytfsm.tfsm.TimeFSM)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		getOutgoingTransitions().clear();
    		getOutgoingTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		getIncomingTransitions().clear();
    		getIncomingTransitions().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
