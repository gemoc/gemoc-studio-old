package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateVisitorAspectStateAspectProperties;

@SuppressWarnings("all")
public class StateVisitorAspectStateAspectContext {
  public final static StateVisitorAspectStateAspectContext INSTANCE = new StateVisitorAspectStateAspectContext();
  
  public static StateVisitorAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateVisitorAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateVisitorAspectStateAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.State, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.StateVisitorAspectStateAspectProperties>();
  
  public Map<State, StateVisitorAspectStateAspectProperties> getMap() {
    return map;
  }
}
