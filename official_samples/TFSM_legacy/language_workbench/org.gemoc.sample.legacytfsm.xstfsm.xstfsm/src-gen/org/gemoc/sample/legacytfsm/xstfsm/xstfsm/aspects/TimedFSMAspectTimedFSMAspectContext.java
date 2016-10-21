package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMAspectTimedFSMAspectProperties;

@SuppressWarnings("all")
public class TimedFSMAspectTimedFSMAspectContext {
  public final static TimedFSMAspectTimedFSMAspectContext INSTANCE = new TimedFSMAspectTimedFSMAspectContext();
  
  public static TimedFSMAspectTimedFSMAspectProperties getSelf(final TimedFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMAspectTimedFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TimedFSM, TimedFSMAspectTimedFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.TimedFSM, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.TimedFSMAspectTimedFSMAspectProperties>();
  
  public Map<TimedFSM, TimedFSMAspectTimedFSMAspectProperties> getMap() {
    return map;
  }
}
