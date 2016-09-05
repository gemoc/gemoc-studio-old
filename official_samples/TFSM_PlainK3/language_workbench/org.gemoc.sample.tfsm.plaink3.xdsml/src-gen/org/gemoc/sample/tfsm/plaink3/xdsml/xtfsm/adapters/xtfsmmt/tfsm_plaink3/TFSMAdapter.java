package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Transition;

@SuppressWarnings("all")
public class TFSMAdapter extends EObjectAdapter<TFSM> implements org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.TFSM {
  private org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory adaptersFactory;
  
  public TFSMAdapter() {
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
    	adaptee.setInitialState(((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter) o).getAdaptee());
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
    	adaptee.setLocalClock(((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMClockAdapter) o).getAdaptee());
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
  public State getCurrentState() {
    return (State) adaptersFactory.createAdapter(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect.currentState(adaptee), eResource);
  }
  
  @Override
  public void setCurrentState(final State currentState) {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect.currentState(adaptee, ((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter) currentState).getAdaptee()
    );
  }
  
  @Override
  public void init() {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspect.init(adaptee);
  }
  
  @Override
  public int getLastStateChangeStepNumber() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect.lastStateChangeStepNumber(adaptee);
  }
  
  @Override
  public void setLastStateChangeStepNumber(final int lastStateChangeStepNumber) {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect.lastStateChangeStepNumber(adaptee, lastStateChangeStepNumber
    );
  }
  
  @Override
  public int getStepNumber() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect.stepNumber(adaptee);
  }
  
  @Override
  public void setStepNumber(final int stepNumber) {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect.stepNumber(adaptee, stepNumber
    );
  }
  
  @Override
  public void visit() {
    org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMVisitorAspect.visit(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int STEP_NUMBER_EDEFAULT = 0;
  
  protected final static int LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.eINSTANCE.getTFSM();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_STATES:
    		return getOwnedStates();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__INITIAL_STATE:
    		return getInitialState();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_EVENTS:
    		return getLocalEvents();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_CLOCK:
    		return getLocalClock();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__CURRENT_STATE:
    		return getCurrentState();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__STEP_NUMBER:
    		return new java.lang.Integer(getStepNumber());
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		return new java.lang.Integer(getLastStateChangeStepNumber());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_STATES:
    		return getOwnedStates() != null && !getOwnedStates().isEmpty();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__INITIAL_STATE:
    		return getInitialState() != null;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_EVENTS:
    		return getLocalEvents() != null && !getLocalEvents().isEmpty();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_CLOCK:
    		return getLocalClock() != null;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions() != null && !getOwnedTransitions().isEmpty();
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__CURRENT_STATE:
    		return getCurrentState() != null;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__STEP_NUMBER:
    		return getStepNumber() != STEP_NUMBER_EDEFAULT;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		return getLastStateChangeStepNumber() != LAST_STATE_CHANGE_STEP_NUMBER_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_STATES:
    		getOwnedStates().clear();
    		getOwnedStates().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__INITIAL_STATE:
    		setInitialState(
    		(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_EVENTS:
    		getLocalEvents().clear();
    		getLocalEvents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LOCAL_CLOCK:
    		setLocalClock(
    		(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__OWNED_TRANSITIONS:
    		getOwnedTransitions().clear();
    		getOwnedTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__CURRENT_STATE:
    		setCurrentState(
    		(org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__STEP_NUMBER:
    		setStepNumber(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.tfsm.plaink3.xdsml.xtfsmmt.tfsm_plaink3.Tfsm_plaink3Package.TFSM__LAST_STATE_CHANGE_STEP_NUMBER:
    		setLastStateChangeStepNumber(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
