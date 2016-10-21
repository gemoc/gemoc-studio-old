package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.Transition;

@SuppressWarnings("all")
public class StateAdapter extends EObjectAdapter<State> implements org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.State {
  private XSTFSMMTAdaptersFactory adaptersFactory;
  
  public StateAdapter() {
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
  
  @Override
  public TimedFSM getOwningFSM() {
    return (TimedFSM) adaptersFactory.createAdapter(adaptee.getOwningFSM(), eResource);
  }
  
  @Override
  public void setOwningFSM(final TimedFSM o) {
    if (o != null)
    	adaptee.setOwningFSM(((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedFSMAdapter) o).getAdaptee());
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
  
  @Override
  public void onEnter() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspect.onEnter(adaptee);
  }
  
  @Override
  public void onLeave() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateAspect.onLeave(adaptee);
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.eINSTANCE.getState();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		return getOwningFSM();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		return getOutgoingTransitions();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		return getIncomingTransitions();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		return getOwningFSM() != null;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		return getOutgoingTransitions() != null && !getOutgoingTransitions().isEmpty();
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		return getIncomingTransitions() != null && !getIncomingTransitions().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OWNING_FSM:
    		setOwningFSM(
    		(org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TimedFSM)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__OUTGOING_TRANSITIONS:
    		getOutgoingTransitions().clear();
    		getOutgoingTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.xstfsm.xstfsmmt.tfsm.TfsmPackage.STATE__INCOMING_TRANSITIONS:
    		getIncomingTransitions().clear();
    		getIncomingTransitions().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
