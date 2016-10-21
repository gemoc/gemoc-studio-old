package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;

@SuppressWarnings("all")
public class EventGuardVisitorAspectEventGuardAspectContext {
  public final static EventGuardVisitorAspectEventGuardAspectContext INSTANCE = new EventGuardVisitorAspectEventGuardAspectContext();
  
  public static EventGuardVisitorAspectEventGuardAspectProperties getSelf(final EventGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.EventGuard, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties>();
  
  public Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> getMap() {
    return map;
  }
}
