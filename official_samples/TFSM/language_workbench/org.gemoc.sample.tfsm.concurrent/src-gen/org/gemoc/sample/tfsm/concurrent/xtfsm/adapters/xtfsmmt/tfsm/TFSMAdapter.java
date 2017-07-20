/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
package org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.Transition;

@SuppressWarnings("all")
public class TFSMAdapter extends EObjectAdapter<TFSM> implements org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TFSM {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public TFSMAdapter() {
    super(org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
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
    	adaptee.setInitialState(((org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter) o).getAdaptee());
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
    	adaptee.setLocalClock(((org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter) o).getAdaptee());
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
  public void changeCurrentState(final State newState) {
    org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect.changeCurrentState(adaptee, (org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State)((EObjectAdapter)newState).getAdaptee()
    );
  }
  
  @Override
  public State getCurrentState() {
    return (State) adaptersFactory.createAdapter(org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect.currentState(adaptee), eResource);
  }
  
  @Override
  public void setCurrentState(final State currentState) {
    org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect.currentState(adaptee, (org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State)((EObjectAdapter)currentState).getAdaptee()
    );
  }
  
  @Override
  public String initialize() {
    return org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TFSMAspect.initialize(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getTFSM();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_STATES:
    		return getOwnedStates();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__INITIAL_STATE:
    		return getInitialState();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_EVENTS:
    		return getLocalEvents();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_CLOCK:
    		return getLocalClock();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__CURRENT_STATE:
    		return getCurrentState();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_STATES:
    		return getOwnedStates() != null && !getOwnedStates().isEmpty();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__INITIAL_STATE:
    		return getInitialState() != null;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_EVENTS:
    		return getLocalEvents() != null && !getLocalEvents().isEmpty();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_CLOCK:
    		return getLocalClock() != null;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_TRANSITIONS:
    		return getOwnedTransitions() != null && !getOwnedTransitions().isEmpty();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__CURRENT_STATE:
    		return getCurrentState() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_STATES:
    		getOwnedStates().clear();
    		getOwnedStates().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__INITIAL_STATE:
    		setInitialState(
    		(org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.State)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_EVENTS:
    		getLocalEvents().clear();
    		getLocalEvents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__LOCAL_CLOCK:
    		setLocalClock(
    		(org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__OWNED_TRANSITIONS:
    		getOwnedTransitions().clear();
    		getOwnedTransitions().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TFSM__CURRENT_STATE:
    		setCurrentState(
    		(org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.State)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
