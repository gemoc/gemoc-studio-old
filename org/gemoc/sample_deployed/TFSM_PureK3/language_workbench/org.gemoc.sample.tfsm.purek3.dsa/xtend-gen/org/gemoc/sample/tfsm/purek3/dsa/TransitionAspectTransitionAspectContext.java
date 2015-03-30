package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.Transition;
import org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectProperties;

@SuppressWarnings("all")
public class TransitionAspectTransitionAspectContext {
  public final static TransitionAspectTransitionAspectContext INSTANCE = new TransitionAspectTransitionAspectContext();
  
  public static TransitionAspectTransitionAspectProperties getSelf(final Transition _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Transition, TransitionAspectTransitionAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.Transition, org.gemoc.sample.tfsm.purek3.dsa.TransitionAspectTransitionAspectProperties>();
  
  public Map<Transition, TransitionAspectTransitionAspectProperties> getMap() {
    return map;
  }
}
