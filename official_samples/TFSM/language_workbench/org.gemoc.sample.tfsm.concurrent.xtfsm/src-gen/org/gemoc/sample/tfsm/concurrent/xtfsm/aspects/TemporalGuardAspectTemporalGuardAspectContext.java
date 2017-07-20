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
package org.gemoc.sample.tfsm.concurrent.xtfsm.aspects;

import java.util.Map;
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard;

@SuppressWarnings("all")
public class TemporalGuardAspectTemporalGuardAspectContext {
  public final static TemporalGuardAspectTemporalGuardAspectContext INSTANCE = new TemporalGuardAspectTemporalGuardAspectContext();
  
  public static TemporalGuardAspectTemporalGuardAspectProperties getSelf(final TemporalGuard _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TemporalGuard, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.TemporalGuardAspectTemporalGuardAspectProperties>();
  
  public Map<TemporalGuard, TemporalGuardAspectTemporalGuardAspectProperties> getMap() {
    return map;
  }
}
