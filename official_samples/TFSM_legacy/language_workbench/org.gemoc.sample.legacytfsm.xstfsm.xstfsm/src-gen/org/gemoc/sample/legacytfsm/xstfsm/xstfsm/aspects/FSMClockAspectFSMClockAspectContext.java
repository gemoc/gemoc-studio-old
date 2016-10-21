package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockAspectFSMClockAspectProperties;

@SuppressWarnings("all")
public class FSMClockAspectFSMClockAspectContext {
  public final static FSMClockAspectFSMClockAspectContext INSTANCE = new FSMClockAspectFSMClockAspectContext();
  
  public static FSMClockAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
