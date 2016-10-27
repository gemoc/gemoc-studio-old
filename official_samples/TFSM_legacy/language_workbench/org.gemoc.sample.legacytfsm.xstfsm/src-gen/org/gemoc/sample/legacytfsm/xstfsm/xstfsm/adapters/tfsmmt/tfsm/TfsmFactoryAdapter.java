package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.gemoc.sample.legacytfsm.tfsm.EvaluateGuard;
import org.gemoc.sample.legacytfsm.tfsm.EventGuard;
import org.gemoc.sample.legacytfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.tfsm.TemporalGuard;
import org.gemoc.sample.legacytfsm.tfsm.TfsmFactory;
import org.gemoc.sample.legacytfsm.tfsm.TfsmPackage;
import org.gemoc.sample.legacytfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory;

@SuppressWarnings("all")
public class TfsmFactoryAdapter extends EFactoryImpl implements TfsmFactory {
  private TFSMMTAdaptersFactory adaptersFactory = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory.getInstance();
  
  private org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmFactory tfsmAdaptee = org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TfsmFactory.eINSTANCE;
  
  @Override
  public TimeFSM createTimeFSM() {
    return adaptersFactory.createTimeFSMAdapter(tfsmAdaptee.createTimeFSM(), null);
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
    return org.gemoc.sample.legacytfsm.tfsm.TfsmPackage.eINSTANCE;
  }
}
