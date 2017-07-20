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

import org.eclipse.emf.common.util.EList;

@SuppressWarnings("all")
public class PlaceAspectPlaceAspectProperties {
  public EList<Object> fifo;
  
  public int currentSize = 0;
  
  public boolean isInitialized = false;
}
