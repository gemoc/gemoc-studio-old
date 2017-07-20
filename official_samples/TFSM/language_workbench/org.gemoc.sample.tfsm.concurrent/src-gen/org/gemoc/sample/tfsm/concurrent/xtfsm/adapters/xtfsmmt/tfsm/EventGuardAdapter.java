/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
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
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EventGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMEvent;

@SuppressWarnings("all")
public class EventGuardAdapter extends EObjectAdapter<EventGuard> implements org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.EventGuard {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public EventGuardAdapter() {
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
  
  @Override
  public FSMEvent getTriggeringEvent() {
    return (FSMEvent) adaptersFactory.createAdapter(adaptee.getTriggeringEvent(), eResource);
  }
  
  @Override
  public void setTriggeringEvent(final FSMEvent o) {
    if (o != null)
    	adaptee.setTriggeringEvent(((org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMEventAdapter) o).getAdaptee());
    else adaptee.setTriggeringEvent(null);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getEventGuard();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		return getTriggeringEvent() != null;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.EVENT_GUARD__TRIGGERING_EVENT:
    		setTriggeringEvent(
    		(org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMEvent)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
