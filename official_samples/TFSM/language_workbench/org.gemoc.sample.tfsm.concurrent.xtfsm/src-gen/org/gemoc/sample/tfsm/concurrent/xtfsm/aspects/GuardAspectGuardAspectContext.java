package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspectGuardAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Guard;

@SuppressWarnings("all")
public class GuardAspectGuardAspectContext {
  public final static GuardAspectGuardAspectContext INSTANCE = new GuardAspectGuardAspectContext();
  
  public static GuardAspectGuardAspectProperties getSelf(final Guard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspectGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Guard, GuardAspectGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.Guard, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.GuardAspectGuardAspectProperties>();
  
  public Map<Guard, GuardAspectGuardAspectProperties> getMap() {
    return map;
  }
}
