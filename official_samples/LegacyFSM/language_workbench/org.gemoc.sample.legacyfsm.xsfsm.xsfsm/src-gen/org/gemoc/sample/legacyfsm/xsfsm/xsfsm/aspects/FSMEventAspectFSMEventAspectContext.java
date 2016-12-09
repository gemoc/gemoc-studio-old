package org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects;

import java.util.Map;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent;
import org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMEventAspectFSMEventAspectProperties;

@SuppressWarnings("all")
public class FSMEventAspectFSMEventAspectContext {
  public final static FSMEventAspectFSMEventAspectContext INSTANCE = new FSMEventAspectFSMEventAspectContext();
  
  public static FSMEventAspectFSMEventAspectProperties getSelf(final FSMEvent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMEventAspectFSMEventAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.legacyfsm.xsfsm.xsfsm.fsm.FSMEvent, org.gemoc.sample.legacyfsm.xsfsm.xsfsm.aspects.FSMEventAspectFSMEventAspectProperties>();
  
  public Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> getMap() {
    return map;
  }
}
