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
package org.gemoc.sample.tfsm.concurrent;

import fr.inria.diverse.melange.lib.IMetamodel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.gemoc.sample.tfsm.concurrent.XTfsmMT;

@SuppressWarnings("all")
public class XTfsm implements IMetamodel {
  private Resource resource;
  
  public Resource getResource() {
    return this.resource;
  }
  
  public void setResource(final Resource resource) {
    this.resource = resource;
  }
  
  public static XTfsm load(final String uri) {
    ResourceSet rs = new ResourceSetImpl();
    Resource res = rs.getResource(URI.createURI(uri), true);
    XTfsm mm = new XTfsm();
    mm.setResource(res);
    return mm ;
  }
  
  public XTfsmMT toXTfsmMT() {
    org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmAdapter adaptee = new org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmAdapter() ;
    adaptee.setAdaptee(resource);
    return adaptee;
  }
}
