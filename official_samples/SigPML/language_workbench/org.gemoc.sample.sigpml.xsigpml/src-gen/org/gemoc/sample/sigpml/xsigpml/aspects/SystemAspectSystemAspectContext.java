package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;
import org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties;

@SuppressWarnings("all")
public class SystemAspectSystemAspectContext {
  public final static SystemAspectSystemAspectContext INSTANCE = new SystemAspectSystemAspectContext();
  
  public static SystemAspectSystemAspectProperties getSelf(final org.gemoc.sample.sigpml.xsigpml.sigpml.System _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<org.gemoc.sample.sigpml.xsigpml.sigpml.System, SystemAspectSystemAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.System, org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspectSystemAspectProperties>();
  
  public Map<org.gemoc.sample.sigpml.xsigpml.sigpml.System, SystemAspectSystemAspectProperties> getMap() {
    return map;
  }
}
