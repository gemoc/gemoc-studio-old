package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EvaluateGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EventGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMClockAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMEventAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.GuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.NamedElementAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.StateAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TemporalGuardAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedFSMAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedSystemAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TransitionAdapter;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EvaluateGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMEvent;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.NamedElement;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;

@SuppressWarnings("all")
public class XSTFSMMTAdaptersFactory implements AdaptersFactory {
  private static XSTFSMMTAdaptersFactory instance;
  
  public static XSTFSMMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.XSTFSMMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public XSTFSMMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM){
    	return createTimedFSMAdapter((org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM) o, res);
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
  
  public TimedFSMAdapter createTimedFSMAdapter(final TimedFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedFSMAdapter) adapter;
    }
  }
  
  public StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.StateAdapter) adapter;
    }
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TransitionAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.NamedElementAdapter) adapter;
    }
  }
  
  public GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.GuardAdapter) adapter;
    }
  }
  
  public TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TemporalGuardAdapter) adapter;
    }
  }
  
  public EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EventGuardAdapter) adapter;
    }
  }
  
  public FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMEventAdapter) adapter;
    }
  }
  
  public FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.FSMClockAdapter) adapter;
    }
  }
  
  public TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.TimedSystemAdapter) adapter;
    }
  }
  
  public EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.legacytfsm.xstfsm.xstfsm.adapters.xstfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    }
  }
}
