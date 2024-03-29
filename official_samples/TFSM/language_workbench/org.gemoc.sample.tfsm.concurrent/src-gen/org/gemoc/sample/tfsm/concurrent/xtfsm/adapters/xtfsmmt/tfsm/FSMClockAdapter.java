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
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;

@SuppressWarnings("all")
public class FSMClockAdapter extends EObjectAdapter<FSMClock> implements org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock {
  private XTfsmMTAdaptersFactory adaptersFactory;
  
  public FSMClockAdapter() {
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
  public int getNumberOfTicks() {
    return org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspect.numberOfTicks(adaptee);
  }
  
  @Override
  public void setNumberOfTicks(final int numberOfTicks) {
    org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspect.numberOfTicks(adaptee, numberOfTicks
    );
  }
  
  @Override
  public String ticks() {
    return org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspect.ticks(adaptee);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int NUMBER_OF_TICKS_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE.getFSMClock();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NAME:
    		return getName();
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		return new java.lang.Integer(getNumberOfTicks());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		return getNumberOfTicks() != NUMBER_OF_TICKS_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.FSM_CLOCK__NUMBER_OF_TICKS:
    		setNumberOfTicks(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
