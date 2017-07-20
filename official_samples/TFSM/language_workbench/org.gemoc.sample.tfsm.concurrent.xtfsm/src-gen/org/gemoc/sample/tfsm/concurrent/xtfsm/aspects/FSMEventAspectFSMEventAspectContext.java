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
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent;

@SuppressWarnings("all")
public class FSMEventAspectFSMEventAspectContext {
  public final static FSMEventAspectFSMEventAspectContext INSTANCE = new FSMEventAspectFSMEventAspectContext();
  
  public static FSMEventAspectFSMEventAspectProperties getSelf(final FSMEvent _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.FSMEvent, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.FSMEventAspectFSMEventAspectProperties>();
  
  public Map<FSMEvent, FSMEventAspectFSMEventAspectProperties> getMap() {
    return map;
  }
}
