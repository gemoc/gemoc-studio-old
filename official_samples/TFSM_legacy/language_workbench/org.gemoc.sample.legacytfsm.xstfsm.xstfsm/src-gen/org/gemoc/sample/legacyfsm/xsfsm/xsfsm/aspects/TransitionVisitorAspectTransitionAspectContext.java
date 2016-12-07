package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TransitionVisitorAspectTransitionAspectProperties;

@SuppressWarnings("all")
public class TransitionVisitorAspectTransitionAspectContext {
  public final static TransitionVisitorAspectTransitionAspectContext INSTANCE = new TransitionVisitorAspectTransitionAspectContext();
  
  public static TransitionVisitorAspectTransitionAspectProperties getSelf(final Transition _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TransitionVisitorAspectTransitionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Transition, TransitionVisitorAspectTransitionAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Transition, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TransitionVisitorAspectTransitionAspectProperties>();
  
  public Map<Transition, TransitionVisitorAspectTransitionAspectProperties> getMap() {
    return map;
  }
}
