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

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWStorageResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Place;

@SuppressWarnings("all")
public class HWStorageResourceAdapter extends EObjectAdapter<HWStorageResource> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWStorageResource {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public HWStorageResourceAdapter() {
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
  public HWPlatform getOwner() {
    return (HWPlatform) adaptersFactory.createAdapter(adaptee.getOwner(), eResource);
  }
  
  @Override
  public void setOwner(final HWPlatform o) {
    if (o != null)
    	adaptee.setOwner(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWPlatformAdapter) o).getAdaptee());
    else adaptee.setOwner(null);
  }
  
  private EList<HWRessource> connectedTo_;
  
  @Override
  public EList<HWRessource> getConnectedTo() {
    if (connectedTo_ == null)
    	connectedTo_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getConnectedTo(), adaptersFactory, eResource);
    return connectedTo_;
  }
  
  private EList<Place> allocatedPlaces_;
  
  @Override
  public EList<Place> getAllocatedPlaces() {
    if (allocatedPlaces_ == null)
    	allocatedPlaces_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getAllocatedPlaces(), adaptersFactory, eResource);
    return allocatedPlaces_;
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getHWStorageResource();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__CONNECTED_TO:
    		return getConnectedTo();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
    		return getAllocatedPlaces();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__CONNECTED_TO:
    		return getConnectedTo() != null && !getConnectedTo().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
    		return getAllocatedPlaces() != null && !getAllocatedPlaces().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__CONNECTED_TO:
    		getConnectedTo().clear();
    		getConnectedTo().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_STORAGE_RESOURCE__ALLOCATED_PLACES:
    		getAllocatedPlaces().clear();
    		getAllocatedPlaces().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
