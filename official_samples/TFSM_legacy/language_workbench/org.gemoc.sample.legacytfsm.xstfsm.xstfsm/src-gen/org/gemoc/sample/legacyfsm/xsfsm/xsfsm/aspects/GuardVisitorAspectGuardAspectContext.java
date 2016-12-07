package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.GuardVisitorAspectGuardAspectProperties;

@SuppressWarnings("all")
public class GuardVisitorAspectGuardAspectContext {
  public final static GuardVisitorAspectGuardAspectContext INSTANCE = new GuardVisitorAspectGuardAspectContext();
  
  public static GuardVisitorAspectGuardAspectProperties getSelf(final Guard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.GuardVisitorAspectGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Guard, GuardVisitorAspectGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.Guard, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.GuardVisitorAspectGuardAspectProperties>();
  
  public Map<Guard, GuardVisitorAspectGuardAspectProperties> getMap() {
    return map;
  }
}
