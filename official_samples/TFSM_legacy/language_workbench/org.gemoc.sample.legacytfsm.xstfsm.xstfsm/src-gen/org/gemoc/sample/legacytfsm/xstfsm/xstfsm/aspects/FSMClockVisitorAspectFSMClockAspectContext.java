package org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock;
import org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties;

@SuppressWarnings("all")
public class FSMClockVisitorAspectFSMClockAspectContext {
  public final static FSMClockVisitorAspectFSMClockAspectContext INSTANCE = new FSMClockVisitorAspectFSMClockAspectContext();
  
  public static FSMClockVisitorAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacytfsm.xstfsm.xstfsm.tfsm.FSMClock, org.gemoc.sample.legacytfsm.xstfsm.xstfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
