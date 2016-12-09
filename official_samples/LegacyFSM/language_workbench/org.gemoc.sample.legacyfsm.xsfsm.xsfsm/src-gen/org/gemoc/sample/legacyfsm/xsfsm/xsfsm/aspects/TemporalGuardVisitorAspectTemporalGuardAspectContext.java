package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;

@SuppressWarnings("all")
public class TemporalGuardVisitorAspectTemporalGuardAspectContext {
  public final static TemporalGuardVisitorAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardVisitorAspectTemporalGuardAspectContext();
  
  public static TemporalGuardVisitorAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TemporalGuard, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
