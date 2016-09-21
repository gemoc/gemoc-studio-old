package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;
import org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort;
import org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties;

@SuppressWarnings("all")
public class OutputPortAspectOutputPortAspectContext {
  public final static OutputPortAspectOutputPortAspectContext INSTANCE = new OutputPortAspectOutputPortAspectContext();
  
  public static OutputPortAspectOutputPortAspectProperties getSelf(final OutputPort _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OutputPort, OutputPortAspectOutputPortAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort, org.gemoc.sample.sigpml.xsigpml.aspects.OutputPortAspectOutputPortAspectProperties>();
  
  public Map<OutputPort, OutputPortAspectOutputPortAspectProperties> getMap() {
    return map;
  }
}
