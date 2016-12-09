package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties;

@SuppressWarnings("all")
public class EventGuardVisitorAspectEventGuardAspectContext {
  public final static EventGuardVisitorAspectEventGuardAspectContext INSTANCE = new EventGuardVisitorAspectEventGuardAspectContext();
  
  public static EventGuardVisitorAspectEventGuardAspectProperties getSelf(final EventGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.EventGuard, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.EventGuardVisitorAspectEventGuardAspectProperties>();
  
  public Map<EventGuard, EventGuardVisitorAspectEventGuardAspectProperties> getMap() {
    return map;
  }
}
