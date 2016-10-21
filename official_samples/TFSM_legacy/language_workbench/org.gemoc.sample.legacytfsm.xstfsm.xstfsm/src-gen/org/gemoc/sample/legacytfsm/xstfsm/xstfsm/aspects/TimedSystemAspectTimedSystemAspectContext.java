package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;

@SuppressWarnings("all")
public class TimedSystemAspectTimedSystemAspectContext {
  public final static TimedSystemAspectTimedSystemAspectContext INSTANCE = new TimedSystemAspectTimedSystemAspectContext();
  
  public static TimedSystemAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedSystem, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedSystemAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
