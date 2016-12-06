package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem;

@SuppressWarnings("all")
public class TimedSystemVisitorAspectTimedSystemAspectContext {
  public final static TimedSystemVisitorAspectTimedSystemAspectContext INSTANCE = new TimedSystemVisitorAspectTimedSystemAspectContext();
  
  public static TimedSystemVisitorAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TimedSystem, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TimedSystemVisitorAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemVisitorAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
