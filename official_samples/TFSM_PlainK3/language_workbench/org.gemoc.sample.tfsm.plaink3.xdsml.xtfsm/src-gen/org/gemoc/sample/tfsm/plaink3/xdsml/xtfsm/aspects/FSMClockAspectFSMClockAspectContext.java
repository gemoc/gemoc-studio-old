package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock;

@SuppressWarnings("all")
public class FSMClockAspectFSMClockAspectContext {
  public final static FSMClockAspectFSMClockAspectContext INSTANCE = new FSMClockAspectFSMClockAspectContext();
  
  public static FSMClockAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.FSMClock, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
