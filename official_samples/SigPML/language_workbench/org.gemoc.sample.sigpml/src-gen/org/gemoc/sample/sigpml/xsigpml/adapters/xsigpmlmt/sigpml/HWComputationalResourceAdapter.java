package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpml.sigpml.HWComputationalResource;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWRessource;

@SuppressWarnings("all")
public class HWComputationalResourceAdapter extends EObjectAdapter<HWComputationalResource> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWComputationalResource {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public HWComputationalResourceAdapter() {
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
  public boolean isIsUnderPreemptiveManagement() {
    return adaptee.isIsUnderPreemptiveManagement();
  }
  
  @Override
  public void setIsUnderPreemptiveManagement(final boolean o) {
    adaptee.setIsUnderPreemptiveManagement(o);
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
  
  private EList<Agent> allocatedAgents_;
  
  @Override
  public EList<Agent> getAllocatedAgents() {
    if (allocatedAgents_ == null)
    	allocatedAgents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getAllocatedAgents(), adaptersFactory, eResource);
    return allocatedAgents_;
  }
  
  @Override
  public int getCurrentExecCycle() {
    return org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspect.currentExecCycle(adaptee);
  }
  
  @Override
  public void setCurrentExecCycle(final int currentExecCycle) {
    org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspect.currentExecCycle(adaptee, currentExecCycle
    );
  }
  
  @Override
  public void incCycle() {
    org.gemoc.sample.sigpml.xsigpml.aspects.HWComputationalResourceAspect.incCycle(adaptee);
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static boolean IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT = false;
  
  protected final static int CURRENT_EXEC_CYCLE_EDEFAULT = 0;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getHWComputationalResource();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO:
    		return getConnectedTo();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
    		return isIsUnderPreemptiveManagement() ? Boolean.TRUE : Boolean.FALSE;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
    		return getAllocatedAgents();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
    		return new java.lang.Integer(getCurrentExecCycle());
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO:
    		return getConnectedTo() != null && !getConnectedTo().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
    		return isIsUnderPreemptiveManagement() != IS_UNDER_PREEMPTIVE_MANAGEMENT_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
    		return getAllocatedAgents() != null && !getAllocatedAgents().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
    		return getCurrentExecCycle() != CURRENT_EXEC_CYCLE_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.HWPlatform)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CONNECTED_TO:
    		getConnectedTo().clear();
    		getConnectedTo().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__IS_UNDER_PREEMPTIVE_MANAGEMENT:
    		setIsUnderPreemptiveManagement(((java.lang.Boolean) newValue).booleanValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__ALLOCATED_AGENTS:
    		getAllocatedAgents().clear();
    		getAllocatedAgents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.HW_COMPUTATIONAL_RESOURCE__CURRENT_EXEC_CYCLE:
    		setCurrentExecCycle(((java.lang.Integer) newValue).intValue());
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
