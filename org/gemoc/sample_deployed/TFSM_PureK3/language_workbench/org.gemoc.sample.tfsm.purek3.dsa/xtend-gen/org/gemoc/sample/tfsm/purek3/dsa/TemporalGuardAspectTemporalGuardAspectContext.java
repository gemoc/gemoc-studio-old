package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.TemporalGuard;
import org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspectTemporalGuardAspectProperties;

@SuppressWarnings("all")
public class TemporalGuardAspectTemporalGuardAspectContext {
  public final static TemporalGuardAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardAspectTemporalGuardAspectContext();
  
  public static TemporalGuardAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.TemporalGuard, org.gemoc.sample.tfsm.purek3.dsa.TemporalGuardAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
