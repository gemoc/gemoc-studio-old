/*******************************************************************************
 * Copyright (c) 2015, 2017  I3S Laboratory  and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     I3S Laboratory - initial API and implementation
 *******************************************************************************/
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
