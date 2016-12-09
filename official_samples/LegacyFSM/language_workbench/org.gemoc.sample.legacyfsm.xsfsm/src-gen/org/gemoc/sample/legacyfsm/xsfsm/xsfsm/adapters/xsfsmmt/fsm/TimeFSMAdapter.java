package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.Transition;

@SuppressWarnings("all")
public class TimeFSMAdapter extends EObjectAdapter<TimeFSM> implements org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.TimeFSM {
  private XSFSMMTAdaptersFactory adaptersFactory;
  
  public TimeFSMAdapter() {
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
    	adaptee.setInitialState(((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.StateAdapter) o).getAdaptee());
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
    	adaptee.setLocalClock(((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMClockAdapter) o).getAdaptee());
    else adaptee.setLocalClock(null);
  }
  
  private EList<Transition> ownedTransitions_;
  
  @Override
  public EList<Transition> getOwnedTransitions() {
    if (ownedTransitions_ == null)
    	ownedTransitions_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedTransitions(), adaptersFactory, eResource);
    return ownedTransitions_;
  }
  
  @Override
  public int getLastStateChangeStepNumber() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect.lastStateChangeStepNumber(adaptee);
  }
  
  @Override
  public void setLastStateChangeStepNumber(final int lastStateChangeStepNumber) {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect.lastStateChangeStepNumber(adaptee, lastStateChangeStepNumber
    );
  }
  
  @Override
  public int getStepNumber() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect.stepNumber(adaptee);
  }
  
  @Override
  public void setStepNumber(final int stepNumber) {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect.stepNumber(adaptee, stepNumber
    );
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspect.visit(adaptee);
  }
  
  @Override
  public State getCurrentState() {
    return (State) adaptersFactory.createAdapter(org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspect.currentState(adaptee), eResource);
  }
  
  @Override
  public void setCurrentState(final State currentState) {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspect.currentState(adaptee, (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State)((EObjectAdapter)currentState).getAdaptee()
    );
  }
  
  @Override
  public void init() {
    org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspect.init(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int STEP_NUMBER_EDEFAULT = 0;
  
  protected final static int LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.eINSTANCE.getTimeFSM();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__NAME:
    		return getName();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_STATES:
    		return getOwnedStates();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__INITIAL_STATE:
    		return getInitialState();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_EVENTS:
    		return getLocalEvents();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_CLOCK:
    		return getLocalClock();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__STEP_NUMBER:
    		return new java.lang.Integer(getStepNumber());
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		return new java.lang.Integer(getLastStateChangeStepNumber());
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__CURRENT_STATE:
    		return getCurrentState();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_STATES:
    		return getOwnedStates() != null && !getOwnedStates().isEmpty();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__INITIAL_STATE:
    		return getInitialState() != null;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_EVENTS:
    		return getLocalEvents() != null && !getLocalEvents().isEmpty();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_CLOCK:
    		return getLocalClock() != null;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions() != null && !getOwnedTransitions().isEmpty();
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__STEP_NUMBER:
    		return getStepNumber() != STEP_NUMBER_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		return getLastStateChangeStepNumber() != LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__CURRENT_STATE:
    		return getCurrentState() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_STATES:
    		getOwnedStates().clear();
    		getOwnedStates().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__INITIAL_STATE:
    		setInitialState(
    		(org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_EVENTS:
    		getLocalEvents().clear();
    		getLocalEvents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LOCAL_CLOCK:
    		setLocalClock(
    		(org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__OWNED_TRANSITIONS:
    		getOwnedTransitions().clear();
    		getOwnedTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__STEP_NUMBER:
    		setStepNumber(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		setLastStateChangeStepNumber(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.FsmPackage.TIME_FSM__CURRENT_STATE:
    		setCurrentState(
    		(org.gemoc.sample.legacyfsm.xsfsm.xsfsmmt.fsm.State)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
