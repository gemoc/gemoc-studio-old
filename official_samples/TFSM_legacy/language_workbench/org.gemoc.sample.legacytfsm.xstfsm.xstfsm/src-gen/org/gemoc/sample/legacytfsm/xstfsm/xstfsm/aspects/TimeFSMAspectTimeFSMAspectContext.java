package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties;

@SuppressWarnings("all")
public class TimeFSMAspectTimeFSMAspectContext {
  public final static TimeFSMAspectTimeFSMAspectContext INSTANCE = new TimeFSMAspectTimeFSMAspectContext();
  
  public static TimeFSMAspectTimeFSMAspectProperties getSelf(final TimeFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimeFSM, TimeFSMAspectTimeFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimeFSM, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimeFSMAspectTimeFSMAspectProperties>();
  
  public Map<TimeFSM, TimeFSMAspectTimeFSMAspectProperties> getMap() {
    return map;
  }
}
