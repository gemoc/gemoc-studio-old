package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard;

@SuppressWarnings("all")
public class EventGuardVisitorAspectEventGuardAspectContext {
  public final static EventGuardVisitorAspectEventGuardAspectContext INSTANCE = new EventGuardVisitorAspectEventGuardAspectContext();
  
  public static EventGuardVisitorAspectEventGuardAspectProperties getSelf(final EventGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.sequential.xtfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.EventGuard, org.gemoc.sample.tfsm.sequential.xtfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties>();
  
  public Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> getMap() {
    return map;
  }
}
