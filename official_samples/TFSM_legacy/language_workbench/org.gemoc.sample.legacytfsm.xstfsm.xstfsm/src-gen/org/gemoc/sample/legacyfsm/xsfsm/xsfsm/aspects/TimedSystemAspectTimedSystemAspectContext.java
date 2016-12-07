package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemAspectTimedSystemAspectProperties;

@SuppressWarnings("all")
public class TimedSystemAspectTimedSystemAspectContext {
  public final static TimedSystemAspectTimedSystemAspectContext INSTANCE = new TimedSystemAspectTimedSystemAspectContext();
  
  public static TimedSystemAspectTimedSystemAspectProperties getSelf(final TimedSystem _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemAspectTimedSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimedSystem, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimedSystemAspectTimedSystemAspectProperties>();
  
  public Map<TimedSystem, TimedSystemAspectTimedSystemAspectProperties> getMap() {
    return map;
  }
}
