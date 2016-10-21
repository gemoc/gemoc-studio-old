package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectProperties;

@SuppressWarnings("all")
public class StateVisitorAspectStateAspectContext {
  public final static StateVisitorAspectStateAspectContext INSTANCE = new StateVisitorAspectStateAspectContext();
  
  public static StateVisitorAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateVisitorAspectStateAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.State, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.StateVisitorAspectStateAspectProperties>();
  
  public Map<State, StateVisitorAspectStateAspectProperties> getMap() {
    return map;
  }
}
