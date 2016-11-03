package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties;

@SuppressWarnings("all")
public class TimeFSMVisitorAspectTimeFSMAspectContext {
  public final static TimeFSMVisitorAspectTimeFSMAspectContext INSTANCE = new TimeFSMVisitorAspectTimeFSMAspectContext();
  
  public static TimeFSMVisitorAspectTimeFSMAspectProperties getSelf(final TimeFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimeFSM, TimeFSMVisitorAspectTimeFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties>();
  
  public Map<TimeFSM, TimeFSMVisitorAspectTimeFSMAspectProperties> getMap() {
    return map;
  }
}
