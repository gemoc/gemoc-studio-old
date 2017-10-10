package org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.sigpml;

import fr.inria.diverse.melange.adapters.EObjectAdapter;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.gemoc.sample.sigpml.xsigpml.adapters.xsigpmlmt.XSigPMLMTAdaptersFactory;
import org.gemoc.sample.sigpml.xsigpml.sigpml.Application;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Agent;
import org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Place;

@SuppressWarnings("all")
public class ApplicationAdapter extends EObjectAdapter<Application> implements org.gemoc.sample.sigpml.xsigpmlmt.sigpml.Application {
  private XSigPMLMTAdaptersFactory adaptersFactory;
  
  public ApplicationAdapter() {
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
  
  private EList<Agent> ownedAgents_;
  
  @Override
  public EList<Agent> getOwnedAgents() {
    if (ownedAgents_ == null)
    	ownedAgents_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedAgents(), adaptersFactory, eResource);
    return ownedAgents_;
  }
  
  private EList<Place> ownedPlaces_;
  
  @Override
  public EList<Place> getOwnedPlaces() {
    if (ownedPlaces_ == null)
    	ownedPlaces_ = fr.inria.diverse.melange.adapters.EListAdapter.newInstance(adaptee.getOwnedPlaces(), adaptersFactory, eResource);
    return ownedPlaces_;
  }
  
  @Override
  public org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System getSystem() {
    return (org.gemoc.sample.sigpml.xsigpmlmt.sigpml.System) adaptersFactory.createAdapter(org.gemoc.sample.sigpml.xsigpml.aspects.NamedElementAspect.getSystem(adaptee), eResource);
  }
  
  protected final static String NAME_EDEFAULT = null;
  
  @Override
  public EClass eClass() {
    return org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.eINSTANCE.getApplication();
  }
  
  @Override
  public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__NAME:
    		return getName();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_AGENTS:
    		return getOwnedAgents();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_PLACES:
    		return getOwnedPlaces();
    }
    
    return super.eGet(featureID, resolve, coreType);
  }
  
  @Override
  public boolean eIsSet(final int featureID) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__NAME:
    		return getName() != NAME_EDEFAULT;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_AGENTS:
    		return getOwnedAgents() != null && !getOwnedAgents().isEmpty();
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_PLACES:
    		return getOwnedPlaces() != null && !getOwnedPlaces().isEmpty();
    }
    
    return super.eIsSet(featureID);
  }
  
  @Override
  public void eSet(final int featureID, final Object newValue) {
    switch (featureID) {
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__NAME:
    		setName(
    		(java.lang.String)
    		 newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_AGENTS:
    		getOwnedAgents().clear();
    		getOwnedAgents().addAll((Collection) newValue);
    		return;
    	case org.gemoc.sample.sigpml.xsigpmlmt.sigpml.SigpmlPackage.APPLICATION__OWNED_PLACES:
    		getOwnedPlaces().clear();
    		getOwnedPlaces().addAll((Collection) newValue);
    		return;
    }
    
    super.eSet(featureID, newValue);
  }
}
