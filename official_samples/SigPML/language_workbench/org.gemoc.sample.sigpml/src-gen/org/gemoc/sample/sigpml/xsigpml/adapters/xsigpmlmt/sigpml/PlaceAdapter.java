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
import org.gemoc.sample.sigpml.xsigpml.sigpml.Place;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.OutputPort;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType;

@SuppressWarnings("all")
public class PlaceAdapter extends EObjectAdapter<Place> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Place {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public PlaceAdapter() {
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
  public int getSize() {
    return adaptee.getSize();
  }
  
  @Override
  public void setSize(final int o) {
    adaptee.setSize(o);
  }
  
  @Override
  public sizeType getType() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType.get(adaptee.getType().getValue());
  }
  
  @Override
  public void setType(final sizeType o) {
    adaptee.setType(org.gemoc.sample.sigpml.xsigpml.sigpml.sizeType.get(o.getValue()));
  }
  
  @Override
  public int getByteSize() {
    return adaptee.getByteSize();
  }
  
  @Override
  public void setByteSize(final int o) {
    adaptee.setByteSize(o);
  }
  
  @Override
  public int getDelay() {
    return adaptee.getDelay();
  }
  
  @Override
  public void setDelay(final int o) {
    adaptee.setDelay(o);
  }
  
  @Override
  public OutputPort getItsOutputPort() {
    return (OutputPort) adaptersFactory.createAdapter(adaptee.getItsOutputPort(), eResource);
  }
  
  @Override
  public void setItsOutputPort(final OutputPort o) {
    if (o != null)
    	adaptee.setItsOutputPort(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.OutputPortAdapter) o).getAdaptee());
    else adaptee.setItsOutputPort(null);
  }
  
  @Override
  public InputPort getItsInputPort() {
    return (InputPort) adaptersFactory.createAdapter(adaptee.getItsInputPort(), eResource);
  }
  
  @Override
  public void setItsInputPort(final InputPort o) {
    if (o != null)
    	adaptee.setItsInputPort(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.InputPortAdapter) o).getAdaptee());
    else adaptee.setItsInputPort(null);
  }
  
  @Override
  public Application getOwner() {
    return (Application) adaptersFactory.createAdapter(adaptee.getOwner(), eResource);
  }
  
  @Override
  public void setOwner(final Application o) {
    if (o != null)
    	adaptee.setOwner(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.ApplicationAdapter) o).getAdaptee());
    else adaptee.setOwner(null);
  }
  
  @Override
  public int getCurrentSize() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.currentSize(adaptee);
  }
  
  @Override
  public void setCurrentSize(final int currentSize) {
    org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.currentSize(adaptee, currentSize
    );
  }
  
  @Override
  public EList<Object> getFifo() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.fifo(adaptee);
  }
  
  @Override
  public void initialize() {
    org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.initialize(adaptee);
  }
  
  @Override
  public boolean isIsInitialized() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.isInitialized(adaptee);
  }
  
  @Override
  public void setIsInitialized(final boolean isInitialized) {
    org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.isInitialized(adaptee, isInitialized
    );
  }
  
  @Override
  public void pop() {
    org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.pop(adaptee);
  }
  
  @Override
  public void push() {
    org.gemoc.sample.sigpml.xsigpml.aspects.PlaceAspect.push(adaptee);
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int SIZE_EDEFAULT = 0;
  
  protected final static sizeType TYPE_EDEFAULT = org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType.B;
  
  protected final static int BYTE_SIZE_EDEFAULT = 0;
  
  protected final static int DELAY_EDEFAULT = 0;
  
  protected final static int CURRENT_SIZE_EDEFAULT = 0;
  
  protected final static boolean IS_INITIALIZED_EDEFAULT = false;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getPlace();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
    		return getItsOutputPort();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_INPUT_PORT:
    		return getItsInputPort();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__SIZE:
    		return new java.lang.Integer(getSize());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__TYPE:
    		return getType();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__BYTE_SIZE:
    		return new java.lang.Integer(getByteSize());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__DELAY:
    		return new java.lang.Integer(getDelay());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__FIFO:
    		return getFifo();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__CURRENT_SIZE:
    		return new java.lang.Integer(getCurrentSize());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__IS_INITIALIZED:
    		return isIsInitialized() ? Boolean.TRUE : Boolean.FALSE;
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
    		return getItsOutputPort() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_INPUT_PORT:
    		return getItsInputPort() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__SIZE:
    		return getSize() != SIZE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__TYPE:
    		return getType() != TYPE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__BYTE_SIZE:
    		return getByteSize() != BYTE_SIZE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__DELAY:
    		return getDelay() != DELAY_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__FIFO:
    		return getFifo() != null && !getFifo().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__CURRENT_SIZE:
    		return getCurrentSize() != CURRENT_SIZE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__IS_INITIALIZED:
    		return isIsInitialized() != IS_INITIALIZED_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_OUTPUT_PORT:
    		setItsOutputPort(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.OutputPort)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__ITS_INPUT_PORT:
    		setItsInputPort(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__SIZE:
    		setSize(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__TYPE:
    		setType(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__BYTE_SIZE:
    		setByteSize(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__DELAY:
    		setDelay(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__FIFO:
    		getFifo().clear();
    		getFifo().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__CURRENT_SIZE:
    		setCurrentSize(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PLACE__IS_INITIALIZED:
    		setIsInitialized(((java.lang.Boolean) newValue).booleanValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
