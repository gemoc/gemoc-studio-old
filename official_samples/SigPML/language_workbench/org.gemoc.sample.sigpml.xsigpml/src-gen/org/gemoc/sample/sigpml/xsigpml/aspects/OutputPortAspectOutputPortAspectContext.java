/*******************************************************************************
 * Copyright (c) 2015, 2016  I3S Laboratory  and others.
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

import org.gemoc.sample.sigpml.xsigpml.sigpml.OutputPort;

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
