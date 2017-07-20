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
package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml;

import com.google.common.collect.LinkedListMultimap;
import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform;

@SuppressWarnings("all")
public class SystemAdapter extends EObjectAdapter<org.gemoc.sample.sigpml.xsigpml.sigpml.System> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public SystemAdapter() {
    super(org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory.getInstance());
    adaptersFactory = org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory.getInstance();
  }
  
  @Override
  public String getName() {
    return adaptee.getName();
  }
  
  @Override
  public void setName(final String o) {
    adaptee.setName(o);
  }
  
  @Override
  public Application getOwnedApplication() {
    return (Application) adaptersFactory.createAdapter(adaptee.getOwnedApplication(), eResource);
  }
  
  @Override
  public void setOwnedApplication(final Application o) {
    if (o != null)
    	adaptee.setOwnedApplication(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter) o).getAdaptee());
    else adaptee.setOwnedApplication(null);
  }
  
  @Override
  public HWPlatform getOwnedHWPlatform() {
    return (HWPlatform) adaptersFactory.createAdapter(adaptee.getOwnedHWPlatform(), eResource);
  }
  
  @Override
  public void setOwnedHWPlatform(final HWPlatform o) {
    if (o != null)
    	adaptee.setOwnedHWPlatform(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter) o).getAdaptee());
    else adaptee.setOwnedHWPlatform(null);
  }
  
  @Override
  public void initializeModel(final org.eclipse.emf.common.util.EList<java.lang.String> args) {
    org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspect.initializeModel(adaptee, args
    );
  }
  
  @Override
  public LinkedListMultimap getSharedMemory() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspect.sharedMemory(adaptee);
  }
  
  @Override
  public void setSharedMemory(final LinkedListMultimap sharedMemory) {
    org.gemoc.sample.sigpml.xsigpml.aspects.SystemAspect.sharedMemory(adaptee, sharedMemory
    );
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static LinkedListMultimap SHARED_MEMORY_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getSystem();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_APPLICATION:
    		return getOwnedApplication();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_HW_PLATFORM:
    		return getOwnedHWPlatform();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__SHARED_MEMORY:
    		return getSharedMemory();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_APPLICATION:
    		return getOwnedApplication() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_HW_PLATFORM:
    		return getOwnedHWPlatform() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__SHARED_MEMORY:
    		return getSharedMemory() != SHARED_MEMORY_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_APPLICATION:
    		setOwnedApplication(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__OWNED_HW_PLATFORM:
    		setOwnedHWPlatform(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.SYSTEM__SHARED_MEMORY:
    		setSharedMemory(
    		(com.google.common.collect.LinkedListMultimap)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
