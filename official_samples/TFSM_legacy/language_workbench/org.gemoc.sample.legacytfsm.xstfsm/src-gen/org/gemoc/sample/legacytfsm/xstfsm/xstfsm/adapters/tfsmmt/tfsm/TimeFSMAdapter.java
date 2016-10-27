package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacytfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;

@SuppressWarnings("all")
public class TimeFSMAdapter extends EObjectAdapter<TimeFSM> implements org.gemoc.sample.legacytfsm.tfsm.TimeFSM {
  private TFSMMTAdaptersFactory adaptersFactory;
  
  public TimeFSMAdapter() {
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
  
  private EList<State> ownedStates_;
  
  @Override
  public EList<State> getOwnedStates() {
    if (ownedStates_ == null)
    	ownedStates_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedStates(), adaptersFactory, eResource);
    return ownedStates_;
  }
  
  @Override
  public State getInitialState() {
    return (State) adaptersFactory.createAdapter(adaptee.getInitialState(), eResource);
  }
  
  @Override
  public void setInitialState(final State o) {
    if (o != null)
    	adaptee.setInitialState(((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.StateAdapter) o).getAdaptee());
    else adaptee.setInitialState(null);
  }
  
  private EList<FSMEvent> localEvents_;
  
  @Override
  public EList<FSMEvent> getLocalEvents() {
    if (localEvents_ == null)
    	localEvents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getLocalEvents(), adaptersFactory, eResource);
    return localEvents_;
  }
  
  @Override
  public FSMClock getLocalClock() {
    return (FSMClock) adaptersFactory.createAdapter(adaptee.getLocalClock(), eResource);
  }
  
  @Override
  public void setLocalClock(final FSMClock o) {
    if (o != null)
    	adaptee.setLocalClock(((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter) o).getAdaptee());
    else adaptee.setLocalClock(null);
  }
  
  private EList<Transition> ownedTransitions_;
  
  @Override
  public EList<Transition> getOwnedTransitions() {
    if (ownedTransitions_ == null)
    	ownedTransitions_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedTransitions(), adaptersFactory, eResource);
    return ownedTransitions_;
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE.getTimeFSM();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__NAME:
    		return getName();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_STATES:
    		return getOwnedStates();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__INITIAL_STATE:
    		return getInitialState();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_EVENTS:
    		return getLocalEvents();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_CLOCK:
    		return getLocalClock();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_STATES:
    		return getOwnedStates() != null && !getOwnedStates().isEmpty();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__INITIAL_STATE:
    		return getInitialState() != null;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_EVENTS:
    		return getLocalEvents() != null && !getLocalEvents().isEmpty();
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_CLOCK:
    		return getLocalClock() != null;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions() != null && !getOwnedTransitions().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_STATES:
    		getOwnedStates().clear();
    		getOwnedStates().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__INITIAL_STATE:
    		setInitialState(
    		(org.gemoc.sample.legacytfsm.tfsm.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_EVENTS:
    		getLocalEvents().clear();
    		getLocalEvents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__LOCAL_CLOCK:
    		setLocalClock(
    		(org.gemoc.sample.legacytfsm.tfsm.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		getOwnedTransitions().clear();
    		getOwnedTransitions().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
