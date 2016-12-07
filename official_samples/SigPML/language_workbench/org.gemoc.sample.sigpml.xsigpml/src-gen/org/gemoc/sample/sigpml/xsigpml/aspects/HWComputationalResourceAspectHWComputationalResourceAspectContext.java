package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;

import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;

@SuppressWarnings("all")
public class HWComputationalResourceAspectHWComputationalResourceAspectContext {
  public final static HWComputationalResourceAspectHWComputationalResourceAspectContext INSTANCE = new HWComputationalResourceAspectHWComputationalResourceAspectContext();
  
  public static HWComputationalResourceAspectHWComputationalResourceAspectProperties getSelf(final HWComputationalResource _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspectHWComputationalResourceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource, org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspectHWComputationalResourceAspectProperties>();
  
  public Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> getMap() {
    return map;
  }
}
