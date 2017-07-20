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

import fr.inria.diverse.melange.resource.MelangeRegistry;
import fr.inria.diverse.melange.resource.MelangeRegistryImpl;
import fr.inria.diverse.melange.resource.MelangeResourceFactoryImpl;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

@SuppressWarnings("all")
public class StandaloneSetup {
  public static void doSetup() {
    StandaloneSetup setup = new StandaloneSetup();
    setup.doEMFRegistration();
    setup.doAdaptersRegistration();
  }
  
  public void doEMFRegistration() {
    EPackage.Registry.INSTANCE.put(
    	org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmPackage.eNS_URI,
    	org.gemoc.sample.tfsm.concurrent.xtfsm.tfsm.TfsmPackage.eINSTANCE
    );
    
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
    	"*",
    	new XMIResourceFactoryImpl()
    );
    Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put(
    	"melange",
    	new MelangeResourceFactoryImpl()
    );
  }
  
  public void doAdaptersRegistration() {
    MelangeRegistry.LanguageDescriptor xTfsm = new MelangeRegistryImpl.LanguageDescriptorImpl(
    	"org.gemoc.sample.tfsm.concurrent.XTfsm", "", "http://org.gemoc.sample.tfsm.concurrent.xtfsm/tfsm/", "org.gemoc.sample.tfsm.concurrent.XTfsmMT"
    );
    xTfsm.addAdapter("org.gemoc.sample.tfsm.concurrent.XTfsmMT", org.gemoc.sample.tfsm.concurrent.xtfsm.adapters.xtfsmmt.XTfsmAdapter.class);
    MelangeRegistry.INSTANCE.getLanguageMap().put(
    	"org.gemoc.sample.tfsm.concurrent.XTfsm",
    	xTfsm
    );
    MelangeRegistry.ModelTypeDescriptor xTfsmMT = new MelangeRegistryImpl.ModelTypeDescriptorImpl(
    	"org.gemoc.sample.tfsm.concurrent.XTfsmMT", "", "http://org.gemoc.sample.tfsm.concurrent.xtfsmmt/"
    );
    MelangeRegistry.INSTANCE.getModelTypeMap().put(
    	"org.gemoc.sample.tfsm.concurrent.XTfsmMT",
    	xTfsmMT
    );
  }
}
