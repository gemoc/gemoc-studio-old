package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspectFSMClockAspectProperties;

@SuppressWarnings("all")
public class FSMClockAspectFSMClockAspectContext {
  public final static FSMClockAspectFSMClockAspectContext INSTANCE = new FSMClockAspectFSMClockAspectContext();
  
  public static FSMClockAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMClock, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMClockAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
