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
import org.gemoc.sample.sigpml.xsigpml.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Port;

@SuppressWarnings("all")
public class AgentAdapter extends EObjectAdapter<Agent> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public AgentAdapter() {
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
  public int getCycles() {
    return adaptee.getCycles();
  }
  
  @Override
  public void setCycles(final int o) {
    adaptee.setCycles(o);
  }
  
  @Override
  public String getCode() {
    return adaptee.getCode();
  }
  
  @Override
  public void setCode(final String o) {
    adaptee.setCode(o);
  }
  
  @Override
  public int getCurrentExecCycle() {
    return adaptee.getCurrentExecCycle();
  }
  
  @Override
  public void setCurrentExecCycle(final int o) {
    adaptee.setCurrentExecCycle(o);
  }
  
  private EList<Port> ownedPorts_;
  
  @Override
  public EList<Port> getOwnedPorts() {
    if (ownedPorts_ == null)
    	ownedPorts_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedPorts(), adaptersFactory, eResource);
    return ownedPorts_;
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
  public HWComputationalResource getAllocatedTo() {
    return (HWComputationalResource) adaptersFactory.createAdapter(adaptee.getAllocatedTo(), eResource);
  }
  
  @Override
  public void setAllocatedTo(final HWComputationalResource o) {
    if (o != null)
    	adaptee.setAllocatedTo(((org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml.HWComputationalResourceAdapter) o).getAdaptee());
    else adaptee.setAllocatedTo(null);
  }
  
  @Override
  public void execute() {
    org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspect.execute(adaptee);
  }
  
  @Override
  public boolean isIsCurrentlyExecuting() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspect.isCurrentlyExecuting(adaptee);
  }
  
  @Override
  public void setIsCurrentlyExecuting(final boolean isCurrentlyExecuting) {
    org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspect.isCurrentlyExecuting(adaptee, isCurrentlyExecuting
    );
  }
  
  @Override
  public void isExecuting() {
    org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspect.isExecuting(adaptee);
  }
  
  @Override
  public void stop() {
    org.gemoc.sample.sigpml.xsigpml.aspects.AgentAspect.stop(adaptee);
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int CYCLES_EDEFAULT = 0;
  
  protected final static String CODE_EDEFAULT = null;
  
  protected final static int CURRENT_EXEC_CYCLE_EDEFAULT = 0;
  
  protected final static boolean IS_CURRENTLY_EXECUTING_EDEFAULT = false;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getAgent();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNED_PORTS:
    		return getOwnedPorts();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CYCLES:
    		return new java.lang.Integer(getCycles());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CODE:
    		return getCode();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__ALLOCATED_TO:
    		return getAllocatedTo();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
    		return new java.lang.Integer(getCurrentExecCycle());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
    		return isIsCurrentlyExecuting() ? Boolean.TRUE : Boolean.FALSE;
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNED_PORTS:
    		return getOwnedPorts() != null && !getOwnedPorts().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CYCLES:
    		return getCycles() != CYCLES_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CODE:
    		return getCode() != CODE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__ALLOCATED_TO:
    		return getAllocatedTo() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
    		return getCurrentExecCycle() != CURRENT_EXEC_CYCLE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
    		return isIsCurrentlyExecuting() != IS_CURRENTLY_EXECUTING_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNED_PORTS:
    		getOwnedPorts().clear();
    		getOwnedPorts().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CYCLES:
    		setCycles(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CODE:
    		setCode(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__ALLOCATED_TO:
    		setAllocatedTo(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWComputationalResource)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__CURRENT_EXEC_CYCLE:
    		setCurrentExecCycle(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.AGENT__IS_CURRENTLY_EXECUTING:
    		setIsCurrentlyExecuting(((java.lang.Boolean) newValue).booleanValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
