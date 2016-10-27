package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EvaluateGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EventGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMEventAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.GuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.NamedElementAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.StateAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TemporalGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimeFSMAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimedSystemAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TransitionAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.NamedElement;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;

@SuppressWarnings("all")
public class TFSMMTAdaptersFactory implements AdaptersFactory {
  private static TFSMMTAdaptersFactory instance;
  
  public static TFSMMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.TFSMMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public TFSMMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM){
    	return createTimeFSMAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State){
    	return createStateAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition){
    	return createTransitionAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard){
    	return createTemporalGuardAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard){
    	return createEventGuardAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent){
    	return createFSMEventAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock){
    	return createFSMClockAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem){
    	return createTimedSystemAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem) o, res);
    }
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard){
    	return createEvaluateGuardAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard) o, res);
    }
    
    return null;
  }
  
  public TimeFSMAdapter createTimeFSMAdapter(final TimeFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimeFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimeFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimeFSMAdapter) adapter;
    }
  }
  
  public StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.StateAdapter) adapter;
    }
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TransitionAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.NamedElementAdapter) adapter;
    }
  }
  
  public GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.GuardAdapter) adapter;
    }
  }
  
  public TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TemporalGuardAdapter) adapter;
    }
  }
  
  public EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EventGuardAdapter) adapter;
    }
  }
  
  public FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMEventAdapter) adapter;
    }
  }
  
  public FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.FSMClockAdapter) adapter;
    }
  }
  
  public TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.TimedSystemAdapter) adapter;
    }
  }
  
  public EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.tfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    }
  }
}
