package org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EvaluateGuardAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EventGuardAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMEventAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.GuardAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.NamedElementAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TFSMAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TemporalGuardAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TimedSystemAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TransitionAdapter;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EvaluateGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EventGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Guard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.NamedElement;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TimedSystem;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Transition;

@SuppressWarnings("all")
public class XTfsmMTAdaptersFactory implements AdaptersFactory {
  private static XTfsmMTAdaptersFactory instance;
  
  public static XTfsmMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public XTfsmMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM){
    	return createTFSMAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TFSM) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State){
    	return createStateAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.State) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Transition){
    	return createTransitionAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Transition) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard){
    	return createTemporalGuardAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EventGuard){
    	return createEventGuardAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EventGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent){
    	return createFSMEventAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock){
    	return createFSMClockAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TimedSystem){
    	return createTimedSystemAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TimedSystem) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EvaluateGuard){
    	return createEvaluateGuardAdapter((org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.EvaluateGuard) o, res);
    }
    
    return null;
  }
  
  public TFSMAdapter createTFSMAdapter(final TFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TFSMAdapter) adapter;
    }
  }
  
  public StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.StateAdapter) adapter;
    }
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TransitionAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.NamedElementAdapter) adapter;
    }
  }
  
  public GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.GuardAdapter) adapter;
    }
  }
  
  public TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TemporalGuardAdapter) adapter;
    }
  }
  
  public EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EventGuardAdapter) adapter;
    }
  }
  
  public FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMEventAdapter) adapter;
    }
  }
  
  public FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.FSMClockAdapter) adapter;
    }
  }
  
  public TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.TimedSystemAdapter) adapter;
    }
  }
  
  public EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.tfsm.EvaluateGuardAdapter) adapter;
    }
  }
}
