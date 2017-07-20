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
import org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspectNamedElementAspectProperties;
import org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.NamedElement;

@SuppressWarnings("all")
public class NamedElementAspectNamedElementAspectContext {
  public final static NamedElementAspectNamedElementAspectContext INSTANCE = new NamedElementAspectNamedElementAspectContext();
  
  public static NamedElementAspectNamedElementAspectProperties getSelf(final NamedElement _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspectNamedElementAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<NamedElement, NamedElementAspectNamedElementAspectProperties> map = new java.util.WeakHashMap<org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.NamedElement, org.gemoc.sample.tfsm.concurrent.xtfsm.aspects.NamedElementAspectNamedElementAspectProperties>();
  
  public Map<NamedElement, NamedElementAspectNamedElementAspectProperties> getMap() {
    return map;
  }
}
