package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import sigpmlextended.OutputPort;
import org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectProperties;

@SuppressWarnings("all")
public class OutputPortAspectOutputPortAspectContext {
  public final static OutputPortAspectOutputPortAspectContext INSTANCE = new OutputPortAspectOutputPortAspectContext();
  
  public static OutputPortAspectOutputPortAspectProperties getSelf(final OutputPort _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<OutputPort, OutputPortAspectOutputPortAspectProperties> map = new java.util.HashMap<sigpmlextended.OutputPort, org.gemoc.sigpmlextended.k3dsa.OutputPortAspectOutputPortAspectProperties>();
  
  public Map<OutputPort, OutputPortAspectOutputPortAspectProperties> getMap() {
    return map;
  }
}
