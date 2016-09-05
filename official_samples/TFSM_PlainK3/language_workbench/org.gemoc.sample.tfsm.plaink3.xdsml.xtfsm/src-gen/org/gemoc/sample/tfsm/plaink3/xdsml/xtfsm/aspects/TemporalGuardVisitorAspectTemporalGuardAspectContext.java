package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard;

@SuppressWarnings("all")
public class TemporalGuardVisitorAspectTemporalGuardAspectContext {
  public final static TemporalGuardVisitorAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardVisitorAspectTemporalGuardAspectContext();
  
  public static TemporalGuardVisitorAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TemporalGuard, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TemporalGuardVisitorAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardVisitorAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
