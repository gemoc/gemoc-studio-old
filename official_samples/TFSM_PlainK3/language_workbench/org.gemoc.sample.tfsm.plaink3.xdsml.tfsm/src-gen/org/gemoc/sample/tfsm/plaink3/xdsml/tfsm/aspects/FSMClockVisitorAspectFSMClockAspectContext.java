package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock;

@SuppressWarnings("all")
public class FSMClockVisitorAspectFSMClockAspectContext {
  public final static FSMClockVisitorAspectFSMClockAspectContext INSTANCE = new FSMClockVisitorAspectFSMClockAspectContext();
  
  public static FSMClockVisitorAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMClock, org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMClockVisitorAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockVisitorAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
