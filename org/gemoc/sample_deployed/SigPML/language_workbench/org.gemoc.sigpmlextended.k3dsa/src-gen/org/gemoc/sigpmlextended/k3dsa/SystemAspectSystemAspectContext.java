package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties;

@SuppressWarnings("all")
public class SystemAspectSystemAspectContext {
  public final static SystemAspectSystemAspectContext INSTANCE = new SystemAspectSystemAspectContext();
  
  public static SystemAspectSystemAspectProperties getSelf(final sigpmlextended.System _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<sigpmlextended.System, SystemAspectSystemAspectProperties> map = new java.util.WeakHashMap<sigpmlextended.System, org.gemoc.sigpmlextended.k3dsa.SystemAspectSystemAspectProperties>();
  
  public Map<sigpmlextended.System, SystemAspectSystemAspectProperties> getMap() {
    return map;
  }
}
