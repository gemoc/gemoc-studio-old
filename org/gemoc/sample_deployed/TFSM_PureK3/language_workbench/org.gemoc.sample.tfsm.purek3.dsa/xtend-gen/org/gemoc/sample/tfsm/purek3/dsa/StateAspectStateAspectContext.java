package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.State;
import org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectProperties;

@SuppressWarnings("all")
public class StateAspectStateAspectContext {
  public final static StateAspectStateAspectContext INSTANCE = new StateAspectStateAspectContext();
  
  public static StateAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateAspectStateAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.State, org.gemoc.sample.tfsm.purek3.dsa.StateAspectStateAspectProperties>();
  
  public Map<State, StateAspectStateAspectProperties> getMap() {
    return map;
  }
}
