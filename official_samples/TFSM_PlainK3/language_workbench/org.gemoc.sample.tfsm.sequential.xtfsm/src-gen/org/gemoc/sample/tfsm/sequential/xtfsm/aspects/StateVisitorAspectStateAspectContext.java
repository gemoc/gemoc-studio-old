package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.StateVisitorAspectStateAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State;

@SuppressWarnings("all")
public class StateVisitorAspectStateAspectContext {
  public final static StateVisitorAspectStateAspectContext INSTANCE = new StateVisitorAspectStateAspectContext();
  
  public static StateVisitorAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.sequential.xtfsm.aspects.StateVisitorAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateVisitorAspectStateAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.State, org.gemoc.sample.tfsm.sequential.xtfsm.aspects.StateVisitorAspectStateAspectProperties>();
  
  public Map<State, StateVisitorAspectStateAspectProperties> getMap() {
    return map;
  }
}
