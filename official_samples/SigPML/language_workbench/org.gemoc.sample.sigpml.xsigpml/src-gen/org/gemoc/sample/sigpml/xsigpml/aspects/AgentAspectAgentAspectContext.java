package org.gemoc.sample.sigpml.xsigpml.aspects;

import java.util.Map;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties;

@SuppressWarnings("all")
public class AgentAspectAgentAspectContext {
  public final static AgentAspectAgentAspectContext INSTANCE = new AgentAspectAgentAspectContext();
  
  public static AgentAspectAgentAspectProperties getSelf(final Agent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Agent, AgentAspectAgentAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.Agent, org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspectAgentAspectProperties>();
  
  public Map<Agent, AgentAspectAgentAspectProperties> getMap() {
    return map;
  }
}
