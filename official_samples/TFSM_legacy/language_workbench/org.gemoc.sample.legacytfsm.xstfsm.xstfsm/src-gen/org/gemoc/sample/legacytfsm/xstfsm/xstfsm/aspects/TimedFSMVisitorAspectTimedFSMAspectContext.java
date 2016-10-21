package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties;

@SuppressWarnings("all")
public class TimedFSMVisitorAspectTimedFSMAspectContext {
  public final static TimedFSMVisitorAspectTimedFSMAspectContext INSTANCE = new TimedFSMVisitorAspectTimedFSMAspectContext();
  
  public static TimedFSMVisitorAspectTimedFSMAspectProperties getSelf(final TimedFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedFSM, TimedFSMVisitorAspectTimedFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMVisitorAspectTimedFSMAspectProperties>();
  
  public Map<TimedFSM, TimedFSMVisitorAspectTimedFSMAspectProperties> getMap() {
    return map;
  }
}
