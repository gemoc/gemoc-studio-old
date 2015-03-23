package org.gemoc.sample.tfsm.purek3.dsa;

import java.util.Map;
import org.gemoc.sample.tfsm.TFSM;
import org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectProperties;

@SuppressWarnings("all")
public class TFSMAspectTFSMAspectContext {
  public final static TFSMAspectTFSMAspectContext INSTANCE = new TFSMAspectTFSMAspectContext();
  
  public static TFSMAspectTFSMAspectProperties getSelf(final TFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TFSM, TFSMAspectTFSMAspectProperties> map = new java.util.HashMap<org.gemoc.sample.tfsm.TFSM, org.gemoc.sample.tfsm.purek3.dsa.TFSMAspectTFSMAspectProperties>();
  
  public Map<TFSM, TFSMAspectTFSMAspectProperties> getMap() {
    return map;
  }
}
