package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TimedSystem;

@SuppressWarnings("all")
public class TimedSystemAspectTimedSystemAspectContext {
  public final static TimedSystemAspectTimedSystemAspectContext INSTANCE = new TimedSystemAspectTimedSystemAspectContext();
  
  public static TimedSystemAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.TimedSystemAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.TimedSystem, org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.TimedSystemAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
