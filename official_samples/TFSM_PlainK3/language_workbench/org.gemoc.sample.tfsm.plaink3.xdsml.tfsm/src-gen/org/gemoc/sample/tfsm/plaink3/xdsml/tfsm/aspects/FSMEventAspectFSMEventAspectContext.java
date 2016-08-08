package org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent;

@SuppressWarnings("all")
public class FSMEventAspectFSMEventAspectContext {
  public final static FSMEventAspectFSMEventAspectContext INSTANCE = new FSMEventAspectFSMEventAspectContext();
  
  public static FSMEventAspectFSMEventAspectProperties getSelf(final FSMEvent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.tfsm_plaink3.FSMEvent, org.gemoc.sample.tfsm.plaink3.xdsml.tfsm.aspects.FSMEventAspectFSMEventAspectProperties>();
  
  public Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> getMap() {
    return map;
  }
}
