package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties;

@SuppressWarnings("all")
public class FSMClockVisitorAspectFSMClockAspectContext {
  public final static FSMClockVisitorAspectFSMClockAspectContext INSTANCE = new FSMClockVisitorAspectFSMClockAspectContext();
  
  public static FSMClockVisitorAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
