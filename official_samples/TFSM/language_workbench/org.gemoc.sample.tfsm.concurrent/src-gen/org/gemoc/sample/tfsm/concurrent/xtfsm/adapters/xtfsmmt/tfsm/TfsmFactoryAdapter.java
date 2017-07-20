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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.EventGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TFSM;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmFactory;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.Transition;

@SuppressWarnings("all")
public class TfsmFactoryAdapter extends EFactoryImpl implements TfsmFactory {
  private XTfsmMTAdaptersFactory adaptersFactory = org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory.getInstance();
  
  private org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmFactory tfsmAdaptee = org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmFactory.eINSTANCE;
  
  @Override
  public TFSM createTFSM() {
    return adaptersFactory.createTFSMAdapter(tfsmAdaptee.createTFSM(), null);
  }
  
  @Override
  public State createState() {
    return adaptersFactory.createStateAdapter(tfsmAdaptee.createState(), null);
  }
  
  @Override
  public Transition createTransition() {
    return adaptersFactory.createTransitionAdapter(tfsmAdaptee.createTransition(), null);
  }
  
  @Override
  public TemporalGuard createTemporalGuard() {
    return adaptersFactory.createTemporalGuardAdapter(tfsmAdaptee.createTemporalGuard(), null);
  }
  
  @Override
  public EventGuard createEventGuard() {
    return adaptersFactory.createEventGuardAdapter(tfsmAdaptee.createEventGuard(), null);
  }
  
  @Override
  public FSMEvent createFSMEvent() {
    return adaptersFactory.createFSMEventAdapter(tfsmAdaptee.createFSMEvent(), null);
  }
  
  @Override
  public FSMClock createFSMClock() {
    return adaptersFactory.createFSMClockAdapter(tfsmAdaptee.createFSMClock(), null);
  }
  
  @Override
  public TimedSystem createTimedSystem() {
    return adaptersFactory.createTimedSystemAdapter(tfsmAdaptee.createTimedSystem(), null);
  }
  
  @Override
  public EvaluateGuard createEvaluateGuard() {
    return adaptersFactory.createEvaluateGuardAdapter(tfsmAdaptee.createEvaluateGuard(), null);
  }
  
  @Override
  public EPackage getEPackage() {
    return getTfsmPackage();
  }
  
  public TfsmPackage getTfsmPackage() {
    return org.gemoc.sample.tfsm.concurrent.xtfsmmt.tfsm.TfsmPackage.eINSTANCE;
  }
}
