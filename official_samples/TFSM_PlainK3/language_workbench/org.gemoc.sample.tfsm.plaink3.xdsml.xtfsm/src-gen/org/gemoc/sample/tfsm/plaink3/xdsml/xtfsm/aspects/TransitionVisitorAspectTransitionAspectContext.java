package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition;

@SuppressWarnings("all")
public class TransitionVisitorAspectTransitionAspectContext {
  public final static TransitionVisitorAspectTransitionAspectContext INSTANCE = new TransitionVisitorAspectTransitionAspectContext();
  
  public static TransitionVisitorAspectTransitionAspectProperties getSelf(final Transition _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Transition, TransitionVisitorAspectTransitionAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Transition, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TransitionVisitorAspectTransitionAspectProperties>();
  
  public Map<Transition, TransitionVisitorAspectTransitionAspectProperties> getMap() {
    return map;
  }
}
