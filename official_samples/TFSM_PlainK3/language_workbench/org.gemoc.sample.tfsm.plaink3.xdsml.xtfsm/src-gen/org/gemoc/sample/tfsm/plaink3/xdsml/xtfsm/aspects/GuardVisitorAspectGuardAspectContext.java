package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard;

@SuppressWarnings("all")
public class GuardVisitorAspectGuardAspectContext {
  public final static GuardVisitorAspectGuardAspectContext INSTANCE = new GuardVisitorAspectGuardAspectContext();
  
  public static GuardVisitorAspectGuardAspectProperties getSelf(final Guard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Guard, GuardVisitorAspectGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.Guard, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.GuardVisitorAspectGuardAspectProperties>();
  
  public Map<Guard, GuardVisitorAspectGuardAspectProperties> getMap() {
    return map;
  }
}
