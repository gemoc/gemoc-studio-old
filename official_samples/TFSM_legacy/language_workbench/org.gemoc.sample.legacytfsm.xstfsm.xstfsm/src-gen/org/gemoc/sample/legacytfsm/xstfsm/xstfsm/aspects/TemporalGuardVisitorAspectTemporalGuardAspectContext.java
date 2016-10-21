package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;

@SuppressWarnings("all")
public class TemporalGuardVisitorAspectTemporalGuardAspectContext {
  public final static TemporalGuardVisitorAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardVisitorAspectTemporalGuardAspectContext();
  
  public static TemporalGuardVisitorAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TemporalGuard, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
