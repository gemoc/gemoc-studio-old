package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EvaluateGuardAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EventGuardAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMClockAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMEventAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.GuardAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.NamedElementAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.StateAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TFSMAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TemporalGuardAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TimedSystemAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TransitionAdapter;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EvaluateGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Guard;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.NamedElement;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TemporalGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TimedSystem;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Transition;

@SuppressWarnings("all")
public class TfsmMTAdaptersFactory implements AdaptersFactory {
  private static TfsmMTAdaptersFactory instance;
  
  public static TfsmMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.TfsmMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public TfsmMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TFSM){
    	return createTFSMAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TFSM) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.State){
    	return createStateAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.State) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Transition){
    	return createTransitionAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.Transition) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TemporalGuard){
    	return createTemporalGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TemporalGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard){
    	return createEventGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EventGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent){
    	return createFSMEventAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock){
    	return createFSMClockAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TimedSystem){
    	return createTimedSystemAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TimedSystem) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EvaluateGuard){
    	return createEvaluateGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.EvaluateGuard) o, res);
    }
    
    return null;
  }
  
  public TFSMAdapter createTFSMAdapter(final TFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TFSMAdapter) adapter;
    }
  }
  
  public StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.StateAdapter) adapter;
    }
  }
  
  public TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TransitionAdapter) adapter;
    }
  }
  
  public NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.NamedElementAdapter) adapter;
    }
  }
  
  public GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.GuardAdapter) adapter;
    }
  }
  
  public TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TemporalGuardAdapter) adapter;
    }
  }
  
  public EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EventGuardAdapter) adapter;
    }
  }
  
  public FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMEventAdapter) adapter;
    }
  }
  
  public FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.FSMClockAdapter) adapter;
    }
  }
  
  public TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.TimedSystemAdapter) adapter;
    }
  }
  
  public EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.adapters.tfsmmt.tfsm_plaink3.EvaluateGuardAdapter) adapter;
    }
  }
}
