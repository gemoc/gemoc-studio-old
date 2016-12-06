package org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties;
import org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM;

@SuppressWarnings("all")
public class TFSMAspectTFSMAspectContext {
  public final static TFSMAspectTFSMAspectContext INSTANCE = new TFSMAspectTFSMAspectContext();
  
  public static TFSMAspectTFSMAspectProperties getSelf(final TFSM _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TFSM, TFSMAspectTFSMAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.tfsm_plaink3.TFSM, org.gemoc.sample.tfsm.plaink3.xdsml.xtfsm.aspects.TFSMAspectTFSMAspectProperties>();
  
  public Map<TFSM, TFSMAspectTFSMAspectProperties> getMap() {
    return map;
  }
}
