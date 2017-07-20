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
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TFSM;

@SuppressWarnings("all")
public class TimedSystemAdapter extends EObjectAdapter<TimedSystem> implements org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TimedSystem {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public TimedSystemAdapter() {
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
  
  private EList<TFSM> tfsms_;
  
  @Override
  public EList<TFSM> getTfsms() {
    if (tfsms_ == null)
    	tfsms_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getTfsms(), adaptersFactory, eResource);
    return tfsms_;
  }
  
  private EList<FSMClock> globalClocks_;
  
  @Override
  public EList<FSMClock> getGlobalClocks() {
    if (globalClocks_ == null)
    	globalClocks_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getGlobalClocks(), adaptersFactory, eResource);
    return globalClocks_;
  }
  
  private EList<FSMEvent> globalEvents_;
  
  @Override
  public EList<FSMEvent> getGlobalEvents() {
    if (globalEvents_ == null)
    	globalEvents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getGlobalEvents(), adaptersFactory, eResource);
    return globalEvents_;
  }
  
  @Override
  public String initialize() {
    return org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TimedSystemAspect.initialize(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getTimedSystem();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__TFSMS:
    		return getTfsms();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		return getGlobalClocks();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		return getGlobalEvents();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__TFSMS:
    		return getTfsms() != null && !getTfsms().isEmpty();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		return getGlobalClocks() != null && !getGlobalClocks().isEmpty();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		return getGlobalEvents() != null && !getGlobalEvents().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__TFSMS:
    		getTfsms().clear();
    		getTfsms().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_CLOCKS:
    		getGlobalClocks().clear();
    		getGlobalClocks().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.TIMED_SYSTEM__GLOBAL_EVENTS:
    		getGlobalEvents().clear();
    		getGlobalEvents().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
