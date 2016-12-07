package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspectTimeFSMAspectProperties;

@SuppressWarnings("all")
public class TimeFSMAspectTimeFSMAspectContext {
  public final static TimeFSMAspectTimeFSMAspectContext INSTANCE = new TimeFSMAspectTimeFSMAspectContext();
  
  public static TimeFSMAspectTimeFSMAspectProperties getSelf(final TimeFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspectTimeFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimeFSM, TimeFSMAspectTimeFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMAspectTimeFSMAspectProperties>();
  
  public Map<TimeFSM, TimeFSMAspectTimeFSMAspectProperties> getMap() {
    return map;
  }
}
