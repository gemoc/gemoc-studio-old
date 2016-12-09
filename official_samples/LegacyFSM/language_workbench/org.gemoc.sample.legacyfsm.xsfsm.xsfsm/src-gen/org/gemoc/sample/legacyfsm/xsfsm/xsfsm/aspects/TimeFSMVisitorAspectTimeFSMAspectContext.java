package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties;

@SuppressWarnings("all")
public class TimeFSMVisitorAspectTimeFSMAspectContext {
  public final static TimeFSMVisitorAspectTimeFSMAspectContext INSTANCE = new TimeFSMVisitorAspectTimeFSMAspectContext();
  
  public static TimeFSMVisitorAspectTimeFSMAspectProperties getSelf(final TimeFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimeFSM, TimeFSMVisitorAspectTimeFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.TimeFSM, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.TimeFSMVisitorAspectTimeFSMAspectProperties>();
  
  public Map<TimeFSM, TimeFSMVisitorAspectTimeFSMAspectProperties> getMap() {
    return map;
  }
}
