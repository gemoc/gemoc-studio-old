package org.gemoc.sample.tfsm.sequential.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem;

@SuppressWarnings("all")
public class TimedSystemVisitorAspectTimedSystemAspectContext {
  public final static TimedSystemVisitorAspectTimedSystemAspectContext INSTANCE = new TimedSystemVisitorAspectTimedSystemAspectContext();
  
  public static TimedSystemVisitorAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.sequential.xtfsm.tfsm.TimedSystem, org.gemoc.sample.tfsm.sequential.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
