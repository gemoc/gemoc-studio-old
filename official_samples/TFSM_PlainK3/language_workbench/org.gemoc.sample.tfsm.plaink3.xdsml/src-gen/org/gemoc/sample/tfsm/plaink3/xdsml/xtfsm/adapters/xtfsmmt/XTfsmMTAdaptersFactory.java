package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt;

import fr.inria.diverse.melange.adapters.AdaptersFactory;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.WeakHashMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.NamedElement;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@SuppressWarnings("all")
public class XTfsmMTAdaptersFactory implements AdaptersFactory {
  private static org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory instance;
  
  public static org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory getInstance() {
    if (instance == null) {
    	instance = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.XTfsmMTAdaptersFactory();
    }
    return instance;
  }
  
  private WeakHashMap<EObject, EObjectAdapter> register;
  
  public XTfsmMTAdaptersFactory() {
    register = new WeakHashMap();
  }
  
  public EObjectAdapter createAdapter(final EObject o, final Resource res) {
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM){
    	return createTFSMAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State){
    	return createStateAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.State) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition){
    	return createTransitionAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard){
    	return createTemporalGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard){
    	return createEventGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EventGuard) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent){
    	return createFSMEventAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMEvent) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock){
    	return createFSMClockAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem){
    	return createTimedSystemAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem) o, res);
    }
    if (o instanceof org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard){
    	return createEvaluateGuardAdapter((org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.EvaluateGuard) o, res);
    }
    
    return null;
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TFSMAdapter createTFSMAdapter(final TFSM adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TFSMAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TFSMAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TFSMAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter createStateAdapter(final State adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.StateAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TransitionAdapter createTransitionAdapter(final Transition adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TransitionAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TransitionAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TransitionAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.NamedElementAdapter createNamedElementAdapter(final NamedElement adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.NamedElementAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.NamedElementAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.NamedElementAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.GuardAdapter createGuardAdapter(final Guard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.GuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.GuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.GuardAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TemporalGuardAdapter createTemporalGuardAdapter(final TemporalGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TemporalGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TemporalGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TemporalGuardAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EventGuardAdapter createEventGuardAdapter(final EventGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EventGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EventGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EventGuardAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMEventAdapter createFSMEventAdapter(final FSMEvent adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMEventAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMEventAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMEventAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMClockAdapter createFSMClockAdapter(final FSMClock adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMClockAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMClockAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.FSMClockAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TimedSystemAdapter createTimedSystemAdapter(final TimedSystem adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TimedSystemAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TimedSystemAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.TimedSystemAdapter) adapter;
    }
  }
  
  public org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EvaluateGuardAdapter createEvaluateGuardAdapter(final EvaluateGuard adaptee, final Resource res) {
    if (adaptee == null)
    	return null;
    EObjectAdapter adapter = register.get(adaptee);
    if(adapter != null)
    	 return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EvaluateGuardAdapter) adapter;
    else {
    	adapter = new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EvaluateGuardAdapter();
    	adapter.setAdaptee(adaptee);
    	adapter.setResource(res);
    	register.put(adaptee, adapter);
    	return (org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.adapters.xtfsmmt.tfsm_plaink3.EvaluateGuardAdapter) adapter;
    }
  }
}
