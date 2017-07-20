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
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock;

@SuppressWarnings("all")
public class FSMClockAspectFSMClockAspectContext {
  public final static FSMClockAspectFSMClockAspectContext INSTANCE = new FSMClockAspectFSMClockAspectContext();
  
  public static FSMClockAspectFSMClockAspectProperties getSelf(final FSMClock _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMClock, FSMClockAspectFSMClockAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMClock, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMClockAspectFSMClockAspectProperties>();
  
  public Map<FSMClock, FSMClockAspectFSMClockAspectProperties> getMap() {
    return map;
  }
}
