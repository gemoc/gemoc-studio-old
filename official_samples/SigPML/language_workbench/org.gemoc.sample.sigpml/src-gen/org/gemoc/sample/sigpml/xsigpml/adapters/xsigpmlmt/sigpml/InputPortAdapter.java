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
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpml.sigpml.InputPort;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType;

@SuppressWarnings("all")
public class InputPortAdapter extends EObjectAdapter<InputPort> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.InputPort {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public InputPortAdapter() {
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
  public int getRate() {
    return adaptee.getRate();
  }
  
  @Override
  public void setRate(final int o) {
    adaptee.setRate(o);
  }
  
  @Override
  public int getByteRate() {
    return adaptee.getByteRate();
  }
  
  @Override
  public void setByteRate(final int o) {
    adaptee.setByteRate(o);
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
  public Agent getOwner() {
    return (Agent) adaptersFactory.createAdapter(adaptee.getOwner(), eResource);
  }
  
  @Override
  public void setOwner(final Agent o) {
    if (o != null)
    	adaptee.setOwner(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.AgentAdapter) o).getAdaptee());
    else adaptee.setOwner(null);
  }
  
  @Override
  public void logSizeToReadWhenNotZero() {
    org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect.logSizeToReadWhenNotZero(adaptee);
  }
  
  @Override
  public void logSizeToReadWhenZero() {
    org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect.logSizeToReadWhenZero(adaptee);
  }
  
  @Override
  public int read() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect.read(adaptee);
  }
  
  @Override
  public int getSizeToread() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect.sizeToread(adaptee);
  }
  
  @Override
  public void setSizeToread(final int sizeToread) {
    org.gemoc.sample.sigpml.xsigpml.aspects.InputPortAspect.sizeToread(adaptee, sizeToread
    );
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int RATE_EDEFAULT = 0;
  
  protected final static int BYTE_RATE_EDEFAULT = 0;
  
  protected final static sizeType TYPE_EDEFAULT = org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType.B;
  
  protected final static int SIZE_TOREAD_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getInputPort();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__RATE:
    		return new java.lang.Integer(getRate());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__BYTE_RATE:
    		return new java.lang.Integer(getByteRate());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__TYPE:
    		return getType();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__SIZE_TOREAD:
    		return new java.lang.Integer(getSizeToread());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__RATE:
    		return getRate() != RATE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__BYTE_RATE:
    		return getByteRate() != BYTE_RATE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__TYPE:
    		return getType() != TYPE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__SIZE_TOREAD:
    		return getSizeToread() != SIZE_TOREAD_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__RATE:
    		setRate(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__BYTE_RATE:
    		setByteRate(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__TYPE:
    		setType(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.INPUT_PORT__SIZE_TOREAD:
    		setSizeToread(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
