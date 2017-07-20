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
package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWCommunicationResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.OutputPort;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Place;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlFactory;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage;

@SuppressWarnings("all")
public class SigpmlFactoryAdapter extends EFactoryImpl implements SigpmlFactory {
  private XSigPMLMTAdaptersFactory adaptersFactory = org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory.getInstance();
  
  private org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlFactory sigpmlAdaptee = org.gemoc.sample.sigpml.xsigpml.sigpml.SigpmlFactory.eINSTANCE;
  
  @Override
  public Application createApplication() {
    return adaptersFactory.createApplicationAdapter(sigpmlAdaptee.createApplication(), null);
  }
  
  @Override
  public Agent createAgent() {
    return adaptersFactory.createAgentAdapter(sigpmlAdaptee.createAgent(), null);
  }
  
  @Override
  public InputPort createInputPort() {
    return adaptersFactory.createInputPortAdapter(sigpmlAdaptee.createInputPort(), null);
  }
  
  @Override
  public OutputPort createOutputPort() {
    return adaptersFactory.createOutputPortAdapter(sigpmlAdaptee.createOutputPort(), null);
  }
  
  @Override
  public Place createPlace() {
    return adaptersFactory.createPlaceAdapter(sigpmlAdaptee.createPlace(), null);
  }
  
  @Override
  public HWComputationalResource createHWComputationalResource() {
    return adaptersFactory.createHWComputationalResourceAdapter(sigpmlAdaptee.createHWComputationalResource(), null);
  }
  
  @Override
  public HWStorageResource createHWStorageResource() {
    return adaptersFactory.createHWStorageResourceAdapter(sigpmlAdaptee.createHWStorageResource(), null);
  }
  
  @Override
  public HWCommunicationResource createHWCommunicationResource() {
    return adaptersFactory.createHWCommunicationResourceAdapter(sigpmlAdaptee.createHWCommunicationResource(), null);
  }
  
  @Override
  public HWPlatform createHWPlatform() {
    return adaptersFactory.createHWPlatformAdapter(sigpmlAdaptee.createHWPlatform(), null);
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System createSystem() {
    return adaptersFactory.createSystemAdapter(sigpmlAdaptee.createSystem(), null);
  }
  
  @Override
  public EPackage getEPackage() {
    return getSigpmlPackage();
  }
  
  public SigpmlPackage getSigpmlPackage() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE;
  }
}
