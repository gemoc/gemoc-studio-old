package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EvaluateGuardAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EventGuardAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMClockAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMEventAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.GuardAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.NamedElementAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.StateAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TemporalGuardAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimeFSMAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimedSystemAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TransitionAdapter;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.NamedElement;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition;

@SuppressWarnings("all")
public class XSFSMMTAdaptersFactory implements AdaptersFactory {
  private static XSFSMMTAdaptersFactory instance;
  
  public static XSFSMMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.XSFSMMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public XSFSMMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM){
    	return createTimeFSMAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State){
    	return createStateAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition){
    	return createTransitionAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard){
    	return createTemporalGuardAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard){
    	return createEventGuardAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent){
    	return createFSMEventAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock){
    	return createFSMClockAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem){
    	return createTimedSystemAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem) o, res);
    }
    if (o instanceof org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard){
    	return createEvaluateGuardAdapter((org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EvaluateGuard) o, res);
    }
    
    return null;
  }
  
  public TimeFSMAdapter createTimeFSMAdapter(final TimeFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimeFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimeFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimeFSMAdapter) adapter;
    }
  }
  
  public StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.StateAdapter) adapter;
    }
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TransitionAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.NamedElementAdapter) adapter;
    }
  }
  
  public GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.GuardAdapter) adapter;
    }
  }
  
  public TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TemporalGuardAdapter) adapter;
    }
  }
  
  public EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EventGuardAdapter) adapter;
    }
  }
  
  public FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMEventAdapter) adapter;
    }
  }
  
  public FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.FSMClockAdapter) adapter;
    }
  }
  
  public TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.TimedSystemAdapter) adapter;
    }
  }
  
  public EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacyfsm.xsfsm.xsfsm.adapters.xsfsmmt.fsm.EvaluateGuardAdapter) adapter;
    }
  }
}
