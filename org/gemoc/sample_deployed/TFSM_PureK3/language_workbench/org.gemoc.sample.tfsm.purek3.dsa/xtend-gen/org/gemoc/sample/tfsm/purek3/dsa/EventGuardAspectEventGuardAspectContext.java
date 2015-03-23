package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.EventGuard;
import org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspectEventGuardAspectProperties;

@SuppressWarnings("all")
public class EventGuardAspectEventGuardAspectContext {
  public final static EventGuardAspectEventGuardAspectContext INSTANCE = new EventGuardAspectEventGuardAspectContext();
  
  public static EventGuardAspectEventGuardAspectProperties getSelf(final EventGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspectEventGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EventGuard, EventGuardAspectEventGuardAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.EventGuard, org.gemoc.sample.tfsm.purek3.dsa.EventGuardAspectEventGuardAspectProperties>();
  
  public Map<EventGuard, EventGuardAspectEventGuardAspectProperties> getMap() {
    return map;
  }
}
