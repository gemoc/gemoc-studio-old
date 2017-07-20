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

import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;

@SuppressWarnings("all")
public class HWComputationalResourceAspectHWComputationalResourceAspectContext {
  public final static HWComputationalResourceAspectHWComputationalResourceAspectContext INSTANCE = new HWComputationalResourceAspectHWComputationalResourceAspectContext();
  
  public static HWComputationalResourceAspectHWComputationalResourceAspectProperties getSelf(final HWComputationalResource _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspectHWComputationalResourceAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource, org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspectHWComputationalResourceAspectProperties>();
  
  public Map<HWComputationalResource, HWComputationalResourceAspectHWComputationalResourceAspectProperties> getMap() {
    return map;
  }
}
