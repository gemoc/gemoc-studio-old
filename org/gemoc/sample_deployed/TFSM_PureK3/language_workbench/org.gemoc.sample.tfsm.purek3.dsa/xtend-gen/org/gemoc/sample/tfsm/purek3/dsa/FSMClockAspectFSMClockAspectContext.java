package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.FSMClock;
import org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectProperties;

@SuppressWarnings("all")
public class FSMClockAspectFSMClockAspectContext {
  public final static FSMClockAspectFSMClockAspectContext INSTANCE = new FSMClockAspectFSMClockAspectContext();
  
  public static FSMClockAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockAspectFSMClockAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.FSMClock, org.gemoc.sample.tfsm.purek3.dsa.FSMClockAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
