package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.FSMEvent;
import org.gemoc.sample.tfsm.purek3.dsa.FSMEventAspectFSMEventAspectProperties;

@SuppressWarnings("all")
public class FSMEventAspectFSMEventAspectContext {
  public final static FSMEventAspectFSMEventAspectContext INSTANCE = new FSMEventAspectFSMEventAspectContext();
  
  public static FSMEventAspectFSMEventAspectProperties getSelf(final FSMEvent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.FSMEventAspectFSMEventAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.FSMEvent, org.gemoc.sample.tfsm.purek3.dsa.FSMEventAspectFSMEventAspectProperties>();
  
  public Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> getMap() {
    return map;
  }
}
