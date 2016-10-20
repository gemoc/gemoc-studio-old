package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;

@SuppressWarnings("all")
public class TemporalGuardAspectTemporalGuardAspectContext {
  public final static TemporalGuardAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardAspectTemporalGuardAspectContext();
  
  public static TemporalGuardAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
