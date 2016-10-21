package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties;

@SuppressWarnings("all")
public class GuardVisitorAspectGuardAspectContext {
  public final static GuardVisitorAspectGuardAspectContext INSTANCE = new GuardVisitorAspectGuardAspectContext();
  
  public static GuardVisitorAspectGuardAspectProperties getSelf(final Guard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Guard, GuardVisitorAspectGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.Guard, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.GuardVisitorAspectGuardAspectProperties>();
  
  public Map<Guard, GuardVisitorAspectGuardAspectProperties> getMap() {
    return map;
  }
}
