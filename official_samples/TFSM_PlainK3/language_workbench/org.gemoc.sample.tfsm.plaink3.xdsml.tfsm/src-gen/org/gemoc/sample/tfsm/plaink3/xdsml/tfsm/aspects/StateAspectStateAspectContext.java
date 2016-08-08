package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.StateAspectStateAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.State;

@SuppressWarnings("all")
public class StateAspectStateAspectContext {
  public final static StateAspectStateAspectContext INSTANCE = new StateAspectStateAspectContext();
  
  public static StateAspectStateAspectProperties getSelf(final State _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.StateAspectStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<State, StateAspectStateAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.State, org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.StateAspectStateAspectProperties>();
  
  public Map<State, StateAspectStateAspectProperties> getMap() {
    return map;
  }
}
