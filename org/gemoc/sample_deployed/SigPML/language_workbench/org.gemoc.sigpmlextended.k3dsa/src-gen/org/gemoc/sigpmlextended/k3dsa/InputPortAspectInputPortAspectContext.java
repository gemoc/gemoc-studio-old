package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import sigpmlextended.InputPort;
import org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties;

@SuppressWarnings("all")
public class InputPortAspectInputPortAspectContext {
  public final static InputPortAspectInputPortAspectContext INSTANCE = new InputPortAspectInputPortAspectContext();
  
  public static InputPortAspectInputPortAspectProperties getSelf(final InputPort _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InputPort, InputPortAspectInputPortAspectProperties> map = new java.util.WeakHashMap<sigpmlextended.InputPort, org.gemoc.sigpmlextended.k3dsa.InputPortAspectInputPortAspectProperties>();
  
  public Map<InputPort, InputPortAspectInputPortAspectProperties> getMap() {
    return map;
  }
}
