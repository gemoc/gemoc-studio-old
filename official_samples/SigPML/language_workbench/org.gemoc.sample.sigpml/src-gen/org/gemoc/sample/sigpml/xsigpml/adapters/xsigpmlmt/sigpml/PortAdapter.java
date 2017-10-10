package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Port;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType;

@SuppressWarnings("all")
public class PortAdapter extends EObjectAdapter<Port> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Port {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public PortAdapter() {
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
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  protected final static int RATE_EDEFAULT = 0;
  
  protected final static int BYTE_RATE_EDEFAULT = 0;
  
  protected final static sizeType TYPE_EDEFAULT = org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType.B;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getPort();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__OWNER:
    		return getOwner();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__RATE:
    		return new java.lang.Integer(getRate());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__BYTE_RATE:
    		return new java.lang.Integer(getByteRate());
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__TYPE:
    		return getType();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__OWNER:
    		return getOwner() != null;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__RATE:
    		return getRate() != RATE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__BYTE_RATE:
    		return getByteRate() != BYTE_RATE_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__TYPE:
    		return getType() != TYPE_EDEFAULT;
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__OWNER:
    		setOwner(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__RATE:
    		setRate(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__BYTE_RATE:
    		setByteRate(((java.lang.Integer) newValue).intValue());
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.PORT__TYPE:
    		setType(
    		(org.gemoc.sample.sigpml.xsigpmlmt.sigpml.sizeType)
    		 newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
