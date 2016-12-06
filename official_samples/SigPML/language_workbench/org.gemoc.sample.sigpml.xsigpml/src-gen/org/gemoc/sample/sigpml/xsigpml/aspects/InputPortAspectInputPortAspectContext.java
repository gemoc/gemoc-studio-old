package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;

import org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort;

@SuppressWarnings("all")
public class InputPortAspectInputPortAspectContext {
  public final static InputPortAspectInputPortAspectContext INSTANCE = new InputPortAspectInputPortAspectContext();
  
  public static InputPortAspectInputPortAspectProperties getSelf(final InputPort _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspectInputPortAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<InputPort, InputPortAspectInputPortAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort, org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspectInputPortAspectProperties>();
  
  public Map<InputPort, InputPortAspectInputPortAspectProperties> getMap() {
    return map;
  }
}
