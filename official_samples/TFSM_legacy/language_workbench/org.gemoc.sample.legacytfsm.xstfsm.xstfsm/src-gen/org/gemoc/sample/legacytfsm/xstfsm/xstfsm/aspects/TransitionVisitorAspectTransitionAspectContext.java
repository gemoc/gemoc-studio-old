package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectProperties;

@SuppressWarnings("all")
public class TransitionVisitorAspectTransitionAspectContext {
  public final static TransitionVisitorAspectTransitionAspectContext INSTANCE = new TransitionVisitorAspectTransitionAspectContext();
  
  public static TransitionVisitorAspectTransitionAspectProperties getSelf(final Transition _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Transition, TransitionVisitorAspectTransitionAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Transition, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TransitionVisitorAspectTransitionAspectProperties>();
  
  public Map<Transition, TransitionVisitorAspectTransitionAspectProperties> getMap() {
    return map;
  }
}
