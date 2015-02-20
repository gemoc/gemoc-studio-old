package org.gemoc.sigpmlextended.k3dsa;

import java.util.Map;
import sigpmlextended.Agent;
import org.gemoc.sigpmlextended.k3dsa.AgentAspectAgentAspectProperties;

@SuppressWarnings("all")
public class AgentAspectAgentAspectContext {
  public final static AgentAspectAgentAspectContext INSTANCE = new AgentAspectAgentAspectContext();
  
  public static AgentAspectAgentAspectProperties getSelf(final Agent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sigpmlextended.k3dsa.AgentAspectAgentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Agent, AgentAspectAgentAspectProperties> map = new java.util.HashMap<sigpmlextended.Agent, org.gemoc.sigpmlextended.k3dsa.AgentAspectAgentAspectProperties>();
  
  public Map<Agent, AgentAspectAgentAspectProperties> getMap() {
    return map;
  }
}
