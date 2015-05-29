package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import sigpmlextended.HWComputationalResource;
import org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectProperties;

@SuppressWarnings("all")
public class HWComputationalResourceAspectHWComputationalResourceAspectContext {
  public final static HWComputationalResourceAspectHWComputationalResourceAspectContext INSTANCE = new HWComputationalResourceAspectHWComputationalResourceAspectContext();
  
  public static HWComputationalResourceAspectHWComputationalResourceAspectProperties getSelf(final HWComputationalResource _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> map = new java.util.WeakHashMap<sigpmlextended.HWComputationalResource, org.gemoc.sigpmlextended.k3dsa.HWComputationalResourceAspectHWComputationalResourceAspectProperties>();
  
  public Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> getMap() {
    return map;
  }
}
