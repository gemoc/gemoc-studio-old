package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard;

@SuppressWarnings("all")
public class TemporalGuardVisitorAspectTemporalGuardAspectContext {
  public final static TemporalGuardVisitorAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardVisitorAspectTemporalGuardAspectContext();
  
  public static TemporalGuardVisitorAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TemporalGuard, org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
